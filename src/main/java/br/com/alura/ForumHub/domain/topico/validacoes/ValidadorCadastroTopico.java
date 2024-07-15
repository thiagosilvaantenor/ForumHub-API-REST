package br.com.alura.ForumHub.domain.topico.validacoes;

import br.com.alura.ForumHub.domain.topico.DadosCadastroTopico;

public interface ValidadorCadastroTopico {

    void validar(DadosCadastroTopico dados);
}
