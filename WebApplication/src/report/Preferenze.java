package report;

import classi.ValutazioneTipo2;
import classi.ValutazioneTipo3;

import java.util.HashMap;


public class Preferenze {

    // 1)  preferenza tra sistema e baseline 1
    public static HashMap<String, Double> sistemaVSbaseline1(){

        int framework = 0, baseline1 = 0;
        int indifferente = 0;
        int totale = 0;

        HashMap<String, Double> esiti = new HashMap<>();

        for (ValutazioneTipo2 v2 : Report.valutazioni2){

            totale++;
            if (v2.getPreferenza0() == 0){
                indifferente++;
            }
            else if (v2.getPreferenza0() == 1){
                framework++;
            }
            else if (v2.getPreferenza0() == 2){
                baseline1++;
            }
        }

        if (totale != 0){
            esiti.put("sistema", (double)framework/totale);
            esiti.put("baseline1", (double)baseline1/totale);
            esiti.put("indifferente", (double)indifferente/totale);
        }
        else {
            esiti.put("sistema", 0.0);
            esiti.put("baseline1", 0.0);
            esiti.put("indifferente", 0.0);
        }
        return esiti;
    }

    // 2)  preferenza tra sistema e baseline 2
    public static HashMap<String, Double> sistemaVSbaseline2(){

        int framework = 0, baselineDistr = 0;
        int indifferente = 0;
        int totale = 0;
        
        HashMap<String, Double> esiti = new HashMap<>();
        
        for (ValutazioneTipo3 v3 : Report.valutazioni3){

            totale++;
            if (v3.getPreferenza0() == 0){
                indifferente++;
            } 
            else if (v3.getPreferenza0() == 1){
            	framework++;
            } 
            else if (v3.getPreferenza0() == 2){
            	baselineDistr++;
            }
        }
        
        if (totale != 0){
            esiti.put("sistema", (double)framework/totale);
            esiti.put("baseline2", (double)baselineDistr/totale);
            esiti.put("indifferente", (double)indifferente/totale);
        } 
        else {
            esiti.put("sistema", 0.0);
            esiti.put("baseline2", 0.0);
            esiti.put("indifferente", 0.0);
        }
        return esiti;
    }

    // -------------------------------------------------------------------------------------
    
    // 3)  preferenza tra normale e baseline 1
    public static HashMap<String, Double> normaleVSbaseline1(){

        int framework = 0, baseline1 = 0;
        int indifferente = 0;
        int totale = 0;
        
        HashMap<String, Double> esiti = new HashMap<>();
        
        for (ValutazioneTipo2 v2 : Report.valutazioni2){
        	if(v2.getTecnica().equals("normale")) {
	            totale++;
	            if (v2.getPreferenza0() == 0){
	                indifferente++;
	            } 
	            else if (v2.getPreferenza0() == 1){
	            	framework++;
	            } 
	            else if (v2.getPreferenza0() == 2){
	            	baseline1++;
	            }
        	}
        }
        
        if (totale != 0){
            esiti.put("sistema", (double)framework/totale);
            esiti.put("baseline1", (double)baseline1/totale);
            esiti.put("indifferente", (double)indifferente/totale);
        } 
        else {
            esiti.put("sistema", 0.0);
            esiti.put("baseline1", 0.0);
            esiti.put("indifferente", 0.0);
        }
        return esiti;
    }

    // 4)  preferenza tra normale e baseline2
    public static HashMap<String, Double> normaleVSbaseline2(){

        int framework = 0, baseline2 = 0;
        int indifferente = 0;
        int totale = 0;

        HashMap<String, Double> esiti = new HashMap<>();

        for (ValutazioneTipo3 v3 : Report.valutazioni3){
            if(v3.getTecnica().equals("normale")) {
                totale++;
                if (v3.getPreferenza0() == 0){
                    indifferente++;
                }
                else if (v3.getPreferenza0() == 1){
                    framework++;
                }
                else if (v3.getPreferenza0() == 2){
                    baseline2++;
                }
            }
        }

        if (totale != 0){
            esiti.put("sistema", (double)framework/totale);
            esiti.put("baseline2", (double)baseline2/totale);
            esiti.put("indifferente", (double)indifferente/totale);
        }
        else {
            esiti.put("sistema", 0.0);
            esiti.put("baseline2", 0.0);
            esiti.put("indifferente", 0.0);
        }
        return esiti;
    }

