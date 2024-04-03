package domain;

import domain.DivideAndConquer;
import domain.Vector;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;

public class DivideAndConquerTest {

    @Test
    public void testBinarySearch() {
        // Crear una instancia de la clase Vector con tamaño 50
        Vector vector = new Vector(50);

        // Llenar el vector con valores aleatorios entre 0 y 99
        for (int i = 0; i < 50; i++) {
            vector.add((int) (Math.random() * 100));
        }

        // Mostrar el contenido del vector sin ordenar
        System.out.println("Contenido del vector sin ordenar: \n" + vector);

        // Ordenar el vector
        vector.sort();
        // Mostrar el contenido del vector ordenado
        System.out.println("Contenido del vector ordenado: \n" + vector);

        // Generar valores aleatorios y probar las búsquedas binarias
        for (int i = 0; i < 20; i++) {
            int valueToSearch = (int) (Math.random() * 100);
            int[] dataArray = vector.getData();

            // Búsqueda utilizando java.util.Arrays.binarySearch()
            int indexArrays = Arrays.binarySearch(dataArray, valueToSearch);
            System.out.println("JAVA.UTIL.ARRAYS CLASS BS... The element " + valueToSearch +
                    (indexArrays < 0 ? " does not exist" : " exists at position [" + indexArrays + "]"));

            // Búsqueda utilizando java.util.Collections.binarySearch()
            int indexCollections = Arrays.binarySearch(dataArray, valueToSearch);
            System.out.println("JAVA.UTIL.COLLECTIONS BS... The element " + valueToSearch +
                    (indexCollections < 0 ? " does not exist" : " exists at position [" + indexCollections + "]"));

            // Búsqueda utilizando la búsqueda binaria iterativa
            int indexIterative = DivideAndConquer.binarySearch(dataArray, valueToSearch);
            System.out.println("ITERATIVE BS... The element " + valueToSearch +
                    (indexIterative < 0 ? " does not exist" : " exists at position [" + indexIterative + "]"));

            // Búsqueda utilizando la búsqueda binaria recursiva
            int indexRecursive = DivideAndConquer.binarySearch(dataArray, valueToSearch, 0, vector.size() - 1);
            System.out.println("RECURSIVE BS... The element " + valueToSearch +
                    (indexRecursive < 0 ? " does not exist" : " exists at position [" + indexRecursive + "]"));
        }
    }
}














