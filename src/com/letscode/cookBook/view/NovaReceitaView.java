package com.letscode.cookBook.view;

import com.letscode.cookBook.Main;
import com.letscode.cookBook.model.Ingrediente;
import com.letscode.cookBook.model.Rendimento;
import com.letscode.cookBook.model.enums.Categoria;
import com.letscode.cookBook.model.enums.TipoMedida;
import com.letscode.cookBook.model.enums.TipoRendimento;

public class NovaReceitaView {

    public String askNome() {
        String nome;

        System.out.println("Nome da receita:");

        while (true) {
            System.out.print("#: ");
            nome = Main.scanner.nextLine();

            if (nome.isBlank()) {
                System.out.println("Nome inválido. Tente novamente!");
            } else {
                break;
            }
        }

        return nome;
    }

    public Categoria askCategoria() {
        Categoria categoria;

        System.out.println("Categoria da receita:");
        for (Categoria cat : Categoria.values()) {
            System.out.printf("%d - %s%n", cat.ordinal(), cat.name());
        }

        while (true) {
            System.out.print("#: ");
            String categoriaIndexString = Main.scanner.nextLine();
            int categoriaIndex;

            if (categoriaIndexString == null || categoriaIndexString.isBlank()) {
                System.out.println("Categoria inválida. Tente novamente!");
                continue;
            }

            try {
                categoriaIndex = Integer.parseInt(categoriaIndexString);
            } catch (NumberFormatException e) {
                System.out.println("Categoria inválida. Tente novamente!");
                continue;
            }

            if (0 <= categoriaIndex && categoriaIndex < Categoria.values().length) {
                categoria = Categoria.values()[categoriaIndex];
                break;
            } else {
                System.out.println("Categoria inválida. Tente novamente!");
            }
        }

        return categoria;
    }

