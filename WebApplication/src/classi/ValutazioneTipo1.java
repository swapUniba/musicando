package classi;

import java.util.ArrayList;

//valutazione di tipo normale/pmi in termini di trasparenza, persuasione, coinvolgimento, fiducia
public class ValutazioneTipo1 {
    public String id;			    // timestamp
    public String configurazione;   // configurazione = unigrammi/bigrammi/unibigrammi
    public String tecnica;			// normale, pmi
    public int item;			    // id item
    public int numeroContesti;	    // numero contesti scelti (1,2,3)
    public ArrayList<Integer> listaContesti;	// lista contesti scelti
    
    public int trasparenza, persuasione, coinvolgimento, fiducia;
    
    ////////////////////////////////////COSTRUTTORI///////////////////////////////////////////////////
    public ValutazioneTipo1(String id, String configurazione, String tecnica, int locale, int numeroContesti, int trasparenza, int persuasione, int coinvolgimento, int fiducia, ArrayList<Integer> listaContesti) {
        this.id = id;
        this.configurazione = configurazione;
        this.tecnica = tecnica;
        this.numeroContesti = numeroContesti;
        this.trasparenza = trasparenza;
        this.persuasione = persuasione;
        this.coinvolgimento = coinvolgimento;
        this.fiducia = fiducia;
        this.listaContesti = listaContesti;
    }
    public ValutazioneTipo1() {}


    /////////////////////////////GETTER-SETTER/////////////////////////////////
    public String getId() { return id;}
    public void setId(String id) { this.id = id;}

    public String getConfigurazione() { return configurazione;}
    public void setConfigurazione(String configurazione) { this.configurazione = configurazione;}

    public String getTecnica() { return tecnica;}
    public void setTecnica(String tecnica) { this.tecnica = tecnica;}

    public int getItem() {return item;}
    public void setItem(int item) { this.item = item; }

    public int getNumeroContesti() { return numeroContesti;}
    public void setNumeroContesti(int numeroContesti) { this.numeroContesti = numeroContesti;}
    
    public int getTrasparenza() { return trasparenza;}
    public void setTrasparenza(int trasparenza) { this.trasparenza = trasparenza;}

    public int getPersuasione() { return persuasione;}
    public void setPersuasione(int persuasione) { this.persuasione = persuasione;}

    public int getCoinvolgimento() {return coinvolgimento; }
    public void setCoinvolgimento(int coinvolgimento) { this.coinvolgimento = coinvolgimento; }

    public int getFiducia() { return fiducia; }
    public void setFiducia(int fiducia) { this.fiducia = fiducia;}

    public ArrayList<Integer> getListaContesti() { return listaContesti;}
    public void setListaContesti(ArrayList<Integer> listaContesti) { this.listaContesti = listaContesti;}

}