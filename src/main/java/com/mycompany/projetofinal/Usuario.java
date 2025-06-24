
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetofinal;
import java.util.UUID;



public class Usuario {
    private String email;
    private String senha;
    private UUID id;

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

    //Construtores
    public Usuario(String email, String senha){
        this.id = UUID.randomUUID();
        this.email = email;
        this.senha = senha;
    }
    public Usuario() {}

    public void visualizarInformacoes(){
        System.out.println("Id: " + this.id.toString());
        System.out.println("Email: " + this.email);
    }
}
