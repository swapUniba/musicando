package vettoricontesto;

import jdk.nashorn.api.tree.Tree;
import main.Configurazione;
import ranking.SimilaritaCoseno;

import java.io.*;
import java.util.*;


/*La classe VETTORI CONTESTO calcola i vettori contesto a partire dalla matrice LEMMA CONTESTO
 La mappa TreeMap<Integer, TreeMap<String, Double>> vettoriContesto
 assegna ad ogni contesto le coppie lemma + score del lemma in quel contesto.
 Inoltre permette di calcolare il CENTROIDE di piu vettori contesto, 
 - come media degli score dei lemminei singoli vettori contesto
*/
								//keyset
public class VettoriContesto {	////1(HA)	   //bank //0,038
    public static TreeMap<Integer, TreeMap<String, Double>> vettoriContesto = new TreeMap<>();
    /*
    Il metodo calcolaVettoriContesto(), per ogni CONTESTO:
    1) Per ogni LEMMA della matrice LEMMA CONTESTO: 
    - inserisce il lemma + score del lemma in quel contesto in una mappa contestoCorrente
	- inserisce nei vettoriContesto l'id del contesto + la mappa contestoCorrente
    */
    public static void calcolaVettoriContesto(){
        for (int idContesto = 1; idContesto <= Configurazione.numeroContesti; idContesto++) {	//1 (HA)
            TreeMap<String, Double> contestoCorrente = new TreeMap<>();	//creo vettore contestuale di HA
            for (String lemma : MatriceLC.matriceLemmaContesto.keySet()) {	//lemma = righe matrice
            		contestoCorrente.put(lemma, MatriceLC.matriceLemmaContesto.get(lemma).get(idContesto));
            }				//HA	//bank	//0,038		
            vettoriContesto.put(idContesto, contestoCorrente);
        }							//1(HA)	   //bank //0,038 (valore matrice lemma contesto)    
        /////////////////////////////PULIZIA///////////////////////////////////////////
        //MatriceLC.matriceLemmaContesto.clear();	//non mi serve pi�
    }
    
    //NUOVO METODO
    //Il centroide � il vettore medio tra i vettori contesto passati come parametro
    ////////////////////////////////CALCOLO CENTROIDE/////////////////////////		[2,3,6]
    public static TreeMap<String,Double> CalcolaCentroide(HashSet<Integer> contesti){
    	TreeMap<String,Double> centroide = new TreeMap<>();
    	int numeroContesti = contesti.size();

    	// Si calcolano le SOMME degli SCORE dei lemmi dei VETTORI CONTESTO
    	for(String lemma : VettoriContesto.vettoriContesto.get(1).keySet()){ //lemmi vett contesto, [active, bank...]
    		double sommaScore=0;
    		for(int contesto : contesti){
    			sommaScore += VettoriContesto.vettoriContesto.get(contesto).get(lemma);
    		}
    		centroide.put(lemma, sommaScore/numeroContesti);
    	}
    	return centroide;
    }
    
    //////SIMILARITA' CONTESTI		
    /*Il metodo public static void calcolaSimilaritaContesti():
    - calcola le similarit� tra i vari vettori contesto, visualizzando l�overlap tra essi */
    public static void calcolaSimilaritaContesti() throws Exception {
    	HashMap<HashSet<Integer>, Double> similarita =  new HashMap<>();
        for (int contesto1 : vettoriContesto.keySet()){
            for (int contesto2 : vettoriContesto.keySet()){
                HashSet<Integer> listaContesti = new HashSet<>();
                listaContesti.add(contesto1);
                listaContesti.add(contesto2);
                if (!similarita.containsKey(listaContesti)){
                    double score = SimilaritaCoseno.calcolaScoreFrase(vettoriContesto.get(contesto1), vettoriContesto.get(contesto2));
                    similarita.put(listaContesti, score);
                    if(contesto1 == contesto2)
                    	System.out.println(score);
                }
            }
        }
        //stampare
        PrintWriter out = new PrintWriter(new File(Configurazione.path + "filesFilmando2\\"  + Configurazione.tecnica + "\\" + Configurazione.TipoLemmi + "\\strutture\\vettoricontesto\\similarita_vettori_contesto.txt"));

        for (HashSet<Integer> contesti : similarita.keySet()){
            out.println(contesti + "\t->\t" + similarita.get(contesti));
        }

        out.flush();
        out.close();
    }
    
    
/////////////////////////////////////////////////////STAMPA///////////////////////////////////////////////////////////    
    //STAMPA SU FILE VETTORI CONTESTO
    public static void stampaVettoriContestoFile() throws Exception{
        for(int idContesto : vettoriContesto.keySet()){
          	PrintWriter out = new PrintWriter(new File(
          			Configurazione.path + "filesFilmando2\\"  + Configurazione.tecnica + "\\" + Configurazione.TipoLemmi + "\\strutture\\vettoricontesto\\"+ idContesto  + ".txt"));
          	out.printf("%-13s\t%d\n", "L", idContesto);
          	for (String lemma : vettoriContesto.get(idContesto).keySet()) {	//righe matrice
          		out.printf("%-13s\t%.8f\n",lemma,vettoriContesto.get(idContesto).get(lemma));
            }
          	out.flush();
            out.close();
        }
    }
    
