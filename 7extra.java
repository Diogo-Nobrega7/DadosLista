class Acao {
    String tipo; 
    String texto;

    public Acao(String tipo, String texto) {
        this.tipo = tipo;
        this.texto = texto;
    }
    
    @Override
    public String toString() {
        return "Ação: " + tipo + ", Texto: '" + texto + "'";
    }
}

class NoAcao {
    Acao acao;
    NoAcao proximo;

    public NoAcao(Acao acao) {
        this.acao = acao;
        this.proximo = null;
    }
}

class PilhaDeAcoes {
    private NoAcao topo;

    public PilhaDeAcoes() {
        this.topo = null;
    }
    
    public void empilhar(Acao acao) {
        NoAcao novoNo = new NoAcao(acao);
        novoNo.proximo = topo;
        topo = novoNo;
    }
    
    public Acao desempilhar() {
        if (estaVazia()) {
            return null;
        }
        Acao acaoDoTopo = topo.acao;
        topo = topo.proximo;
        return acaoDoTopo;
    }
    
    public boolean estaVazia() {
        return topo == null;
    }

    public void limpar() {
        topo = null;
    }
}

class Editor {
    private String conteudo;
    private PilhaDeAcoes pilhaDesfazer;
    private PilhaDeAcoes pilhaRefazer;

    public Editor() {
        this.conteudo = "";
        this.pilhaDesfazer = new PilhaDeAcoes();
        this.pilhaRefazer = new PilhaDeAcoes();
    }
    
    public void executarAcao(Acao acao) {
        pilhaDesfazer.empilhar(acao);
        pilhaRefazer.limpar(); 
        System.out.println("Executado: " + acao);
    }
    
    public void desfazer() {
        Acao ultimaAcao = pilhaDesfazer.desempilhar();
        if (ultimaAcao != null) {
            pilhaRefazer.empilhar(ultimaAcao);
            System.out.println("Desfeito: " + ultimaAcao);
        } else {
            System.out.println("Nada a desfazer.");
        }
    }
    
    public void refazer() {
        Acao ultimaAcaoDesfeita = pilhaRefazer.desempilhar();
        if (ultimaAcaoDesfeita != null) {
            pilhaDesfazer.empilhar(ultimaAcaoDesfeita);
            System.out.println("Refeito: " + ultimaAcaoDesfeita);
        } else {
            System.out.println("Nada a refazer.");
        }
    }
    
    public static void main(String[] args) {
        Editor meuEditor = new Editor();

        meuEditor.executarAcao(new Acao("ADICIONAR", "Olá "));
        meuEditor.executarAcao(new Acao("ADICIONAR", "Mundo"));
        meuEditor.executarAcao(new Acao("SUBSTITUIR", "!"));

        System.out.println("\n--- Histórico de Ações ---");
        meuEditor.desfazer();
        meuEditor.desfazer();
        meuEditor.refazer();
    }
}