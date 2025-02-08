import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class RSAAlgorithm {

    // Load the public key from a PEM file
    private static PublicKey getPublicKey(String path) throws Exception {
        String publicKeyPEM = new String(Files.readAllBytes(Paths.get(path)));
        publicKeyPEM = publicKeyPEM.replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s+", "");
        byte[] encoded = Base64.getDecoder().decode(publicKeyPEM);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    // Load the private key from a PEM file
    private static PrivateKey getPrivateKey(String path) throws Exception {
        String privateKeyPEM = new String(Files.readAllBytes(Paths.get(path)));
        privateKeyPEM = privateKeyPEM.replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s+", "");
        byte[] encoded = Base64.getDecoder().decode(privateKeyPEM);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    // Generate a new random AES key (128-bit) and return it as a Base64 encoded
    // string
    public static String generateAESKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        byte[] keyBytes = keyGen.generateKey().getEncoded();
        return Base64.getEncoder().encodeToString(keyBytes);
    }

    // Convert Base64 encoded AES key to byte array
    public static byte[] decodeBase64ToAESKeyBytes(String base64Key) {
        return Base64.getDecoder().decode(base64Key);
    }

    // Convert byte array to Base64 encoded string
    public static String encodeAESKeyBytesToBase64(byte[] keyBytes) {
        return Base64.getEncoder().encodeToString(keyBytes);
    }

    // Encrypt AES key (provided as Base64 string) using RSA private key
    public static String encryptAESKey(String base64AESKey, String pathPrivateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        PrivateKey privateKey = getPrivateKey(pathPrivateKey);
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] keyBytes = decodeBase64ToAESKeyBytes(base64AESKey);
        byte[] encryptedKey = cipher.doFinal(keyBytes);
        return Base64.getEncoder().encodeToString(encryptedKey);
    }

    // Decrypt AES key using RSA public key and return it as a Base64 encoded string
    public static String decryptAESKey(String encryptedKey, String pathPublicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        PublicKey publicKey = getPublicKey(pathPublicKey);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] decodedKey = Base64.getDecoder().decode(encryptedKey);
        byte[] keyBytes = cipher.doFinal(decodedKey);
        return Base64.getEncoder().encodeToString(keyBytes);
    }

    // Encrypt data using AES key (provided as Base64 string)
    public static String encryptAES(String data, String base64AESKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        byte[] keyBytes = decodeBase64ToAESKeyBytes(base64AESKey);
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    // Decrypt data using AES key (provided as Base64 string)
    public static String decryptAES(String encryptedData, String base64AESKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        byte[] keyBytes = decodeBase64ToAESKeyBytes(base64AESKey);
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedData = cipher.doFinal(decodedData);
        return new String(decryptedData, "UTF-8");
    }

    // Sign data using RSA private key
    public static String signDataRSA(String data, String pathPrivateKey) throws Exception {
        PrivateKey privateKey = getPrivateKey(pathPrivateKey);
        Signature signer = Signature.getInstance("SHA256withRSA");
        signer.initSign(privateKey);
        signer.update(data.getBytes("UTF-8"));
        byte[] signature = signer.sign();
        return Base64.getEncoder().encodeToString(signature);
    }

    // Verify data signature using RSA public key
    public static boolean verifyData(String data, String signatureBase64, String pathPublicKey) throws Exception {
        PublicKey publicKey = getPublicKey(pathPublicKey);
        Signature verifier = Signature.getInstance("SHA256withRSA");
        verifier.initVerify(publicKey);
        verifier.update(data.getBytes("UTF-8"));
        byte[] signature = Base64.getDecoder().decode(signatureBase64);
        return verifier.verify(signature);
    }
}
