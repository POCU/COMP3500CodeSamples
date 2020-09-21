package academy.pocu.comp3500samples.w05.aes;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Program {
    public static void main(String[] args) {
        String message = "My message";
        String longerMessage = "My longer message";

        {
            String aes128key = "1234567890123456";

            String encryptedMessage = encrypt(message, aes128key);
            String encryptedLongerMessage = encrypt(longerMessage, aes128key);

            System.out.println(encryptedMessage);
            System.out.println(encryptedLongerMessage);

            String decryptedMessage = decrypt(encryptedMessage, aes128key);
            String decryptedLongerMessage = encrypt(encryptedLongerMessage, aes128key);

            System.out.println(decryptedMessage);
            System.out.println(decryptedLongerMessage);
        }

        {
            String aes192key = "123456789012345678901234";

            String encryptedMessage = encrypt(message, aes192key);
            String encryptedLongerMessage = encrypt(longerMessage, aes192key);

            System.out.println(encryptedMessage);
            System.out.println(encryptedLongerMessage);

            String decryptedMessage = decrypt(encryptedMessage, aes192key);
            String decryptedLongerMessage = encrypt(encryptedLongerMessage, aes192key);

            System.out.println(decryptedMessage);
            System.out.println(decryptedLongerMessage);
        }

        {
            String aes256key = "12345678901234567890123456789012";

            String encryptedMessage = encrypt(message, aes256key);
            String encryptedLongerMessage = encrypt(longerMessage, aes256key);

            System.out.println(encryptedMessage);
            System.out.println(encryptedLongerMessage);

            String decryptedMessage = decrypt(encryptedMessage, aes256key);
            String decryptedLongerMessage = encrypt(encryptedLongerMessage, aes256key);

            System.out.println(decryptedMessage);
            System.out.println(decryptedLongerMessage);
        }
    }

    private static String encrypt(String message, String key) {
        assert (key.length() == 16 || key.length() == 24 || key.length() == 32);

        try {
            byte[] keyInBytes = key.getBytes("UTF-8");
            byte[] messageInBytes = message.getBytes("UTF-8");

            SecretKeySpec secretKey = new SecretKeySpec(keyInBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(new byte[16]));

            byte[] encrypted = cipher.doFinal(messageInBytes);

            String encryptedMessage = Base64.getEncoder().encodeToString(encrypted);

            return encryptedMessage;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static String decrypt(String encryptedMessage, String key) {
        assert (key.length() == 16 || key.length() == 24 || key.length() == 32);

        try {
            byte[] keyInBytes = key.getBytes("UTF-8");
            byte[] encrypted = Base64.getDecoder().decode(encryptedMessage);

            SecretKeySpec secretKey = new SecretKeySpec(keyInBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(new byte[16]));

            byte[] messageInBytes = cipher.doFinal(encrypted);

            String message = new String(messageInBytes);

            return message;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
