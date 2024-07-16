package br.com.alura.ForumHub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Page<Topico> findAllByAtivoTrue(Pageable paginacao);
    //Optional<Topico> findByTituloAndMensagem(String titulo, String mensagem);

    @Query("SELECT t FROM Topico t WHERE t.titulo = :titulo AND t.mensagem = :mensagem")
    Optional<Topico> findByTituloAndMensagem(String titulo, String mensagem);

}

