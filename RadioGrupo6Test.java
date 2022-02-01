// import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.Test;

// class RadioGrupo6Test {
// 	/*
// 	@Test
// 	void testTurnOnOff() {
// 		boolean esperado = true; // creando variables
// 		boolean resultado = true; //creando variables
		
		
				
// 	}*/
	

// 	@Test
// 	void testNextStation() {
// 		RadioGrupo6 rad = new RadioGrupo6(); // creo nuevo objeto

// 		double esperado = 0; //creando variables
// 		double resultado = 0; //creando variables
		
// 		double emisora = 0;
		
		
// 		double emisoraAct = rad.getStation(); //emisora actual
		
// 		if (rad.getFrequency()) { //radio en AM
// 			if (emisoraAct < 1610) {
// 				emisora = rad.getStation();
				
// 				rad.nextStation(rad.getFrequency()); // avanzo de estacion
				
// 				esperado = emisora + 10; // valor esperado
// 				resultado = rad.getStation(); // valor resultante
// 			}else {
// 				rad.nextStation(rad.getFrequency()); // avanzo de estacion
// 				esperado = 530; // valor esperado
// 				resultado = rad.getStation(); //valor resultante
// 			}
			
// 		}else {// radio en FM
// 			if (emisoraAct < 107.9) {
// 				emisora = rad.getStation();
				
// 				rad.nextStation(rad.getFrequency()); // avanzo de estacion
				
// 				esperado = emisora + 0.2; //valor esperado
// 				resultado = rad.getStation(); //valor resultante
// 			}else {
// 				rad.nextStation(rad.getFrequency()); // avanzo de estacion
// 				esperado = 87.9; // valor esperado
// 				resultado = rad.getStation(); // valor resultante
// 			}
// 		}
// 		assertEquals(esperado, resultado);// comprobaci�n de las pruebas, fallos
		
// 	}
	
	

// 	@Test
// 	void testPrevStation() {
// 		RadioGrupo6 rad = new RadioGrupo6(); // creo nuevo objeto

// 		double esperado = 0; //creando variables
// 		double resultado = 0; //creando variables
		
// 		double emisora = 0;
		
		
// 		double emisoraAct = rad.getStation(); //emisora actual
		
// 		if (rad.getFrequency()) { //radio en AM
// 			if (emisoraAct > 530) {
// 				emisora = rad.getStation();
				
// 				rad.prevStation(rad.getFrequency());; // bajo de estacion
				
// 				esperado = emisora -10; // valor esperado
// 				resultado = rad.getStation(); // valor resultante
// 			}else {
// 				rad.prevStation(rad.getFrequency());; // bajo de estacion
// 				esperado = 1610; // valor esperado
// 				resultado = rad.getStation(); //valor resultante
// 			}
			
// 		}else {// radio en FM
// 			if (emisoraAct  > 87.9) {
// 				emisora = rad.getStation();
				
// 				rad.prevStation(rad.getFrequency());; // bajo de estacion
				
// 				esperado = emisora - 0.2; //valor esperado
// 				resultado = rad.getStation(); //valor resultante
// 			}else {
// 				rad.prevStation(rad.getFrequency());; // bajo de estacion
// 				esperado = 107.9; // valor esperado
// 				resultado = rad.getStation(); // valor resultante
// 			}
// 		}
// 		assertEquals(esperado, resultado);// comprobaci�n de las pruebas, fallos
// 	}
// /*
// 	@Test
// 	void testSaveStation() {
// 		double[] emisoras_guardadas = new double[12];
// 		RadioGrupo6 rad = new RadioGrupo6();
// 		rad.saveStation(10, 530);
		
// 	}*/

// 	@Test
// 	void testSwitchAMFM() {
// 		RadioGrupo6 rad = new RadioGrupo6(); // creo nuevo objeto
		
// 		boolean resultado = true; //creando variables
// 		boolean esperado = true; // creando variables
		
		
// 		if (rad.getFrequency()) { // si la emisora esta en AM (true)
// 			rad.switchAMFM(); //cambio de frecuencia
// 			esperado = false; //El resultado esperado es FM
// 		}
// 		else { // si la emisora esta en FM (false)
// 			rad.switchAMFM();
// 			esperado = true; //El resultado esperado es AM
// 		}
		
// 		resultado = rad.getFrequency(); // Devuelve si estoy en AM o FM
// 		assertEquals(esperado, resultado); // Compruebo que lo esperado y el resultado coincidan
		
	
// 	}

// }
