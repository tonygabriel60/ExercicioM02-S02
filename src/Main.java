import java.util.Scanner;

public class Main {
    static String[] nomes = {"Tomates", "Batatas", "Cebolas"};
    static double[] precos = {5.50, 3.20, 4.80};
    static int[] quantidades = {100, 150, 80};
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n[1] Venda\n[2] Reposição\n[3] Relatório\n[4] Sair");
            opcao = sc.nextInt();
            
            switch (opcao) {
                case 1: venda(); break;
                case 2: reposicao(); break;
                case 3: relatorio(); break;
            }
        } while (opcao != 4);
    }
    
    static void venda() {
        System.out.println("Produtos: 1-Tomates 2-Batatas 3-Cebolas");
        int produto = sc.nextInt() - 1;
        System.out.print("Quantidade: ");
        int qtd = sc.nextInt();
        
        if (qtd > quantidades[produto]) {
            System.out.println("Estoque insuficiente!");
        } else {
            quantidades[produto] -= qtd;
            System.out.println("Venda realizada!");
        }
    }
    
    static void reposicao() {
        System.out.println("Produtos: 1-Tomates 2-Batatas 3-Cebolas");
        int produto = sc.nextInt() - 1;
        System.out.print("Quantidade: ");
        int qtd = sc.nextInt();
        quantidades[produto] += qtd;
        System.out.println("Reposição realizada!");
    }
    
    static void relatorio() {
        double total = 0;
        for (int i = 0; i < 3; i++) {
            double valorProduto = quantidades[i] * precos[i];
            total += valorProduto;
            System.out.printf("%s - Qtd: %d - Preço: R$%.2f - Total: R$%.2f\n", 
                nomes[i], quantidades[i], precos[i], valorProduto);
        }
        System.out.printf("Total do estoque: R$%.2f\n", total);
    }
}