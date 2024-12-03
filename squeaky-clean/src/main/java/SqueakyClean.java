import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqueakyClean {
    public static String clean(String identifier) {
        identifier = identifier.replaceAll("\\s", "_");

        Matcher matcher = Pattern.compile("-(\\w)").matcher(identifier);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        identifier = sb.toString();

        matcher = Pattern.compile("[43017]").matcher(identifier);
        sb = new StringBuilder();
        while (matcher.find()) {
            String replacement = switch (matcher.group()) {
                case "4" -> "a";
                case "3" -> "e";
                case "0" -> "o";
                case "1" -> "l";
                case "7" -> "t";
                default -> matcher.group();
            };
            matcher.appendReplacement(sb, replacement);
        }
        matcher.appendTail(sb);
        identifier = sb.toString();

        identifier = identifier.replaceAll("[^a-zA-Z_]", "");

        return identifier;
    }
}
