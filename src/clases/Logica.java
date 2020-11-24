package clases;

public class Logica {

	/*
	 * L M M J V S D Trabajador1 0 1 1 1 1 1 1 Trabajador2 1 0 1 1 1 1 1 Descansero
	 * 1 1 0 0 0 0 0
	 */

	private int dias_trabajo, dias_descanso, cantidad_puestos;
	private int lista_horarios[][];
	boolean bandera_trabajador, bandera_dia;;

	public Logica(int dias_trabajo, int dias_descanso, int cantidad_puestos) {
		this.dias_trabajo = dias_trabajo;
		this.dias_descanso = dias_descanso;
		this.cantidad_puestos = cantidad_puestos;
		lista_horarios = new int[cantidad_puestos + 1][dias_trabajo];
	}

	public int[][] getAleatorios() {
		// Obtenemos números aleatorios y los redondeamos a 0 o 1
		int numero_generado = 0;
		for (int j = 0; j < cantidad_puestos; j += 1) {
			for (int i = 0; i < dias_trabajo; i += 1) {
				numero_generado = (int) Math.round(Math.random());
				lista_horarios[j][i] = numero_generado;
			}
		}
		return lista_horarios;
	}

	public void setSolucion() {
		for (int[] j : lista_horarios) {
			for (int i : j) {
				System.out.print("[" + i + "]");
			}
			System.out.println("");
		}
	}

	public boolean getValidarHorarioxTrabajador() {
		/*
		 * Validamos que c/t tenga sus días de trabajo y descanso correctos Validación
		 * fila por fila
		 */
		int suma_dias_trabajo = 0;
		for (int j = 0; j < cantidad_puestos && !bandera_trabajador; j += 1) {
			for (int i = 0; i < dias_trabajo; i += 1) {
				suma_dias_trabajo += lista_horarios[j][i];
			}
			if (suma_dias_trabajo != dias_trabajo - dias_descanso) {
				bandera_trabajador = true;
			}
			suma_dias_trabajo = 0;
		}
		return bandera_trabajador;
	}

	public boolean getDescansosxDia() {
		// Validamos que por cada día haya sólo un trabajador en descanso
		int descansos_dia = 0, descansos_total = 0;
		for (int i = 0; i < dias_trabajo && !bandera_dia; i += 1) {
			for (int j = 0; j < cantidad_puestos; j += 1) {
				if (lista_horarios[j][i] == 0) {
					descansos_dia += 1;
				}
			}
			if (descansos_dia == 0 || descansos_dia == 1) {
				descansos_total += descansos_dia;
				descansos_dia = 0;
			} else {
				bandera_dia = true;
			}
		}
		if (descansos_total != cantidad_puestos) {
			bandera_dia = true;
		}
		return bandera_dia;
	}

	public void setDescansero() {
		for (int j = 0; j < cantidad_puestos; j += 1) {
			for (int i = 0; i < dias_trabajo; i += 1) {
				if (lista_horarios[j][i] == 0) {
					lista_horarios[cantidad_puestos][i] = 1;
				}
			}
		}
	}
}
