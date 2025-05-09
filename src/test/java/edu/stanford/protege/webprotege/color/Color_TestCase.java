package edu.stanford.protege.webprotege.color;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@ExtendWith(MockitoExtension.class)
public class Color_TestCase {

    private final int red = 255;

    private final int green = 10;

    private final int blue = 120;

    private Color color;

    @BeforeEach
    public void setUp() {
        color = Color.get(red, green, blue);
    }

    @Test
    public void shouldReturnSupplied_red() {
        assertThat(color.getRed(), is(this.red));
    }

    @Test
    public void shouldReturnSupplied_green() {
        assertThat(color.getGreen(), is(this.green));
    }

    @Test
    public void shouldReturnSupplied_blue() {
        assertThat(color.getBlue(), is(this.blue));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(color, is(color));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(color.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(color, is(Color.get(red, green, blue)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_red() {
        assertThat(color, is(not(Color.get(4, green, blue))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_green() {
        assertThat(color, is(not(Color.get(red, 5, blue))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_blue() {
        assertThat(color, is(not(Color.get(red, green, 6))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(color.hashCode(), is(Color.get(red, green, blue).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(color.toString(), Matchers.startsWith("Color"));
    }

    @Test
    public void should_getRGB() {
        assertThat(Color.getRGB(red, green, blue), is(color));
    }

    @Test
    public void should_getHex_From_String() {
        assertThat(Color.getHex("#ff0a78"), is(color));
    }

    @Test
    public void should_getHex_From_RGB_Strings() {
        assertThat(Color.getHex("ff", "0a", "78"), is(color));
    }

    @Test
    public void should_getHex() {
        assertThat(color.getHex(), is("#ff0a78"));
    }

    @Test
    public void should_getHSLColor() {
        Color c = Color.getHSL(0, 1, 0.5);
        assertThat(c.getRed(), is(255));
        assertThat(c.getGreen(), is(0));
        assertThat(c.getBlue(), is(0));
    }

}
