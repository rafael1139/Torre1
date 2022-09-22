package com.example.torre;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    private String pneu_dd;
    private String pneu_de;
    private String pneu_trd1;
    private String pneu_trd2;
    private String pneu_trd3;
    private String pneu_trd4;
    private String pneu_tre1;
    private String pneu_tre2;
    private String pneu_tre3;
    private String pneu_tre4;
    private String placa;
    private String pneu_saida_de;
    private String pneu_saida_dd;
    private String pneu_saida_tre1;
    private String pneu_saida_tre2;
    private String pneu_saida_tre3;
    private String pneu_saida_tre4;
    private String pneu_saida_trd1;
    private String pneu_saida_trd2;
    private String pneu_saida_trd3;
    private String pneu_saida_trd4;
    private String date;
    private String nome;

    public String getKey() {
        return null;
    }
    public String getRef(int position) {
        return null;
    }

    public User() {
    }


    public String getPneu_dd() {
        return pneu_dd;
    }

    public String getPneu_de() {
        return pneu_de;
    }

    public String getPneu_trd1() {
        return pneu_trd1;
    }

    public String getPneu_trd2() {
        return pneu_trd2;
    }

    public String getPneu_tre1() {
        return pneu_tre1;
    }

    public String getPneu_tre2() {
        return pneu_tre2;
    }

    public String getPlaca() {
        return placa;
    }

    public String getPneu_saida_de() {
        return pneu_saida_de;
    }

    public String getPneu_saida_dd() {
        return pneu_saida_dd;
    }

    public String getPneu_saida_tre1() {
        return pneu_saida_tre1;
    }

    public String getPneu_saida_tre2() {
        return pneu_saida_tre2;
    }

    public String getPneu_saida_trd1() {
        return pneu_saida_trd1;
    }

    public String getPneu_saida_trd2() {
        return pneu_saida_trd2;
    }

    public String getDate() {
        return date;
    }

    public String getNome() {
        return nome;
    }

    public User(String pneu_dd, String pneu_de, String pneu_trd1, String pneu_trd2, String pneu_trd3, String pneu_trd4, String pneu_tre1, String pneu_tre2,
                String pneu_tre3, String pneu_tre4, String text_title_veiculo, String pneu_saida_de, String pneu_saida_dd, String pneu_saida_tre1,
                String pneu_saida_tre2, String pneu_saida_tre3, String pneu_saida_tre4, String pneu_saida_trd1, String pneu_saida_trd2, String pneu_saida_trd3,
                String pneu_saida_trd4, String mDisplayDate, String text_nomeuser1) {
        this.pneu_dd = pneu_dd;
        this.pneu_de = pneu_de;
        this.pneu_trd1 = pneu_trd1;
        this.pneu_trd2 = pneu_trd2;
        this.pneu_trd3 = pneu_trd3;
        this.pneu_trd4 = pneu_trd4;
        this.pneu_tre1 = pneu_tre1;
        this.pneu_tre2 = pneu_tre2;
        this.pneu_tre3 = pneu_tre3;
        this.pneu_tre4 = pneu_tre4;
        this.placa = text_title_veiculo;
        this.pneu_saida_de = pneu_saida_de;
        this.pneu_saida_dd = pneu_saida_dd;
        this.pneu_saida_tre1 = pneu_saida_tre1;
        this.pneu_saida_tre2 = pneu_saida_tre2;
        this.pneu_saida_tre3 = pneu_saida_tre3;
        this.pneu_saida_tre4 = pneu_saida_tre4;
        this.pneu_saida_trd1 = pneu_saida_trd1;
        this.pneu_saida_trd2 = pneu_saida_trd2;
        this.pneu_saida_trd3 = pneu_saida_trd3;
        this.pneu_saida_trd4 = pneu_saida_trd4;
        this.date = mDisplayDate;
        this.nome = text_nomeuser1;


    }

}
