package report;

import classi.ValutazioneTipo1;

import java.util.HashMap;
/*
//////////////////////////////VALUTAZIONI//////////////////////////
5) valutazioni metriche assolute sulle spiegazioni basate sul centroide; 
6) valutazioni metriche assolute sulle spiegazioni basate sulle frasi singole;
*/

public class Valutazioni {


    // 1) valutazioni sistema - generale
    public static HashMap<String, Double> valutazioniAssolute() {

        HashMap<String, Double> uni = new HashMap<>();

        int valore1uni = 0, valore2uni = 0, valore3uni = 0, valore4uni = 0, totaleuni = 0;

        for (ValutazioneTipo1 v1 : Report.valutazioni1) {

            valore1uni += v1.getTrasparenza();
            valore2uni += v1.getPersuasione();
            valore3uni += v1.getCoinvolgimento();
            valore4uni += v1.getFiducia();
            totaleuni++;


        }

        if (totaleuni != 0) {
            uni.put("Trasparenza", (double) valore1uni / totaleuni);
            uni.put("Persuasione", (double) valore2uni / totaleuni);
            uni.put("Coinvolgimento", (double) valore3uni / totaleuni);
            uni.put("Fiducia", (double) valore4uni / totaleuni);
        } else {
            uni.put("Trasparenza", 0.0);
            uni.put("Persuasione", 0.0);
            uni.put("Coinvolgimento", 0.0);
            uni.put("Fiducia", 0.0);
        }

        return uni;
    }

    // 2) valutazioni assolute - normale - generale
    public static HashMap<String, Double> valutazioniAssoluteNormale() {

        HashMap<String, Double> uni = new HashMap<>();

        int valore1uni = 0, valore2uni = 0, valore3uni = 0, valore4uni = 0, totaleuni = 0;

        for (ValutazioneTipo1 v1 : Report.valutazioni1) {
            if (v1.getTecnica().equals("normale")) {
                valore1uni += v1.getTrasparenza();
                valore2uni += v1.getPersuasione();
                valore3uni += v1.getCoinvolgimento();
                valore4uni += v1.getFiducia();
                totaleuni++;
            }

        }

        if (totaleuni != 0) {
            uni.put("Trasparenza", (double) valore1uni / totaleuni);
            uni.put("Persuasione", (double) valore2uni / totaleuni);
            uni.put("Coinvolgimento", (double) valore3uni / totaleuni);
            uni.put("Fiducia", (double) valore4uni / totaleuni);
        } else {
            uni.put("Trasparenza", 0.0);
            uni.put("Persuasione", 0.0);
            uni.put("Coinvolgimento", 0.0);
            uni.put("Fiducia", 0.0);
        }

        return uni;
    }

    // 3) valutazioni assolute - pmi - generale
    public static HashMap<String, Double> valutazioniAssolutePMI() {

        HashMap<String, Double> uni = new HashMap<>();

        int valore1uni = 0, valore2uni = 0, valore3uni = 0, valore4uni = 0, totaleuni = 0;

        for (ValutazioneTipo1 v1 : Report.valutazioni1) {
            if (v1.getTecnica().equals("pmi")) {
                valore1uni += v1.getTrasparenza();
                valore2uni += v1.getPersuasione();
                valore3uni += v1.getCoinvolgimento();
                valore4uni += v1.getFiducia();
                totaleuni++;
            }

        }

        if (totaleuni != 0) {
            uni.put("Trasparenza", (double) valore1uni / totaleuni);
            uni.put("Persuasione", (double) valore2uni / totaleuni);
            uni.put("Coinvolgimento", (double) valore3uni / totaleuni);
            uni.put("Fiducia", (double) valore4uni / totaleuni);
        } else {
            uni.put("Trasparenza", 0.0);
            uni.put("Persuasione", 0.0);
            uni.put("Coinvolgimento", 0.0);
            uni.put("Fiducia", 0.0);
        }

        return uni;
    }

