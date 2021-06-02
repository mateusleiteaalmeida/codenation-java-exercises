package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private ArrayList<Time> listaDeTimes = new ArrayList<>();
	private ArrayList<Jogador> listaDeJogadores = new ArrayList<>();

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if (buscarTimes().contains(id)) throw new IdentificadorUtilizadoException("Este identificador já existe.");
		listaDeTimes.add(new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if (!buscarTimes().contains(idTime)) throw new TimeNaoEncontradoException("Time não encontrado.");
		if (buscarJogadoresDoTime(idTime).contains(id)) throw new IdentificadorUtilizadoException("Este identificador já existe.");
		listaDeJogadores.add(new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));
	}

	public void definirCapitao(Long idJogador) {
		if (listaDeJogadores.stream().anyMatch(jogador -> jogador.getId().equals(idJogador))) {
			for (Jogador jogador : listaDeJogadores) {
				if (jogador.getId() == idJogador) jogador.setCapitao(true);
				else jogador.setCapitao(false);
			}
		} else {
			throw new JogadorNaoEncontradoException("Jogador não encontrado.");
		}
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		if (!buscarTimes().contains(idTime)) throw new TimeNaoEncontradoException("Time não encontrado.");
		for (Jogador jogador : listaDeJogadores) {
			if (jogador.isCapitao()) return jogador.getId();
		}
		throw new CapitaoNaoInformadoException("Capitão não informado.");
	}

	public String buscarNomeJogador(Long idJogador) {
		for (Jogador jogador : listaDeJogadores) {
			if (jogador.getId() == idJogador) return jogador.getNome();
		}
		throw new JogadorNaoEncontradoException("Jogador não encontrado.");
	}

	public String buscarNomeTime(Long idTime) {
		for (Time time : listaDeTimes) {
			if (time.getId() == idTime) return time.getNome();
		}
		throw new TimeNaoEncontradoException("Time não encontrado.");
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		List<Long> listaDeJogadoresdoTimeBuscado = new ArrayList<>();
		if (!buscarTimes().contains(idTime)) throw new TimeNaoEncontradoException("Time não encontrado.");
		for (Jogador jogador : listaDeJogadores) {
			if (jogador.getIdTime() == idTime) listaDeJogadoresdoTimeBuscado.add(jogador.getId());
		}
		return listaDeJogadoresdoTimeBuscado;
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if (!buscarTimes().contains(idTime)) throw new TimeNaoEncontradoException("Time não encontrado.");
		listaDeJogadores.sort(Comparator.comparing(Jogador::getNivelHabilidade));
		return listaDeJogadores.get(listaDeJogadores.size() - 1).getId();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		if (!buscarTimes().contains(idTime)) throw new TimeNaoEncontradoException("Time não encontrado.");
		listaDeJogadores.sort(Comparator.comparing(Jogador::getDataNascimento).thenComparing(Jogador::getId));
		return listaDeJogadores.get(0).getId();
	}

	public List<Long> buscarTimes() {
		List<Long> listaDeTimesIds = new ArrayList<>();
		for (Time time : listaDeTimes) {
			listaDeTimesIds.add(time.getId());
		}
		return listaDeTimesIds;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		if (!buscarTimes().contains(idTime)) throw new TimeNaoEncontradoException("Time não encontrado.");
		listaDeJogadores.sort(Comparator.comparing(Jogador::getSalario).reversed().thenComparing(Jogador::getId));
		return listaDeJogadores.get(0).getId();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		for (Jogador jogador : listaDeJogadores) {
			if (jogador.getId() == idJogador) return jogador.getSalario();
		};
		throw new JogadorNaoEncontradoException("Jogador não encontrado.");
	}

	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> topJogadores = new ArrayList<>();
		if (listaDeJogadores.isEmpty()) return topJogadores;
		listaDeJogadores.sort(Comparator.comparing(Jogador::getNivelHabilidade).thenComparing(Jogador::getId).reversed());
		topJogadores = listaDeJogadores.stream().map(Jogador::getId).collect(Collectors.toList()).subList(0, top);
		return topJogadores;
	}

}

