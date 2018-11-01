package com.hebo.java.regular;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hebo on 2017/5/3. 泛型
 */
public class RepalceCallback {

    public static interface Callback {
        String matchFound(MatchResult match);
    }

    public static String replace(String pattern, String subject, Callback callback)
    {
        return replace(pattern, subject, -1, null, callback);
    }

    public static String replace(String pattern, String subject, int limit, Callback callback)
    {
        return replace(pattern, subject, limit, null, callback);
    }

    public static String replace(String regex, String subject, int limit,
                                 AtomicInteger count, Callback callback)
    {
        StringBuffer sb = new StringBuffer();
        Matcher matcher = Pattern.compile(regex).matcher(subject);
        int i;
        for(i = 0; (limit < 0 || i < limit) && matcher.find(); i++)
        {
            String replacement = callback.matchFound(matcher.toMatchResult());
            replacement = Matcher.quoteReplacement(replacement); //probably what you want...
            matcher.appendReplacement(sb, replacement);
        }
        matcher.appendTail(sb);

        if(count != null)
            count.set(i);
        return sb.toString();
    }
}
