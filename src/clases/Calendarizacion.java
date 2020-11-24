package clases;

import java.util.Scanner;

public class Calendarizacion {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("***********************************************************");
		System.out.println("SOFTWARE PARA CALCULAR EL HORARIO ADECUADO EN UNA EMPRESA X");
		System.out.println("***********************************************************");
		System.out.println("LEYENDA: 1 = trabajo, 0 = descanso");
		System.out.println("¿Cuántos días de trabajo tendrá cada trabajador?");
		int dias_trabajo = entrada.nextInt();
		System.out.println("¿Cuántos días de descanso por semana tendrá cada trabajador?");
		int dias_descanso = entrada.nextInt();
		System.out.println("¿Cuántos puestos desea cubrir?");
		int cantidad_puestos = entrada.nextInt();

		Logica mensajero = new Logica(dias_trabajo, dias_descanso, cantidad_puestos);

		
		do {
			mensajero.bandera_trabajador = false;
			mensajero.bandera_dia = false;
			mensajero.getAleatorios();
			mensajero.getValidarHorarioxTrabajador(); //Validación fila por fila
			if (mensajero.bandera_trabajador == false) {
				mensajero.getDescansosxDia(); //Validación columna por columna
			}
		} while (mensajero.bandera_trabajador == true || mensajero.bandera_dia == true);

		if(mensajero.bandera_trabajador == false && mensajero.bandera_dia == false) {
			mensajero.setDescansero();
			mensajero.setSolucion();
		}	
	}
}
