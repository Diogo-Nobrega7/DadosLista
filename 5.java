class PaginaWeb {
    String url;
    String titulo;

    public PaginaWeb(String url, String titulo) {
        this.url = url;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Página: " + titulo + " (" + url + ")";
    }
}

class NoPagina {
    PaginaWeb pagina;
    NoPagina proximo;
    NoPagina anterior;

    public NoPagina(PaginaWeb pagina) {
        this.pagina = pagina;
        this.proximo = null;
        this.anterior = null;
    }
}

class Navegador {
    private NoPagina paginaAtual;

    public Navegador() {
        this.paginaAtual = null;
    }

    public void visitarNovaPagina(PaginaWeb pagina) {
        NoPagina novoNo = new NoPagina(pagina);
        if (paginaAtual == null) {
            paginaAtual = novoNo;
        } else {
            paginaAtual.proximo = novoNo;
            novoNo.anterior = paginaAtual;
            paginaAtual = novoNo;
        }
        System.out.println("Visitando: " + paginaAtual.pagina);
    }
    
    public void voltar() {
        if (paginaAtual != null && paginaAtual.anterior != null) {
            paginaAtual = paginaAtual.anterior;
            System.out.println("Voltando para: " + paginaAtual.pagina);
        } else {
            System.out.println("Não há página anterior para voltar.");
        }
    }
    
    public void avancar() {
        if (paginaAtual != null && paginaAtual.proximo != null) {
            paginaAtual = paginaAtual.proximo;
            System.out.println("Avançando para: " + paginaAtual.pagina);
        } else {
            System.out.println("Não há página seguinte para avançar.");
        }
    }
    
    public static void main(String[] args) {
        Navegador meuNavegador = new Navegador();

        meuNavegador.visitarNovaPagina(new PaginaWeb("google.com", "Google"));
        meuNavegador.visitarNovaPagina(new PaginaWeb("wikipedia.org", "Wikipédia"));
        meuNavegador.visitarNovaPagina(new PaginaWeb("github.com", "GitHub"));
        
        System.out.println("\nNavegando pelo histórico...");
        meuNavegador.voltar();
        meuNavegador.voltar();
        meuNavegador.avancar();
    }
}