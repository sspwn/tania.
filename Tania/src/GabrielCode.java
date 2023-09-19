public class GabrielCode{
    public static void main(String[] args) {
        int[] array1 = {10, 5, 8, 2, 1};

        System.out.println("Array original:");
        printArray(array1);

        long startTime = System.nanoTime(); // Captura o tempo inicial

        bubbleSort(array1);

        long endTime = System.nanoTime(); // Captura o tempo final

        double duration = (endTime - startTime) / 1e6; // Calcula a duração em milissegundos

        System.out.println("\nArray ordenado:");
        printArray(array1);
        System.out.println("Tempo de execução: " + duration + " milissegundos");
    }
    // Função para realizar o Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Trocar arr[j] e arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Se nenhum elemento foi trocado nesta passagem, a lista está ordenada
            if (!swapped) {
                break;
            }
        }
    }

    // Função auxiliar para imprimir um array
    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}