
---

# README

***RSA-Algorithm***
The RSA algorithm is a public-key cryptosystem for secure data transmission. Developed by Rivest, Shamir, and Adleman in 1977, it uses two keys: a public key for encryption and a private key for decryption. RSA ensures secure communication by allowing only the recipient to decrypt the message

---

---

# RSA Algorithm Java Implementation

This project demonstrates the **RSA Algorithm** for **secure data transmission**, **encryption**, **decryption**, and **digital signatures** in Java. It combines **RSA** (asymmetric encryption) for key exchange and **AES** (symmetric encryption) for data encryption. 

## Features

- **RSA Key Pair Generation**: Load public and private keys from PEM files.
- **AES Key Generation**: Generate a random 128-bit AES key.
- **RSA-AES Hybrid Encryption**: Encrypt and decrypt AES key using RSA.
- **AES Data Encryption**: Encrypt and decrypt data using AES.
- **Digital Signatures**: Sign data with RSA private key and verify with RSA public key.

## Requirements

- Java 8 or above
- Java Cryptography Extension (JCE)

## Setup

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/rsa-algorithm-java.git
cd rsa-algorithm-java
```

### 2. Compile the Code

```bash
javac RSAAlgorithm.java
```

### 3. Run the Program

To use RSA and AES methods, run the program with necessary arguments.

---

## Example Usage

### 1. **Load Public and Private Keys**

```java
PublicKey publicKey = RSAAlgorithm.getPublicKey("path/to/publicKey.pem");
PrivateKey privateKey = RSAAlgorithm.getPrivateKey("path/to/privateKey.pem");
```

### 2. **Generate AES Key**

```java
String aesKey = RSAAlgorithm.generateAESKey();
System.out.println("Generated AES Key: " + aesKey);
```

### 3. **Encrypt and Decrypt AES Key**

```java
String encryptedAESKey = RSAAlgorithm.encryptAESKey(aesKey, "path/to/privateKey.pem");
String decryptedAESKey = RSAAlgorithm.decryptAESKey(encryptedAESKey, "path/to/publicKey.pem");
System.out.println("Decrypted AES Key: " + decryptedAESKey);
```

### 4. **Encrypt and Decrypt Data Using AES**

```java
String encryptedData = RSAAlgorithm.encryptAES("Sensitive data", aesKey);
String decryptedData = RSAAlgorithm.decryptAES(encryptedData, aesKey);
System.out.println("Decrypted Data: " + decryptedData);
```

### 5. **Sign and Verify Data Using RSA**

```java
String signature = RSAAlgorithm.signDataRSA("Data to sign", "path/to/privateKey.pem");
boolean isSignatureValid = RSAAlgorithm.verifyData("Data to sign", signature, "path/to/publicKey.pem");
System.out.println("Signature Valid: " + isSignatureValid);
```

---

## Methods Overview

### **`getPublicKey(String path)`**
Loads a public key from a PEM file.

### **`getPrivateKey(String path)`**
Loads a private key from a PEM file.

### **`generateAESKey()`**
Generates a random 128-bit AES key.

### **`encodeAESKeyBytesToBase64(byte[] keyBytes)`**
Encodes AES key bytes into a Base64 string.

### **`decodeBase64ToAESKeyBytes(String base64Key)`**
Decodes Base64 encoded AES key into a byte array.

### **`encryptAESKey(String base64AESKey, String pathPrivateKey)`**
Encrypts AES key using RSA private key.

### **`decryptAESKey(String encryptedKey, String pathPublicKey)`**
Decrypts AES key using RSA public key.

### **`encryptAES(String data, String base64AESKey)`**
Encrypts data using AES key.

### **`decryptAES(String encryptedData, String base64AESKey)`**
Decrypts data using AES key.

### **`signDataRSA(String data, String pathPrivateKey)`**
Signs data using RSA private key.

### **`verifyData(String data, String signatureBase64, String pathPublicKey)`**
Verifies digital signature using RSA public key.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

### How to Contribute

1. Fork the repository
2. Create a feature branch (`git checkout -b feature-branch`)
3. Commit your changes (`git commit -m 'Add new feature'`)
4. Push to the branch (`git push origin feature-branch`)
5. Create a Pull Request

---

### Notes

- Ensure your keys are in PEM format before using them.
- The example uses `SHA256withRSA` for signing and verifying, but other algorithms can be used.

---

## Contact

- Email: phokeanghour12@gmail.com
- Telegram: [@phokeanghour](https://t.me/phokeanghour)

<a href="https://t.me/phokeanghour" target="_blank" rel="noreferrer">
    <img src="https://www.vectorlogo.zone/logos/telegram/telegram-ar21.svg" />
</a>

<a href="https://www.linkedin.com/in/pho-keanghour-27133b21b/" target="_blank" rel="noreferrer">
    <img src="https://www.vectorlogo.zone/logos/linkedin/linkedin-ar21.svg" />
</a>

---

**Credit**: This project was created by **Pho Keanghour**.

---

Let me know if this works!
