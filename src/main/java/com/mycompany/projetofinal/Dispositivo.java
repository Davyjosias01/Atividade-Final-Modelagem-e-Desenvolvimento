package com.mycompany.projetofinal;

import java.util.List;

public class Dispositivo {
    private int id;
    private String nome;
    private String modelo;
    private String tipo;
    private String moradia;
    private List<Consumo> historicoConsumo;
    private float mediaHistoricoDeConsumo;

    //GETTERS N SETTERS
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMoradia() {
        return moradia;
    }
    public void setMoradia(String moradia) {
        this.moradia = moradia;
    }

    public List<Consumo> getHistoricoConsumo() {
        return historicoConsumo;
    }
    public void setHistoricoConsumo(List<Consumo> historicoConsumo) {
        this.historicoConsumo = historicoConsumo;
    }
    
    
    //CONSTRUTORES
    public Dispositivo(int id, String nome, String modelo, String tipo, String moradia, List<Consumo> historicoConsumo) {
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
        this.tipo = tipo;
        this.moradia = moradia;
        this.historicoConsumo = historicoConsumo;
    }
    public Dispositivo(){}
    
    
    //METODOS
    public void registrarConsumo(Consumo consumo){
        historicoConsumo.add(consumo);
        mediaHistoricoDeConsumo = ((mediaHistoricoDeConsumo+consumo.getValor())/2);
    }
    
    public Consumo getConsumoAtual(){
        return historicoConsumo.getFirst();
    }
}
