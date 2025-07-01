package com.mycompany.projetofinal;

import java.util.Scanner;

public class ProjetoFinal {

    public static void main(String[] args) {
        SistemaMonitoramento sistema = new SistemaMonitoramento();
        Scanner sc = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n=== MENU MONITORAMENTO ENERGÉTICO ===");
            System.out.println("1. Registrar Dispositivo");
            System.out.println("2. Registrar Morador");
            System.out.println("3. Registrar Síndico");
            System.out.println("4. Registrar Alerta");
            System.out.println("5. Registrar Moradia");
            System.out.println("6. Coletar Dados");
            System.out.println("7. Processar Alertas");
            System.out.println("8. Carregar Informações dos Dispositivos");
            System.out.println("9. Carregar Alertas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = -1;
            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1 -> sistema.registrarDispositivo();
                case 2 -> sistema.registrarMorador();
                case 3 -> sistema.registrarSindico();
                case 4 -> sistema.registrarAlerta();
                case 5 -> sistema.registrarMoradia();
                case 6 -> sistema.coletarDados();
                case 7 -> sistema.processarAlertas();
                case 8 -> sistema.carregarInformacoesDispositivos();
                case 9 -> sistema.carregarAlertas();
                case 0 -> {
                    rodando = false;
                    System.out.println("Encerrando o sistema...");
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }

        sc.close();
    }
}
