# README

# RSA-Algorithm
The RSA algorithm is a public-key cryptosystem for secure data transmission. Developed by Rivest, Shamir, and Adleman in 1977, it uses two keys: a public key for encryption and a private key for decryption. RSA ensures secure communication by allowing only the recipient to decrypt the message

---

**RSA Algorithm** Java implementation:

---

# RSA Algorithm Java Implementation

This project demonstrates the implementation of the **RSA Algorithm** for **secure data transmission**, **encryption**, **decryption**, and **digital signatures** in Java. It combines **RSA (asymmetric encryption)** for key exchange and **AES (symmetric encryption)** for data encryption. The implementation is capable of securely transferring AES keys, encrypting data, and signing/validating data.

## Features

- **RSA Key Pair Generation**: Load public and private keys from PEM files.
- **AES Key Generation**: Generate a random 128-bit AES key for data encryption.
- **RSA-AES Hybrid Encryption**: Encrypt the AES key using the RSA private key and decrypt it using the RSA public key.
- **AES Data Encryption**: Encrypt and decrypt data using the AES key.
- **Digital Signatures**: Sign data using RSA private key and verify using RSA public key.

## Requirements

- Java 8 or above
- Java Cryptography Extension (JCE) (should be included in the standard Java distribution)

## File Structure

```
/src
    └── RSAAlgorithm.java       # Main class implementing RSA & AES encryption/decryption, and signing
```

## Setup

### 1. Clone the repository

```bash
git clone https://github.com/yourusername/rsa-algorithm-java.git
cd rsa-algorithm-java
```

### 2. Compile the Code

Make sure to compile the `RSAAlgorithm.java` file:

```bash
javac RSAAlgorithm.java
```

### 3. Run the Program

To use the RSA and AES encryption methods, run the class with the necessary arguments.

### Example Usage

#### 1. **Load Public and Private Keys**

Before encrypting or signing data, load the **public** and **private keys** from their respective PEM files.

```java
PublicKey publicKey = RSAAlgorithm.getPublicKey("path/to/publicKey.pem");
PrivateKey privateKey = RSAAlgorithm.getPrivateKey("path/to/privateKey.pem");
```

#### 2. **Generate AES Key**

Generate a random 128-bit AES key for data encryption.

```java
String aesKey = RSAAlgorithm.generateAESKey();
System.out.println("Generated AES Key: " + aesKey);
```

#### 3. **Encrypt and Decrypt AES Key with RSA**

Encrypt the AES key using the RSA private key, and decrypt it with the RSA public key.

```java
String encryptedAESKey = RSAAlgorithm.encryptAESKey(aesKey, "path/to/privateKey.pem");
System.out.println("Encrypted AES Key: " + encryptedAESKey);

String decryptedAESKey = RSAAlgorithm.decryptAESKey(encryptedAESKey, "path/to/publicKey.pem");
System.out.println("Decrypted AES Key: " + decryptedAESKey);
```

#### 4. **Encrypt and Decrypt Data Using AES**

Encrypt and decrypt data using the AES key.

```java
String encryptedData = RSAAlgorithm.encryptAES("Sensitive data", aesKey);
System.out.println("Encrypted Data: " + encryptedData);

String decryptedData = RSAAlgorithm.decryptAES(encryptedData, aesKey);
System.out.println("Decrypted Data: " + decryptedData);
```

#### 5. **Sign and Verify Data Using RSA**

Sign data with the RSA private key and verify it using the RSA public key.

```java
String signature = RSAAlgorithm.signDataRSA("Data to sign", "path/to/privateKey.pem");
System.out.println("Signature: " + signature);

boolean isSignatureValid = RSAAlgorithm.verifyData("Data to sign", signature, "path/to/publicKey.pem");
System.out.println("Signature Valid: " + isSignatureValid);
```

## Methods Overview

### **`getPublicKey(String path)`**
Loads a public key from a PEM file.

### **`getPrivateKey(String path)`**
Loads a private key from a PEM file.

### **`generateAESKey()`**
Generates a random 128-bit AES key.

### **`encodeAESKeyBytesToBase64(byte[] keyBytes)`**
Encodes the AES key bytes into a Base64 string.

### **`decodeBase64ToAESKeyBytes(String base64Key)`**
Decodes the Base64 encoded AES key into a byte array.

### **`encryptAESKey(String base64AESKey, String pathPrivateKey)`**
Encrypts the AES key using the RSA private key.

### **`decryptAESKey(String encryptedKey, String pathPublicKey)`**
Decrypts the AES key using the RSA public key.

### **`encryptAES(String data, String base64AESKey)`**
Encrypts data using the AES key.

### **`decryptAES(String encryptedData, String base64AESKey)`**
Decrypts encrypted data using the AES key.

### **`signDataRSA(String data, String pathPrivateKey)`**
Signs data using the RSA private key.

### **`verifyData(String data, String signatureBase64, String pathPublicKey)`**
Verifies the digital signature using the RSA public key.

## Key Concepts

- **RSA Algorithm**: Asymmetric encryption algorithm that uses a public key for encryption and a private key for decryption.
- **AES Algorithm**: Symmetric encryption algorithm used to encrypt and decrypt data with the same key.
- **Digital Signatures**: RSA is used for signing data, ensuring its authenticity and integrity.
  
## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

### How to Contribute

1. Fork the repository
2. Create your feature branch (`git checkout -b feature-branch`)
3. Commit your changes (`git commit -m 'Add new feature'`)
4. Push to the branch (`git push origin feature-branch`)
5. Create a new Pull Request

---

### Notes

- Ensure your keys are in the correct PEM format before using them in the program.
- Make sure you have appropriate file permissions to read the key files.
- The example assumes the usage of `SHA256withRSA` for signing and verifying data, but other algorithms could also be implemented based on requirements.

---

This **README** is designed to help users quickly get started with the project, understand the key concepts, and guide them through practical examples of using the RSA and AES encryption system.

### License:
MIT License

---

**Contact**:
- Email: phokeanghour12@gmail.com
- Telegram: @phokeanghour | 095 323 346


<a href="https://t.me/phokeanghour" target="_blank" rel="noreferrer">
    <img src="https://www.vectorlogo.zone/logos/telegram/telegram-ar21.svg" />
  </a>

<a href="https://www.linkedin.com/in/pho-keanghour-27133b21b/" target="_blank" rel="noreferrer">
    <img src="https://www.vectorlogo.zone/logos/linkedin/linkedin-ar21.svg" />
  </a>

---
