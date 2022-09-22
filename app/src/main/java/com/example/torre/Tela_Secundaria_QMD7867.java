package com.example.torre;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Tela_Secundaria_QMD7867 extends AppCompatActivity {


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private TextView edit_dd,edit_de,edit_tr_dd1,edit_tr_dd2,edit_tr_dd3,edit_tr_dd4,edit_tr_de1,edit_tr_de2,edit_tr_de3,edit_tr_de4,data,nome;
    private Button bt_voltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_secundaria_qmd7867);
        IniciarComponente();


        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Tela_Secundaria_QMD7867.this, Tela_Principal.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();


        DocumentReference documentReference = db.collection("Pneus").document("QMD7867");
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {

                edit_dd.setText(documentSnapshot.getString("pneu_DD"));
                edit_de.setText(documentSnapshot.getString("pneu_DE"));
                edit_tr_dd1.setText(documentSnapshot.getString("pneu_TRD1"));
                edit_tr_dd2.setText(documentSnapshot.getString("pneu_TRD2"));
                edit_tr_dd3.setText(documentSnapshot.getString("pneu_TRD3"));
                edit_tr_dd4.setText(documentSnapshot.getString("pneu_TRD4"));
                edit_tr_de2.setText(documentSnapshot.getString("pneu_TRE1"));
                edit_tr_de1.setText(documentSnapshot.getString("pneu_TRE2"));
                edit_tr_de4.setText(documentSnapshot.getString("pneu_TRE3"));
                edit_tr_de3.setText(documentSnapshot.getString("pneu_TRE4"));
                data.setText(documentSnapshot.getString("data"));
                nome.setText(documentSnapshot.getString("nome"));

            }
        });
        edit_dd = findViewById(R.id.edit_dd_dd);
        edit_de = findViewById(R.id.edit_dd_de);
        edit_tr_dd1 = findViewById(R.id.edit_tr_dd1);
        edit_tr_dd2 = findViewById(R.id.edit_tr_dd2);
        edit_tr_dd3 = findViewById(R.id.edit_tr_dd3);
        edit_tr_dd4 = findViewById(R.id.edit_tr_dd4);
        edit_tr_de1 = findViewById(R.id.edit_tr_de1);
        edit_tr_de2 = findViewById(R.id.edit_tr_de2);
        edit_tr_de3 = findViewById(R.id.edit_tr_de3);
        edit_tr_de4 = findViewById(R.id.edit_tr_de4);
        data = findViewById(R.id.data);
        nome = findViewById(R.id.nome);


    }
    private void IniciarComponente(){
        bt_voltar = findViewById(R.id.bt_voltar);
    }
}
