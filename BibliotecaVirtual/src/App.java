public class App {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.adicionarLivro("It: A Coisa", "Stephen King", 1986);
        biblioteca.adicionarLivro("O Iluminado", "Stephen King", 1977);
        biblioteca.adicionarLivro("Carrie, a Estranha", "Stephen King", 1974);

        biblioteca.listarLivros();

        System.out.println("Total de livros na biblioteca: " + biblioteca.getQuantidadeLivros());
    }
}