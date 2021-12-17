package com.letscode.cookBook.model;

import com.letscode.cookBook.model.enums.TipoMedida;

public class Ingrediente {
    private final String nome;
    private final double quantidade;
    private final TipoMedida tipoQuantidade;

    public Ingrediente(String nome, double quantidade, TipoMedida tipoQuantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.tipoQuantidade = tipoQuantidade;
    }

    public String getNome() {
        return this.nome;
    }

    public double getQuantidade() {
        return this.quantidade;
    }

    public TipoMedida getTipoQuantidade() {
        return this.tipoQuantidade;
    }

    @Override
    public String toString() {
        return String.format("%.3f %s de %s",
                this.quantidade, this.tipoQuantidade, this.nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Ingrediente that = (Ingrediente) o;

        return this.nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return this.nome.hashCode();
    }
}
