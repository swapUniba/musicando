package report;

import classi.ValutazioneTipo1;
import frontend.Configurazione;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/*
/////////////////////////////CONTATORI///////////////////////////
10) contatori configurazioni elaborate;
11) contatori numero di contesti selezionati dagli utenti
12) contatori film suggeriti;
*/
public class Contatori {
//////////////////////////////////////////////CONTATORI///////////////////////////////////////////////// 
	//10) contatori numero valutazoni per UNIGRAMMI, BIGRAMMI, UNIBI
	public static HashMap<String, Integer> contatoriConfigurazioni(){

		HashMap<String, Integer> contatori = new HashMap<String, Integer>();
		contatori.put("unigrammi",0);	//INIZIALIZZAZ
		contatori.put("bigrammi", 0);
		contatori.put("unibigrammi",0);
		
		for (ValutazioneTipo1 v1 : Report.valutazioni1){

			contatori.put(v1.configurazione, contatori.get(v1.configurazione) + 1);
		}

		return contatori;
	}
	
	//10.2) contatori numero valutazoni per PMI, NORMALE
	public static HashMap<String, Integer> contatoriTenica(){
		HashMap<String, Integer> contatori2 = new HashMap<String, Integer>();
		contatori2.put("pmi",0);	//INIZIALIZZAZ
		contatori2.put("normale", 0);
		
		for (ValutazioneTipo1 v1 : Report.valutazioni1){//CENTROIDE + FRASI SINGOLE
			contatori2.put(v1.tecnica, contatori2.get(v1.tecnica) + 1);
		}
		return contatori2;
	}

	public static HashMap<String, Integer> contatoriCombinazioni(){

		HashMap<String, Integer> c = new HashMap<>();

		int nu=0, nb=0, nub=0, pu=0, pb=0, pub=0;



		for (ValutazioneTipo1 v1 : Report.valutazioni1){

			if (v1.getTecnica().equals("normale")){
				if (v1.getConfigurazione().equals("unigrammi")){
					nu++;
				} else if (v1.getConfigurazione().equals("bigrammi")){
					nb++;
				} else {
					nub++;
				}
			} else {
				if (v1.getConfigurazione().equals("unigrammi")){
					pu++;
				} else if (v1.getConfigurazione().equals("bigrammi")){
					pb++;
				} else {
					pub++;
				}
			}

		}

		c.put("nu", nu);
		c.put("nb", nb);
		c.put("nub", nub);
		c.put("pu", pu);
		c.put("pb", pb);
		c.put("pub", pub);

		return c;

	}
	
	//11) contatori NUMERO CONTESTI TOTALI elaborati dagli utenti.
	public static HashMap<Integer, Integer> contatoriNumeroContesti(){
		HashMap<Integer, Integer> contatori = new HashMap<Integer, Integer>();
		contatori.put(1,0);	//INIZIALIZZAZ
		contatori.put(2, 0);
		contatori.put(3,0);

		for (ValutazioneTipo1 v1 : Report.valutazioni1){	//per ogni rigo sommo quanti contesti conto
			contatori.put(v1.getNumeroContesti(), contatori.get(v1.getNumeroContesti()) + 1);
		}
		return contatori;
	}


	//12) contatori NUMERO TOTALE FILM SUGGERITI suggeriti;
	public static HashMap<Integer, Integer> contatoriLocaliSuggeriti(){
		HashMap<Integer, Integer> contatoriLocali = new HashMap<Integer, Integer>();
		
		for (ValutazioneTipo1 v1 : Report.valutazioni1){
			Integer locale = v1.getItem();
			if (contatoriLocali.containsKey(locale))	//se presente sommo 1
				contatoriLocali.put(locale, contatoriLocali.get(locale) + 1);
			else 				//altrimenti aggiungo e conto 1
				contatoriLocali.put(locale, 1);	// prima occorrenza
		}
		return contatoriLocali;
	}
	
	//PER AGGIUNGERE IL TITOLO DEL FILM
    public static String getTitoloLocale(int locale) throws FileNotFoundException {
    	Scanner infoLocale = new Scanner(new File(
            Configurazione.path + "info utili/" + locale + ".txt"));
        infoLocale.nextLine();  //IDFILM
        String nomeLocale = infoLocale.nextLine().replaceAll("'", "");//TITOLO FILM
        infoLocale.close();
        return nomeLocale;
    }


}
