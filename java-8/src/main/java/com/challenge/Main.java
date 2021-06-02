package com.challenge;

import com.challenge.desafio.CalculadorDeClasses;
import com.challenge.interfaces.Calculavel;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Teste teste = new Teste(new BigDecimal(7), new BigDecimal(3));
        CalculadorDeClasses c = new CalculadorDeClasses();
        System.out.println(c.totalizar(teste));
    }
}
