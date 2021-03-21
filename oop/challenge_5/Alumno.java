public class Alumno extends BaseUser implements Califications {
    private float calificacion;

    public Alumno(int Id, String nombre, String apellido, String correoElectronico) {
        super(Id, nombre, apellido, correoElectronico);
    }

    public void mostrarCalificaciones() {
        System.out.printf("Alumno %s %s tiene calificacion %.2f\n", this.nombre, this.apellido, this.calificacion);
    }

    public float guardarCalificacion(float calificacion) {
        this.calificacion = calificacion;
        return this.calificacion;
    }

    public float getCalificacion() {
        return this.calificacion;
    }
}
