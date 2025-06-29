class Jogador {
    String nome;
    int pontuacao;

    public Jogador(String nome, int pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        return "Jogador: " + nome + " (Pontos: " + pontuacao + ")";
    }
}

class NoJogador {
    Jogador jogador;
    NoJogador proximo;

    public NoJogador(Jogador jogador) {
        this.jogador = jogador;
        this.proximo = null;
    }
}

class RodizioJogadores {
    private NoJogador jogadorAtual;
    private int quantidade;

    public RodizioJogadores() {
        this.jogadorAtual = null;
        this.quantidade = 0;
    }

    public void adicionarJogador(Jogador jogador) {
        NoJogador novoNo = new NoJogador(jogador);
        if (jogadorAtual == null) {
            novoNo.proximo = novoNo;
            jogadorAtual = novoNo;
        } else {
            novoNo.proximo = jogadorAtual.proximo;
            jogadorAtual.proximo = novoNo;
        }
        quantidade++;
    }
    
    public void avancarRodizio() {
        if (jogadorAtual != null) {
            jogadorAtual = jogadorAtual.proximo;
            System.out.println("É a vez de: " + jogadorAtual.jogador);
        } else {
            System.out.println("Não há jogadores no rodízio.");
        }
    }
    
    public void removerJogador(String nomeJogador) {
        if (jogadorAtual == null) return;

        NoJogador noParaRemover = null;
        NoJogador anterior = jogadorAtual;

        for (int i = 0; i < quantidade; i++) {
            if (anterior.proximo.jogador.nome.equals(nomeJogador)) {
                noParaRemover = anterior.proximo;
                break;
            }
            anterior = anterior.proximo;
        }
        
        if (noParaRemover != null) {
            if (quantidade == 1) {
                jogadorAtual = null;
            } else {
                if (noParaRemover == jogadorAtual) {
                    jogadorAtual = jogadorAtual.proximo;
                }
                anterior.proximo = noParaRemover.proximo;
            }
            System.out.println(nomeJogador + " foi removido.");
            quantidade--;
        }
    }
    
    public static void main(String[] args) {
        RodizioJogadores jogo = new RodizioJogadores();

        jogo.adicionarJogador(new Jogador("Ana", 100));
        jogo.adicionarJogador(new Jogador("Bruno", 150));
        jogo.adicionarJogador(new Jogador("Carlos", 120));

        System.out.println("Iniciando o jogo...");
        jogo.avancarRodizio();
        
        jogo.removerJogador("Bruno");
        
        System.out.println("\nContinuando o jogo após remoção...");
        jogo.avancarRodizio();
    }
}