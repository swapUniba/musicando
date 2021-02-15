package frontend;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/generazioneSpiegazioni")
/*Questa servlet serve a creare il file delle spiegazioni spiegazioni<timestamp>.txt .
In base ai parametri degli IdFrase passati alla servlet, viene letta:
2) lista ID delle frasi per contesti singoli
3) lista ID della frasi della baseline;
4) vengono lette le frasi intere dai file di testo e di oggetti 
5) tramite un template per tipo di spiegazione,
vengono generate le 3 spiegazioni e salvate su un file chiamato spiegazioni<timestamp>.txt
6) viene inviato alla pagina result1.jsp tramite metodo GET l'id del film scelto.
*/
public class ServletGenerazioneSpiegazioni extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Strutture parametri
        HashMap<Integer, Integer> frasiSingole = new HashMap<Integer, Integer>();
        int locale = 0;
        HashSet<Integer> contesti = new HashSet<>();

        String configurazione = "";//PER REPORT
        try {
            Map<String, String[]> mappaParametri = request.getParameterMap();    // RICEZIONE PARAMETRI DALLA GET
            //generazioneSpiegazioni?tempo=28282912		&configurazione=unigrammi		&locale=112
            //&frasiSingole=4:234;7:113
            for (String parametro : mappaParametri.keySet()) {
                if (parametro.equals("frasiSingole")) {
                    String contestiFrasi = mappaParametri.get(parametro)[0];
                    for (String singoloContestoFrase : contestiFrasi.split(";")) {
                        int contesto = Integer.parseInt(singoloContestoFrase.split(":")[0]);
                        int frase = Integer.parseInt(singoloContestoFrase.split(":")[1]);
                        frasiSingole.put(contesto, frase);

                        contesti.add(contesto);
                    }

                    /*
                    for (String contestoFrase : mappaParametri.get(parametro)){
                        int contesto = Integer.parseInt(contestoFrase.split(":")[0]);//IDCONTESTO
                        int frase = Integer.parseInt(contestoFrase.split(":")[1]);	//IDFRASE
                        frasiSingole.put(contesto, frase);
                    }
                    */
                } else if (parametro.equals("locale")) {
                    locale = Integer.parseInt(mappaParametri.get(parametro)[0]);//IDFILM
                } else if (parametro.equals("configurazione")) {
                    configurazione = mappaParametri.get(parametro)[0];
                }
            }

/////////////////////////////////////////2) SPIEGAZIONI CENTROIDE///////////////////////////////////////////////////
            System.out.println("\n-------------------------------INIZIO GENERAZIONE SPIEGAZIONI-----------------------------");
            String titoloLocale = getTitoloLocale(locale);
            String artista = getArtistaLocale(locale);
            //////////////////////////LETTURA FRASI INTERE FILM .dat///////////////////
            TreeMap<Integer, String> mappaFrasi = Locale.LeggiFrasiLocaleDAT(locale);

            /////////////////////////////////CALCOLO N CONTESTI/////////////////////////////////////////
            int numeroContesti = frasiSingole.size();

            ///////////////////////////1) SPIEGAZIONI GIUSTAPPOSIZIONE FRASI SINGOLE//////////////////////////////////////////
            System.out.println("////////////////////////////////1) SPIEGAZIONE GIUSTAPPOSIZIONE FRASI SINGOLE://////////////////////////////////////////");//GENERAZIONE SPIEGAZIONI FRASI SINGOLE 
            String spiegazioneSingole = generazioneFrasiSingole(frasiSingole, mappaFrasi, numeroContesti, titoloLocale, artista);
            System.out.println(spiegazioneSingole + "\n");//STAMPA A VIDEO FRASI SINGOLE

            // baseline 1 - contestuale, lessico statico
            String spiegazioneBaseline1 = generazioneBaseline1(locale, contesti, titoloLocale, artista);
            System.out.println("Spiegazione baseline 1: " + spiegazioneBaseline1);

            // baseline 2 - non contestuale, distibuzionale
            String spiegazioneBaseline2 = generazioneBaseline2(locale, titoloLocale, artista);
            System.out.println("Spiegazione baseline 2: " + spiegazioneBaseline2);
    		
    		/*
            //////////////////////////////////3) BASELINE PUCARIELLO/////////////////////////// 
            System.out.println("////////////////////////////////3) SPIEGAZIONE BASELINE://////////////////////////////////////////");
            String spiegazioneBaseline = generazioneBaseline(frasiSingole, locale);
            System.out.println(spiegazioneBaseline + "\n");//STAMPA A VIDEO BASELINE	
            
            	///////////////////////////////4) BASELINE DISTRIBUZIONALE/////////////////////////// 
            System.out.println("////////////////////////////////4) SPIEGAZIONE BASELINE DISTRIBUZIONALE://////////////////////////////////////////");
            String spiegazioneBaseline2 = generazioneBaseline2(frasiSingole, locale);
            System.out.println(spiegazioneBaseline2 + "\n");//STAMPA A VIDEO BASELINE DISTRIBUZIONALE	
            */
///////////////////////////////////SCRITTURA SPIEGAZIONI SU FILE//////////////////////////////////////
            ///////////////SCRITTURA SU FILE SPIEGAZIONI
            String tempo = request.getParameter("tempo").trim();
            PrintWriter spiegazioni = new PrintWriter(
                    Configurazione.path + "temp/spiegazioni" + tempo + ".txt");
            spiegazioni.println(spiegazioneSingole);    //1 rigo
            spiegazioni.println(spiegazioneBaseline1);	//2 rigo
            spiegazioni.println(spiegazioneBaseline2);	//3 rigo
            spiegazioni.flush();
            spiegazioni.close();

            System.out.println("--------------------------FINE GENERAZIONE SPIEGAZIONI------------------------------\n\n");

            /////////////////////////////INVIO DATI A RESULT1 PER STAMPA
            String url = "pagine/results1.jsp?tempo=" + tempo + "&locale=" + locale;
            response.sendRedirect(url);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }



    /////////////////////////////////////////////////////////////////////////////////////////////
