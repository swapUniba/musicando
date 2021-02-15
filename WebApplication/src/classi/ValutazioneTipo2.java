package classi;

import java.util.ArrayList;

//confronto fra normale/pmi e baseline 1
public class ValutazioneTipo2 extends ValutazioneTipo1 {

    protected int preferenza0;      //preferenza tra framework (1), baseline (2), indifferente (0)
    


    public ValutazioneTipo2(int preferenza0) {
        this.preferenza0 = preferenza0;
    }

    public ValutazioneTipo2(String id, String configurazione, String tecnica, int locale, int numeroContesti, int trasparenza, int persuasione, int coinvolgimento, int fiducia, ArrayList<Integer> listaContesti) {
        super(id, configurazione, tecnica, locale, numeroContesti, trasparenza, persuasione, coinvolgimento, fiducia, listaContesti);
    }

    public ValutazioneTipo2(){}
    
    ////////////////////////////GETTER SETTER/////////////////
    public int getPreferenza0() {return preferenza0;}
    public void setPreferenza0(int preferenza0) { this.preferenza0 = preferenza0;}
}