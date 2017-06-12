package com.hebo.regular;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.MatchResult;

/**
 * Created by hebo on 2017/6/12.
 */
public class RepalceCallbackTest {
    @Test
    public void replace() throws Exception {
        final Map<String,String> props = new HashMap<String,String>();
        props.put("MY_NAME", "Kip");
        props.put("DEPT", "R&D");
        props.put("BOSS", "Dave");
        String subjectString = "Hi my name is ${MY_NAME} and I work in ${DEPT} for ${BOSS}";
        String sRegex = "\\$\\{([A-Za-z0-9_]+)\\}";
        String a =  RepalceCallback.replace(sRegex, subjectString, new RepalceCallback.Callback() {
            @Override
            public String matchFound(MatchResult match) {
                String group1 = match.group(1);
                if(group1 != null && props.containsKey(group1))
                    return props.get(group1);
                return match.group();
            }
        });
        System.out.println(a);
    }

}