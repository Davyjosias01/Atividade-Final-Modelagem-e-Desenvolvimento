package com.mycompany.projetofinal;

import java.util.ArrayList;
import java.util.List;

public class Morador extends Usuario{
    //ATRIBUTOS
    private List<Alerta> alerta;
    
    //CONSTRUTORES
    public Morador (String nome, String email, String senha, List<Alerta> alertas){
        super(nome, email, senha);
        this.alerta = alertas;
    }
    public Morador(){}
    
    //DUAS FUNÇÕES COM ASSINATURAS DIFERENTES
    public void defineAlerta(Float limite, String tipo){
        Alerta a = new Alerta(limite, tipo);
        alerta.add(a);
    }
    public void defineAlerta(Alerta a){
        alerta.add(a);
    }
    
    public List<Consumo> visualizaConsumo(Dispositivo dispositivo){
        return dispositivo.getHistoricoConsumo();
    }
    
    public void receberNotificacao(String mensagem){
        System.out.println(mensagem);
    }
}
