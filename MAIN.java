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

import java.text.DecimalFormat;
import java.util.*;

public class MAIN {
    
    public static void main(String[] args) {
        boolean terminar= false;
        int opcion=0;
        Vista v = new Vista();

        RadioGrupo6 r = new RadioGrupo6();
        
        //GRUPO 1
        //RadioGrupo1 r = new RadioGrupo1();

        //GRUPO 3
        // RadioController r = new RadioController();

        //GRUPO 8
        // RadioG8 r = new RadioG8();

        boolean encendido= false;
        v.bienvenida();
        while(!terminar){
            if (encendido){

                double actual_station = r.getStation();
                boolean actual_frequency = r.getFrequency();

                v.mostrar_radio(actual_station, actual_frequency);
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
                        double m = 0; //emisora
                        int i = 0;//posicion

                        m = v.obtener_emisora();
                        i = v.obtener_posicion_emisora();

                        r.saveStation(i, m);

                        v.estacion_guardada();
                
                        break;

                    case 5:
                        // obtener emisora

                        int l = 0;
                        l = v.obtener_posicion_emisora_guardada();

                        double emisora_guardada = r.getSavedStation(l);

                        v.emisora_guardada(emisora_guardada);

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
//VISTA PARA LA INTERACCION CON EL USUARIO
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
        System.out.println("-------------------- Acciones del Radio ----------------");
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
        System.out.println("-------------- ¿Desea encender el radio? ---------------");
        System.out.println("--------------------------------------------------------");
        System.out.println("1. Si");
        System.out.println("2. No");
        String s = " Ingrese su desicion: ";
        desicion = solicitar_int(s, 1, 2);
        return desicion;
    }

    public void mostrar_radio(double station, boolean frequency){
        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println("-------------- Información de radio ---------------");
        System.out.println("---------------------------------------------------");
        if(frequency){
            System.out.println("Frecuencia: AM");
        }
        else{
            System.out.println("Frecuencia: FM");
        }
        DecimalFormat df = new DecimalFormat("#.00");

        System.out.println("- Estacion: "+df.format(station));
        System.out.println();
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

    public double obtener_emisora(){
        System.out.println();
        System.out.println();
        System.out.println("- Ingrese la emisora que desea guardar.");
        System.out.println("NOTA: La emisora debe de ser con coma. (Ej: 84,64)");
        String s = "Ingrese su emisora con coma: ";
        double emisora = solicitar_double(s, 0, 1000);
        System.out.println();
        return emisora;
    }

    public int obtener_posicion_emisora(){
        System.out.println();
        System.out.println();
        String s = "Ingrese la posicion en la que desea guardar la emisora: ";
        int posicion = solicitar_int(s, 1, 12);
        System.out.println();
        return posicion;
    }

    public void estacion_guardada(){
        System.out.println();
        System.out.println("\nSu estacion ha sido guardad exitosamente...");
        System.out.println();
        System.out.println("\nRecuerde no perder la posicion en la que guardo su emisora.");
        System.out.println();
    }

    public int obtener_posicion_emisora_guardada(){
        System.out.println();
        System.out.println();
        String s = "Ingrese la posicion en la que guardo su genial emisora: ";
        int posicion = solicitar_int(s, 1, 12);
        System.out.println();
        return posicion;
    }

    public void emisora_guardada(double e){
        if(!(e==0)){
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println();
            System.out.println("\nSu emisora guardada es la "+df.format(e));
            System.out.println();
        }
        else{
            System.out.println();
            System.out.println("\nLo sentimos, No hay una emisora guardada en esa posicion...");
            System.out.println();
        }
    }
}
