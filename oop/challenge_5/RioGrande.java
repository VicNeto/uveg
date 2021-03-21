public class RioGrande {
    public static void main(String[] args) {
        System.out.println("Escuela Rio Grande");
        // Maestro
        System.out.println("INSERT INTO TABLE maestros VALUES (1, \"Andres\", \"Espinal\", \"anespinal@uveg.edu.mx\");");
        simulateDBOperation(3);

        Maestro m = new Maestro(1, "Andres", "Espinal", "anespinal@uveg.edu.mx");
        System.out.println("SELECT * FROM maestros;");
        simulateDBOperation(3);
        m.imprimirPerfil();

        // Alumno
        System.out.println("INSERT INTO TABLE alumnos VALUES (13, \"Victor\", \"Gutierrez\", \"victor@uveg.edu.mx\", 10);");
        simulateDBOperation(3);

        Alumno alumno = new Alumno(13, "Victor", "Gutierrez", "victor@uveg.edu.mx");
        alumno.guardarCalificacion(10);
        System.out.println("SELECT * FROM alumnos;");
        simulateDBOperation(3);
        alumno.imprimirPerfil();
        alumno.mostrarCalificaciones();

        // Tutor
        System.out.println("INSERT INTO TABLE tutores VALUES (3, \"Michelle\", \"Dominguez\", \"midominguez@uveg.edu.mx\");");
        simulateDBOperation(3);

        Tutor tutor = new Tutor(3, "Michelle", "Dominguez", "midominguez@uveg.edu.mx", alumno);
        System.out.println("SELECT * FROM tutores;");
        simulateDBOperation(3);
        tutor.imprimirPerfil();
        tutor.mostrarCalificaciones();
        
    }

    private static void simulateDBOperation(int time) {
        // Thread.sleep(1000);
        try {
            for (int i = 0; i < 8; i++) {
                Thread.sleep(time * 100);
                System.out.printf("-");
            }
            System.out.printf("\n");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
