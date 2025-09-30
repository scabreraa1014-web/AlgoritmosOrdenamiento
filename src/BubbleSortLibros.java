import java.util.Scanner;

public class BubbleSortLibros {

    private static int comparaciones = 0;
    private static int intercambios = 0;

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.println(">>> Pasada " + (i + 1));
            for (int j = 0; j < n - i - 1; j++) {
                comparaciones++; 
                if (less(a[j + 1], a[j])) {
                    exch(a, j, j + 1);
                    intercambios++; 
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
            System.out.print(elem + " | ");
        }
        System.out.println();
    }

    // Método para comprobar que el arreglo está ordenado
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese títulos de libros separados por coma:");
        String linea = sc.nextLine();
        String[] libros = linea.split(",");

        System.out.println("\nLista original de libros:");
        show(libros);

        comparaciones = 0;
        intercambios = 0;

        sort(libros);

        System.out.println("\nLista final de libros ordenados:");
        show(libros);
        
        System.out.println("\n--- Análisis de complejidad ---");
        System.out.println("Número de libros (n): " + libros.length);
        System.out.println("Comparaciones realizadas: " + comparaciones);
        System.out.println("Intercambios realizados: " + intercambios);

        sc.close();
    }
}
