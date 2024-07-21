package com.toxicant123.util;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-22 上午1:50
 */
@Slf4j
public class AesUtil {

    private static final String ALGORITHM = "AES";

    private static final int KEY_SIZE = 128;

    private static SecretKeySpec SECRET_KEY_SPEC;

    static {
        try {
            var keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(KEY_SIZE); // 可以是128, 192, 或 256位
            var secretKey = keyGenerator.generateKey();
            var keyBytes = secretKey.getEncoded();
            SECRET_KEY_SPEC = new SecretKeySpec(keyBytes, ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            log.error("NoSuchAlgorithmException - {}", ALGORITHM, e);
            System.exit(255);
        }
    }

    public static String encrypt(String text) {
        String result = null;
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, SECRET_KEY_SPEC);
            var encryptedBytes = cipher.doFinal(text.getBytes());
            result = Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (NoSuchAlgorithmException
                 | NoSuchPaddingException
                 | InvalidKeyException
                 | IllegalBlockSizeException
                 | BadPaddingException e) {
            log.error("AesUtil.encrypt error", e);
        }
        return result;
    }

    public static String decrypt(String ciphertext) {
        String result = null;
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, SECRET_KEY_SPEC);
            var decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
            result = new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException
                 | NoSuchPaddingException
                 | InvalidKeyException
                 | IllegalBlockSizeException
                 | BadPaddingException e) {
            log.error("AesUtil.decrypt error", e);
        }
        return result;
    }
}
