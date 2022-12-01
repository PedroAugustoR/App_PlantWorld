package co.tiagoaguiar.tutorial.gmaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class suport extends AppCompatActivity {

    private Button voltarsup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suport);

        getSupportActionBar().hide();
        IniciarComponentes();

        voltarsup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(suport.this,telaprincipal.class);
                startActivity(intent);
            }
        });
    }

    private void IniciarComponentes(){
        voltarsup = findViewById(R.id.voltarsup);
    }
}