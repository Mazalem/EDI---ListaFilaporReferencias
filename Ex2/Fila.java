public class Fila {
    public Aviao cabeca;
    public Aviao cauda;
    public int tamanho = 0;

    public void enfileirar(Aviao aviao) {
        if (tamanho != 0)
            cauda.setProximo(aviao);
        else
            cabeca = aviao;
        cauda = aviao;
        aviao.proximo = null;
        tamanho++;
    }

    public Aviao desenfileirar() throws Exception {
        if (isVazia())
            throw new Exception("Não há ninguem para enfileirar.");
        Aviao aux = cabeca;
        cabeca = cabeca.proximo;
        tamanho--;
        return aux;
    }

    public boolean isVazia() {
        return tamanho == 0;
    }

}
