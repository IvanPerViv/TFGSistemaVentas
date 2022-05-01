package Utils;

/**
 *
 * @author Iván Pérez
 */
public class generarCodigos {

    protected int numero;
    protected int codigoInicial = 1;
    

    public int generarCod(int valor) {
        numero = valor;
        int codigo = 0;
        
        if (numero < 9) {
            codigo = codigoInicial + numero;
        }
        if (numero >= 9 || numero < 100) {
            codigo = codigoInicial + numero;
        }
        return codigo;
    }
}
