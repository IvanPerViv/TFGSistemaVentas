package Utils;

/**
 *
 * @author Iván Pérez
 */
public class generarCodigos {

    protected int dato;
    protected int codigoInicial = 1;
    

    public int generarCod(int dato) {
        this.dato = dato;
        int codigo = 0;
        
        if (this.dato < 9) {
            codigo = codigoInicial + this.dato;
        }
        if ((this.dato >= 9) || (this.dato < 100)) {
            codigo = codigoInicial + this.dato;
        }
        return codigo;
    }
}
