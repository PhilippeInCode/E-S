package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio14 {
	static boolean isEncontrado = false;

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce la ruta del directorio:");

		try {
			String directorio = br.readLine();

			System.out.println("Introduce el nombre del archivo:");
			String nombreArchivo = br.readLine();
			buscarArchivo(directorio, nombreArchivo);
			seHaEncontrado();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void buscarArchivo(String directorio, String nombreArchivo) {
		File dir = new File(directorio);

		File[] archivos = dir.listFiles();
		if (archivos != null) {

			for (File archivo : archivos) {
				if (archivo.isDirectory()) {
					buscarArchivo(archivo.getAbsolutePath(), nombreArchivo);
				} else if (archivo.isFile() && archivo.getName().equals(nombreArchivo)) {
					System.out.println("Se ha encontrado en la ruta: " + archivo.getAbsolutePath());
					isEncontrado = true;
					mostrarContenido(archivo);
					return;
				}
			}

		}

	}

	public static void mostrarContenido(File archivo) {
		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			String linea;
			System.out.println("Contenido de " + archivo.getName() + ":");
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void seHaEncontrado() {
		if (!isEncontrado) {
			System.out.println("No se ha encontrado el archivo");
		}
	}
}