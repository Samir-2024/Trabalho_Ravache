
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

    /*public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        System.out.print("Pré-ordem: ");
        arvore.preOrdem(arvore.raiz);
        System.out.println();
        System.out.print("Em-Ordem: ");
        arvore.emOrdem(arvore.raiz);
        System.out.println();
        System.out.print("Pós-ordem: ");
        arvore.posOrdem(arvore.raiz);
    }
    
    public int contarNos(No no) {
        if (no == null) {
            return 0;
        } else {
            return 1 + contarNos(no.esquerda) + contarNos(no.direita);
        }
    }

    public int contarNos() {
        return contarNos(raiz);
    }
    */

    public void preOrdemRecursivo(No no) {
        No noAtual = no;
        while (no != null) {
            if (noAtual != null) {
                System.out.print(noAtual.valor + " ");
                noAtual = noAtual.esquerda;
            } else if (noAtual == null) {
                noAtual = no.direita;
            }
    }
}
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        System.out.print("Pré-ordem: ");
        arvore.preOrdemRecursivo(arvore.raiz);
       
    }
}
