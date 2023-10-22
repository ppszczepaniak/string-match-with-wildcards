package pl.ds.util;

public final class StringUtilAlt {

    private StringUtilAlt() {
    }

    public static boolean contains(String string, String pattern) {
        if (string == null || pattern == null) {
            return false;
        }

        int pIndex = 0;
        int sIndex = 0;
        boolean wildcardMode = false;
        boolean escapedMode = false;

        while (sIndex < string.length() && pIndex < pattern.length()) {
            if (pattern.charAt(pIndex) == '\\' && pIndex + 1 < pattern.length() && pattern.charAt(pIndex + 1) == '*') {
                pIndex++;
                escapedMode = true;
            }

            if (pattern.charAt(pIndex) == '*' && !escapedMode) {
                pIndex++;
                wildcardMode = true;
            } else if (string.charAt(sIndex) == pattern.charAt(pIndex)) {
                sIndex++;
                pIndex++;
                wildcardMode = false;
                escapedMode = false;
            } else {
                pIndex = !wildcardMode ? 0 : pIndex; //reset to beginning of the pattern if it's not a wildcardMode
                sIndex = (string.charAt(sIndex) == pattern.charAt(pIndex) && !escapedMode) ? //after reset, if there is a match AND it's not an escapeMode, don't raise the sIndex
                        sIndex :
                        sIndex + 1;
            }
        }
        return pattern.chars().skip(pIndex).allMatch(ch -> ch == '*');    //if there's any pattern left which isn't a wildcard, the string doesn't contain full pattern; empty stream (no pattern left) results in true

//        //ALTERNATIVE if IntStream.allMatch() is not allowed
//        while (pIndex < pattern.length() && pattern.charAt(pIndex) == '*') {
//            pIndex++;
//        }
//        return pIndex == pattern.length();
    }

}


