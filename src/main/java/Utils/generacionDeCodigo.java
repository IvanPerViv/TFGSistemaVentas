package Utils;

/**
 *
 * @author Iván Pérez
 */
public class generacionDeCodigo {

    protected int codigoInicial = 1;
    
    public int generarCod(int valor) {
        int codigo = 0;
        
        if (valor < 10000) {
            codigo = codigoInicial + valor;
        }
        return codigo;
    }
}