    // 5)  preferenza tra pmi e baseline 1
    public static HashMap<String, Double> pmiVSbaseline1(){

        int framework = 0, baseline1 = 0;
        int indifferente = 0;
        int totale = 0;

        HashMap<String, Double> esiti = new HashMap<>();

        for (ValutazioneTipo2 v2 : Report.valutazioni2){
            if(v2.getTecnica().equals("pmi")) {
                totale++;
                if (v2.getPreferenza0() == 0){
                    indifferente++;
                }
                else if (v2.getPreferenza0() == 1){
                    framework++;
                }
                else if (v2.getPreferenza0() == 2){
                    baseline1++;
                }
            }
        }

        if (totale != 0){
            esiti.put("sistema", (double)framework/totale);
            esiti.put("baseline1", (double)baseline1/totale);
            esiti.put("indifferente", (double)indifferente/totale);
        }
        else {
            esiti.put("sistema", 0.0);
            esiti.put("baseline1", 0.0);
            esiti.put("indifferente", 0.0);
        }
        return esiti;
    }

    // 6)  preferenza tra pmi e baseline2
    public static HashMap<String, Double> pmiVSbaseline2(){

        int framework = 0, baseline2 = 0;
        int indifferente = 0;
        int totale = 0;

        HashMap<String, Double> esiti = new HashMap<>();

        for (ValutazioneTipo3 v3 : Report.valutazioni3){
            if(v3.getTecnica().equals("pmi")) {
                totale++;
                if (v3.getPreferenza0() == 0){
                    indifferente++;
                }
                else if (v3.getPreferenza0() == 1){
                    framework++;
                }
                else if (v3.getPreferenza0() == 2){
                    baseline2++;
                }
            }
        }

        if (totale != 0){
            esiti.put("sistema", (double)framework/totale);
            esiti.put("baseline2", (double)baseline2/totale);
            esiti.put("indifferente", (double)indifferente/totale);
        }
        else {
            esiti.put("sistema", 0.0);
            esiti.put("baseline2", 0.0);
            esiti.put("indifferente", 0.0);
        }
        return esiti;
    }

    // -------------------------------------------------------------------------------------

    // 7)  preferenze tra sistema e baseline1 in base ai lemmi
    public static HashMap<String, HashMap<String, Double>> sistemaVSbaseline1PreferenzeLemmi(){

        HashMap<String, HashMap<String, Double>> esiti = new HashMap<>();
        int  baseline1_Uni = 0, baseline1_Bi = 0, baseline1_UniBi = 0,
                sistemaUni = 0, sistemaBi = 0, sistemaUniBi = 0,
                indiffUni = 0, indiffBi = 0, indiffUniBi = 0,
                totaleUni = 0, totaleBi = 0, totaleUniBi = 0;

        for (ValutazioneTipo2 v2 : Report.valutazioni2){
            if (v2.getConfigurazione().equals("unigrammi")){
                totaleUni++;
                if (v2.getPreferenza0() == 1){
                    sistemaUni++;
                } else if (v2.getPreferenza0() == 2){
                    baseline1_Uni++;
                } else {
                    indiffUni++;
                }
            } else if (v2.getConfigurazione().equals("bigrammi")){
                totaleBi++;
                if (v2.getPreferenza0() == 1){
                    sistemaBi++;
                } else if (v2.getPreferenza0() == 2){
                    baseline1_Bi++;
                } else {
                    indiffBi++;
                }
            } else if (v2.getConfigurazione().equals("unibigrammi")){
                totaleUniBi++;
                if (v2.getPreferenza0() == 1){
                    sistemaUniBi++;
                } else if (v2.getPreferenza0() == 2){
                    baseline1_UniBi++;
                } else {
                    indiffUniBi++;
                }
            }
        }

        HashMap<String, Double> uni = new HashMap<>();
        HashMap<String, Double> bi = new HashMap<>();
        HashMap<String, Double> unibi = new HashMap<>();

        if (totaleUni != 0){
            uni.put("sistema", (double)sistemaUni/totaleUni);
            uni.put("baseline1", (double)baseline1_Uni/totaleUni);
            uni.put("indifferenti", (double)indiffUni/totaleUni);

        }
        else {
            uni.put("sistema", 0.0);
            uni.put("baseline1", 0.0);
            uni.put("indifferenti", 0.0);
        }

        if (totaleBi != 0){
            bi.put("sistema", (double)sistemaBi/totaleBi);
            bi.put("baseline1", (double)baseline1_Bi/totaleBi);
            bi.put("indifferenti", (double)indiffBi/totaleBi);
        }
        else {
            bi.put("sistema", 0.0);
            bi.put("baseline1", 0.0);
            bi.put("indifferenti", 0.0);
        }

        if (totaleUniBi != 0){
            unibi.put("sistema", (double)sistemaUniBi/totaleUniBi);
            unibi.put("baseline1", (double)baseline1_UniBi/totaleUniBi);
            unibi.put("indifferenti", (double)indiffUniBi/totaleUniBi);
        }
        else {
            unibi.put("sistema", 0.0);
            unibi.put("baseline1", 0.0);
            unibi.put("indifferenti", 0.0);
        }

        esiti.put("unigrammi", uni);
        esiti.put("bigrammi", bi);
        esiti.put("unibigrammi", unibi);
        return esiti;
    }

