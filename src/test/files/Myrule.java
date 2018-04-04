class MyRule {
	/*
	 * Clase que contine codigo java como datos de entrada, es decir,
	 * este es el código a analizar
	 */
	MyRule (MyRule mc) {} //constructor
	 
	  int foo1 () {return 0; } // método sin parametros
	  void foo2 (int value) {} // metodo que no devuelve nada
	  int foo3 (int value) {return 0; } //funcion que retorna un // Noncompliant
	  									//valor del mismo tipo
	  									//que el parametro recibido
	  Object  foo4(int value) { return null; } // funcion que
	  									//retorna un valor de tipo distinto al recibido
	  									// por parametro
	  MyRule foo5 (MyRule value) {return null; } // funcion que retorna un valor // Noncompliant
	  					//de tipo distinto al recibido por parámetro pero no son tipos
	  					//primitivos
	 
	  int foo6 (int value, String name) {return 0; } 
	  int foo7 (int ... values) {return 0;} 
}