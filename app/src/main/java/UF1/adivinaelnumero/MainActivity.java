package UF1.adivinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int intentos = 0;
    int rand = (int) Math.floor(Math.random() * 100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView registros = findViewById(R.id.mensaje);
        registros.setMovementMethod(new ScrollingMovementMethod());

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final EditText number = findViewById(R.id.intento);
        final Button adivinar = findViewById(R.id.adivinar);


        adivinar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (String.valueOf(number).isEmpty()) {
                    builder.setMessage("¡ You can't leave blanks !");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {}
                    });

                    AlertDialog alert = builder.create();
                    alert.setTitle("Warning");
                    alert.show();
                }

                intentos += 1;
                registros.append("\nIntentos restantes: " + intentos + "\n");

                if(Integer.parseInt(number.getText().toString()) < rand){
                    CharSequence text = "Es más grande";
                    Toast(text);
                    registros.append("Es más grande\n");
                } else if (Integer.parseInt(number.getText().toString()) > rand){
                    CharSequence text = "Es más pequeño";
                    Toast(text);
                    registros.append("Es más pequeño\n");
                } else if(Integer.parseInt(number.getText().toString()) == rand){

                    builder.setMessage("¡¡¡ Congratulations !!!");
                    builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            CharSequence text = "¡¡ Congratulations !!";
                            Toast(text);
                            intentos = 0;
                            registros.setText("Aquí aparecerán los resultados\n");
                            number.setText("");
                        }
                    });

                    AlertDialog win = builder.create();
                    win.setTitle("YOU WIN");
                    win.show();
                }

                if (intentos == 5){
                    builder.setMessage("¡¡¡ How unlucky, you didn't win !!!");
                    builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            CharSequence text = "No has tenido suerte";
                            Toast(text);
                            intentos = 0;
                            registros.setText("Aquí aparecerán los resultados\n");
                            number.setText("");
                        }
                    });

                    AlertDialog lose = builder.create();
                    lose.setTitle("YOU LOSE");
                    lose.show();
                }
            }
        });
    }


    public void Toast(CharSequence text){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}