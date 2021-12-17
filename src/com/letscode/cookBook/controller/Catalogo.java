package com.letscode.cookBook.controller;

import com.letscode.cookBook.model.Receita;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Catalogo {
    private List<Receita> receitas;

    public Catalogo() {
        this.receitas = new ArrayList<Receita>();
    }

    public boolean add(Receita receita) {
        if (receita == null || receita.getNome().isBlank()) {
            return false;
        }

        if (this.receitas.contains(receita)) {
            return false;
        }

        return this.receitas.add(receita);
    }

    public boolean del(String nome) {
        if (nome.isBlank()) {
            return false;
        }

        Receita receita = getReceita(nome);

        if (receita == null) {
            return false;
        }

        return this.receitas.remove(receita);
    }

    public Receita getReceita(String nome) {
        if (nome == null || nome.isBlank()) {
            return null;
        }

        for (Receita receita : this.receitas) {
            if (receita.getNome().equalsIgnoreCase(nome)) {
                return receita;
            }
        }

        return null;
    }

    public Receita getReceita(int index) {
        if (index < 0 || index >= this.receitas.size()) {
            return null;
        }

        return this.receitas.get(index);
    }

    public int getIndex(String nome) {
        if (nome == null || nome.isBlank()) {
            return -1;
        }

        Receita receitaBuscada = this.getReceita(nome);

        return this.receitas.indexOf(receitaBuscada);
    }

    public Receita getRandom() {
        if (receitas.isEmpty()) {
            return null;
        }

        int randomIndex = new Random().nextInt(receitas.size());

        return this.getReceita(randomIndex);
    }
}
