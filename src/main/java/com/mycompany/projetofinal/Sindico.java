package com.mycompany.projetofinal;

import java.util.List;

public class Sindico extends Usuario {
    public Sindico(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public Sindico() {}

    public float calcularConsumoTotal(List<Moradia> moradias) {
        float total = 0;
        for (Moradia m : moradias) {
            total += m.getConsumoTotal();
        }
        return total;
    }
}
