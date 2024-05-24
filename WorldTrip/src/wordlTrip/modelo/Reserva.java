package wordlTrip.modelo;

import wordlTrip.modelo.Cliente;

import wordlTrip.modelo.Tour;

public class Reserva {
	
    private static int contadorReservas = 0;

    private int codigoReserva;
    private String nombreHotel;
    private int numPersonas;
    private String fechaInicio;
    private String fechaFin;
    private double costeTotal;
    private String ciudad;
    private String direccion;
    private Tour tour;
    private Cliente cliente;

    public Reserva(Cliente cliente, String nombreHotel, int numPersonas, String fechaInicio, 
            String fechaFin, double costeTotal, String direccion, String ciudad) {
        this.codigoReserva = ++contadorReservas;
        this.cliente = cliente; // Asignar el cliente recibido como argumento
        this.nombreHotel = nombreHotel;
        this.numPersonas = numPersonas;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costeTotal = costeTotal;
        this.ciudad = ciudad;
        this.direccion = direccion;        
    }

    public int getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(int codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getCosteTotal() {
        return costeTotal;
    }

    public void setCosteTotal(double costeTotal) {
        this.costeTotal = costeTotal;
    }
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    @Override
    public String toString() {
        return "Reserva [codigoReserva=" + codigoReserva + ", nombreHotel=" + nombreHotel + ", numPersonas="
                + numPersonas + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", costeTotal=" + costeTotal
                + ", ciudad=" + ciudad + ", direccion=" + direccion + ", cliente=" + cliente + "]";
 }
}
