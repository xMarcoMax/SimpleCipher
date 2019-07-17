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

        Button caesar = (Button) findViewById(R.id.caesar);
        Button mono = (Button) findViewById(R.id.mono);
        final Alphabet a = new Alphabet();
        final Cipher c = new Cipher(a);

        mono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText plain = (EditText) findViewById(R.id.cifrare);
                TextView crypted = (TextView) findViewById(R.id.cifrato);

                List<Character> alpha = new ArrayList<>(a.alpha);
                Collections.shuffle(alpha);
                String s = c.monoCipher(plain.getText().toString(),alpha);

                crypted.setText(s);

            }
        });

        caesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText plain = (EditText) findViewById(R.id.cifrare);
                TextView crypted = (TextView) findViewById(R.id.cifrato);

                String s = c.caesarCipher(plain.getText().toString(),5);

                crypted.setText(s);
            }
        });



    }
}
