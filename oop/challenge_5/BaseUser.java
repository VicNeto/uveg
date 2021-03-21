abstract class BaseAbstractUser {
    protected int Id;
    protected String nombre;
    protected String apellido;
    protected String correoElectronico;
}

public class BaseUser extends BaseAbstractUser implements Perfil {
    public BaseUser (int Id, String nombre, String apellido, String correoElectronico) {
        this.Id = Id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
    }

    public void imprimirPerfil() {
        System.out.printf("Id: %d\n", this.Id);
        System.out.printf("Nombre: %s\n", this.nombre);
        System.out.printf("Apellido: %s\n", this.apellido);
        System.out.printf("Correo electronico: %s\n", this.correoElectronico);
    }
}