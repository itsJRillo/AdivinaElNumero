package UF1.adivinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int rand = 10;
        final EditText number = findViewById(R.id.intento);
        final Button adivinar = findViewById(R.id.adivinar);

        adivinar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(Integer.parseInt(number.getText().toString()) > rand){
                    CharSequence text = "Es más pequeño";
                    Toast(text);
                } else if(Integer.parseInt(number.getText().toString()) < rand){
                    CharSequence text = "Es más grande";
                    Toast(text);
                } else {
                    CharSequence text = "¡¡Congratulations!!";
                    Toast(text);
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