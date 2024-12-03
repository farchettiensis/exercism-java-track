class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder result = new StringBuilder();
        int length = identifier.length();
        for (int i = 0; i < length; i++) {
            char c = identifier.charAt(i);
            if (c == ' ') {
                result.append('_');
            } else if (c == '-') {
                if (i + 1 < length) {
                    i++;
                    char nextChar = identifier.charAt(i);
                    nextChar = convertLeetSpeak(nextChar);
                    if (Character.isLetter(nextChar)) {
                        result.append(Character.toUpperCase(nextChar));
                    }
                }
            } else {
                c = convertLeetSpeak(c);
                if (Character.isLetter(c)) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
    private static char convertLeetSpeak(char c) {
        return switch (c) {
            case '4' -> 'a';
            case '3' -> 'e';
            case '0' -> 'o';
            case '1' -> 'l';
            case '7' -> 't';
            default -> c;
        };
    }
}