package com.toxicant123.util;

import com.toxicant123.enums.ErrorCodeAndUserMessageEnum;
import com.toxicant123.exception.unchecked.LoginException;
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
public class LoginAesUtils {

    private static final String ALGORITHM = "AES";

    private static final int KEY_SIZE = 128;

    private static final SecretKeySpec SECRET_KEY_SPEC;

    static {
        try {
            var keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(KEY_SIZE);
            var secretKey = keyGenerator.generateKey();
            var keyBytes = secretKey.getEncoded();
            SECRET_KEY_SPEC = new SecretKeySpec(keyBytes, ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new LoginException(ErrorCodeAndUserMessageEnum.B0411, "NoSuchAlgorithm: " + ALGORITHM);
        }
    }

    public static String encrypt(String text) {
        String result;
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, SECRET_KEY_SPEC);
            var encryptedBytes = cipher.doFinal(text.getBytes());
            result = Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new LoginException(ErrorCodeAndUserMessageEnum.B0411, "NoSuchAlgorithm: " + ALGORITHM);
        } catch (NoSuchPaddingException
                 | InvalidKeyException
                 | IllegalBlockSizeException
                 | BadPaddingException e) {
            throw new LoginException(ErrorCodeAndUserMessageEnum.A0350, "LoginAesUtils.encrypt error");
        }
        return result;
    }

    public static String decrypt(String ciphertext) {
        String result;
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, SECRET_KEY_SPEC);
            var decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
            result = new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException e) {
            throw new LoginException(ErrorCodeAndUserMessageEnum.B0411, "NoSuchAlgorithm: " + ALGORITHM);
        } catch (NoSuchPaddingException
                 | InvalidKeyException
                 | IllegalBlockSizeException
                 | BadPaddingException e) {
            throw new LoginException(ErrorCodeAndUserMessageEnum.A0350, "LoginAesUtils.decrypt error");
        }
        return result;
    }
}
