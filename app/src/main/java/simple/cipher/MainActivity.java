package simple.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
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
        Button reset = findViewById(R.id.reset);
        final Alphabet a = new Alphabet();
        final Cipher c = new Cipher(a);

        FileInputStream fis = null;


        reset.setVisibility(View.INVISIBLE);

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
                Button b = findViewById(R.id.reset);
                b.setVisibility(View.VISIBLE);
            }
        });

        caesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText plain = findViewById(R.id.cifrare);
                TextView crypt = findViewById(R.id.cifrato);
                TextView desc = findViewById(R.id.desc);

                int n = (int)(Math.random()*25+1);
                String s = c.caesarCipher(plain.getText().toString(),n);

                crypt.setText(s);
                desc.setText("CHIAVE = "+n);
                desc.setVisibility(View.VISIBLE);
                Button b = findViewById(R.id.reset);
                b.setVisibility(View.VISIBLE);
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
                Button b = findViewById(R.id.reset);
                b.setVisibility(View.VISIBLE);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText plain = findViewById(R.id.cifrare);
                TextView crypt = findViewById(R.id.cifrato);
                TextView desc = findViewById(R.id.desc);

                plain.setText("");
                crypt.setText("");
                desc.setText("");
                desc.setVisibility(View.INVISIBLE);
                Button b = findViewById(R.id.reset);
                b.setVisibility(View.INVISIBLE);
            }
        });

    }
}
