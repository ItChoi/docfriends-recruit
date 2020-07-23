import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Algorithm {
    public static final void main(String[] args) {
        String q = "ab23c4d56e78f9g12h34i5j12k45l67n89m99o1k123p456q567r768s890t67u456v345w234x23y239z";
        String regEx = "\\d{1,}+";

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(q);

        List<Integer> list = new ArrayList<>();

        while (matcher.find()) {
            list.add(Integer.valueOf(matcher.group()));
        }

        Integer[] numbers = list.toArray(new Integer[list.size()]);

        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[minIndex] > numbers[i]) {
                minIndex = i;
            }

            if (numbers[maxIndex] < numbers[i]) {
                maxIndex = i;
            }
        }

        System.out.println("result: " + (minIndex + maxIndex));

    }
}
