package simple.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button caesar = findViewById(R.id.caesar);
        Button mono = findViewById(R.id.mono);
        Button poli = findViewById(R.id.poli);
        final Alphabet a = new Alphabet();
        final Cipher c = new Cipher(a);

        mono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText plain = findViewById(R.id.cifrare);
                TextView crypt = findViewById(R.id.cifrato);
                TextView desc = findViewById(R.id.desc);

                List<Character> alpha = new ArrayList<>(a.alpha);
                Collections.shuffle(alpha);
                String s = c.monoCipher(plain.getText().toString(),alpha);

                crypt.setText(s);
                desc.setText("PERMUTAZIONE USATA"+System.lineSeparator()+alpha.toString());
                desc.setVisibility(View.VISIBLE);
            }
        });

        caesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText plain = findViewById(R.id.cifrare);
                TextView crypt = findViewById(R.id.cifrato);
                TextView desc = findViewById(R.id.desc);

                String s = c.caesarCipher(plain.getText().toString(),5);

                crypt.setText(s);
                desc.setText("CHIAVE = 5");
                desc.setVisibility(View.VISIBLE);
            }
        });

        poli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText plain = findViewById(R.id.cifrare);
                TextView crypt = findViewById(R.id.cifrato);
                TextView desc = findViewById(R.id.desc);

                String s = c.poliCipher(plain.getText().toString(),"ciao");

                crypt.setText(s);
                desc.setText("CHIAVE = 'ciao'");
                desc.setVisibility(View.VISIBLE);
            }
        });

    }
}
