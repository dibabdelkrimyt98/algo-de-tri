import java.util.Arrays;

public class TriParBase {

    // Tri par comptage utilisé comme sous-procédure
    public static void countingSort(int[] A, int exp) {
        int n = A.length;
        int[] B = new int[n];
        int[] C = new int[10]; // chiffres 0-9

        // Comptage des occurrences selon le chiffre courant
        for (int i = 0; i < n; i++) {
            int index = (A[i] / exp) % 10;
            C[index]++;
        }

        // Cumul des positions
        for (int i = 1; i < 10; i++)
            C[i] += C[i - 1];

        // Construction du tableau trié (de droite à gauche pour stabilité)
        for (int i = n - 1; i >= 0; i--) {
            int index = (A[i] / exp) % 10;
            B[C[index] - 1] = A[i];
            C[index]--;
        }

        // Copier B dans A
        System.arraycopy(B, 0, A, 0, n);
    }

    // Tri par base (Radix Sort)
    public static void radixSort(int[] A) {
        int max = Arrays.stream(A).max().getAsInt();

        // Appliquer countingSort pour chaque chiffre
        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSort(A, exp);
    }

    public static void main(String[] args) {
        int[] A = {170, 45, 75, 90, 802, 24, 2, 66};

        System.out.println("Tableau initial : " + Arrays.toString(A));

        long start = System.nanoTime();
        radixSort(A);
        long end = System.nanoTime();

        System.out.println("Tableau trié : " + Arrays.toString(A));
        System.out.println("Temps d'exécution en nano : " + (end - start) + "ns");
        System.out.println("Temps d'exécution en mili : " + (end - start) / 1_000_000.0 + "ms");
    }
}
