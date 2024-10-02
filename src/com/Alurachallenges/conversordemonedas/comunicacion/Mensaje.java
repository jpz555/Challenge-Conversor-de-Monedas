package com.Alurachallenges.conversordemonedas.comunicacion;

import com.Alurachallenges.conversordemonedas.clases.Moneda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensaje {
        private String tipoMonedaBase;
        private String tipoMonedaDestino;
        private double valorConvertido;
        private double valorIngresado;
        private String fechaDeRegistro;
        private Moneda moneda;

    public Mensaje(double valorIngresado, Moneda moneda) {
        this.valorIngresado = valorIngresado;
        this.valorIngresado = valorIngresado;
        this.tipoMonedaBase = moneda.base_code();
        this.tipoMonedaDestino = moneda.target_code();
        this.valorConvertido = moneda.conversion_result();
        this.fechaDeRegistro = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    @Override
    public String toString() {
        return String.format("\n(%s -- El valor %.2f [%s], corresponde al valor final de =>>> %.2f [%s])", fechaDeRegistro, valorIngresado, tipoMonedaBase, valorConvertido, tipoMonedaDestino);
    }

}
