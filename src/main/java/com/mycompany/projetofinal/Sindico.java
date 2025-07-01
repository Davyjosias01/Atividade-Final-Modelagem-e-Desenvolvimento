package com.mycompany.projetofinal;

import java.util.List;

public class Sindico extends Usuario {
    public Sindico(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public Sindico() {}

    public String cadastrarUsuario(String nome, String email, String senha) {
        return "Usuário cadastrado com sucesso: " + nome;
    }
}