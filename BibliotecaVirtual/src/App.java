import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.adicionarLivro("1984", "George Orwell", 1949);
        biblioteca.adicionarLivro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954);
        biblioteca.adicionarLivro("Dom Casmurro", "Machado de Assis", 1899);
        biblioteca.adicionarLivro("Cem Anos de Solidão", "Gabriel García Márquez", 1967);
        biblioteca.adicionarLivro("It: A Coisa", "Stephen King", 1986);
        biblioteca.adicionarLivro("O Nome do Vento", "Patrick Rothfuss", 2007);
        biblioteca.adicionarLivro("Duna", "Frank Herbert", 1965);
        biblioteca.adicionarLivro("Orgulho e Preconceito", "Jane Austen", 1813);
        biblioteca.adicionarLivro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943);
        biblioteca.adicionarLivro("A Metamorfose", "Franz Kafka", 1915);

        biblioteca.adicionarRecomendacao("1984", "Duna");
        biblioteca.adicionarRecomendacao("1984", "A Metamorfose");
        biblioteca.adicionarRecomendacao("O Senhor dos Anéis", "O Nome do Vento");
        biblioteca.adicionarRecomendacao("O Senhor dos Anéis", "Duna");
        biblioteca.adicionarRecomendacao("Dom Casmurro", "Orgulho e Preconceito");
        biblioteca.adicionarRecomendacao("Dom Casmurro", "Cem Anos de Solidão");
        biblioteca.adicionarRecomendacao("Cem Anos de Solidão", "Dom Casmurro");
        biblioteca.adicionarRecomendacao("Cem Anos de Solidão", "O Pequeno Príncipe");
        biblioteca.adicionarRecomendacao("It: A Coisa", "A Metamorfose");
        biblioteca.adicionarRecomendacao("It: A Coisa", "1984");
        biblioteca.adicionarRecomendacao("O Nome do Vento", "O Senhor dos Anéis");
        biblioteca.adicionarRecomendacao("O Nome do Vento", "Duna");
        biblioteca.adicionarRecomendacao("Duna", "1984");
        biblioteca.adicionarRecomendacao("Duna", "O Nome do Vento");
        biblioteca.adicionarRecomendacao("Orgulho e Preconceito", "Dom Casmurro");
        biblioteca.adicionarRecomendacao("Orgulho e Preconceito", "Cem Anos de Solidão");
        biblioteca.adicionarRecomendacao("O Pequeno Príncipe", "Cem Anos de Solidão");
        biblioteca.adicionarRecomendacao("O Pequeno Príncipe", "O Nome do Vento");
        biblioteca.adicionarRecomendacao("A Metamorfose", "It: A Coisa");
        biblioteca.adicionarRecomendacao("A Metamorfose", "1984");

        biblioteca.listarLivros();

        System.out.println("\nTotal de livros na biblioteca: " + biblioteca.getQuantidadeLivros());
        System.out.println("\nTestando recomendações:");
        biblioteca.sugerirLivros("1984");
        biblioteca.sugerirLivros("O Senhor dos Anéis");
        biblioteca.sugerirLivros("It: A Coisa");

        System.out.println("\n=== Teste de Ordenação com 10.000 Livros ===");
        
        String[] titulosAleatorios = GeradorDeNomesDeLivros.gerarNomes(10000);

        System.out.println("\nPrimeiros 5 elementos antes da ordenação:");
        for (int i = 0; i < 5 && i < titulosAleatorios.length; i++) {
            System.out.println((i + 1) + ": \"" + titulosAleatorios[i] + "\" (length: " + titulosAleatorios[i].length() + ")");
        }

        long inicioBubble = System.currentTimeMillis();
        String[] resultadoBubble = BubbleSort.ordenar(titulosAleatorios.clone());
        long fimBubble = System.currentTimeMillis();

        long inicioMerge = System.currentTimeMillis();
        String[] resultadoMerge = MergeSort.ordenar(titulosAleatorios.clone());
        long fimMerge = System.currentTimeMillis();

        System.out.println("\nResultados da ordenação:");
        System.out.println("Bubble Sort:");
        System.out.println("Tempo: " + (fimBubble - inicioBubble) + "ms");
        System.out.println("Comparações: " + BubbleSort.getContadorComparacoes());
        
        System.out.println("\nMerge Sort:");
        System.out.println("Tempo: " + (fimMerge - inicioMerge) + "ms");
        System.out.println("Comparações: " + MergeSort.getContadorComparacoes());
        
        System.out.println("\nVerificando arrays ordenados:");
        System.out.println("Tamanho do resultadoBubble: " + (resultadoBubble != null ? resultadoBubble.length : "null"));
        System.out.println("Tamanho do resultadoMerge: " + (resultadoMerge != null ? resultadoMerge.length : "null"));

        System.out.println("\nPrimeiros 5 livros ordenados (Bubble Sort):");
        if (resultadoBubble != null && resultadoBubble.length > 0) {
            for (int i = 0; i < 5 && i < resultadoBubble.length; i++) {
                String value = resultadoBubble[i] != null ? "\"" + resultadoBubble[i] + "\"" : "null";
                System.out.println((i + 1) + ": " + value + " (length: " + (resultadoBubble[i] != null ? resultadoBubble[i].length() : -1) + ")");
            }
        } else {
            System.out.println("Erro: Array do Bubble Sort está vazio ou nulo!");
        }
        
        System.out.println("\nPrimeiros 5 livros ordenados (Merge Sort):");
        if (resultadoMerge != null && resultadoMerge.length > 0) {
            for (int i = 0; i < 5 && i < resultadoMerge.length; i++) {
                String value = resultadoMerge[i] != null ? "\"" + resultadoMerge[i] + "\"" : "null";
                System.out.println((i + 1) + ": " + value + " (length: " + (resultadoMerge[i] != null ? resultadoMerge[i].length() : -1) + ")");
            }
        } else {
            System.out.println("Erro: Array do Merge Sort está vazio ou nulo!");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Busca de Livros ===");
        System.out.print("Digite o título do livro que deseja buscar: ");
        String tituloBusca = scanner.nextLine();

        System.out.println("\nBuscando '" + tituloBusca + "' usando DFS:");
        boolean encontradoDFS = biblioteca.buscaEmProfundidade(tituloBusca);
        System.out.println("Resultado DFS: " + (encontradoDFS ? "Livro encontrado!" : "Livro não encontrado."));

        System.out.println("\nBuscando '" + tituloBusca + "' usando BFS:");
        boolean encontradoBFS = biblioteca.buscaEmLargura(tituloBusca);
        System.out.println("Resultado BFS: " + (encontradoBFS ? "Livro encontrado!" : "Livro não encontrado."));

        scanner.close();
    }
}