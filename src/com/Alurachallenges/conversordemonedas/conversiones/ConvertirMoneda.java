package com.Alurachallenges.conversordemonedas.conversiones;

import com.Alurachallenges.conversordemonedas.clases.Moneda;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvertirMoneda {
    private String apiKey;
    private String monedaBase;
    private String monedaDestino;
    private double cantidad;

    public Moneda convertirMoneda(String monedaBase, String monedaDestino, double cantidad) {
        this.apiKey = "625f47a7dafbf9e4a8758741";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey
                + "/pair/" +monedaBase+ "/" + monedaDestino + "/" + cantidad);

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
            throw new RuntimeException("No se pudo calcular el valor de la moneda.");

        }

    }

}
