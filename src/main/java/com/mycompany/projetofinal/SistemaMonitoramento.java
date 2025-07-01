package com.mycompany.projetofinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaMonitoramento {

    private List<Morador> moradores = new ArrayList<>();
    private List<Dispositivo> dispositivos = new ArrayList<>();
    private List<Moradia> moradias = new ArrayList<>();
    private List<Alerta> alertas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void registrarDispositivo() {
        System.out.print("ID: ");
        int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();
        Dispositivo d = new Dispositivo(id, nome, modelo, tipo);
        dispositivos.add(d);
        System.out.println("Dispositivo cadastrado com sucesso.");
    }

    public void registrarMorador() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        Morador m = new Morador(nome, email, senha);
        moradores.add(m);
        System.out.println("Morador cadastrado.");
    }

    public void registrarSindico() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        Sindico s = new Sindico(email, senha, nome);
        System.out.println("Síndico registrado (não armazenado na lista).");
    }

    public void registrarAlerta() {
        System.out.print("Tipo do dispositivo: ");
        String tipo = scanner.nextLine();
        System.out.print("Limite de consumo: ");
        float limite = scanner.nextFloat(); scanner.nextLine();
        Alerta alerta = new Alerta(limite, tipo);
        alertas.add(alerta);
        System.out.println("Alerta registrado.");
    }

    public void registrarMoradia() {
        System.out.print("Número da moradia: ");
        int numero = scanner.nextInt(); scanner.nextLine();
        System.out.print("Bloco: ");
        String bloco = scanner.nextLine();
        Moradia moradia = new Moradia();
        moradia.setNumero(numero);
        moradia.setBloco(bloco);
        moradias.add(moradia);
        System.out.println("Moradia registrada.");
    }

    public void coletarDados() {
        for (Dispositivo d : dispositivos) {
            registrarConsumo(d, (float) (Math.random() * 10));
        }
        System.out.println("Dados coletados com sucesso para todos os dispositivos.");
    }

    public void processarAlertas() {
        for (Dispositivo d : dispositivos) {
            Consumo atual = d.getConsumoAtual();
            if (atual != null) processarAlerta(d, atual);
        }
    }

    public void carregarInformacoesDispositivos() {
        for (Dispositivo d : dispositivos) {
            System.out.println(d);
        }
    }

    public void carregarAlertas() {
        for (Alerta a : alertas) {
            System.out.println("Alerta para tipo: " + a.getTipo() + ", limite: " + a.getLimite() + " kWh");
        }
    }

    public void registrarConsumo(Dispositivo dispositivo, float valor) {
        Consumo consumo = new Consumo(valor);
        dispositivo.registrarConsumo(consumo);
        processarAlerta(dispositivo, consumo);
    }

    private void processarAlerta(Dispositivo dispositivo, Consumo consumo) {
        for (Morador morador : moradores) {
            for (Alerta alerta : morador.getAlertas()) {
                if (alerta.getTipo().equalsIgnoreCase(dispositivo.getTipo())
                        && alerta.alertaExcedido(consumo.getValor())) {
                    morador.receberNotificacao("Consumo excedido no dispositivo: " + dispositivo.getNome() +
                            ". Valor registrado: " + consumo.getValor() + "kWh. Limite: " + alerta.getLimite() + "kWh.");
                }
            }
        }
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public List<Morador> getMoradores() {
        return moradores;
    }

    public List<Moradia> getMoradias() {
        return moradias;
    }
}