package com.Alurachallenges.conversordemonedas.conversiones;

import java.util.List;
import java.util.Map;

public class DatosFormatosMonedas {
    private int clave;
    private Map<Integer, List<String>> valoresPaisesDisponibles = Map.of(
            1, List.of("USD", "COP"),
            2, List.of("COP", "USD"),
            3, List.of("ARS", "COP"),
            4, List.of("COP", "ARS"),
            5, List.of("cop", "eur"),
            6, List.of("eur", "cop"),
            7, List.of("cop", "brl"),
            8, List.of("brl", "cop"),
            9, List.of("cop", "mxn"),
            10, List.of("mxn", "cop")
    );

    public String obtenerFormatos(int clave, int posicion) {
        this.clave = clave;
        return valoresPaisesDisponibles.get(clave).get(posicion).toUpperCase();
    }

    public Map<Integer, List<String>> getValoresPaisesDisponibles() {
        return valoresPaisesDisponibles;
    }

}

