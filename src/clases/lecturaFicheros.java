package clases;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lecturaFicheros {

	public static void main(String[] args) {
//		numPrimos(); // Ejercicio 1 - Los 500 primeros números primos en un fichero
//		lectura(); // Ejercicio 2 - Leer los números primos del ejercicio 1
//		dosFicheros(); // Ejercicio 3 - Guardar en un fichero el contenido de dos ficheros intercalando
//		ordenaAlfabeticamente(); // Ejercicio 4 - Ordenar palabras alfabeticamente
		// Ejercicio 5 - Eliminar comentarios de un programa en Java, no lo tengo
//		ocurrenciasPalabra(); // Ejercicio 6 - Ocurrencias de una palabra
//		lecturaYMuestra(); // Ejercicio 7 Lectura Linea y mostrar contenido
//		leerCaracterACaracter(); // Ejercicio 7 Lectura Caracter y mostrar contenido
//		leeNombreYMuestra(); // Ejercicio 8 Nombre y muestra contenido
//		conversionMinusYMayus(); // Ejercicio 9 - Lee contenido de archivo y muestra contenido haciendo conversión
//		lineasX(); // Ejercicio 10 - Crea un archivo y escribe la cadena Linea X
//		listarDirectorio(); // Ejercicio 11 - Programa que lista el contenido de un directorio
		// Ejercicio 12 - Esta repetido xd
//		 obtenerArchivosPorExtension(); // Ejercicio 13 - Pasas una ruta y una extensión y te lista los archivos con esa extensión
		// Ejercicio 14 - Lo tengo hecho a parte
//		palabraMasLarga(); // Ejercicio 15 - Busca la palabra más larga en un archivo 
		// Ejercicio 16 - Clase asignaturaUniversitaria, en clase a parte
//		quitarPrimeraLetra(); // Ejercicio 17 - Quitar la primera letra de las palabras contenidas en un archivo y conversion mayus a minus y viceversa
		ordenAscendente(); // Ejercicio 18 - Leer archivo y decir cual es la ultima cadena en orden ascendente
		
		
	}
	
	 public static void ordenAscendente() {
	        String rutaArchivo = "C:\\Users\\User\\Desktop\\FELIPE STUFF\\DAW\\Programación\\3º Trimestre\\pruebasFicheros\\harto.txt";

	        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
	            List<String> cadenas = new ArrayList<>();

	            // Leer todas las líneas y almacenarlas en la lista
	            String linea;
	            while ((linea = br.readLine()) != null) {
	            		cadenas.add(linea);
	            }

	            // Ordenar la lista en orden alfabético ascendente
	            Collections.sort(cadenas);

	            // La última cadena en orden ascendente es la última en la lista
	            String ultimaCadena = cadenas.get(cadenas.size() - 1);

	            System.out.println("La última cadena en orden alfabético ascendente es: \"" + ultimaCadena + "\"");

	        } catch (IOException e) {
	            System.err.println("Error al leer el archivo: " + e.getMessage());
	        }
	    }

	
	 public static void quitarPrimeraLetra() {
	        String rutaArchivo = "C:\\Users\\User\\Desktop\\FELIPE STUFF\\DAW\\Programación\\3º Trimestre\\pruebasFicheros\\tocaPelotas.txt";
	        String rutaArchivoTemporal = "C:\\Users\\User\\Desktop\\FELIPE STUFF\\DAW\\Programación\\3º Trimestre\\pruebasFicheros\\tocaPelotas_temp.txt";

	        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
	             BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivoTemporal))) {

	            String linea;
	            while ((linea = br.readLine()) != null) {
	                String[] palabras = linea.split(" ");

	                for (int i = 0; i < palabras.length; i++) {
	                    String palabra = palabras[i];

	                    // Eliminar primera letra
	                    if (palabra.length() > 1) {
	                        palabra = palabra.substring(1);
	                    } else {
	                        palabra = "";
	                    }

	                    // Cambiar vocales
	                    palabra = cambiarVocales(palabra);

	                    palabras[i] = palabra;
	                }

	                // Escribir línea modificada en el archivo temporal
	                bw.write(String.join(" ", palabras));
	                bw.newLine();
	            }

	        } catch (IOException e) {
	            System.err.println("Error al procesar el archivo: " + e.getMessage());
	        }

	        // Reemplazar el archivo original con el archivo temporal
	        File archivoOriginal = new File(rutaArchivo);
	        File archivoTemporal = new File(rutaArchivoTemporal);
	        archivoOriginal.delete();
	        archivoTemporal.renameTo(archivoOriginal);
	    }

	 public static String cambiarVocales(String palabra) {
	        StringBuilder resultado = new StringBuilder();

	        for (int i = 0; i < palabra.length(); i++) {
	            char caracter = palabra.charAt(i);
	            if (esVocal(caracter)) {
	                resultado.append(Character.isUpperCase(caracter) ? Character.toLowerCase(caracter) : Character.toUpperCase(caracter));
	            } else {
	                resultado.append(caracter);
	            }
	        }

	        return resultado.toString();
	    }

	    public static boolean esVocal(char c) {
	        return "AEIOUaeiou".indexOf(c) != -1;
	    }
	
	public static void palabraMasLarga() {
		String ruta = "C:\\Users\\User\\Desktop\\FELIPE STUFF\\DAW\\Programación\\3º Trimestre\\pruebasFicheros\\palabras.txt";
		String palabraMasLarga = "";

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split("\\s+"); // Dividir la línea en palabras
                for (String palabra : palabras) {
                    // Verificar si la palabra actual es más larga que la palabra más larga actual
                    if (palabra.length() > palabraMasLarga.length()) {
                        palabraMasLarga = palabra;
                    }
                }
            }
            if (!palabraMasLarga.isEmpty()) {
                System.out.println("La palabra más larga en el archivo es: " + palabraMasLarga);
            } else {
                System.out.println("No se encontraron palabras en el archivo.");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
		
	public static void obtenerArchivosPorExtension() {
		String rutaDirectorio = "C:\\Users\\User\\Desktop\\FELIPE STUFF\\DAW\\Programación\\3º Trimestre\\Teoría";
        String extension = "pdf"; // Extensión específica de los archivos que quieres obtener
        
        File directorio = new File(rutaDirectorio);

        // Verificar si la ruta corresponde a un directorio
        if (!directorio.isDirectory()) {
            System.out.println("La ruta especificada no corresponde a un directorio.");
            return;
        }

        // Obtener la lista de archivos en el directorio especificado
        File[] archivos = directorio.listFiles();

        // Recorrer la lista de archivos y filtrar por la extensión específica
        System.out.println("Archivos con la extensión '" + extension + "' en el directorio '" + rutaDirectorio + "':");
        for (File archivo : archivos) {
            if (archivo.isFile() && archivo.getName().endsWith("." + extension)) {
                System.out.println(archivo.getName());
            }
        }   
	}
	
	public static void listarDirectorio() {
		String directorioBase = "C:\\Users\\User\\Desktop\\FELIPE STUFF\\DAW\\Programación\\3º Trimestre\\pruebasFicheros";
		  File directorio = new File(directorioBase);

	        // Verificar si la ruta corresponde a un directorio
	        if (!directorio.isDirectory()) {
	            System.out.println("La ruta especificada no corresponde a un directorio.");
	            return;
	        }

	        // Obtener la lista de archivos y directorios en el directorio especificado
	        File[] archivos = directorio.listFiles();

	        // Imprimir el nombre de cada archivo o directorio
	        System.out.println("Contenido del directorio '" + directorioBase + "':");
	        System.out.println();
	        for (File archivo : archivos) {
	            System.out.println(archivo.getName());
	        }
	    }
	
	
	public static void lineasX() {
	String archivo = "C:\\Users\\User\\Desktop\\FELIPE STUFF\\DAW\\Programación\\3º Trimestre\\pruebasFicheros\\prueba.txt";
	 try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
         for (int i = 1; i <= 20; i++) {
             bw.write("Línea " + i);
             bw.newLine(); 
         }
         System.out.println("Se ha creado el archivo 'prueba.txt' y se ha escrito el contenido.");
     } catch (IOException e) {
         System.err.println("Error al escribir en el archivo: " + e.getMessage());
     }
	}
	
	public static void conversionMinusYMayus() {
		String rutaArchivoEntrada = "C:\\Users\\User\\Desktop\\FELIPE STUFF\\DAW\\Programación\\3º Trimestre\\pruebasFicheros\\conversion.txt";
        String rutaArchivoSalida = "C:\\Users\\User\\Desktop\\FELIPE STUFF\\DAW\\Programación\\3º Trimestre\\pruebasFicheros\\conversion_resultado.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivoSalida))) {

            int caracter;
            while ((caracter = br.read()) != -1) {
                char caracterActual = (char) caracter;

                // Convertir minúsculas a mayúsculas y viceversa
                if (Character.isLowerCase(caracterActual)) {
                    caracterActual = Character.toUpperCase(caracterActual);
                } else if (Character.isUpperCase(caracterActual)) {
                    caracterActual = Character.toLowerCase(caracterActual);
                }

                // Escribir el caracter modificado en el archivo de salida
                bw.write(caracterActual);
            }

            System.out.println("La conversión se ha realizado correctamente.");

        } catch (IOException e) {
            System.err.println("Error al realizar la conversión: " + e.getMessage());
        }
    }

	
	// Ejercicio 8 - Introduce nombre y mostrar contenido en pantalla
	
	public static void leeNombreYMuestra() {
		String rutaBase = "C:\\Users\\User\\Desktop\\FELIPE STUFF\\DAW\\Programación\\3º Trimestre\\pruebasFicheros\\";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Introduce el nombre del archivo:");
            String nombreArchivo = br.readLine();

            // Combinar la ruta base con el nombre del archivo
            String rutaCompleta = rutaBase + nombreArchivo;

            // Abrir el archivo
            File archivo = new File(rutaCompleta);
            if (!archivo.exists() || !archivo.isFile()) {
                System.err.println("El archivo no existe o no es válido.");
                return;
            }

            // Leer y mostrar el contenido del archivo
            try (BufferedReader archivoBR = new BufferedReader(new FileReader(archivo))) {
                String linea;
                System.out.println("\nContenido del archivo " + nombreArchivo + ":");
                while ((linea = archivoBR.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }

        } catch (IOException e) {
            System.err.println("Error al leer la entrada del usuario: " + e.getMessage());
        }
    }

	
	// Ejercicio 7 - Caracter - Leer archivo de texto y mostrar contenido en pantalla
	
	public static void leerCaracterACaracter(String[] args) {
	    if (args.length < 1) {
	        System.err.println("Debes proporcionar la ruta del archivo como argumento.");
	        return;
	    }

	    String archivo = args[0];

	    try (FileInputStream fis = new FileInputStream(archivo);
	         BufferedInputStream bis = new BufferedInputStream(fis);
	         InputStreamReader isr = new InputStreamReader(bis)) {

	        System.out.println("Leyendo el archivo carácter a carácter: " + archivo);
	        int caracter;
	        while ((caracter = isr.read()) != -1) {
	            System.out.print((char) caracter);
	        }
	        System.out.println("\nFin de la lectura del archivo carácter a carácter");

	    } catch (FileNotFoundException e) {
	        System.err.println("El archivo no existe en la ruta especificada: " + archivo);
	    } catch (IOException e) {
	        System.err.println("Error al leer el archivo: " + e.getMessage());
	    }
	}

	
	// Ejercicio 7 - Linea - Leer archivo de texto y mostrar contenido en pantalla

	public static void lecturaYMuestra() {
        String archivo = "C:\\Users\\User\\Desktop\\FELIPE STUFF\\DAW\\Programación\\3º Trimestre\\pruebasFicheros\\gatos.txt";

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo)));
            String linea;
            System.out.println("\nLeyendo el archivo línea a línea: " + archivo);
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
            System.out.println("Fin de la lectura del archivo línea a línea");
        } catch (FileNotFoundException e) {
            System.err.println("El archivo no existe en la ruta especificada: " + archivo);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
	}
	
	// Ejercicio 6 - Ocurrencias de una palabra

	public static void ocurrenciasPalabra() {
		String archivo = "C:\\Users\\User\\Desktop\\FELIPE STUFF\\DAW\\Programación\\3º Trimestre\\pruebasFicheros\\frases.txt";
		String palabraBuscar = "bocadillo";

		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea;
			int cont = 0;

			do {
				linea = br.readLine();

				if (linea != null) {
					String[] palabras = linea.split(" ");

					for (int i = 0; i < palabras.length; i++) {
						int pos = palabras[i].indexOf(palabraBuscar);

						if (palabras[i].equals(palabraBuscar)) {
							cont++;

						}
						// CADENA CON SIMBOLOS POR DETRAS Y POR DELANTE
						else if (pos > 0 && palabras[i].contains(palabraBuscar)
								&& !Character.isLetter(palabras[i].charAt(pos - 1))
								&& pos + palabras[i].length() <= palabras[i].length()
								&& !Character.isLetter(palabras[i].charAt(pos + palabraBuscar.length()))) {
							cont++;

						}
						// CADENA CON SIMBOLOS POR DETRAS
						else if (pos == 0 && palabras[i].contains(palabraBuscar)
								&& !Character.isLetter(palabras[i].charAt(palabraBuscar.length()))) {
							cont++;

						}
						// CADENA CON SIMBOLOS POR DELANTE
						else if (pos > 0 && palabras[i].contains(palabraBuscar)
								&& !Character.isLetter(palabras[i].charAt(pos - 1))) {
							cont++;

						}

					}
				}

			} while (linea != null);

			System.out.println("Se han encotrado " + cont + " concurrencias de la palabra " + palabraBuscar + ".");

		} catch (IOException e) {
			System.err.println("Error al leer el archivo: " + e.getMessage());
		}
	}

	// Ejercicio 4 - Ordenar palabras alfabéticamente

	public static void ordenaAlfabeticamente() {
		String fichero = "C:\\Users\\DAW MAÑANA\\Desktop\\FELIPE CHACÓN MONTERO\\Programación\\3º Trimestre\\palabrasOrdenadas.txt";
		String ficheroResultado = "C:\\Users\\DAW MAÑANA\\Desktop\\FELIPE CHACÓN MONTERO\\Programación\\3º Trimestre\\palabrasOrdenadas_sort.txt";

		try {
			BufferedReader bf = new BufferedReader(new FileReader(fichero));
			BufferedWriter bfSalida = new BufferedWriter(new FileWriter(ficheroResultado));

			ArrayList<String> palabras = new ArrayList<>();

			String palabra = bf.readLine();
			while (palabra != null) {
				palabras.add(palabra);
				palabra = bf.readLine();
			}

			Collections.sort(palabras);

			for (String p : palabras) {
				bfSalida.write(p);
				bfSalida.newLine();
			}

			System.out.println("\nContenido del fichero " + fichero + " leído y ordenado en " + ficheroResultado);
			bf.close();
			bfSalida.close();
		} catch (IOException e) {
			System.err.println("\nError al leer/escribir los archivos: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Ejercicio 3 - Guarda en un fichero el contenido de dos ficheros

	public static void dosFicheros() {
		// Se guardan las rutas de los ficheros
		String fichero1 = "C:\\Users\\DAW MAÑANA\\Desktop\\FELIPE CHACÓN MONTERO\\Programación\\3º Trimestre\\fichero1.txt";
		String fichero2 = "C:\\Users\\DAW MAÑANA\\Desktop\\FELIPE CHACÓN MONTERO\\Programación\\3º Trimestre\\fichero2.txt";
		String ficheroVacio = "C:\\Users\\DAW MAÑANA\\Desktop\\FELIPE CHACÓN MONTERO\\Programación\\3º Trimestre\\ficheroVacio.txt";

		// Tenemos dos BufferReader con FileReaders de lectura y un BufferWriter con un
		// FileWriter de escritura
		try (BufferedReader bf1 = new BufferedReader(new FileReader(fichero1));
				BufferedReader bf2 = new BufferedReader(new FileReader(fichero2));
				BufferedWriter bfSalida = new BufferedWriter(new FileWriter(ficheroVacio))) {

			// Estás son las líneas que se leen y posteriormente se intercalan
			String linea1 = bf1.readLine();
			String linea2 = bf2.readLine();

			/*
			 * El bucle while se ejecutará mientras la linea1 y linea2 NO sean null Si la
			 * linea1 no es null, el BufferWriter escribe la linea1, deja un espacio con
			 * newLine() y finalmente le da el valor leído por BufferReader(bf1)
			 */
			while (linea1 != null || linea2 != null) {
				if (linea1 != null) {
					bfSalida.write(linea1);
					bfSalida.newLine();
					linea1 = bf1.readLine();
				}
				/*
				 * Si la linea2 no es null, el BufferWriter escribe la linea2, deja un espacio
				 * con newLine() y finalmente le da el valor leído por BufferReader(bf2)
				 */
				if (linea2 != null) {
					bfSalida.write(linea2);
					bfSalida.newLine();
					linea2 = bf2.readLine();
				}
			}

			// Si se ha ejecutado correctamente las acciones requeridas se muestra el
			// siguiente mensaje
			System.out.println("\nContenido de los ficheros " + fichero1 + " y " + fichero2
					+ " intercalado correctamente en el fichero " + ficheroVacio);
			// Se atrapa la excepción y se muestra un mensaje de error en caso que sea
			// necesario
		} catch (IOException e) {
			System.err.println("\nError al leer/escribir los archivos: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Ejercicio 2 - Leer los números primos del fichero y mostrarlos por consola

	public static void lectura() {
		String nombreFichero = "C:\\Users\\DAW MAÑANA\\Desktop\\FELIPE CHACÓN MONTERO\\Programación\\3º Trimestre\\primos.dat";
		try {
			FileReader fr = new FileReader(nombreFichero);
			int character;
			while ((character = fr.read()) != -1) {
				System.out.print((char) character);
			}
			fr.close();
			System.out.println("Números primos del 1 al 500 leídos del archivo 'primos.dat'");
		} catch (IOException e) {
			System.err.println("Error al leer el archivo: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Ejercicio 1 - Guardar en un fichero números primos

	public static void numPrimos() {
		String nombreFichero = "C:\\Users\\DAW MAÑANA\\Desktop\\FELIPE CHACÓN MONTERO\\Programación\\3º Trimestre\\primos.dat";
		try {
			FileWriter fw = new FileWriter(nombreFichero);
			for (int i = 2; i <= 500; i++) {
				if (esPrimo(i)) {
					/*
					 * Esta es la forma correcta de hacerlo pasa el número a cadena de texto
					 */
					fw.write(Integer.toString(i) + "\n");
					// Imprime el valor numérico del carácter
//					fw.write(i);
//					fw.write("\n");
				}
			}
			fw.close();
			System.out.println("Números primos del 1 al 500 guardados en el archivo 'primos.dat'");
		} catch (IOException e) {
			System.err.println("Error al leer el archivo: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static boolean esPrimo(int num) {
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
