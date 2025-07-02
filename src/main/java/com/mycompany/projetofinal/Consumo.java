package com.mycompany.projetofinal;

import java.time.LocalDateTime;

public class Consumo {
    private LocalDateTime dataHora;
    private float valor;

    public Consumo() {
        this.dataHora = LocalDateTime.now();
    }

    public Consumo(float valor) {
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
    }

    public Consumo(LocalDateTime dataHora, float valor) {
        this.dataHora = dataHora;
        this.valor = valor;
    }

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
