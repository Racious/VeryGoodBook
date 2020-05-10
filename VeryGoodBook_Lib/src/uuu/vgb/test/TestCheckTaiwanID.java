package uuu.vgb.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCheckTaiwanID {

    public static void main(String[] args) {
        String inputStr = "ABC\nABC\nABC";
        String patternStr = "(?d)ABC";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(inputStr);
        boolean matchFound = matcher.find();
        while (matchFound) {
            System.out.println(matcher.start() + "-" + matcher.end());
            for (int i = 0; i <= matcher.groupCount(); i++) {
                String groupStr = matcher.group(i);
                System.out.println(i + ":" + groupStr);
            }
            if (matcher.end() + 1 <= inputStr.length()) {
                matchFound = matcher.find(matcher.end());
            } else {
                break;
            }
        }
//        String id = "A123456789";
//        //檢查id格式(regular expression)必須符合[A-Z][12][0~9]{8}
//        
//        if (id.length() == 10) {
//            System.out.println("正確");
//        } else {
//            System.out.println("不正確");
//        }
//        String str = "41574"; 
//        String testString = "ABCaaabcaac";
//        System.out.println("str.contains():\t"+testString.contains("4"));

    }
}
