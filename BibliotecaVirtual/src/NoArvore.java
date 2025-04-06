public class NoArvore {
    private Livro livro;
    private NoArvore esquerda;
    private NoArvore direita;

    public NoArvore(Livro livro) {
        this.livro = livro;
        this.esquerda = null;
        this.direita = null;
    }

    public Livro getLivro() {
        return livro;
    }

    public NoArvore getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoArvore esquerda) {
        this.esquerda = esquerda;
    }

    public NoArvore getDireita() {
        return direita;
    }

    public void setDireita(NoArvore direita) {
        this.direita = direita;
    }
}