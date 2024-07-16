package br.com.alura.ForumHub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(
       @NotBlank
       String titulo,
       @NotBlank
       String mensagem,
       @NotNull
       Long idCurso,
       @NotNull
       Long idAutor
) {

       public DadosCadastroTopico(Topico topico) {
              this(topico.getTitulo(),topico.getMensagem(),topico.getCurso().getId(),topico.getAutor().getId());
       }

}
