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

/**
 * Controller of the program.
 */

public class MAIN {
    
    public static void main(String[] args) {
        boolean terminar= false;
        int opcion=0;
        Vista v = new Vista();

        Radio r = new RadioGrupo6();
        
        //GRUPO 1
        //Radio r = new RadioGrupo1();

        //GRUPO 3
        // Radio r = new RadioController();

        //GRUPO 8
        // Radio r = new RadioG8();

        boolean encendido= false;
        v.bienvenida();
        while(!terminar){
            if (encendido){

                double actual_station = r.getStation();
                boolean actual_frequency = r.getFrequency();

                v.mostrar_radio(actual_station, actual_frequency);
                opcion = v.MenuPrincipalOn();
                switch(opcion){
                    case 1:
                        //cambiar frecuencia (AM o FM)
                        r.switchAMFM();

                        break;

                    case 2:
                        // Subir emisora
                        r.nextStation(r.getFrequency());
                        break;

                    case 3:
                        // bajar emisora 
                        r.prevStation(r.getFrequency());
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

    /**
     * Metodo para darle una bienvenida al usuario.
     */
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

    /**
     * Metodo privado para solicitar un entero al usuario.
     * @return int
     * @param String,int,int
     */
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

    /**
     * Metodo privado para solicitar un double al usuario.
     * @return double
     * @param String,double,double
     */
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

    /**
     * Metodo de menu principal cuando el radio este encendido.
     * retorna un entero para poder utilizarlo en el switch del controlador.
     * @return int
     */
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

    /**
     * Metodo de menu principal cuando el radio este apagado.
     * Retorna un int para saber cuando el usuario desee encender la radio.
     * @return int
     */
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

    /**
     * Metodo para mostrar informacion de la radio cuando este encendida.
     * @param double,boolean
     */
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

    /**
     * Metodo de vista para el usuario.
     * Unicamente imprime un mensaje.
     */
    public void RadioEncendido(){
        System.out.println("El radio está encendido");
    }

    /**
     * Metodo para recibir una emisora de parte del usuario.
     * @return double
     */
    public double RecibirEmisora(){
        System.out.println();
        String s= "Ingrese el número de emisora: ";
        double n=0;
        n= solicitar_double(s, 0, 1000);
        return n;
    }

    /**
     * Metodo para recibir una posicion de emisora del usuario.
     * @return int
     */
    public int RecibirPosicion(){
        System.out.println();
        String s= "Ingrese el número en el que desea guardar la emisora: ";
        int n=0;
        n= solicitar_int(s, 1, 12);
        return n;
    }

    /**
     * Metodo para obtener una emisora en forma de double de parte del usuario.
     * @return double
     */
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

    /**
     * Metodo para obtener del usuario la posicion de la emisora que desea obtener.
     * @return int
     */
    public int obtener_posicion_emisora(){
        System.out.println();
        System.out.println();
        String s = "Ingrese la posicion en la que desea guardar la emisora: ";
        int posicion = solicitar_int(s, 1, 12);
        System.out.println();
        return posicion;
    }

    /**
     * Metodo de vista para el usuario.
     * Unicamente imprime un texto informativo.
     */
    public void estacion_guardada(){
        System.out.println();
        System.out.println("\nSu estacion ha sido guardad exitosamente...");
        System.out.println();
        System.out.println("\nRecuerde no perder la posicion en la que guardo su emisora.");
        System.out.println();
    }

    /**
     * Metodo para obtener una posicion de emisora guardada por el usuario
     * @return int
     */
    public int obtener_posicion_emisora_guardada(){
        System.out.println();
        System.out.println();
        String s = "Ingrese la posicion en la que guardo su genial emisora: ";
        int posicion = solicitar_int(s, 1, 12);
        System.out.println();
        return posicion;
    }

    /**
     * Metodo de vista para el usuario.
     * imprime informacion de la emisora guardada.
     * @param double
     */
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
