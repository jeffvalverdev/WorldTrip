package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Agencia {
    private List<Cliente> listaClientes;
    private List<Tour> listaTours;
    private List<Reserva> listaReservas;
    
    
    


    public Agencia() {
        this.listaClientes = new ArrayList<>();
        this.listaTours = new ArrayList<>();
        this.listaReservas = new ArrayList<>();
        
        Tour tour1 = new Tour("MAD001", "Tour por el Palacio Real", "Madrid", 2, 35.50);
        Tour tour2 = new Tour("MAD002", "Visita al Museo del Prado", "Madrid", 3, 20);

        Tour tour3 = new Tour("BCN001", "Tour por la Sagrada Familia", "Barcelona", 2, 32.80);
        Tour tour4 = new Tour("BCN002", "Paseo por Las Ramblas", "Barcelona", 2, 20);

        Tour tour5 = new Tour("VAL001", "Visita a la Ciudad de las Artes y las Ciencias", "Valencia", 3, 30);
        Tour tour6 = new Tour("VAL002", "Tour por el casco antiguo de Valencia", "Valencia", 2, 40);
        agregarTour(tour1);
        agregarTour(tour2);
        agregarTour(tour3);
        agregarTour(tour4);
        agregarTour(tour5);
        agregarTour(tour6);    
    }
   

    // Métodos para la gestión de clientes
    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void mostrarClientes() {
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }
    // añadido para que me muestre las lista de clientes en mi ventana de gestion de clientes
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
    public List<Tour> getListaTours() {
        return listaTours;
    }
    
    public List<Reserva> getListaReservas() {
        return listaReservas;
    }
    
 // Método para buscar un cliente por su código
    public Cliente buscarClientePorCodigo(int codigoCliente) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCodigo() == codigoCliente) {
                return cliente;
            }
        }
        return null; // Retorna null si no se encuentra el cliente con el código dado
    }
    

    // Métodos para la gestión de tours
    public void agregarTour(Tour tour) {
        listaTours.add(tour);
    }

    public void mostrarToursDisponibles() {
        for (Tour tour : listaTours) {
            System.out.println(tour);
        }
    }
    public Tour buscarTourPorNombre(String nombre) {
        for (Tour tour : listaTours) {
            if (tour.getNombreTour().equals(nombre)) {
                return tour;
            }
        }
        return null; // Retorna null si no se encuentra ningún tour con ese nombre
    }

    // Métodos para la gestión de reservas
    public void agregarReserva(Reserva reserva) {
        listaReservas.add(reserva);
    }

    public void mostrarReservas() {
        for (Reserva reserva : listaReservas) {
            System.out.println(reserva);
        }
    }
    
    
 // Método para eliminar una reserva por su código
    public void eliminarReservaPorCodigo(int codigoReserva) {
        boolean reservaEncontrada = false;
        for (Reserva reserva : listaReservas) {
            if (reserva.getCodigoReserva() == codigoReserva) {
                listaReservas.remove(reserva);
                reservaEncontrada = true;
                // Mostrar ventana emergente confirmando la eliminación de la reserva
                JOptionPane.showMessageDialog(null, "Usted acaba de borrar la reserva del cliente " + reserva.getCliente().getNombre() + " con código " + reserva.getCodigoReserva() + " en el hotel " + reserva.getNombreHotel() + " satisfactoriamente.");
                break; // Terminar el bucle después de eliminar la reserva
            }
        }
        // Si no se encontró la reserva, mostrar ventana emergente indicando que el código de reserva no existe
        if (!reservaEncontrada) {
            JOptionPane.showMessageDialog(null, "El código de la reserva no existe.");
        }
    }
    
    public void mostrarClientesYReservas() {
        for (Cliente cliente : listaClientes) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cliente: ").append(cliente.getNombre()).append(" ").append(cliente.getApellido()).append(" | Reservas: ");

            boolean clienteConReservas = false;
            for (Reserva reserva : listaReservas) {
                if (reserva.getCliente() == cliente) {
                    sb.append("[Código de reserva: ").append(reserva.getCodigoReserva())
                      .append(", Nombre del hotel: ").append(reserva.getNombreHotel())
                      .append(", Fecha de inicio: ").append(reserva.getFechaInicio())
                      .append(", Fecha de fin: ").append(reserva.getFechaFin())
                      .append("] ");
                    clienteConReservas = true;
                }
            }

            if (!clienteConReservas) {
                sb.append("Este cliente no tiene reservas.");
            }

            System.out.println(sb.toString());
        }
        
        
    }

    
}
