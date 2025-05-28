public class Fracao {
    private int numerador;
    private int denominador;

    public Fracao(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("O denominador não pode ser zero.");
        }
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
    }

    // Método para somar duas frações
    public Fracao somar(Fracao outra) {
        int num = this.numerador * outra.denominador + outra.numerador * this.denominador;
        int den = this.denominador * outra.denominador;
        return new Fracao(num, den);
    }

    // Método para subtrair duas frações
    public Fracao subtrair(Fracao outra) {
        int num = this.numerador * outra.denominador - outra.numerador * this.denominador;
        int den = this.denominador * outra.denominador;
        return new Fracao(num, den);
    }

    // Método para multiplicar duas frações
    public Fracao multiplicar(Fracao outra) {
        int num = this.numerador * outra.numerador;
        int den = this.denominador * outra.denominador;
        return new Fracao(num, den);
    }

    // Método para dividir duas frações
    public Fracao dividir(Fracao outra) {
        int num = this.numerador * outra.denominador;
        int den = this.denominador * outra.numerador;
        return new Fracao(num, den);
    }

    // Método para simplificar a fração
    private void simplificar() {
        int mdc = mdc(Math.abs(numerador), Math.abs(denominador));
        this.numerador /= mdc;
        this.denominador /= mdc;
        // Corrigir sinal
        if (this.denominador < 0) {
            this.numerador *= -1;
            this.denominador *= -1;
        }
    }

    // Método para calcular o Máximo Divisor Comum
    private int mdc(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Método para exibir a fração
    public String toString() {
        if (denominador == 1) {
            return String.valueOf(numerador); // Exibir como inteiro se possível
        }
        return numerador + "/" + denominador;
    }
    
    public class TesteFracao {
        public static void main(String[] args) {
            Fracao f1 = new Fracao(2, 5);
            Fracao f2 = new Fracao(3, 7);
    
            System.out.println("Soma: " + f1.somar(f2));
            System.out.println("Subtração: " + f1.subtrair(f2));
            System.out.println("Multiplicação: " + f1.multiplicar(f2));
            System.out.println("Divisão: " + f1.dividir(f2));
        }
    }

}
