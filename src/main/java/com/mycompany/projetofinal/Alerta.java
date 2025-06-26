package com.mycompany.projetofinal;

public class Alerta {
    //ATRIBUTOS DA CLASSE
    private float limite;
    private String tipo;

    //CONSTRUTORES
    public Alerta(float limite, String tipo) {
        this.limite = limite;
        this.tipo = tipo;
    }
    public Alerta(){}

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
    public boolean alertaExcedido(float valor, float OffSet) {
        if (valor > OffSet){
            return true;
        }else {
            return false;
        }
    }
}