    public int askTempoPreparo() {
        int tempoPreparo;

        System.out.println("Tempo de preparo da receita (número inteiro em minutos):");

        while (true) {
            System.out.print("#: ");
            String tempoPreparoString = Main.scanner.nextLine();

            if (tempoPreparoString == null || tempoPreparoString.isBlank()) {
                System.out.println("Tempo inválido. Tente novamente!");
                continue;
            }

            try {
                tempoPreparo = Integer.parseInt(tempoPreparoString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Tempo inválido. Tente novamente!");
            }
        }

        return tempoPreparo;
    }

    public Rendimento askRendimento() {
        TipoRendimento tipoRendimento;
        int quantidade;

        System.out.println("Rendimento da receita - tipo:");
        for (TipoRendimento tipo : TipoRendimento.values()) {
            System.out.printf("%d - %s%n", tipo.ordinal(), tipo.name());
        }

        while (true) {
            System.out.print("#: ");
            String tipoRendimentoIndexString = Main.scanner.nextLine();
            int tipoRendimentoIndex;

            if (tipoRendimentoIndexString == null || tipoRendimentoIndexString.isBlank()) {
                System.out.println("Tipo inválido. Tente novamente!");
                continue;
            }

            try {
                tipoRendimentoIndex = Integer.parseInt(tipoRendimentoIndexString);
            } catch (NumberFormatException e) {
                continue;
            }

            if (0 <= tipoRendimentoIndex && tipoRendimentoIndex < TipoRendimento.values().length) {
                tipoRendimento = TipoRendimento.values()[tipoRendimentoIndex];
                break;
            } else {
                System.out.println("Tipo inválido. Tente novamente!");
            }
        }

        System.out.println();
        System.out.println("Rendimento da receita - quantidade (número inteiro):");

        while (true) {
            System.out.print("#: ");
            String quantidadeString = Main.scanner.nextLine();

            if (quantidadeString == null || quantidadeString.isBlank()) {
                System.out.println("Quantidade inválida. Tente novamente!");
                continue;
            }

            try {
                quantidade = Integer.parseInt(quantidadeString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Quantidade inválida. Tente novamente!");
            }
        }

        return new Rendimento(quantidade, tipoRendimento);
    }

    public Ingrediente[] askIngredientes() {
        int quantidadeIngredientes;

        System.out.println("Ingredientes da receita - quantidade de ingredientes (número inteiro):");

        while (true) {
            System.out.print("#: ");
            String quantidadeIngredientesString = Main.scanner.nextLine();

            if (quantidadeIngredientesString == null || quantidadeIngredientesString.isBlank()) {
                System.out.println("Quantidade inválida. Tente novamente!");
                continue;
            }

            try {
                quantidadeIngredientes = Integer.parseInt(quantidadeIngredientesString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Quantidade inválida. Tente novamente!");
            }
        }

        Ingrediente[] ingredientes = new Ingrediente[quantidadeIngredientes];

        for (int i = 0; i < quantidadeIngredientes; ++i) {
            String nome;
            double quantidade;
            TipoMedida tipoQuantidade;

            System.out.println();
            System.out.printf("Ingrediente %d - nome:%n", i + 1);

            while (true) {
                System.out.print("#: ");
                nome = Main.scanner.nextLine();

                if (nome == null || nome.isBlank()) {
                    System.out.println("Nome inválido. Tente novamente!");
                } else {
                    break;
                }
            }

            System.out.printf("Ingrediente %d - tipo de medida:%n", i + 1);
            for (TipoMedida tipo : TipoMedida.values()) {
                System.out.printf("%d - %s%n", tipo.ordinal(), tipo.name());
            }

            while (true) {
                System.out.print("#: ");
                String tipoQuantidadeString = Main.scanner.nextLine();
                int tipoQuantidadeIndex;

                if (tipoQuantidadeString == null || tipoQuantidadeString.isBlank()) {
                    System.out.println("Tipo inválido. Tente novamente!");
                    continue;
                }

                try {
                    tipoQuantidadeIndex = Integer.parseInt(tipoQuantidadeString);
                } catch (NumberFormatException e) {
                    System.out.println("Tipo inválido. Tente novamente!");
                    continue;
                }

                if (0 <= tipoQuantidadeIndex && tipoQuantidadeIndex < TipoMedida.values().length) {
                    tipoQuantidade = TipoMedida.values()[tipoQuantidadeIndex];
                    break;
                } else {
                    System.out.println("Tipo inválido. Tente novamente!");
                }
            }

            System.out.printf("Ingrediente %d - quantidade:%n", i + 1);

            while (true) {
                System.out.print("#: ");
                String quantidadeString = Main.scanner.nextLine();

                if (quantidadeString == null || quantidadeString.isBlank()) {
                    System.out.println("Quantidade inválida. Tente novamente!");
                    continue;
                }

                try {
                    quantidade = Double.parseDouble(quantidadeString);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Quantidade inválida. Tente novamente!");
                }
            }

            ingredientes[i] = new Ingrediente(nome, quantidade, tipoQuantidade);
        }

        return ingredientes;
    }

    public String[] askModoPreparo() {
        int quantidadePassos;

        System.out.println("Modo de preparo - quantidade de passos (número inteiro):");

        while (true) {
            System.out.print("#: ");
            String quantidadePassosString = Main.scanner.nextLine();

            if (quantidadePassosString == null || quantidadePassosString.isBlank()) {
                System.out.println("Quantidade inválida. Tente novamente!");
                continue;
            }

            try {
                quantidadePassos = Integer.parseInt(quantidadePassosString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Quantidade inválida. Tente novamente!");
            }
        }

        String[] modoPreparo = new String[quantidadePassos];

        for (int i = 0; i < quantidadePassos; ++i) {
            String passo;

            System.out.println();
            System.out.printf("Passo %d:%n", i + 1);

            while (true) {
                System.out.print("#: ");
                passo = Main.scanner.nextLine();

                if (passo == null || passo.isBlank()) {
                    System.out.println("Texto inválido. Tente novamente!");
                } else {
                    break;
                }
            }

            modoPreparo[i] = passo;
        }

        return modoPreparo;
    }
}
