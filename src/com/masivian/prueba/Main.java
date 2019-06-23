package com.masivian.prueba;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Main {

	public static void main(String[] args) {
		//Creo el arbol
		Arbol arbol = new Arbol();
		
		//Creacion de los nodo del arbol
		arbol.insertarNodo(67);
		arbol.insertarNodo(39);
		arbol.insertarNodo(28);
		arbol.insertarNodo(29);
		arbol.insertarNodo(44);
		arbol.insertarNodo(76);
		arbol.insertarNodo(74);
		arbol.insertarNodo(85);
		arbol.insertarNodo(83);
		arbol.insertarNodo(87);
		
		//Nodos para hallar el ancestro en el arbol creado
		Nodo n1 = new Nodo(29);
		Nodo n2 = new Nodo(44);
		
		//Nodos para hallar el ancestro en el arbol creado
		Nodo n3 = new Nodo(44);
		Nodo n4 = new Nodo(85);
		
		//Nodos para hallar el ancestro en el arbol creado
		Nodo n5 = new Nodo(83);
		Nodo n6 = new Nodo(87);
		
		//Objeto para ser representado en un JSON
		JSONObject JSONobj = new JSONObject();
		
		//Objeto para representar el resultado del metodo lowestCommonAncesto en el JSON
		JSONObject JSONancestro1 = new JSONObject();
		JSONObject JSONancestro2 = new JSONObject();
		JSONObject JSONancestro3 = new JSONObject();
		
		//Objeto para representar el arbol en recorrido preOrden en el JSON
		JSONObject JSONarbol = new JSONObject();

		/*
		 * Seccion de codigo que representa el recorrido del arbol, para posteriormente
		 * ser ingresado a un array JSON
		 */
		JSONArray listArbol = new JSONArray();	
		for (int i : arbol.recorridoPreorden()) {
			listArbol.add(new Integer(i));
		}
		JSONarbol.put("NodosPreOrden", listArbol);	
		
		/*
		 *Seccion de codigo que representa el resultado del metodo lowestCommonAncesto
		 *Junto con los nodos que se van a buscar sus ancestros
		 *
		 */
		
		JSONArray listNodosAncestro1 = new JSONArray();
		listNodosAncestro1.add(new Integer(n1.datos));
		listNodosAncestro1.add(new Integer(n2.datos));
		JSONancestro1.put("Nodos", listNodosAncestro1);
		JSONancestro1.put("Padre", new Integer(arbol.lowestCommonAncesto(arbol, n1, n2)));
		
		JSONArray listNodosAncestro2 = new JSONArray();
		listNodosAncestro2.add(new Integer(n3.datos));
		listNodosAncestro2.add(new Integer(n4.datos));
		JSONancestro2.put("Nodos", listNodosAncestro1);
		JSONancestro2.put("Padre", new Integer(arbol.lowestCommonAncesto(arbol, n3, n4)));
		
		JSONArray listNodosAncestro3 = new JSONArray();
		listNodosAncestro3.add(new Integer(n5.datos));
		listNodosAncestro3.add(new Integer(n6.datos));
		JSONancestro3.put("Nodos", listNodosAncestro3);
		JSONancestro3.put("Padre", new Integer(arbol.lowestCommonAncesto(arbol, n5, n6)));
		
		/*
		 * Estructura con la cual va a quedar el archivo JSON a generar
		 * 
		 */
		JSONArray listAncestro = new JSONArray();
		listAncestro.add(JSONancestro1);
		listAncestro.add(JSONancestro2);
		listAncestro.add(JSONancestro3);
		JSONobj.put("Ancestro", listAncestro);
		JSONobj.put("Arbol", JSONarbol);
		
		try {
			//Linea que representa donde se va a crear el archivo JSON (ejemplo:c:\\Users\\santiagoPc\\eclipse-workspace\\arbol.json) 
			FileWriter file = new FileWriter("PATH"); //Editar PATH, con la ruta donde se desea crear el archivo JSON
			file.write(JSONobj.toJSONString());
			file.flush();
			file.close();
			JOptionPane.showMessageDialog(null, "Generación exitosa", "Generación JSON", JOptionPane.INFORMATION_MESSAGE);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Puede ser que la ruta no este bien especificada", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		

	}

}
