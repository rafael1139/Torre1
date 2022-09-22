package com.example.torre;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Tela_Principal extends AppCompatActivity {

    private Button bt_deslogar,bt_visualizar;
    private String[] placas = new String[]{"Frota", "QME5781", "QME5782", "QME5784", "QMD4351","QMD4527","QMD4533","QMD5674","QMD7717","QMD7722","QMD7723","QMD7731"
            ,"QMD7767","QMD7772","QMD7864","QMD7865","QMD7866","QMD7867","QMD9946","QMD9954","QMD9963","QMD9971","QMD9973","OUZ2065","OUZ8654","OZP8845","OZM6747"
            ,"OZS0246","OZV0945","OZV7471","JRL7073","NYH5704","PJB6124","QME6691","QME6703","QME6662","QME6674"};
    private Spinner sp;
    private TextView nomeuser;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String usuarioID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        IniciarComponente();

        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Tela_Principal.this, FormLogin.class);
                startActivity(intent);
                finish();
            }
        });
        bt_visualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Tela_Principal.this, Userlist.class));
                finish();
            }
        });



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, placas);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_multiple_choice);

        sp = (Spinner) findViewById(R.id.spinner);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 1) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QME5781.class);
                    startActivity(intent);
                    finish();
                } else if (position == 2) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QME5782.class);
                    startActivity(intent);
                    finish();
                } else if (position == 3) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QME5784.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 4) {
                Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QMD4351.class);
                startActivity(intent);
                finish();
                }  else if (position == 5) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QMD4527.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 6) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QMD4533.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 7) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QMD5674.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 8) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QMD7717.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 9) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QMD7722.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 10) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QMD7723.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 11) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QMD7731.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 12) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QMD7767.class);
                    startActivity(intent);
                    finish();
                } else if (position == 13) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QMD7772.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 14) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QMD7864.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 15) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QMD7865.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 16) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QMD7866.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 17) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QMD7867.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 18) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QMD9946.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 19) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QMD9954.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 20) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QMD9963.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 21) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QMD9971.class);
                    startActivity(intent);
                    finish();
                } else if (position == 22) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QMD9973.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 23) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_OUZ2065.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 24) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_OUZ8654.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 25) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_OZP8845.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 26) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_OZM6747.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 27) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_OZS0246.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 28) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_OZV0945.class);
                    startActivity(intent);
                    finish();
                } else if (position == 29) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_OZV7471.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 30) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_JRL7073.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 31) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_NYH5704.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 32) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_PJB6124.class);
                    startActivity(intent);
                    finish();
                }
                else if (position == 33) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QME6691.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 34) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QME6703.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 35) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QME6662.class);
                    startActivity(intent);
                    finish();
                }  else if (position == 36) {
                    Intent intent = new Intent(Tela_Principal.this, Tela_Principal_QME6674.class);
                    startActivity(intent);
                    finish();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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

    private void IniciarComponente () {
            bt_deslogar = findViewById(R.id.bt_deslogar);
            bt_visualizar = findViewById(R.id.bt_visualizar);
            nomeuser = findViewById(R.id.text_nomeuser);
        }
    }
