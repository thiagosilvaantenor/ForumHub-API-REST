package br.com.alura.ForumHub.domain.topico.validacoes.detalhamento;

import br.com.alura.ForumHub.domain.ValidacaoException;
import br.com.alura.ForumHub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorIdExistente implements ValidadorDetalhamentoTopico{

    @Autowired
    private TopicoRepository repository;


    @Override
    public void validar(Long id) {
        if(repository.findAll().isEmpty()){
            return;
        }
        if(!repository.existsById(id)){
            throw new ValidacaoException("Id de topico informado não existe");
        }
    }
}
