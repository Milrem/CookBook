package com.letscode.cookBook.view;

import com.letscode.cookBook.Main;

public class ProcuraReceitaView {

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
}
