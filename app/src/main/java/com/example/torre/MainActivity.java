package com.example.torre;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    Button bt_deslogar,bt_visualizar;
    EditText pneu_dd, pneu_de, pneu_trd1, pneu_trd2,pneu_trd3,pneu_trd4, pneu_tre1, pneu_tre2, pneu_tre3, pneu_tre4, text_title_veiculo, edit_saida_de,
            edit_saida_dd, edit_saida_tre1,edit_saida_tre2,edit_saida_tre3,edit_saida_tre4, edit_saida_trd1, edit_saida_trd2, edit_saida_trd3, edit_saida_trd4,
            mDisplayDate, text_nomeuser;
    DatabaseReference databaseUsers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_deslogar = findViewById(R.id.bt_deslogar);
        bt_visualizar =  findViewById(R.id.bt_visualizar);
        pneu_dd = findViewById(R.id.pneu_dd);
        pneu_de = findViewById(R.id.pneu_de);
        databaseUsers = FirebaseDatabase.getInstance().getReference();

        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertData();
            }
        });

        bt_visualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Userlist.class));
                finish();
            }
        });


    }

    private void InsertData() {
        String pneu_DD = pneu_dd.getText().toString();
        String pneu_DE = pneu_de.getText().toString();
        String pneu_TRD1 = pneu_trd1.getText().toString();
        String pneu_TRD2 = pneu_trd2.getText().toString();
        String pneu_TRD3 = pneu_trd3.getText().toString();
        String pneu_TRD4 = pneu_trd4.getText().toString();
        String pneu_TRE1 = pneu_tre1.getText().toString();
        String pneu_TRE2 = pneu_tre2.getText().toString();
        String pneu_TRE3 = pneu_tre3.getText().toString();
        String pneu_TRE4 = pneu_tre4.getText().toString();
        String placa = text_title_veiculo.getText().toString();
        String saida_de = edit_saida_de.getText().toString();
        String saida_dd = edit_saida_dd.getText().toString();
        String saida_tre1 = edit_saida_tre1.getText().toString();
        String saida_tre2 = edit_saida_tre2.getText().toString();
        String saida_tre3 = edit_saida_tre3.getText().toString();
        String saida_tre4 = edit_saida_tre4.getText().toString();
        String saida_trd1 = edit_saida_trd1.getText().toString();
        String saida_trd2 = edit_saida_trd2.getText().toString();
        String saida_trd3 = edit_saida_trd3.getText().toString();
        String saida_trd4 = edit_saida_trd4.getText().toString();
        String date = mDisplayDate.getText().toString();
        String nome = text_nomeuser.getText().toString();
        String id = databaseUsers.push().getKey();

        User user = new User(pneu_DD, pneu_DE , pneu_TRD1, pneu_TRD2,pneu_TRD3,pneu_TRD4, pneu_TRE1, pneu_TRE2,pneu_TRE3,pneu_TRE4, placa, saida_de, saida_dd,
                saida_tre1, saida_tre2, saida_tre3, saida_tre4, saida_trd1, saida_trd2, saida_trd3, saida_trd4, date, nome);
        databaseUsers.child("Pneus").child(id).setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this, "Aeeeeeeeeee", Toast.LENGTH_SHORT).show();

                        }

                    }
                });
    }

}