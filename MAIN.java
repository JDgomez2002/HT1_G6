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
