public class Main {
    public static void main(String[] args) {
        No arvore = new No();

        No a = new No("as vezes");
        No b = new No("best");
        No d = new No("d");
        No c = new No("cellar door");
        No aa = new No("a");

        arvore.inserir(arvore, a);
        arvore.inserir(arvore, b);
        arvore.inserir(arvore, d);
        arvore.inserir(arvore, c);
        arvore.inserir(arvore, aa);

        arvore.impressao_em_ordem(arvore);

        System.out.println("\n");

        //buscar 'cellar door'
        System.out.println(arvore.buscar(arvore, "cellar door").getPalavra());
        //buscar 'a'
        System.out.println(arvore.buscar(arvore, "a").getPalavra());

        System.out.println("\n");
        
        //remover nós com dois filhos
        arvore.remover("as vezes");
        arvore.impressao_em_ordem(arvore);
        System.out.println("\n");

        //com apenas um filho para a esquerda
        arvore.remover("d");
        arvore.impressao_em_ordem(arvore);
        System.out.println("\n");

        //com apenas um filho para a direita
        d = new No("d");
        arvore.inserir(arvore, d);
        arvore.remover("cellar door");
        arvore.impressao_em_ordem(arvore);
        System.out.println("\n");

        //sem filhos
        arvore.remover("a");
        arvore.impressao_em_ordem(arvore);
        System.out.println("\n");

        //esvaziar
        arvore.remover("best");
        arvore.impressao_em_ordem(arvore);
        System.out.println("\n");
        arvore.remover("d");
        arvore.impressao_em_ordem(arvore);

    }
}