    // 8)  preferenze tra sistema e baseline2 in base ai lemmi
    public static HashMap<String, HashMap<String, Double>> sistemaVSbaseline2PreferenzeLemmi(){

        HashMap<String, HashMap<String, Double>> esiti = new HashMap<>();
        int  baseline2_Uni = 0, baseline2_Bi = 0, baseline2_UniBi = 0,
                sistemaUni = 0, sistemaBi = 0, sistemaUniBi = 0,
                indiffUni = 0, indiffBi = 0, indiffUniBi = 0,
                totaleUni = 0, totaleBi = 0, totaleUniBi = 0;

        for (ValutazioneTipo3 v3 : Report.valutazioni3){
            if (v3.getConfigurazione().equals("unigrammi")){
                totaleUni++;
                if (v3.getPreferenza0() == 1){
                    sistemaUni++;
                } else if (v3.getPreferenza0() == 2){
                    baseline2_Uni++;
                } else {
                    indiffUni++;
                }
            } else if (v3.getConfigurazione().equals("bigrammi")){
                totaleBi++;
                if (v3.getPreferenza0() == 1){
                    sistemaBi++;
                } else if (v3.getPreferenza0() == 2){
                    baseline2_Bi++;
                } else {
                    indiffBi++;
                }
            } else if (v3.getConfigurazione().equals("unibigrammi")){
                totaleUniBi++;
                if (v3.getPreferenza0() == 1){
                    sistemaUniBi++;
                } else if (v3.getPreferenza0() == 2){
                    baseline2_UniBi++;
                } else {
                    indiffUniBi++;
                }
            }
        }

        HashMap<String, Double> uni = new HashMap<>();
        HashMap<String, Double> bi = new HashMap<>();
        HashMap<String, Double> unibi = new HashMap<>();

        if (totaleUni != 0){
            uni.put("sistema", (double)sistemaUni/totaleUni);
            uni.put("baseline2", (double)baseline2_Uni/totaleUni);
            uni.put("indifferenti", (double)indiffUni/totaleUni);

        }
        else {
            uni.put("sistema", 0.0);
            uni.put("baseline2", 0.0);
            uni.put("indifferenti", 0.0);
        }

        if (totaleBi != 0){
            bi.put("sistema", (double)sistemaBi/totaleBi);
            bi.put("baseline2", (double)baseline2_Bi/totaleBi);
            bi.put("indifferenti", (double)indiffBi/totaleBi);
        }
        else {
            bi.put("sistema", 0.0);
            bi.put("baseline2", 0.0);
            bi.put("indifferenti", 0.0);
        }

        if (totaleUniBi != 0){
            unibi.put("sistema", (double)sistemaUniBi/totaleUniBi);
            unibi.put("baseline2", (double)baseline2_UniBi/totaleUniBi);
            unibi.put("indifferenti", (double)indiffUniBi/totaleUniBi);
        }
        else {
            unibi.put("sistema", 0.0);
            unibi.put("baseline2", 0.0);
            unibi.put("indifferenti", 0.0);
        }

        esiti.put("unigrammi", uni);
        esiti.put("bigrammi", bi);
        esiti.put("unibigrammi", unibi);
        return esiti;
    }

