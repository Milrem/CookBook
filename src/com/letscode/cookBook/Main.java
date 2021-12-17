package com.letscode.cookBook;

import java.util.Scanner;

import com.letscode.cookBook.view.CatalogoView;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CatalogoView catalogoView = new CatalogoView();

        catalogoView.show();

        Main.scanner.close();
    }
}
