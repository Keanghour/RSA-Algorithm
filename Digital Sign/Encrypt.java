public class Encrypt {

    public static void main(String[] args) {
        try {
            // Paths to keys
            String pathPrivateKey = "privateKey.pem";

            // Generate a new AES key as a Base64 encoded string
            // String aesKeyBase64 = RSAAlgorithm.generateAESKey();
            String aesKeyBase64 = Digital Sign.RSAAlgorithm.generateAESKey();
            System.out.println("Generated AES Key (Base64): " + aesKeyBase64);

            // Data to encrypt
            String data = "Hello world";

            // Encrypt the data using AES key (Base64 string)
            String encryptedData = RSAAlgorithm.encryptAES(data, aesKeyBase64);
            System.out.println("\nEncrypted Data: " + encryptedData);

            // Encrypt AES key using RSA private key (adjusted per your requirement)
            String encryptedAESKey = RSAAlgorithm.encryptAESKey(aesKeyBase64, pathPrivateKey);
            System.out.println("\nEncrypted AES Key: " + encryptedAESKey);

            // Sign the data using RSA private key
            String signature = RSAAlgorithm.signDataRSA(data, pathPrivateKey);
            System.out.println("\nData Signature: " + signature);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
