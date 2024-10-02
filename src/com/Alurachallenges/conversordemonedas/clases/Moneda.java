package com.Alurachallenges.conversordemonedas.clases;

public record Moneda(String base_code,
                     String target_code,
                     String conversion_rate,
                     double conversion_result) {

}
