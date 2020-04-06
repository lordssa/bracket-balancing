import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class BalancedBrackets {

    public boolean isBalanced(String str) {
        if (!Objects.nonNull(str) || (str.length() % 2) != 0) {
            return false;
        } else {
            char[] chars = str.toCharArray();

            var accepted = List.of('{', '}', '[', ']', '(', ')');
            boolean valid = Stream.of(chars)
                    .anyMatch(Predicate.not(accepted::contains));

            if (!valid) {
                return false;
            }
        }

        while (str.contains("()") || str.contains("[]") || str.contains("{}")) {
            str = str.replaceAll("\\(\\)", "")
                    .replaceAll("\\[\\]", "")
                    .replaceAll("\\{\\}", "");
        }
        return str.isEmpty();
    }

}