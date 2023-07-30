public class No {
    private No esquerda;
    private No direita;
    private String palavra;
    
    No(){
        esquerda = null;
        direita = null;
    }

    No(String palavra){
        esquerda = null;
        direita = null;
        this.palavra = palavra.toUpperCase();
    }


    public boolean arvoreVazia(){
        if (this.palavra == null){
            return true;
        } else {
            return false;
        }
    }


    public boolean comparaStr(String palavra_um, String palavra_dois){ //retorna se a primeira palavra tem prioridade alfabeticamente ou é igual
        String padrao_palavra_um = palavra_um.toUpperCase();
        String padrao_palavra_dois = palavra_dois.toUpperCase();

        //se a primeira palavra for maior ou igual
        if (padrao_palavra_um.length() >= padrao_palavra_dois.length()){
            for (int i = 0; i < padrao_palavra_dois.length(); i++){
                if(padrao_palavra_dois.charAt(i) < padrao_palavra_um.charAt(i)){
                    return false;
                } else if(padrao_palavra_dois.charAt(i) > padrao_palavra_um.charAt(i)){
                    return true;
                }
            }
            return false;
        }

        //se a primeira palavra for menor
        else {
            for (int i = 0; i < padrao_palavra_um.length(); i++){
                if(padrao_palavra_um.charAt(i) < padrao_palavra_dois.charAt(i)){
                    return true;
                } else if(padrao_palavra_um.charAt(i) > padrao_palavra_dois.charAt(i)){
                    return false;
                }
            }
            return true;
        }
    }


    public void inserir(No no_atual, No novo_no){
        if (arvoreVazia()){ //se for vazia
            no_atual.palavra = novo_no.palavra;
        } else { //se não for vazia
            if (comparaStr(novo_no.palavra,no_atual.palavra)){ //se a nova palavra tiver prioridade alfabetica
                if (no_atual.esquerda == null){ //se não houver palavra à esquerda
                    no_atual.esquerda = novo_no;
                } else { //se houver palavra à esquerda
                    inserir(no_atual.esquerda, novo_no);
                }
            } else { //se for de prioridade igual ou posterior
                if (no_atual.direita == null){ //se não houver palavra à direita
                    no_atual.direita = novo_no;
                } else { //se houver palavra à direita
                    inserir(no_atual.direita, novo_no);
                }
            }
        }
    }


    public void impressao_em_ordem(No no_atual){
        if (arvoreVazia()){ //se for vazia
            System.out.println("A árvore está vazia!");
        } else { //se não for vazia
            if(no_atual.esquerda != null){ //se houver elementos à esquerda
                impressao_em_ordem(no_atual.esquerda);
            }
            System.out.println(no_atual.palavra);
            if(no_atual.direita != null){ //se houver à direita
                impressao_em_ordem(no_atual.direita);
            } 
        }
    }


    public No buscar(No no_atual, String palavra){
        palavra = palavra.toUpperCase();
        if (comparaStr(palavra, no_atual.palavra)){ //se a palavra buscada tiver prioridade alfabética
            return buscar(no_atual.esquerda, palavra);
        } else { //se a palavra buscada não tiver prioridade alfabética
            if (no_atual.palavra.equals(palavra)){ //se encontrar a palavra na árvore
                return no_atual;
            } else if (no_atual.direita != null){
                return buscar(no_atual.direita, palavra);
            } else {
                return null;
            }
        }
    }

    public No minimo(No no_atual) {
        if (no_atual.esquerda != null) {
            return minimo(no_atual.esquerda);
        } else {
            return no_atual;
        }
    }


    public No remover(String palavra){
        palavra = palavra.toUpperCase();
        if(this.palavra == null) { // árvore vazia
            return null;
        }
        if(this.palavra.equals(palavra)) { // remover a raiz
            if(this.esquerda == null && this.direita == null) { // sem filhos
                this.palavra = null;
            } else if(this.esquerda == null) { // apenas filho à direita
                this.palavra = this.direita.palavra;
                this.direita = remover(this.direita, this.palavra);
            } else if(this.direita == null) { // apenas filho à esquerda
                this.palavra = this.esquerda.palavra;
                this.esquerda = remover(this.esquerda, this.palavra);
            } else { // dois filhos
                No sucessor = minimo(this.direita);
                this.palavra = sucessor.palavra;
                this.direita = remover(this.direita, sucessor.palavra);
            }
            return this;
        } else { // remover um nó diferente da raiz
            return remover(this, palavra);
        }
    }

    public No remover(No no_atual, String palavra){
        if(no_atual.palavra.equals(palavra)){ //remover o atual
            if (no_atual.direita == null){ //atual não tem direita
                if(no_atual.esquerda != null){ //mas tem esquerda
                    return no_atual.esquerda;
                }
            } else if (no_atual.esquerda == null)  { //tem direita mas não tem esquerda
                return no_atual.direita;
            } else { //tem direita e esquerda
                No sucessor = minimo(no_atual.direita);
                no_atual.palavra = sucessor.palavra;
                no_atual.direita = remover(no_atual.direita, sucessor.palavra);
                return no_atual;
            }
        } else {
            if(comparaStr(palavra, no_atual.palavra)){ //se a palavra buscada tiver prioridade alfabética
                if (no_atual.esquerda == null){ //se não houver palavra à esquerda
                    return no_atual;
                } else { //se houver à esquerda
                    no_atual.esquerda = remover(no_atual.esquerda, palavra);
                    return no_atual;
                }

            } else { //se a palavra buscada não tiver prioridade alfabética
                if (no_atual.direita == null){ //se não houver à direita
                    return no_atual;
                } else { //se houver à direita
                    no_atual.direita = remover(no_atual.direita, palavra);
                    return no_atual;
                }
            }
        }

        return null;
    }

    public String getPalavra(){
        return this.palavra;
    }


}