    // 9)  preferenze tra normale e baseline1 in base ai lemmi
    public static HashMap<String, HashMap<String, Double>> normaleVSbaseline1PreferenzeLemmi(){

        HashMap<String, HashMap<String, Double>> esiti = new HashMap<>();
        int  baseline1_Uni = 0, baseline1_Bi = 0, baseline1_UniBi = 0,
                sistemaUni = 0, sistemaBi = 0, sistemaUniBi = 0,
                indiffUni = 0, indiffBi = 0, indiffUniBi = 0,
                totaleUni = 0, totaleBi = 0, totaleUniBi = 0;

        for (ValutazioneTipo2 v2 : Report.valutazioni2){
            if (v2.getTecnica().equals("normale")) {
                if (v2.getConfigurazione().equals("unigrammi")) {
                    totaleUni++;
                    if (v2.getPreferenza0() == 1) {
                        sistemaUni++;
                    } else if (v2.getPreferenza0() == 2) {
                        baseline1_Uni++;
                    } else {
                        indiffUni++;
                    }
                } else if (v2.getConfigurazione().equals("bigrammi")) {
                    totaleBi++;
                    if (v2.getPreferenza0() == 1) {
                        sistemaBi++;
                    } else if (v2.getPreferenza0() == 2) {
                        baseline1_Bi++;
                    } else {
                        indiffBi++;
                    }
                } else if (v2.getConfigurazione().equals("unibigrammi")) {
                    totaleUniBi++;
                    if (v2.getPreferenza0() == 1) {
                        sistemaUniBi++;
                    } else if (v2.getPreferenza0() == 2) {
                        baseline1_UniBi++;
                    } else {
                        indiffUniBi++;
                    }
                }
            }
        }

        HashMap<String, Double> uni = new HashMap<>();
        HashMap<String, Double> bi = new HashMap<>();
        HashMap<String, Double> unibi = new HashMap<>();

        if (totaleUni != 0){
            uni.put("sistema", (double)sistemaUni/totaleUni);
            uni.put("baseline1", (double)baseline1_Uni/totaleUni);
            uni.put("indifferenti", (double)indiffUni/totaleUni);

        }
        else {
            uni.put("sistema", 0.0);
            uni.put("baseline1", 0.0);
            uni.put("indifferenti", 0.0);
        }

        if (totaleBi != 0){
            bi.put("sistema", (double)sistemaBi/totaleBi);
            bi.put("baseline1", (double)baseline1_Bi/totaleBi);
            bi.put("indifferenti", (double)indiffBi/totaleBi);
        }
        else {
            bi.put("sistema", 0.0);
            bi.put("baseline1", 0.0);
            bi.put("indifferenti", 0.0);
        }

        if (totaleUniBi != 0){
            unibi.put("sistema", (double)sistemaUniBi/totaleUniBi);
            unibi.put("baseline1", (double)baseline1_UniBi/totaleUniBi);
            unibi.put("indifferenti", (double)indiffUniBi/totaleUniBi);
        }
        else {
            unibi.put("sistema", 0.0);
            unibi.put("baseline1", 0.0);
            unibi.put("indifferenti", 0.0);
        }

        esiti.put("unigrammi", uni);
        esiti.put("bigrammi", bi);
        esiti.put("unibigrammi", unibi);
        return esiti;
    }

