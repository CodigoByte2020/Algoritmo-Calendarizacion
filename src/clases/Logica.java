package clases;

public class Logica {

	/*
	 * L M M J V S D Trabajador1 0 1 1 1 1 1 1 Trabajador2 1 0 1 1 1 1 1 Descansero
	 * 1 1 0 0 0 0 0
	 */

	private int dias_trabajo, dias_descanso, cantidad_puestos;
	private int lista_horarios[];
	private int cromosomas[][];
	private int fila_cromosomas;
	private int descansos_validacion1, descansos_validacion2;
	private int fila_cromosoma;
	private int poblacion_inicial;
	private boolean validacion = true;
	private int posicion_descansos[];

	public Logica(int dias_trabajo, int dias_descanso, int cantidad_puestos, int poblacion_inicial) {
		this.dias_trabajo = dias_trabajo;
		this.dias_descanso = dias_descanso;
		this.cantidad_puestos = cantidad_puestos;
		lista_horarios = new int[dias_trabajo * (cantidad_puestos + 1)];
		cromosomas = new int[poblacion_inicial][dias_trabajo * (cantidad_puestos + 1)];
		this.poblacion_inicial = poblacion_inicial;
		posicion_descansos = new int[cantidad_puestos + 1];
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
			cromosomas[fila_cromosomas][i] = lista_horarios[i];
		}
		fila_cromosomas += 1;
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
		for (int i : cromosomas[fila_cromosoma]) {
			if (i == 0) {
				descansos_validacion1 += 1;
			}
		}
		if (descansos_validacion1 != 7) {
			validacion = false;
		}
		//fila_cromosoma += 1;
		return validacion;
	}

	public boolean validacion2() {
		// Validamos que en cada parte del cromosoma haya 0 o 1 descanso, excepto la última parte del descansero.
		// Guardamos el index de cada descanso en un array.
		int iii = 0; // index the posicion_descansos[]
		for (int i = 0; i < cromosomas.length;) {
			for (int ii = 0; ii <= cantidad_puestos; ii += 1) {
				if (cromosomas[fila_cromosoma][i] == 0) {
					posicion_descansos[iii] = cromosomas[fila_cromosoma][ii];
					descansos_validacion2 += 1;
					iii += 1;
				}
				i += 1;
			}
			if (descansos_validacion2 > 1) {
				validacion = false;
			}
		}
		return validacion;
	}
	
	public boolean validacion3() {
		//Validamos que por dia de trabajo haya 0 o 1 descanso.
		
		return validacion;
	}
	
	
	
	
	
	
	

}