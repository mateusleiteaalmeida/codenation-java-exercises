package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object objeto) {
        BigDecimal totalSoma = new BigDecimal(0);
        Field[] listaDeAtributos = objeto.getClass().getDeclaredFields();
        for (Field atributo : listaDeAtributos) {
            atributo.setAccessible(true);
            if (atributo.getAnnotation(Somar.class) != null && atributo.getType() == BigDecimal.class) {
                try {
                    totalSoma = totalSoma.add((BigDecimal) atributo.get(objeto));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            };
        }
        return totalSoma;
    }


    @Override
    public BigDecimal subtrair(Object objeto) {
        BigDecimal totalSubtracao = new BigDecimal(0);
        Field[] listaDeAtributos = objeto.getClass().getDeclaredFields();
        for (Field atributo : listaDeAtributos) {
            atributo.setAccessible(true);
            if (atributo.getAnnotation(Subtrair.class) != null && atributo.getType() == BigDecimal.class) {
                try {
                    totalSubtracao = totalSubtracao.add((BigDecimal) atributo.get(objeto));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            };
        }
        return totalSubtracao;
    }

    @Override
    public BigDecimal totalizar(Object objeto) {
        return somar(objeto).subtract(subtrair(objeto));
    }
}
