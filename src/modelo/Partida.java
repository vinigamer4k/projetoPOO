package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public abstract class Partida {
    private LocalDateTime dataHora; 
    private List<String> logsDeOperacoes; 
    
    public Partida() {
        this.dataHora = LocalDateTime.now();
        this.logsDeOperacoes = new ArrayList<>();
    }
    
    public void registrarLog(String acao) {
        logsDeOperacoes.add(acao);
    }
    
    public LocalDateTime getDataHora() { return dataHora; }
    public List<String> getLogsDeOperacoes() { return logsDeOperacoes; }
    
    // metodo abstrato que as classes filhas Solo e competitiva vao implementar
    public abstract void calcularPontuacao();
}