class Pedido {
    int numeroPedido;
    String nomeCliente;
    double valorTotal;

    public Pedido(int numeroPedido, String nomeCliente, double valorTotal) {
        this.numeroPedido = numeroPedido;
        this.nomeCliente = nomeCliente;
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Pedido Nº: " + numeroPedido + ", Cliente: " + nomeCliente + ", Valor: R$" + valorTotal;
    }
}

class NoPedido {
    Pedido pedido;
    NoPedido proximo;
    NoPedido anterior;

    public NoPedido(Pedido pedido) {
        this.pedido = pedido;
        this.proximo = null;
        this.anterior = null;
    }
}

class HistoricoPedidos {
    private NoPedido primeiro;
    private NoPedido ultimo;

    public HistoricoPedidos() {
        this.primeiro = null;
        this.ultimo = null;
    }
    
    public void adicionarPedido(Pedido pedido) {
        NoPedido novoNo = new NoPedido(pedido);
        if (primeiro == null) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.proximo = novoNo;
            novoNo.anterior = ultimo;
            ultimo = novoNo;
        }
    }

    public void cancelarPedido(int numeroDoPedido) {
        NoPedido atual = primeiro;
        while (atual != null) {
            if (atual.pedido.numeroPedido == numeroDoPedido) {
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
                System.out.println("Pedido " + numeroDoPedido + " cancelado.");
                return;
            }
            atual = atual.proximo;
        }
        System.out.println("Pedido " + numeroDoPedido + " não encontrado.");
    }
    
    public void listarPedidos() {
        if (primeiro == null) {
            System.out.println("Nenhum pedido no histórico.");
            return;
        }
        System.out.println("--- Histórico de Pedidos ---");
        NoPedido atual = primeiro;
        while (atual != null) {
            System.out.println(atual.pedido);
            atual = atual.proximo;
        }
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        HistoricoPedidos restaurante = new HistoricoPedidos();

        restaurante.adicionarPedido(new Pedido(101, "Carlos", 50.00));
        restaurante.adicionarPedido(new Pedido(102, "Mariana", 75.50));
        restaurante.adicionarPedido(new Pedido(103, "Lucas", 30.00));

        System.out.println("Histórico inicial:");
        restaurante.listarPedidos();
        
        System.out.println("\nCancelando pedido 102...");
        restaurante.cancelarPedido(102);

        System.out.println("\nHistórico final:");
        restaurante.listarPedidos();
    }
}