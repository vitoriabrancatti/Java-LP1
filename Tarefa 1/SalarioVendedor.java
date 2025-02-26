import java.util.Scanner;

public class SalarioVendedor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o salário fixo do vendedor: R$ ");
        double salarioFixo = scanner.nextDouble();
        
        System.out.print("Digite o número de carros vendidos: ");
        int carrosVendidos = scanner.nextInt();
        
        System.out.print("Digite o valor recebido por carro vendido: R$ ");
        double comissaoPorCarro = scanner.nextDouble();
        
        System.out.print("Digite o valor total das vendas: R$ ");
        double valorTotalVendas = scanner.nextDouble();
        
        double comissaoFixa = carrosVendidos * comissaoPorCarro;
        double comissaoPercentual = valorTotalVendas * 0.05;

        double salarioFinal = salarioFixo + comissaoFixa + comissaoPercentual;

        System.out.printf("O salário final do vendedor é: R$ %.2f\n", salarioFinal);
        
        scanner.close();
    }
}
