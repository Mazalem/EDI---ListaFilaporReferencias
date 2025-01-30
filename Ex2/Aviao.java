public class Aviao {
    public String identificador;
    public Aviao proximo;
    
    public Aviao(String identificador) {
        this.identificador = identificador;
        this.proximo = null;
    }
    public String getIdentificador() {
        return identificador;
    }
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    public Aviao getProximo() {
        return proximo;
    }
    public void setProximo(Aviao proximo) {
        this.proximo = proximo;
    }
}
