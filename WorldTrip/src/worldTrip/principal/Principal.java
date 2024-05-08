package worldTrip.principal;

import java.util.Scanner;

public class Principal {
	private static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {

		System.out.println("Menu de Worldtrip");
		int opcion=0;
		String menu= "1-Alta Cliente,\n"+
				"2-Lista de los Tours\n"+
				"3-Realizar una reserva\n"+
				"4-Modificar Reserva\n"+
				"5-Añadir Tour\n"+
				"6-Cancelar Tour\n"+
				"7-Cancelar Reserva\n"+
				"8-Baja Cliente\n"+
				"9-Salir\n";
		
		Reserva reservas=new Reserva();
		
		do {
			System.out.println(menu);
			System.out.println("Dame una opcion: ");
			opcion=sc.nextInt();
			switch(opcion) {
			case 1:
				reservas.AltaCliente();
				break;
			case 2:
				reservas.ListaTours();
				break;
			case 3:
				reservas.Realizarreserva();
				break;
			case 4:
				reservas.ModificarReserva();
				break;
			case 5:
				reservas.AñadirTour();
				break;
			case 6:
				reservas.CancelarTour();
				break;
			case 7:
				reservas.CancelarReserva();
				break;
			case 8:
				reservas.BajaCliente();
				break;
			case 9: 
				System.out.println("Esta saliendo...");
				break;
			default:
				   System.out.println("Opciones incorrectas.");
				   System.out.println(menu);
			}
		}while(opcion!=9);
	}
}
