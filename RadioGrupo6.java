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

public class RadioGrupo6 implements Radio{
    private boolean on;
    private double emisora_am; //530 -> 1610
    private double emisora_fm; //87.9 -> 107.9
    private boolean frequency; //true = AM
    private double[] emisoras_guardadas = new double[12];


    public RadioGrupo6(){
        this.on = false;
        this.emisora_am = 530;
        this.emisora_fm = 87.9;
        this.frequency = true; //AM
        for(int k = 0; k<12 ;k++){
            this.emisoras_guardadas[k] = 0;
        }

    }

    public boolean isOn(){
        return this.on;
    }

    public void turnOnOff(){
        if(this.on){
            this.on = false;
        }
        else{
            this.on = true;
        }
    }

    public void nextStation(boolean frequency){
        if(this.frequency){ //AM
            if(this.emisora_am>=1610){
                this.emisora_am = 530;
            }
            else{
                this.emisora_am += 10;
            }
        }
        else{ //FM
            if(this.emisora_fm>=107.9){
                this.emisora_fm = 87.9;
            }
            else{
                this.emisora_fm += 0.2;
            }
        }
    }

    public void prevStation(boolean frequency){
        if(this.frequency){ //AM
            if(this.emisora_am<=530){
                this.emisora_am = 1610;
            }
            else{
                this.emisora_am -= 10;
            }
        }
        else{ //FM
            if(this.emisora_fm<=87.9){
                this.emisora_fm = 107.9;
            }
            else{
                this.emisora_fm -= 0.2;
            }
        }
    }  

    public double getStation(){
        double actual_frequency = 0;
        if(this.frequency){ //AM
            actual_frequency = this.emisora_am;
        }
        else{ //FM
            actual_frequency = this.emisora_fm;
        }
        return actual_frequency;
    }

    public void saveStation(int position, double station){
        if((position>=0)&&(position<12)){
            this.emisoras_guardadas[position] = station;
        }
    }

    public double getSavedStation(int position){
        return this.emisoras_guardadas[position];
    }

    public boolean getFrequency(){
        return this.frequency;
    }

    public void switchAMFM(){
        if(this.frequency){
            this.frequency = false;
        }
        else{
            this.frequency = true;
        }
    }
}
