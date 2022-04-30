package Modelos;

/**
 * @author Iván Pérez
 */
public class FamiliaArticulos {

    int codFamilia;
    String nombreFamilia;

    public FamiliaArticulos(int codFamilia, String nombreFamilia) {
        this.codFamilia = codFamilia;
        this.nombreFamilia = nombreFamilia;
    }

    public int getCodFamilia() {
        return codFamilia;
    }

    public void setCodFamilia(int codFamilia) {
        this.codFamilia = codFamilia;
    }

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }

}
