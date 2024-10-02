package com.Alurachallenges.conversordemonedas.comunicacion;

public class MostrarMenus {

    public void mostrarMenuDeOpcionesDeConversion(){
        String menuOpciones = """
                ************************************************************
                                      Menu de Inicio.
                Nota: Ingrese el número que se encuentra al lado de la
                opción, para seleccionarla.
                
                -------------------Menu de Conversiones.--------------------
                _________________Ingrese una opción valida._________________
                1). Dólar [USD] =>> Peso Colombiano [COP].
                2). Peso Colombiano [COP] =>> Dólar [USD].
                3). Peso Argentino [ARS] =>> Peso Colombiano[COP].
                4). Peso Colombiano[COP] =>>  Peso Argentino [ARS].
                5). Peso Colombiano[COP] =>> Euro[EUR].
                6). Euro[EUR] =>> Peso Colombiano[COP].
                7). Peso Colombiano[COP] =>> Peso Brasileño[BRL].
                8). Peso Brasileño[BRL] =>> Peso Colombiano[COP].
                9). Peso Colombiano[COP] =>> Peso Mexicano[MXN].
                10).Peso Mexicano[MXN] =>> Peso Colombiano[COP].
                
                -------------------- Menu de Usuario. ---------------------
                11).Salir de la aplicación.
                12) Mostrar historial de conversiones.
                ************************************************************
                """;
        System.out.println(menuOpciones);
    }

}
