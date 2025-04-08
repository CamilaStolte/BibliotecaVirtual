import java.util.Random;

class GeradorDeNomesDeLivros {
    private static final int TAMANHO_MAXIMO_DO_NOME = 20;
    private static final String ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String ALFABETO_COM_ESPACO = ALFABETO + " ";

    public static String[] gerarNomes(int numeroDeLivros) {
        Random random = new Random();
        String[] nomesDeLivros = new String[numeroDeLivros];

        for (int i = 0; i < numeroDeLivros; i++) {
            nomesDeLivros[i] = gerarNomeAleatorio(random);
        }

        System.out.println("10 primeiros nomes gerados:");
        for (int i = 0; i < 10 && i < numeroDeLivros; i++) {
            System.out.println(nomesDeLivros[i]);
        }

        return nomesDeLivros;
    }

    private static String gerarNomeAleatorio(Random random) {
        int tamanhoDoNome = random.nextInt(TAMANHO_MAXIMO_DO_NOME - 1) + 2;
        StringBuilder sb = new StringBuilder(tamanhoDoNome);

        sb.append(ALFABETO.charAt(random.nextInt(ALFABETO.length())));

        for (int i = 1; i < tamanhoDoNome; i++) {
            sb.append(ALFABETO_COM_ESPACO.charAt(random.nextInt(ALFABETO_COM_ESPACO.length())));
        }

        return sb.toString();
    }
}