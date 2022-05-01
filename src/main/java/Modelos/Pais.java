package Modelos;

/**
 * @author Iván Pérez
 */
public class Pais {
    protected int cod;
    protected String pais;

    public Pais(int cod, String pais) {
        this.cod = cod;
        this.pais = pais;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return cod + " - " + pais;
    }
    
}
