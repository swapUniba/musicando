package main;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/*
La classe configurazione contiene 
- l'attributo tipoLemma, che indica quale configurazione è utilizzata (unigrammi,  bigrammi, unibigrammi)
- il numero dei film e numero dei contesti; 
- il path della cartella dei file
- la lista dei nomi dei contesti
*/

public class Configurazione {

    public static String TipoLemmi = "unigrammi";
    //public static String TipoLemmi = "bigrammi";
    //public static String TipoLemmi = "unibigrammi";
    
    public static Random number = new Random();
    
    public static String tecnica = "normale";
    //public static String tecnica = "pmi";
    
    public static String TipoFrasi = "frasisingole";	//frasisingole
    //public static String TipoFrasi = "centroide";	//centroide

    public static String path = "C:\\Users\\Giuseppe\\Desktop\\progetto nlp\\Spillo - Musicando\\";	//RUN COMPLETA
    public static Integer numeroLocali = 3207;					//RUN COMPLETA
    //public static String path = "D:\\Università\\INFORMATICA\\3 anno\\TESI\\review based explanation\\";	//DEBUG
    //public static Integer numeroLocali = 5;		//DEBUG
    
    public static Integer numeroContesti = 10;
    public static HashMap<Integer, String> contesti = new HashMap<>();
    static {
        contesti.put(1, "Good mood");
        contesti.put(2, "Bad mood");
        contesti.put(3, "Relax");
        contesti.put(4, "Sport");
        contesti.put(5, "Focus");
        contesti.put(6, "Home");
        contesti.put(7, "Driving");
        contesti.put(8, "Alone");
        contesti.put(9, "Friends");
        contesti.put(10, "Couple");
    }
    
    //Il metodo  tipoRandom() imposta casualemente una delle 3 configurazioni.
    public static void tipoRandom(){
    	number= new Random();
        int p = number.nextInt(3);
        if (p == 0){            TipoLemmi = "unigrammi";} 
        else if (p == 1){       TipoLemmi = "bigrammi";} 
        else {            		TipoLemmi = "unibigrammi";}
    }
    
    //Il metodo  tecnicaRandom() imposta casualemente una delle 2 tecniche.
    public static void tecnicaRandom(){
    	number= new Random();
        boolean value = number.nextBoolean();
        if (value == true){  	tecnica = "normale";} 
        else {        			tecnica = "pmi";}
    }
    
    public static void tipoFrasiRandom(){
    	number= new Random();
        boolean value2 = number.nextBoolean();
        if (value2 == true){  	TipoFrasi = "centroide";} 
        else {        			TipoFrasi = "frasisingole";}
    }

    public static HashSet<String> stopwords = new HashSet<>();
    public static void leggiStopwords(){

        try{
            Scanner in = new Scanner(new File("stopwords.txt"));

            while (in.hasNextLine()){
                stopwords.add(in.nextLine().trim());
            }

            in.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    
    
    
}
