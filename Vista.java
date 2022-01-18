//Universidad del Valle de Guatemala
//Algoritmos y Estructura de Datos
//Catedrático Douglas Barrios
//Primer Semestre 2022
//José Daniel Gómez Cabrera 21429
//Carlos Daniel Jashua Martinez Lopez 
//Sofía Lam Méndez
//Grupo 6
//Sección 41
//Actividad: Hoja de Trabajo 1

import java.util.*;

public class Vista {
    Scanner scan = new Scanner(System.in);

    public void bienvenida(){
        System.out.println();
        System.out.println();
        System.out.println("------------ Bienvenido al radio UVG ------------");
        System.out.println();
        System.out.println("------------ BIENVENID@ ------------");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.println("- Esto es un simulador de radios para vehiculos!");
        System.out.println("- Podra probar el radio e intercambiarlo con diferentes autos...");
        System.out.println("- Estamos basados en la definición de Abstract Data Types!!!");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    public int solicitar_int(String s, int inferior, int superior){
        inferior -= 1;
        superior += 1;
        int entero = 0;
        boolean continuar = true;
            while(continuar){
                try{
                System.out.print(s);
                this.scan = new Scanner(System.in);
                int numero = scan.nextInt();
                if((numero>inferior)&&(numero<superior)){
                    entero = numero;
                    System.out.println("---------------------------------------------------------------------------------------------------------------------");
                    continuar = false; 
                }
                else{
                    System.out.println("\t Error: debe de ingresar un entero valido.");   
                    System.out.println();              
                }
                }
                catch(Exception e){
                    System.out.println("\t Error: debe de ingresar un entero valido.");
                    System.out.println();
                }
            }
        
        return entero;
    }

    public int MenuPrincipal(){
        int desicion = 0;
        System.out.println("--------------------------------------------------------");
        System.out.println("-------------------- Acciones del Radio ------------------");
        System.out.println("--------------------------------------------------------");
        System.out.println("Que accion deseas realizar?");
        System.out.println("1. Prender Radio");
        System.out.println("2. Cambiar Frecuencia (AM/FM)");
        System.out.println("3. Subir de emisora.");
        System.out.println("4. Bajar de emisora.");
        System.out.println("5. Guardar emisora.");
        System.out.println("6. Obtener emisora guardada.");
        System.out.println("7. Apagar Radio.");
        String s = " Ingrese su desicion: ";
        desicion = solicitar_int(s, 1, 4);
        return desicion;
}
}