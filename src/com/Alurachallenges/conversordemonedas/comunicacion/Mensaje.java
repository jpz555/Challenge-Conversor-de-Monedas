package com.Alurachallenges.conversordemonedas.comunicacion;

import com.Alurachallenges.conversordemonedas.clases.Moneda;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensaje {
        private String tipoMonedaBase;
        private String tipoMonedaDestino;
        private Double valorIngresado;
        private String valorConvertidoFormateado;
        private String fechaDeRegistro;
        private Moneda moneda;

    public Mensaje(Double valorIngresado, Moneda moneda) {
        this.valorIngresado = valorIngresado;
        this.tipoMonedaBase = moneda.base_code();
        this.tipoMonedaDestino = moneda.target_code();

        if (moneda.conversion_result().compareTo(BigDecimal.ONE) > 0) {
            this.valorConvertidoFormateado = new DecimalFormat("#,###.00").format(moneda.conversion_result());
        } else
            this.valorConvertidoFormateado = new DecimalFormat("0.0000").format(moneda.conversion_result());

        this.fechaDeRegistro = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    @Override
    public String toString() {
        return String.format("\n(%s -- El valor %.2f [%s], corresponde al valor final de =>>> %s [%s])", fechaDeRegistro, valorIngresado, tipoMonedaBase, valorConvertidoFormateado, tipoMonedaDestino);
//        return String.format("\n(%s -- El valor %.2f [%s], corresponde al valor final de =>>> %s [%s])", fechaDeRegistro, valorIngresado, tipoMonedaBase, new DecimalFormat("0.00000").format(valorConvertido), tipoMonedaDestino);
    }

}
