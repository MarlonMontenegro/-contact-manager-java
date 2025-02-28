public class Contacto {

    private static int contadorId = 1;
    private int id;
    String nombre;
    String apellido;
    String telefono;
    String email;


    public Contacto(String nombre, String apellido, String telefono, String email) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id + ". " + nombre + " " + apellido + " | Tel: " + telefono + " | Email: " + email;
    }
}


