package com.Alurachallenges.conversordemonedas.conversiones;

import com.Alurachallenges.conversordemonedas.clases.Moneda;
import com.google.gson.Gson;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;

public class ConvertirMoneda {
    private String apiKey;

    public Moneda convertirMoneda(String monedaBase, String monedaDestino, Double cantidad) throws InterruptedException {
        this.apiKey = "625f47a7dafbf9e4a8758741";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey
                + "/pair/" +monedaBase+ "/" + monedaDestino + "/" + BigDecimal.valueOf(cantidad).setScale(2, RoundingMode.HALF_UP));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse <String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return (new Gson().fromJson(response.body(), Moneda.class));

        } catch (NumberFormatException e){
            throw new NumberFormatException("Error en el numero del formato.");
        }
        catch (Exception e) {
            throw new RuntimeException("No se pudo calcular el valor de la moneda que ingreso.");

        }

    }
//    public static void main(String[] args) throws IOException, InterruptedException {
//        ConvertirMoneda moneda = new ConvertirMoneda();
//        System.out.println(moneda.convertirMoneda("USD","COP", "5000000000.00"));
//
//    }

}
