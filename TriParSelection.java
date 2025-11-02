public class TriParSelection {
public static void TriParSelection(int [] A) {
    int n=A.length; 
    for (int i=0; i<n-1; i++) {
        int minIndex=i; 
        for (int j=i+1; j<n; j++) {
            if (A[j]<A[minIndex]) {
                minIndex=j; 
            }
        }
        int temp=A[i]; 
        A[i]=A[minIndex]; 
        A[minIndex]=temp; 
    }

}
public static void main(String[] args) {
    int[] A = {170, 45, 75, 90, 802, 24, 2, 66};

    System.out.println("Tableau initial : " + java.util.Arrays.toString(A));

    long start = System.nanoTime();
    TriParSelection(A);
    long end = System.nanoTime();

    System.out.println("Tableau trié : " + java.util.Arrays.toString(A));
    System.out.println("Temps d'exécution en nano : " + (end - start) + "ns");
    System.out.println("Temps d'exécution en mili : " + (end - start) / 1_000_000.0 + "ms");
}
}