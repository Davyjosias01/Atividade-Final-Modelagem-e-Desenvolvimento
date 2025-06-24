/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projetofinal;

import java.util.Scanner;

/**
 *
 * @author davyj
 */
public class ProjetoFinal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario davy = new Usuario();
        try {
        davy.visualizarInformacoes();
        } catch (NullPointerException e){
            System.out.println("Valores inexistentes para usuario!\n" + e);
        }
    }
}
