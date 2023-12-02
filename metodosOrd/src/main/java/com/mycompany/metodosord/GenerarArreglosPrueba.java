/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.metodosord;

import java.util.Random;

/**
 *
 * @author dm
 */

public class GenerarArreglosPrueba {
    public static int[] mejorDeLosCasos(int inicial, int cantidad, int incremento)
	{
		int arreglo[] = new int[cantidad];
		int dato = inicial;
		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i] = dato;
			dato += incremento;
		}
		
		return arreglo;
	}
	
	public static int[] peorDeLosCasos(int inicial, int cantidad, int incremento)
	{
		int mayor = (cantidad*incremento) + inicial - incremento;
		int arreglo[] = new int[cantidad];
		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i] = mayor;
			mayor -= incremento;
		}
		return arreglo;
	}
	
	public static int[] uniforme(int primero, int ultimo, int cantidad)
	{
		Random r = new Random();
		int datos[] = new int[cantidad];
		for (int i = 0; i < datos.length; i++) {
			datos[i] = r.nextInt(ultimo - primero +1) + primero;
		}
		return datos;
	}
	
	public static int[] dist8020(int primero, int ultimo, int cantidad)
	{
		Random r = new Random();
		int datos[] = new int[cantidad];
		int medio = (ultimo-primero+1)/2;
		for (int i = 0; i < datos.length; i++) {
			double p = r.nextDouble();
			if(p<=0.8)
			{
				datos[i] = r.nextInt(medio) + primero;
			}
			else
			{
				datos[i] = r.nextInt(ultimo-medio) + primero + medio;
			}
		}
		return datos;
	}
	
	public static int[] dist2080(int primero, int ultimo, int cantidad)
	{
		Random r = new Random();
		int datos[] = new int[cantidad];
		int medio = (ultimo-primero+1)/2;
		for (int i = 0; i < datos.length; i++) {
			double p = r.nextDouble();
			if(p<=0.2)
			{
				datos[i] = r.nextInt(medio) + primero;
			}
			else
			{
				datos[i] = r.nextInt(ultimo-medio) + primero + medio;
			}
		}
		return datos;
	}


	
	public static void printArray(int arr[])
	{
		for (int i = 0; i < arr.length; i++) {
			System.out.println("a[" + i + "]= " + arr[i]);
		}
	}
}
