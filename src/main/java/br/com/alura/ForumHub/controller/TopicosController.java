package br.com.alura.ForumHub.controller;

import br.com.alura.ForumHub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private TopicoRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopico(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder){
       var topico = topicoService.cadastrar(dados);

       var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

       return ResponseEntity.created(uri).body(new DadosListagemTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listarTopicos(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemTopico::new);
        return ResponseEntity.ok(page);

    }

    @GetMapping("/{id}")
    public ResponseEntity detalharTopico(@PathVariable @Valid Long id){
        DadosDetalhamentoTopico topico = topicoService.detalhar(id);
        return ResponseEntity.ok(topico);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarTopico(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados){
        DadosAtualizacaoTopico topico = topicoService.atualizar(dados);
        return ResponseEntity.ok(topico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarTopico(@PathVariable @Valid Long id) {
        topicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
