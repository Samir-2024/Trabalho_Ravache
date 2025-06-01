public class App {
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
    }
}