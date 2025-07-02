package com.mycompany.projetofinal;

import java.util.Scanner;

public class ProjetoFinal {

    public static void main(String[] args) {
        SistemaMonitoramento sistema = new SistemaMonitoramento();
        Scanner sc = new Scanner(System.in);
        boolean rodando = true;

        boolean sindicoCadastrado = false;
        boolean moradiaCadastrada = false;
        boolean moradorCadastrado = false;
        boolean dispositivoCadastrado = false;

        System.out.println("=== SISTEMA DE MONITORAMENTO ENERGÉTICO ===");

        while (rodando) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Registrar Síndico" + (sindicoCadastrado ? " (OK)" : ""));
            System.out.println("2. Registrar Moradia" + (moradiaCadastrada ? " (OK)" : ""));
            System.out.println("3. Registrar Morador" + (moradorCadastrado ? " (OK)" : ""));
            System.out.println("4. Registrar Dispositivo" + (dispositivoCadastrado ? " (OK)" : ""));
            System.out.println("5. Registrar Alerta");
            System.out.println("6. Coletar Leitura dos Dispositivos");
            System.out.println("7. Processar Alertas");
            System.out.println("8. Exibir Dispositivos");
            System.out.println("9. Exibir Alertas");
            System.out.println("10. Visualizar Consumo Total do Edifício");
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
                case 1:
                    sistema.registrarSindico();
                    sindicoCadastrado = true;
                    break;

                case 2:
                    if (!sindicoCadastrado) {
                        System.out.println("Cadastre primeiro o síndico.");
                        break;
                    }
                    sistema.registrarMoradia();
                    moradiaCadastrada = true;
                    break;

                case 3:
                    if (!moradiaCadastrada) {
                        System.out.println("Cadastre uma moradia antes de adicionar moradores.");
                        break;
                    }
                    sistema.registrarMorador();
                    moradorCadastrado = true;
                    break;

                case 4:
                    if (!moradiaCadastrada) {
                        System.out.println("Cadastre uma moradia antes de adicionar dispositivos.");
                        break;
                    }
                    sistema.registrarDispositivo();
                    dispositivoCadastrado = true;
                    break;

                case 5:
                    if (!moradorCadastrado) {
                        System.out.println("Cadastre um morador antes de registrar alertas.");
                        break;
                    }
                    if (!dispositivoCadastrado) {
                        System.out.println("Cadastre dispositivos antes de criar alertas.");
                        break;
                    }
                    sistema.registrarAlerta();
                    break;

                case 6:
                    if (!dispositivoCadastrado) {
                        System.out.println("Nenhum dispositivo cadastrado para coleta.");
                        break;
                    }
                    sistema.coletarDados();
                    break;

                case 7:
                    sistema.processarAlertas();
                    break;

                case 8:
                    sistema.carregarInformacoesDispositivos();
                    break;

                case 9:
                    sistema.carregarAlertas();
                    break;

                case 10:
                    if (!sindicoCadastrado) {
                        System.out.println("Nenhum síndico cadastrado.");
                        break;
                    }
                    sistema.visualizarConsumoTotal(new Sindico());
                    break;

                case 0:
                    rodando = false;
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        sc.close();
    }
}
