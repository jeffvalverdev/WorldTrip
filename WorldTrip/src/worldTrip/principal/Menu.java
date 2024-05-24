package worldTrip.principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import worldTrip.modelo.Agencia;
import worldTrip.vistas.ClienteVista;
import worldTrip.vistas.ConsultaClientesVista;
import worldTrip.vistas.ReservaVista;


public class Menu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel panelPrincipal;
    private Agencia agencia; 

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu frame = new Menu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Menu() {
        // Inicializar la agencia
        agencia = new Agencia();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 555, 446);
        panelPrincipal = new JPanel();
        panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelPrincipal);
        panelPrincipal.setLayout(new BorderLayout());

        // Crear un JLabel con el t�tulo "World Trip"
        JLabel lblTitulo = new JLabel("Bienvenido a WorldTrip");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 40)); // Establecer la fuente y tama�o del texto
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto horizontalmente

        // Agregar el JLabel al panel en la parte superior
        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);

        // Crear bot�n "Gesti�n de Clientes"
        JButton btnClienteVista = new JButton("Gestion de Clientes");
        btnClienteVista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqu� puedes agregar la l�gica para abrir la ventana de gesti�n de clientes
                ClienteVista clienteVista = new ClienteVista(agencia);
                clienteVista.setVisible(true);
            }
        });

        // Crear bot�n "Gesti�n de Reservas"
        JButton btnReservaVista = new JButton("Gestion de Reservas");
        btnReservaVista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqu� puedes agregar la l�gica para abrir la ventana de gesti�n de reservas
                ReservaVista reservaVista = new ReservaVista(agencia);
                reservaVista.setVisible(true);
            }
        });
     // Crear bot�n "Consultar Clientes" y agregar su ActionListener
        JButton btnConsultaClientes = new JButton("Consultar Clientes");
        btnConsultaClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqu� puedes agregar la l�gica para abrir la ventana de consulta de clientes
                ConsultaClientesVista consultaClientesVista = new ConsultaClientesVista(agencia);
                consultaClientesVista.setVisible(true);
            }
        });
        
     // Crear bot�n "Salir"
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la aplicaci�n cuando se hace clic en el bot�n "Salir"
                System.exit(0);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 5, 5)); // Cambiado a 3 filas
        buttonPanel.add(btnClienteVista);
        buttonPanel.add(btnReservaVista);
        buttonPanel.add(btnConsultaClientes); // Agregado el bot�n de consulta de clientes
        buttonPanel.add(btnSalir); // Agregar el bot�n "Salir" al panel de botones
        // Agregar el panel de botones al panel principal
        panelPrincipal.add(buttonPanel, BorderLayout.CENTER);
    }
}
