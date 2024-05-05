package clases;
import java.io.*;

public class Universidad {
    private int codAsig;
    private String nomAsig;
    private int cantCreditoAsig;

    public Universidad(int codAsig, String nomAsig, int cantCreditoAsig) {
        this.codAsig = codAsig;
        this.nomAsig = nomAsig;
        this.cantCreditoAsig = cantCreditoAsig;
    }

    public void imprimir() {
        System.out.println("Código de asignatura: " + codAsig);
        System.out.println("Nombre de asignatura: " + nomAsig);
        System.out.println("Cantidad de créditos: " + cantCreditoAsig);
    }

 // Función para leer los contenidos de un archivo de asignatura y mostrarlos en pantalla
    public void leerAsignatura() {
        // Definir la ruta del archivo dentro del método
        String rutaArchivo = "C:\\Users\\User\\Desktop\\FELIPE STUFF\\DAW\\Programación\\3º Trimestre\\pruebasFicheros\\lecturaAsignatura.txt";

        try {
            File archivo = new File(rutaArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            br.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Función para escribir los contenidos de un objeto asignatura en un archivo
    public void escribirAsignatura() {
        // Definir la ruta del archivo dentro del método
        String rutaArchivo = "C:\\Users\\User\\Desktop\\FELIPE STUFF\\DAW\\Programación\\3º Trimestre\\pruebasFicheros\\escrituraAsignatura.txt";

        try {
            File archivo = new File(rutaArchivo);
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Código asignatura: " + getCodAsig());
            bw.newLine();
            bw.write("Nombre asignatura: " + getNomAsig());
            bw.newLine();
            bw.write("Cantidad crédito asignatura: " + getCantCreditoAsig());

            bw.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

	private int getCantCreditoAsig() {
		// TODO Auto-generated method stub
		return cantCreditoAsig;
	}

	private String getNomAsig() {
		// TODO Auto-generated method stub
		return nomAsig;
	}

	private int getCodAsig() {
		// TODO Auto-generated method stub
		return codAsig;
	}
}
