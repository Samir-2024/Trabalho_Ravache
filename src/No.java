public class No {
    private String valor;
    private String proximo;
    private String anterior;

    public No(String valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getProximo() {
        return proximo;
    }

    public void setProximo(String proximo) {
        this.proximo = valor + 1;
    }

    public String getAnterior() {
        return anterior;
    }

    public void setAnterior(int anterior) {
        this.anterior = valor;
    }
}