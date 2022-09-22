package com.example.torre;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Tela_Principal_QMD4351 extends AppCompatActivity {

    private Button bt_deslogar,bt_confirmar,bt_pneu_atual;
    private static final String TAG = "Tela_Principal_QMD4351";
    private TextView nomeuser, edit_dd,edit_de,edit_tre1,edit_tre2,edit_tre3,edit_tre4,edit_trd1,edit_trd2,edit_trd3,edit_trd4,mDisplayDate,
            edit_saida_dd,edit_saida_de,edit_saida_tre1,edit_saida_tre2,edit_saida_tre3,edit_saida_tre4,edit_saida_trd1,edit_saida_trd2,edit_saida_trd3,edit_saida_trd4,
            text_title_veiculo, text_nomeuser;
    String[] mensagens = {"Cadastro realizado com sucesso!","Por favor, inserir todos os pneus."};
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String usuarioID;
    DatabaseReference databaseUsers;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal_qmd4351);
        mDisplayDate = (TextView) findViewById(R.id.tvDate);

        IniciarComponente();


        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Tela_Principal_QMD4351.this, Tela_Principal.class);
                startActivity(intent);
                finish();

            }

        });
        bt_pneu_atual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Tela_Principal_QMD4351.this, Tela_Secundaria_QMD4351.class);
                startActivity(intent);
                finish();

            }


        });
        bt_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pneu_dd = edit_dd.getText().toString();
                String pneu_de = edit_de.getText().toString();
                String pneu_trd1 = edit_trd1.getText().toString();
                String pneu_trd2 = edit_trd2.getText().toString();
                String pneu_tre1 = edit_tre1.getText().toString();
                String pneu_tre2 = edit_tre2.getText().toString();
                String date = mDisplayDate.getText().toString();



                if (pneu_dd.isEmpty() || pneu_de.isEmpty() || pneu_trd1.isEmpty()|| pneu_trd2.isEmpty()|| pneu_tre1.isEmpty()|| pneu_tre2.isEmpty() || date.isEmpty() ){
                    Snackbar snackbar = Snackbar.make(v,mensagens[1],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();



                }else{
                    SalvarDadosUsuario(v);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(Tela_Principal_QMD4351.this, Tela_Secundaria_QMD4351.class);
                            startActivity(intent);
                            finish();

                        }
                    },2000);

                }
            }
        });
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Tela_Principal_QMD4351.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month +1;
                Log.d(TAG, "onDateSet: date: " + year + "/"+ month + "/"+ day + "/");

                String date = day + "/" + month + "/" + year;
                mDisplayDate.setText(date);
            }
        };


    }

    private void SalvarDadosUsuario(View v){
        String pneu_dd = edit_dd.getText().toString();
        String pneu_de = edit_de.getText().toString();
        String pneu_trd1 = edit_trd1.getText().toString();
        String pneu_trd2 = edit_trd2.getText().toString();
        String pneu_trd3 = edit_trd3.getText().toString();
        String pneu_trd4 = edit_trd4.getText().toString();
        String pneu_tre1 = edit_tre1.getText().toString();
        String pneu_tre2 = edit_tre2.getText().toString();
        String pneu_tre3 = edit_tre3.getText().toString();
        String pneu_tre4 = edit_tre4.getText().toString();
        String date = mDisplayDate.getText().toString();
        String pneu_saida_dd = edit_saida_dd.getText().toString();
        String pneu_saida_de = edit_saida_de.getText().toString();
        String pneu_saida_trd1 = edit_saida_trd1.getText().toString();
        String pneu_saida_trd2 = edit_saida_trd2.getText().toString();
        String pneu_saida_trd3 = edit_saida_trd3.getText().toString();
        String pneu_saida_trd4 = edit_saida_trd4.getText().toString();
        String pneu_saida_tre1 = edit_saida_tre1.getText().toString();
        String pneu_saida_tre2 = edit_saida_tre2.getText().toString();
        String pneu_saida_tre3 = edit_saida_tre3.getText().toString();
        String pneu_saida_tre4 = edit_saida_tre4.getText().toString();
        String placa = text_title_veiculo.getText().toString();
        String nome = text_nomeuser.getText().toString();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String,Object> usuarios = new HashMap<>();
        usuarios.put("pneu_DD",pneu_dd);
        usuarios.put("pneu_DE",pneu_de);
        usuarios.put("pneu_TRD1",pneu_trd1);
        usuarios.put("pneu_TRD2",pneu_trd2);
        usuarios.put("pneu_TRD3",pneu_trd3);
        usuarios.put("pneu_TRD4",pneu_trd4);
        usuarios.put("pneu_TRE1",pneu_tre1);
        usuarios.put("pneu_TRE2",pneu_tre2);
        usuarios.put("pneu_TRE3",pneu_tre3);
        usuarios.put("pneu_TRE4",pneu_tre4);
        usuarios.put("data",date);
        usuarios.put("pneu_saida_DD",pneu_saida_dd);
        usuarios.put("pneu_saida_DE",pneu_saida_de);
        usuarios.put("pneu_saida_TRD1",pneu_saida_trd1);
        usuarios.put("pneu_saida_TRD2",pneu_saida_trd2);
        usuarios.put("pneu_saida_TRD3",pneu_saida_trd3);
        usuarios.put("pneu_saida_TRD4",pneu_saida_trd4);
        usuarios.put("pneu_saida_TRE1",pneu_saida_tre1);
        usuarios.put("pneu_saida_TRE2",pneu_saida_tre2);
        usuarios.put("pneu_saida_TRE3",pneu_saida_tre3);
        usuarios.put("pneu_saida_TRE4",pneu_saida_tre4);
        usuarios.put("placa", placa);
        usuarios.put("nome", nome);


        String id = databaseUsers.push().getKey();

        User user = new User(pneu_dd, pneu_de, pneu_trd1, pneu_trd2, pneu_trd3, pneu_trd4, pneu_tre1, pneu_tre2, pneu_tre3, pneu_tre4, placa,pneu_saida_de,
                pneu_saida_dd, pneu_saida_tre1, pneu_saida_tre2, pneu_saida_tre3, pneu_saida_tre4, pneu_saida_trd1, pneu_saida_trd2,pneu_saida_trd3,
                pneu_saida_trd4, date, nome);
        databaseUsers.child("Pneus").child(id).setValue(user);



        DocumentReference documentReference = db.collection("Pneus").document("QMD4351");
        documentReference.set(usuarios).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {


                Snackbar snackbar = Snackbar.make(v,mensagens[0],Snackbar.LENGTH_SHORT);
                snackbar.setBackgroundTint(Color.WHITE);
                snackbar.setTextColor(Color.BLACK);
                snackbar.show();




            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();

        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Usuarios").document(usuarioID);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if(documentSnapshot != null){
                    nomeuser.setText(documentSnapshot.getString("nome"));
                }

            }
        });

    }


    private void IniciarComponente(){
        bt_deslogar = findViewById(R.id.bt_deslogar);
        nomeuser = findViewById(R.id.text_nomeuser);
        edit_dd = findViewById(R.id.edit_dd);
        edit_de = findViewById(R.id.edit_de);
        bt_confirmar = findViewById(R.id.bt_confirmar);
        bt_pneu_atual = findViewById(R.id.bt_pneu_atual);
        edit_trd1 = findViewById(R.id.edit_trd1);
        edit_trd2 = findViewById(R.id.edit_trd2);
        edit_trd3 = findViewById(R.id.edit_trd3);
        edit_trd4 = findViewById(R.id.edit_trd4);
        edit_tre1 = findViewById(R.id.edit_tre1);
        edit_tre2 = findViewById(R.id.edit_tre2);
        edit_tre3 = findViewById(R.id.edit_tre3);
        edit_tre4 = findViewById(R.id.edit_tre4);
        edit_saida_trd1 = findViewById(R.id.edit_saida_trd1);
        edit_saida_trd2 = findViewById(R.id.edit_saida_trd2);
        edit_saida_trd3 = findViewById(R.id.edit_saida_trd3);
        edit_saida_trd4 = findViewById(R.id.edit_saida_trd4);
        edit_saida_tre1 = findViewById(R.id.edit_saida_tre1);
        edit_saida_tre2 = findViewById(R.id.edit_saida_tre2);
        edit_saida_tre3 = findViewById(R.id.edit_saida_tre3);
        edit_saida_tre4 = findViewById(R.id.edit_saida_tre4);
        edit_saida_dd = findViewById(R.id.edit_saida_dd);
        edit_saida_de = findViewById(R.id.edit_saida_de);
        databaseUsers = FirebaseDatabase.getInstance().getReference();
        text_title_veiculo = findViewById(R.id.text_title_veiculo);
        text_nomeuser = findViewById(R.id.text_nomeuser);
    }
}