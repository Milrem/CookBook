package com.letscode.cookBook.model;

import com.letscode.cookBook.model.enums.TipoRendimento;

public class Rendimento {
    private final int quantidade;
    private final TipoRendimento tipoRendimento;

    public Rendimento(int quantidade, TipoRendimento tipoRendimento) {
        this.quantidade = quantidade;
        this.tipoRendimento = tipoRendimento;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public TipoRendimento getTipoRendimento() {
        return this.tipoRendimento;
    }

    @Override
    public String toString() {
        return String.format("%2d %s", this.quantidade, this.tipoRendimento);
    }
}
