package pl.ds.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilTest {

    @ParameterizedTest
    @CsvSource(value = {
            "NULL, *, false",
            "*, NULL, false",
            "'', '', true",
            "abc, '', true",
            "abc, a, true",
            "abc, a*, true",
            "a*c, a\\*, true",
            "a*c, abc, false",
            "abc, A, false",
            "abc, abcd, false",
            "abcd, bc, true",
    }, nullValues = {"NULL"})
    void originalTests(String string, String pattern, boolean expected) {
        boolean result = StringUtil.contains(string, pattern);
        assertEquals(expected, result);
    }
}
