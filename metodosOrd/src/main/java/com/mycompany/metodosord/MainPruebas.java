/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.metodosord;
import java.util.Arrays;
import java.util.function.Consumer;
/**
 *
 * @author dm
 */
public class MainPruebas {
  


    public static void main(String[] args) {
        // Tamaños de los arreglos
        int[] tamanos = {1000, 5000, 10000, 50000, 100000};

        // Ciclo para probar con diferentes tamaños de arreglos
        for (int tamano : tamanos) {
            System.out.println("Tamaño del arreglo: " + tamano);

            // Generar arreglos con diferentes distribuciones
            int[] arreglou = GenerarArreglosPrueba.uniforme(0, 100000000, tamano);
            int[] arreglopc = GenerarArreglosPrueba.peorDeLosCasos(0, 100000000, tamano);
            int[] arreglomc = GenerarArreglosPrueba.mejorDeLosCasos(0, 100000000, tamano);
            int[] arreglo8020 = GenerarArreglosPrueba.dist8020(0, 100000000, tamano);
            int[] arreglo2080 = GenerarArreglosPrueba.dist2080(0, 100000000, tamano);

            
            /*
            // Medir y mostrar el tiempo de ejecución para el método de burbuja PENDIENTE
            medirTiempo("Burbuja (Uniforme)", arreglou.clone(), MetodosOrd::ordenarBurbuja);
            medirTiempo("Burbuja (Peor Caso)", arreglopc.clone(), MetodosOrd::ordenarBurbuja);
            medirTiempo("Burbuja (Mejor Caso)", arreglomc.clone(), MetodosOrd::ordenarBurbuja);
          

                        medirTiempo("Quicksort (Uniforme)", arreglou.clone(), arr -> MetodosOrd.ordenarQuickSort(arr, 0, arr.length - 1));
               medirTiempo("Quicksort (Peor Caso)", arreglopc.clone(), arr -> MetodosOrd.ordenarQuickSort(arr, 0, arr.length - 1));
               medirTiempo("Quicksort (Mejor Caso)", arreglomc.clone(), arr -> MetodosOrd.ordenarQuickSort(arr, 0, arr.length - 1));
               medirTiempo("Quicksort (Dist 80-20)", arreglo8020.clone(), arr -> MetodosOrd.ordenarQuickSort(arr, 0, arr.length - 1));
               medirTiempo("Quicksort (Dist 20-80)", arreglo2080.clone(), arr -> MetodosOrd.ordenarQuickSort(arr, 0, arr.length - 1));


            
            // Medir y mostrar el tiempo de ejecución para el método de intercalación
            medirTiempo("Intercalación (Uniforme)", arreglou.clone(), MetodosOrd::intercalacion);
            medirTiempo("Intercalación (Peor Caso)", arreglopc.clone(), MetodosOrd::intercalacion);
            medirTiempo("Intercalación (Mejor Caso)", arreglomc.clone(), MetodosOrd::intercalacion);
            medirTiempo("Intercalación (Dist 80-20)", arreglo8020.clone(), MetodosOrd::intercalacion);
            medirTiempo("Intercalación (Dist 20-80)", arreglo2080.clone(), MetodosOrd::intercalacion);
            
            
         

            // Medir y mostrar el tiempo de ejecución para el método de radixsort
            medirTiempo("Radixsort (Uniforme)", arreglou.clone(), MetodosOrd::radixSort);
            medirTiempo("Radixsort (Peor Caso)", arreglopc.clone(), MetodosOrd::radixSort);
            medirTiempo("Radixsort (Mejor Caso)", arreglomc.clone(), MetodosOrd::radixSort);
            medirTiempo("Radixsort (Dist 80-20)", arreglo8020.clone(), MetodosOrd::radixSort);
            medirTiempo("Radixsort (Dist 20-80)", arreglo2080.clone(), MetodosOrd::radixSort);

// Medir y mostrar el tiempo de ejecución para el método de mezcla directa
medirTiempo("Mezcla Directa (Uniforme)", arreglou.clone(), MetodosOrd::mezclaDirecta);
medirTiempo("Mezcla Directa (Mejor Caso)", arreglomc.clone(), MetodosOrd::mezclaDirecta);
medirTiempo("Mezcla Directa (Peor Caso)", arreglopc.clone(), MetodosOrd::mezclaDirecta);
medirTiempo("Mezcla Directa (Dist 80-20)", arreglo8020.clone(), MetodosOrd::mezclaDirecta);
medirTiempo("Mezcla Directa (Dist 20-80)", arreglo2080.clone(), MetodosOrd::mezclaDirecta);
            
            
            
            // Medir y mostrar el tiempo de ejecución para el método de intercalación
            medirTiempo("Intercalación (Uniforme)", arreglou.clone(), MetodosOrd::intercalacion);
            medirTiempo("Intercalación (Peor Caso)", arreglopc.clone(), MetodosOrd::intercalacion);
            medirTiempo("Intercalación (Mejor Caso)", arreglomc.clone(), MetodosOrd::intercalacion);
            medirTiempo("Intercalación (Dist 80-20)", arreglo8020.clone(), MetodosOrd::intercalacion);
            medirTiempo("Intercalación (Dist 20-80)", arreglo2080.clone(), MetodosOrd::intercalacion);
            
            

 medirTiempo("Quicksort (Uniforme)", arreglou.clone(), arr -> MetodosOrd.ordenarQuickSort(arr, 0, arr.length - 1));

medirTiempo("Quicksort (Peor Caso)", arreglopc.clone(), arr -> MetodosOrd.ordenarQuickSort(arr, 0, arr.length - 1));
medirTiempo("Quicksort (Mejor Caso)", arreglomc.clone(), arr -> MetodosOrd.ordenarQuickSort(arr, 0, arr.length - 1));
medirTiempo("Quicksort (Dist 80-20)", arreglo8020.clone(), arr -> MetodosOrd.ordenarQuickSort(arr, 0, arr.length - 1));
medirTiempo("Quicksort (Dist 20-80)", arreglo2080.clone(), arr -> MetodosOrd.ordenarQuickSort(arr, 0, arr.length - 1));

            
            // Medir y mostrar el tiempo de ejecución para el método de shellsort
            medirTiempo("Shellsort (Uniforme)", arreglou.clone(), MetodosOrd::shellSort);
            medirTiempo("Shellsort (Peor Caso)", arreglopc.clone(), MetodosOrd::shellSort);
            medirTiempo("Shellsort (Mejor Caso)", arreglomc.clone(), MetodosOrd::shellSort);
            medirTiempo("Shellsort (Dist 80-20)", arreglo8020.clone(), MetodosOrd::shellSort);
            medirTiempo("Shellsort (Dist 20-80)", arreglo2080.clone(), MetodosOrd::shellSort);
            
            // Medir y mostrar el tiempo de ejecución para el método de mezcla natural
medirTiempo("Mezcla Natural (Uniforme)", arreglou.clone(), arreglo -> MetodosOrd.mezclaNatural(arreglo));
medirTiempo("Mezcla Natural (Mejor Caso)", arreglomc.clone(), arreglo -> MetodosOrd.mezclaNatural(arreglo));
medirTiempo("Mezcla Natural (Peor Caso)", arreglopc.clone(), arreglo -> MetodosOrd.mezclaNatural(arreglo));
medirTiempo("Mezcla Natural (Dist 80-20)", arreglo8020.clone(), arreglo -> MetodosOrd.mezclaNatural(arreglo));
medirTiempo("Mezcla Natural (Dist 20-80)", arreglo2080.clone(), arreglo -> MetodosOrd.mezclaNatural(arreglo));
 
medirTiempo("Quicksort (Uniforme)", arreglou.clone(), arreglo -> MetodosOrd.ordenarQuickSort(arreglo, 0, arreglo.length - 1));
                
medirTiempo("Quicksort (Mejor Caso)", arreglomc.clone(), arreglo -> MetodosOrd.ordenarQuickSort(arreglo, 0, arreglo.length - 1));
            
medirTiempo("Quicksort (Mejor Caso)", arreglomc.clone(), arreglo -> MetodosOrd.ordenarQuickSort(arreglo, 0, arreglo.length - 1));
medirTiempo("Quicksort (Dist 80-20)", arreglo8020.clone(), arreglo -> MetodosOrd.ordenarQuickSort(arreglo, 0, arreglo.length - 1));
medirTiempo("Quicksort (Dist 20-80)", arreglo2080.clone(), arreglo -> MetodosOrd.ordenarQuickSort(arreglo, 0, arreglo.length - 1));
medirTiempo("Quicksort (Peor Caso)", arreglopc.clone(), arreglo -> MetodosOrd.ordenarQuickSort(arreglo, 0, arreglo.length - 1));

           medirTiempo("Burbuja (Peor Caso)", arreglopc.clone(), MetodosOrd::ordenarBurbuja);
          
            
        medirTiempo("Burbuja (Mejor Caso)", arreglomc.clone(), MetodosOrd::ordenarBurbuja);
*/
  
            medirTiempo("Burbuja (Dist 80-20)", arreglo8020.clone(), MetodosOrd::ordenarBurbuja);
            medirTiempo("Burbuja (Dist 20-80)", arreglo2080.clone(), MetodosOrd::ordenarBurbuja);
   
System.out.println(); // Separador entre tamaños de arreglos
        }
    }

    private static void medirTiempo(String nombreAlgoritmo, int[] arreglo, Consumer<int[]> algoritmo) {
        long inicio = System.currentTimeMillis();
        algoritmo.accept(arreglo);
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución (" + nombreAlgoritmo + "): " + (fin - inicio) + " ms");
    }
}


