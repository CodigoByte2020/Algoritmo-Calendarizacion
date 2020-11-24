package clases;

public class Logica {

	/*
	 * L M M J V S D Trabajador1 0 1 1 1 1 1 1 Trabajador2 1 0 1 1 1 1 1 Descansero
	 * 1 1 0 0 0 0 0
	 */

	private int dias_trabajo, dias_descanso, cantidad_puestos;
	private int[] lista_horarios;
	private int[][] cromosomas;
	private int fila_cromosoma;
	private int descansos_validacion1, descansos_validacion2_trabajadores, trabajos_validacion2_descansero;
	private int poblacion_inicial;
	private boolean validacion = true;
	private int[] posicion_descanso_trabajadores;
	private int posicion_trabajo_descanseros[];
	
	public Logica(int dias_trabajo, int dias_descanso, int cantidad_puestos, int poblacion_inicial) {
		this.dias_trabajo = dias_trabajo;
		this.dias_descanso = dias_descanso;
		this.cantidad_puestos = cantidad_puestos;
		lista_horarios = new int[dias_trabajo * (cantidad_puestos + 1)];
		cromosomas = new int[poblacion_inicial][dias_trabajo * (cantidad_puestos + 1)];
		this.poblacion_inicial = poblacion_inicial;
		posicion_descanso_trabajadores = new int[cantidad_puestos];
		posicion_trabajo_descanseros = new int[cantidad_puestos];
	}

	public void setFilaCromosoma(int fila_cromosoma) {
		this.fila_cromosoma = fila_cromosoma;
	}
	
	public void getAleatorios() {
		// Obtenemos números aleatorios y los redondeamos a 0 o 1
		int numero_generado = 0;
		for (int i = 0; i < lista_horarios.length; i += 1) {
			numero_generado = (int) Math.round(Math.random());
			lista_horarios[i] = numero_generado;
		}
	}

	public void setCromosomas() {
		for (int i = 0; i < lista_horarios.length; i += 1) {
			cromosomas[fila_cromosoma][i] = lista_horarios[i];
		}
		fila_cromosoma += 1;
	}

	public void ImprimirCromosomas() {
		for (int[] j : cromosomas) {
			for (int i : j) {
				System.out.print("[" + i + "]");
			}
			System.out.println("");
		}
	}

	public boolean validacion1() {
		// Validamos que en cada cromosoma haya 7 descansos.
		fila_cromosoma += 1;
		for (int i : cromosomas[fila_cromosoma]) {
			if (i == 0) {
				descansos_validacion1 += 1;
			}
		}
		if (descansos_validacion1 != dias_trabajo) {
			validacion = false;
		}
		// fila_cromosoma += 1;
		return validacion;
	}

	public boolean validacion2() {
		// Validamos que en cada parte del cromosoma haya 0 o 1 descanso.
		// Validamos que el descansero trabaje la cantidad de días descansados por los trabajadores.
		// Guardamos el index de cada descanso en un array.
		// i index the cromosoma
		// ii index the cada parte del cromosoma
		// iii index the posicion_descanso_trabajadores
		// iiii index the posicion_trabajo_descanseros
		int iii = 0, iiii = 0;
		for (int i = 0; i < cromosomas.length && iii < cantidad_puestos && iiii < cantidad_puestos;) {
			for (int ii = 0; ii < dias_trabajo; ii += 1) {
				if (i < cantidad_puestos * dias_trabajo) {
					if (cromosomas[fila_cromosoma][i] == 0) {
						posicion_descanso_trabajadores[iii] = ii;
						descansos_validacion2_trabajadores += 1;
						iii += 1;
					}
				} else {
					if (cromosomas[fila_cromosoma][i] == 1) {
						posicion_trabajo_descanseros[iiii] = ii;
						trabajos_validacion2_descansero += 1;
						iiii += 1;
					}
				}
				i += 1;
			}			
		}
		
		if (descansos_validacion2_trabajadores != trabajos_validacion2_descansero) {
			validacion = false;
		}
		
		//fila_cromosoma += 1;
		return validacion;
	}
	
	
	public boolean validacion3() {
		// Validamos que por dia de trabajo haya 0 o 1 descanso.
		
		return validacion;
	}

}