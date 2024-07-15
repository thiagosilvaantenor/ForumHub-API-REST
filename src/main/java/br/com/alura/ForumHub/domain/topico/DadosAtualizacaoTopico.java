package br.com.alura.ForumHub.domain.topico;

import br.com.alura.ForumHub.domain.curso.Curso;
import br.com.alura.ForumHub.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
        @NotNull
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull
        Curso curso,
        @NotNull
        Usuario autor
) {
    public DadosAtualizacaoTopico(Topico topico) {
        this(topico.getId(),topico.getTitulo(),topico.getMensagem(),topico.getCurso(),topico.getAutor());
    }
}
