package pl.ds.util;

public final class StringUtil {

    private StringUtil() {
        // no instances
    }

    /**
     * <p>Checks if a {@code string} contains a {@code pattern}.</p>
     *
     * <p>A pattern may contain single or multiple wildcard characters {@code *}.
     * Each occurrence of {@code *} in the {@code pattern} means that it can be a match for
     * zero or more characters of the {@code string}.</p>
     *
     * <p>Asterisk (*) is considered as a regular character, if it is preceded by a backslash (\)
     * in a pattern. Backslash (\) is considered as a regular character in all cases other
     * than preceding the asterisk (*).</p>
     *
     * <p>Examples:</p>
     * <pre>
     * StringUtils.contains(null, *) = false
     * StringUtils.contains(*, null) = false
     * StringUtils.contains("", "") = true
     * StringUtils.contains("abc", "") = true
     * StringUtils.contains("abc", "a") = true
     * StringUtils.contains("abc", "a*") = true
     * StringUtils.contains("a*c", "a\*") = true
     * StringUtils.contains("a*c", "abc") = false
     * StringUtils.contains("abc", "A") = false
     * StringUtils.contains("abc", "abcd") = false
     * </pre>
     *
     * @param string  string to check
     * @param pattern pattern to search in a string
     * @return true if the {@code string} contains a {@code pattern}, false otherwise.
     */
    public static boolean contains(String string, String pattern) {
        if (string == null || pattern == null) {
            return false;
        }

        int pIndex = pattern.length() - 1;
        int sIndex = string.length() - 1;
        boolean wildCardMode = false;
        boolean escapedMode = false;

        while (sIndex >= 0 && pIndex >= 0) {
            if (pattern.charAt(pIndex) == '*' && pIndex - 1 >= 0 && pattern.charAt(pIndex - 1) == '\\') {
                escapedMode = true;
            }

            if (!escapedMode && pattern.charAt(pIndex) == '*') {
                pIndex--;
                wildCardMode = true;
            } else if (string.charAt(sIndex) == pattern.charAt(pIndex)) {
                sIndex--;
                pIndex = escapedMode ? pIndex - 2 : pIndex - 1;
                wildCardMode = false;
                escapedMode = false;
            } else {
                sIndex--;
                pIndex = !wildCardMode ? pattern.length() - 1 : pIndex; //reset to the end of the pattern if not in a wildCardMode
            }
        }

        while (pIndex >= 0 && pattern.charAt(pIndex) == '*') { //if any of the leftover pattern isn't a wildcard, the string doesn't contain full pattern
            pIndex--;
        }

        return pIndex < 0;
    }

}
