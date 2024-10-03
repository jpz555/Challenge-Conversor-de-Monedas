package com.Alurachallenges.conversordemonedas.principal;

import com.Alurachallenges.conversordemonedas.clases.Moneda;
import com.Alurachallenges.conversordemonedas.comunicacion.MostrarMenus;
import com.Alurachallenges.conversordemonedas.comunicacion.GeneradorArchivo;
import com.Alurachallenges.conversordemonedas.comunicacion.Mensaje;
import com.Alurachallenges.conversordemonedas.conversiones.ConvertirMoneda;
import com.Alurachallenges.conversordemonedas.conversiones.DatosFormatosMonedas;

import java.io.IOException;
import java.util.*;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("*******    Bienvenido/a al Conversor de monedas.  **********");
        Scanner entradaUsuario = new Scanner(System.in);
        ConvertirMoneda conversor = new ConvertirMoneda();
        MostrarMenus menuOpciones = new MostrarMenus();
        DatosFormatosMonedas datoMoneda = new DatosFormatosMonedas();
        List<String> conversiones = new ArrayList<>();
        conversiones.add("Fecha -----------------Conversión\n");

        while (true) {
            try {
                menuOpciones.mostrarMenuDeOpcionesDeConversion();
                int opcion = entradaUsuario.nextInt();

                if (opcion == 11) {
                    System.out.println("¡Salida Exitosa!");
                    break;

                } else if (opcion == 12) {
                    if (conversiones.size() > 1) {
//                      Collections.sort(conversiones, Collections.reverseOrder());
                        conversiones.sort(Collections.reverseOrder());
                        System.out.println(conversiones);
                        System.out.println("Desea guardar el archivo. Ingrese 'Si' o 'No'");
                        String guardar = entradaUsuario.next();
                        if (guardar.equalsIgnoreCase("si")) {
                            new GeneradorArchivo().guardarArchivo(conversiones);
                            System.out.println("¡Archivo guardado con exito!\n");
                        }
                    } else {
                        System.out.println("*** No hay historial de conversiones, para consultar. ***\n");
                    }

                } else if (datoMoneda.getValoresPaisesDisponibles().containsKey(opcion)) {
                    System.out.println("***Ingresa la cantidad que desea convertir.***");
                    double cantidad = entradaUsuario.nextDouble();
                    String monedaBase = datoMoneda.obtenerFormatos(opcion, 0);
                    String monedaDestino = datoMoneda.obtenerFormatos(opcion, 1);
                    Moneda moneda = conversor.convertirMoneda(monedaBase, monedaDestino,cantidad);
                    String conversion = new Mensaje(cantidad, moneda).toString();
//                   String conversion = new Mensaje(cantidad).mostrarMensajeConversion(cantidad, moneda);
                    System.out.println(conversion);
                    conversiones.add(conversion);

                } else {
                    System.out.println("Opción ingresada no valida, vuelva a intentar.");
                }
            } catch (InputMismatchException e) {
                System.out.println("""
                                Advertencia:
                                1. Solo se pueden ingresar números enteros para escoger
                                la opcion inicial.
                                2. a la hora de ingresar el valor  a convertir, puede
                                ingresar numeros con comas como por ejemplo: 5,98, 4980,00.
                                3.Tampoco puede ingreser cadenas de caracteres como: 'salir'""");
                entradaUsuario.nextLine();
            }
        }
        entradaUsuario.close();
    }
}
