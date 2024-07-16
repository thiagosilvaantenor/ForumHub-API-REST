package br.com.alura.ForumHub.controller;

import br.com.alura.ForumHub.domain.ValidacaoException;
import br.com.alura.ForumHub.domain.usuario.DadosCadastroUsuario;
import br.com.alura.ForumHub.domain.usuario.Usuario;
import br.com.alura.ForumHub.domain.usuario.UsuarioRepository;
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
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder){

        if(repository.existsByEmail(dados.email())){
            throw new ValidacaoException("Já existe um usuário com esse email");
        }
        if(repository.existsByNome(dados.nome())) {
            throw new ValidacaoException("Já existe um usuário com esse nome");
        }
        Usuario usuarioCriado = new Usuario(dados);
        repository.save(usuarioCriado);
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuarioCriado.getId()).toUri();

        return ResponseEntity.created(uri).body(usuarioCriado);
    }
}
