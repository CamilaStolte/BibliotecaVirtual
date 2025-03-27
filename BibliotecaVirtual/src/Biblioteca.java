import java.util.*;

public class Biblioteca {
    private LinkedList<Livro> colecaoLivros;
    private Queue<String> listaEspera;
    private Stack<Livro> historicoNavegacao;
    private HashMap<Livro, Set<Livro>> grafoRecomendacoes;

    public Biblioteca() {
        this.colecaoLivros = new LinkedList<>();
        this.listaEspera = new LinkedList<>();
        this.historicoNavegacao = new Stack<>();
        this.grafoRecomendacoes = new HashMap<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        Livro novoLivro = new Livro(titulo, autor, anoPublicacao);
        colecaoLivros.add(novoLivro);
        grafoRecomendacoes.put(novoLivro, new HashSet<>());
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

    public void adicionarRecomendacao(String tituloOrigem, String tituloRecomendado) {
        Livro origem = null, recomendado = null;
        for (Livro livro : colecaoLivros) {
            if (livro.getTitulo().equalsIgnoreCase(tituloOrigem))
                origem = livro;
            if (livro.getTitulo().equalsIgnoreCase(tituloRecomendado))
                recomendado = livro;
        }
        if (origem != null && recomendado != null) {
            grafoRecomendacoes.get(origem).add(recomendado);
            System.out.println("Recomendação adicionada: " + origem.getTitulo() + " -> " + recomendado.getTitulo());
        } else {
            System.out.println("Um dos livros não foi encontrado!");
        }
    }

    public void sugerirLivros(String titulo) {
        Livro livroBase = null;
        for (Livro livro : colecaoLivros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livroBase = livro;
                break;
            }
        }
        if (livroBase == null) {
            System.out.println("Livro '" + titulo + "' não encontrado!");
            return;
        }
        Set<Livro> recomendados = grafoRecomendacoes.get(livroBase);
        if (recomendados.isEmpty()) {
            System.out.println("Nenhuma recomendação para '" + titulo + "'.");
        } else {
            System.out.println("Recomendações para '" + titulo + "':");
            for (Livro rec : recomendados) {
                System.out.println(rec);
            }
        }
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

    public int getQuantidadeLivros() {
        return colecaoLivros.size();
    }
}