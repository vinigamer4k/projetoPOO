package modelo;


public abstract class Usuario implements Autenticavel {
    private String login; 
    private String email; 
    private String senha; 
    private StatusConta status;

    public Usuario(String login, String email, String senha) {
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.status = StatusConta.ATIVA;
    }

    @Override
    public boolean autenticar(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }
    
  
    public String getLogin() { return login; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public StatusConta getStatus() { return status; }
    public void setStatus(StatusConta status) { this.status = status; }
}