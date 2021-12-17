package com.letscode.cookBook.model;

import com.letscode.cookBook.model.enums.Categoria;

import java.util.ArrayList;
import java.util.List;

public class Receita {
    private String nome;
    private Categoria categoria;
    private int tempoPreparo;
    private Rendimento rendimento;
    private List<Ingrediente> ingredientes;
    private String[] modoPreparo;

    public Receita(String nome) {
        this.nome = nome;
        this.ingredientes = new ArrayList<Ingrediente>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getTempoPreparo() {
        return this.tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public Rendimento getRendimento() {
        return this.rendimento;
    }

    public void setRendimento(Rendimento rendimento) {
        this.rendimento = rendimento;
    }

    public List<Ingrediente> getIngredientes() {
        return this.ingredientes;
    }

    public void setIngredientes(Ingrediente[] ingredientes) {
        for (Ingrediente ingrediente : ingredientes) {
            this.ingredientes.add(ingrediente);
        }
    }

    public String[] getModoPreparo() {
        return this.modoPreparo;
    }

    public void setModoPreparo(String[] modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Receita that = (Receita) o;

        return this.nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return this.nome.hashCode();
    }

    @Override
    public String toString() {

        String nome = String.format("Nome: %s%n", this.nome);

        String categoria = String.format("Categoria: %s%n",
                this.categoria == null ? "" : this.categoria.name());

        String rendimento = String.format("Rendimento: %s%n",
                this.rendimento == null ? "" : this.rendimento);

        String tempoPreparo = String.format("Tempo de preparo: ");
        if (this.tempoPreparo != 0) {
            tempoPreparo += String.format("%d%n", this.tempoPreparo);
        } else {
            tempoPreparo += String.format("%n");
        }

        String ingredientes = String.format("Ingredientes: %n");
        if (this.ingredientes != null) {
            for (Ingrediente ingrediente : this.ingredientes) {
                ingredientes += String.format("\t%s%n", ingrediente);
            }
        }

        String modoPreparo = String.format("Modo de preparo: %n");
        if (this.modoPreparo != null) {
            for (String passo : this.modoPreparo) {
                modoPreparo += String.format("\t%s%n", passo);
            }
        }

        return nome + categoria + rendimento + tempoPreparo + ingredientes + modoPreparo;
    }
}
