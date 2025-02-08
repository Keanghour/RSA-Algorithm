public class Decrypt {

    public static void main(String[] args) {
        try {
            // Paths to keys
            String pathPublicKey = "publicKey.pem";

            // Example encrypted data and keys (these should be obtained from Encrypt
            // output)
            String encryptedData = "LON8T5NCovOkb9AAhHEngg==";
            String encryptedAESKey = "Z7mtM6Rzez84Z46QaGCAofXYlCRx3q2ZnPN/N1tSJhjDmPKmbXXDLB1pQMbzmtCqSP77amuuoIZ90fAKTHSxQBNdm6BVQDERga29qDrqXx7rvX5Edoi0cQyqIo6DlYyl6XFO7zkiZ08hdx+yQX1dwpVY8HY+gpAJIvbOQd3lofCebtq2I2/QfNKGSSERie9a2CAqkLncushWLxax3bgLRHo0B7cv4u15R1mZH3Lb9DYDx2/EaR7A7uAgzIoQyixCT6nTdBCpLzkrHjIfzO/oGaZJGG3j9Gp/emJ4JWJ5TpaVil273DL94i1pMF633Y8USY2Z37102ekD0HB3/9n2Cg==";
            String signature = "OrZDeJy8r4dfKwvobinbCEeiiqnMKpF4uaHV+MZxLC2gCNQ9AHXq3Oiza2h9eKWKJtKR2BP90wo+7UyVNcNAtf02W6pSiSAvjNrfoRyV0uhk5Lud+HCDq2QBZKRcE1OqRF9KLcjNaSqpCRQ0upoTOxXw3y+QpTHIiW3QGsDToWJNH8r1ON05dU+cdGtbjuex/SxM1bcWG05C79TTWqS0LJHw8PWrLGlo8747SG8sQI2GAUTZrlTc0kVdRJhTjAPxDJtHpcInpU/7+rEw4atiKvCsKm0Nf52qcNw75R7doNiWsIFzI3NQhHgPRyYoY9FZrEWULnhFYf0idWc7e+w4Qg==";

            // Decrypt the AES key using RSA public key (adjusted per your requirement)
            String decryptedAESKey = RSAAlgorithm.decryptAESKey(encryptedAESKey, pathPublicKey);

            // Decrypt the data using the decrypted AES key
            String decryptedData = RSAAlgorithm.decryptAES(encryptedData, decryptedAESKey);
            System.out.println("Decrypted Data: " + decryptedData);

            // Verify the signature using RSA public key
            boolean isSignatureValid = RSAAlgorithm.verifyData(decryptedData, signature, pathPublicKey);
            System.out.println("Signature Valid: " + isSignatureValid);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
