import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int escolha = -1;
        Fila filaQ = new Fila();
        Fila filaA = new Fila();
        Fila filaB = new Fila();

        do {
            System.out.println("1 - Adicionar nome a uma fila.");
            System.out.println("2 - Processar cadastro.");
            System.out.print("Escolha: ");
            escolha = teclado.nextInt();

            switch (escolha) {
                case 1:
                    String texto;
                    System.out.print("Informe o nome e a operação (A, B ou X). Exemplo: 'Matheus A': ");
                    teclado.nextLine();
                    texto = teclado.nextLine();
                    String nome = texto.split(" ")[0];
                    String operacao = texto.split(" ")[1];
                    System.out.println();
                    filaQ.enfileirar(new Node(operacao));
                    filaQ.enfileirar(new Node(nome));
                    System.out.println("Adicionado com Sucesso\n");
                    break;
                case 2:
                    while (!filaQ.isVazia()) {
                        try {
                            String op = filaQ.desenfileirar().elemento.toLowerCase();
                            Node el = filaQ.desenfileirar();
                            switch (op) {
                                case "a":
                                    System.out.println(el.elemento + " entrou na fila A.");
                                    filaA.enfileirar(el);
                                    break;
                                case "b":
                                    System.out.println(el.elemento + " entrou na fila B.");
                                    filaB.enfileirar(el);
                                    break;
                                case "x":
                                    if (filaA.tamanho > filaB.tamanho) {
                                        System.out.println(el.elemento + " entrou na fila B (menor fila).");
                                        filaB.enfileirar(el);
                                    } else if (filaA.tamanho < filaB.tamanho) {
                                        System.out.println(el.elemento + " entrou na fila A (menor fila).");
                                        filaA.enfileirar(el);
                                    } else {
                                        System.out.println(el.elemento
                                                + " foi descartado pois as demais filas tinham o mesmo tamanho.");
                                    }
                                    break;
                                default:
                                    System.out.println(
                                            el.elemento + " foi descartado pois a operação informada é inválida.");
                            }
                        } catch (Exception ex) {
                            System.err.println(ex.getMessage());
                        }
                    }
                    System.out.println("\nFila A:");
                    imprime(filaA);
                    System.out.println("Fila B:");
                    imprime(filaB);
                    break;
            }

        } while (escolha != 2);

        teclado.close();
    }

    public static void imprime(Fila fila) {
        if (!fila.isVazia()) {
            Node el = fila.cabeca;
            for (int i = 1; i <= fila.tamanho; i++) {
                System.out.println(i + ": " + el.elemento);
                el = el.proximo;
            }
            System.out.println("\n");
        } else {
            System.out.println("Fila Vazia\n");
        }
    }
}
