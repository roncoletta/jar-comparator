package com.roncoletta.comparator.file;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by roncoletta on 05/10/16.
 */

public class RegexUtil {
    public static boolean isMatch(String target, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(target);
        return matcher.find();
    }

    public static String getSubStringByRegex(String target, String regex) {
        String result = target;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(target);
        if (matcher.find()) {
            result = null;
            for (int i = 1; i <= matcher.groupCount() && result == null; i++) {
                result = matcher.group(i);
            }
        }
        return result;
    }
}
