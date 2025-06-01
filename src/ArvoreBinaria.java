import java.util.Stack;

public class ArvoreBinaria {
    public No raiz;

    public ArvoreBinaria() {
        No noA = new No("A");
        No noB = new No("B");
        No noC = new No("C");
        No noD = new No("D");
        No noE = new No("E");
        No noF = new No("F");

        noA.esquerda = noB;
        noA.direita = noC;
        noB.esquerda = noD;
        noB.direita = noE;
        noC.direita = noF;

        this.raiz = noA;
    }

    public void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }

    public void emOrdem(No no) {
        if (no != null) {
            emOrdem(no.esquerda);
            System.out.print(no.valor + " ");
            emOrdem(no.direita);
        }
    }

    public void posOrdem(No no) {
        if (no != null) {
            posOrdem(no.esquerda);
            System.out.print(no.valor + " ");
            posOrdem(no.direita);
        }
    }

    public void emNivel(No no, int nivel) {
        if (no != null) {
            if (no.nivel == nivel) {
                System.out.println(no.valor + " ");
            } else {
                emNivel(no.esquerda, nivel);
                emNivel(no.direita, nivel);
            }
        }
    }
 
    public void emOrdemRecursivo(No raiz) {
        Stack<No> pilha = new Stack<>();
        No atual = raiz;

        while (atual != null || !pilha.isEmpty()) {
            while (atual != null) {
                pilha.push(atual);
                atual = atual.esquerda;
            }
            atual = pilha.pop();
            System.out.print(atual.valor + " ");
            atual = atual.direita;
        }
    }
    public void contarFolha(No no, int[] contador) {
        if (no != null) {
            if (no.esquerda == null && no.direita == null) {
                contador[0]++;
            } else {
                contarFolha(no.esquerda, contador);
                contarFolha(no.direita, contador);
            }
        }
    }

    public void contarIteracoes(No no, int[] contador) {
        if (no != null) {
            contador[0]++;
            contarIteracoes(no.esquerda, contador);
            contarIteracoes(no.direita, contador);}
    }


}

