public class CuentaBase {
    protected double montoActual;

    public double depositar(double cantidad) {
        this.montoActual += cantidad;
        return this.montoActual;
    }

    public double getMontoActual() {
        return this.montoActual;
    }
}
