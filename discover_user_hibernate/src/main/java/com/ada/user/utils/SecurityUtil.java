package com.ada.user.utils;


/**
 * 密码加盐工具
 * <p>
 * Created by ada on 2016/10/24.
 */
public class SecurityUtil {

    /**
     * 加密方法
     */
    public final static String HASH_ALGORITHM = "SHA-1";
    public final static int HASH_INTERATIONS = 1024;
    public final static int SALT_SIZE = 8; // 盐长度

    private byte[] salt;

    public SecurityUtil() {
        salt = Digests.generateSalt(SALT_SIZE);
    }

    public SecurityUtil(String salts) {
        salt = Encodes.decodeHex(salts);
    }

    /**
     * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
     */
    public String entryptPassword(String password) {
        byte[] hashPassword = Digests.sha1(password.getBytes(), salt, HASH_INTERATIONS);
        String result = Encodes.encodeHex(hashPassword);
        return result;
    }

    public String getSalt() {
        return Encodes.encodeHex(salt);
    }

    public boolean checkPassword(String password, String oldPassword) {
        byte[] hashPassword = Digests.sha1(oldPassword.getBytes(), salt, HASH_INTERATIONS);
        return password.equals(Encodes.encodeHex(hashPassword));
    }

    public static void main(String[] args) {
        SecurityUtil utils = new SecurityUtil();
        SecurityUtil utilsa = new SecurityUtil(utils.getSalt());
        System.out.println(utilsa.checkPassword(utils.entryptPassword("123456"), "1234567"));

        System.out.println(utils.getSalt());
        System.out.println(utils.entryptPassword("123"));
        System.out.println(utils.getSalt());

    }

}
