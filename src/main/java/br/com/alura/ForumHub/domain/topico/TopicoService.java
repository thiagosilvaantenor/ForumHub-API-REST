package br.com.alura.ForumHub.domain.topico;

import br.com.alura.ForumHub.domain.ValidacaoException;
import br.com.alura.ForumHub.domain.curso.CursoRepository;
import br.com.alura.ForumHub.domain.topico.validacoes.ValidadorCadastroTopico;
import br.com.alura.ForumHub.domain.topico.validacoes.detalhamento.ValidadorDetalhamentoTopico;
import br.com.alura.ForumHub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private List<ValidadorCadastroTopico> validadoresCadastro;
    @Autowired
    private List<ValidadorDetalhamentoTopico> validadorDetalhamentoTopicos;

    public Topico cadastrar(DadosCadastroTopico dados) {
        var idAutor = dados.idAutor();
        var idCurso = dados.idCurso();

        if(!usuarioRepository.existsById(idAutor)){
            throw new ValidacaoException("Autor não cadastrado!");
        }
        if (!cursoRepository.existsById(idCurso)){
            throw new ValidacaoException("Curso inexistente!");
        }

        validadoresCadastro.forEach( v-> v.validar(dados));

        var topico = new Topico(dados, cursoRepository.getReferenceById(idCurso), usuarioRepository.getReferenceById(idAutor));
        topicoRepository.save(topico);
        return topico;
    }

    public DadosDetalhamentoTopico detalhar(Long id) {
        validadorDetalhamentoTopicos.forEach( v-> v.validar(id));
        Topico topico = topicoRepository.getReferenceById(id);
        return new DadosDetalhamentoTopico(topico);
    }

    public DadosAtualizacaoTopico atualizar(DadosAtualizacaoTopico dadosAtualizacao) {
        validadorDetalhamentoTopicos.forEach( v-> v.validar(dadosAtualizacao.id()));
        var topico = topicoRepository.findById(dadosAtualizacao.id());
        if(!topico.isPresent()) {
            throw new ValidacaoException("Topico não existe!");
        }
        var dadosASeremValidados = new DadosCadastroTopico(dadosAtualizacao.titulo(),dadosAtualizacao.mensagem(),dadosAtualizacao.curso().getId(),dadosAtualizacao.autor().getId());
        validadoresCadastro.forEach(v -> v.validar(dadosASeremValidados));
        topico.get().atualizarInformacoes(dadosAtualizacao);

        return new DadosAtualizacaoTopico(topico.get());
    }

    public void deletar(Long id) {
        var topicoEncontrado = topicoRepository.findById(id);
        if(!topicoEncontrado.isPresent()){
            throw new ValidacaoException("Topico não existe!");
        }
        topicoEncontrado.get().excluir();
    }
}
