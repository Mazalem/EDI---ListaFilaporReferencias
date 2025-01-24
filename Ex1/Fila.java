public class Fila {
    public Node cabeca;
    public Node cauda;
    public int tamanho = 0;

    public void enfileirar(Node elemento) {
        if(tamanho != 0)
            cauda.setProximo(elemento);
        else
            cabeca = elemento;
        cauda = elemento;
        elemento.proximo = null;
        tamanho++;
    }
    
    public Node desenfileirar() throws Exception{
        if(isVazia())
            throw new Exception("Não há ninguem para enfileirar.");
        Node aux = cabeca;
        cabeca = cabeca.proximo;
        tamanho--;
        return aux;
    }

    public boolean isVazia() {
        return tamanho == 0;
    }

}
