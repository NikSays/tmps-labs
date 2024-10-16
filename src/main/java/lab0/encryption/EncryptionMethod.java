package lab0.encryption;

public interface EncryptionMethod {
    String encrypt(String data);

    String decrypt(String data);
}