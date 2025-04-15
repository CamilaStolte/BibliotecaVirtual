import java.util.*;

public class Biblioteca {
    private LinkedList<Livro> colecaoLivros;
    private Queue<String> listaEspera;
    private Stack<Livro> historicoNavegacao;
    private HashMap<Livro, Set<Livro>> grafoRecomendacoes;
    private NoArvore raiz;

    public Biblioteca() {
        this.colecaoLivros = new LinkedList<>();
        this.listaEspera = new LinkedList<>();
        this.historicoNavegacao = new Stack<>();
        this.grafoRecomendacoes = new HashMap<>();
        this.raiz = null;
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        Livro novoLivro = new Livro(titulo, autor, anoPublicacao);
        colecaoLivros.add(novoLivro);
        grafoRecomendacoes.put(novoLivro, new HashSet<>());
        if (raiz == null) {
            raiz = new NoArvore(novoLivro);
        } else {
            inserirNaArvore(raiz, novoLivro);
        }
        System.out.println("Livro adicionado com sucesso!");
    }

    private void inserirNaArvore(NoArvore no, Livro livro) {
        if (livro.getTitulo().compareToIgnoreCase(no.getLivro().getTitulo()) < 0) {
            if (no.getEsquerda() == null) {
                no.setEsquerda(new NoArvore(livro));
            } else {
                inserirNaArvore(no.getEsquerda(), livro);
            }
        } else {
            if (no.getDireita() == null) {
                no.setDireita(new NoArvore(livro));
            } else {
                inserirNaArvore(no.getDireita(), livro);
            }
        }
    }

    public void listarLivros() {
        if (raiz == null) {
            System.out.println("A biblioteca está vazia!");
        } else {
            System.out.println("Coleção de livros (em ordem alfabética):");
            listarEmOrdem(raiz);
        }
    }

    private void listarEmOrdem(NoArvore no) {
        if (no != null) {
            listarEmOrdem(no.getEsquerda());
            System.out.println(no.getLivro());
            listarEmOrdem(no.getDireita());
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
        Livro livro = buscarNaArvore(raiz, titulo);
        if (livro != null) {
            historicoNavegacao.push(livro);
            System.out.println("Visualizando: " + livro);
        } else {
            System.out.println("Livro '" + titulo + "' não encontrado!");
        }
    }

    private Livro buscarNaArvore(NoArvore no, String titulo) {
        if (no == null) {
            return null;
        }
        int comparacao = titulo.compareToIgnoreCase(no.getLivro().getTitulo());
        if (comparacao == 0) {
            return no.getLivro();
        } else if (comparacao < 0) {
            return buscarNaArvore(no.getEsquerda(), titulo);
        } else {
        return buscarNaArvore(no.getDireita(), titulo);
    }
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

    public boolean buscaEmProfundidade(String titulo) {
        List<String> visitados = new ArrayList<>();
        boolean encontrado = buscaEmProfundidadeRecursivo(raiz, titulo, visitados);
        System.out.print("Caminho DFS: ");
        for (int i = 0; i < visitados.size(); i++) {
            System.out.print(visitados.get(i));
            if (i < visitados.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    
        return encontrado;
    }

    private boolean buscaEmProfundidadeRecursivo(NoArvore no, String titulo, List<String> visitados) {
        if (no == null) return false;

        visitados.add(no.getLivro().getTitulo());

        if (no.getLivro().getTitulo().equalsIgnoreCase(titulo)) return true;

        return buscaEmProfundidadeRecursivo(no.getEsquerda(), titulo, visitados) ||
               buscaEmProfundidadeRecursivo(no.getDireita(), titulo, visitados);
    }

    public boolean buscaEmLargura(String titulo) {
        if (raiz == null) {
            System.out.println("Caminho BFS: []");
            return false;
        }
        List<String> visitados = new ArrayList<>();
        Queue<NoArvore> fila = new LinkedList<>();
        fila.add(raiz);
    
        while (!fila.isEmpty()) {
            NoArvore atual = fila.poll();
            visitados.add(atual.getLivro().getTitulo());
    
            if (atual.getLivro().getTitulo().equalsIgnoreCase(titulo)) {
                System.out.print("Caminho BFS: ");
                for (int i = 0; i < visitados.size(); i++) {
                    System.out.print(visitados.get(i));
                    if (i < visitados.size() - 1) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println();
                return true;
            }
    
            if (atual.getEsquerda() != null) {
                fila.add(atual.getEsquerda());
            }
            if (atual.getDireita() != null) {
                fila.add(atual.getDireita());
            }
        }
    
        System.out.print("Caminho BFS: ");
        for (int i = 0; i < visitados.size(); i++) {
            System.out.print(visitados.get(i));
            if (i < visitados.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
        return false;
    }

    public void recomendarPorDijkstra(String tituloOrigem) {
        Livro origem = null;
        for (Livro livro : colecaoLivros) {
            if (livro.getTitulo().equalsIgnoreCase(tituloOrigem)) {
                origem = livro;
                break;
            }
        }
        if (origem == null) {
            System.out.println("Livro '" + tituloOrigem + "' não encontrado!");
            return;
        }

        Map<Livro, Integer> distancias = djikstraSimples(grafoRecomendacoes, origem);
        System.out.println("\nRecomendações baseadas na menor distância a partir de '" + tituloOrigem + "':");
        List<Map.Entry<Livro, Integer>> listaDistancias = new ArrayList<>(distancias.entrySet());
        listaDistancias.sort((a, b) -> a.getValue().compareTo(b.getValue()));
        for (Map.Entry<Livro, Integer> entrada : listaDistancias) {
            if (!entrada.getKey().equals(origem)) {
                System.out.println("Livro: " + entrada.getKey().getTitulo() + ", Distância: " + entrada.getValue());
            }
        }
    }

    private Map<Livro, Integer> djikstraSimples(HashMap<Livro, Set<Livro>> grafo, Livro origem) {
        Map<Livro, Integer> distancias = new HashMap<>();
        Queue<Livro> fila = new LinkedList<>();
        distancias.put(origem, 0);
        fila.add(origem);

        while (!fila.isEmpty()) {
            Livro atual = fila.poll();
            int distanciaAtual = distancias.get(atual);

            for (Livro vizinho : grafo.getOrDefault(atual, new HashSet<>())) {
                if (!distancias.containsKey(vizinho)) {
                    distancias.put(vizinho, distanciaAtual + 1);
                    fila.add(vizinho);
                }
            }
        }
        return distancias;
    }
}
