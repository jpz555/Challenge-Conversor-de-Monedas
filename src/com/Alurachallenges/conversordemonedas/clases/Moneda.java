package com.Alurachallenges.conversordemonedas.clases;

import java.math.BigDecimal;

public record Moneda(String base_code,
                     String target_code,
                     Double conversion_rate,
                     BigDecimal conversion_result) {

}
