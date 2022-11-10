package homework.first.Task2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**
 * HashtagUtil class for checking and sorting List<String> by the most 5 popular hashtags inside
 */
public class HashtagUtil {


    /**
     * To find the most 5 popular hashTags in List of Strings
     * @param stringList - input List of Strings with hashTags
     * @return Map<String,Integer> with result
     */
    public static Map<String, Integer> countHashtag(List<String> stringList) {
        if (stringList == null || stringList.contains(null)){
            throw new NullPointerException("Null value is present");
        }
        Map<String, Integer> map = new HashMap<>();
        Pattern pattern = Pattern.compile("#(\\S+)");
        for (String string : stringList) {
            String temp = string.replaceAll("[-+_?,.!():;]*", "");
            Matcher matcher = pattern.matcher(temp);
            Set<String> uniqueWordSet = new HashSet<>();
            while (matcher.find()) {
                String hashTagKey = "#" + matcher.group(1).toLowerCase();
                if (!uniqueWordSet.contains(hashTagKey)) {
                    uniqueWordSet.add(hashTagKey);
                    if (!map.containsKey(hashTagKey)) {
                        map.put(hashTagKey, 1);
                    } else {
                        map.replace(hashTagKey, map.get(hashTagKey) + 1);
                    }
                }
            }
        }
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }
}
