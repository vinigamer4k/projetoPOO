package modelo;


public class Jogador extends Usuario {
    private int pontuacaoSolo; 
    private int pontuacaoCompetitiva; 

    public Jogador(String login, String email, String senha) {
        super(login, email, senha); 
        this.pontuacaoSolo = 0;
        this.pontuacaoCompetitiva = 0;
    }

    public void adicionarPontosSolo(int pontos) {
        this.pontuacaoSolo += pontos;
    }

    public void adicionarPontosCompetitivo(int pontos) {
        this.pontuacaoCompetitiva += pontos; 
    }
    
    public int getPontuacaoSolo() { return pontuacaoSolo; }
    public int getPontuacaoCompetitiva() { return pontuacaoCompetitiva; }
}