package br.com.alura.ForumHub.controller;

import br.com.alura.ForumHub.domain.ValidacaoException;
import br.com.alura.ForumHub.domain.curso.Curso;
import br.com.alura.ForumHub.domain.curso.CursoRepository;
import br.com.alura.ForumHub.domain.curso.DadosCadastroCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarCurso(@RequestBody @Valid DadosCadastroCurso dados, UriComponentsBuilder uriBuilder){

        if(repository.existsByNome(dados.nome())){
            throw new ValidacaoException("Já existe um curso com esse nome");
        }

        Curso cursoCriado = new Curso(dados);
        repository.save(cursoCriado);

        var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(cursoCriado.getId()).toUri();

        return ResponseEntity.created(uri).body(cursoCriado);
    }
}
