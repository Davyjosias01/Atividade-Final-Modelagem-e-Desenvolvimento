package com.mycompany.projetofinal;

import java.util.ArrayList;
import java.util.List;

public class Dispositivo {
    //ATRIBUTOS
    private int id;
    private String nome;
    private String modelo;
    private String tipo;
    private Moradia moradia;
    private List<Consumo> historicoConsumo = new ArrayList<>();
    private float mediaHistoricoDeConsumo;

    //CONSTRUTORES
    public Dispositivo() {}

    public Dispositivo(int id, String nome, String modelo, String tipo) {
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    //GETTERS E SETTERS
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

    public Moradia getMoradia() {
        return moradia;
    }

    public void setMoradia(Moradia moradia) {
        this.moradia = moradia;
    }

    public List<Consumo> getHistoricoConsumo() {
        return historicoConsumo;
    }

    public float getMediaHistoricoDeConsumo() {
        return mediaHistoricoDeConsumo;
    }

    public Consumo getConsumoAtual() {
        if (historicoConsumo.isEmpty()) return null;
        return historicoConsumo.get(historicoConsumo.size() - 1);
    }

    public void setHistoricoConsumo(List<Consumo> historicoConsumo) {
        this.historicoConsumo = historicoConsumo;
    }

    public void setMediaHistoricoDeConsumo(float mediaHistoricoDeConsumo) {
        this.mediaHistoricoDeConsumo = mediaHistoricoDeConsumo;
    }

    //MÉTODOS
    public void registrarConsumo(Consumo consumo) {
        historicoConsumo.add(consumo);
        float soma = 0;
        for (Consumo c : historicoConsumo) soma += c.getValor();
        mediaHistoricoDeConsumo = soma / historicoConsumo.size();
    }

    @Override
    public String toString() {
        return "Dispositivo {id=" + id + ", nome='" + nome + "', modelo='" + modelo + "', tipo='" + tipo + "'}";
    }
}
