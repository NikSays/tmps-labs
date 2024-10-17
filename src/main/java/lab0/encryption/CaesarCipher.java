package lab0.encryption;

public class CaesarCipher extends MonoalphabeticCipher {

    public CaesarCipher(int shift) {
        super(generateShiftedAlphabet(shift));
    }

    private static String generateShiftedAlphabet(int shift) {
        String originalAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder shiftedAlphabet = new StringBuilder();

        for (int i = 0; i < originalAlphabet.length(); i++) {
            shiftedAlphabet.append(originalAlphabet.charAt((i + shift) % originalAlphabet.length()));
        }

        return shiftedAlphabet.toString();
    }
}
