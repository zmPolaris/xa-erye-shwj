package cn.xa.eyre.common.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestTools {
    public static byte[] sha1(byte[]  content) throws NoSuchAlgorithmException, InvalidKeyException {
        return sha1(content, null);
    }

    public static byte[] sha1(byte[]  content, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
        if(key != null) {
            messageDigest.update(key.getBytes());
        }
        messageDigest.update(content);
        return messageDigest.digest();
    }

    public static byte[] sha256(byte[]  content) throws NoSuchAlgorithmException, InvalidKeyException {
        return sha256(content, null);
    }

    public static byte[] sha256(byte[]  content, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        if(key != null) {
            messageDigest.update(key.getBytes());
        }
        messageDigest.update(content);
        return messageDigest.digest();
    }

    public static byte[] hmacSha256(byte[]  content, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        return hmac(content, key, "HmacSHA256");
    }

    public static byte[] hmacSha1(byte[]  content, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        return hmac(content, key, "HmacSHA1");
    }

    public static byte[] hmac(byte[] content, String key, String algorithm) throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), algorithm);
        Mac mac = Mac.getInstance(algorithm);
        mac.init(signingKey);
        byte[] rawHmac = mac.doFinal(content);
        return rawHmac;
    }
}
