package Modelos;

/**
 * @author Iván Pérez
 */
public class FamiliaArticulo {

    int codFamilia;
    String nombreFamilia;

    public FamiliaArticulo(int codFamilia, String nombreFamilia) {
        this.codFamilia = codFamilia;
        this.nombreFamilia = nombreFamilia;
    }
     public FamiliaArticulo(){
         
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
