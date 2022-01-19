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

public class MAIN {
    
    public static void main(String[] args) {
        boolean terminar= false;
        int opcion=0;
        Vista v = new Vista();
        RadioGrupo6 r= new RadioGrupo6();
        boolean encendido= false;
        v.bienvenida();
        while(!terminar){
            if (encendido){
                opcion=v.MenuPrincipalOn();
                switch(opcion){
                    case 1:
                    //cambiar frecuencia (AM o FM)
                    r.switchAMFM();
                    break;
                    case 2:
                    // Subir emisora
                    r.nextStation(true);
                    break;
                    case 3:
                    // bajar emisora 
                    r.prevStation(true);
                    break;
                    case 4:
                    //guardar emisora
                    double m=0;
                
                    break;
                    case 5:
                    // obtener emisora
                    break;
                    default:
                    // apagar
                    encendido=false;
                    break;
                }
            }
            else{
                int decision=0;
                decision= v.MenuPrincipalOff();
                if(decision==1){
                    encendido=true;
                    v.RadioEncendido();
                }
            }

        }
    }
}

//--------------------------------------------------------------------------------------------------------------------------------------------------

class Vista {
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

    private int solicitar_int(String s, int inferior, int superior){
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
    private double solicitar_double(String s, double inferior, double superior){
        inferior -= 1;
        superior += 1;
        double entero = 0;
        boolean continuar = true;
            while(continuar){
                try{
                System.out.print(s);
                this.scan = new Scanner(System.in);
                double numero = scan.nextDouble();
                if((numero>inferior)&&(numero<superior)){
                    entero = numero;
                    System.out.println("---------------------------------------------------------------------------------------------------------------------");
                    continuar = false; 
                }
                else{
                    System.out.println("\t Error: debe de ingresar un decimal valido.");   
                    System.out.println();              
                }
                }
                catch(Exception e){
                    System.out.println("\t Error: debe de ingresar un decimal valido.");
                    System.out.println();
                }
            }
        
        return entero;
    }

    public int MenuPrincipalOn(){
        int desicion = 0;
        System.out.println("--------------------------------------------------------");
        System.out.println("-------------------- Acciones del Radio ------------------");
        System.out.println("--------------------------------------------------------");
        System.out.println("Que accion deseas realizar?");
        System.out.println("1. Cambiar Frecuencia (AM/FM)");
        System.out.println("2. Subir de emisora.");
        System.out.println("3. Bajar de emisora.");
        System.out.println("4. Guardar emisora.");
        System.out.println("5. Obtener emisora guardada.");
        System.out.println("6. Apagar Radio.");
        String s = " Ingrese su desicion: ";
        desicion = solicitar_int(s, 1, 6);
        return desicion;
}
public int MenuPrincipalOff(){
    int desicion = 0;
    System.out.println("--------------------------------------------------------");
    System.out.println("-------------------- ¿Desea encender el radio?------------------");
    System.out.println("--------------------------------------------------------");
    System.out.println("1. Si");
    System.out.println("2. No");
    String s = " Ingrese su desicion: ";
    desicion = solicitar_int(s, 1, 2);
    return desicion;
}
public void RadioEncendido(){
    System.out.println("El radio está encendido");
}
public double RecibirEmisora(){
    System.out.println();
    String s= "Ingrese el número de emisora: ";
    double n=0;
    n= solicitar_double(s, 0, 1000);
    return n;
}
public int RecibirPosicion(){
    System.out.println();
    String s= "Ingrese el número en el que desea guardar la emisora: ";
    int n=0;
    n= solicitar_int(s, 1, 12);
    return n;
}



}
