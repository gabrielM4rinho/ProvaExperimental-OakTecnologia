package entities;

import java.util.*;

public class Register {


    private static List<Product> listProduct = new ArrayList<>();
    private boolean opcaoValida = false;


    public void cadastrarProduto() {
        Scanner sc = new Scanner(System.in);

        boolean valid = false;
        char disp = 'x';
        System.out.print("Nome do produto: ");
        String name = sc.nextLine();
        System.out.print("Descrição do produto: ");
        String desc = sc.nextLine();

        double value = 0;
        boolean valorValido = false;
        while (!valorValido) {
            try {
                System.out.print("Valor do produto: ");
                value = sc.nextDouble();
                valorValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: O valor do produto deve ser númerico: ");
                sc.next();
            }
        }

        opcaoValida = false;
        while (!opcaoValida) {
            try {
                System.out.print("O produto está disponivel para venda? (s/n): ");
                disp = Character.toLowerCase(sc.next().charAt(0));
                if (disp == 's') {
                    Product p = new Product(name, desc, value, disp);
                    listProduct.add(p);
                    System.out.println("\nProduto cadastrado!\n");
                    opcaoValida = true;
                    listarProdutos();
                } else if (disp == 'n') {
                    System.out.println("Produto listado como não disponivel");
                    Product p = new Product(name, desc, value, disp);
                    listProduct.add(p);
                    System.out.println("\nProduto cadastrado!\n");
                    opcaoValida = true;
                    listarProdutos();
                } else {
                    System.out.println("---------\nResponda apenas com 's' ou 'n': ");
                }
            } catch (InputMismatchException e) {
                System.out.println("---------\nResponda apenas com 's' ou 'n': ");
            }
        }
    }

    public void listarProdutos() {
        Scanner sc = new Scanner(System.in);
        listProduct.sort(Comparator.comparing(Product::getProductPrice));
        System.out.println("Listagem dos produtos: ");

        for (Product prod : listProduct) {
            System.out.println(prod.toString());
        }

        char novoProduto;
        boolean validarOpcao = false;
        while (!validarOpcao) {
            try {
                System.out.println("Deseja cadastrar um novo produto? (s/n) ");
                novoProduto = Character.toLowerCase(sc.next().charAt(0));
                if (novoProduto == 's') {
                    cadastrarProduto();
                    validarOpcao = true;
                } else if (novoProduto == 'n') {
                    System.out.println("Encerrando listagem");
                    validarOpcao = true;
                } else {
                    System.out.println("---------\nResponda apenas com 's' ou 'n': ");
                }
            } catch (InputMismatchException e) {
                System.out.println("---------\nResponda apenas com 's' ou 'n': ");
            }
        }
    }
}
