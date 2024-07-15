package br.com.alura.ForumHub.domain.topico.validacoes.detalhamento;

import br.com.alura.ForumHub.domain.ValidacaoException;
import br.com.alura.ForumHub.domain.topico.TopicoRepository;

public class ValidadorIdExistente implements ValidadorDetalhamentoTopico{

    private TopicoRepository repository;

    @Override
    public void validar(Long id) {
        if(!repository.existsById(id)){
            throw new ValidacaoException("Id de topico informado não existe");
        }
    }
}
