package UF1.adivinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int rand = (int) Math.floor(Math.random() * 100);
        final int[] intentos = {0};
        final TextView registros = findViewById(R.id.mensaje);
        registros.setMovementMethod(new ScrollingMovementMethod());

        final EditText number = findViewById(R.id.intento);
        final Button adivinar = findViewById(R.id.adivinar);


        adivinar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                registros.append("\nIntentos restantes: " + String.valueOf(5 - intentos[0]) + "\n");
                intentos[0] += 1;
                if(Integer.parseInt(number.getText().toString()) < rand){
                    CharSequence text = "Es más grande";
                    Toast(text);
                    registros.append("Es más grande\n");
                } else if (Integer.parseInt(number.getText().toString()) > rand){
                    CharSequence text = "Es más pequeño";
                    Toast(text);
                    registros.append("Es más pequeño\n");
                } else {
                    CharSequence text = "¡¡ Congratulations !!";
                    Toast(text);
                    registros.append("\n¡¡ Congratulations !!\nNúmero a adivinar: " + rand);
                    adivinar.setEnabled(false);
                }

                if (intentos[0] == 5){
                    CharSequence text = "No has tenido suerte";
                    Toast(text);
                    registros.append("\nAww, no has tenido suerte\nEl número que buscas es: " + rand);
                    adivinar.setEnabled(false);
                }

            }
        });

        registros.setText("");
    }

    public void Toast(CharSequence text){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}