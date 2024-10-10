import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class SimpleEncryptionExample {

    // Method to encrypt data
    public static String encrypt(String plainText, SecretKey secretKey) throws Exception {
        // Get Cipher instance for AES encryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Perform encryption
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

        // Encode the result to Base64 for easy storage and transfer
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Method to decrypt data
    public static String decrypt(String encryptedText, SecretKey secretKey) throws Exception {
        // Get Cipher instance for AES decryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Decode Base64 and decrypt the data
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));

        // Return the decrypted string
        return new String(decryptedBytes);
    }

    public static void main(String[] args) {
        try {
            // Step 1: Generate a secret AES key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // Key size of 128 bits
            SecretKey secretKey = keyGen.generateKey();

            // Original text to encrypt
            String originalText = "Hello, World!";

            // Step 2: Encrypt the original text
            String encryptedText = encrypt(originalText, secretKey);
            System.out.println("Encrypted Text: " + encryptedText);

            // Step 3: Decrypt the encrypted text
            String decryptedText = decrypt(encryptedText, secretKey);
            System.out.println("Decrypted Text: " + decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
