package wordlTrip.modelo;

public class Tour {
    private String codigoTour;
    private String nombreTour;
    private String ciudad;
    private int duracion;
    private double coste;

    public Tour(String codigoTour, String nombreTour, String ciudad,
    		int duracion, double coste) {
        this.codigoTour = codigoTour;
        this.nombreTour = nombreTour;
        this.ciudad = ciudad;
        this.duracion = duracion;
        this.coste = coste;
    }

    public String getCodigoTour() {
        return codigoTour;
    }

    public void setCodigoTour(String codigoTour) {
        this.codigoTour = codigoTour;
    }

    public String getNombreTour() {
        return nombreTour;
    }

    public void setNombreTour(String nombreTour) {
        this.nombreTour = nombreTour;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

	@Override
	public String toString() {
		return "Tour [codigoTour=" + codigoTour + ", nombreTour=" + nombreTour + ", ciudad=" + ciudad + ", duracion="
				+ duracion + ", coste=" + coste + "]";
	}
    
    
}
