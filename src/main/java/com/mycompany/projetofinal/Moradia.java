package com.mycompany.projetofinal;

import java.util.List;
import java.util.UUID;


public class Moradia {
    private UUID id;
    private int numero;
    private String bloco;
    private List<Morador> moradores;
    private List<Dispositivo> dispositivos;
    
    //CONSTRUCTORS
    public Moradia(int numero, String bloco, List<Morador> moradores){
        this.id = UUID.randomUUID();
        this.numero = numero;
        this.bloco = bloco;
        this.moradores = moradores;
    }
    public Moradia(UUID id, int numero, String bloco) {
        this.id = id;
        this.numero = numero;
        this.bloco = bloco;
    }
    public Moradia() {
        this.id = UUID.randomUUID();
    }

    //GETTERS N SETTERS
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
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
    public void setMoradores(List<Morador> moradores) {
        this.moradores = moradores;
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }
    public void setDispositivos(List<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }
    
    //METODOS
    public void adicionaDispositivo(Dispositivo dispositivo){
        this.dispositivos.add(dispositivo);
    }
    
    
    
}
