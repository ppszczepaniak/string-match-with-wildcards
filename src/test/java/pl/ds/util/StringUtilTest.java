package pl.ds.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilTest {

    @Test
    void testIsSubstring() {
        assertEquals(true, StringUtil.contains("abcd", "bc"));
    }

}
