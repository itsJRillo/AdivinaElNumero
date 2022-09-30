package UF1.adivinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinnersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winners);

        final Button play = findViewById(R.id.play);
        Bundle extras = getIntent().getExtras();
        String repeated = new String(new char[45]).replace("\0", " ");

        if (extras != null) {
            final TextView playerName = findViewById(R.id.dataPlayers);

            String name = extras.getString("nombre_player");
            int tries = extras.getInt("intentos_player");

            if(name == null && tries == 0){return;}
            playerName.append(name + repeated + tries + "\n");
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