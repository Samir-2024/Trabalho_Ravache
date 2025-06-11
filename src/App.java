public class App {
    public static void preOrdemAVL(NoAVL no) {
        if (no != null) {
            System.out.print(no.chave + " ");
            preOrdemAVL(no.esquerdo);
            preOrdemAVL(no.direito);
        }
    }
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        System.out.print("Pré-ordem: ");
        arvore.preOrdem(arvore.raiz);
        System.out.println();

        System.out.print("Em-Ordem: ");
        arvore.emOrdem(arvore.raiz);
        System.out.println();

        System.out.print("Pós-ordem: ");
        arvore.posOrdem(arvore.raiz);
        System.out.println();

        System.out.println("Em-nível");
        for (int i = 0; i <= 3; i++) {
            System.out.print("Nível " + i + ": ");
            arvore.emNivel(arvore.raiz, i);        
        }
    
        System.out.println("Em-ordem iterativo: ");
        arvore.emOrdemRecursivo(arvore.raiz);
        System.out.println();

        System.out.print("Contagem de folhas: ");
        No no = arvore.raiz;
        int[] contador = {0};
        arvore.contarFolha(no, contador);
        System.out.println(contador[0]);

        System.out.print("Contagem de iterações: ");
        int[] contadorIteracoes = {0};
        arvore.contarIteracoes(no, contadorIteracoes);
        System.out.println(contadorIteracoes[0]);


        System.out.println();
        System.out.print("Fator de balanceamento: ");
        NoAVL noAVL = new NoAVL(10);
        noAVL.esquerdo = new NoAVL(5); 

        System.out.println(noAVL.fatorBalanceamento(noAVL));
        noAVL.direito = new NoAVL(15);
        noAVL.esquerdo.esquerdo = new NoAVL(3);
        noAVL.esquerdo.direito = new NoAVL(7);
        noAVL.direito.esquerdo = new NoAVL(12);
        noAVL.direito.direito = new NoAVL(20);
        System.out.println(noAVL.fatorBalanceamento(noAVL));
        noAVL.esquerdo = noAVL.rotacaoEsquerda(noAVL.esquerdo);
        System.out.println("Após rotação esquerda: " + noAVL.fatorBalanceamento(noAVL));
        noAVL.direito = noAVL.rotacaoDireita(noAVL.direito);
        System.out.println("Após rotação direita: " + noAVL.fatorBalanceamento(noAVL));
        System.out.println("Inserindo 8: ");
        noAVL = noAVL.inserir(noAVL, 8);
        System.out.println("Fator de balanceamento após inserção: " + noAVL.fatorBalanceamento(noAVL));
        System.out.println("Árvore AVL após inserção:");
        preOrdemAVL(noAVL);
        System.out.println();
        System.out.println("Inserindo 6: ");
        noAVL = noAVL.inserir(noAVL, 6);
        System.out.println("Fator de balanceamento após inserção: " + noAVL.fatorBalanceamento(noAVL));
        System.out.println("Árvore AVL após inserção:");
        preOrdemAVL(noAVL);
        System.out.println();
        System.out.println("Inserindo 4: ");
        noAVL = noAVL.inserir(noAVL, 4);
        System.out.println("Fator de balanceamento após inserção: " + noAVL.fatorBalanceamento(noAVL));
        System.out.println("Árvore AVL após inserção:");
        preOrdemAVL(noAVL);
        System.out.println();
        System.out.println("Inserindo 2: ");
        noAVL = noAVL.inserir(noAVL, 2);
        System.out.println("Fator de balanceamento após inserção: " + noAVL.fatorBalanceamento(noAVL));
        System.out.println("Árvore AVL após inserção:");
        preOrdemAVL(noAVL);
        System.out.println();

        System.out.println("Removendo 8: ");
        noAVL = noAVL.remover(noAVL, 8);
        System.out.println("Fator de balanceamento após remoção: " + noAVL.fatorBalanceamento(noAVL));
        System.out.println("Árvore AVL após remoção:");
        preOrdemAVL(noAVL);
        System.out.println();
        
        System.out.println("Buscarndo 6: ");
        NoAVL resultadoBusca = noAVL.buscar(noAVL, 6);
        if (resultadoBusca != null) {
            System.out.println("Valor encontrado: " + resultadoBusca.chave);
        } else {
            System.out.println("Valor não encontrado.");
        }

        
    }
}