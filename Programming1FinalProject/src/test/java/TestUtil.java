import org.example.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUtil {

    @Test
    public void testToTitleCase() {
        String str = "Hi There How Are You";
        String expectedResult = "Hi There How Are You";
        String result = Util.toTitleCase(str);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase2() {
        String str = "HI HOW ARE YOU";
        String expectedResult = "Hi How Are You";
        String result = Util.toTitleCase(str);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase3() {
        String str = "hi there";
        String expectedResult = "Hi There";
        String result = Util.toTitleCase(str);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase4() {
        String str = null;
        String expectedResult = null;
        String result = Util.toTitleCase(str);

        Assertions.assertEquals(expectedResult, result);
    }
}
