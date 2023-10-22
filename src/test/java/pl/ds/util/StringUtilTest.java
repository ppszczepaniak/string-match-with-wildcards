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

    @ParameterizedTest
    @CsvSource(value = {
            "adcab, ab, true",
            "abcA, A, true",
            "' ', ' ', true",
            "' ', '  ', false",
            "'  ', '  ', true",
            "'  ', ' ', true",
            "'', a, false",
            "' abc', ' a', true",
            "' a bc', ' a', true",
            "'         a b c', ' ', true",
            "'abc ', 'c ', true",
            "'abc ', ' ', true",
            "'abc ', '  ', false",
            "a, a, true",
            "a, b, false",
            "a, ab, false",
            "b, ab, false",
            "ab, ab, true",
            "aba, aa, false",
            "axaxaxa, aa, false",
            "axaxaaxa, aa, true",
            "axaxaxaa, aa, true",
            "axaxaxaaaaa, aa, true",
            "axaxaxaxaxaaxaaxaaxaxa, aa, true",
            "ba, cba, false",
            "abcA, abc, true",
            "abcd, abcd, true",
            "abcabcabcabcd, abcd, true",
            "abcabcabcabcd, ca, true",
            "aaaaaaaaab, ab, true",
            "bbbbbb, ab, false",
            "aba, abc, false",
            "abc, abc, true",
            "babc, abc, true",
            "ababc, abc, true",
            "aabc, abc, true",
            "axabc, abc, true",
            "bababc, abc, true",
            "abababc, abc, true",
            "bbbababababc, abc, true",
            "abcd, abcde, false",
            "xyz, ab, false",
    }, nullValues = {"NULL"})
    void regularTests(String string, String pattern, boolean expected) {
        boolean result = StringUtil.contains(string, pattern);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "NULL, abc, false",
            "abc, null, false",
            "abc, NULL, false",
            "NULL, null, false",
            "null, NULL, false",
            "null, null, true",
            "null123, null, true",
            "123null123, null, true",
    }, nullValues = {"NULL"})
    void nullTests(String string, String pattern, boolean expected) {
        boolean result = StringUtil.contains(string, pattern);
        assertEquals(expected, result);
    }
}
