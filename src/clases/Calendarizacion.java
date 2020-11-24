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
		System.out.println("¿Cuanta será la población inicial?");
		int poblacion_inicial = entrada.nextInt();
		
		Logica objeto = new Logica(dias_trabajo, dias_descanso, cantidad_puestos, poblacion_inicial);

		for (int i = 0; i < poblacion_inicial; i += 1) {
			objeto.getAleatorios();
			objeto.setCromosomas();
		}
		
		//objeto.ImprimirCromosomas();
		
		objeto.validacion1();
		if (!objeto.validacion1()) {
			objeto.validacion2();
			if (!objeto.validacion2()) {
				objeto.validacion3();
			}
		}		
	}
}
