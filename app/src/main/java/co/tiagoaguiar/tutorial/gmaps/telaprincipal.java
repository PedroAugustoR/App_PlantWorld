package co.tiagoaguiar.tutorial.gmaps;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class telaprincipal extends AppCompatActivity {

    private TextView nomeUsuario,emailUsuario;
    private Button botao_deslogar;
    private Button botaoplantar;
    private TextView sup;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String usuarioID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telaprincipal);

        getSupportActionBar().hide();

        IniciarComponentes();
        IniciarComponents1();
        IniciarComponentes2();

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(telaprincipal.this,suport.class);
                startActivity(intent);

            }
        });

        botaoplantar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(telaprincipal.this,arvore.class);
                startActivity(intent);
            }
        });

        botao_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(telaprincipal.this,loginjava.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Usuarios").document(usuarioID);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if(documentSnapshot != null){
                    nomeUsuario.setText(documentSnapshot.getString("nome"));
                    emailUsuario.setText(email);
                }
            }
        });
    }
    private void IniciarComponents1(){
        botaoplantar = findViewById(R.id.botaoplantar);
    }
    private void IniciarComponentes(){
        nomeUsuario = findViewById(R.id.textNomeUsuario);
        emailUsuario = findViewById(R.id.textEmailUsuario);
        botao_deslogar = findViewById(R.id.botao_deslogar);

    }
    private void IniciarComponentes2(){
        sup = findViewById(R.id.sup);

    }



}