public class TarjetaDebito extends CuentaBase{
    
    public TarjetaDebito(double apertura) {
        this.montoActual = apertura;
    }

    public double retirar(double cantidad) {
        this.montoActual -= cantidad;
        return this.montoActual;
    }    
}
