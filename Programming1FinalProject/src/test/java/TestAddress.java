import org.example.Address;
import org.junit.jupiter.api.Test;

import static org.example.Address.isPostalCodeValid;

public class TestAddress {

    @Test
    public void testIsPostalCodeValid() {
        String str = "H1D 2V2";
        boolean result = isPostalCodeValid(str);
        boolean expectedResult = true;
    }

    @Test
    public void testIsPostalCodeValid2() {
        String str = "H1D2V2";
        boolean result = isPostalCodeValid(str);
        boolean expectedResult = true;
    }

    @Test
    public void testIsPostalCodeValid3() {
        String str = "H1D 2VB";
        boolean result = isPostalCodeValid(str);
        boolean expectedResult = false;
    }

    @Test
    public void testIsPostalCodeValid4() {
        String str = "H1D2VB";
        boolean result = isPostalCodeValid(str);
        boolean expectedResult = false;
    }

    @Test
    public void testIsPostalCodeValid5() {
        String str = "HDD 2V2";
        boolean result = isPostalCodeValid(str);
        boolean expectedResult = false;
    }

    @Test
    public void testIsPostalCodeValid6() {
        String str = null;
        boolean result = isPostalCodeValid(str);
        boolean expectedResult = false;
    }
}
