public class App {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.adicionarLivro("It: A Coisa", "Stephen King", 1986);
        biblioteca.adicionarLivro("O Iluminado", "Stephen King", 1977);
        biblioteca.adicionarLivro("Carrie, a Estranha", "Stephen King", 1974);

        biblioteca.listarLivros();

        System.out.println("\nTestando a lista de espera:");
        biblioteca.adicionarListaEspera("Camila");
        biblioteca.adicionarListaEspera("Luan");
        biblioteca.removerListaEspera(); // Remove João

        System.out.println("\nTestando o histórico de navegação:");
        biblioteca.visualizarLivro("O Iluminado");
        biblioteca.visualizarLivro("It: A Coisa");
        biblioteca.mostrarHistorico();

        System.out.println("\nTotal de livros na biblioteca: " + biblioteca.getQuantidadeLivros());
    }
}