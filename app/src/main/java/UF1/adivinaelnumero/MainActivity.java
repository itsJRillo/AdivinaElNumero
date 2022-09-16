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
                if(Integer.parseInt(number.getText().toString()) == rand){
                    GoodToast();
                } else {
                    BadToast();
                }
            }
        });
    }

    public void BadToast(){
        Context context = getApplicationContext();
        CharSequence text = "¡¡ Wrong number !!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void GoodToast(){
        Context context = getApplicationContext();
        CharSequence text = "¡¡ Congratulations !!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}