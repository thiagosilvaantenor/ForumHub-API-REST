package br.com.alura.ForumHub.domain.usuario;

public record DadosDetalhamentoUsuario(
        Long id,
        String nome,
        String email,
        String senha
) {
    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.nome, usuario.email, usuario.senha);
    }
}
