public class Tutor extends BaseUser implements Califications {
    private Alumno alumno;

    public Tutor(int Id, String nombre, String apellido, String correoElectronico, Alumno alumno) {
        super(Id, nombre, apellido, correoElectronico);
        this.alumno = alumno;
    }

    public void mostrarCalificaciones() {
        System.out.printf("Su Alumno %s %s tiene calificacion %.2f\n", alumno.nombre, alumno.apellido, alumno.getCalificacion());
    }
}
