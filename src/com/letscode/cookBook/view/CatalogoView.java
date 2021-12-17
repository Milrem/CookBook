package com.letscode.cookBook.view;

import com.letscode.cookBook.Main;
import com.letscode.cookBook.controller.Catalogo;
import com.letscode.cookBook.model.Ingrediente;
import com.letscode.cookBook.model.Receita;
import com.letscode.cookBook.model.Rendimento;
import com.letscode.cookBook.model.enums.Categoria;

public class CatalogoView {
    private final Receita NONE_FOUND = new Receita("");

    Catalogo controller;
    private Receita receitaAtual;
    private int indexReceitaAtual;

    String aviso;

    public CatalogoView() {
        this.controller = new Catalogo();
        this.indexReceitaAtual = -1;
        this.aviso = "";
    }

    private void showHeader() {
        ScreenUtil.printTextLine("", 80, true, '=');
        ScreenUtil.printTextLine("#### #### #### #  #  ###  #### #### #  #", 80, true, ' ');
        ScreenUtil.printTextLine("#    #  # #  # # #   #  # #  # #  # # # ", 80, true, ' ');
        ScreenUtil.printTextLine("#    #  # #  # ##    ###  #  # #  # ##  ", 80, true, ' ');
        ScreenUtil.printTextLine("#    #  # #  # # #   #  # #  # #  # # # ", 80, true, ' ');
        ScreenUtil.printTextLine("#### #### #### #  #  ###  #### #### #  #", 80, true, ' ');
        ScreenUtil.printTextLine("", 80, true, '=');
    }

    private void showAviso() {
        ScreenUtil.printTextLine("", 80, true, '=');
        ScreenUtil.printTextLine(String.format("AVISO: %s", this.aviso), 80, true);
        ScreenUtil.printTextLine("", 80, true, '=');
    }

    private void showReceita(Receita receita) {
        System.out.println(receita.toString());
    }

    private void showReceitaAnterior() {
        if (this.indexReceitaAtual <= 0 || this.receitaAtual == null) {
            return;
        }

        Receita receitaAnterior = this.controller.getReceita(this.indexReceitaAtual - 1);

        if (receitaAnterior == null) {
            return;
        }

        this.indexReceitaAtual--;
        this.receitaAtual = receitaAnterior;
    }

    private void showReceitaSeguinte() {
        Receita receitaSeguinte = this.controller.getReceita(this.indexReceitaAtual + 1);

        if (receitaSeguinte == null) {
            return;
        }

        this.indexReceitaAtual++;
        this.receitaAtual = receitaSeguinte;
    }

    private void addReceita() {
        NovaReceitaView novaReceitaView = new NovaReceitaView();

        System.out.println();
        String nome = novaReceitaView.askNome();

        System.out.println();
        Categoria categoria = novaReceitaView.askCategoria();

        System.out.println();
        int tempoPreparo = novaReceitaView.askTempoPreparo();

        System.out.println();
        Rendimento rendimento = novaReceitaView.askRendimento();

        System.out.println();
        Ingrediente[] ingredientes = novaReceitaView.askIngredientes();

        System.out.println();
        String[] modoPreparo = novaReceitaView.askModoPreparo();

        Receita novaReceita = new Receita(nome);
        novaReceita.setCategoria(categoria);
        novaReceita.setTempoPreparo(tempoPreparo);
        novaReceita.setRendimento(rendimento);
        novaReceita.setIngredientes(ingredientes);
        novaReceita.setModoPreparo(modoPreparo);

        if (this.controller.add(novaReceita)) {
            this.receitaAtual = novaReceita;
            this.indexReceitaAtual++;

            this.aviso = "Receita adicionada com sucesso!";
        } else {
            this.aviso = "Houve algum erro. Receita não adicionada.";
        }
    }

    private void delReceita() {
        if (this.indexReceitaAtual < 0 || this.receitaAtual == null) {
            return;
        }

        boolean existeReceitaSeguinte = this.controller.getReceita(this.indexReceitaAtual + 1) != null;
        boolean existeReceitaAnterior = this.controller.getReceita(this.indexReceitaAtual - 1) != null;

        if (this.controller.del(this.receitaAtual.getNome())) {

            if (existeReceitaSeguinte) {
                this.indexReceitaAtual--;
                this.showReceitaSeguinte();
            } else if (existeReceitaAnterior) {
                this.showReceitaAnterior();
            } else {
                this.receitaAtual = null;
                this.indexReceitaAtual = -1;
            }

            this.aviso = "Receita removida com sucesso!";
        } else {
            this.aviso = "Houve algum erro. Receita não removida.";
        }
    }

    private void searchReceita() {
        ProcuraReceitaView procuraReceitaView = new ProcuraReceitaView();

        System.out.println();
        String nome = procuraReceitaView.askNome();

        Receita receitaEncontrada = this.controller.getReceita(nome);
        if (receitaEncontrada == null) {
            this.aviso = "Receita não encontrada.";
            return;
        }

        this.receitaAtual = receitaEncontrada;
        this.indexReceitaAtual = this.controller.getIndex(nome);

        this.aviso = "Receita encontrada!";
    }

    public void show() {
        String option;

        do {
            ScreenUtil.clearScreen();

            showHeader();

            if (this.receitaAtual == null) {
                this.aviso = "Nenhuma receita encontrada.";
            }

            showAviso();
            this.aviso = "";

            showReceita(this.receitaAtual == null ? this.NONE_FOUND : this.receitaAtual);

            ScreenUtil.printTextLine("", 80, true, '=');
            ScreenUtil.printTextLine("P: Receita anterior", 80, true);
            ScreenUtil.printTextLine("N: Receita seguinte", 80, true);
            ScreenUtil.printTextLine("+: Adicionar nova receita", 80, true);
            ScreenUtil.printTextLine("-: Remover receita", 80, true);
            ScreenUtil.printTextLine("S: Pesquisar receita", 80, true);
            ScreenUtil.printTextLine("E: Sair", 80, true);
            ScreenUtil.printTextLine("", 80, true, '=');

            System.out.print("#: ");
            option = Main.scanner.nextLine();

            switch (option.toUpperCase()) {
                case "P":
                    this.showReceitaAnterior();
                    break;
                case "N":
                    this.showReceitaSeguinte();
                    break;
                case "+":
                    this.addReceita();
                    break;
                case "-":
                    this.delReceita();
                    break;
                case "S":
                    this.searchReceita();
                    break;
                case "E":
                    continue;
                default:
                    ScreenUtil.printTextLine("Opção inválida", 80);
            }
        } while (!option.equalsIgnoreCase("E"));
    }
}
