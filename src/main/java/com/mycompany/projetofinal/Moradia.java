package com.mycompany.projetofinal;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Moradia {
    //ATRIBUTOS
    private UUID id;
    private int numero;
    private String bloco;
    private List<Morador> moradores = new ArrayList<>();
    private List<Dispositivo> dispositivos = new ArrayList<>();

    //CONSTRUTORES
    public Moradia() {
        this.id = UUID.randomUUID();
    }

    public Moradia(UUID id, int numero, String bloco){
        this.id = id;
        this.numero = numero;
        this.bloco = bloco;
    }

    //GETTERS E SETTERS
    public UUID getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public List<Morador> getMoradores() {
        return moradores;
    }

    //MÉTODOS
    public void addMorador(Morador morador) {
        morador.setMoradia(this);
        moradores.add(morador);
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void adicionaDispositivo(Dispositivo dispositivo) {
        dispositivo.setMoradia(this);
        dispositivos.add(dispositivo);
    }

    public float getConsumoTotal() {
        float total = 0;
        for (Dispositivo d : dispositivos) {
            Consumo atual = d.getConsumoAtual();
            if (atual != null) total += atual.getValor();
        }
        return total;
    }
}
