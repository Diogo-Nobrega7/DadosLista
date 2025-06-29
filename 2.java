class Musica {
    String nome;
    int duracaoSegundos;

    public Musica(String nome, int duracaoSegundos) {
        this.nome = nome;
        this.duracaoSegundos = duracaoSegundos;
    }

    @Override
    public String toString() {
        return "Musica: " + nome + " (" + duracaoSegundos + "s)";
    }
}

class NoMusica {
    Musica musica;
    NoMusica proximo;
    NoMusica anterior;

    public NoMusica(Musica musica) {
        this.musica = musica;
        this.proximo = null;
        this.anterior = null;
    }
}

class Playlist {
    private NoMusica musicaAtual;

    public Playlist() {
        this.musicaAtual = null;
    }
    
    public void adicionarMusica(Musica musica) {
        NoMusica novoNo = new NoMusica(musica);
        if (musicaAtual == null) {
            musicaAtual = novoNo;
            novoNo.proximo = novoNo;
            novoNo.anterior = novoNo;
        } else {
            NoMusica anteriorDaAtual = musicaAtual.anterior;
            
            anteriorDaAtual.proximo = novoNo;
            novoNo.anterior = anteriorDaAtual;
            novoNo.proximo = musicaAtual;
            musicaAtual.anterior = novoNo;
        }
    }

    public void avancar() {
        if (musicaAtual != null) {
            musicaAtual = musicaAtual.proximo;
            System.out.println("Tocando agora: " + musicaAtual.musica);
        } else {
            System.out.println("Playlist está vazia.");
        }
    }

    public void voltar() {
        if (musicaAtual != null) {
            musicaAtual = musicaAtual.anterior;
            System.out.println("Tocando agora: " + musicaAtual.musica);
        } else {
            System.out.println("Playlist está vazia.");
        }
    }
    
    public static void main(String[] args) {
        Playlist minhaPlaylist = new Playlist();

        minhaPlaylist.adicionarMusica(new Musica("Bohemian Rhapsody", 355));
        minhaPlaylist.adicionarMusica(new Musica("Stairway to Heaven", 482));
        minhaPlaylist.adicionarMusica(new Musica("Like a Rolling Stone", 373));

        System.out.println("Iniciando a playlist...");
        minhaPlaylist.avancar();

        System.out.println("\nAvançando...");
        minhaPlaylist.avancar();

        System.out.println("\nVoltando a música...");
        minhaPlaylist.voltar();
    }
}