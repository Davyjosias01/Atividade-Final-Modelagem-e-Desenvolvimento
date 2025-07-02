package com.mycompany.projetofinal;

import java.util.ArrayList;
import java.util.List;

public class Morador extends Usuario {
    //MÉTODOS
    private List<Alerta> alertas = new ArrayList<>();
    private Moradia moradia;

    //CONSTRUTORES
    public Morador(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public Morador() {}

    //GETTERS E SETTERS
    public List<Alerta> getAlertas() {
        return alertas;
    }

    public Moradia getMoradia() {
        return moradia;
    }

    public void setMoradia(Moradia moradia) {
        this.moradia = moradia;
    }

    //MÉTODOS
    public void defineAlerta(float limite, String tipo) {
        alertas.add(new Alerta(limite, tipo));
    }

    public void receberNotificacao(String mensagem) {
        System.out.println("[Alerta] " + mensagem);
    }
}
