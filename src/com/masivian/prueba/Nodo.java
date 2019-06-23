package com.masivian.prueba;

public class Nodo {
	Nodo nodoIzq;
	Nodo nodoDer;
	int datos;

	public Nodo(int datosNodo) {
		this.datos = datosNodo;
		nodoIzq = nodoDer = null;
	}

	/**
	 * Metodo para ingresar un nodo hoja al arbol ya existente
	 * @param valorInsertar
	 */
	public void insertar(int valorInsertar) {
		//Verifico si el dato entrante es menor que la raiz
		if (valorInsertar <= datos) {
			//De ser cierto, verifico si exites una hoja a la izquierda
			if (nodoIzq == null) {
				//De ser verdadero lo ingreso como una nueva Hoja izquierda
				nodoIzq = new Nodo(valorInsertar);
			} else {
				//De ser falso, envio el valor de la Hoja izquierda existente, para volver a crear otra rama del arbol
				nodoIzq.insertar(valorInsertar);
			}
		}//Verifico si el dato entrante es mayor que la raiz
		else if (valorInsertar > datos) {
			//De ser cierto, verifico si exites una hoja a la derecha
			if (nodoDer == null) {
				//De ser verdadero lo ingreso como una nueva Hoja derecha
				nodoDer = new Nodo(valorInsertar);
			} else {
				//De ser falso, envio el valor de la Hoja derecha existente, para volver a crear otra rama del arbol
				nodoDer.insertar(valorInsertar);
			}
		}
	}
}
