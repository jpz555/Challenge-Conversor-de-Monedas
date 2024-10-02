package com.Alurachallenges.conversordemonedas.comunicacion;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorArchivo{

    public void guardarArchivo(List<String> contenido) throws IOException {
        try {
            String nombreDelArchivo = "conversiones.txt";
            FileWriter escritura = new FileWriter(nombreDelArchivo);
            escritura.write(contenido.toString());
            escritura.close();

        } catch (IOException e) {
            throw new RuntimeException("Ocurrio un error, no se pudo guardar el archivo.");
        }
    }
}
