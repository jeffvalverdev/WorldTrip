package worldTrip.vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.text.MessageFormat;

import worldTrip.modelo.Agencia;
import worldTrip.modelo.Cliente;

public class ConsultaClientesVista extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Agencia agencia;
    private JTable table;
    private DefaultTableModel tableModel;

    public ConsultaClientesVista(Agencia agencia) {
        this.agencia = agencia;
        setTitle("Consulta de Clientes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Crear el panel principal
        JPanel panel = new JPanel(new BorderLayout());

        // Crear la tabla y el modelo de tabla
        tableModel = new DefaultTableModel(new Object[]{"Código", 
        		"Nombre", "Apellido", "Email", "Teléfono",}, 0);
        table = new JTable(tableModel);
        cargarDatosClientes(); // Cargar los datos reales de los clientes

        // Añadir la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Crear el botón de actualizar
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarDatosClientes(); // Actualizar los datos de los clientes
            }
        });

        // Crear el botón de salir
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana
            }
        });

        // Crear un panel para los botones
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnPanel.add(btnActualizar);
        btnPanel.add(btnSalir);

        // Añadir el panel de botones a la parte inferior del panel principal
        panel.add(btnPanel, BorderLayout.SOUTH);

        // Añadir el panel principal al frame
        add(panel);
    }

    private void cargarDatosClientes() {
        // Limpiar la tabla antes de cargar nuevos datos
        tableModel.setRowCount(0);
        
        // Iterar sobre la lista real de clientes de la agencia
        for (Cliente cliente : agencia.getListaClientes()) {
            // Agregar cada cliente a la tabla
            tableModel.addRow(new Object[]{cliente.getCodigo(), cliente.getNombre(), cliente.getApellido(), cliente.getEmail(), cliente.getTelefono()});
        }
    }

    public static void main(String[] args) {
        // Crear una instancia de Agencia y agregar algunos clientes
        Agencia agencia = new Agencia();
        // Agregar clientes de prueba
        agencia.agregarCliente(new Cliente("Juan", "Pérez", "juan@example.com", "123456789"));
        agencia.agregarCliente(new Cliente("María", "López", "maria@example.com", "987654321"));

        // Mostrar la vista con la instancia de Agencia creada
        ConsultaClientesVista vista = new ConsultaClientesVista(agencia);
        vista.setVisible(true);
    }
}
