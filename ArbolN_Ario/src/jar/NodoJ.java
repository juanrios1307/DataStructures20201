package jar;

public class NodoJ extends NodoBin<Jarras[]> {
	private int aux;
	

	public int getAux() {
		return aux;
	}

	public void setAux(int aux) {
		this.aux = aux;
	}

	public NodoJ(Jarras[] estado1) {
		super(estado1);

	}

	public void setHijoIzq(NodoJ nodo) {
		super.setHijoIzq(nodo);
	}

	public NodoJ getHijoIzq() {
		return (NodoJ) super.getHijoIzq();
	}

	public void setHermano(NodoJ nodo) {
		super.setHermano(nodo);
	}

	public NodoJ getHermano() {
		return (NodoJ) super.getHermano();
	}

	public void sol1(NodoJ nodo) {
		if (this.hijoIzq == null) {
			this.setHijoIzq(nodo);
			nodo.setPadre(this);
		} else {
			this.getHijoIzq().setHermano(nodo);
			nodo.setPadre(this);
		}

	}
	public String accion(int i) {
		switch (i) {
		case (0):
			return "Se lleno la Jarra 1";
		case(1):
			return "Se lleno la Jarra 2";
		case(2):
			return "Se vacio la Jarra 1";
		case(3):
			return "Se vacio la Jarra 2";
		case(4):
			return "Se paso el contenido de la Jarra 1 a la Jarra 2";
		case(5):
			return "Se paso el contenido de la Jarra 2 a la Jarra 1";
		}
		return "No se pudo complertar la accion";
	}

	public void operadores(Jarras j1, Jarras j2) {
		Jarras tj1 = new Jarras(j1.getCap());
		Jarras tj2 = new Jarras(j2.getCap());

		for (int i = 0; i < 6; i++) {

			// llenar j1
			if (j1.getEstado() < j1.getCap() && i == 0) {
				tj1.setEstado(j1.getCap());
				tj2.setEstado(j2.getEstado());
				// Se crea un nuevo hijo para a�adir al padre que se est� creando
				Jarras[] jarras = { tj1, tj2 };
				NodoJ nodo = new NodoJ(jarras);
				nodo.aux = i;
				sol1(nodo);

			}

			// llenar garrafa j2
			if (j2.getEstado() < j2.getCap() && i == 1) {
				tj1.setEstado(j1.getEstado());
				tj2.setEstado(j2.getCap());
				Jarras[] jarras = { tj1, tj2 };
				NodoJ nodo = new NodoJ(jarras);
				nodo.aux = i;
				sol1(nodo);

			}

			// vaciar j1
			if (j1.getEstado() > 0 && i == 2) {
				tj1.setEstado(0);
				tj2.setEstado(j2.getEstado());
				Jarras[] jarras = { tj1, tj2 };
				NodoJ nodo = new NodoJ(jarras);
				nodo.aux = i;
				sol1(nodo);

			}

			// vaciar j2
			if (j2.getEstado() > 0 && i == 3) {
				tj1.setEstado(j1.getEstado());
				tj2.setEstado(0);
				Jarras[] jarras = { tj1, tj2 };
				NodoJ nodo = new NodoJ(jarras);
				nodo.aux = i;
				sol1(nodo);

			}

			// verter garrafa de j1 a j2
			if ((j1.getEstado() > 0 && j2.getEstado() < j2.getCap()) && i == 4) {
				if (j2.getEstado() + j1.getEstado() <= j2.getCap()) {
					tj2.setEstado(j1.getEstado() + j2.getEstado());
					tj1.setEstado(0);
					Jarras[] jarras = { tj1, tj2 };
					NodoJ nodo = new NodoJ(jarras);
					nodo.aux = i;
					sol1(nodo);

				} else {
					tj1.setEstado(j1.getEstado() - (j2.getCap() - j2.getEstado()));
					tj2.setEstado(j2.getCap());
					Jarras[] jarras = { tj1, tj2 };
					NodoJ nodo = new NodoJ(jarras);
					nodo.aux = i;
					sol1(nodo);

				}

			}

			// verter de j2 a j1
			if ((j2.getEstado() > 0 && j1.getEstado() < j1.getCap() && i == 5)) {
				if (j1.getEstado() + j2.getEstado() <= j1.getCap()) {
					tj1.setEstado(j1.getEstado() + j2.getEstado());
					tj2.setEstado(0);
					Jarras[] jarras = { tj1, tj2 };
					NodoJ nodo = new NodoJ(jarras);
					nodo.aux = i;
					sol1(nodo);

				} else {
					tj2.setEstado(j2.getEstado() - (j1.getCap() - j1.getEstado()));
					tj1.setEstado(j1.getCap());
					Jarras[] jarras = { tj1, tj2 };
					NodoJ nodo = new NodoJ(jarras);
					nodo.aux = i;
					sol1(nodo);

				}

			}

		}

	}
}
