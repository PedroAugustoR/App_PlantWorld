package co.tiagoaguiar.tutorial.gmaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class arvore extends AppCompatActivity {

    private Button voltararvore;
    private Button maps_tela;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arvore);


        getSupportActionBar().hide();
        IniciarComponentes();
        IniciarComponentes1();

        maps_tela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(arvore.this,MainActivity.class);
                startActivity(intent);

            }
        });


        voltararvore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(arvore.this,telaprincipal.class);
                startActivity(intent);

            }
        });
    }
    private void IniciarComponentes1(){
        maps_tela = findViewById(R.id.maps_tela);
    }


    private void IniciarComponentes(){
        voltararvore = findViewById(R.id.voltararvore);
    }


}
