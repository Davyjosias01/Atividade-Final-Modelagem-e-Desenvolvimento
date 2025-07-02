package com.mycompany.projetofinal;

public class Alerta {
    //ATRIBUTOS
    private float limite;
    private String tipo;

    //CONSTRUTORES
    public Alerta() {}

    public Alerta(float limite, String tipo) {
        this.limite = limite;
        this.tipo = tipo;
    }

    //GETTERS E SETTERS
    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //MÉTODOS
    public boolean alertaExcedido(float consumoAtual) {
        return consumoAtual > limite;
    }
}
