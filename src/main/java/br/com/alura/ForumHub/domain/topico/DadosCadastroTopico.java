package br.com.alura.ForumHub.domain.topico;

import br.com.alura.ForumHub.domain.curso.Curso;
import br.com.alura.ForumHub.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(
       @NotBlank
       String titulo,
       @NotBlank
       String mensagem,
       @NotNull
       Curso curso,
       @NotNull
       Usuario autor
) {

       public DadosCadastroTopico(Topico topico) {
              this(topico.getTitulo(),topico.getMensagem(),topico.getCurso(),topico.getAutor());
       }
}
