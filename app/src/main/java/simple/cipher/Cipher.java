package simple.cipher;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Cipher {
    private List<Character> alpha;

    public Cipher(Alphabet a) {
        this.alpha =  a.alpha;
    }

    /**
     * Encrypt a sentence using the Caesar's Cipher
     * @param s The string to be encrypted
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
     * @param permAlpha The choosen alphabet (latin, cyrillic, etc.), already permutated, to use for the encryption
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
     * @param permAlpha The choosen alphabet (latin, cyrillic, etc.), already permutated, used for the encryption
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

    /**
     * Encrypt a sentence using the polialphabetic cipher
     * @param s The string to be encrypted
     * @param key The choosen to use for the encryption
     * */
    public String poliCipher(String s, String key) {
        Map<Character,Alphabet> poli = new TreeMap<>();
        StringBuilder crypt = new StringBuilder();
        Alphabet a = new Alphabet();

        key=key.toUpperCase();
        for(int i =0;i<key.length();++i) {
            char c = key.charAt(i);
            int ind = a.alpha.indexOf(c);

            List<Character> temp1 = new ArrayList<>(a.alpha.subList(ind, 26));
            List<Character> temp2 = new ArrayList<>(a.alpha.subList(0, ind));
            List<Character> fin = new ArrayList<>(temp1);

            fin.addAll(temp2);
            poli.put(c, new Alphabet(fin));
        }
        s=s.toUpperCase();
        int k = 0;
        for(int i = 0;i<s.length();++i) {
            if(Character.isLetter(s.charAt(i))) {
                Alphabet ab = poli.get(key.charAt(k));
                for(char c:alpha) {
                    if(c == s.charAt(i)) {
                        crypt.append(ab.alpha.get(alpha.indexOf(c)));
                        if (k<key.length()-1)
                            k++;
                        else
                            k=0;
                        break;
                    }
                }
            }
            else {
                crypt.append(s.charAt(i));
            }
        }
        return crypt.toString();
    }

    /**
     * Decrypt a sentence encrypted with the polialphabetic cipher
     * @param s The string to be decrypted
     * @param key The choosen used for the encryption
     * */
    public String poliDecrypt(String s, String key) {
        Map<Character,Alphabet> poli = new TreeMap<>();
        StringBuilder decrypt = new StringBuilder();
        Alphabet a = new Alphabet();

        key=key.toUpperCase();
        for(int i =0;i<key.length();++i) {
            char c = key.charAt(i);
            int ind = a.alpha.indexOf(c);

            List<Character> temp1 = new ArrayList<>(a.alpha.subList(ind, 26));
            List<Character> temp2 = new ArrayList<>(a.alpha.subList(0, ind));
            List<Character> fin = new ArrayList<>(temp1);

            fin.addAll(temp2);
            poli.put(c, new Alphabet(fin));
        }
        s=s.toUpperCase();
        int k = 0;
        for(int i = 0;i<s.length();++i) {
            if(Character.isLetter(s.charAt(i))) {
                Alphabet ab = poli.get(key.charAt(k));
                for(char c:alpha) {
                    if(c == s.charAt(i)) {
                        decrypt.append(alpha.get(ab.alpha.indexOf(c)));
                        if (k<key.length()-1)
                            k++;
                        else
                            k=0;
                        break;
                    }
                }
            }
            else {
                decrypt.append(s.charAt(i));
            }
        }
        return decrypt.toString();
    }
}

