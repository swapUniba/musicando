package report;

import classi.Utente;
import classi.ValutazioneTipo1;
import classi.ValutazioneTipo2;
import classi.ValutazioneTipo3;
import frontend.Configurazione;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/* Questa classe legge i valori contenuti nei log e popola le strutture utenti e valutazioni.
vengono costruite  mappe, che contengono MEDIE sulle  informazioni: */
public class Report {
    public static HashSet<Utente> 				utenti = null;
    public static HashSet<ValutazioneTipo1> 	valutazioni1 = null;
    public static HashSet<ValutazioneTipo2> 	valutazioni2 = null;
    public static HashSet<ValutazioneTipo3> 	valutazioni3 = null;

    /////////////////////////////////////////COSTRUTTORE//////////////////////////////////////////
    //Questa classe popola le strutture utenti, valutazioni1, valutazioni2 , valutazioni3
    public static void leggiLog() throws Exception {
        ////////////////////////////////////////////////////UTENTI//////////////////////
        leggiUtente();
        //////////////////////////////////////////////////VALUTAZIONI/////////////////////////////////
        leggiValutazione1();
        leggiValutazione2();
        leggiValutazione3();
        
        controllo();
    }

    public static void leggiUtente() throws FileNotFoundException {

    	utenti = new HashSet<>();
    	//Scanner users = new Scanner(new File(Configurazione.path + "filesFilmando2/utenti.txt"));
        Scanner users = new Scanner(new File(Configurazione.path + "utenti.txt"));

        /*  1613139864696;
            2;
            uomo;
            7;
            12;
            14   */
    
    	while(users.hasNextLine()){

    		String[] riga = users.nextLine().split(";");
    		
    		Utente u = new Utente();

    		u.setId(riga[0]);									//1586298607561
    		u.setEta(Integer.parseInt(riga[1]));				//2
    		u.setGenere(riga[2]);								//donna
    		u.setTitoloStudio(Integer.parseInt(riga[3]));		//6
    		u.setFrequenzaUscite(Integer.parseInt(riga[4]));	//11
    		u.setUsoRecSys(riga[5]);							//14
    		utenti.add(u);
    	}
    	users.close();
    }
    
