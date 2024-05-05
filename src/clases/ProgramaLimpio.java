package clases;
import java.io.*;

public class ProgramaLimpio {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: java ProgramaLimpio PROGRAMA_ORIGINAL PROGRAMA_LIMPIO");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            boolean inBlockComment = false;

            while ((line = br.readLine()) != null) {
                StringBuilder cleanLine = new StringBuilder();
                int length = line.length();
                for (int i = 0; i < length; i++) {
                    char currentChar = line.charAt(i);

                    if (!inBlockComment) {
                        if (currentChar == '/') {
                            if (i + 1 < length && line.charAt(i + 1) == '/') {
                                break; // Ignorar el resto de la línea si es un comentario de una línea
                            } else if (i + 1 < length && line.charAt(i + 1) == '*') {
                                inBlockComment = true;
                                i++; // Avanzar para omitir el próximo carácter (el '*' que inicia el comentario de bloque)
                            } else {
                                cleanLine.append(currentChar);
                            }
                        } else {
                            cleanLine.append(currentChar);
                        }
                    } else {
                        if (currentChar == '*' && i + 1 < length && line.charAt(i + 1) == '/') {
                            inBlockComment = false;
                            i++; // Avanzar para omitir el próximo carácter (el '/' que cierra el comentario de bloque)
                        }
                    }
                }

                // Escribir la línea limpia en el archivo de salida
                bw.write(cleanLine.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Comentarios eliminados correctamente.");
    }
}
