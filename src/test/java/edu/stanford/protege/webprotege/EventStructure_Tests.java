package edu.stanford.protege.webprotege;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-29
 */
public class EventStructure_Tests {

    private static final String CHANNEL = "CHANNEL";

    private List<Class<? extends Event>> eventClasses;

    @BeforeEach
    void setUp() {
        var urls = ClasspathHelper.forJavaClassPath();

        Reflections reflections = new Reflections(new ConfigurationBuilder().setUrls(urls)
                                                                            .setScanners(new SubTypesScanner()));
        eventClasses = reflections.getSubTypesOf(Event.class)
                                  .stream()
                                  .filter(cls -> !cls.isInterface())
                                  .collect(Collectors.toList());
    }

    @Test
    void shouldHaveChannelField() throws NoSuchFieldException {
        for (var event : eventClasses) {
            try {
                event.getField(CHANNEL);
            } catch (NoSuchFieldException e) {
                fail("CHANNEL field is missing from " + event.getName());
            }
        }
    }

    @Test
    void shouldHaveChannelNameThatIsNotSuffixedWithEvent() throws NoSuchFieldException, IllegalAccessException {
        for (var eventCls : eventClasses) {
            var channelNameField = eventCls.getField(CHANNEL);
            var channelName = (String) channelNameField.get(eventCls);
            assertThat(channelName.endsWith("Event")).isFalse();
        }
    }



    @Test
    void shoulHaveJsonTypeAnnotation() throws NoSuchFieldException {
        for (var eventCls : eventClasses) {
            var eventClsAnnotation = eventCls.getAnnotation(JsonTypeName.class);
            if(eventClsAnnotation == null) {
                fail("@JsonTypeName is missing on " + eventCls.getName());
            }
            var eventName = eventCls.getSimpleName();
            var expectedTypeNameSuffix =  "." + eventName.substring(0, eventName.length() - "Event".length());
            assertThat(eventClsAnnotation.value()).endsWith(expectedTypeNameSuffix);
        }
    }
}
