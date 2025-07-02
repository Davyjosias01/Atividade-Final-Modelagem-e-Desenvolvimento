package com.mycompany.projetofinal;

import java.util.UUID;

public class Usuario {
    //ATRIBUTOS
    private String nome;
    private String email;
    private String senha;
    private UUID id;

    //CONSTRUTORES
    public Usuario(String nome, String email, String senha) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {
        this.id = UUID.randomUUID();
    }

    //GETTERS E SETTERS
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //MÉTODOS
    public void visualizarInformacoes() {
        System.out.println("Id: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Email: " + this.email);
    }
}
