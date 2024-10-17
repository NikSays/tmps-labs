package lab0.encryption;

import lab0.encryption.EncryptionMethod;

import java.util.HashMap;
import java.util.Map;

public class MonoalphabeticCipher implements EncryptionMethod {

    private final Map<Character, Character> encryptMap = new HashMap<>();
    private final Map<Character, Character> decryptMap = new HashMap<>();

    public MonoalphabeticCipher(String shuffledAlphabet) {
        String originalAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < originalAlphabet.length(); i++) {
            this.encryptMap.put(originalAlphabet.charAt(i), shuffledAlphabet.charAt(i));
            this.decryptMap.put(shuffledAlphabet.charAt(i), originalAlphabet.charAt(i));
        }
    }

    public String encrypt(String data) {
        return this.transform(data.toUpperCase(), this.encryptMap);
    }

    public String decrypt(String data) {
        return this.transform(data.toUpperCase(), this.decryptMap);
    }

    private String transform(String data, Map<Character, Character> map) {
        StringBuilder result = new StringBuilder();
        for (char c : data.toCharArray()) {
            // Leave non-alphabetic characters as is.
            result.append(map.getOrDefault(c, c));
        }
        return result.toString();
    }
}

