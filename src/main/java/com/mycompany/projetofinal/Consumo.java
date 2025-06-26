package com.mycompany.projetofinal;

import java.util.Date;

public class Consumo {
    //ATRIBUTOS
    private Date dataHora;
    private float valor;

    //CONSTRUTORES
    public Consumo(Date dataHora, float valor) {
        this.dataHora = dataHora;
        this.valor = valor;
    }
    public Consumo(){}

    //GETTERS E SETTERS
    public Date getDataHora() {
        return dataHora;
    }
    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }

    //MÉTODOS

}
