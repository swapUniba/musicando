package classi;

import java.util.ArrayList;

//confronto fra normale/pmi e baseline 2
public class ValutazioneTipo3 extends ValutazioneTipo2 {


    public ValutazioneTipo3(String id, String configurazione, String tecnica, int locale, int numeroContesti, int trasparenza, int persuasione, int coinvolgimento, int fiducia, ArrayList<Integer> listaContesti) {
        super(id, configurazione, tecnica, locale, numeroContesti, trasparenza, persuasione, coinvolgimento, fiducia, listaContesti);
    }

    public ValutazioneTipo3(){}
    
    ////////////////////////////GETTER SETTER/////////////////
    //public int getPreferenzaPrecedente() { return preferenzaPrecedente; }
    //public void setPreferenzaPrecedente(int preferenzaPrecedente) { this.preferenzaPrecedente = preferenzaPrecedente; }
}