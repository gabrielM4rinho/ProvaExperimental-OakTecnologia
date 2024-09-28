package application;

import entities.Register;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        char cont;
        do {
            Program.menu();
            System.out.println("Deseja retornar ao menu? (s/n)");
            cont = Character.toLowerCase(sc.next().charAt(0));
        } while (cont == 's');
    }

    public static void menu() {
        Register reg = new Register();
        int selectMenu;
        System.out.println("MENU");
        System.out.print("1 - Cadastrar um novo produto\n" +
                "2 - Listar todos os produtos cadastrados\n");
        selectMenu = sc.nextInt();

        while (selectMenu > 2 || selectMenu < 1) {
            System.out.print("Item invalido, tente novamente: ");
            selectMenu = sc.nextInt();
        }
        switch (selectMenu) {
            case 1:
                reg.cadastrarProduto();
                break;
            case 2:
                reg.listarProdutos();
                break;
        }
    }
}
