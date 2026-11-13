package controle;

import java.util.ArrayList;
import java.util.List;
import modelo.*; // Importa todas as classes do pacote modelo

public class CentralDeInformacoes {
    private List<Usuario> usuarios;
    private List<Palavra> bancoDePalavras;
    private List<Partida> historicoPartidas;
    
    public CentralDeInformacoes() {
        this.usuarios = new ArrayList<>();
        this.bancoDePalavras = new ArrayList<>();
        this.historicoPartidas = new ArrayList<>();
    }
    
    
    public void cadastrarJogador(String login, String email, String senha) throws Exception {
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login) || u.getEmail().equals(email)) {
                throw new Exception("Login ou E-mail já cadastrado!"); // impede dois
            }
        }
        usuarios.add(new Jogador(login, email, senha));
    }
    
    public void cadastrarAdministrador(String login, String email, String senha) throws Exception {
        usuarios.add(new Administrador(login, email, senha));
    }
    
    public Usuario realizarLogin(String email, String senha) throws Exception {
        for (Usuario u : usuarios) {
            if (u.autenticar(email, senha)) {
                if (u.getStatus() == StatusConta.INATIVA) {
                    throw new Exception("Conta inativada. Não é possível fazer login."); 
                }
                return u;
            }
        }
        throw new Exception("Credenciais inválidas.");
    }
    
    public boolean isPrimeiraExecucao() {
        return usuarios.isEmpty(); //  manda para cadastro de admin se tiver vazio
    }
    

    public List<Usuario> getUsuarios() { return usuarios; }
    public List<Palavra> getBancoDePalavras() { return bancoDePalavras; }
    public List<Partida> getHistoricoPartidas() { return historicoPartidas; }
}