    // 4) valutazioni sistema - lemmi
    public static HashMap<String, HashMap<String, Double>> valutazioniAssoluteLemmi() {
        HashMap<String, HashMap<String, Double>> esiti = new HashMap<>();

        HashMap<String, Double> uni = new HashMap<>();
        HashMap<String, Double> bi = new HashMap<>();
        HashMap<String, Double> unibi = new HashMap<>();

        int valore1uni = 0, valore2uni = 0, valore3uni = 0, valore4uni = 0, totaleuni = 0,
                valore1bi = 0, valore2bi = 0, valore3bi = 0, valore4bi = 0, totalebi = 0,
                valore1unibi = 0, valore2unibi = 0, valore3unibi = 0, valore4unibi = 0, totaleunibi = 0;

        for (ValutazioneTipo1 v1 : Report.valutazioni1) {//centroide pmi/normale
            //AGGIUNTO DA ME
            if (v1.getConfigurazione().equals("unigrammi")) {
                valore1uni += v1.getTrasparenza();
                valore2uni += v1.getPersuasione();
                valore3uni += v1.getCoinvolgimento();
                valore4uni += v1.getFiducia();
                totaleuni++;
            } else if (v1.getConfigurazione().equals("bigrammi")) {
                valore1bi += v1.getTrasparenza();
                valore2bi += v1.getPersuasione();
                valore3bi += v1.getCoinvolgimento();
                valore4bi += v1.getFiducia();
                totalebi++;
            } else if (v1.getConfigurazione().equals("unibigrammi")) {
                valore1unibi += v1.getTrasparenza();
                valore2unibi += v1.getPersuasione();
                valore3unibi += v1.getCoinvolgimento();
                valore4unibi += v1.getFiducia();
                totaleunibi++;
            }

        }
        ////////////////////////////////////CALCOLO MEDIE ASSOLUTE
        ////////////////////////////
        if (totaleuni != 0) {
            uni.put("Trasparenza", (double) valore1uni / totaleuni);
            uni.put("Persuasione", (double) valore2uni / totaleuni);
            uni.put("Coinvolgimento", (double) valore3uni / totaleuni);
            uni.put("Fiducia", (double) valore4uni / totaleuni);
        } else {
            uni.put("Trasparenza", 0.0);
            uni.put("Persuasione", 0.0);
            uni.put("Coinvolgimento", 0.0);
            uni.put("Fiducia", 0.0);
        }
        ////////////////////
        if (totalebi != 0) {
            bi.put("Trasparenza", (double) valore1bi / totalebi);
            bi.put("Persuasione", (double) valore2bi / totalebi);
            bi.put("Coinvolgimento", (double) valore3bi / totalebi);
            bi.put("Fiducia", (double) valore4bi / totalebi);
        } else {
            bi.put("Trasparenza", 0.0);
            bi.put("Persuasione", 0.0);
            bi.put("Coinvolgimento", 0.0);
            bi.put("Fiducia", 0.0);
        }
        ///////////////////////////
        if (totaleunibi != 0) {
            unibi.put("Trasparenza", (double) valore1unibi / totaleunibi);
            unibi.put("Persuasione", (double) valore2unibi / totaleunibi);
            unibi.put("Coinvolgimento", (double) valore3unibi / totaleunibi);
            unibi.put("Fiducia", (double) valore4unibi / totaleunibi);
        } else {
            unibi.put("Trasparenza", 0.0);
            unibi.put("Persuasione", 0.0);
            unibi.put("Coinvolgimento", 0.0);
            unibi.put("Fiducia", 0.0);
        }

        esiti.put("unigrammi", uni);
        esiti.put("bigrammi", bi);
        esiti.put("unibigrammi", unibi);
        return esiti;
    }

    // 5) valutazioni assolute - normale - lemmi
    public static HashMap<String, HashMap<String, Double>> valutazioniAssoluteNormaleLemmi() {
        HashMap<String, HashMap<String, Double>> esiti = new HashMap<>();

        HashMap<String, Double> uni = new HashMap<>();
        HashMap<String, Double> bi = new HashMap<>();
        HashMap<String, Double> unibi = new HashMap<>();

        int valore1uni = 0, valore2uni = 0, valore3uni = 0, valore4uni = 0, totaleuni = 0,
                valore1bi = 0, valore2bi = 0, valore3bi = 0, valore4bi = 0, totalebi = 0,
                valore1unibi = 0, valore2unibi = 0, valore3unibi = 0, valore4unibi = 0, totaleunibi = 0;

        for (ValutazioneTipo1 v1 : Report.valutazioni1) {//centroide pmi/normale
            if (v1.getTecnica().equals("normale")) {//AGGIUNTO DA ME
                if (v1.getConfigurazione().equals("unigrammi")) {
                    valore1uni += v1.getTrasparenza();
                    valore2uni += v1.getPersuasione();
                    valore3uni += v1.getCoinvolgimento();
                    valore4uni += v1.getFiducia();
                    totaleuni++;
                } else if (v1.getConfigurazione().equals("bigrammi")) {
                    valore1bi += v1.getTrasparenza();
                    valore2bi += v1.getPersuasione();
                    valore3bi += v1.getCoinvolgimento();
                    valore4bi += v1.getFiducia();
                    totalebi++;
                } else if (v1.getConfigurazione().equals("unibigrammi")) {
                    valore1unibi += v1.getTrasparenza();
                    valore2unibi += v1.getPersuasione();
                    valore3unibi += v1.getCoinvolgimento();
                    valore4unibi += v1.getFiducia();
                    totaleunibi++;
                }
            }//
        }
        ////////////////////////////////////CALCOLO MEDIE ASSOLUTE
        ////////////////////////////
        if (totaleuni != 0) {
            uni.put("Trasparenza", (double) valore1uni / totaleuni);
            uni.put("Persuasione", (double) valore2uni / totaleuni);
            uni.put("Coinvolgimento", (double) valore3uni / totaleuni);
            uni.put("Fiducia", (double) valore4uni / totaleuni);
        } else {
            uni.put("Trasparenza", 0.0);
            uni.put("Persuasione", 0.0);
            uni.put("Coinvolgimento", 0.0);
            uni.put("Fiducia", 0.0);
        }
        ////////////////////
        if (totalebi != 0) {
            bi.put("Trasparenza", (double) valore1bi / totalebi);
            bi.put("Persuasione", (double) valore2bi / totalebi);
            bi.put("Coinvolgimento", (double) valore3bi / totalebi);
            bi.put("Fiducia", (double) valore4bi / totalebi);
        } else {
            bi.put("Trasparenza", 0.0);
            bi.put("Persuasione", 0.0);
            bi.put("Coinvolgimento", 0.0);
            bi.put("Fiducia", 0.0);
        }
        ///////////////////////////
        if (totaleunibi != 0) {
            unibi.put("Trasparenza", (double) valore1unibi / totaleunibi);
            unibi.put("Persuasione", (double) valore2unibi / totaleunibi);
            unibi.put("Coinvolgimento", (double) valore3unibi / totaleunibi);
            unibi.put("Fiducia", (double) valore4unibi / totaleunibi);
        } else {
            unibi.put("Trasparenza", 0.0);
            unibi.put("Persuasione", 0.0);
            unibi.put("Coinvolgimento", 0.0);
            unibi.put("Fiducia", 0.0);
        }

        esiti.put("unigrammi", uni);
        esiti.put("bigrammi", bi);
        esiti.put("unibigrammi", unibi);
        return esiti;
    }

