public class TarjetaCredito extends CuentaBase {

    public TarjetaCredito(double apertura) {
        this.montoActual = -apertura;
    }

    public double sumaInteres() {
        this.montoActual -= 0.15 * this.montoActual;
        return this.montoActual;
    }
}