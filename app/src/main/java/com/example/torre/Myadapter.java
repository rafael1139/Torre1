package com.example.torre;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {
    Context context;
    String databaseReference;
    ArrayList<User> list;
    List<String> keys;
    private Myadapter query;

    public Myadapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = list.get(position);
        holder.pneu_dd.setText(user.getPneu_dd());
        holder.pneu_de.setText(user.getPneu_de());
        holder.pneu_trd1.setText(user.getPneu_trd1());
        holder.pneu_trd2.setText(user.getPneu_trd2());
        holder.pneu_tre1.setText(user.getPneu_tre1());
        holder.pneu_tre2.setText(user.getPneu_tre2());
        holder.placa.setText(user.getPlaca());
        holder.pneu_saida_de.setText(user.getPneu_saida_de());
        holder.pneu_saida_dd.setText(user.getPneu_saida_dd());
        holder.pneu_saida_tre1.setText(user.getPneu_saida_tre1());
        holder.pneu_saida_tre2.setText(user.getPneu_saida_tre2());
        holder.pneu_saida_trd1.setText(user.getPneu_saida_trd1());
        holder.pneu_saida_trd2.setText(user.getPneu_saida_trd2());
        holder.date.setText(user.getDate());
        holder.nome.setText(user.getNome());

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.nome.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true,1200)
                        .create();

                //dialogPlus.show();

                View view = dialogPlus.getHolderView();

                EditText pneu_dd = view.findViewById(R.id.txtPneu_dd);
                EditText pneu_de = view.findViewById(R.id.txtPneu_de);
                EditText pneu_tre1 = view.findViewById(R.id.txtPneu_tre1);
                EditText pneu_tre2 = view.findViewById(R.id.txtPneu_tre2);
                EditText pneu_trd1 = view.findViewById(R.id.txtPneu_trd1);
                EditText pneu_trd2 = view.findViewById(R.id.txtPneu_trd2);

                Button btnUpdate = view.findViewById(R.id.btnUpdate);

                pneu_dd.setText(user.getPneu_dd());
                pneu_de.setText(user.getPneu_de());
                pneu_tre1.setText(user.getPneu_tre1());
                pneu_tre2.setText(user.getPneu_tre2());
                pneu_trd1.setText(user.getPneu_trd1());
                pneu_trd2.setText(user.getPneu_trd2());

                dialogPlus.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("pneu_dd", pneu_dd.getText().toString());
                        map.put("pneu_de", pneu_de.getText().toString());
                        map.put("pneu_tre1", pneu_tre1.getText().toString());
                        map.put("pneu_tre2", pneu_tre2.getText().toString());
                        map.put("pneu_trd1", pneu_trd1.getText().toString());
                        map.put("pneu_trd2", pneu_tre2.getText().toString());


                   FirebaseDatabase.getInstance().getReference("Pneus");



                    }
                });
            }
        });
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.pneu_dd.getContext());
                builder.setTitle("Deseja excluir?");
                builder.setMessage("Pressione ''Delete'' parara continuar.");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        FirebaseDatabase.getInstance().getReference().child("Pneus");

                    }


                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.pneu_dd.getContext(), "Operação cancelada.", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.show();
            }

        });


    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    public void onCreateViewHolder(){

    }
    public void remove(RecyclerView.ViewHolder viewHolder) {

    }

    public void deleteItem(int adapterPosition) {

    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView pneu_dd,pneu_de, pneu_trd1, pneu_trd2, pneu_trd3, pneu_trd4, pneu_tre1, pneu_tre2, pneu_tre3, pneu_tre4, placa, pneu_saida_de,
                pneu_saida_dd, pneu_saida_tre1, pneu_saida_tre2, pneu_saida_tre3, pneu_saida_tre4, pneu_saida_trd1, pneu_saida_trd2, pneu_saida_trd3, pneu_saida_trd4
                , date, nome;
        Button btnEdit, btnDelete;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            pneu_dd = itemView.findViewById(R.id.text_entrada_dd);
            pneu_de = itemView.findViewById(R.id.text_entrada_de);
            pneu_trd1 = itemView.findViewById(R.id.text_entrada_trd1);
            pneu_trd2 = itemView.findViewById(R.id.text_entrada_trd2);
            pneu_tre1 = itemView.findViewById(R.id.text_entrada_tre1);
            pneu_tre2 = itemView.findViewById(R.id.text_entrada_tre2);
            placa = itemView.findViewById(R.id.placa);
            pneu_saida_de = itemView.findViewById(R.id.text_saida_de);
            pneu_saida_dd = itemView.findViewById(R.id.text_saida_dd);
            pneu_saida_tre1 = itemView.findViewById(R.id.text_saida_tre1);
            pneu_saida_tre2 = itemView.findViewById(R.id.text_saida_tre2);
            pneu_saida_trd1 = itemView.findViewById(R.id.text_saida_trd1);
            pneu_saida_trd2 = itemView.findViewById(R.id.text_saida_trd2);
            date = itemView.findViewById(R.id.text_data);
            nome = itemView.findViewById(R.id.text_nomeuser1);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);

        }
    }
}
