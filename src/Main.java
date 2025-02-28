import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private JButton addContactBtn;
    private JPanel MainPanel;
    private JTextField tfName;
    private JTextField tfApellido;
    private JTextField tfTelefono;
    private JTextField tfEmail;
    private JList listContactos;
    private JButton DeleteBtn;
    private DefaultListModel<Contacto> listModelContactos;


    GestorContactos gestor = new GestorContactos();

    public Main(){
        setContentPane(MainPanel);

        setTitle("Contactos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        listModelContactos = new DefaultListModel<>();
        listContactos.setModel(listModelContactos);


        /**
         * Acción que se ejecuta al presionar el botón "Agregar Contacto".
         *
         * - Valida que los campos no estén vacíos.
         * - Crea un nuevo objeto Contacto con los datos ingresados.
         * - Agrega el contacto al gestor de contactos.
         * - Lo añade a la lista visual (JList).
         * - Limpia los campos del formulario después de agregar el contacto.
         */

        addContactBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                // Asignacion y validacion de los datos.

                String name = validateNotEmpty(tfName.getText(),"Nombre");
                String apellido = validateNotEmpty(tfApellido.getText(),"Apellido");
                String telefono = validateNotEmpty(tfTelefono.getText(),"Telefono");
                String email = validateNotEmpty(tfEmail.getText(),"Email");

                //TODO: Realizar validacion de Email y telefono.


                // Creamos del objeto contacto;
                Contacto contacto = new Contacto(name, apellido, telefono, email);
                gestor.agregarContacto(contacto);


                listModelContactos.addElement(contacto);


                tfName.setText("");
                tfApellido.setText("");
                tfTelefono.setText("");
                tfEmail.setText("");

            }
        });


        DeleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contacto selected = (Contacto) listContactos.getSelectedValue();
                if (selected != null) JOptionPane.showMessageDialog(null, "Contacto Eliminado Correctamente!", "Contacto Eliminado", JOptionPane.INFORMATION_MESSAGE);
                listModelContactos.removeElement(selected);
                gestor.eliminarContacto(selected);

                tfName.setText("");
                tfApellido.setText("");
                tfTelefono.setText("");
                tfEmail.setText("");


            }
        });
    }


    public static void main(String[] args) {
        new Main();
    }



    // TODO: Arreglar que cuando los datos no estan bien no deben quedar en null.
    public String validateNotEmpty(String input, String fieldName){
        if (input.isEmpty() || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo " + fieldName + " no puede estar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        return input;
    }


}



