import javax.swing.*;
import java.util.ArrayList;
public class GestorContactos {

    private final ArrayList<Contacto> contactos;

    public GestorContactos() {
        contactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) {
        if (contactos.contains(contacto)) return;
        if (contacto == null) return;

        contactos.add(contacto);
    }


    public void eliminarContacto(Contacto contacto) {
        if (!contactos.contains(contacto)) return;
        contactos.remove(contacto);
    }

    public void modificarContacto(Contacto contacto) {
        if (!contactos.contains(contacto)) return;
        contactos.set(contactos.indexOf(contacto), contacto);
    }



    public ArrayList<Contacto> getContactos() {
        return contactos;
    }


    public void mostrarContactos() {
        // Crear el modelo de lista
        DefaultListModel<Contacto> listModel = new DefaultListModel<>();

        // Llenar el modelo con los contactos
        for (Contacto contacto : contactos) {
            listModel.addElement(contacto);
        }

        // Crear el JList con el modelo
        JList<Contacto> list = new JList<>(listModel);

        // Crear un JScrollPane para envolver el JList y permitir desplazamiento
        JScrollPane scrollPane = new JScrollPane(list);

        // Configurar la ventana de la interfaz gráfica
        JFrame frame = new JFrame("Gestor de Contactos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
