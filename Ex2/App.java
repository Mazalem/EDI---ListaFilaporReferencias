import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String escolha = null;
        Fila filaSul = new Fila();
        Fila filaNorte = new Fila();
        Fila filaLeste = new Fila();
        Fila filaOeste = new Fila();
        Fila filaFinal = new Fila();

        escolha = teclado.next();
        do {
            switch (escolha) {
                case "-1":
                    escolha = recebeAvioes(filaOeste, teclado);
                    break;
                case "-2":
                    escolha = recebeAvioes(filaSul, teclado);
                    break;
                case "-3":
                    escolha = recebeAvioes(filaNorte, teclado);
                    break;
                case "-4":
                    escolha = recebeAvioes(filaLeste, teclado);
                    break;
            }
        } while (!escolha.equals("0"));

        while(filaLeste.tamanho > 0 || filaOeste.tamanho > 0 || filaNorte.tamanho > 0 || filaSul.tamanho > 0) {
            try {
                if(filaOeste.tamanho != 0) {
                    filaFinal.enfileirar(filaOeste.desenfileirar());
                }
                if(filaNorte.tamanho != 0) {
                    filaFinal.enfileirar(filaNorte.desenfileirar());
                }
                if(filaSul.tamanho != 0) {
                    filaFinal.enfileirar(filaSul.desenfileirar());
                }
                if(filaLeste.tamanho != 0) {
                    filaFinal.enfileirar(filaLeste.desenfileirar());
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        imprime(filaFinal);
        teclado.close();
    }

    public static String recebeAvioes(Fila fila, Scanner teclado) {
        String op = null;
        while (true) {
            op = teclado.next();
            if (op.equals("-1") || op.equals("-2") || op.equals("-3") || op.equals("-4") || op.equals("0")) {
                break;
            } else {
                fila.enfileirar(new Aviao(op));
            }
        }
        return op;
    }

    public static void imprime(Fila fila) {
        if (!fila.isVazia()) {
            Aviao el = fila.cabeca;
            for (int i = 1; i <= fila.tamanho; i++) {
                System.out.print(el.identificador + " ");
                el = el.proximo;
            }
            System.out.println("\n");
        } else {
            System.out.println("Fila Vazia\n");
        }
    }
}
