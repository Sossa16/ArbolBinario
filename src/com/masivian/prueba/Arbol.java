package com.masivian.prueba;

import java.awt.List;
import java.util.ArrayList;

public class Arbol {

	private Nodo raiz;

	public Arbol() {
		raiz = null;
	}

	/**
	 * Metodo para insertar un nodo a un arbol
	 * @param valorInsertar
	 */
	public void insertarNodo(int valorInsertar) {
		//Verifico si exites la raiz del arborl
		if (raiz == null) {
			//Si la condicion es afirmativa (NO existe) el valor ingresado pasa a ser la raiz del arbol
			raiz = new Nodo(valorInsertar);
		} else {
			//De existir una raiz, se envia a otro metodo para que pase a ser una hoja del arbol
			raiz.insertar(valorInsertar);
		}
	}
	
	
	/**
	 * Metodo intermediario para hallar el ancestro entre dos nodos
	 * @param arbol
	 * @param n1
	 * @param n2
	 * @return el ancestro entre dos nodos
	 */
	public int lowestCommonAncesto(Arbol arbol, Nodo n1, Nodo n2 ) {
		
		return buscarAncestroCercano(arbol.raiz, n1, n2);
	}
	
	/**
	 * Metodo utlizado para hallar el ancestro entre dos nodos
	 * @param raiz
	 * @param n1
	 * @param n2
	 * @return el ancestro entre dos nodos
	 */
	private int buscarAncestroCercano(Nodo raiz, Nodo n1, Nodo n2) {
		//verifico que el arbol (o sub-arbol) no este vacio
		while(raiz!= null) {
			//De ser verdadero, verfico si los nodos se encuentran en el sub-arbol Izquierdo
			if(n1.datos < raiz.datos && n2.datos < raiz.datos) {
				//retorno el metodo para que siga buscando el ancestro de los nodos en el sub-arbol izquierdo
				return buscarAncestroCercano(raiz.nodoIzq, n1, n2);
			}//De ser verdadero, verfico si los nodos se encuentran en el sub-arbol derecho
			else if(n1.datos > raiz.datos && n2.datos > raiz.datos) {
				//retorno el metodo para que siga buscando el ancestro de los nodos en el sub-arbol derecho
				return buscarAncestroCercano(raiz.nodoDer, n1, n2);
			}
			//Si no cumple ninguna de las condiciones, retorno la raiz que es el ancestro de los nodos
			return raiz.datos;
		}
		//De estar el arbol vacio, se terna esto;
		return 000;
	}

	/**
	 * Metodo intermediario para devolver el arbol en un recorrido preOrden
	 * @return arreglo con los nodos pertenecientes al arbol en un recorrido preOrden
	 */
	public ArrayList<Integer> recorridoPreorden() {
		ArrayList<Integer> arbol = new ArrayList<Integer>();
		return ayudantePreorden(raiz, arbol);
	}

	/**
	 * Metodo para hacer el recorrido del arbol en preOrden
	 * @param nodo
	 * @param arbol
	 * @return arreglo con los nodos pertenecientes al arbol en un recorrido preOrden
	 */
	private ArrayList<Integer> ayudantePreorden(Nodo nodo, ArrayList<Integer> arbol) {
		//Verifico que el arbol no este vacio
		if (nodo == null) {
			//De ser asi, se retorna una lista nula 
			return null;
		} else {
			//De no ser asi, agrego el nodo a la lista
			arbol.add(nodo.datos);
			//Pregunto si hay el arbol tiene mas ramas
			if (nodo.nodoIzq == null && nodo.nodoDer == null) {
				//De ser asi, de vuelvo la lista 
				return arbol;
			}else {
				//De no ser asi, verifico si hay un sub-arbol izquierdo
				if(nodo.nodoIzq != null) {
					//Invoco de nuevo el metodo para agregar los nodos del sub-arbol izquierdo
					ayudantePreorden(nodo.nodoIzq, arbol);
				}//De no ser asi, verifico si hay un sub-arbol derecho
				else if(nodo.nodoDer != null) {
					//Invoco de nuevo el metodo para agregar los nodos del sub-arbol derecho
					ayudantePreorden(nodo.nodoDer, arbol);
				}
				
			}
		}
		return arbol;
	}

}
