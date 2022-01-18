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
        v.bienvenida();
        while(!terminar){
            opcion=v.MenuPrincipal();
            switch(opcion){
                case 1:
                //prender radio
                break;
                case 2:
                //cambiar frecuencia (AM o FM)
                break;
                case 3:
                // Subir emisora
                break;
                case 4:
                // bajar emisora 
                break;
                case 5:
                //guardar emisora
                break;
                case 6:
                // obtener emisora
                break;
                default:
                // apagar
                break;
            }

        }
    }
}
