public class Espaço {
    private int valor;
    private Boolean alteravel;


    public Espaço(int valor, Boolean alteravel) {
        this.valor = valor;
        this.alteravel = alteravel;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Boolean getAlteravel() {
        return alteravel;
    }

    public void setAlteravel(Boolean alteravel) {
        this.alteravel = alteravel;
    }
}
