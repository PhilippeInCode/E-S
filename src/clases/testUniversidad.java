package clases;
public class testUniversidad {

    public static void main(String[] args) {
        Universidad asignatura1 = new Universidad(102030, "Programacion", 500);

        // Escribir los datos de la asignatura en un archivo
        asignatura1.escribirAsignatura();

        // Leer y mostrar los datos del archivo
        asignatura1.leerAsignatura();
    }
}