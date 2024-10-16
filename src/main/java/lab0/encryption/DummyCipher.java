package lab0.encryption;

public class DummyCipher implements EncryptionMethod {

    public String encrypt(String data) {
        return data;
    }

    public String decrypt(String data) {
        return data;
    }
}

