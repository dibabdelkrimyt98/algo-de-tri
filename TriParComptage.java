import java.util.Arrays;

public class TriParComptage {

    // Méthode de tri par comptage
    public static int[] countingSort(int[] A) {
        int n = A.length;

        // Trouver la valeur maximale
        int k = Arrays.stream(A).max().getAsInt();

        // Tableaux auxiliaires
        int[] C = new int[k + 1];
        int[] B = new int[n];

        // Initialisation du tableau de comptage
        for (int i = 0; i <= k; i++)
            C[i] = 0;

        // Comptage des occurrences
        for (int j = 0; j < n; j++)
            C[A[j]]++;

        // Cumul des positions
        for (int i = 1; i <= k; i++)
            C[i] += C[i - 1];

        // Construction du tableau trié (stabilité)
        for (int j = n - 1; j >= 0; j--) {
            B[C[A[j]] - 1] = A[j];
            C[A[j]]--;
        }

        return B;
    }

    public static void main(String[] args) {
        int[] A = {4, 2, 2, 8, 3, 3, 1};

        System.out.println("Tableau initial : " + Arrays.toString(A));

        long start = System.nanoTime();
        int[] B = countingSort(A);
        long end = System.nanoTime();

        System.out.println("Tableau trié : " + Arrays.toString(B));
        System.out.println("Temps d'exécution en nano: " + (end - start) + " ns");
        System.out.println("Temps d'exécution en mili : " + (end - start) / 1_000_000.0 + " ms");

    }
}
