/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.metodosord;

import java.util.Arrays;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author dm
 */
public class MetodosOrd {
    
//burbuja
    public static void ordenarBurbuja(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    public static int[] intercalacion(int[] listaA, int[] listaB) {
        int[] listaResultado = new int[listaA.length + listaB.length];
        int i = 0, j = 0, k = 0;

        while (i < listaA.length && j < listaB.length) {
            if (listaA[i] < listaB[j]) {
                listaResultado[k++] = listaA[i++];
            } else {
                listaResultado[k++] = listaB[j++];
            }
        }

        while (i < listaA.length) {
            listaResultado[k++] = listaA[i++];
        }

        while (j < listaB.length) {
            listaResultado[k++] = listaB[j++];
        }

        return listaResultado;
    }
    // Quicksort
  public static void ordenarQuickSort(int[] arreglo, int izquierda, int derecha) {
        // Utilizar una pila para almacenar los límites
        Stack<Integer> stack = new Stack<>();
        stack.push(izquierda);
        stack.push(derecha);

        // Proceso de partición y ordenación de manera iterativa
        while (!stack.isEmpty()) {
            derecha = stack.pop();
            izquierda = stack.pop();

            int indiceParticion = particion(arreglo, izquierda, derecha);

            // Agregar los límites de las subarreglos a la pila
            if (indiceParticion - 1 > izquierda) {
                stack.push(izquierda);
                stack.push(indiceParticion - 1);
            }

            if (indiceParticion + 1 < derecha) {
                stack.push(indiceParticion + 1);
                stack.push(derecha);
            }
        }
    }

    private static int particion(int[] arreglo, int izquierda, int derecha) {
        if (izquierda >= 0 && derecha < arreglo.length) {
            int pivote = arreglo[derecha];
            int i = izquierda;
            for (int j = izquierda; j < derecha; j++) {
                if (arreglo[j] <= pivote) {
                    intercambiar(arreglo, i, j);
                    i++;
                }
            }
            intercambiar(arreglo, i, derecha);
            return i;
        } else {
            System.err.println("Error: Límites fuera de los límites del arreglo");
            return -1; // o maneja de alguna manera el error en tu lógica
        }
    }

    private static void intercambiar(int[] arreglo, int i, int j) {
        int temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }


    public static void mostrarMensaje(String mensaje, int[] arreglo) {
        StringBuilder sb = new StringBuilder(mensaje + "\n");
        for (int i : arreglo) {
            sb.append(i).append(" ");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    //shellsort
  public static void shellSort(int[] arreglo) {
        int numero = arreglo.length;
        int incremento = numero / 2;

        while (incremento > 0) {
            for (int i = incremento; i < numero; i++) {
                int j = i;
                int aux = arreglo[i];

                while (j >= incremento && arreglo[j - incremento] > aux) {
                    arreglo[j] = arreglo[j - incremento];
                    j -= incremento;
                }

                arreglo[j] = aux;
            }

            incremento /= 2;
        }
    }
  //radix
  
    public static void radixSort(int arr[]) {
        int n = arr.length;
        int max = getMax(arr, n);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, n, exp);
        }
    }

    private static int getMax(int arr[], int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

 private static void countingSort(int arr[], int n, int exp) {
    int output[] = new int[n];
    int count[] = new int[19]; 
    Arrays.fill(count, 0);

    for (int i = 0; i < n; i++) {
        count[getDigit(arr[i], exp)]++;
    }

    for (int i = 1; i < 19; i++) {
        count[i] += count[i - 1];
    }

    for (int i = n - 1; i >= 0; i--) {
        output[count[getDigit(arr[i], exp)] - 1] = arr[i];
        count[getDigit(arr[i], exp)]--;
    }

    for (int i = 0; i < n; i++) {
        arr[i] = output[i];
    }
}

private static int getDigit(int number, int position) {
    return (number / position) % 10 + 9; 
}


    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
   //mergesort
    public int [] mergeSort(int [] arreglo){
        if(arreglo.length <= 1){
            return arreglo;
        }else{
            int [] left;
            int [] right;
            right = new int [arreglo.length / 2];
            if(arreglo.length % 2 == 0){
                left = new int [arreglo.length / 2];
            }else{
                left = new int [arreglo.length / 2 + 1];
            }
            int i;
            for (i = 0; i < left.length; ++i){
                left[i] = arreglo[i];
            }
            int k = 0;
            for (int j = i; j < arreglo.length; ++j){
                right[k] = arreglo[j];
                ++k;
            } 
            int [] arrayOrdenado = merge(mergeSort(left), mergeSort(right));
            return arrayOrdenado;
        }
    }
    public int [] merge(int [] b, int [] c){
        int i = 0;  
        int j = 0;
        int [] a = new int [b.length + c.length];
        for (int k = 0; k < a.length; ++k){
            if(b[i] < c[j]){
                a[k] = b[i];
                ++i;
            }else{
                a[k] = c[j];
                ++j;
            }
            if(i == b.length){                
                ++k;
                for (j = j; j < c.length; j++){
                    a[k] = c[j];
                    ++k;
                }
            }else if(j == c.length){                
                ++k;
                for (i = i; i < b.length; i++){
                    a[k] = b[i];
                    ++k;
                }
            }            
        }
        return a;
    }
    
    //intercalacion 
    public static void intercalacion(int[] arreglo) {
    ordenarPorIntercalacion(arreglo);
}

// Método para ordenar por intercalación
private static void ordenarPorIntercalacion(int[] arreglo) {
    int n = arreglo.length;
    if (n <= 1) {
        return;
    }

    int mitad = n / 2;
    int[] mitadIzquierda = Arrays.copyOfRange(arreglo, 0, mitad);
    int[] mitadDerecha = Arrays.copyOfRange(arreglo, mitad, n);

    // Ordenar recursivamente las dos mitades
    ordenarPorIntercalacion(mitadIzquierda);
    ordenarPorIntercalacion(mitadDerecha);

    // Mezclar las dos mitades ordenadas
    int i = 0, j = 0, k = 0;
    while (i < mitadIzquierda.length && j < mitadDerecha.length) {
        if (mitadIzquierda[i] <= mitadDerecha[j]) {
            arreglo[k++] = mitadIzquierda[i++];
        } else {
            arreglo[k++] = mitadDerecha[j++];
        }
    }

    // Agregar cualquier elemento restante de las dos mitades
    while (i < mitadIzquierda.length) {
        arreglo[k++] = mitadIzquierda[i++];
    }

    while (j < mitadDerecha.length) {
        arreglo[k++] = mitadDerecha[j++];
    }
}

    // Mezcla Directa
    public static int[] mezclaDirecta(int[] arreglo) {
        if (arreglo.length <= 1) {
            return arreglo;
        }

        int medio = arreglo.length / 2;
        int[] izquierda = Arrays.copyOfRange(arreglo, 0, medio);
        int[] derecha = Arrays.copyOfRange(arreglo, medio, arreglo.length);

        izquierda = mezclaDirecta(izquierda);
        derecha = mezclaDirecta(derecha);

        return merge2(izquierda, derecha);
    }

    private static int[] merge2(int[] izquierda, int[] derecha) {
        int[] resultado = new int[izquierda.length + derecha.length];
        int i = 0, j = 0, k = 0;

        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] < derecha[j]) {
                resultado[k++] = izquierda[i++];
            } else {
                resultado[k++] = derecha[j++];
            }
        }

