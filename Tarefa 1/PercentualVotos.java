import java.util.Scanner;

public class PercentualVotos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Digite o número total de eleitores: ");
        int totalEleitores = scanner.nextInt();
        
        System.out.print("Digite o número de votos brancos: ");
        int votosBrancos = scanner.nextInt();
        
        System.out.print("Digite o número de votos nulos: ");
        int votosNulos = scanner.nextInt();
        
        System.out.print("Digite o número de votos válidos: ");
        int votosValidos = scanner.nextInt();
        
  
        int totalVotos = votosBrancos + votosNulos + votosValidos;
        if (totalVotos > totalEleitores) {
            System.out.println("Erro: A soma dos votos não pode ser maior que o total de eleitores.");
        } else {

            double percentualBrancos = (votosBrancos * 100.0) / totalEleitores;
            double percentualNulos = (votosNulos * 100.0) / totalEleitores;
            double percentualValidos = (votosValidos * 100.0) / totalEleitores;
            
            System.out.printf("Percentual de votos brancos: %.2f%%\n", percentualBrancos);
            System.out.printf("Percentual de votos nulos: %.2f%%\n", percentualNulos);
            System.out.printf("Percentual de votos válidos: %.2f%%\n", percentualValidos);
        }

        scanner.close();
    }
}
