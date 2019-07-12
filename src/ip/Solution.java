package ip;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//有效IP地址问题
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A", 0);
        hashMap.put("B", 0);
        hashMap.put("C", 0);
        hashMap.put("D", 0);
        hashMap.put("E", 0);
        hashMap.put("ERROR", 0);
        hashMap.put("P", 0);//私有的
        while (!sc.hasNext("exit")) {
            String tmp = sc.nextLine();
            String[] ss = tmp.split("~");
            String ip = ss[0];
            String mask = ss[1];
            if (!isValid(ip) || !isValid(mask) || !isValidMask(mask)) {
                hashMap.put("ERROR", hashMap.get("ERROR") + 1);
            } else {
                String[] firstIP = ip.trim().split("\\.");
                int firstOfIp = Integer.parseInt(firstIP[0]);
                int secondOfIp = Integer.parseInt(firstIP[1]);
                if (firstOfIp >= 1 && firstOfIp <= 126) {
                    if (firstOfIp == 10) {
                        hashMap.put("P", hashMap.get("P") + 1);
                    }
                    hashMap.put("A", hashMap.get("A") + 1);

                } else if (firstOfIp >= 128 && firstOfIp <= 191) {
                    if (firstOfIp == 172 && secondOfIp >= 16 && secondOfIp <= 31) {
                        hashMap.put("P", hashMap.get("P") + 1);
                    }
                    hashMap.put("B", hashMap.get("B") + 1);

                } else if (firstOfIp >= 192 && firstOfIp <= 223) {
                    if (firstOfIp == 192 && secondOfIp == 168) {
                        hashMap.put("P", hashMap.get("P") + 1);
                    }
                    hashMap.put("C", hashMap.get("C") + 1);

                } else if (firstOfIp >= 224 && firstOfIp <= 239) {
                    hashMap.put("D", hashMap.get("D") + 1);
                } else if (firstOfIp >= 240 && firstOfIp <= 255) {
                    hashMap.put("E", hashMap.get("E") + 1);
                }
            }
        }
        sc.close();
        System.out.printf("%d %d %d %d %d %d %d", hashMap.get("A"), hashMap.get("B"), hashMap.get("C"), hashMap.get("D"), hashMap.get("E"), hashMap.get("ERROR"), hashMap.get("P"));
    }

    public static boolean isValid(String ip) {
        if (ip == null || ip.length() == 0) {
            return false;
        }
        Pattern pattern = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$");//创建一个正则表达式，也可以说是创建一个匹配模式，够着方法私有不可以直接创建
        Matcher matcher = pattern.matcher(ip);
        if (matcher.matches()) {
            String[] arr = ip.trim().split("\\.");
            for (String s : arr) {
                int n = Integer.valueOf(s);
                if (n < 0 || n > 255) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidMask(String maskIP) {
        String res = "";
        String[] ss = maskIP.split("\\.");
        for (String s : ss) {
            res += binaryString(Integer.valueOf(s));
        }
        int indexOfFirstZero = res.indexOf('0');
        int indexOfLastOne = res.lastIndexOf('1');
        if (indexOfFirstZero < indexOfLastOne) {
            return false;
        }
        return true;
    }
    //将一个数字转化为8为二进制数
    public static String binaryString(int num) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index <= 7) {
            result.append((num & 1 << 7) == 0 ? 0 : 1);
            num <<= 1;
            index++;
        }
        return result.toString();
    }
}
