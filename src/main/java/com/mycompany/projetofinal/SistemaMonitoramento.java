package com.mycompany.projetofinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class SistemaMonitoramento {
    //ATRIBUTOS
    private List<Morador> moradores = new ArrayList<>();
    private List<Dispositivo> dispositivos = new ArrayList<>();
    private List<Moradia> moradias = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    //CONSTRUTORES
    public SistemaMonitoramento(){}

    //MÉTODOS
    public void registrarDispositivo() {
        System.out.print("ID: ");
        int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();

        if (moradias.isEmpty()) {
            System.out.println("Nenhuma moradia registrada. Cadastre uma moradia primeiro.");
            return;
        }

        exibirMoradias();
        System.out.print("Digite o ID da moradia (UUID): ");
        String moradiaIdStr = scanner.nextLine();

        try {
            UUID moradiaId = UUID.fromString(moradiaIdStr);
            Moradia moradia = buscarMoradiaPorId(moradiaId);
            if (moradia != null) {
                Dispositivo d = new Dispositivo(id, nome, modelo, tipo);
                moradia.adicionaDispositivo(d);
                dispositivos.add(d);
                System.out.println("Dispositivo cadastrado na moradia com sucesso.");
            } else {
                System.out.println("Moradia não encontrada.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ID inválido.");
        }
    }

    public void registrarMorador() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if (moradias.isEmpty()) {
            System.out.println("Nenhuma moradia registrada. Cadastre uma moradia primeiro.");
            return;
        }

        exibirMoradias();
        System.out.print("Digite o ID da moradia (UUID): ");
        String moradiaIdStr = scanner.nextLine();

        try {
            UUID moradiaId = UUID.fromString(moradiaIdStr);
            Moradia moradia = buscarMoradiaPorId(moradiaId);
            if (moradia != null) {
                Morador m = new Morador(nome, email, senha);
                m.setMoradia(moradia);
                moradia.addMorador(m);
                moradores.add(m);
                System.out.println("Morador cadastrado na moradia.");
            } else {
                System.out.println("Moradia não encontrada.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ID inválido.");
        }
    }

    public void registrarSindico() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        Sindico s = new Sindico(nome, email, senha);
        System.out.println("Síndico registrado (não armazenado na lista).");

        visualizarConsumoTotal(s);
    }

    public void registrarAlerta() {
        if (moradores.isEmpty()) {
            System.out.println("Nenhum morador cadastrado.");
            return;
        }

        exibirMoradores();
        System.out.print("Digite o email do morador para o qual deseja cadastrar o alerta: ");
        String email = scanner.nextLine();
        Morador morador = buscarMoradorPorEmail(email);

        if (morador == null) {
            System.out.println("Morador não encontrado.");
            return;
        }

        System.out.print("Tipo do dispositivo: ");
        String tipo = scanner.nextLine();
        System.out.print("Limite de consumo (kWh): ");
        float limite = scanner.nextFloat(); scanner.nextLine();

        morador.defineAlerta(limite, tipo);
        System.out.println("Alerta vinculado ao morador com sucesso.");
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
        System.out.println("Moradia registrada com ID: " + moradia.getId());
    }

    public void coletarDados() {
        for (Dispositivo d : dispositivos) {
            registrarConsumo(d, (float) (Math.random() * 10));
        }
        System.out.println("Dados coletados para todos os dispositivos.");
    }

    public void processarAlertas() {
        for (Dispositivo d : dispositivos) {
            Consumo atual = d.getConsumoAtual();
            if (atual != null) {
                processarAlerta(d, atual);
            }
        }
    }

    public void carregarInformacoesDispositivos() {
        for (Dispositivo d : dispositivos) {
            System.out.println(d + " | Consumo atual: " +
                    (d.getConsumoAtual() != null ? d.getConsumoAtual().getValor() + " kWh" : "Sem consumo"));
        }
    }

    public void carregarAlertas() {
        for (Morador morador : moradores) {
            System.out.println("Morador: " + morador.getNome());
            for (Alerta a : morador.getAlertas()) {
                System.out.println(" - Tipo: " + a.getTipo() + " | Limite: " + a.getLimite() + " kWh");
            }
        }
    }

    public void visualizarConsumoTotal(Sindico sindico) {
        float total = sindico.calcularConsumoTotal(moradias);
        System.out.println("Consumo total do edifício: " + total + " kWh");
    }

    private void registrarConsumo(Dispositivo dispositivo, float valor) {
        Consumo consumo = new Consumo(valor);
        dispositivo.registrarConsumo(consumo);
        processarAlerta(dispositivo, consumo);
    }

    private void processarAlerta(Dispositivo dispositivo, Consumo consumo) {
        Moradia moradia = dispositivo.getMoradia();
        if (moradia == null) return;

        for (Morador morador : moradia.getMoradores()) {
            for (Alerta alerta : morador.getAlertas()) {
                if (alerta.getTipo().equalsIgnoreCase(dispositivo.getTipo())
                        && alerta.alertaExcedido(consumo.getValor())) {
                    morador.receberNotificacao("Dispositivo: " + dispositivo.getNome() +
                            " excedeu o consumo. Valor: " + consumo.getValor() +
                            "kWh | Limite: " + alerta.getLimite() + "kWh.");
                }
            }
        }
    }

    private void exibirMoradias() {
        System.out.println("Moradias disponíveis:");
        for (Moradia m : moradias) {
            System.out.println("ID: " + m.getId() + " | Número: " + m.getNumero() + " | Bloco: " + m.getBloco());
        }
    }

    private void exibirMoradores() {
        System.out.println("Moradores disponíveis:");
        for (Morador m : moradores) {
            System.out.println("Nome: " + m.getNome() + " | Email: " + m.getEmail());
        }
    }

    private Moradia buscarMoradiaPorId(UUID id) {
        for (Moradia m : moradias) {
            if (m.getId().equals(id)) return m;
        }
        return null;
    }

    private Morador buscarMoradorPorEmail(String email) {
        for (Morador m : moradores) {
            if (m.getEmail().equalsIgnoreCase(email)) return m;
        }
        return null;
    }

    // Getters
    public List<Dispositivo> getDispositivos() { return dispositivos; }
    public List<Morador> getMoradores() { return moradores; }
    public List<Moradia> getMoradias() { return moradias; }
}
