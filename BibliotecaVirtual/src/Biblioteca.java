import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Biblioteca {
    private LinkedList<Livro> colecaoLivros;
    private Queue<String> listaEspera;
    private Stack<Livro> historicoNavegacao;

    public Biblioteca() {
        this.colecaoLivros = new LinkedList<>();
        this.listaEspera = new LinkedList<>();
        this.historicoNavegacao = new Stack<>();
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

    public void adicionarListaEspera(String nomeUsuario) {
        listaEspera.add(nomeUsuario);
        System.out.println(nomeUsuario + " foi adicionado à lista de espera.");
    }

    public String removerListaEspera() {
        if (listaEspera.isEmpty()) {
            System.out.println("A lista de espera está vazia!");
            return null;
        } else {
            String usuario = listaEspera.poll();
            System.out.println(usuario + " foi removido da lista de espera.");
            return usuario;
        }
    }

    public void visualizarLivro(String titulo) {
        for (Livro livro : colecaoLivros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                historicoNavegacao.push(livro);
                System.out.println("Visualizando: " + livro);
                return;
            }
        }
        System.out.println("Livro '" + titulo + "' não encontrado!");
    }

    public void mostrarHistorico() {
        if (historicoNavegacao.isEmpty()) {
            System.out.println("O histórico de navegação está vazio!");
        } else {
            System.out.println("Histórico de navegação (do mais recente ao mais antigo):");
            for (Livro livro : historicoNavegacao) {
                System.out.println(livro);
            }
        }
    }
}