    public static void stampaVettoreCentroide(TreeMap<String,Double> centroide){
    	//out.printf("%-13s\t%d\n", "L", idContesto);
    	for (String lemma : centroide.keySet()) {	//righe matrice
    		System.out.printf("%-13s\t%.8f\n",lemma,centroide.get(lemma));
    	}
    	System.out.println();
    }
    
    
    //SCRITTURA SU FILE SIMILARITA CONTESTI
    public static void stampaSimilaritaContestiFile(HashMap<HashSet<Integer>, Double> similarita) throws Exception {
        PrintWriter out = new PrintWriter(new File(
        		Configurazione.path + "filesFilmando2\\"  + Configurazione.tecnica + "\\" + Configurazione.TipoLemmi +"\\matrice similarita contesti.txt"));
        out.println("\t1\t2\t3\t5\t5\t6\t7");
        for (int i=1; i<= Configurazione.numeroContesti; i++){
            out.print(i+"\t");
            for (int j=1; j<= Configurazione.numeroContesti; j++){
                HashSet<Integer> listaContesti = new HashSet<>();
                listaContesti.add(i);
                listaContesti.add(j);
                if (similarita.containsKey(listaContesti)) {
                    out.printf("%.2f\t", similarita.get(listaContesti));
                }
            }
            out.println();
        }
        out.flush();
        out.close();
    }
	
    
//////////////////////////////////////////////SERIALIZZAZIONE/////////////////////////////////////////////////////////////////////
    //SERIALIZZAZIONE
    public static void scriviVettoriContestoDAT() throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(
        		Configurazione.path +"filesFilmando2\\"  + Configurazione.tecnica + "\\" + Configurazione.TipoLemmi + "\\serialized\\vettori contesto.dat")));
        oos.writeObject(vettoriContesto);
        oos.flush();
        oos.close();
    }
    //DESERIALIZZAZIONE
    public static void leggiVettoriContestoDAT() throws Exception {
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(new File(
        		Configurazione.path + "filesFilmando2\\"  + Configurazione.tecnica + "\\" + Configurazione.TipoLemmi + "\\serialized\\vettori contesto.dat")));
        vettoriContesto = (TreeMap<Integer, TreeMap<String, Double>>) oin.readObject();
        oin.close();
    }

    public static void generaLessicoVettoriContesto() throws Exception{

        // per ogni contesto
        for (int idContesto=1; idContesto<=10; idContesto++){

            // seleziono il singolo contesto
            TreeMap<String, Double> contesto = vettoriContesto.get(idContesto);

            // mappa ordinata score -> [insieme di lessici]
            TreeMap<Double, TreeSet<String>> lessicoScore = new TreeMap<>(Collections.reverseOrder());

            // per ogni lemma
            for (String lemma : contesto.keySet()){

                // leggo lo score
                double score = contesto.get(lemma);

                // se � presente, aggiorno la lista di lemmi con quello score
                if (lessicoScore.containsKey(score)){
                    lessicoScore.get(score).add(lemma);

                // altrimenti inserisco la coppia score -> [lista di lemmi] con [lista di lemmi] di dimensione 1
                } else {
                    TreeSet<String> less = new TreeSet<>();
                    less.add(lemma);
                    lessicoScore.put(score, less);
                }
            }

            // ora ho tutti i lemmi ordinati per score, quindi li stampo su file
            PrintWriter out = new PrintWriter(new File(Configurazione.path + "filesFilmando2\\"  + Configurazione.tecnica + "\\" + Configurazione.TipoLemmi + "\\lessico\\" + idContesto + "_" + Configurazione.contesti.get(idContesto) +".txt"));

            for (double score : lessicoScore.keySet()){
                for (String lemma : lessicoScore.get(score)){
                    out.println(lemma + "\t" + score);
                }

            }

            out.flush();
            out.close();


        }

        System.out.println("Lessico generato.");

    }
    
}
