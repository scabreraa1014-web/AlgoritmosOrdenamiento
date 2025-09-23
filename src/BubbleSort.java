import java.util.Scanner;

public class BubbleSort {

    /**
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.println(">>> Pasada " + (i + 1));
            for (int j = 0; j < n - i - 1; j++) {
                if (less(a[j + 1], a[j])) {
                    exch(a, j, j + 1);
                    System.out.print("Intercambio en posición " + j + ": ");
                    show(a);
                }
            }
          
            System.out.print("Estado después de pasada " + (i + 1) + ": ");
            show(a);
            System.out.println("----------------------------------");
        }
        assert isSorted(a);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void show(Comparable[] a) {
        for (Comparable elem : a) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese elementos separados por espacio:");
        String linea = sc.nextLine();
        String[] datos = linea.split(" ");

        System.out.println("Arreglo original:");
        show(datos);

        sort(datos);

        System.out.println("Arreglo final ordenado:");
        show(datos);

        sc.close();
    }
}
