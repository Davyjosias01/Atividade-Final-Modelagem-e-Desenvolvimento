
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetofinal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Usuario {
    //ATRIBUTOS
    private String nome;
    private String email;
    private String senha;
    private UUID id;
    List<String> listaUsuarios = new ArrayList<>();

    //Construtores
    public Usuario(String email, String senha, String nome){
        this.id = UUID.randomUUID();
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }
    public Usuario() {}

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
    public void visualizarInformacoes(){
        System.out.println("Id: " + this.id.toString());
        System.out.println("Nome: " + this.nome);
        System.out.println("Email: " + this.email);
    }
}
