/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetofinal;

import java.util.List;

public class Sindico extends Usuario{
    //ATRIBUTOS
    

    //CONSTRUTORES
    public Sindico(String email, String senha, String nome) {
        super(email, senha, nome);
    }
    public Sindico() {
    }

    //MÉTODOS
    public String cadastrarDispositivo(String dispositivo){
        return dispositivo;
    }

    public String cadastrarMoradia(String moradia){
        return moradia;
    }

    public String cadastrarUsuario(String nome, String email, String senha){
        super.setNome(nome);
        super.setEmail(email);
        super.setSenha(senha);
        return "Usuário cadastrado com sucesso!";
    }

    public List<String> listarUsuario(){
        return listaUsuarios;
    }

    /*
    public List<String> listarDispositivo(){
        return listaDispositivos;
    }
    */
}
