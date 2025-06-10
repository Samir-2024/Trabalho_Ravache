public class NoAVL {
    public int altura, chave;
    public NoAVL esquerdo, direito;


    public NoAVL(int valor) {
        chave = valor;
        altura = 1;
    }

    int altura(NoAVL no) {
        if (no == null) 
            return 0;
        return no.altura;
    }

    int fatorBalanceamento(NoAVL no) {
        if (no == null) 
            return 0;
        return altura(no.esquerdo) - altura(no.direito);
    }

    NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerdo;
        NoAVL T2 = x.direito;

        x.direito = y;
        y.esquerdo = T2;

        y.altura = Math.max(altura(y.esquerdo), altura(y.direito)) + 1;
        x.altura = Math.max(altura(x.esquerdo), altura(x.direito)) + 1;

        return x;
    }

    NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direito;
        NoAVL T2 = x.esquerdo;

        y.esquerdo = x;
        x.direito = T2;

        x.altura = Math.max(altura(x.esquerdo), altura(x.direito)) + 1;
        y.altura = Math.max(altura(y.esquerdo), altura(y.direito)) + 1;

        return y;
    }

    NoAVL inserir(NoAVL no, int chave) {

        if (no == null) {
            return new NoAVL(chave);
        }

        if (chave < no.chave) 
            no.esquerdo = inserir(no.esquerdo, chave);
        else if (chave > no.chave)
            no.direito = inserir(no.direito, chave);
        else
            return no;

        no.altura = 1 + Math.max(altura(no.esquerdo), altura(no.direito));

        int balanceamento = fatorBalanceamento(no);

        if (balanceamento > 1 && chave < no.esquerdo.chave) {
            return rotacaoDireita(no);
        }

        if (balanceamento < -1 && chave > no.direito.chave) {
            return rotacaoEsquerda(no);
        }

        if (balanceamento > 1 && chave > no.esquerdo.chave) {
            no.esquerdo = rotacaoEsquerda(no.esquerdo);
            return rotacaoDireita(no);
        }

        if (balanceamento < -1 && chave < no.direito.chave) {
            no.direito = rotacaoDireita(no.direito);
            return rotacaoEsquerda(no);
        }

        return no;
    } 

    NoAVL buscar(NoAVL no, int chave) {
        if (no == null || no.chave == chave) {
            return no;
        } else if (chave < no.chave) {
            return buscar(no.esquerdo, chave);
        } else {
            return buscar(no.direito, chave);
        }
    }

    NoAVL remover(NoAVL no, int chave) {
        if (no == null) return no;
        if (chave < no.chave) {
            no.esquerdo = remover(no.esquerdo, chave);
        } else if (chave > no.chave) {
            no.direito = remover(no.direito, chave);
        } else {
            if (no.esquerdo == null || no.direito == null) {
                NoAVL temp = (no.esquerdo != null) ? no.esquerdo : no.direito;
                no = temp;
            } else {
                NoAVL temp = no.direito;
                while (temp.esquerdo != null) {
                    temp = temp.esquerdo;
                }
                no.chave = temp.chave;
                no.direito = remover(no.direito, temp.chave);
            }
        }
        if (no == null) return no;
        no.altura = 1 + Math.max(altura(no.esquerdo), altura(no.direito));
        int balanceamento = fatorBalanceamento(no);
        if (balanceamento > 1 && fatorBalanceamento(no.esquerdo) >= 0) {
            return rotacaoDireita(no);
        }
        if (balanceamento > 1 && fatorBalanceamento(no.esquerdo) < 0) {
            no.esquerdo = rotacaoEsquerda(no.esquerdo);
            return rotacaoDireita(no);
        }
        if (balanceamento < -1 && fatorBalanceamento(no.direito) <= 0) {
            return rotacaoEsquerda(no);
        }
        if (balanceamento < -1 && fatorBalanceamento(no.direito) > 0) {
            no.direito = rotacaoDireita(no.direito);
            return rotacaoEsquerda(no);
        }
        return no;
    }
}

