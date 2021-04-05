package academy.pocu.comp3500samples.w05.aes;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Program {
    public static void main(String[] args) {
        String plaintext = "My message";
        String longPlaintext = "My longer message";

        {
            String aes128key = "1234567890123456";
            byte[] keyInBytes = aes128key.getBytes(StandardCharsets.US_ASCII);

            String ciphertext = encrypt(plaintext, keyInBytes);
            String longCiphertext = encrypt(longPlaintext, keyInBytes);

            System.out.println(ciphertext);
            System.out.println(longCiphertext);

            String decryptedText = decrypt(ciphertext, keyInBytes);
            String longDecryptedText = decrypt(longCiphertext, keyInBytes);

            System.out.println(decryptedText);
            System.out.println(longDecryptedText);
        }

        {
            String aes192key = "123456789012345678901234";
            byte[] keyInBytes = aes192key.getBytes(StandardCharsets.US_ASCII);

            String ciphertext = encrypt(plaintext, keyInBytes);
            String longCiphertext = encrypt(longPlaintext, keyInBytes);

            System.out.println(ciphertext);
            System.out.println(longCiphertext);

            String decryptedText = decrypt(ciphertext, keyInBytes);
            String longDecryptedText = decrypt(longCiphertext, keyInBytes);

            System.out.println(decryptedText);
            System.out.println(longDecryptedText);
        }

        {
            String aes256key = "12345678901234567890123456789012";
            byte[] keyInBytes = aes256key.getBytes(StandardCharsets.US_ASCII);

            String ciphertext = encrypt(plaintext, keyInBytes);
            String longCiphertext = encrypt(longPlaintext, keyInBytes);

            System.out.println(ciphertext);
            System.out.println(longCiphertext);

            String decryptedText = decrypt(ciphertext, keyInBytes);
            String longDecryptedText = decrypt(longCiphertext, keyInBytes);

            System.out.println(decryptedText);
            System.out.println(longDecryptedText);
        }
    }

    private static String encrypt(String plaintext, byte[] key) {
        assert (key.length == 16 || key.length == 24 || key.length == 32);

        try {
            byte[] plaintextInBytes = plaintext.getBytes(StandardCharsets.UTF_8);

            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,
                    secretKey,
                    new IvParameterSpec(new byte[16]));

            byte[] encrypted = cipher
                    .doFinal(plaintextInBytes);

            return Base64.getEncoder()
                    .encodeToString(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static String decrypt(String cipherText, byte[] key) {
        assert (key.length == 16 || key.length == 24 || key.length == 32);

        try {
            byte[] encrypted = Base64.getDecoder()
                    .decode(cipherText);

            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,
                    secretKey,
                    new IvParameterSpec(new byte[16]));

            byte[] plaintext = cipher
                    .doFinal(encrypted);

            return new String(plaintext, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