    // 6) valutazioni assolute - pmi - lemmi
    public static HashMap<String, HashMap<String, Double>> valutazioniAssolutePMILemmi() {
        HashMap<String, HashMap<String, Double>> esiti = new HashMap<>();

        HashMap<String, Double> uni = new HashMap<>();
        HashMap<String, Double> bi = new HashMap<>();
        HashMap<String, Double> unibi = new HashMap<>();

        int valore1uni = 0, valore2uni = 0, valore3uni = 0, valore4uni = 0, totaleuni = 0,
                valore1bi = 0, valore2bi = 0, valore3bi = 0, valore4bi = 0, totalebi = 0,
                valore1unibi = 0, valore2unibi = 0, valore3unibi = 0, valore4unibi = 0, totaleunibi = 0;

        for (ValutazioneTipo1 v1 : Report.valutazioni1) {//centroide pmi/normale
            if (v1.getTecnica().equals("pmi")) {//AGGIUNTO DA ME
                if (v1.getConfigurazione().equals("unigrammi")) {
                    valore1uni += v1.getTrasparenza();
                    valore2uni += v1.getPersuasione();
                    valore3uni += v1.getCoinvolgimento();
                    valore4uni += v1.getFiducia();
                    totaleuni++;
                } else if (v1.getConfigurazione().equals("bigrammi")) {
                    valore1bi += v1.getTrasparenza();
                    valore2bi += v1.getPersuasione();
                    valore3bi += v1.getCoinvolgimento();
                    valore4bi += v1.getFiducia();
                    totalebi++;
                } else if (v1.getConfigurazione().equals("unibigrammi")) {
                    valore1unibi += v1.getTrasparenza();
                    valore2unibi += v1.getPersuasione();
                    valore3unibi += v1.getCoinvolgimento();
                    valore4unibi += v1.getFiducia();
                    totaleunibi++;
                }
            }//
        }
        ////////////////////////////////////CALCOLO MEDIE ASSOLUTE
        ////////////////////////////
        if (totaleuni != 0) {
            uni.put("Trasparenza", (double) valore1uni / totaleuni);
            uni.put("Persuasione", (double) valore2uni / totaleuni);
            uni.put("Coinvolgimento", (double) valore3uni / totaleuni);
            uni.put("Fiducia", (double) valore4uni / totaleuni);
        } else {
            uni.put("Trasparenza", 0.0);
            uni.put("Persuasione", 0.0);
            uni.put("Coinvolgimento", 0.0);
            uni.put("Fiducia", 0.0);
        }
        ////////////////////
        if (totalebi != 0) {
            bi.put("Trasparenza", (double) valore1bi / totalebi);
            bi.put("Persuasione", (double) valore2bi / totalebi);
            bi.put("Coinvolgimento", (double) valore3bi / totalebi);
            bi.put("Fiducia", (double) valore4bi / totalebi);
        } else {
            bi.put("Trasparenza", 0.0);
            bi.put("Persuasione", 0.0);
            bi.put("Coinvolgimento", 0.0);
            bi.put("Fiducia", 0.0);
        }
        ///////////////////////////
        if (totaleunibi != 0) {
            unibi.put("Trasparenza", (double) valore1unibi / totaleunibi);
            unibi.put("Persuasione", (double) valore2unibi / totaleunibi);
            unibi.put("Coinvolgimento", (double) valore3unibi / totaleunibi);
            unibi.put("Fiducia", (double) valore4unibi / totaleunibi);
        } else {
            unibi.put("Trasparenza", 0.0);
            unibi.put("Persuasione", 0.0);
            unibi.put("Coinvolgimento", 0.0);
            unibi.put("Fiducia", 0.0);
        }

        esiti.put("unigrammi", uni);
        esiti.put("bigrammi", bi);
        esiti.put("unibigrammi", unibi);
        return esiti;
    }


}
