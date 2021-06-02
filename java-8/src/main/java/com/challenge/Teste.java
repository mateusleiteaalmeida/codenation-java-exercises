package com.challenge;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;

public class Teste {
    @Somar
    public BigDecimal numero;

    @Subtrair
    public BigDecimal numero2;

    public Teste(BigDecimal numero, BigDecimal numero2) {
        this.numero = numero;
        this.numero2 = numero2;
    }
}
