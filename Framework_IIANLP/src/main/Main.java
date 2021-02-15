package main;

import pmi.FrequenzaContesto;
import pmi.FrequenzaLemma;
import pmi.PMI;
import ranking.MatriceLocaleContesto;
import ranking.SimilaritaCoseno;
import ranking.Top10LocaliPerCombinazione;
import spiegazioni.MatriceContestiItemFrasi;
import spiegazioni.MatriceLocaliContestiFrasi;
import vettoricontesto.*;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        try {

            Configurazione.leggiStopwords();

            //soloLessici();
            //Scanner ines = new Scanner(new File("inesistente.txt"));


            int conf = 1;

            while (conf <= 6) {

                switch (conf) {
                    case 1:
                        Configurazione.tecnica = "normale";
                        Configurazione.TipoLemmi = "unigrammi";
                        break;
                    case 2:
                        Configurazione.tecnica = "normale";
                        Configurazione.TipoLemmi = "bigrammi";
                        break;
                    case 3:
                        Configurazione.tecnica = "normale";
                        Configurazione.TipoLemmi = "unibigrammi";
                        break;
                    case 4:
                        Configurazione.tecnica = "pmi";
                        Configurazione.TipoLemmi = "unigrammi";
                        break;
                    case 5:
                        Configurazione.tecnica = "pmi";
                        Configurazione.TipoLemmi = "bigrammi";
                        break;
                    case 6:
                        Configurazione.tecnica = "pmi";
                        Configurazione.TipoLemmi = "unibigrammi";
                        break;
                }

                reset();

                double inizio = System.currentTimeMillis();

                System.out.println("Configurazione: " + Configurazione.TipoLemmi);
                System.out.println("Tecnica: " + Configurazione.tecnica);

                if (Configurazione.tecnica.equals("normale")) {
                    ///////////////////////////////////////1) GENERAZIONE VETTORI CONTESTO//////////////////////////////////////
                    System.out.println("/////////////////////////////////////1) GENERAZIONE VETTORI CONTESTO///////////////////////////");
                    //1) MATRICE FRASE CONTESTO
                    MatriceFC.calcolaMatriceFraseContesto();
                    MatriceFC.stampaMatriceFraseContestoFile();    //AGGIUNTO DA ME
                    System.out.println("MATRICE FRASE CONTESTO calcolata.");

                    //2) IDF E TF
                    VettoreIDF.calcolaIDF();
                    VettoreIDF.annullamentoScoreStopWordsIDF();//annullo score IDF stoplemmi
                    VettoreIDF.stampaIDFFile();
                    VettoreIDF.scriviIDFDAT();//SERIALIZZAZIONE
                    VettoreIDF.leggiIDFDAT();//DESERIALIZZAZIONE
                    System.out.println("IDF calcolati.");

                    //2) MATRICE LEMMA FRASE
                    MatriceLF.calcolaMatriceLemmaFrase();
                    MatriceLF.stampaMatriceLemmaFraseFile();
                    System.out.println("MATRICE LEMMA FRASE calcolata.");

                    //3) MATRICE LEMMA CONTESTO
                    MatriceLC.calcolaMatriceLemmaContesto();
                    System.out.println("MATRICE LEMMA CONTESTO calcolata.");
                    MatriceLC.annullamentoScoreStopWords();    //ANNULLAMENTO STOP WORDS	//AGGIUNTO DA MIRKO
                    MatriceLC.stampaMatriceLemmaContestoFile();
                    MatriceLC.ScriviMatriceLemmaContestoDAT();//SERIALIZZAZIONE
                    //MatriceLC.LeggiMatriceLemmaContestoDAT();//DESERIALIZZAZIONE

                } else {
                    ///////////////////////////////////////1) GENERAZIONE VETTORI CONTESTO//////////////////////////////////////
                    System.out.println("/////////////////////////////////////1) GENERAZIONE VETTORI CONTESTO///////////////////////////");
                    FrequenzaLemma.calcolaFreqLemma();
                    FrequenzaLemma.annullamentoScoreStopWords();//annullo score IDF stoplemmi
                    FrequenzaLemma.stampaIDFFile();
                    FrequenzaLemma.scriviFreqLemmaDAT();
                    //FrequenzaLemma.leggiFreqLemmaDAT();
                    System.out.println("FREQUENZE LEMMI calcolate.\n");

                    FrequenzaContesto.calcolaFreqContesto();
                    FrequenzaContesto.stampaFreqContestoFile();
                    System.out.println("FREQUENZE CONTESTI calcolate.\n");

                    PMI.calcolaPMI();
                    PMI.stampaMatriceLemmaContestoFile();
                    PMI.annullamentoScoreStopWords();        //annullo score PMI stopwords
                    System.out.println("MATRICE PMI CONTESTO calcolata.");

                }


                //4) VETTORI CONTESTO
                VettoriContesto.calcolaVettoriContesto();
                VettoriContesto.stampaVettoriContestoFile();
                VettoriContesto.scriviVettoriContestoDAT();//SERIALIZZAZIONE VETT CONTESTO
                VettoriContesto.generaLessicoVettoriContesto(); //STAMPA LESSICO GENERATO
                //VettoriContesto.leggiVettoriContestoDAT();//DESERIALIZZAZIONE VETT CONTESTO
                System.out.println("VETTORI CONTESTO calcolati\n");
                //Scanner scan = new Scanner(new File("ineststente.txt"));
                VettoriContesto.calcolaSimilaritaContesti();

////////////////////////////////////////2) RANKING FILM///////////////////////////////////////////
                System.out.println("//////////////////////////////////2) RANKING FILM/////////////////////////////////////////////");
                MatriceLocaleContesto.calcolaMatriceLocaleContesto();                        //DEBUG
                MatriceLocaleContesto.stampaMatriceLocaleContestoFile();        //1	FASE
                MatriceLocaleContesto.stampaFileMatriceLocaleContestoDat();    //SCRIVI IN FORMATO .DAT
                SimilaritaCoseno.stampaFileSimilaritaDat();                //SCRIVI IN FORMATO .DAT
                //MatriceLocaleContesto.leggiMatriceLocaleContestoDat();		//LEGGI IN FORMATO .DAT
                //SimilaritaCoseno.leggiSimilaritaDat();					//LEGGI IN FORMATO .DAT
                System.out.println("MATRICE FILM CONTESTO calcolata\n");


//////////////////////////////////////////3) GENERAZIONE TOP 10 FILM///////////////////////////////////////////////
                System.out.println("/////////////////////////////////3) GENERAZIONE TOP 10 FILM////////////////////////////////////////////////");
                Top10LocaliPerCombinazione.calcolaTop10FilmSingoloContesto();
                Top10LocaliPerCombinazione.calcolaTop10FilmCombContesti();//AGGIUNTO MODULO DI RIUDZIONE SCORE
                Top10LocaliPerCombinazione.stampaContestiItemTop10();//STAMPA A VIDEO TOP 10
                Top10LocaliPerCombinazione.stampaContestiItemTop10File();
                Top10LocaliPerCombinazione.scriviTop10File();    //SCRIVI IN FORMATO .DAT 	//WEBAPP
                System.out.println("TOP10 FILM trovati\n");


/////////////////////////////////////////4) SPIEGAZIONI////////////////////////////////////////////////
                System.out.println("/////////////////////////////////4) SPIEGAZIONI FILM////////////////////////////////////////////////");
                MatriceLocaleContesto.leggiMatriceLocaleContestoDat();//RIPRISTINO

                System.out.println("///////////////////////1) SPIEGAZIONI GIUSTAPPOSIZIONE DI FRASI///////////////////////////////");
                MatriceLocaliContestiFrasi.calcolaMatriceLocaliContestiFrasi();
                //MatriceContestiItemFrasi.leggiMatrice();
                MatriceLocaliContestiFrasi.stampaMatriceLocaliContestiFrasiFile();            //2	FASE
                MatriceLocaliContestiFrasi.scriviMatrice();    //SCRIVI IN FORMATO .DAT		//WEBAPP
                MatriceLocaliContestiFrasi.scriviCombinazioni();        //STAMPA A VIDEO COMB
                MatriceLocaliContestiFrasi.scriviCombinazioniFile();                        //2	FASE

                System.out.println("MATRICE FILM-CONTESTI-FRASI calcolata\n");

                /////////////////MATRICE CONTESTI ITEM FRASI//////////
                System.out.println("///////////////////////////////2) SPIEGAZIONI CENTROIDE///////////////////////////////");
                MatriceContestiItemFrasi.calcolaMatriceContestiItemFrasi();    //RUN COMPLETA
                System.out.println(MatriceContestiItemFrasi.matriceContestiItemFrasi);
                MatriceContestiItemFrasi.scriviCombinazioni();             //STAMPA A VIDEO COMB
                MatriceContestiItemFrasi.scriviCombinazioniFile();            //3	FASE
                MatriceContestiItemFrasi.scriviMatrice();    //SCRIVI IN FORMATO .DAT	//WEBAPP
                MatriceContestiItemFrasi.stampaMatriceContestiItemFrasiFile(); //STAMPA SU FILE
                System.out.println("MATRICE CONTESTI FILM FRASI calcolata.\n");

                System.out.println("FINE");

                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                double durata = (System.currentTimeMillis() - inizio) / 60000;
                System.out.println("Tempo esecuzione:  " + durata + " minuti.");

                conf++;

            }






        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void soloLessici() throws Exception {

        int conf = 4;

        while (conf <= 6) {

            switch (conf) {
                case 1:
                    Configurazione.tecnica = "normale";
                    Configurazione.TipoLemmi = "unigrammi";
                    break;
                case 2:
                    Configurazione.tecnica = "normale";
                    Configurazione.TipoLemmi = "bigrammi";
                    break;
                case 3:
                    Configurazione.tecnica = "normale";
                    Configurazione.TipoLemmi = "unibigrammi";
                    break;
                case 4:
                    Configurazione.tecnica = "pmi";
                    Configurazione.TipoLemmi = "unigrammi";
                    break;
                case 5:
                    Configurazione.tecnica = "pmi";
                    Configurazione.TipoLemmi = "bigrammi";
                    break;
                case 6:
                    Configurazione.tecnica = "pmi";
                    Configurazione.TipoLemmi = "unibigrammi";
                    break;
            }

            reset();

            if (Configurazione.tecnica.equals("normale")) {
                ///////////////////////////////////////1) GENERAZIONE VETTORI CONTESTO//////////////////////////////////////
                System.out.println("/////////////////////////////////////1) GENERAZIONE VETTORI CONTESTO///////////////////////////");
                //1) MATRICE FRASE CONTESTO
                MatriceFC.calcolaMatriceFraseContesto();
                MatriceFC.stampaMatriceFraseContestoFile();    //AGGIUNTO DA ME
                System.out.println("MATRICE FRASE CONTESTO calcolata.");

                //2) IDF E TF
                VettoreIDF.calcolaIDF();
                VettoreIDF.annullamentoScoreStopWordsIDF();//annullo score IDF stoplemmi
                VettoreIDF.stampaIDFFile();
                VettoreIDF.scriviIDFDAT();//SERIALIZZAZIONE
                VettoreIDF.leggiIDFDAT();//DESERIALIZZAZIONE
                System.out.println("IDF calcolati.");

                //2) MATRICE LEMMA FRASE
                MatriceLF.calcolaMatriceLemmaFrase();
                MatriceLF.stampaMatriceLemmaFraseFile();
                System.out.println("MATRICE LEMMA FRASE calcolata.");

                //3) MATRICE LEMMA CONTESTO
                MatriceLC.calcolaMatriceLemmaContesto();
                System.out.println("MATRICE LEMMA CONTESTO calcolata.");
                MatriceLC.annullamentoScoreStopWords();    //ANNULLAMENTO STOP WORDS	//AGGIUNTO DA MIRKO
                MatriceLC.stampaMatriceLemmaContestoFile();
                MatriceLC.ScriviMatriceLemmaContestoDAT();//SERIALIZZAZIONE
                //MatriceLC.LeggiMatriceLemmaContestoDAT();//DESERIALIZZAZIONE

            } else {
                ///////////////////////////////////////1) GENERAZIONE VETTORI CONTESTO//////////////////////////////////////
                System.out.println("/////////////////////////////////////1) GENERAZIONE VETTORI CONTESTO///////////////////////////");
                FrequenzaLemma.calcolaFreqLemma();
                FrequenzaLemma.annullamentoScoreStopWords();//annullo score IDF stoplemmi
                FrequenzaLemma.stampaIDFFile();
                FrequenzaLemma.scriviFreqLemmaDAT();
                //FrequenzaLemma.leggiFreqLemmaDAT();
                System.out.println("FREQUENZE LEMMI calcolate.\n");

                FrequenzaContesto.calcolaFreqContesto();
                FrequenzaContesto.stampaFreqContestoFile();
                System.out.println("FREQUENZE CONTESTI calcolate.\n");

                PMI.calcolaPMI();
                PMI.stampaMatriceLemmaContestoFile();
                PMI.annullamentoScoreStopWords();        //annullo score PMI stopwords
                System.out.println("MATRICE PMI CONTESTO calcolata.");

            }


            //4) VETTORI CONTESTO
            VettoriContesto.calcolaVettoriContesto();
            VettoriContesto.stampaVettoriContestoFile();
            VettoriContesto.scriviVettoriContestoDAT();//SERIALIZZAZIONE VETT CONTESTO
            VettoriContesto.generaLessicoVettoriContesto(); //STAMPA LESSICO GENERATO
            //VettoriContesto.leggiVettoriContestoDAT();//DESERIALIZZAZIONE VETT CONTESTO
            System.out.println("VETTORI CONTESTO calcolati\n");

            conf++;

        }


        //Scanner ines = new Scanner(new File("inesistente.txt"));

    }

    public static void reset() {

        MatriceFC.matriceFraseContesto = new TreeMap<>();
        MatriceFC.idFraseidContesti = new TreeMap<>();

        VettoreIDF.idFrasi = new HashSet<>();
        VettoreIDF.insiemeLemmi = new HashSet<>();
        VettoreIDF.idFraseLemmi = new TreeMap<>();
        VettoreIDF.lemmiIDF = new HashMap<>();

        MatriceLF.matriceLemmaFrase = new TreeMap<>();
        MatriceLF.matriceLemmaTF = new TreeMap<>();
        MatriceLF.numeroFrasi = 0;
        MatriceLF.idFrasi = new HashSet<>();
        MatriceLF.insiemeLemmi = new HashSet<>();
        MatriceLF.idFraseLemmi = new TreeMap<>();

        MatriceLC.matriceLemmaContesto = new TreeMap<>();

        FrequenzaLemma.numeroFrasi = 0;
        FrequenzaLemma.insiemeLemmi = new HashSet<>();
        FrequenzaLemma.idFrasi = new HashSet<>();
        FrequenzaLemma.idFraseLemmi = new TreeMap<>();
        FrequenzaLemma.freqLemma = new HashMap<>();

        FrequenzaContesto.insiemeLemmiContesto = new HashMap<>();
        FrequenzaContesto.FreqCont = new HashMap<>();

        PMI.insiemeLemmi = new HashSet<>();
        PMI.idFraseLemmi = new TreeMap<>();
        PMI.idFraseidContesti = new TreeMap<>();

        VettoriContesto.vettoriContesto = new TreeMap<>();

        MatriceLocaleContesto.matriceLocaleContesto = new TreeMap<>();

        SimilaritaCoseno.Similarita = new TreeMap<>();

        Top10LocaliPerCombinazione.combinazioni = new HashSet<>();
        Top10LocaliPerCombinazione.contestiItemTop10 = new HashMap<>();

        MatriceLocaliContestiFrasi.localiContestiFrasi = new HashMap<>();

        MatriceContestiItemFrasi.matriceContestiItemFrasi = new HashMap<>();
        MatriceContestiItemFrasi.combinazioni = Top10LocaliPerCombinazione.combinazioni;



    }

}
