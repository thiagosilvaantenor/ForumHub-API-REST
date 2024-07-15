package br.com.alura.ForumHub.domain.topico;

import br.com.alura.ForumHub.domain.ValidacaoException;
import br.com.alura.ForumHub.domain.topico.validacoes.ValidadorCadastroTopico;
import br.com.alura.ForumHub.domain.topico.validacoes.detalhamento.ValidadorDetalhamentoTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    private List<ValidadorCadastroTopico> validadoresCadastro;
    private List<ValidadorDetalhamentoTopico> validadorDetalhamentoTopicos;

    public Topico cadastrar(DadosCadastroTopico dados) {
        var autor = dados.autor();
        var curso = dados.curso();

        if(!topicoRepository.existsById(autor.getId())){
            throw new ValidacaoException("Autor não cadastrado!");
        }
        if (!topicoRepository.existsById(curso.getId())){
            throw new ValidacaoException("Curso inexistente!");
        }

        validadoresCadastro.forEach(v-> v.validar(dados));

        var topico = new Topico(dados);
        topicoRepository.save(topico);
        return topico;
    }

    public DadosDetalhamentoTopico detalhar(Long id) {
        validadorDetalhamentoTopicos.forEach( v-> v.validar(id));
        Topico topico = topicoRepository.getReferenceById(id);
        return new DadosDetalhamentoTopico(topico);
    }

    public DadosAtualizacaoTopico atualizar(Long id) {
        validadorDetalhamentoTopicos.forEach(v -> v.validar(id));
        var dados = topicoRepository.findById(id);
        if(!dados.isPresent()) {
            throw new ValidacaoException("Topico não existe!");
        }
        validadoresCadastro.forEach(v -> v.validar(new DadosCadastroTopico(dados.get())));
        return new DadosAtualizacaoTopico(dados.get());
    }

    public void deletar(Long id) {
        var topicoEncontrado = topicoRepository.findById(id);
        if(!topicoEncontrado.isPresent()){
            throw new ValidacaoException("Topico não existe!");
        }
        topicoEncontrado.get().excluir();
    }
}
