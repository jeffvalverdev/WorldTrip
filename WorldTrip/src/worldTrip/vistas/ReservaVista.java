package worldTrip.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import worldTrip.modelo.Reserva;
import worldTrip.modelo.Agencia;
import worldTrip.modelo.Cliente;
import worldTrip.modelo.Tour;



public class ReservaVista extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCodigoCliente;
    private JTextField txtNombreHotel;
    private JTextField txtNumPersonas;
    private JTextField txtFechaInicio;
    private JTextField txtFechaFin;
    private JTextField txtCosteTotal;
    private JTextField txtCiudad;
    private JTextField txtDireccion;
    private Agencia agencia;
    private JComboBox<String> cmbTours;


    public ReservaVista(Agencia agencia) {
        this.agencia = agencia;
        setTitle("Gestion de Reservas");
        setSize(700,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espacios entre los componentes

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Codigo del Cliente:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Estirar horizontalmente
        txtCodigoCliente = new JTextField(15); // Ancho del campo de texto
        panel.add(txtCodigoCliente, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Nombre del Hotel:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Estirar horizontalmente
        txtNombreHotel = new JTextField(15); // Ancho del campo de texto
        panel.add(txtNombreHotel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Numero de Personas:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        txtNumPersonas = new JTextField(15);
        panel.add(txtNumPersonas, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Fecha de Inicio:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        txtFechaInicio = new JTextField(15);
        panel.add(txtFechaInicio, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Fecha de Fin:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        txtFechaFin = new JTextField(15);
        panel.add(txtFechaFin, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Coste Total:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        txtCosteTotal = new JTextField(15);
        panel.add(txtCosteTotal, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Ciudad:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        txtCiudad = new JTextField(15);
        panel.add(txtCiudad, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Direccion:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        txtDireccion = new JTextField(15);
        panel.add(txtDireccion, gbc);

        // A�adir el JComboBox para seleccionar el tour
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Tour:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        cmbTours = new JComboBox<>();
        cmbTours.addItem("Ninguno"); // Opci�n por defecto
        // Llenar el JComboBox con los nombres de los tours disponibles
        for (Tour tour : agencia.getListaTours()) {
            cmbTours.addItem(tour.getNombreTour());
        }
        panel.add(cmbTours, gbc);

     // Bot�n para crear reserva
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2; // Ocupar dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centrar el bot�n
        gbc.fill = GridBagConstraints.NONE; // Restablecer la propiedad de relleno
        JButton btnCrearReserva = new JButton("Crear Reserva");
        btnCrearReserva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqu� puedes manejar la l�gica para crear una nueva reserva
                try {
                    int codigoCliente = Integer.parseInt(txtCodigoCliente.getText());
                    String nombreHotel = txtNombreHotel.getText();
                    int numPersonas = Integer.parseInt(txtNumPersonas.getText());
                    String fechaInicio = txtFechaInicio.getText();
                    String fechaFin = txtFechaFin.getText();
                    double costeTotal = Double.parseDouble(txtCosteTotal.getText());
                    String ciudad = txtCiudad.getText();
                    String direccion = txtDireccion.getText();

                    // Buscar al cliente por su c�digo
                    Cliente cliente = agencia.buscarClientePorCodigo(codigoCliente);

                    if (cliente != null) {
                        // Crear una nueva instancia de Reserva
                        Reserva nuevaReserva = new Reserva(cliente, nombreHotel, numPersonas, fechaInicio, fechaFin, costeTotal, direccion, ciudad);

                        // Asociar el cliente a la reserva
                        nuevaReserva.setCliente(cliente);

                        // Obtener el tour seleccionado por el usuario
                        String tourSeleccionado = cmbTours.getSelectedItem().toString();
                        // Buscar el tour por su nombre
                        Tour tour = agencia.buscarTourPorNombre(tourSeleccionado);
                        // Asociar el tour con la reserva creada
                        nuevaReserva.setTour(tour);

                        // Agregar la reserva a la lista de reservas de la agencia
                        agencia.getListaReservas().add(nuevaReserva);

                        // Mostrar un mensaje emergente con los datos de la reserva
                        JOptionPane.showMessageDialog(null,
                                "Nueva reserva creada satisfactoriamente:\n" +
                                        "Codigo de Reserva: " + nuevaReserva.getCodigoReserva() + "\n" +
                                        "Nombre del Hotel: " + nombreHotel + "\n" +
                                        "Numero de Personas: " + numPersonas + "\n" +
                                        "Fecha de Inicio: " + fechaInicio + "\n" +
                                        "Fecha de Fin: " + fechaFin + "\n" +
                                        "Coste Total: " + costeTotal + "\n" +
                                        "Ciudad: " + ciudad + "\n" +
                                        "Tour: " + (tour != null ? tour.getNombreTour() : "Ninguno") + "\n" +
                                        "Direccion: " + direccion,
                                "Reserva Creada",
                                JOptionPane.INFORMATION_MESSAGE);

                        // Limpiar los campos de texto despu�s de crear la reserva
                        txtCodigoCliente.setText("");
                        txtNombreHotel.setText("");
                        txtNumPersonas.setText("");
                        txtFechaInicio.setText("");
                        txtFechaFin.setText("");
                        txtCosteTotal.setText("");
                        txtCiudad.setText("");
                        txtDireccion.setText("");
                    } else {
                        // Mostrar un mensaje de error si no se encuentra el cliente
                        JOptionPane.showMessageDialog(null, "No se encontr� un cliente con el c�digo proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    // Mostrar un mensaje de error si los datos no son v�lidos
                    JOptionPane.showMessageDialog(null, "Por favor ingresa datos v�lidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(btnCrearReserva, gbc);
        
     // Bot�n "Salir"
        gbc.gridy = 10;
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(btnSalir, gbc);

        add(panel);
    }
}