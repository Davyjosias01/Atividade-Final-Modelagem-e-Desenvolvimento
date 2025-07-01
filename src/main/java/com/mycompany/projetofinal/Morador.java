package com.mycompany.projetofinal;

import java.util.ArrayList;
import java.util.List;

public class Morador extends Usuario {
    private List<Alerta> alertas = new ArrayList<>();

    public Morador(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public Morador() {}

    public void defineAlerta(float limite, String tipo) {
        alertas.add(new Alerta(limite, tipo));
    }

    public List<Alerta> getAlertas() {
        return alertas;
    }

    public void receberNotificacao(String mensagem) {
        System.out.println("[Alerta] " + mensagem);
    }
}