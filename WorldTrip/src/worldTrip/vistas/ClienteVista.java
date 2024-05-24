package worldTrip.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import worldTrip.modelo.Cliente;
import worldTrip.modelo.Agencia;

public class ClienteVista extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEmail;
    private JTextField txtTelefono;
    private Agencia agencia;

    public ClienteVista(Agencia agencia) {
        this.agencia = agencia;
        setTitle("Gesti�n de Clientes");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtNombre = new JTextField(15);
        panel.add(txtNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Apellido:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        txtApellido = new JTextField(15);
        panel.add(txtApellido, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        txtEmail = new JTextField(15);
        panel.add(txtEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Telefono:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        txtTelefono = new JTextField(15);
        panel.add(txtTelefono, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        JButton btnCrearCliente = new JButton("Crear Cliente");
        btnCrearCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String email = txtEmail.getText();
                String telefono = txtTelefono.getText();

                Cliente nuevoCliente = new Cliente(nombre, apellido, email, telefono);
                agencia.getListaClientes().add(nuevoCliente);

                JOptionPane.showMessageDialog(null,
                    "Nuevo cliente creado satisfactoriamente:\n" +
                    "Codigo: " + nuevoCliente.getCodigo() + "\n" +
                    "Nombre: " + nombre + "\n" +
                    "Apellido: " + apellido + "\n" +
                    "Email: " + email + "\n" +
                    "Telefono: " + telefono,
                    "Cliente Creado",
                    JOptionPane.INFORMATION_MESSAGE);

                txtNombre.setText("");
                txtApellido.setText("");
                txtEmail.setText("");
                txtTelefono.setText("");
            }
        });
        panel.add(btnCrearCliente, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        gbc.anchor = GridBagConstraints.CENTER; // Alineaci�n vertical al centro
        panel.add(btnSalir, gbc);

        add(panel);
    }
}
