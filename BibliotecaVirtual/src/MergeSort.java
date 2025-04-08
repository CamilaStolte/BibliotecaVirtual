class MergeSort {
    private static long contadorComparacoes = 0;

    public static String[] ordenar(String[] oldArr) {
        contadorComparacoes = 0;
        String[] arr = oldArr.clone();
        if (arr.length < 2) {
            return arr;
        }
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void mergeSort(String[] arr, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
            mergeSort(arr, esquerda, meio);
            mergeSort(arr, meio + 1, direita);
            merge(arr, esquerda, meio, direita);
        }
    }

    private static void merge(String[] arr, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        String[] esquerdaArr = new String[n1];
        String[] direitaArr = new String[n2];

        for (int i = 0; i < n1; i++)
            esquerdaArr[i] = arr[esquerda + i];
        for (int j = 0; j < n2; j++)
            direitaArr[j] = arr[meio + 1 + j];

        int i = 0, j = 0, k = esquerda;

        while (i < n1 && j < n2) {
            contadorComparacoes++;
            if (esquerdaArr[i].compareTo(direitaArr[j]) <= 0) {
                arr[k++] = esquerdaArr[i++];
            } else {
                arr[k++] = direitaArr[j++];
            }
        }

        while (i < n1) {
            arr[k++] = esquerdaArr[i++];
        }

        while (j < n2) {
            arr[k++] = direitaArr[j++];
        }
    }

    public static long getContadorComparacoes() {
        return contadorComparacoes;
    }
}