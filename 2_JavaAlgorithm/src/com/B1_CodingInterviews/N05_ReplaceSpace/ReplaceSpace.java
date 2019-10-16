package com.B1_CodingInterviews.N05_ReplaceSpace;

/**
 * 将字符串中出现的空格替换为 %20
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("I am string.");

        String string = repalceSpace(s);
        System.out.print(string);
    }

    public static String repalceSpace(StringBuffer stringBuffer) {
        int count = 0;
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (' ' == stringBuffer.charAt(i))
                count++;
        }
        int newLength = stringBuffer.length() + count * 2 - 1;
        int oldLength = stringBuffer.length() - 1;
        stringBuffer.setLength(newLength + 1);//设置新的长度

        while (oldLength >= 0 && newLength >= oldLength) {
            if (' ' == stringBuffer.charAt(oldLength)) {
                stringBuffer.setCharAt(newLength--, '0');
                stringBuffer.setCharAt(newLength--, '2');
                stringBuffer.setCharAt(newLength--, '%');
            } else {
                stringBuffer.setCharAt(newLength--, stringBuffer.charAt(oldLength));
            }
            oldLength--;
        }

        return stringBuffer.toString();
    }
}
