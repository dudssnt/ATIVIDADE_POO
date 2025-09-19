import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class SimuladorImprt {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);


        try {
            System.out.println("==== Calculaddora de Imposto de Importação (EUA)  ====");

            System.out.println("Descrição de Produto: ");
            String descricao = scanner.nextLine();

            System.out.println("Origem \n 1-China \n 2-UE \n 3-Japão \n 4-Coreia \n 5-Vietnã \n 6-Tailândia \n 7-Canadá \n 8-México \n 9-Outros \n 10-Brasil \n Selecione: ");
            int origem = scanner.nextInt();

            System.out.println("Categoria \n 1-Geral \n 2-Fármacos \n 3-Semicondutores \n 4-Cobre \n 5-Madeira \n 6-Energia/Minerais \n 7-Bullion \n Selecione: ");
            int categoria = scanner.nextInt();

            System.out.print("Valor da Mercadoria (USD): ");
            double valorMercadoria = scanner.nextDouble();

            System.out.print("Valor do Frete (USD): ");
            double valorFrete = scanner.nextDouble();

            boolean usmca = false;
            if (origem == 7 || origem == 8) {
                System.out.print("O produto se qualifica para o USMCA? (true/false): ");
                usmca = scanner.nextBoolean();
            }

            ProdutoImportado produto = new ProdutoImportado(descricao, origem, categoria, valorMercadoria, valorFrete, usmca);

            Calculadora calculadora = new Calculadora();
            
            //os calculos
            double cif = calculadora.calcularCIF(produto);
            double aliquota = calculadora.determinarAliquota(produto);
            double imposto = calculadora.calcularValorImposto(cif, aliquota);
            double valorFinal = cif + imposto;

            //saída
            System.out.println("\n==== Relatório de Importação ====");
            System.out.printf("Produto: %s\n", produto.getDescricao());
            System.out.printf("País de Origem: %s\n", produto.getOrigemTexto());
            System.out.printf("Categoria: %s\n", produto.getCategoriaTexto());
            System.out.println("====================================");
            System.out.printf("Valor CIF (Mercadoria + Frete): $%.2f\n", cif);
            System.out.println("====================================");
            // alíquota em formato de %
            System.out.printf("Alíquota Aplicada: %.1f%%\n", aliquota * 100);
            System.out.printf("Valor do Imposto: $%.2f\n", imposto);
            System.out.println("------------------------------------");
            System.out.printf("VALOR FINAL TOTAL: $%.2f\n", valorFinal);
        } catch (InputMismatchException e) {
        System.err.println("Erro: Entrada inválida. Por favor, insira os dados no formato correto.");
        } finally {
        scanner.close();
        }
    }
}
