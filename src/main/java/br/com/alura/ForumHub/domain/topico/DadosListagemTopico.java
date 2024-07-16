package br.com.alura.ForumHub.domain.topico;

import br.com.alura.ForumHub.domain.curso.Curso;
import br.com.alura.ForumHub.domain.usuario.Usuario;

import java.time.LocalDateTime;


public record DadosListagemTopico(
          String titulo,
          String mensagem,
          LocalDateTime dataCriacao,
          boolean ativo,
          Curso curso,
          Usuario autor
) {
    public DadosListagemTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao()
                , topico.isAtivo(), topico.getCurso(), topico.getAutor());
    }
}


