package com.hebo.java.ascci;

/**
 * @author bo.he@ttpai.cn
 */
public class AsciiToStr {

    public static void main(String[] args) throws Exception {
        String str = "0010503135523530334e3330305330325032383343323239343734303937425633373054363635483530304130";
        String b = hex2String(str);
        System.out.println(b);
        System.out.println(string2HexString(b));
    }


    /*
     * 字符转换为字节
     */
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /*
     * 16进制字符串转字节数组
     */
    public static byte[] hexString2Bytes(String hex) {

        if ((hex == null) || (hex.equals(""))) {
            return null;
        } else if (hex.length() % 2 != 0) {
            return null;
        } else {
            hex = hex.toUpperCase();
            int len = hex.length() / 2;
            byte[] b = new byte[len];
            char[] hc = hex.toCharArray();
            for (int i = 0; i < len; i++) {
                int p = 2 * i;
                b[i] = (byte) (charToByte(hc[p]) << 4 | charToByte(hc[p + 1]));
            }
            return b;
        }
    }

    /*
     * 16进制字符串转字符串
     */
    public static String hex2String(String hex) throws Exception {
        return bytes2String(hexString2Bytes(hex));
    }

    /*
     * 字节数组转字符串
     */
    public static String bytes2String(byte[] b) throws Exception {
        return new String(b, "UTF-8");
    }

    /*
     * 字节数组转16进制字符串
     */
    public static String bytes2HexString(byte[] b) {
        String r = "";

        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            r += hex.toUpperCase();
        }

        return r;
    }

    /*
     * 字符串转16进制字符串
     */
    public static String string2HexString(String s) throws Exception {
        return bytes2HexString(string2Bytes(s));
    }

    /*
     * 字符串转字节数组
     */
    public static byte[] string2Bytes(String s) {
        return s.getBytes();
    }
}
