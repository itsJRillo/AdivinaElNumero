package UF1.adivinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class WinnersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winners);

        final Button play = findViewById(R.id.play);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            // final TextView tries = findViewById(R.id.players);
            final TextView players = findViewById(R.id.player);
            final TextView tries = findViewById(R.id.tries);

            ArrayList<String> namePlayer = extras.getStringArrayList("nombre_jugador");
            ArrayList<Integer> triesPlayer = extras.getIntegerArrayList("intentos_jugador");

            for(int i=0;i<namePlayer.size();i++){
                String repeated = new String(new char[45 - namePlayer.get(i).length()]).replace("\0", " ");
                players.append(namePlayer.get(i) + "\n");
                tries.append(String.valueOf(triesPlayer.get(i)) + "\n");
            }

        }

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage(view);
            }
        });
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}