    //CENTROIDE
    public static void leggiValutazione1() throws FileNotFoundException {

    	valutazioni1 = new HashSet<>(); 
    	Scanner val1 = new Scanner(new File(Configurazione.path + "valutazione1.txt"));

    	/*  1613139864696;
    	    bigrammi;
    	    pmi;
    	    3057;
    	    2;
    	    1,3;
    	    4;
    	    4;
    	    4;
    	    4 */

    	while(val1.hasNextLine()){
    		String[] riga = val1.nextLine().split(";");
    		ValutazioneTipo1 v1 = new ValutazioneTipo1();

    		v1.setId(riga[0]);				//1591983865169
    		v1.setConfigurazione(riga[1]);	//bigrammi 
    		v1.setTecnica(riga[2]);			//normale //agg
    		v1.setItem(Integer.parseInt(riga[3]));	//281
    		v1.setNumeroContesti(Integer.parseInt(riga[4]));	//2
    		
    		ArrayList<Integer> lc = new ArrayList<>();
    		String[] lista = riga[5].split(",");	//4,6
    		for (String s : lista){
    			lc.add(Integer.parseInt(s));
    		}
    		v1.setListaContesti(lc);	//4,6
    		
    		v1.setTrasparenza(Integer.parseInt(riga[6]));		//3
    		v1.setPersuasione(Integer.parseInt(riga[7]));		//5
    		v1.setCoinvolgimento(Integer.parseInt(riga[8]));	//5
    		v1.setFiducia(Integer.parseInt(riga[9]));			//5

    		valutazioni1.add(v1);
    	}
    	val1.close();
    }

    
    public static void leggiValutazione2() throws FileNotFoundException {

        valutazioni2 = new HashSet<>();
        Scanner val2 = new Scanner(new File(Configurazione.path+"valutazione2.txt"));

        //1591983865169;bigrammi;normale;centroide;281;2;4,6;1;1;0;2;2
        while(val2.hasNextLine()){
            String[] riga = val2.nextLine().split(";");
            ValutazioneTipo2 v2 = new ValutazioneTipo2();

            v2.setId(riga[0]);
            v2.setConfigurazione(riga[1]);
            v2.setTecnica(riga[2]);//agg
            v2.setItem(Integer.parseInt(riga[3]));
            v2.setNumeroContesti(Integer.parseInt(riga[4]));

            ArrayList<Integer> lc = new ArrayList<>();
            String[] lista = riga[5].split(",");
            for (String s : lista){
                lc.add(Integer.parseInt(s));
            }
            v2.setListaContesti(lc);

            v2.setPreferenza0(Integer.parseInt(riga[6]));//confronto tra framew e distribuz

            v2.setTrasparenza(Integer.parseInt(riga[7]));
            v2.setPersuasione(Integer.parseInt(riga[8]));
            v2.setCoinvolgimento(Integer.parseInt(riga[9]));
            v2.setFiducia(Integer.parseInt(riga[10]));

            valutazioni2.add(v2);
        }
        val2.close();
    }
    
    
	public static void leggiValutazione3() throws FileNotFoundException {
		valutazioni3 = new HashSet<>();
		Scanner val3 = new Scanner(new File(Configurazione.path+"valutazione3.txt"));

        while(val3.hasNextLine()){
            String[] riga = val3.nextLine().split(";");
            ValutazioneTipo3 v3 = new ValutazioneTipo3();

            v3.setId(riga[0]);
            v3.setConfigurazione(riga[1]);
            v3.setTecnica(riga[2]);//agg
            v3.setItem(Integer.parseInt(riga[3]));
            v3.setNumeroContesti(Integer.parseInt(riga[4]));
            ArrayList<Integer> lc = new ArrayList<>();
            String[] lista = riga[5].split(",");
            for (String s : lista){
                lc.add(Integer.parseInt(s));
            }
            v3.setListaContesti(lc);
            
            v3.setPreferenza0(Integer.parseInt(riga[6]));//confronto tra framew e pucariello
            
            v3.setTrasparenza(Integer.parseInt(riga[7]));
            v3.setPersuasione(Integer.parseInt(riga[8]));
            v3.setCoinvolgimento(Integer.parseInt(riga[9]));
            v3.setFiducia(Integer.parseInt(riga[10]));

            valutazioni3.add(v3);
        }
        val3.close();
	}
	
	
    private static void controllo(){

        ArrayList<HashSet<String>> listaId = new ArrayList<HashSet<String>>();

        HashSet<String> id0 = new HashSet<>();
        for (Utente u : utenti){
            String id = u.getId();
            id0.add(id);
        }
        listaId.add(id0);

        HashSet<String> id1 = new HashSet<>();
        for (ValutazioneTipo1 v1 : valutazioni1){
            String id = v1.getId();
            id1.add(id);
        }
        listaId.add(id1);

        HashSet<String> id2 = new HashSet<>();
        for (ValutazioneTipo2 v2 : valutazioni2){
            String id = v2.getId();
            id2.add(id);
        }
        listaId.add(id2);

        HashSet<String> id3 = new HashSet<>();
        for (ValutazioneTipo3 v3 : valutazioni3){
            String id = v3.getId();
            id3.add(id);
        }
        listaId.add(id3);


        listaId.get(0).retainAll(listaId.get(1));
        listaId.get(0).retainAll(listaId.get(2));
        listaId.get(0).retainAll(listaId.get(3));

        HashSet<String> mantenere = listaId.get(0);

        HashSet<Utente> rimUt = new HashSet<>();
        for (Utente u : utenti){
            if (!mantenere.contains(u.getId())){
                rimUt.add(u);
            }
        }
        utenti.removeAll(rimUt);

        HashSet<ValutazioneTipo1> rimV1 = new HashSet<>();
        for (ValutazioneTipo1 v1 : valutazioni1){
            if (!mantenere.contains(v1.getId())){
                rimV1.add(v1);
            }
        }
        valutazioni1.removeAll(rimV1);

        HashSet<ValutazioneTipo2> rimV2 = new HashSet<>();
        for (ValutazioneTipo2 v2 : valutazioni2){
            if (!mantenere.contains(v2.getId())){
                rimV2.add(v2);
            }
        }
        valutazioni2.removeAll(rimV2);

        HashSet<ValutazioneTipo3> rimV3 = new HashSet<>();
        for (ValutazioneTipo3 v3 : valutazioni3){
            if (!mantenere.contains(v3.getId())){
                rimV3.add(v3);
            }
        }
        valutazioni3.removeAll(rimV3);

        TreeSet<String> ut = new TreeSet<>();
        for (Utente u : utenti){
            ut.add(u.getId());
        }

        for (String s : ut){
            System.out.println(s);
        }

    }


}