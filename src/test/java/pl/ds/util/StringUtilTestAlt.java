package pl.ds.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilTestAlt {

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
        boolean result = StringUtilAlt.contains(string, pattern);
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
        boolean result = StringUtilAlt.contains(string, pattern);
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
        boolean result = StringUtilAlt.contains(string, pattern);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'', ****, true",
            "'', *, true",
            "*, '', true",
            "a, ****, true",
            "*, *, true",
            "abc, *, true",
            "abc, a*b*c*, true",
            "abc, a***b***c***, true",
            "abc, a***b***c, true",
            "abc, ab***c, true",
            "abc, **ab*c, true",
            "abc, *, true",
            "abc, ***, true",
            "abc, ********, true",
            "'   aasghdfgfTGBJHOghjkgfhjg2  !@#$%^& bc', *, true",
            "abcdefghijk, abcdefghijk*, true",
            "abcdefghijk, abcdefghijk*******, true",
            "abcdefghijk, *abcdefghijk*******, true",
            "abcdefghijk, *******abcdefghijk*******, true",
            "abcdefghij, *******abcdefghijk*******, false",
            "abcdefghijk, *******abcdefghij*******, true",
            "abcdeafghiajk, *******a*******, true",
            "abcdefghijk, '******* *******', false",
            "'abcd efghijk', '******* *******', true",
            "' ', '******* *******', true",
            "'       ', '******* *******', true",
            "'       a', '******* *******', true",
            "' a', '* *', true",
            "' a ', '* *', true",
            "'a ', '* *', true",
            "'       *', '******* *******', true",
            "'******* *******', '******* *******', true",
            "'* *', '******* *******', true",
            "'abc hijk', abc hijk*, true",
            "abcdefgh, *a*b*c*d*e*f*g*h*, true",
            "abcdefgh, *abcdefgh, true",
            "abcdefgh, a*bcdefgh, true",
            "a, a*bcdefgh, false",
            "bcdefgh, a*bcdefgh, false",
            "abcdefgh, abcd****efgh, true",
            "abcd#@E$R%T^&Y*()(*efgh, abcd****efgh, true",
            "bzxca, b*a, true",
            "bza, b*a, true",
            "ba, b*a, true",
            "ba, *a, true",
            "bbbbba, *a, true",
            "bbbbbaaaaa, *a, true",
            "baaaa, *a, true",
            "abcd#@E$R%T^&Y*()(*efgh, abcd*efgh, true",
            "abcd__________/efgh, abcd****efgh, true",
            "abcdefgh, abcdefgh*, true",
            "abcdefgh, abcdefgh****, true",
    }, nullValues = {"NULL"})
    void wildcardsTests(String string, String pattern, boolean expected) {
        boolean result = StringUtilAlt.contains(string, pattern);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "****, \\*\\*\\*\\*, true",
            "****, \\*\\*\\*\\**, true",
            "****%$$*&T*//\\\\////, \\*\\*\\*\\**, true",
            "****%$$*&T*//\\\\////, *\\*\\*\\*\\**, true",
            "!@#$%^&*****%$$*&T*//\\\\////, *\\*\\*\\*\\**, true",
            "'****%$$*&T*//\\\\////', *\\*\\*\\*\\**, true",
            "'    ****%$$*&T*//\\\\////', *\\*\\*\\*\\**, true",
            "'    ****%$$*&T*//\\\\////', *\\*\\*\\*\\*, true",
            "'****%$$*&T*//\\\\////', *\\*\\*\\*\\*, true",
            "'****%$$*&T*//\\\\////', *\\*\\*\\*\\**, true",
            "'    ****', *\\*\\*\\*\\*, true",
            "*, \\*, true",
            "/, \\*, false",
            "/*, \\*, true",
            "/*, /\\*, true",
            "*, /\\*, false",
            "/*, \\*\\*, false",
            "/*/, \\*\\*, false",
            "/*/*, \\*\\*, false",
            "/**, \\*\\*, true",
            "*/*, \\*\\*, false",
            "*/**, \\*\\*, true",
            "*a**b, \\*\\*b, true",
            "*a**a**b, \\*\\*b, true",
            "**/, \\*\\*, true",
            "**, \\*\\*, true",
            "**, \\*\\**, true",
            "**abwsd, \\*\\**, true",
            "abc*, \\*, true",
            "/*/*/*/*, \\*\\*\\*\\*, false",
            "\\*, \\*, true",
            "\\*a, \\*a, true",
            "\\*\\*\\*\\*, \\*\\*\\*\\*, false",
            "\\*\\*, \\*\\*, false",
            "*\\*, \\*\\*, false",
            "**********, \\*\\*\\*\\**, true",
            "*, \\*\\*\\*\\**, false",
            "*, \\, false",
            "\\, \\, true",
            "asd\\n, \\n, true", //special cases
            "\ta, \ta, true",
            "\ta, '\t a', false",
            "\\b, \\b, true",
            "asd\\b, asd\\b, true",
            "\\r, \\r, true",
            "aa\\r, aa\\r, true",
            "\\f, \\f, true",
            "aa\\f, aa\\f, true",
            "\\', \\', true",
            "aa\\', aa\\', true",
            "\\\", \\\", true",
            "aa\\\", aa\\\", true",
    }, nullValues = {"NULL"})
    void escapedCharsTests(String string, String pattern, boolean expected) {
        boolean result = StringUtilAlt.contains(string, pattern);
        assertEquals(expected, result);
    }
}
