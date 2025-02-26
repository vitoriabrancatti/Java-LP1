import java.util.Scanner;

public class CustoCarro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o custo de fábrica do carro: R$ ");
        double custoFabrica = scanner.nextDouble();
        
        double percentualDistribuidor = 28.0;
        double percentualImpostos = 45.0;
        
        double valorDistribuidor = custoFabrica * percentualDistribuidor / 100;
        double valorImpostos = custoFabrica * percentualImpostos / 100;
        
        double custoFinal = custoFabrica + valorDistribuidor + valorImpostos;

        System.out.printf("O custo final ao consumidor é: R$ %.2f\n", custoFinal);
        
        scanner.close();
    }
}
