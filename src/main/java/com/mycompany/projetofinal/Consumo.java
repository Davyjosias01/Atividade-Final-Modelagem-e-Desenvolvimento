package com.mycompany.projetofinal;

import java.time.LocalDateTime;

public class Consumo {
    //ATRIBUTOS
    private LocalDateTime dataHora;
    private float valor;

    //CONSTRUTORES
    public Consumo(float valor) {
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
    }

    public Consumo() {}

    public Consumo(LocalDateTime dataHora, float valor) {
        this.dataHora = dataHora;
        this.valor = valor;
    }

    //GETTERS E SETTERS
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
