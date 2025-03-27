import java.util.LinkedList;

public class Biblioteca {
    private LinkedList<Livro> colecaoLivros;

    public Biblioteca() {
        this.colecaoLivros = new LinkedList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        Livro novoLivro = new Livro(titulo, autor, anoPublicacao);
        colecaoLivros.add(novoLivro);
        System.out.println("Livro adicionado com sucesso!");
    }

    public void listarLivros() {
        if (colecaoLivros.isEmpty()) {
            System.out.println("A biblioteca está vazia!");
        } else {
            System.out.println("Coleção de livros:");
            for (Livro livro : colecaoLivros) {
                System.out.println(livro);
            }
        }
    }

    public int getQuantidadeLivros() {
        return colecaoLivros.size();
    }
}