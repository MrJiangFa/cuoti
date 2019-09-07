package stringtest;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class APIMatch {
    public static void main(String[] args) {
//        System.out.println(Pattern.matches("\\d*(\\.)\\d+", ".."));
//        pattern1();
        System.out.println(Pattern.matches("\\\\d", "1"));
        System.out.println("" + '\\');
        Pattern pattern = Pattern.compile("(?<group0>a*)(?<group1>b*)");//在正则表达式中通过  ?<name> 的方式给分组命名
        String wait = "abbbbaaa";
        Matcher matcher = pattern.matcher(wait);
        matcher.find();
        System.out.println(matcher.group("group0"));
        System.out.println(matcher.group("group1"));
        System.out.println(wait.replaceAll("a+", "${jj}"));
        System.out.println(wait.replaceAll("a+", "$"));//非法的组引用，缺少组索引
        System.out.println(wait.replaceAll("a+", "\\"));//缺少要转义的字符
        System.out.println("${}");
        System.out.println("\\\ta");
        System.out.println("\\.");
        System.out.println("a\\{");
    }

    private static void pattern1() {
        //?:  意为采用非捕获组，更经济
        // ? 紧随* + ? {n} {n,m} 表示匹配模式是非贪心的
        Pattern pattern = Pattern.compile("^\\{\\{((?:\\.|\\r?\\n)+?)\\}}$");
        Matcher matcher = pattern.matcher("aa{{company}}bb{{cc}}");
        System.out.println(matcher.pattern() == pattern); //true
//        System.out.println(matcher.toString());
//        System.out.println(matcher.toMatchResult());

        Pattern pattern1 = Pattern.compile("b");
        Matcher matcher1 = pattern1.matcher("ccbaa");
        //find()：尝试寻找，每当find()
        while (matcher1.find()) {
            System.out.println("start:" + matcher1.start());
            System.out.println("end:" + matcher1.end());
            System.out.println("group:" + matcher1.group());
        }
    }

    private static void pattern2() {
        Pattern pattern = Pattern.compile("[a-z]+");
        System.out.println(pattern.matcher("").groupCount());
        String test = "ahdsf3h4254354";
        System.out.println(Arrays.toString(pattern.split(test)));
    }

    private static void pattern3() {
        Pattern pattern = Pattern.compile("\\.");
        System.out.println(pattern.pattern());
    }

    //将source中所有满足regx的字符串替换成replace
    private static String repalceByRegx(String source, String regx, String replace) {
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(source);
        matcher.reset();
        boolean result = matcher.find();
        if (result) {
            StringBuffer sb = new StringBuffer();
            do {
                appendReplacement(sb, replace);
                result = matcher.find();
            } while (result);
        }
        return source.replaceAll(regx, replace);
    }

    private static Matcher appendReplacement(StringBuffer sb, String replace) {
        int cursor = 0;
        StringBuilder result = new StringBuilder();
        while (cursor < replace.length()) {
            char nextChar = replace.charAt(cursor);
            //针对转移字符进行处理
            if (nextChar == '\\') {
                cursor++;
                if (cursor == replace.length()) {
                    throw new IllegalArgumentException("缺少需要转义的字符");
                }
                nextChar = replace.charAt(cursor);
                result.append(nextChar);
                cursor++;
            } else if (nextChar == '$') {
                cursor++;
                if (cursor == replace.length()) {
                    throw new IllegalArgumentException("illegal group reference: group index is missing");
                }
                nextChar = replace.charAt(cursor);
                int refNum = -1;


            }
        }
        return null;

    }
}
