import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class RSAKeyGenerator_Console {

    // Method to generate the RSA key pair
    public static KeyPair generateRSAKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Use 2048-bit key size
        return keyPairGenerator.generateKeyPair();
    }

    // Method to convert a private key to PEM format
    public static String convertPrivateKeyToPEM(PrivateKey privateKey) {
        String privateKeyPEM = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        return "-----BEGIN PRIVATE KEY-----\n" +
                privateKeyPEM.replaceAll("(.{64})", "$1\n") +
                "\n-----END PRIVATE KEY-----";
    }

    // Method to convert a public key to PEM format
    public static String convertPublicKeyToPEM(PublicKey publicKey) {
        String publicKeyPEM = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        return "-----BEGIN PUBLIC KEY-----\n" +
                publicKeyPEM.replaceAll("(.{64})", "$1\n") +
                "\n-----END PUBLIC KEY-----";
    }

    public static void main(String[] args) {
        try {
            // Generate RSA key pair
            KeyPair keyPair = generateRSAKeyPair();

            // Convert private key to PEM format
            String privateKeyPEM = convertPrivateKeyToPEM(keyPair.getPrivate());
            System.out.println("Private Key:");
            System.out.println(privateKeyPEM);

            // Convert public key to PEM format
            String publicKeyPEM = convertPublicKeyToPEM(keyPair.getPublic());
            System.out.println("Public Key:");
            System.out.println(publicKeyPEM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
