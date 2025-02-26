import java.util.Scanner;

public class IdadeConversor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita a idade em anos
        System.out.print("Digite sua idade em anos: ");
        int anos = scanner.nextInt();
        
        // Converte para meses e dias
        int meses = anos * 12;
        int dias = anos * 365;

        // Exibe o resultado
        System.out.println("Sua idade em meses: " + meses);
        System.out.println("Sua idade em dias: " + dias);
        
        scanner.close();
    }
}