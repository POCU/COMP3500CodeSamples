package academy.pocu.comp3500samples.w05.aes;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Program {
    public static void main(String[] args) {
        String plaintext = "My message";
        String longerPlaintext = "My longer message";

        {
            String aes128key = "1234567890123456";

            String ciphertext = encrypt(plaintext, aes128key);
            String longerCiphertext = encrypt(longerPlaintext, aes128key);

            System.out.println(ciphertext);
            System.out.println(longerCiphertext);

            String actualPlaintext = decrypt(ciphertext, aes128key);
            String actualLongerPlaintext = decrypt(longerCiphertext, aes128key);

            System.out.println(actualPlaintext);
            System.out.println(actualLongerPlaintext);
        }

        {
            String aes192key = "123456789012345678901234";

            String ciphertext = encrypt(plaintext, aes192key);
            String longerCiphertext = encrypt(longerPlaintext, aes192key);

            System.out.println(ciphertext);
            System.out.println(longerCiphertext);

            String actualPlaintext = decrypt(ciphertext, aes192key);
            String actualLongerPlaintext = decrypt(longerCiphertext, aes192key);

            System.out.println(actualPlaintext);
            System.out.println(actualLongerPlaintext);
        }

        {
            String aes256key = "12345678901234567890123456789012";

            String ciphertext = encrypt(plaintext, aes256key);
            String longerCiphertext = encrypt(longerPlaintext, aes256key);

            System.out.println(ciphertext);
            System.out.println(longerCiphertext);

            String actualPlaintext = decrypt(ciphertext, aes256key);
            String actualLongerPlaintext = decrypt(longerCiphertext, aes256key);

            System.out.println(actualPlaintext);
            System.out.println(actualLongerPlaintext);
        }
    }

    private static String encrypt(String plaintext, String key) {
        assert (key.length() == 16 || key.length() == 24 || key.length() == 32);

        try {
            byte[] keyInBytes = key.getBytes(StandardCharsets.UTF_8);
            byte[] plaintextInBytes = plaintext.getBytes(StandardCharsets.UTF_8);

            SecretKeySpec secretKey = new SecretKeySpec(keyInBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,
                    secretKey,
                    new IvParameterSpec(new byte[16]));

            byte[] encrypted = cipher.doFinal(plaintextInBytes);

            return Base64.getEncoder()
                    .encodeToString(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static String decrypt(String cipherText, String key) {
        assert (key.length() == 16 || key.length() == 24 || key.length() == 32);

        try {
            byte[] keyInBytes = key.getBytes(StandardCharsets.UTF_8);
            byte[] encrypted = Base64.getDecoder()
                    .decode(cipherText);

            SecretKeySpec secretKey = new SecretKeySpec(keyInBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,
                    secretKey,
                    new IvParameterSpec(new byte[16]));

            byte[] plaintext = cipher.doFinal(encrypted);

            return new String(plaintext);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
