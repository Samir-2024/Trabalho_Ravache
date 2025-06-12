public class Rubro {
    public int color;
    public int chave;
    public Rubro esquerdo, direito, pai;
    

    public Rubro(int valor) {
        chave = valor;
        color = 1;   
    }

    public Rubro(int valor , int color) {
        chave = valor;
        this.color = color;
    }

    public Rubro(int valor , Rubro esquerdo, Rubro direito, Rubro pai) {
        chave = valor;
        this.esquerdo = esquerdo;
        this.direito = direito;
        this.pai = pai;
        this.color = 1;
    }

    public Rubro(int valor, Rubro esquerdo, Rubro direito, Rubro pai, int color) {
        chave = valor;
        this.esquerdo = esquerdo;
        this.direito = direito;
        this.pai = pai;
        this.color = color;
    }

    public boolean isVermelho() {
        return color == 1;
    }

    public boolean isPreto() {
        return color == 0;
    }

    public void color(int color) {
        this.color = color;
    }

    public int getChave() {
        return chave;
    }

    public Rubro getEsquerdo() {
        return esquerdo;
    }

    public Rubro getDireito() {
        return direito;
    }

    public Rubro getPai() {
        return pai;
    }

    public void setEsquerdo(Rubro esquerdo) {
        this.esquerdo = esquerdo;
        if (esquerdo != null) {
            esquerdo.pai = this;
        }
    }

    public void setDireito(Rubro direito) {
        this.direito = direito;
        if (direito != null) {
            direito.pai = this;
        }
    }

    public void setPai(Rubro pai) {
        this.pai = pai;
    }

    public void setPai(int valor) {
        this.pai = new Rubro(valor);
    } 

    public class ArvoreRubroNegra {
    private Rubro raiz;

    public void inserir(int chave) {
        Rubro novo = new Rubro(chave); 
        raiz = inserirBST(raiz, novo);
        corrigirInsercao(novo);
    }

    private Rubro inserirBST(Rubro atual, Rubro novo) {
        if (atual == null) {
            return novo;
        }

        if (novo.chave < atual.chave) {
            atual.setEsquerdo(inserirBST(atual.getEsquerdo(), novo));
        } else if (novo.chave > atual.chave) {
            atual.setDireito(inserirBST(atual.getDireito(), novo));
        }

        return atual;
    }

    private void corrigirInsercao(Rubro node) {
        while (node != raiz && node.getPai().isVermelho()) {
            Rubro pai = node.getPai();
            Rubro avo = pai.getPai();

            if (pai == avo.getEsquerdo()) {
                Rubro tio = avo.getDireito();

                if (tio != null && tio.isVermelho()) {
                    pai.color(0);
                    tio.color(0);
                    avo.color(1);
                    node = avo;
                } else {
                    if (node == pai.getDireito()) {
                        node = pai;
                        rotacaoEsquerda(node);
                    }
                    pai.color(0);
                    avo.color(1);
                    rotacaoDireita(avo);
                }
            } else {
                Rubro tio = avo.getEsquerdo();

                if (tio != null && tio.isVermelho()) {
                    pai.color(0);
                    tio.color(0);
                    avo.color(1);
                    node = avo;
                } else {
                    if (node == pai.getEsquerdo()) {
                        node = pai;
                        rotacaoDireita(node);
                    }
                    pai.color(0);
                    avo.color(1);
                    rotacaoEsquerda(avo);
                }
            }
        }
        raiz.color(0); // raiz sempre preta
    }

    private void rotacaoEsquerda(Rubro x) {
        Rubro y = x.getDireito();
        x.setDireito(y.getEsquerdo());

        if (y.getEsquerdo() != null) {
            y.getEsquerdo().setPai(x);
        }

        y.setPai(x.getPai());

        if (x.getPai() == null) {
            raiz = y;
        } else if (x == x.getPai().getEsquerdo()) {
            x.getPai().setEsquerdo(y);
        } else {
            x.getPai().setDireito(y);
        }

        y.setEsquerdo(x);
    }

    private void rotacaoDireita(Rubro x) {
        Rubro y = x.getEsquerdo();
        x.setEsquerdo(y.getDireito());

        if (y.getDireito() != null) {
            y.getDireito().setPai(x);
        }

        y.setPai(x.getPai());

        if (x.getPai() == null) {
            raiz = y;
        } else if (x == x.getPai().getDireito()) {
            x.getPai().setDireito(y);
        } else {
            x.getPai().setEsquerdo(y);
        }

        y.setDireito(x);
    }

    public Rubro getRaiz() {
        return raiz;
    }

    public ArvoreRubroNegra() {
        raiz = null;
    }
    }   
}