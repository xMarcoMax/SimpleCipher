package simple.cipher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alphabet {
    public List<Character> alpha;

    public Alphabet() {
        this.alpha = new ArrayList<>(26);
        char c = 'A';
        for (int i = 0; i < 26; ++i) {
            alpha.add(c);
            c++;
        }
    }

    public List<Character> generatePermutation() {
        List<Character> ret = new ArrayList<>(alpha);
        Collections.shuffle(ret);
        return ret;
    }

    public String toString() {
        return alpha.toString();
    }
}
