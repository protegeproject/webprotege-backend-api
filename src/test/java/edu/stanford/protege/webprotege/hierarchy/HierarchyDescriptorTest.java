package edu.stanford.protege.webprotege.hierarchy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class HierarchyDescriptorTest {

    @Autowired
    private JacksonTester<HierarchyDescriptor> tester;

    @Test
    void testSerializeClassHierarchyDescriptor() throws Exception {
        var classHierarchyDescriptor = ClassHierarchyDescriptor.create();

        var json = tester.write(classHierarchyDescriptor);

        assertThat(json).hasJsonPathStringValue("['@type']", "ClassHierarchyDescriptor");

        // Deserialize and assert it becomes the correct class
        var deserialized = tester.read(new StringReader(json.getJson()));
        assertThat(deserialized).isInstanceOf(ClassHierarchyDescriptor.class);
    }

    @Test
    void testSerializeObjectPropertyHierarchyDescriptor() throws Exception {
        var objectPropertyDescriptor = ObjectPropertyHierarchyDescriptor.create();
        var json = tester.write(objectPropertyDescriptor);

        assertThat(json).hasJsonPathStringValue("['@type']", "ObjectPropertyHierarchyDescriptor");

        // Deserialize and assert it becomes the correct class
        var deserialized = tester.read(new StringReader(json.getJson()));
        assertThat(deserialized).isInstanceOf(ObjectPropertyHierarchyDescriptor.class);
    }

    @Test
    void testSerializeDataPropertyHierarchyDescriptor() throws Exception {
        var dataPropertyDescriptor = DataPropertyHierarchyDescriptor.create();
        // Initialize the object with appropriate fields
        var json = tester.write(dataPropertyDescriptor);

        assertThat(json).hasJsonPathStringValue("['@type']", "DataPropertyHierarchyDescriptor");

        var deserialized = tester.read(new StringReader(json.getJson()));
        assertThat(deserialized).isInstanceOf(DataPropertyHierarchyDescriptor.class);
    }

    @Test
    void testSerializeAnnotationPropertyHierarchyDescriptor() throws Exception {
        var annotationPropertyDescriptor = AnnotationPropertyHierarchyDescriptor.create();
        var json = tester.write(annotationPropertyDescriptor);

        assertThat(json).hasJsonPathStringValue("['@type']", "AnnotationPropertyHierarchyDescriptor");

        // Deserialize and assert it becomes the correct class
        var deserialized = tester.read(new StringReader(json.getJson()));
        assertThat(deserialized).isInstanceOf(AnnotationPropertyHierarchyDescriptor.class);
    }

}