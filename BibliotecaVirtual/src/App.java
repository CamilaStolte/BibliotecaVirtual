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
    }
}