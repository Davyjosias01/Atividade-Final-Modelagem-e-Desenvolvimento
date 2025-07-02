package com.mycompany.projetofinal;

public class Alerta {
    private float limite;
    private String tipo;

    public Alerta() {}

    public Alerta(float limite, String tipo) {
        this.limite = limite;
        this.tipo = tipo;
    }

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

    public boolean alertaExcedido(float consumoAtual) {
        return consumoAtual > limite;
    }
}