//Tale metodo genera le spiegazioni attraverso la gisutapposizione, passandogli la lista delle frasi singole per contesto, le frasi intere e il n dei contesti 
    public static String generazioneFrasiSingole(HashMap<Integer, Integer> frasiSingole, TreeMap<Integer, String> mappaFrasi, int numeroContesti, String titoloLocale, String artista) {
        HashMap<String, ArrayList<Integer>> fraseContesti = new HashMap<String, ArrayList<Integer>>();
        //{He's always loved the movie but it somehow never made it to our shelf.=[3],
        //If you love enormously entertaining action movies, then this is the movie for you.=[2],
        String spiegazioneSingole = "I recommend you <b>" + titoloLocale + "</b> by <b>" + artista + "</b> because people who liked the album think that";
        ////////////////////////////CREAZ FRASE CONTESTI/////////////////////////////////
        int cont = 0;
        for (int c : frasiSingole.keySet()) {
            if (fraseContesti.containsKey(mappaFrasi.get(frasiSingole.get(c)))) {
                fraseContesti.get(mappaFrasi.get(frasiSingole.get(c))).add(c);
            } else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                fraseContesti.put(mappaFrasi.get(frasiSingole.get(c)), temp);
                fraseContesti.get(mappaFrasi.get(frasiSingole.get(c))).add(c);
            }
        }
        System.out.println(fraseContesti);
        //////////////////////////////////////solo da 2 frase in poi/////////////////
        for (String f : fraseContesti.keySet()) {
            cont++;
            if (cont == 2 || cont == 4) {
                spiegazioneSingole += ", and that"; //2 FRASE
            } else if (cont == 3) {
                spiegazioneSingole += "; moreover,"; //3 FRASE
            } else if (cont == 5) {//NON ABBIAMO 5 CONTESTI
                spiegazioneSingole += "; finally, they said that ";
            }
            //CASO IN CUI ABBIAMO UNA STESSA FRASE PER 2 CONTESTI DIVERSI (ES: Frasi singole: {2=3195, 6=3195}
            if (fraseContesti.get(f).size() != 1) {
                String parteFraseContesti = "";//PREPARAZIONE PARTE PRECEDENTE

                for (int i = 0; i < fraseContesti.get(f).size(); i++) {
                    if (i > 0) cont++;
                    int c = fraseContesti.get(f).get(i);
                    switch (c) {
                        case 1:
                            parteFraseContesti += " it's perfect to listen it in a <b>good mood</b> because ";
                            break;
                        case 2:
                            parteFraseContesti += " it's perfect to listen it in a <b>bad mood</b> because ";
                            break;
                        ///////////////////////////
                        case 3:
                            parteFraseContesti += " it's perfect to listen when you want to <b>relax</b> because ";
                            break;
                        case 4:
                            parteFraseContesti += " it's perfect to listen when you are doing <b>sport activities</b> because ";
                            break;
                        case 5:
                            parteFraseContesti += " it's perfect to listen when you want to <b>focus</b> because ";
                            break;
                        //////////////////////////////////
                        case 6:
                            parteFraseContesti += " it's perfect to listen when you are doing <b>home activities</b> because ";
                            break;
                        case 7:
                            parteFraseContesti += " it's perfect to listen when you are <b>driving</b> because ";
                            break;
                        case 8:
                            parteFraseContesti += " it's perfect to listen <b>alone</b> because ";
                            break;
                        case 9:
                            parteFraseContesti += " it's perfect to listen <b>with friends</b> because ";
                            break;
                        case 10:
                            parteFraseContesti += " it's perfect to listen in <b>sweet company</b> because ";
                            break;


                    }
                    //togliere perchè a tutti quelli che non sono ultimi
                    if (i <= fraseContesti.get(f).size() - 1) {
                        parteFraseContesti = parteFraseContesti.split("because ")[0];
                    }
                    if (i != fraseContesti.get(f).size() - 1) {
                        if (i < fraseContesti.get(f).size() - 2) {
                            parteFraseContesti += ", ";
                        } else {
                            parteFraseContesti += " and ";
                        }
                    } else {
                        parteFraseContesti += " because: ";
                    }
                }
                //RIMOZIONE . E ; ALLA FINE
                if (f.charAt(f.length() - 1) == '.' || f.charAt(f.length() - 1) == ';')//rimuovo , o ;
                    f = f.substring(0, f.length() - 1);

                String fr2 = f.replace("\"", "").replace("(", "").replace(")", "");//RIMOZIONE DI "",(,)..
                if (fr2.split(" ")[0].toLowerCase().equals("a") || fr2.split(" ")[0].toLowerCase().equals("an")) {
                    fr2 = "it's " + fr2.substring(0, 1).toLowerCase() + fr2.substring(1);
                }//AGGIUNGI IT'S CON LE FRASI CON A DAVANTI
                spiegazioneSingole += parteFraseContesti + "<b>" + fr2.substring(0, 1).toLowerCase() + fr2.substring(1) + "</b>";    //spiegazioneSingole += parteFraseContesti + "<b>" + f +"</b>";

            } else {

                ///////////////////////////CONTESTO SINGOLO/////////////////////////////
                int c = fraseContesti.get(f).get(0);
                switch (c) {
                    case 1:
                        spiegazioneSingole += " it's perfect to listen it in a <b>good mood</b> because ";
                        break;
                    case 2:
                        spiegazioneSingole += " it's perfect to listen it in a <b>bad mood</b> because ";
                        break;
                    ///////////////////////////
                    case 3:
                        spiegazioneSingole += " it's perfect to listen when you want to <b>relax</b> because ";
                        break;
                    case 4:
                        spiegazioneSingole += " it's perfect to listen when you are doing <b>sport activities</b> because ";
                        break;
                    case 5:
                        spiegazioneSingole += " it's perfect to listen when you want to <b>focus</b> because ";
                        break;
                    //////////////////////////////////
                    case 6:
                        spiegazioneSingole += " it's perfect to listen when you are doing <b>home activities</b> because ";
                        break;
                    case 7:
                        spiegazioneSingole += " it's perfect to listen when you are <b>driving</b> because ";
                        break;
                    case 8:
                        spiegazioneSingole += " it's perfect to listen <b>alone</b> because ";
                        break;
                    case 9:
                        spiegazioneSingole += " it's perfect to listen <b>with friends</b> because ";
                        break;
                    case 10:
                        spiegazioneSingole += " it's perfect to listen in <b>sweet company</b> because ";
                        break;
                }
                String fr = mappaFrasi.get(frasiSingole.get(c)).replace("\"", "").replace("(", "").replace(")", "");
                //RIMOZIONE . E ; ALLA FINE
                if (fr.charAt(fr.length() - 1) == '.' || fr.charAt(fr.length() - 1) == ';')//rimuovo , o ;
                    fr = fr.substring(0, fr.length() - 1);
                if (fr.split(" ")[0].toLowerCase().equals("a") || fr.split(" ")[0].toLowerCase().equals("an")) {
                    fr = "it's " + fr.substring(0, 1).toLowerCase() + fr.substring(1);
                }//AGGIUNGI IT'S CON LE FRASI CON A DAVANTI
                spiegazioneSingole += "<b>" + fr.substring(0, 1).toLowerCase() + fr.substring(1) + "</b>";
            }//FINE ELSE (CONT SINGOLO)

        }
        spiegazioneSingole += ".";

        return spiegazioneSingole;    //FINE SPIEGAZIONE GIUSTAPPOSIZIONE FRASI SINGOLE
    }

    // baseline 1 - contestuale, lessico statico
    public static String generazioneBaseline1(int item, HashSet<Integer> contesti, String titoloItem, String artista) throws FileNotFoundException {

        Scanner in = new Scanner(new File(Configurazione.path + "baseline1/frasi/" + item + ".txt"));

        HashMap<Integer, String> contestoFrase = new HashMap<>();

        // leggo le frasi scelte per i contesti
        while (in.hasNextLine()){

            String riga[] = in.nextLine().split(";",2);

            // leggo il contesto
            int c = Integer.parseInt(riga[0]);

            // quando trovo un contesto che mi interessa salvo la frase
            if (contesti.contains(c)){
                String f = riga[1];
                contestoFrase.put(c,f);
            }
        }

        in.close();

        // generazione della spiegazione
        String spiegazione = "I recommend you <b>" + titoloItem + "</b> by <b>" + artista + "</b> because people who liked the album think that";
        if (contesti.size() > 1) spiegazione += ":";

        for (int c : contesti){

            switch (c) {
                case 1:
                    spiegazione += " it's perfect to listen it in a <b>good mood</b> because ";
                    spiegazione += "<b>" + contestoFrase.get(c) + "</b>;";
                    break;
                case 2:
                    spiegazione += " it's perfect to listen it in a <b>bad mood</b> because ";
                    spiegazione += "<b>" + contestoFrase.get(c) + "</b>;";
                    break;
                ///////////////////////////
                case 3:
                    spiegazione += " it's perfect to listen when you want to <b>relax</b> because ";
                    spiegazione += "<b>" + contestoFrase.get(c) + "</b>;";
                    break;
                case 4:
                    spiegazione += " it's perfect to listen when you are doing <b>sport activities</b> because ";
                    spiegazione += "<b>" + contestoFrase.get(c) + "</b>;";
                    break;
                case 5:
                    spiegazione += " it's perfect to listen when you want to <b>focus</b> because ";
                    spiegazione += "<b>" + contestoFrase.get(c) + "</b>;";
                    break;
                //////////////////////////////////
                case 6:
                    spiegazione += " it's perfect to listen when you are doing <b>home activities</b> because ";
                    spiegazione += "<b>" + contestoFrase.get(c) + "</b>;";
                    break;
                case 7:
                    spiegazione += " it's perfect to listen when you are <b>driving</b> because ";
                    spiegazione += "<b>" + contestoFrase.get(c) + "</b>;";
                    break;
                case 8:
                    spiegazione += " it's perfect to listen <b>alone</b> because ";
                    spiegazione += "<b>" + contestoFrase.get(c) + "</b>;";
                    break;
                case 9:
                    spiegazione += " it's perfect to listen <b>with friends</b> because ";
                    spiegazione += "<b>" + contestoFrase.get(c) + "</b>;";
                    break;
                case 10:
                    spiegazione += " it's perfect to listen in <b>sweet company</b> because ";
                    spiegazione += "<b>" + contestoFrase.get(c) + "</b>;";
                    break;
            }

        }

        spiegazione = spiegazione.substring(0, spiegazione.length()-1);
        return spiegazione;

    }

    // baseline 2 - non contestuale, distribuzionale
    public static String generazioneBaseline2(int item, String titoloItem, String artista) throws FileNotFoundException {

        // leggo la singola frase scelta dalla baseline
        Scanner in = new Scanner(new File(Configurazione.path + "baseline2/frasi/" + item + ".txt"));
        String frase = in.nextLine().split(";")[2];
        in.close();

        String spiegazione = "I recommend you <b>" + titoloItem + "</b> by <b>" + artista + "</b> because people who liked the album think that <b>" + frase + "</b>";

        return spiegazione;
        /*
        String spiegazioneBaseline = "I recommend you <b>" + getTitoloLocale(locale) + "</b> because people who watched the movie think that ";
        Scanner baseline = new Scanner(new File(Configurazione.path + "filesFilmando2/baseline2.txt"));

        while (baseline.hasNextLine()) {
            String rigaBaseline = baseline.nextLine();
            int localeRigaBaseline = Integer.parseInt(rigaBaseline.split(";")[0]);
            if (locale == localeRigaBaseline) {
                String fr = rigaBaseline.split(";")[1];
                spiegazioneBaseline += "<b>" + fr.substring(0, 1).toLowerCase() + fr.substring(1) + "</b>";
            }
        }
        baseline.close();
        spiegazioneBaseline.replace("\"", "").replace("(", "").replace(")", "");
        return spiegazioneBaseline;
        */
    }

    //PER AGGIUNGERE IL TITOLO DEL FILM
    public static String getTitoloLocale(int locale) throws FileNotFoundException {
        Scanner infoLocale = new Scanner(new File(
                Configurazione.path + "info utili/" + locale + ".txt"));
        infoLocale.nextLine();
        infoLocale.nextLine();  //IDFILM
        String nomeLocale = infoLocale.nextLine().replaceAll("'", "");//TITOLO FILM
        infoLocale.close();
        return nomeLocale;
    }

    public static String getArtistaLocale(int locale) throws Exception {
        Scanner infoLocale = new Scanner(new File(
                Configurazione.path + "info utili/" + locale + ".txt"));
        infoLocale.nextLine();
        infoLocale.nextLine();  //IDFILM
        infoLocale.nextLine();
        String artista = infoLocale.nextLine().replaceAll("'", "");//TITOLO FILM
        infoLocale.close();
        return artista;

    }


}