    // 10) preferenze tra normale e baseline2 in base ai lemmi
    public static HashMap<String, HashMap<String, Double>> normaleVSbaseline2PreferenzeLemmi(){

        HashMap<String, HashMap<String, Double>> esiti = new HashMap<>();
        int  baseline2_Uni = 0, baseline2_Bi = 0, baseline2_UniBi = 0,
                sistemaUni = 0, sistemaBi = 0, sistemaUniBi = 0,
                indiffUni = 0, indiffBi = 0, indiffUniBi = 0,
                totaleUni = 0, totaleBi = 0, totaleUniBi = 0;

        for (ValutazioneTipo3 v3 : Report.valutazioni3){
            if (v3.getTecnica().equals("normale")) {
                if (v3.getConfigurazione().equals("unigrammi")) {
                    totaleUni++;
                    if (v3.getPreferenza0() == 1) {
                        sistemaUni++;
                    } else if (v3.getPreferenza0() == 2) {
                        baseline2_Uni++;
                    } else {
                        indiffUni++;
                    }
                } else if (v3.getConfigurazione().equals("bigrammi")) {
                    totaleBi++;
                    if (v3.getPreferenza0() == 1) {
                        sistemaBi++;
                    } else if (v3.getPreferenza0() == 2) {
                        baseline2_Bi++;
                    } else {
                        indiffBi++;
                    }
                } else if (v3.getConfigurazione().equals("unibigrammi")) {
                    totaleUniBi++;
                    if (v3.getPreferenza0() == 1) {
                        sistemaUniBi++;
                    } else if (v3.getPreferenza0() == 2) {
                        baseline2_UniBi++;
                    } else {
                        indiffUniBi++;
                    }
                }
            }
        }

        HashMap<String, Double> uni = new HashMap<>();
        HashMap<String, Double> bi = new HashMap<>();
        HashMap<String, Double> unibi = new HashMap<>();

        if (totaleUni != 0){
            uni.put("sistema", (double)sistemaUni/totaleUni);
            uni.put("baseline2", (double)baseline2_Uni/totaleUni);
            uni.put("indifferenti", (double)indiffUni/totaleUni);

        }
        else {
            uni.put("sistema", 0.0);
            uni.put("baseline2", 0.0);
            uni.put("indifferenti", 0.0);
        }

        if (totaleBi != 0){
            bi.put("sistema", (double)sistemaBi/totaleBi);
            bi.put("baseline2", (double)baseline2_Bi/totaleBi);
            bi.put("indifferenti", (double)indiffBi/totaleBi);
        }
        else {
            bi.put("sistema", 0.0);
            bi.put("baseline2", 0.0);
            bi.put("indifferenti", 0.0);
        }

        if (totaleUniBi != 0){
            unibi.put("sistema", (double)sistemaUniBi/totaleUniBi);
            unibi.put("baseline2", (double)baseline2_UniBi/totaleUniBi);
            unibi.put("indifferenti", (double)indiffUniBi/totaleUniBi);
        }
        else {
            unibi.put("sistema", 0.0);
            unibi.put("baseline2", 0.0);
            unibi.put("indifferenti", 0.0);
        }

        esiti.put("unigrammi", uni);
        esiti.put("bigrammi", bi);
        esiti.put("unibigrammi", unibi);
        return esiti;
    }

    // 11) preferenze tra pmi e baseline1 in base ai lemmi
    public static HashMap<String, HashMap<String, Double>> pmiVSbaseline1PreferenzeLemmi(){

        HashMap<String, HashMap<String, Double>> esiti = new HashMap<>();
        int  baseline1_Uni = 0, baseline1_Bi = 0, baseline1_UniBi = 0,
                sistemaUni = 0, sistemaBi = 0, sistemaUniBi = 0,
                indiffUni = 0, indiffBi = 0, indiffUniBi = 0,
                totaleUni = 0, totaleBi = 0, totaleUniBi = 0;

        for (ValutazioneTipo2 v2 : Report.valutazioni2){
            if (v2.getTecnica().equals("pmi")) {
                if (v2.getConfigurazione().equals("unigrammi")) {
                    totaleUni++;
                    if (v2.getPreferenza0() == 1) {
                        sistemaUni++;
                    } else if (v2.getPreferenza0() == 2) {
                        baseline1_Uni++;
                    } else {
                        indiffUni++;
                    }
                } else if (v2.getConfigurazione().equals("bigrammi")) {
                    totaleBi++;
                    if (v2.getPreferenza0() == 1) {
                        sistemaBi++;
                    } else if (v2.getPreferenza0() == 2) {
                        baseline1_Bi++;
                    } else {
                        indiffBi++;
                    }
                } else if (v2.getConfigurazione().equals("unibigrammi")) {
                    totaleUniBi++;
                    if (v2.getPreferenza0() == 1) {
                        sistemaUniBi++;
                    } else if (v2.getPreferenza0() == 2) {
                        baseline1_UniBi++;
                    } else {
                        indiffUniBi++;
                    }
                }
            }
        }

        HashMap<String, Double> uni = new HashMap<>();
        HashMap<String, Double> bi = new HashMap<>();
        HashMap<String, Double> unibi = new HashMap<>();

        if (totaleUni != 0){
            uni.put("sistema", (double)sistemaUni/totaleUni);
            uni.put("baseline1", (double)baseline1_Uni/totaleUni);
            uni.put("indifferenti", (double)indiffUni/totaleUni);

        }
        else {
            uni.put("sistema", 0.0);
            uni.put("baseline1", 0.0);
            uni.put("indifferenti", 0.0);
        }

        if (totaleBi != 0){
            bi.put("sistema", (double)sistemaBi/totaleBi);
            bi.put("baseline1", (double)baseline1_Bi/totaleBi);
            bi.put("indifferenti", (double)indiffBi/totaleBi);
        }
        else {
            bi.put("sistema", 0.0);
            bi.put("baseline1", 0.0);
            bi.put("indifferenti", 0.0);
        }

        if (totaleUniBi != 0){
            unibi.put("sistema", (double)sistemaUniBi/totaleUniBi);
            unibi.put("baseline1", (double)baseline1_UniBi/totaleUniBi);
            unibi.put("indifferenti", (double)indiffUniBi/totaleUniBi);
        }
        else {
            unibi.put("sistema", 0.0);
            unibi.put("baseline1", 0.0);
            unibi.put("indifferenti", 0.0);
        }

        esiti.put("unigrammi", uni);
        esiti.put("bigrammi", bi);
        esiti.put("unibigrammi", unibi);
        return esiti;
    }

