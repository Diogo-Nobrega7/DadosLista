class Item {
    String nome;
    int quantidade;
    double precoUnitario;

    public Item(String nome, int quantidade, double precoUnitario) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    @Override
    public String toString() {
        return "Item: " + nome + ", Qtd: " + quantidade + ", Preço: R$" + String.format("%.2f", precoUnitario);
    }
}

class NoItem {
    Item item;
    NoItem proximo;
    NoItem anterior;

    public NoItem(Item item) {
        this.item = item;
        this.proximo = null;
        this.anterior = null;
    }
}

class CarrinhoDeCompras {
    private NoItem primeiro;
    private NoItem ultimo;

    public CarrinhoDeCompras() {
        this.primeiro = null;
        this.ultimo = null;
    }
    
    public void adicionarItem(Item item) {
        NoItem novoNo = new NoItem(item);
        if (primeiro == null) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.proximo = novoNo;
            novoNo.anterior = ultimo;
            ultimo = novoNo;
        }
    }

    public void removerItem(String nomeDoItem) {
        NoItem atual = primeiro;
        while (atual != null) {
            if (atual.item.nome.equals(nomeDoItem)) {
                if (atual.anterior != null) {
                    atual.anterior.proximo = atual.proximo;
                } else {
                    primeiro = atual.proximo;
                }
                if (atual.proximo != null) {
                    atual.proximo.anterior = atual.anterior;
                } else {
                    ultimo = atual.anterior;
                }
                System.out.println(nomeDoItem + " removido.");
                return;
            }
            atual = atual.proximo;
        }
        System.out.println("Item não encontrado no carrinho.");
    }

    public void listarItens() {
        if (primeiro == null) {
            System.out.println("Carrinho vazio.");
            return;
        }
        System.out.println("--- Itens no Carrinho ---");
        NoItem atual = primeiro;
        while (atual != null) {
            System.out.println(atual.item);
            atual = atual.proximo;
        }
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        CarrinhoDeCompras meuCarrinho = new CarrinhoDeCompras();

        meuCarrinho.adicionarItem(new Item("Feijão", 2, 8.50));
        meuCarrinho.adicionarItem(new Item("Arroz", 1, 5.00));
        meuCarrinho.adicionarItem(new Item("Carne", 1, 35.00));

        System.out.println("Carrinho inicial:");
        meuCarrinho.listarItens();

        System.out.println("\nRemovendo 'Arroz'...");
        meuCarrinho.removerItem("Arroz");

        System.out.println("\nCarrinho final:");
        meuCarrinho.listarItens();
    }
}
