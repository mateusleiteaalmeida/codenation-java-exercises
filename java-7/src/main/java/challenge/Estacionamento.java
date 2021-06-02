package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    List<Carro> listaDeCarros = new ArrayList<>();

    private final int LIMITE_VAGAS = 10;
    private final int LIMITE_IDADE = 55;

    public void estacionar(Carro carro) {
        if (carrosEstacionados() == LIMITE_VAGAS) {
            if (carrosEstacionados() == verificaMotoristasComIdadeAvancada()) {
                throw new EstacionamentoException("O estacionamento está lotado.");
            } else {
                for (Carro carAtual : listaDeCarros) {
                    if (carroEstacionado(carro)) {
                        listaDeCarros.remove(carAtual);
                        listaDeCarros.add(carro);
                        break;
                    }
                }
            }
        } else {
            listaDeCarros.add(carro);
        }
    }

    public int carrosEstacionados() {
        return listaDeCarros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carro.getMotorista().getIdade() > LIMITE_IDADE;
    }

    public int verificaMotoristasComIdadeAvancada() {
        List<Carro> listaDeMotoristas = new ArrayList<>();
        for (Carro carro : listaDeCarros) {
            if (carroEstacionado(carro)) {
                listaDeMotoristas.add(carro);
            }
        }
        return listaDeMotoristas.size();
    }
}