    // 12) preferenze tra pmi e baseline2 in base ai lemmi
    public static HashMap<String, HashMap<String, Double>> pmiVSbaseline2PreferenzeLemmi(){

        HashMap<String, HashMap<String, Double>> esiti = new HashMap<>();
        int  baseline2_Uni = 0, baseline2_Bi = 0, baseline2_UniBi = 0,
                sistemaUni = 0, sistemaBi = 0, sistemaUniBi = 0,
                indiffUni = 0, indiffBi = 0, indiffUniBi = 0,
                totaleUni = 0, totaleBi = 0, totaleUniBi = 0;

        for (ValutazioneTipo3 v3 : Report.valutazioni3){
            if (v3.getTecnica().equals("pmi")) {
                if (v3.getConfigurazione().equals("unigrammi")) {
                    totaleUni++;
                    if (v3.getPreferenza0() == 1) {
                        sistemaUni++;
                    } else if (v3.getPreferenza0() == 2) {
                        baseline2_Uni++;
                    } else {
                        indiffUni++;
                    }
                } else if (v3.getConfigurazione().equals("bigrammi")) {
                    totaleBi++;
                    if (v3.getPreferenza0() == 1) {
                        sistemaBi++;
                    } else if (v3.getPreferenza0() == 2) {
                        baseline2_Bi++;
                    } else {
                        indiffBi++;
                    }
                } else if (v3.getConfigurazione().equals("unibigrammi")) {
                    totaleUniBi++;
                    if (v3.getPreferenza0() == 1) {
                        sistemaUniBi++;
                    } else if (v3.getPreferenza0() == 2) {
                        baseline2_UniBi++;
                    } else {
                        indiffUniBi++;
                    }
                }
            }
        }

        HashMap<String, Double> uni = new HashMap<>();
        HashMap<String, Double> bi = new HashMap<>();
        HashMap<String, Double> unibi = new HashMap<>();

        if (totaleUni != 0){
            uni.put("sistema", (double)sistemaUni/totaleUni);
            uni.put("baseline2", (double)baseline2_Uni/totaleUni);
            uni.put("indifferenti", (double)indiffUni/totaleUni);

        }
        else {
            uni.put("sistema", 0.0);
            uni.put("baseline2", 0.0);
            uni.put("indifferenti", 0.0);
        }

        if (totaleBi != 0){
            bi.put("sistema", (double)sistemaBi/totaleBi);
            bi.put("baseline2", (double)baseline2_Bi/totaleBi);
            bi.put("indifferenti", (double)indiffBi/totaleBi);
        }
        else {
            bi.put("sistema", 0.0);
            bi.put("baseline2", 0.0);
            bi.put("indifferenti", 0.0);
        }

        if (totaleUniBi != 0){
            unibi.put("sistema", (double)sistemaUniBi/totaleUniBi);
            unibi.put("baseline2", (double)baseline2_UniBi/totaleUniBi);
            unibi.put("indifferenti", (double)indiffUniBi/totaleUniBi);
        }
        else {
            unibi.put("sistema", 0.0);
            unibi.put("baseline2", 0.0);
            unibi.put("indifferenti", 0.0);
        }

        esiti.put("unigrammi", uni);
        esiti.put("bigrammi", bi);
        esiti.put("unibigrammi", unibi);
        return esiti;
    }
        

    
}
