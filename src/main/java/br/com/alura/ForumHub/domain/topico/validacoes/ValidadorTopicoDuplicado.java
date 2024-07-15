package br.com.alura.ForumHub.domain.topico.validacoes;

import br.com.alura.ForumHub.domain.ValidacaoException;
import br.com.alura.ForumHub.domain.topico.DadosCadastroTopico;
import br.com.alura.ForumHub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTopicoDuplicado implements ValidadorCadastroTopico {
    @Autowired
    private TopicoRepository repository;

    public void validar(DadosCadastroTopico dados){
        if(repository.findByTituloAndMensagem(dados.titulo(), dados.mensagem())){
            throw new ValidacaoException("Topico com o mesmo titulo e mensagem");
        };
    }
}
