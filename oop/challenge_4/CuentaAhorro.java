public class CuentaAhorro extends CuentaBase{
    
    public CuentaAhorro(double apertura) {
        this.montoActual = apertura;
    }

    public double invertir() {
        this.montoActual += this.montoActual * 0.1;
        return this.montoActual;
    }
}
