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

/**
 * Implements all the methods that the Radio should have.
 */

public class RadioGrupo6 implements Radio{
    private boolean on;
    private double emisora_am; //530 -> 1610
    private double emisora_fm; //87.9 -> 107.9
    private boolean frequency; //true = AM
    private double[] emisoras_guardadas = new double[12];

    /**
     * Constructor
     */
    public RadioGrupo6(){
        this.on = false;
        this.emisora_am = 530;
        this.emisora_fm = 87.9;
        this.frequency = true; //AM
        for(int k = 0; k<12 ;k++){
            this.emisoras_guardadas[k] = 0;
        }

    }

    /**
     * Get the current state of the radio.
     * @return boolean indicating if the Radio is on.
     */
    public boolean isOn(){
        return this.on;
    }

    /**
     * Switch the on state of the Radio.
     */
    public void turnOnOff(){
        if(this.on){
            this.on = false;
        }
        else{
            this.on = true;
        }
    }

    /**
     * Move forward into the station dial.
     * @param frequency boolean indicating if the frequency is AM or FM. true = AM
     */
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

    /**
     * Move backwards into the station dial.
     * @param frequency boolean indicating if the frequency is AM or FM. true = AM.
     */
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

    /**
     * Get the current station selected.
     * @return double indicating the current station selected.
     */
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

    /**
     * Save a station on the favorites array.
     * @param position index indicating where to store the station.
     * @param station double indicating the station.
     */
    public void saveStation(int position, double station){
        if((position>=0)&&(position<12)){
            this.emisoras_guardadas[position] = station;
        }
    }

    /**
     * Get a saved station on the favorites array
     * @param position index indicating which station to pick.
     */
    public double getSavedStation(int position){
        return this.emisoras_guardadas[position];
    }

    /**
     * Get the current frequency. And also save it as the current station.
     * @return boolean indicating if it is AM or FM. true = AM.
     */
    public boolean getFrequency(){
        return this.frequency;
    }

    /**
     * Switch the frequency selected.
     */
    public void switchAMFM(){
        if(this.frequency){
            this.frequency = false;
        }
        else{
            this.frequency = true;
        }
    }
}
