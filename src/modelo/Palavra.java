package modelo;

public class Palavra {
    private String texto; 
    private Nivel dificuldade; 
    private String dica; 

    public Palavra(String texto, Nivel dificuldade, String dica) {
        this.texto = texto;
        this.dificuldade = dificuldade;
        this.dica = dica;
    }

    public String getTexto() { return texto; }
    public int getTamanho() { return texto.length(); }
    public Nivel getDificuldade() { return dificuldade; }
    public String getDica() { return dica; }
}