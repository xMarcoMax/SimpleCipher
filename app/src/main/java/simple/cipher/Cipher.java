package simple.cipher;
import java.util.List;

public class Cipher {
    private List<Character> alpha;
    private enum Type{CAESAR, MONO, POLI};
    Type type;

    public Cipher(Alphabet a) {
        this.type = null;
        this.alpha =  a.alpha;
    }

    /**
     * Encrypt a sentence using the Caesar's Cipher
     * @param s The string to be encrypted
     * @param alpha The choosen alphabet (latin, cyrillic, etc.) to use for the encryption
     * @param k The position of the substituting letter with respect to the one to be replaced
     * */
    public String caesarCipher(String s, int k) {
        StringBuilder crypted = new StringBuilder();
        int pos;

        s = s.toUpperCase();
        for(int i = 0; i<s.length();++i) {
            if(Character.isLetter(s.charAt(i))) {
                for(char c:alpha) {
                    if(c == s.charAt(i)) {
                        pos = alpha.indexOf(c) + k;
                        if(pos>25) {
                            pos = pos - 26;
                        }
                        crypted.append(alpha.get(pos));
                        break;
                    }
                }
            }
            else {
                crypted.append(s.charAt(i));
            }
        }
        return crypted.toString();
    }

    /**
     * Decrypt a sentence encrypted using the Caesar's Cipher
     * @param s The string to be decrypted
     * @param alpha The choosen alphabet (latin, cyrillic, etc.) used for the original encryption
     * @param k The position of the substituting letter with respect to the one to be replaced used in the encryption
     * */
    public String caesarDecrypt(String s, int k) {
        StringBuilder decrypted = new StringBuilder();
        int pos;

        s = s.toUpperCase();
        for(int i = 0; i<s.length();++i) {
            if(Character.isLetter(s.charAt(i))) {
                for(char c:alpha) {
                    if(c == s.charAt(i)) {
                        pos = alpha.indexOf(c) - k;
                        if(pos<0) {
                            pos = 26 + pos;
                        }
                        decrypted.append(alpha.get(pos));
                        break;
                    }
                }
            }
            else {
                decrypted.append(s.charAt(i));
            }
        }
        return decrypted.toString();
    }

    /**
     * Encrypt a sentence using the monoalphabetic cipher
     * @param s The string to be encrypted
     * @param alpha The choosen alphabet (latin, cyrillic, etc.), already permutated, to use for the encryption
     * */
    public String monoCipher(String s, List<Character> permAlpha) {
        StringBuilder crypted = new StringBuilder();

        s = s.toUpperCase();
        for(int i = 0; i<s.length();++i) {
            if(Character.isLetter(s.charAt(i))) {
                for(char c:alpha) {
                    if(c == s.charAt(i)) {
                        crypted.append(permAlpha.get(alpha.indexOf(c)));
                    }
                }
            }
            else {
                crypted.append(s.charAt(i));
            }
        }
        return crypted.toString();
    }

    /**
     * Decrypt a sentence encrypted using the monoalphabetic cipher
     * @param s The string to be decrypted
     * @param alpha The choosen alphabet (latin, cyrillic, etc.), already permutated, used for the encryption
     * */
    public String monoDecrypt(String s, List<Character> permAlpha) {
        StringBuilder decrypted = new StringBuilder();

        s = s.toUpperCase();
        for(int i = 0; i<s.length();++i) {
            if(Character.isLetter(s.charAt(i))) {
                for(char c:permAlpha) {
                    if(c == s.charAt(i)) {
                        decrypted.append(alpha.get(permAlpha.indexOf(c)));
                    }
                }
            }
            else {
                decrypted.append(s.charAt(i));
            }
        }
        return decrypted.toString();
    }
//	public String poliCipher(String s, String key) {
//		return null;
//	}
//	public String poliDecrypt(String s, List<Character> permAlpha1, List<Character> permAlpha2) {
//		return null;
//	}
}

