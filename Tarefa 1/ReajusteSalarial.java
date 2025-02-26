import java.util.Scanner;

public class ReajusteSalarial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o salário mensal atual do funcionário: ");
        double salarioAtual = scanner.nextDouble();
        
        System.out.print("Digite o percentual de reajuste (ex: 10 para 10%%): ");
        double percentualReajuste = scanner.nextDouble();
        
        double novoSalario = salarioAtual + (salarioAtual * percentualReajuste / 100);

        System.out.printf("O novo salário após o reajuste será: R$ %.2f\n", novoSalario);
        
        scanner.close();
    }
}
