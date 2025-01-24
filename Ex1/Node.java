public class Node {
    public String elemento;
    public Node proximo;
    
    public Node(String elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }
    public String getElemento() {
        return elemento;
    }
    public void setElemento(String elemento) {
        this.elemento = elemento;
    }
    public Node getProximo() {
        return proximo;
    }
    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
}
