package modelo;

public enum Nivel {
    FACIL(1.0), NORMAL(1.5), DIFICIL(2.0);
    
    private final double multiplicador;
    
    Nivel(double multiplicador) {
        this.multiplicador = multiplicador;
    }
    
    public double getMultiplicador() {
        return multiplicador;
    }
}