        while (i < izquierda.length) {
            resultado[k++] = izquierda[i++];
        }

        while (j < derecha.length) {
            resultado[k++] = derecha[j++];
        }

        return resultado;
    }

   public static void mezclaNatural(int[] arreglo) {
    int izquierda, izq, derecha, der;
    boolean ordenado;

    do {
        ordenado = true;
        izquierda = 0;

        while (izquierda < arreglo.length - 1) {
            izq = izquierda;

            while (izq < arreglo.length - 1 && arreglo[izq] <= arreglo[izq + 1]) {
                izq++;
            }

            der = izq + 1;

            while (der == arreglo.length - 1 || der < arreglo.length - 1 && arreglo[der] <= arreglo[der + 1]) {
                der++;
            }

            if (der <= arreglo.length - 1) {
                mezclaDirecta2(arreglo, izquierda, der, arreglo.length - 1);
                ordenado = false;
            }

            izquierda = izq;
        }
    } while (!ordenado);
}

    private static void mezclaDirecta2(int[] arreglo, int izquierda, int medio, int derecha) {
        int i, j, k;
        int[] resultado = new int[derecha - izquierda + 1];
        i = izquierda;
        j = medio + 1;
        k = 0;

        while (i <= medio && j <= derecha) {
            if (arreglo[i] < arreglo[j]) {
                resultado[k++] = arreglo[i++];
            } else {
                resultado[k++] = arreglo[j++];
            }
        }

        while (i <= medio) {
            resultado[k++] = arreglo[i++];
        }

        while (j <= derecha) {
            resultado[k++] = arreglo[j++];
        }

        for (i = 0; i < k; i++) {
            arreglo[izquierda + i] = resultado[i];
        }
    }
}
