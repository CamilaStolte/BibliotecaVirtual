class BubbleSort {
    private static long contadorComparacoes = 0;

    public static String[] ordenar(String[] oldArr) {
        contadorComparacoes = 0;
        String[] arr = oldArr.clone();
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                contadorComparacoes++;
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static long getContadorComparacoes() {
        return contadorComparacoes;
    }
}