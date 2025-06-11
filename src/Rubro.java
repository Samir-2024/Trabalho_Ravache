public class Rubro {
    public int cor;
    public int chave;
    public Rubro esquerdo, direito, pai;
    

    public Rubro(int valor) {
        chave = valor;
        cor = 1;
        esquerdo = direito = pai = null;
    }

    public Rubro(int valor , int cor) {
        chave = valor;
        this.cor = cor;
        
    }

    public Rubro(int valor , Rubro esquerdo, Rubro direito, Rubro pai) {
        chave = valor;
        this.esquerdo = esquerdo;
        this.direito = direito;
        this.pai = pai;
        this.cor = 1;
    }

    
    
}
