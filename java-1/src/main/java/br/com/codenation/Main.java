package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DesafioMeuTimeApplication d = new DesafioMeuTimeApplication();
        List<Long> jogadores = d.buscarTopJogadores(2);
        System.out.println(jogadores);
    }
}
