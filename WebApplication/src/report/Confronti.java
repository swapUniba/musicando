package report;

import classi.ValutazioneTipo2;
import classi.ValutazioneTipo3;

import java.util.HashMap;

/*
//////////////////////////////////////CONTRONTI VALUTAZIONI/////////////////////////////
7) confronto valutazioni metriche centroide e frasi singole;
8) confronto valutazioni metriche framework e baseline;
9) preferenze tra centroide e frasi singole in base al numero di contesti;
*/
public class Confronti {


    // 1) confronto tra metriche framework e baseline 1
    public static HashMap<String, HashMap<String, Double>> sistemaVSBaseline1Metriche() {

        HashMap<String, HashMap<String, Double>> uni = new HashMap<>();

        HashMap<String, Double> sistemaUni = new HashMap<>();
        HashMap<String, Double> baselineUni = new HashMap<>();
        HashMap<String, Double> indifferentiUni = new HashMap<>();

        baselineUni.put("Trasparenza", 0.0);
        baselineUni.put("Persuasione", 0.0);
        baselineUni.put("Coinvolgimento", 0.0);
        baselineUni.put("Fiducia", 0.0);

        sistemaUni.put("Trasparenza", 0.0);
        sistemaUni.put("Persuasione", 0.0);
        sistemaUni.put("Coinvolgimento", 0.0);
        sistemaUni.put("Fiducia", 0.0);

        indifferentiUni.put("Trasparenza", 0.0);
        indifferentiUni.put("Persuasione", 0.0);
        indifferentiUni.put("Coinvolgimento", 0.0);
        indifferentiUni.put("Fiducia", 0.0);

        int totaliUni = 0;

        for (ValutazioneTipo2 v2 : Report.valutazioni2) {


            totaliUni++;

            if (v2.getTrasparenza() == 1) {
                sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") + 1);
            } else if (v2.getTrasparenza() == 2) {
                baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") + 1);
            } else {
                indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") + 1);
            }

            if (v2.getPersuasione() == 1) {
                sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") + 1);
            } else if (v2.getPersuasione() == 2) {
                baselineUni.put("Persuasione", baselineUni.get("Persuasione") + 1);
            } else {
                indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") + 1);
            }

            if (v2.getCoinvolgimento() == 1) {
                sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") + 1);
            } else if (v2.getCoinvolgimento() == 2) {
                baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") + 1);
            } else {
                indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") + 1);
            }

            if (v2.getFiducia() == 1) {
                sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") + 1);
            } else if (v2.getFiducia() == 2) {
                baselineUni.put("Fiducia", baselineUni.get("Fiducia") + 1);
            } else {
                indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") + 1);
            }

        }

        //////////////////////////////////////////////////////////////
        if (totaliUni != 0) {
            sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") / totaliUni);
            sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") / totaliUni);
            sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") / totaliUni);
            sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") / totaliUni);

            baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") / totaliUni);
            baselineUni.put("Persuasione", baselineUni.get("Persuasione") / totaliUni);
            baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") / totaliUni);
            baselineUni.put("Fiducia", baselineUni.get("Fiducia") / totaliUni);

            indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") / totaliUni);
            indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") / totaliUni);
            indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") / totaliUni);
            indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") / totaliUni);
        }


        uni.put("sistema", sistemaUni);
        uni.put("baseline1", baselineUni);
        uni.put("indifferenti", indifferentiUni);

        for (String k : uni.keySet()){
            System.out.println("\t"+k);
            for (String v : uni.get(k).keySet()){
                System.out.println("\t\t"+uni.get(k).get(v));
            }
        }

        return uni;
    }

    // 2) confronto tra metriche framework (solo normale) e baseline 1
    public static HashMap<String, HashMap<String, Double>> sistemaVSBaseline1MetricheNormale() {

        HashMap<String, HashMap<String, Double>> uni = new HashMap<>();

        HashMap<String, Double> sistemaUni = new HashMap<>();
        HashMap<String, Double> baselineUni = new HashMap<>();
        HashMap<String, Double> indifferentiUni = new HashMap<>();

        baselineUni.put("Trasparenza", 0.0);
        baselineUni.put("Persuasione", 0.0);
        baselineUni.put("Coinvolgimento", 0.0);
        baselineUni.put("Fiducia", 0.0);

        sistemaUni.put("Trasparenza", 0.0);
        sistemaUni.put("Persuasione", 0.0);
        sistemaUni.put("Coinvolgimento", 0.0);
        sistemaUni.put("Fiducia", 0.0);

        indifferentiUni.put("Trasparenza", 0.0);
        indifferentiUni.put("Persuasione", 0.0);
        indifferentiUni.put("Coinvolgimento", 0.0);
        indifferentiUni.put("Fiducia", 0.0);

        int totaliUni = 0;

        for (ValutazioneTipo2 v2 : Report.valutazioni2) {

            if (v2.getTecnica().equals("normale")) {

                totaliUni++;

                if (v2.getTrasparenza() == 1) {
                    sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") + 1);
                } else if (v2.getTrasparenza() == 2) {
                    baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") + 1);
                } else {
                    indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") + 1);
                }

                if (v2.getPersuasione() == 1) {
                    sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") + 1);
                } else if (v2.getPersuasione() == 2) {
                    baselineUni.put("Persuasione", baselineUni.get("Persuasione") + 1);
                } else {
                    indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") + 1);
                }

                if (v2.getCoinvolgimento() == 1) {
                    sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") + 1);
                } else if (v2.getCoinvolgimento() == 2) {
                    baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") + 1);
                } else {
                    indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") + 1);
                }

                if (v2.getFiducia() == 1) {
                    sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") + 1);
                } else if (v2.getFiducia() == 2) {
                    baselineUni.put("Fiducia", baselineUni.get("Fiducia") + 1);
                } else {
                    indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") + 1);
                }
            }
        }

        //////////////////////////////////////////////////////////////
        if (totaliUni != 0) {
            sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") / totaliUni);
            sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") / totaliUni);
            sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") / totaliUni);
            sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") / totaliUni);

            baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") / totaliUni);
            baselineUni.put("Persuasione", baselineUni.get("Persuasione") / totaliUni);
            baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") / totaliUni);
            baselineUni.put("Fiducia", baselineUni.get("Fiducia") / totaliUni);

            indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") / totaliUni);
            indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") / totaliUni);
            indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") / totaliUni);
            indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") / totaliUni);
        }


        uni.put("sistema", sistemaUni);
        uni.put("baseline1", baselineUni);
        uni.put("indifferenti", indifferentiUni);

        return uni;
    }

    // 3) confronto tra metriche framework (solo pmi) e baseline 1
    public static HashMap<String, HashMap<String, Double>> sistemaVSBaseline1MetrichePMI() {

        HashMap<String, HashMap<String, Double>> uni = new HashMap<>();

        HashMap<String, Double> sistemaUni = new HashMap<>();
        HashMap<String, Double> baselineUni = new HashMap<>();
        HashMap<String, Double> indifferentiUni = new HashMap<>();

        baselineUni.put("Trasparenza", 0.0);
        baselineUni.put("Persuasione", 0.0);
        baselineUni.put("Coinvolgimento", 0.0);
        baselineUni.put("Fiducia", 0.0);

        sistemaUni.put("Trasparenza", 0.0);
        sistemaUni.put("Persuasione", 0.0);
        sistemaUni.put("Coinvolgimento", 0.0);
        sistemaUni.put("Fiducia", 0.0);

        indifferentiUni.put("Trasparenza", 0.0);
        indifferentiUni.put("Persuasione", 0.0);
        indifferentiUni.put("Coinvolgimento", 0.0);
        indifferentiUni.put("Fiducia", 0.0);

        int totaliUni = 0;

        for (ValutazioneTipo2 v2 : Report.valutazioni2) {

            if (v2.getTecnica().equals("pmi")) {

                totaliUni++;

                if (v2.getTrasparenza() == 1) {
                    sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") + 1);
                } else if (v2.getTrasparenza() == 2) {
                    baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") + 1);
                } else {
                    indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") + 1);
                }

                if (v2.getPersuasione() == 1) {
                    sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") + 1);
                } else if (v2.getPersuasione() == 2) {
                    baselineUni.put("Persuasione", baselineUni.get("Persuasione") + 1);
                } else {
                    indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") + 1);
                }

                if (v2.getCoinvolgimento() == 1) {
                    sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") + 1);
                } else if (v2.getCoinvolgimento() == 2) {
                    baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") + 1);
                } else {
                    indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") + 1);
                }

                if (v2.getFiducia() == 1) {
                    sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") + 1);
                } else if (v2.getFiducia() == 2) {
                    baselineUni.put("Fiducia", baselineUni.get("Fiducia") + 1);
                } else {
                    indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") + 1);
                }
            }
        }

        //////////////////////////////////////////////////////////////
        if (totaliUni != 0) {
            sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") / totaliUni);
            sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") / totaliUni);
            sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") / totaliUni);
            sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") / totaliUni);

            baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") / totaliUni);
            baselineUni.put("Persuasione", baselineUni.get("Persuasione") / totaliUni);
            baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") / totaliUni);
            baselineUni.put("Fiducia", baselineUni.get("Fiducia") / totaliUni);

            indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") / totaliUni);
            indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") / totaliUni);
            indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") / totaliUni);
            indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") / totaliUni);
        }


        uni.put("sistema", sistemaUni);
        uni.put("baseline1", baselineUni);
        uni.put("indifferenti", indifferentiUni);

        return uni;
    }

    // 4) confronto tra metriche framework e baseline 2
    public static HashMap<String, HashMap<String, Double>> sistemaVSBaseline2Metriche() {

        HashMap<String, HashMap<String, Double>> uni = new HashMap<>();

        HashMap<String, Double> sistemaUni = new HashMap<>();
        HashMap<String, Double> baselineUni = new HashMap<>();
        HashMap<String, Double> indifferentiUni = new HashMap<>();

        baselineUni.put("Trasparenza", 0.0);
        baselineUni.put("Persuasione", 0.0);
        baselineUni.put("Coinvolgimento", 0.0);
        baselineUni.put("Fiducia", 0.0);

        sistemaUni.put("Trasparenza", 0.0);
        sistemaUni.put("Persuasione", 0.0);
        sistemaUni.put("Coinvolgimento", 0.0);
        sistemaUni.put("Fiducia", 0.0);

        indifferentiUni.put("Trasparenza", 0.0);
        indifferentiUni.put("Persuasione", 0.0);
        indifferentiUni.put("Coinvolgimento", 0.0);
        indifferentiUni.put("Fiducia", 0.0);

        int totaliUni = 0;

        for (ValutazioneTipo3 v3 : Report.valutazioni3) {


            totaliUni++;

            if (v3.getTrasparenza() == 1) {
                sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") + 1);
            } else if (v3.getTrasparenza() == 2) {
                baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") + 1);
            } else {
                indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") + 1);
            }

            if (v3.getPersuasione() == 1) {
                sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") + 1);
            } else if (v3.getPersuasione() == 2) {
                baselineUni.put("Persuasione", baselineUni.get("Persuasione") + 1);
            } else {
                indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") + 1);
            }

            if (v3.getCoinvolgimento() == 1) {
                sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") + 1);
            } else if (v3.getCoinvolgimento() == 2) {
                baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") + 1);
            } else {
                indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") + 1);
            }

            if (v3.getFiducia() == 1) {
                sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") + 1);
            } else if (v3.getFiducia() == 2) {
                baselineUni.put("Fiducia", baselineUni.get("Fiducia") + 1);
            } else {
                indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") + 1);
            }

        }

        //////////////////////////////////////////////////////////////
        if (totaliUni != 0) {
            sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") / totaliUni);
            sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") / totaliUni);
            sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") / totaliUni);
            sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") / totaliUni);

            baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") / totaliUni);
            baselineUni.put("Persuasione", baselineUni.get("Persuasione") / totaliUni);
            baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") / totaliUni);
            baselineUni.put("Fiducia", baselineUni.get("Fiducia") / totaliUni);

            indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") / totaliUni);
            indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") / totaliUni);
            indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") / totaliUni);
            indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") / totaliUni);
        }


        uni.put("sistema", sistemaUni);
        uni.put("baseline2", baselineUni);
        uni.put("indifferenti", indifferentiUni);

        for (String k : uni.keySet()){
            System.out.println("\t"+k);
            for (String v : uni.get(k).keySet()){
                System.out.println("\t\t"+uni.get(k).get(v));
            }
        }

        return uni;
    }

    // 5) confronto tra metriche framework (solo normale) e baseline 2
    public static HashMap<String, HashMap<String, Double>> sistemaVSBaseline2MetricheNormale() {

        HashMap<String, HashMap<String, Double>> uni = new HashMap<>();

        HashMap<String, Double> sistemaUni = new HashMap<>();
        HashMap<String, Double> baselineUni = new HashMap<>();
        HashMap<String, Double> indifferentiUni = new HashMap<>();

        baselineUni.put("Trasparenza", 0.0);
        baselineUni.put("Persuasione", 0.0);
        baselineUni.put("Coinvolgimento", 0.0);
        baselineUni.put("Fiducia", 0.0);

        sistemaUni.put("Trasparenza", 0.0);
        sistemaUni.put("Persuasione", 0.0);
        sistemaUni.put("Coinvolgimento", 0.0);
        sistemaUni.put("Fiducia", 0.0);

        indifferentiUni.put("Trasparenza", 0.0);
        indifferentiUni.put("Persuasione", 0.0);
        indifferentiUni.put("Coinvolgimento", 0.0);
        indifferentiUni.put("Fiducia", 0.0);

        int totaliUni = 0;

        for (ValutazioneTipo3 v3 : Report.valutazioni3) {

            if (v3.getTecnica().equals("normale")) {

                totaliUni++;

                if (v3.getTrasparenza() == 1) {
                    sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") + 1);
                } else if (v3.getTrasparenza() == 2) {
                    baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") + 1);
                } else {
                    indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") + 1);
                }

                if (v3.getPersuasione() == 1) {
                    sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") + 1);
                } else if (v3.getPersuasione() == 2) {
                    baselineUni.put("Persuasione", baselineUni.get("Persuasione") + 1);
                } else {
                    indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") + 1);
                }

                if (v3.getCoinvolgimento() == 1) {
                    sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") + 1);
                } else if (v3.getCoinvolgimento() == 2) {
                    baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") + 1);
                } else {
                    indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") + 1);
                }

                if (v3.getFiducia() == 1) {
                    sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") + 1);
                } else if (v3.getFiducia() == 2) {
                    baselineUni.put("Fiducia", baselineUni.get("Fiducia") + 1);
                } else {
                    indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") + 1);
                }
            }
        }

        //////////////////////////////////////////////////////////////
        if (totaliUni != 0) {
            sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") / totaliUni);
            sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") / totaliUni);
            sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") / totaliUni);
            sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") / totaliUni);

            baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") / totaliUni);
            baselineUni.put("Persuasione", baselineUni.get("Persuasione") / totaliUni);
            baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") / totaliUni);
            baselineUni.put("Fiducia", baselineUni.get("Fiducia") / totaliUni);

            indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") / totaliUni);
            indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") / totaliUni);
            indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") / totaliUni);
            indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") / totaliUni);
        }


        uni.put("sistema", sistemaUni);
        uni.put("baseline2", baselineUni);
        uni.put("indifferenti", indifferentiUni);

        return uni;
    }

    // 6) confronto tra metriche framework (solo pmi) e baseline 2
    public static HashMap<String, HashMap<String, Double>> sistemaVSBaseline2MetrichePMI() {

        HashMap<String, HashMap<String, Double>> uni = new HashMap<>();

        HashMap<String, Double> sistemaUni = new HashMap<>();
        HashMap<String, Double> baselineUni = new HashMap<>();
        HashMap<String, Double> indifferentiUni = new HashMap<>();

        baselineUni.put("Trasparenza", 0.0);
        baselineUni.put("Persuasione", 0.0);
        baselineUni.put("Coinvolgimento", 0.0);
        baselineUni.put("Fiducia", 0.0);

        sistemaUni.put("Trasparenza", 0.0);
        sistemaUni.put("Persuasione", 0.0);
        sistemaUni.put("Coinvolgimento", 0.0);
        sistemaUni.put("Fiducia", 0.0);

        indifferentiUni.put("Trasparenza", 0.0);
        indifferentiUni.put("Persuasione", 0.0);
        indifferentiUni.put("Coinvolgimento", 0.0);
        indifferentiUni.put("Fiducia", 0.0);

        int totaliUni = 0;

        for (ValutazioneTipo3 v3 : Report.valutazioni3) {

            if (v3.getTecnica().equals("pmi")) {

                totaliUni++;

                if (v3.getTrasparenza() == 1) {
                    sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") + 1);
                } else if (v3.getTrasparenza() == 2) {
                    baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") + 1);
                } else {
                    indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") + 1);
                }

                if (v3.getPersuasione() == 1) {
                    sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") + 1);
                } else if (v3.getPersuasione() == 2) {
                    baselineUni.put("Persuasione", baselineUni.get("Persuasione") + 1);
                } else {
                    indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") + 1);
                }

                if (v3.getCoinvolgimento() == 1) {
                    sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") + 1);
                } else if (v3.getCoinvolgimento() == 2) {
                    baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") + 1);
                } else {
                    indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") + 1);
                }

                if (v3.getFiducia() == 1) {
                    sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") + 1);
                } else if (v3.getFiducia() == 2) {
                    baselineUni.put("Fiducia", baselineUni.get("Fiducia") + 1);
                } else {
                    indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") + 1);
                }
            }
        }

        //////////////////////////////////////////////////////////////
        if (totaliUni != 0) {
            sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") / totaliUni);
            sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") / totaliUni);
            sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") / totaliUni);
            sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") / totaliUni);

            baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") / totaliUni);
            baselineUni.put("Persuasione", baselineUni.get("Persuasione") / totaliUni);
            baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") / totaliUni);
            baselineUni.put("Fiducia", baselineUni.get("Fiducia") / totaliUni);

            indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") / totaliUni);
            indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") / totaliUni);
            indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") / totaliUni);
            indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") / totaliUni);
        }


        uni.put("sistema", sistemaUni);
        uni.put("baseline2", baselineUni);
        uni.put("indifferenti", indifferentiUni);

        return uni;
    }

    // ------------------------------------------------------------------------------------------

    // 4) confronto valutazioni metriche FRAMEWORK e BASELINE 1 per configurazione
    public static HashMap<String, HashMap<String, HashMap<String, Double>>> sistemaVSBaseline1MetricheLemmi() {

        HashMap<String, HashMap<String, HashMap<String, Double>>> esiti = new HashMap<>();

        HashMap<String, HashMap<String, Double>> uni = new HashMap<>();
        HashMap<String, HashMap<String, Double>> bi = new HashMap<>();
        HashMap<String, HashMap<String, Double>> unibi = new HashMap<>();

        HashMap<String, Double> sistemaUni = new HashMap<>();
        HashMap<String, Double> sistemaBi = new HashMap<>();
        HashMap<String, Double> sistemaUniBi = new HashMap<>();

        HashMap<String, Double> baselineUni = new HashMap<>();
        HashMap<String, Double> baselineBi = new HashMap<>();
        HashMap<String, Double> baselineUniBi = new HashMap<>();

        HashMap<String, Double> indifferentiUni = new HashMap<>();
        HashMap<String, Double> indifferentiBi = new HashMap<>();
        HashMap<String, Double> indifferentiUniBi = new HashMap<>();

        baselineUni.put("Trasparenza", 0.0);
        baselineUni.put("Persuasione", 0.0);
        baselineUni.put("Coinvolgimento", 0.0);
        baselineUni.put("Fiducia", 0.0);

        baselineBi.put("Trasparenza", 0.0);
        baselineBi.put("Persuasione", 0.0);
        baselineBi.put("Coinvolgimento", 0.0);
        baselineBi.put("Fiducia", 0.0);

        baselineUniBi.put("Trasparenza", 0.0);
        baselineUniBi.put("Persuasione", 0.0);
        baselineUniBi.put("Coinvolgimento", 0.0);
        baselineUniBi.put("Fiducia", 0.0);

        sistemaUni.put("Trasparenza", 0.0);
        sistemaUni.put("Persuasione", 0.0);
        sistemaUni.put("Coinvolgimento", 0.0);
        sistemaUni.put("Fiducia", 0.0);

        sistemaBi.put("Trasparenza", 0.0);
        sistemaBi.put("Persuasione", 0.0);
        sistemaBi.put("Coinvolgimento", 0.0);
        sistemaBi.put("Fiducia", 0.0);

        sistemaUniBi.put("Trasparenza", 0.0);
        sistemaUniBi.put("Persuasione", 0.0);
        sistemaUniBi.put("Coinvolgimento", 0.0);
        sistemaUniBi.put("Fiducia", 0.0);

        indifferentiUni.put("Trasparenza", 0.0);
        indifferentiUni.put("Persuasione", 0.0);
        indifferentiUni.put("Coinvolgimento", 0.0);
        indifferentiUni.put("Fiducia", 0.0);

        indifferentiBi.put("Trasparenza", 0.0);
        indifferentiBi.put("Persuasione", 0.0);
        indifferentiBi.put("Coinvolgimento", 0.0);
        indifferentiBi.put("Fiducia", 0.0);

        indifferentiUniBi.put("Trasparenza", 0.0);
        indifferentiUniBi.put("Persuasione", 0.0);
        indifferentiUniBi.put("Coinvolgimento", 0.0);
        indifferentiUniBi.put("Fiducia", 0.0);

        int totaliUni = 0, totaliBi = 0, totaliUniBi = 0;

        for (ValutazioneTipo2 v2 : Report.valutazioni2) {    // normale + pmi
            if (v2.getConfigurazione().equals("unigrammi")) {
                totaliUni++;
                if (v2.getTrasparenza() == 1) {
                    sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") + 1);
                } else if (v2.getTrasparenza() == 2) {
                    baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") + 1);
                } else {
                    indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") + 1);
                }

                if (v2.getPersuasione() == 1) {
                    sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") + 1);
                } else if (v2.getPersuasione() == 2) {
                    baselineUni.put("Persuasione", baselineUni.get("Persuasione") + 1);
                } else {
                    indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") + 1);
                }

                if (v2.getCoinvolgimento() == 1) {
                    sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") + 1);
                } else if (v2.getCoinvolgimento() == 2) {
                    baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") + 1);
                } else {
                    indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") + 1);
                }

                if (v2.getFiducia() == 1) {
                    sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") + 1);
                } else if (v2.getFiducia() == 2) {
                    baselineUni.put("Fiducia", baselineUni.get("Fiducia") + 1);
                } else {
                    indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") + 1);
                }

            } else if (v2.getConfigurazione().equals("bigrammi")) {
                totaliBi++;
                if (v2.getTrasparenza() == 1) {
                    sistemaBi.put("Trasparenza", sistemaBi.get("Trasparenza") + 1);
                } else if (v2.getTrasparenza() == 2) {
                    baselineBi.put("Trasparenza", baselineBi.get("Trasparenza") + 1);
                } else {
                    indifferentiBi.put("Trasparenza", indifferentiBi.get("Trasparenza") + 1);
                }

                if (v2.getPersuasione() == 1) {
                    sistemaBi.put("Persuasione", sistemaBi.get("Persuasione") + 1);
                } else if (v2.getPersuasione() == 2) {
                    baselineBi.put("Persuasione", baselineBi.get("Persuasione") + 1);
                } else {
                    indifferentiBi.put("Persuasione", indifferentiBi.get("Persuasione") + 1);

                }

                if (v2.getCoinvolgimento() == 1) {
                    sistemaBi.put("Coinvolgimento", sistemaBi.get("Coinvolgimento") + 1);
                } else if (v2.getCoinvolgimento() == 2) {
                    baselineBi.put("Coinvolgimento", baselineBi.get("Coinvolgimento") + 1);
                } else {
                    indifferentiBi.put("Coinvolgimento", indifferentiBi.get("Coinvolgimento") + 1);
                }

                if (v2.getFiducia() == 1) {
                    sistemaBi.put("Fiducia", sistemaBi.get("Fiducia") + 1);
                } else if (v2.getFiducia() == 2) {
                    baselineBi.put("Fiducia", baselineBi.get("Fiducia") + 1);
                } else {
                    indifferentiBi.put("Fiducia", indifferentiBi.get("Fiducia") + 1);
                }

            } else if (v2.getConfigurazione().equals("unibigrammi")) {
                totaliUniBi++;
                if (v2.getTrasparenza() == 1) {
                    sistemaUniBi.put("Trasparenza", sistemaUniBi.get("Trasparenza") + 1);
                } else if (v2.getTrasparenza() == 2) {
                    baselineUniBi.put("Trasparenza", baselineUniBi.get("Trasparenza") + 1);
                } else {
                    indifferentiUniBi.put("Trasparenza", indifferentiUniBi.get("Trasparenza") + 1);
                }

                if (v2.getPersuasione() == 1) {
                    sistemaUniBi.put("Persuasione", sistemaUniBi.get("Persuasione") + 1);
                } else if (v2.getPersuasione() == 2) {
                    baselineUniBi.put("Persuasione", baselineUniBi.get("Persuasione") + 1);
                } else {
                    indifferentiUniBi.put("Persuasione", indifferentiUniBi.get("Persuasione") + 1);
                }

                if (v2.getCoinvolgimento() == 1) {
                    sistemaUniBi.put("Coinvolgimento", sistemaUniBi.get("Coinvolgimento") + 1);
                } else if (v2.getCoinvolgimento() == 2) {
                    baselineUniBi.put("Coinvolgimento", baselineUniBi.get("Coinvolgimento") + 1);
                } else {
                    indifferentiUniBi.put("Coinvolgimento", indifferentiUniBi.get("Coinvolgimento") + 1);
                }

                if (v2.getFiducia() == 1) {
                    sistemaUniBi.put("Fiducia", sistemaUniBi.get("Fiducia") + 1);
                } else if (v2.getFiducia() == 2) {
                    baselineUniBi.put("Fiducia", baselineUniBi.get("Fiducia") + 1);
                } else {
                    indifferentiUniBi.put("Fiducia", indifferentiUniBi.get("Fiducia") + 1);
                }
            }
        }

        //////////////////////////////////////////////////////////////
        if (totaliUni != 0) {
            sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") / totaliUni);
            sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") / totaliUni);
            sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") / totaliUni);
            sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") / totaliUni);

            baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") / totaliUni);
            baselineUni.put("Persuasione", baselineUni.get("Persuasione") / totaliUni);
            baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") / totaliUni);
            baselineUni.put("Fiducia", baselineUni.get("Fiducia") / totaliUni);

            indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") / totaliUni);
            indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") / totaliUni);
            indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") / totaliUni);
            indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") / totaliUni);
        }
        /////////////////////
        if (totaliBi != 0) {
            sistemaBi.put("Trasparenza", sistemaBi.get("Trasparenza") / totaliBi);
            sistemaBi.put("Persuasione", sistemaBi.get("Persuasione") / totaliBi);
            sistemaBi.put("Coinvolgimento", sistemaBi.get("Coinvolgimento") / totaliBi);
            sistemaBi.put("Fiducia", sistemaBi.get("Fiducia") / totaliBi);

            baselineBi.put("Trasparenza", baselineBi.get("Trasparenza") / totaliBi);
            baselineBi.put("Persuasione", baselineBi.get("Persuasione") / totaliBi);
            baselineBi.put("Coinvolgimento", baselineBi.get("Coinvolgimento") / totaliBi);
            baselineBi.put("Fiducia", baselineBi.get("Fiducia") / totaliBi);

            indifferentiBi.put("Trasparenza", indifferentiBi.get("Trasparenza") / totaliBi);
            indifferentiBi.put("Persuasione", indifferentiBi.get("Persuasione") / totaliBi);
            indifferentiBi.put("Coinvolgimento", indifferentiBi.get("Coinvolgimento") / totaliBi);
            indifferentiBi.put("Fiducia", indifferentiBi.get("Fiducia") / totaliBi);
        }
        /////////////////////////////////
        if (totaliUniBi != 0) {
            sistemaUniBi.put("Trasparenza", sistemaUniBi.get("Trasparenza") / totaliUniBi);
            sistemaUniBi.put("Persuasione", sistemaUniBi.get("Persuasione") / totaliUniBi);
            sistemaUniBi.put("Coinvolgimento", sistemaUniBi.get("Coinvolgimento") / totaliUniBi);
            sistemaUniBi.put("Fiducia", sistemaUniBi.get("Fiducia") / totaliUniBi);

            baselineUniBi.put("Trasparenza", baselineUniBi.get("Trasparenza") / totaliUniBi);
            baselineUniBi.put("Persuasione", baselineUniBi.get("Persuasione") / totaliUniBi);
            baselineUniBi.put("Coinvolgimento", baselineUniBi.get("Coinvolgimento") / totaliUniBi);
            baselineUniBi.put("Fiducia", baselineUniBi.get("Fiducia") / totaliUniBi);

            indifferentiUniBi.put("Trasparenza", indifferentiUniBi.get("Trasparenza") / totaliUniBi);
            indifferentiUniBi.put("Persuasione", indifferentiUniBi.get("Persuasione") / totaliUniBi);
            indifferentiUniBi.put("Coinvolgimento", indifferentiUniBi.get("Coinvolgimento") / totaliUniBi);
            indifferentiUniBi.put("Fiducia", indifferentiUniBi.get("Fiducia") / totaliUniBi);
        }

        uni.put("sistema", sistemaUni);
        uni.put("baseline1", baselineUni);
        uni.put("indifferenti", indifferentiUni);

        bi.put("sistema", sistemaBi);
        bi.put("baseline1", baselineBi);
        bi.put("indifferenti", indifferentiBi);

        unibi.put("sistema", sistemaUniBi);
        unibi.put("baseline1", baselineUniBi);
        unibi.put("indifferenti", indifferentiUniBi);
        ////////////////////////////////////////////////////
        esiti.put("unigrammi", uni);
        esiti.put("bigrammi", bi);
        esiti.put("unibigrammi", unibi);

        return esiti;
    }

    // 5) confronto valutazioni metriche FRAMEWORK (solo normale) e BASELINE 1 per configurazione
    public static HashMap<String, HashMap<String, HashMap<String, Double>>> sistemaVSBaseline1MetricheNormaleLemmi() {
        HashMap<String, HashMap<String, HashMap<String, Double>>> esiti = new HashMap<>();

        HashMap<String, HashMap<String, Double>> uni = new HashMap<>();
        HashMap<String, HashMap<String, Double>> bi = new HashMap<>();
        HashMap<String, HashMap<String, Double>> unibi = new HashMap<>();

        HashMap<String, Double> sistemaUni = new HashMap<>();
        HashMap<String, Double> sistemaBi = new HashMap<>();
        HashMap<String, Double> sistemaUniBi = new HashMap<>();

        HashMap<String, Double> baselineUni = new HashMap<>();
        HashMap<String, Double> baselineBi = new HashMap<>();
        HashMap<String, Double> baselineUniBi = new HashMap<>();

        HashMap<String, Double> indifferentiUni = new HashMap<>();
        HashMap<String, Double> indifferentiBi = new HashMap<>();
        HashMap<String, Double> indifferentiUniBi = new HashMap<>();

        baselineUni.put("Trasparenza", 0.0);
        baselineUni.put("Persuasione", 0.0);
        baselineUni.put("Coinvolgimento", 0.0);
        baselineUni.put("Fiducia", 0.0);

        baselineBi.put("Trasparenza", 0.0);
        baselineBi.put("Persuasione", 0.0);
        baselineBi.put("Coinvolgimento", 0.0);
        baselineBi.put("Fiducia", 0.0);

        baselineUniBi.put("Trasparenza", 0.0);
        baselineUniBi.put("Persuasione", 0.0);
        baselineUniBi.put("Coinvolgimento", 0.0);
        baselineUniBi.put("Fiducia", 0.0);

        sistemaUni.put("Trasparenza", 0.0);
        sistemaUni.put("Persuasione", 0.0);
        sistemaUni.put("Coinvolgimento", 0.0);
        sistemaUni.put("Fiducia", 0.0);

        sistemaBi.put("Trasparenza", 0.0);
        sistemaBi.put("Persuasione", 0.0);
        sistemaBi.put("Coinvolgimento", 0.0);
        sistemaBi.put("Fiducia", 0.0);

        sistemaUniBi.put("Trasparenza", 0.0);
        sistemaUniBi.put("Persuasione", 0.0);
        sistemaUniBi.put("Coinvolgimento", 0.0);
        sistemaUniBi.put("Fiducia", 0.0);

        indifferentiUni.put("Trasparenza", 0.0);
        indifferentiUni.put("Persuasione", 0.0);
        indifferentiUni.put("Coinvolgimento", 0.0);
        indifferentiUni.put("Fiducia", 0.0);

        indifferentiBi.put("Trasparenza", 0.0);
        indifferentiBi.put("Persuasione", 0.0);
        indifferentiBi.put("Coinvolgimento", 0.0);
        indifferentiBi.put("Fiducia", 0.0);

        indifferentiUniBi.put("Trasparenza", 0.0);
        indifferentiUniBi.put("Persuasione", 0.0);
        indifferentiUniBi.put("Coinvolgimento", 0.0);
        indifferentiUniBi.put("Fiducia", 0.0);

        int totaliUni = 0, totaliBi = 0, totaliUniBi = 0;

        for (ValutazioneTipo2 v2 : Report.valutazioni2) {    //INDISTINTAMENTE CENTROIDE FRASI SINGOLE
            if (v2.getTecnica().equals("normale")) {
                if (v2.getConfigurazione().equals("unigrammi")) {
                    totaliUni++;
                    if (v2.getTrasparenza() == 1) {
                        sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") + 1);
                    } else if (v2.getTrasparenza() == 2) {
                        baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") + 1);
                    } else {
                        indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") + 1);
                    }

                    if (v2.getPersuasione() == 1) {
                        sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") + 1);
                    } else if (v2.getPersuasione() == 2) {
                        baselineUni.put("Persuasione", baselineUni.get("Persuasione") + 1);
                    } else {
                        indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") + 1);
                    }

                    if (v2.getCoinvolgimento() == 1) {
                        sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") + 1);
                    } else if (v2.getCoinvolgimento() == 2) {
                        baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") + 1);
                    } else {
                        indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") + 1);
                    }

                    if (v2.getFiducia() == 1) {
                        sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") + 1);
                    } else if (v2.getFiducia() == 2) {
                        baselineUni.put("Fiducia", baselineUni.get("Fiducia") + 1);
                    } else {
                        indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") + 1);
                    }

                } else if (v2.getConfigurazione().equals("bigrammi")) {
                    totaliBi++;
                    if (v2.getTrasparenza() == 1) {
                        sistemaBi.put("Trasparenza", sistemaBi.get("Trasparenza") + 1);
                    } else if (v2.getTrasparenza() == 2) {
                        baselineBi.put("Trasparenza", baselineBi.get("Trasparenza") + 1);
                    } else {
                        indifferentiBi.put("Trasparenza", indifferentiBi.get("Trasparenza") + 1);
                    }

                    if (v2.getPersuasione() == 1) {
                        sistemaBi.put("Persuasione", sistemaBi.get("Persuasione") + 1);
                    } else if (v2.getPersuasione() == 2) {
                        baselineBi.put("Persuasione", baselineBi.get("Persuasione") + 1);
                    } else {
                        indifferentiBi.put("Persuasione", indifferentiBi.get("Persuasione") + 1);

                    }

                    if (v2.getCoinvolgimento() == 1) {
                        sistemaBi.put("Coinvolgimento", sistemaBi.get("Coinvolgimento") + 1);
                    } else if (v2.getCoinvolgimento() == 2) {
                        baselineBi.put("Coinvolgimento", baselineBi.get("Coinvolgimento") + 1);
                    } else {
                        indifferentiBi.put("Coinvolgimento", indifferentiBi.get("Coinvolgimento") + 1);
                    }

                    if (v2.getFiducia() == 1) {
                        sistemaBi.put("Fiducia", sistemaBi.get("Fiducia") + 1);
                    } else if (v2.getFiducia() == 2) {
                        baselineBi.put("Fiducia", baselineBi.get("Fiducia") + 1);
                    } else {
                        indifferentiBi.put("Fiducia", indifferentiBi.get("Fiducia") + 1);
                    }

                } else if (v2.getConfigurazione().equals("unibigrammi")) {
                    totaliUniBi++;
                    if (v2.getTrasparenza() == 1) {
                        sistemaUniBi.put("Trasparenza", sistemaUniBi.get("Trasparenza") + 1);
                    } else if (v2.getTrasparenza() == 2) {
                        baselineUniBi.put("Trasparenza", baselineUniBi.get("Trasparenza") + 1);
                    } else {
                        indifferentiUniBi.put("Trasparenza", indifferentiUniBi.get("Trasparenza") + 1);
                    }

                    if (v2.getPersuasione() == 1) {
                        sistemaUniBi.put("Persuasione", sistemaUniBi.get("Persuasione") + 1);
                    } else if (v2.getPersuasione() == 2) {
                        baselineUniBi.put("Persuasione", baselineUniBi.get("Persuasione") + 1);
                    } else {
                        indifferentiUniBi.put("Persuasione", indifferentiUniBi.get("Persuasione") + 1);
                    }

                    if (v2.getCoinvolgimento() == 1) {
                        sistemaUniBi.put("Coinvolgimento", sistemaUniBi.get("Coinvolgimento") + 1);
                    } else if (v2.getCoinvolgimento() == 2) {
                        baselineUniBi.put("Coinvolgimento", baselineUniBi.get("Coinvolgimento") + 1);
                    } else {
                        indifferentiUniBi.put("Coinvolgimento", indifferentiUniBi.get("Coinvolgimento") + 1);
                    }

                    if (v2.getFiducia() == 1) {
                        sistemaUniBi.put("Fiducia", sistemaUniBi.get("Fiducia") + 1);
                    } else if (v2.getFiducia() == 2) {
                        baselineUniBi.put("Fiducia", baselineUniBi.get("Fiducia") + 1);
                    } else {
                        indifferentiUniBi.put("Fiducia", indifferentiUniBi.get("Fiducia") + 1);
                    }
                }

            }
        }

        //////////////////////////////////////////////////////////////
        if (totaliUni != 0) {
            sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") / totaliUni);
            sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") / totaliUni);
            sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") / totaliUni);
            sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") / totaliUni);

            baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") / totaliUni);
            baselineUni.put("Persuasione", baselineUni.get("Persuasione") / totaliUni);
            baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") / totaliUni);
            baselineUni.put("Fiducia", baselineUni.get("Fiducia") / totaliUni);

            indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") / totaliUni);
            indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") / totaliUni);
            indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") / totaliUni);
            indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") / totaliUni);
        }
        /////////////////////
        if (totaliBi != 0) {
            sistemaBi.put("Trasparenza", sistemaBi.get("Trasparenza") / totaliBi);
            sistemaBi.put("Persuasione", sistemaBi.get("Persuasione") / totaliBi);
            sistemaBi.put("Coinvolgimento", sistemaBi.get("Coinvolgimento") / totaliBi);
            sistemaBi.put("Fiducia", sistemaBi.get("Fiducia") / totaliBi);

            baselineBi.put("Trasparenza", baselineBi.get("Trasparenza") / totaliBi);
            baselineBi.put("Persuasione", baselineBi.get("Persuasione") / totaliBi);
            baselineBi.put("Coinvolgimento", baselineBi.get("Coinvolgimento") / totaliBi);
            baselineBi.put("Fiducia", baselineBi.get("Fiducia") / totaliBi);

            indifferentiBi.put("Trasparenza", indifferentiBi.get("Trasparenza") / totaliBi);
            indifferentiBi.put("Persuasione", indifferentiBi.get("Persuasione") / totaliBi);
            indifferentiBi.put("Coinvolgimento", indifferentiBi.get("Coinvolgimento") / totaliBi);
            indifferentiBi.put("Fiducia", indifferentiBi.get("Fiducia") / totaliBi);
        }
        /////////////////////////////////
        if (totaliUniBi != 0) {
            sistemaUniBi.put("Trasparenza", sistemaUniBi.get("Trasparenza") / totaliUniBi);
            sistemaUniBi.put("Persuasione", sistemaUniBi.get("Persuasione") / totaliUniBi);
            sistemaUniBi.put("Coinvolgimento", sistemaUniBi.get("Coinvolgimento") / totaliUniBi);
            sistemaUniBi.put("Fiducia", sistemaUniBi.get("Fiducia") / totaliUniBi);

            baselineUniBi.put("Trasparenza", baselineUniBi.get("Trasparenza") / totaliUniBi);
            baselineUniBi.put("Persuasione", baselineUniBi.get("Persuasione") / totaliUniBi);
            baselineUniBi.put("Coinvolgimento", baselineUniBi.get("Coinvolgimento") / totaliUniBi);
            baselineUniBi.put("Fiducia", baselineUniBi.get("Fiducia") / totaliUniBi);

            indifferentiUniBi.put("Trasparenza", indifferentiUniBi.get("Trasparenza") / totaliUniBi);
            indifferentiUniBi.put("Persuasione", indifferentiUniBi.get("Persuasione") / totaliUniBi);
            indifferentiUniBi.put("Coinvolgimento", indifferentiUniBi.get("Coinvolgimento") / totaliUniBi);
            indifferentiUniBi.put("Fiducia", indifferentiUniBi.get("Fiducia") / totaliUniBi);
        }

        uni.put("sistema", sistemaUni);
        uni.put("baseline1", baselineUni);
        uni.put("indifferenti", indifferentiUni);

        bi.put("sistema", sistemaBi);
        bi.put("baseline1", baselineBi);
        bi.put("indifferenti", indifferentiBi);

        unibi.put("sistema", sistemaUniBi);
        unibi.put("baseline1", baselineUniBi);
        unibi.put("indifferenti", indifferentiUniBi);
        ////////////////////////////////////////////////////
        esiti.put("unigrammi", uni);
        esiti.put("bigrammi", bi);
        esiti.put("unibigrammi", unibi);

        return esiti;
    }

    // 6) confronto valutazioni metriche FRAMEWORK (solo pmi) e BASELINE 1 per configurazione
    public static HashMap<String, HashMap<String, HashMap<String, Double>>> sistemaVSBaseline1MetrichePMILemmi() {
        HashMap<String, HashMap<String, HashMap<String, Double>>> esiti = new HashMap<>();

        HashMap<String, HashMap<String, Double>> uni = new HashMap<>();
        HashMap<String, HashMap<String, Double>> bi = new HashMap<>();
        HashMap<String, HashMap<String, Double>> unibi = new HashMap<>();

        HashMap<String, Double> sistemaUni = new HashMap<>();
        HashMap<String, Double> sistemaBi = new HashMap<>();
        HashMap<String, Double> sistemaUniBi = new HashMap<>();

        HashMap<String, Double> baselineUni = new HashMap<>();
        HashMap<String, Double> baselineBi = new HashMap<>();
        HashMap<String, Double> baselineUniBi = new HashMap<>();

        HashMap<String, Double> indifferentiUni = new HashMap<>();
        HashMap<String, Double> indifferentiBi = new HashMap<>();
        HashMap<String, Double> indifferentiUniBi = new HashMap<>();

        baselineUni.put("Trasparenza", 0.0);
        baselineUni.put("Persuasione", 0.0);
        baselineUni.put("Coinvolgimento", 0.0);
        baselineUni.put("Fiducia", 0.0);

        baselineBi.put("Trasparenza", 0.0);
        baselineBi.put("Persuasione", 0.0);
        baselineBi.put("Coinvolgimento", 0.0);
        baselineBi.put("Fiducia", 0.0);

        baselineUniBi.put("Trasparenza", 0.0);
        baselineUniBi.put("Persuasione", 0.0);
        baselineUniBi.put("Coinvolgimento", 0.0);
        baselineUniBi.put("Fiducia", 0.0);

        sistemaUni.put("Trasparenza", 0.0);
        sistemaUni.put("Persuasione", 0.0);
        sistemaUni.put("Coinvolgimento", 0.0);
        sistemaUni.put("Fiducia", 0.0);

        sistemaBi.put("Trasparenza", 0.0);
        sistemaBi.put("Persuasione", 0.0);
        sistemaBi.put("Coinvolgimento", 0.0);
        sistemaBi.put("Fiducia", 0.0);

        sistemaUniBi.put("Trasparenza", 0.0);
        sistemaUniBi.put("Persuasione", 0.0);
        sistemaUniBi.put("Coinvolgimento", 0.0);
        sistemaUniBi.put("Fiducia", 0.0);

        indifferentiUni.put("Trasparenza", 0.0);
        indifferentiUni.put("Persuasione", 0.0);
        indifferentiUni.put("Coinvolgimento", 0.0);
        indifferentiUni.put("Fiducia", 0.0);

        indifferentiBi.put("Trasparenza", 0.0);
        indifferentiBi.put("Persuasione", 0.0);
        indifferentiBi.put("Coinvolgimento", 0.0);
        indifferentiBi.put("Fiducia", 0.0);

        indifferentiUniBi.put("Trasparenza", 0.0);
        indifferentiUniBi.put("Persuasione", 0.0);
        indifferentiUniBi.put("Coinvolgimento", 0.0);
        indifferentiUniBi.put("Fiducia", 0.0);

        int totaliUni = 0, totaliBi = 0, totaliUniBi = 0;

        for (ValutazioneTipo2 v2 : Report.valutazioni2) {    //INDISTINTAMENTE CENTROIDE FRASI SINGOLE
            if (v2.getTecnica().equals("pmi")) {
                if (v2.getConfigurazione().equals("unigrammi")) {
                    totaliUni++;
                    if (v2.getTrasparenza() == 1) {
                        sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") + 1);
                    } else if (v2.getTrasparenza() == 2) {
                        baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") + 1);
                    } else {
                        indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") + 1);
                    }

                    if (v2.getPersuasione() == 1) {
                        sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") + 1);
                    } else if (v2.getPersuasione() == 2) {
                        baselineUni.put("Persuasione", baselineUni.get("Persuasione") + 1);
                    } else {
                        indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") + 1);
                    }

                    if (v2.getCoinvolgimento() == 1) {
                        sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") + 1);
                    } else if (v2.getCoinvolgimento() == 2) {
                        baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") + 1);
                    } else {
                        indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") + 1);
                    }

                    if (v2.getFiducia() == 1) {
                        sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") + 1);
                    } else if (v2.getFiducia() == 2) {
                        baselineUni.put("Fiducia", baselineUni.get("Fiducia") + 1);
                    } else {
                        indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") + 1);
                    }

                } else if (v2.getConfigurazione().equals("bigrammi")) {
                    totaliBi++;
                    if (v2.getTrasparenza() == 1) {
                        sistemaBi.put("Trasparenza", sistemaBi.get("Trasparenza") + 1);
                    } else if (v2.getTrasparenza() == 2) {
                        baselineBi.put("Trasparenza", baselineBi.get("Trasparenza") + 1);
                    } else {
                        indifferentiBi.put("Trasparenza", indifferentiBi.get("Trasparenza") + 1);
                    }

                    if (v2.getPersuasione() == 1) {
                        sistemaBi.put("Persuasione", sistemaBi.get("Persuasione") + 1);
                    } else if (v2.getPersuasione() == 2) {
                        baselineBi.put("Persuasione", baselineBi.get("Persuasione") + 1);
                    } else {
                        indifferentiBi.put("Persuasione", indifferentiBi.get("Persuasione") + 1);

                    }

                    if (v2.getCoinvolgimento() == 1) {
                        sistemaBi.put("Coinvolgimento", sistemaBi.get("Coinvolgimento") + 1);
                    } else if (v2.getCoinvolgimento() == 2) {
                        baselineBi.put("Coinvolgimento", baselineBi.get("Coinvolgimento") + 1);
                    } else {
                        indifferentiBi.put("Coinvolgimento", indifferentiBi.get("Coinvolgimento") + 1);
                    }

                    if (v2.getFiducia() == 1) {
                        sistemaBi.put("Fiducia", sistemaBi.get("Fiducia") + 1);
                    } else if (v2.getFiducia() == 2) {
                        baselineBi.put("Fiducia", baselineBi.get("Fiducia") + 1);
                    } else {
                        indifferentiBi.put("Fiducia", indifferentiBi.get("Fiducia") + 1);
                    }

                } else if (v2.getConfigurazione().equals("unibigrammi")) {
                    totaliUniBi++;
                    if (v2.getTrasparenza() == 1) {
                        sistemaUniBi.put("Trasparenza", sistemaUniBi.get("Trasparenza") + 1);
                    } else if (v2.getTrasparenza() == 2) {
                        baselineUniBi.put("Trasparenza", baselineUniBi.get("Trasparenza") + 1);
                    } else {
                        indifferentiUniBi.put("Trasparenza", indifferentiUniBi.get("Trasparenza") + 1);
                    }

                    if (v2.getPersuasione() == 1) {
                        sistemaUniBi.put("Persuasione", sistemaUniBi.get("Persuasione") + 1);
                    } else if (v2.getPersuasione() == 2) {
                        baselineUniBi.put("Persuasione", baselineUniBi.get("Persuasione") + 1);
                    } else {
                        indifferentiUniBi.put("Persuasione", indifferentiUniBi.get("Persuasione") + 1);
                    }

                    if (v2.getCoinvolgimento() == 1) {
                        sistemaUniBi.put("Coinvolgimento", sistemaUniBi.get("Coinvolgimento") + 1);
                    } else if (v2.getCoinvolgimento() == 2) {
                        baselineUniBi.put("Coinvolgimento", baselineUniBi.get("Coinvolgimento") + 1);
                    } else {
                        indifferentiUniBi.put("Coinvolgimento", indifferentiUniBi.get("Coinvolgimento") + 1);
                    }

                    if (v2.getFiducia() == 1) {
                        sistemaUniBi.put("Fiducia", sistemaUniBi.get("Fiducia") + 1);
                    } else if (v2.getFiducia() == 2) {
                        baselineUniBi.put("Fiducia", baselineUniBi.get("Fiducia") + 1);
                    } else {
                        indifferentiUniBi.put("Fiducia", indifferentiUniBi.get("Fiducia") + 1);
                    }
                }

            }
        }

        //////////////////////////////////////////////////////////////
        if (totaliUni != 0) {
            sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") / totaliUni);
            sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") / totaliUni);
            sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") / totaliUni);
            sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") / totaliUni);

            baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") / totaliUni);
            baselineUni.put("Persuasione", baselineUni.get("Persuasione") / totaliUni);
            baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") / totaliUni);
            baselineUni.put("Fiducia", baselineUni.get("Fiducia") / totaliUni);

            indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") / totaliUni);
            indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") / totaliUni);
            indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") / totaliUni);
            indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") / totaliUni);
        }
        /////////////////////
        if (totaliBi != 0) {
            sistemaBi.put("Trasparenza", sistemaBi.get("Trasparenza") / totaliBi);
            sistemaBi.put("Persuasione", sistemaBi.get("Persuasione") / totaliBi);
            sistemaBi.put("Coinvolgimento", sistemaBi.get("Coinvolgimento") / totaliBi);
            sistemaBi.put("Fiducia", sistemaBi.get("Fiducia") / totaliBi);

            baselineBi.put("Trasparenza", baselineBi.get("Trasparenza") / totaliBi);
            baselineBi.put("Persuasione", baselineBi.get("Persuasione") / totaliBi);
            baselineBi.put("Coinvolgimento", baselineBi.get("Coinvolgimento") / totaliBi);
            baselineBi.put("Fiducia", baselineBi.get("Fiducia") / totaliBi);

            indifferentiBi.put("Trasparenza", indifferentiBi.get("Trasparenza") / totaliBi);
            indifferentiBi.put("Persuasione", indifferentiBi.get("Persuasione") / totaliBi);
            indifferentiBi.put("Coinvolgimento", indifferentiBi.get("Coinvolgimento") / totaliBi);
            indifferentiBi.put("Fiducia", indifferentiBi.get("Fiducia") / totaliBi);
        }
        /////////////////////////////////
        if (totaliUniBi != 0) {
            sistemaUniBi.put("Trasparenza", sistemaUniBi.get("Trasparenza") / totaliUniBi);
            sistemaUniBi.put("Persuasione", sistemaUniBi.get("Persuasione") / totaliUniBi);
            sistemaUniBi.put("Coinvolgimento", sistemaUniBi.get("Coinvolgimento") / totaliUniBi);
            sistemaUniBi.put("Fiducia", sistemaUniBi.get("Fiducia") / totaliUniBi);

            baselineUniBi.put("Trasparenza", baselineUniBi.get("Trasparenza") / totaliUniBi);
            baselineUniBi.put("Persuasione", baselineUniBi.get("Persuasione") / totaliUniBi);
            baselineUniBi.put("Coinvolgimento", baselineUniBi.get("Coinvolgimento") / totaliUniBi);
            baselineUniBi.put("Fiducia", baselineUniBi.get("Fiducia") / totaliUniBi);

            indifferentiUniBi.put("Trasparenza", indifferentiUniBi.get("Trasparenza") / totaliUniBi);
            indifferentiUniBi.put("Persuasione", indifferentiUniBi.get("Persuasione") / totaliUniBi);
            indifferentiUniBi.put("Coinvolgimento", indifferentiUniBi.get("Coinvolgimento") / totaliUniBi);
            indifferentiUniBi.put("Fiducia", indifferentiUniBi.get("Fiducia") / totaliUniBi);
        }

        uni.put("sistema", sistemaUni);
        uni.put("baseline1", baselineUni);
        uni.put("indifferenti", indifferentiUni);

        bi.put("sistema", sistemaBi);
        bi.put("baseline1", baselineBi);
        bi.put("indifferenti", indifferentiBi);

        unibi.put("sistema", sistemaUniBi);
        unibi.put("baseline1", baselineUniBi);
        unibi.put("indifferenti", indifferentiUniBi);
        ////////////////////////////////////////////////////
        esiti.put("unigrammi", uni);
        esiti.put("bigrammi", bi);
        esiti.put("unibigrammi", unibi);

        return esiti;
    }

    // 7) confronto valutazioni metriche FRAMEWORK e BASELINE 2 per configurazione
    public static HashMap<String, HashMap<String, HashMap<String, Double>>> sistemaVSbaseline2MetricheLemmi() {

        HashMap<String, HashMap<String, HashMap<String, Double>>> esiti = new HashMap<>();

        HashMap<String, HashMap<String, Double>> uni = new HashMap<>();
        HashMap<String, HashMap<String, Double>> bi = new HashMap<>();
        HashMap<String, HashMap<String, Double>> unibi = new HashMap<>();

        HashMap<String, Double> sistemaUni = new HashMap<>();
        HashMap<String, Double> sistemaBi = new HashMap<>();
        HashMap<String, Double> sistemaUniBi = new HashMap<>();

        HashMap<String, Double> baselineUni = new HashMap<>();
        HashMap<String, Double> baselineBi = new HashMap<>();
        HashMap<String, Double> baselineUniBi = new HashMap<>();

        HashMap<String, Double> indifferentiUni = new HashMap<>();
        HashMap<String, Double> indifferentiBi = new HashMap<>();
        HashMap<String, Double> indifferentiUniBi = new HashMap<>();

        baselineUni.put("Trasparenza", 0.0);
        baselineUni.put("Persuasione", 0.0);
        baselineUni.put("Coinvolgimento", 0.0);
        baselineUni.put("Fiducia", 0.0);

        baselineBi.put("Trasparenza", 0.0);
        baselineBi.put("Persuasione", 0.0);
        baselineBi.put("Coinvolgimento", 0.0);
        baselineBi.put("Fiducia", 0.0);

        baselineUniBi.put("Trasparenza", 0.0);
        baselineUniBi.put("Persuasione", 0.0);
        baselineUniBi.put("Coinvolgimento", 0.0);
        baselineUniBi.put("Fiducia", 0.0);

        sistemaUni.put("Trasparenza", 0.0);
        sistemaUni.put("Persuasione", 0.0);
        sistemaUni.put("Coinvolgimento", 0.0);
        sistemaUni.put("Fiducia", 0.0);

        sistemaBi.put("Trasparenza", 0.0);
        sistemaBi.put("Persuasione", 0.0);
        sistemaBi.put("Coinvolgimento", 0.0);
        sistemaBi.put("Fiducia", 0.0);

        sistemaUniBi.put("Trasparenza", 0.0);
        sistemaUniBi.put("Persuasione", 0.0);
        sistemaUniBi.put("Coinvolgimento", 0.0);
        sistemaUniBi.put("Fiducia", 0.0);

        indifferentiUni.put("Trasparenza", 0.0);
        indifferentiUni.put("Persuasione", 0.0);
        indifferentiUni.put("Coinvolgimento", 0.0);
        indifferentiUni.put("Fiducia", 0.0);

        indifferentiBi.put("Trasparenza", 0.0);
        indifferentiBi.put("Persuasione", 0.0);
        indifferentiBi.put("Coinvolgimento", 0.0);
        indifferentiBi.put("Fiducia", 0.0);

        indifferentiUniBi.put("Trasparenza", 0.0);
        indifferentiUniBi.put("Persuasione", 0.0);
        indifferentiUniBi.put("Coinvolgimento", 0.0);
        indifferentiUniBi.put("Fiducia", 0.0);

        int totaliUni = 0, totaliBi = 0, totaliUniBi = 0;

        for (ValutazioneTipo3 v3 : Report.valutazioni3) {    // normale + pmi
            if (v3.getConfigurazione().equals("unigrammi")) {
                totaliUni++;
                if (v3.getTrasparenza() == 1) {
                    sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") + 1);
                } else if (v3.getTrasparenza() == 2) {
                    baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") + 1);
                } else {
                    indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") + 1);
                }

                if (v3.getPersuasione() == 1) {
                    sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") + 1);
                } else if (v3.getPersuasione() == 2) {
                    baselineUni.put("Persuasione", baselineUni.get("Persuasione") + 1);
                } else {
                    indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") + 1);
                }

                if (v3.getCoinvolgimento() == 1) {
                    sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") + 1);
                } else if (v3.getCoinvolgimento() == 2) {
                    baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") + 1);
                } else {
                    indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") + 1);
                }

                if (v3.getFiducia() == 1) {
                    sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") + 1);
                } else if (v3.getFiducia() == 2) {
                    baselineUni.put("Fiducia", baselineUni.get("Fiducia") + 1);
                } else {
                    indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") + 1);
                }

            } else if (v3.getConfigurazione().equals("bigrammi")) {
                totaliBi++;
                if (v3.getTrasparenza() == 1) {
                    sistemaBi.put("Trasparenza", sistemaBi.get("Trasparenza") + 1);
                } else if (v3.getTrasparenza() == 2) {
                    baselineBi.put("Trasparenza", baselineBi.get("Trasparenza") + 1);
                } else {
                    indifferentiBi.put("Trasparenza", indifferentiBi.get("Trasparenza") + 1);
                }

                if (v3.getPersuasione() == 1) {
                    sistemaBi.put("Persuasione", sistemaBi.get("Persuasione") + 1);
                } else if (v3.getPersuasione() == 2) {
                    baselineBi.put("Persuasione", baselineBi.get("Persuasione") + 1);
                } else {
                    indifferentiBi.put("Persuasione", indifferentiBi.get("Persuasione") + 1);

                }

                if (v3.getCoinvolgimento() == 1) {
                    sistemaBi.put("Coinvolgimento", sistemaBi.get("Coinvolgimento") + 1);
                } else if (v3.getCoinvolgimento() == 2) {
                    baselineBi.put("Coinvolgimento", baselineBi.get("Coinvolgimento") + 1);
                } else {
                    indifferentiBi.put("Coinvolgimento", indifferentiBi.get("Coinvolgimento") + 1);
                }

                if (v3.getFiducia() == 1) {
                    sistemaBi.put("Fiducia", sistemaBi.get("Fiducia") + 1);
                } else if (v3.getFiducia() == 2) {
                    baselineBi.put("Fiducia", baselineBi.get("Fiducia") + 1);
                } else {
                    indifferentiBi.put("Fiducia", indifferentiBi.get("Fiducia") + 1);
                }

            } else if (v3.getConfigurazione().equals("unibigrammi")) {
                totaliUniBi++;
                if (v3.getTrasparenza() == 1) {
                    sistemaUniBi.put("Trasparenza", sistemaUniBi.get("Trasparenza") + 1);
                } else if (v3.getTrasparenza() == 2) {
                    baselineUniBi.put("Trasparenza", baselineUniBi.get("Trasparenza") + 1);
                } else {
                    indifferentiUniBi.put("Trasparenza", indifferentiUniBi.get("Trasparenza") + 1);
                }

                if (v3.getPersuasione() == 1) {
                    sistemaUniBi.put("Persuasione", sistemaUniBi.get("Persuasione") + 1);
                } else if (v3.getPersuasione() == 2) {
                    baselineUniBi.put("Persuasione", baselineUniBi.get("Persuasione") + 1);
                } else {
                    indifferentiUniBi.put("Persuasione", indifferentiUniBi.get("Persuasione") + 1);
                }

                if (v3.getCoinvolgimento() == 1) {
                    sistemaUniBi.put("Coinvolgimento", sistemaUniBi.get("Coinvolgimento") + 1);
                } else if (v3.getCoinvolgimento() == 2) {
                    baselineUniBi.put("Coinvolgimento", baselineUniBi.get("Coinvolgimento") + 1);
                } else {
                    indifferentiUniBi.put("Coinvolgimento", indifferentiUniBi.get("Coinvolgimento") + 1);
                }

                if (v3.getFiducia() == 1) {
                    sistemaUniBi.put("Fiducia", sistemaUniBi.get("Fiducia") + 1);
                } else if (v3.getFiducia() == 2) {
                    baselineUniBi.put("Fiducia", baselineUniBi.get("Fiducia") + 1);
                } else {
                    indifferentiUniBi.put("Fiducia", indifferentiUniBi.get("Fiducia") + 1);
                }
            }
        }

        //////////////////////////////////////////////////////////////
        if (totaliUni != 0) {
            sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") / totaliUni);
            sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") / totaliUni);
            sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") / totaliUni);
            sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") / totaliUni);

            baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") / totaliUni);
            baselineUni.put("Persuasione", baselineUni.get("Persuasione") / totaliUni);
            baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") / totaliUni);
            baselineUni.put("Fiducia", baselineUni.get("Fiducia") / totaliUni);

            indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") / totaliUni);
            indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") / totaliUni);
            indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") / totaliUni);
            indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") / totaliUni);
        }
        /////////////////////
        if (totaliBi != 0) {
            sistemaBi.put("Trasparenza", sistemaBi.get("Trasparenza") / totaliBi);
            sistemaBi.put("Persuasione", sistemaBi.get("Persuasione") / totaliBi);
            sistemaBi.put("Coinvolgimento", sistemaBi.get("Coinvolgimento") / totaliBi);
            sistemaBi.put("Fiducia", sistemaBi.get("Fiducia") / totaliBi);

            baselineBi.put("Trasparenza", baselineBi.get("Trasparenza") / totaliBi);
            baselineBi.put("Persuasione", baselineBi.get("Persuasione") / totaliBi);
            baselineBi.put("Coinvolgimento", baselineBi.get("Coinvolgimento") / totaliBi);
            baselineBi.put("Fiducia", baselineBi.get("Fiducia") / totaliBi);

            indifferentiBi.put("Trasparenza", indifferentiBi.get("Trasparenza") / totaliBi);
            indifferentiBi.put("Persuasione", indifferentiBi.get("Persuasione") / totaliBi);
            indifferentiBi.put("Coinvolgimento", indifferentiBi.get("Coinvolgimento") / totaliBi);
            indifferentiBi.put("Fiducia", indifferentiBi.get("Fiducia") / totaliBi);
        }
        /////////////////////////////////
        if (totaliUniBi != 0) {
            sistemaUniBi.put("Trasparenza", sistemaUniBi.get("Trasparenza") / totaliUniBi);
            sistemaUniBi.put("Persuasione", sistemaUniBi.get("Persuasione") / totaliUniBi);
            sistemaUniBi.put("Coinvolgimento", sistemaUniBi.get("Coinvolgimento") / totaliUniBi);
            sistemaUniBi.put("Fiducia", sistemaUniBi.get("Fiducia") / totaliUniBi);

            baselineUniBi.put("Trasparenza", baselineUniBi.get("Trasparenza") / totaliUniBi);
            baselineUniBi.put("Persuasione", baselineUniBi.get("Persuasione") / totaliUniBi);
            baselineUniBi.put("Coinvolgimento", baselineUniBi.get("Coinvolgimento") / totaliUniBi);
            baselineUniBi.put("Fiducia", baselineUniBi.get("Fiducia") / totaliUniBi);

            indifferentiUniBi.put("Trasparenza", indifferentiUniBi.get("Trasparenza") / totaliUniBi);
            indifferentiUniBi.put("Persuasione", indifferentiUniBi.get("Persuasione") / totaliUniBi);
            indifferentiUniBi.put("Coinvolgimento", indifferentiUniBi.get("Coinvolgimento") / totaliUniBi);
            indifferentiUniBi.put("Fiducia", indifferentiUniBi.get("Fiducia") / totaliUniBi);
        }

        uni.put("sistema", sistemaUni);
        uni.put("baseline2", baselineUni);
        uni.put("indifferenti", indifferentiUni);

        bi.put("sistema", sistemaBi);
        bi.put("baseline2", baselineBi);
        bi.put("indifferenti", indifferentiBi);

        unibi.put("sistema", sistemaUniBi);
        unibi.put("baseline2", baselineUniBi);
        unibi.put("indifferenti", indifferentiUniBi);
        ////////////////////////////////////////////////////
        esiti.put("unigrammi", uni);
        esiti.put("bigrammi", bi);
        esiti.put("unibigrammi", unibi);

        return esiti;
    }

    // 8) confronto valutazioni metriche FRAMEWORK (solo normale) e BASELINE 2 per configurazione
    public static HashMap<String, HashMap<String, HashMap<String, Double>>> sistemaVSbaseline2MetricheNormaleLemmi() {
        HashMap<String, HashMap<String, HashMap<String, Double>>> esiti = new HashMap<>();

        HashMap<String, HashMap<String, Double>> uni = new HashMap<>();
        HashMap<String, HashMap<String, Double>> bi = new HashMap<>();
        HashMap<String, HashMap<String, Double>> unibi = new HashMap<>();

        HashMap<String, Double> sistemaUni = new HashMap<>();
        HashMap<String, Double> sistemaBi = new HashMap<>();
        HashMap<String, Double> sistemaUniBi = new HashMap<>();

        HashMap<String, Double> baselineUni = new HashMap<>();
        HashMap<String, Double> baselineBi = new HashMap<>();
        HashMap<String, Double> baselineUniBi = new HashMap<>();

        HashMap<String, Double> indifferentiUni = new HashMap<>();
        HashMap<String, Double> indifferentiBi = new HashMap<>();
        HashMap<String, Double> indifferentiUniBi = new HashMap<>();

        baselineUni.put("Trasparenza", 0.0);
        baselineUni.put("Persuasione", 0.0);
        baselineUni.put("Coinvolgimento", 0.0);
        baselineUni.put("Fiducia", 0.0);

        baselineBi.put("Trasparenza", 0.0);
        baselineBi.put("Persuasione", 0.0);
        baselineBi.put("Coinvolgimento", 0.0);
        baselineBi.put("Fiducia", 0.0);

        baselineUniBi.put("Trasparenza", 0.0);
        baselineUniBi.put("Persuasione", 0.0);
        baselineUniBi.put("Coinvolgimento", 0.0);
        baselineUniBi.put("Fiducia", 0.0);

        sistemaUni.put("Trasparenza", 0.0);
        sistemaUni.put("Persuasione", 0.0);
        sistemaUni.put("Coinvolgimento", 0.0);
        sistemaUni.put("Fiducia", 0.0);

        sistemaBi.put("Trasparenza", 0.0);
        sistemaBi.put("Persuasione", 0.0);
        sistemaBi.put("Coinvolgimento", 0.0);
        sistemaBi.put("Fiducia", 0.0);

        sistemaUniBi.put("Trasparenza", 0.0);
        sistemaUniBi.put("Persuasione", 0.0);
        sistemaUniBi.put("Coinvolgimento", 0.0);
        sistemaUniBi.put("Fiducia", 0.0);

        indifferentiUni.put("Trasparenza", 0.0);
        indifferentiUni.put("Persuasione", 0.0);
        indifferentiUni.put("Coinvolgimento", 0.0);
        indifferentiUni.put("Fiducia", 0.0);

        indifferentiBi.put("Trasparenza", 0.0);
        indifferentiBi.put("Persuasione", 0.0);
        indifferentiBi.put("Coinvolgimento", 0.0);
        indifferentiBi.put("Fiducia", 0.0);

        indifferentiUniBi.put("Trasparenza", 0.0);
        indifferentiUniBi.put("Persuasione", 0.0);
        indifferentiUniBi.put("Coinvolgimento", 0.0);
        indifferentiUniBi.put("Fiducia", 0.0);

        int totaliUni = 0, totaliBi = 0, totaliUniBi = 0;

        for (ValutazioneTipo2 v3 : Report.valutazioni3) {    //INDISTINTAMENTE CENTROIDE FRASI SINGOLE
            if (v3.getTecnica().equals("normale")) {
                if (v3.getConfigurazione().equals("unigrammi")) {
                    totaliUni++;
                    if (v3.getTrasparenza() == 1) {
                        sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") + 1);
                    } else if (v3.getTrasparenza() == 2) {
                        baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") + 1);
                    } else {
                        indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") + 1);
                    }

                    if (v3.getPersuasione() == 1) {
                        sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") + 1);
                    } else if (v3.getPersuasione() == 2) {
                        baselineUni.put("Persuasione", baselineUni.get("Persuasione") + 1);
                    } else {
                        indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") + 1);
                    }

                    if (v3.getCoinvolgimento() == 1) {
                        sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") + 1);
                    } else if (v3.getCoinvolgimento() == 2) {
                        baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") + 1);
                    } else {
                        indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") + 1);
                    }

                    if (v3.getFiducia() == 1) {
                        sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") + 1);
                    } else if (v3.getFiducia() == 2) {
                        baselineUni.put("Fiducia", baselineUni.get("Fiducia") + 1);
                    } else {
                        indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") + 1);
                    }

                } else if (v3.getConfigurazione().equals("bigrammi")) {
                    totaliBi++;
                    if (v3.getTrasparenza() == 1) {
                        sistemaBi.put("Trasparenza", sistemaBi.get("Trasparenza") + 1);
                    } else if (v3.getTrasparenza() == 2) {
                        baselineBi.put("Trasparenza", baselineBi.get("Trasparenza") + 1);
                    } else {
                        indifferentiBi.put("Trasparenza", indifferentiBi.get("Trasparenza") + 1);
                    }

                    if (v3.getPersuasione() == 1) {
                        sistemaBi.put("Persuasione", sistemaBi.get("Persuasione") + 1);
                    } else if (v3.getPersuasione() == 2) {
                        baselineBi.put("Persuasione", baselineBi.get("Persuasione") + 1);
                    } else {
                        indifferentiBi.put("Persuasione", indifferentiBi.get("Persuasione") + 1);

                    }

                    if (v3.getCoinvolgimento() == 1) {
                        sistemaBi.put("Coinvolgimento", sistemaBi.get("Coinvolgimento") + 1);
                    } else if (v3.getCoinvolgimento() == 2) {
                        baselineBi.put("Coinvolgimento", baselineBi.get("Coinvolgimento") + 1);
                    } else {
                        indifferentiBi.put("Coinvolgimento", indifferentiBi.get("Coinvolgimento") + 1);
                    }

                    if (v3.getFiducia() == 1) {
                        sistemaBi.put("Fiducia", sistemaBi.get("Fiducia") + 1);
                    } else if (v3.getFiducia() == 2) {
                        baselineBi.put("Fiducia", baselineBi.get("Fiducia") + 1);
                    } else {
                        indifferentiBi.put("Fiducia", indifferentiBi.get("Fiducia") + 1);
                    }

                } else if (v3.getConfigurazione().equals("unibigrammi")) {
                    totaliUniBi++;
                    if (v3.getTrasparenza() == 1) {
                        sistemaUniBi.put("Trasparenza", sistemaUniBi.get("Trasparenza") + 1);
                    } else if (v3.getTrasparenza() == 2) {
                        baselineUniBi.put("Trasparenza", baselineUniBi.get("Trasparenza") + 1);
                    } else {
                        indifferentiUniBi.put("Trasparenza", indifferentiUniBi.get("Trasparenza") + 1);
                    }

                    if (v3.getPersuasione() == 1) {
                        sistemaUniBi.put("Persuasione", sistemaUniBi.get("Persuasione") + 1);
                    } else if (v3.getPersuasione() == 2) {
                        baselineUniBi.put("Persuasione", baselineUniBi.get("Persuasione") + 1);
                    } else {
                        indifferentiUniBi.put("Persuasione", indifferentiUniBi.get("Persuasione") + 1);
                    }

                    if (v3.getCoinvolgimento() == 1) {
                        sistemaUniBi.put("Coinvolgimento", sistemaUniBi.get("Coinvolgimento") + 1);
                    } else if (v3.getCoinvolgimento() == 2) {
                        baselineUniBi.put("Coinvolgimento", baselineUniBi.get("Coinvolgimento") + 1);
                    } else {
                        indifferentiUniBi.put("Coinvolgimento", indifferentiUniBi.get("Coinvolgimento") + 1);
                    }

                    if (v3.getFiducia() == 1) {
                        sistemaUniBi.put("Fiducia", sistemaUniBi.get("Fiducia") + 1);
                    } else if (v3.getFiducia() == 2) {
                        baselineUniBi.put("Fiducia", baselineUniBi.get("Fiducia") + 1);
                    } else {
                        indifferentiUniBi.put("Fiducia", indifferentiUniBi.get("Fiducia") + 1);
                    }
                }

            }
        }

        //////////////////////////////////////////////////////////////
        if (totaliUni != 0) {
            sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") / totaliUni);
            sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") / totaliUni);
            sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") / totaliUni);
            sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") / totaliUni);

            baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") / totaliUni);
            baselineUni.put("Persuasione", baselineUni.get("Persuasione") / totaliUni);
            baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") / totaliUni);
            baselineUni.put("Fiducia", baselineUni.get("Fiducia") / totaliUni);

            indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") / totaliUni);
            indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") / totaliUni);
            indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") / totaliUni);
            indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") / totaliUni);
        }
        /////////////////////
        if (totaliBi != 0) {
            sistemaBi.put("Trasparenza", sistemaBi.get("Trasparenza") / totaliBi);
            sistemaBi.put("Persuasione", sistemaBi.get("Persuasione") / totaliBi);
            sistemaBi.put("Coinvolgimento", sistemaBi.get("Coinvolgimento") / totaliBi);
            sistemaBi.put("Fiducia", sistemaBi.get("Fiducia") / totaliBi);

            baselineBi.put("Trasparenza", baselineBi.get("Trasparenza") / totaliBi);
            baselineBi.put("Persuasione", baselineBi.get("Persuasione") / totaliBi);
            baselineBi.put("Coinvolgimento", baselineBi.get("Coinvolgimento") / totaliBi);
            baselineBi.put("Fiducia", baselineBi.get("Fiducia") / totaliBi);

            indifferentiBi.put("Trasparenza", indifferentiBi.get("Trasparenza") / totaliBi);
            indifferentiBi.put("Persuasione", indifferentiBi.get("Persuasione") / totaliBi);
            indifferentiBi.put("Coinvolgimento", indifferentiBi.get("Coinvolgimento") / totaliBi);
            indifferentiBi.put("Fiducia", indifferentiBi.get("Fiducia") / totaliBi);
        }
        /////////////////////////////////
        if (totaliUniBi != 0) {
            sistemaUniBi.put("Trasparenza", sistemaUniBi.get("Trasparenza") / totaliUniBi);
            sistemaUniBi.put("Persuasione", sistemaUniBi.get("Persuasione") / totaliUniBi);
            sistemaUniBi.put("Coinvolgimento", sistemaUniBi.get("Coinvolgimento") / totaliUniBi);
            sistemaUniBi.put("Fiducia", sistemaUniBi.get("Fiducia") / totaliUniBi);

            baselineUniBi.put("Trasparenza", baselineUniBi.get("Trasparenza") / totaliUniBi);
            baselineUniBi.put("Persuasione", baselineUniBi.get("Persuasione") / totaliUniBi);
            baselineUniBi.put("Coinvolgimento", baselineUniBi.get("Coinvolgimento") / totaliUniBi);
            baselineUniBi.put("Fiducia", baselineUniBi.get("Fiducia") / totaliUniBi);

            indifferentiUniBi.put("Trasparenza", indifferentiUniBi.get("Trasparenza") / totaliUniBi);
            indifferentiUniBi.put("Persuasione", indifferentiUniBi.get("Persuasione") / totaliUniBi);
            indifferentiUniBi.put("Coinvolgimento", indifferentiUniBi.get("Coinvolgimento") / totaliUniBi);
            indifferentiUniBi.put("Fiducia", indifferentiUniBi.get("Fiducia") / totaliUniBi);
        }

        uni.put("sistema", sistemaUni);
        uni.put("baseline2", baselineUni);
        uni.put("indifferenti", indifferentiUni);

        bi.put("sistema", sistemaBi);
        bi.put("baseline2", baselineBi);
        bi.put("indifferenti", indifferentiBi);

        unibi.put("sistema", sistemaUniBi);
        unibi.put("baseline2", baselineUniBi);
        unibi.put("indifferenti", indifferentiUniBi);
        ////////////////////////////////////////////////////
        esiti.put("unigrammi", uni);
        esiti.put("bigrammi", bi);
        esiti.put("unibigrammi", unibi);

        return esiti;
    }

    // 9) confronto valutazioni metriche FRAMEWORK (solo pmi) e BASELINE 2 per configurazione
    public static HashMap<String, HashMap<String, HashMap<String, Double>>> sistemaVSbaseline2MetrichePMILemmi() {
        HashMap<String, HashMap<String, HashMap<String, Double>>> esiti = new HashMap<>();

        HashMap<String, HashMap<String, Double>> uni = new HashMap<>();
        HashMap<String, HashMap<String, Double>> bi = new HashMap<>();
        HashMap<String, HashMap<String, Double>> unibi = new HashMap<>();

        HashMap<String, Double> sistemaUni = new HashMap<>();
        HashMap<String, Double> sistemaBi = new HashMap<>();
        HashMap<String, Double> sistemaUniBi = new HashMap<>();

        HashMap<String, Double> baselineUni = new HashMap<>();
        HashMap<String, Double> baselineBi = new HashMap<>();
        HashMap<String, Double> baselineUniBi = new HashMap<>();

        HashMap<String, Double> indifferentiUni = new HashMap<>();
        HashMap<String, Double> indifferentiBi = new HashMap<>();
        HashMap<String, Double> indifferentiUniBi = new HashMap<>();

        baselineUni.put("Trasparenza", 0.0);
        baselineUni.put("Persuasione", 0.0);
        baselineUni.put("Coinvolgimento", 0.0);
        baselineUni.put("Fiducia", 0.0);

        baselineBi.put("Trasparenza", 0.0);
        baselineBi.put("Persuasione", 0.0);
        baselineBi.put("Coinvolgimento", 0.0);
        baselineBi.put("Fiducia", 0.0);

        baselineUniBi.put("Trasparenza", 0.0);
        baselineUniBi.put("Persuasione", 0.0);
        baselineUniBi.put("Coinvolgimento", 0.0);
        baselineUniBi.put("Fiducia", 0.0);

        sistemaUni.put("Trasparenza", 0.0);
        sistemaUni.put("Persuasione", 0.0);
        sistemaUni.put("Coinvolgimento", 0.0);
        sistemaUni.put("Fiducia", 0.0);

        sistemaBi.put("Trasparenza", 0.0);
        sistemaBi.put("Persuasione", 0.0);
        sistemaBi.put("Coinvolgimento", 0.0);
        sistemaBi.put("Fiducia", 0.0);

        sistemaUniBi.put("Trasparenza", 0.0);
        sistemaUniBi.put("Persuasione", 0.0);
        sistemaUniBi.put("Coinvolgimento", 0.0);
        sistemaUniBi.put("Fiducia", 0.0);

        indifferentiUni.put("Trasparenza", 0.0);
        indifferentiUni.put("Persuasione", 0.0);
        indifferentiUni.put("Coinvolgimento", 0.0);
        indifferentiUni.put("Fiducia", 0.0);

        indifferentiBi.put("Trasparenza", 0.0);
        indifferentiBi.put("Persuasione", 0.0);
        indifferentiBi.put("Coinvolgimento", 0.0);
        indifferentiBi.put("Fiducia", 0.0);

        indifferentiUniBi.put("Trasparenza", 0.0);
        indifferentiUniBi.put("Persuasione", 0.0);
        indifferentiUniBi.put("Coinvolgimento", 0.0);
        indifferentiUniBi.put("Fiducia", 0.0);

        int totaliUni = 0, totaliBi = 0, totaliUniBi = 0;

        for (ValutazioneTipo2 v3 : Report.valutazioni3) {    //INDISTINTAMENTE CENTROIDE FRASI SINGOLE
            if (v3.getTecnica().equals("pmi")) {
                if (v3.getConfigurazione().equals("unigrammi")) {
                    totaliUni++;
                    if (v3.getTrasparenza() == 1) {
                        sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") + 1);
                    } else if (v3.getTrasparenza() == 2) {
                        baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") + 1);
                    } else {
                        indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") + 1);
                    }

                    if (v3.getPersuasione() == 1) {
                        sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") + 1);
                    } else if (v3.getPersuasione() == 2) {
                        baselineUni.put("Persuasione", baselineUni.get("Persuasione") + 1);
                    } else {
                        indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") + 1);
                    }

                    if (v3.getCoinvolgimento() == 1) {
                        sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") + 1);
                    } else if (v3.getCoinvolgimento() == 2) {
                        baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") + 1);
                    } else {
                        indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") + 1);
                    }

                    if (v3.getFiducia() == 1) {
                        sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") + 1);
                    } else if (v3.getFiducia() == 2) {
                        baselineUni.put("Fiducia", baselineUni.get("Fiducia") + 1);
                    } else {
                        indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") + 1);
                    }

                } else if (v3.getConfigurazione().equals("bigrammi")) {
                    totaliBi++;
                    if (v3.getTrasparenza() == 1) {
                        sistemaBi.put("Trasparenza", sistemaBi.get("Trasparenza") + 1);
                    } else if (v3.getTrasparenza() == 2) {
                        baselineBi.put("Trasparenza", baselineBi.get("Trasparenza") + 1);
                    } else {
                        indifferentiBi.put("Trasparenza", indifferentiBi.get("Trasparenza") + 1);
                    }

                    if (v3.getPersuasione() == 1) {
                        sistemaBi.put("Persuasione", sistemaBi.get("Persuasione") + 1);
                    } else if (v3.getPersuasione() == 2) {
                        baselineBi.put("Persuasione", baselineBi.get("Persuasione") + 1);
                    } else {
                        indifferentiBi.put("Persuasione", indifferentiBi.get("Persuasione") + 1);

                    }

                    if (v3.getCoinvolgimento() == 1) {
                        sistemaBi.put("Coinvolgimento", sistemaBi.get("Coinvolgimento") + 1);
                    } else if (v3.getCoinvolgimento() == 2) {
                        baselineBi.put("Coinvolgimento", baselineBi.get("Coinvolgimento") + 1);
                    } else {
                        indifferentiBi.put("Coinvolgimento", indifferentiBi.get("Coinvolgimento") + 1);
                    }

                    if (v3.getFiducia() == 1) {
                        sistemaBi.put("Fiducia", sistemaBi.get("Fiducia") + 1);
                    } else if (v3.getFiducia() == 2) {
                        baselineBi.put("Fiducia", baselineBi.get("Fiducia") + 1);
                    } else {
                        indifferentiBi.put("Fiducia", indifferentiBi.get("Fiducia") + 1);
                    }

                } else if (v3.getConfigurazione().equals("unibigrammi")) {
                    totaliUniBi++;
                    if (v3.getTrasparenza() == 1) {
                        sistemaUniBi.put("Trasparenza", sistemaUniBi.get("Trasparenza") + 1);
                    } else if (v3.getTrasparenza() == 2) {
                        baselineUniBi.put("Trasparenza", baselineUniBi.get("Trasparenza") + 1);
                    } else {
                        indifferentiUniBi.put("Trasparenza", indifferentiUniBi.get("Trasparenza") + 1);
                    }

                    if (v3.getPersuasione() == 1) {
                        sistemaUniBi.put("Persuasione", sistemaUniBi.get("Persuasione") + 1);
                    } else if (v3.getPersuasione() == 2) {
                        baselineUniBi.put("Persuasione", baselineUniBi.get("Persuasione") + 1);
                    } else {
                        indifferentiUniBi.put("Persuasione", indifferentiUniBi.get("Persuasione") + 1);
                    }

                    if (v3.getCoinvolgimento() == 1) {
                        sistemaUniBi.put("Coinvolgimento", sistemaUniBi.get("Coinvolgimento") + 1);
                    } else if (v3.getCoinvolgimento() == 2) {
                        baselineUniBi.put("Coinvolgimento", baselineUniBi.get("Coinvolgimento") + 1);
                    } else {
                        indifferentiUniBi.put("Coinvolgimento", indifferentiUniBi.get("Coinvolgimento") + 1);
                    }

                    if (v3.getFiducia() == 1) {
                        sistemaUniBi.put("Fiducia", sistemaUniBi.get("Fiducia") + 1);
                    } else if (v3.getFiducia() == 2) {
                        baselineUniBi.put("Fiducia", baselineUniBi.get("Fiducia") + 1);
                    } else {
                        indifferentiUniBi.put("Fiducia", indifferentiUniBi.get("Fiducia") + 1);
                    }
                }

            }
        }

        //////////////////////////////////////////////////////////////
        if (totaliUni != 0) {
            sistemaUni.put("Trasparenza", sistemaUni.get("Trasparenza") / totaliUni);
            sistemaUni.put("Persuasione", sistemaUni.get("Persuasione") / totaliUni);
            sistemaUni.put("Coinvolgimento", sistemaUni.get("Coinvolgimento") / totaliUni);
            sistemaUni.put("Fiducia", sistemaUni.get("Fiducia") / totaliUni);

            baselineUni.put("Trasparenza", baselineUni.get("Trasparenza") / totaliUni);
            baselineUni.put("Persuasione", baselineUni.get("Persuasione") / totaliUni);
            baselineUni.put("Coinvolgimento", baselineUni.get("Coinvolgimento") / totaliUni);
            baselineUni.put("Fiducia", baselineUni.get("Fiducia") / totaliUni);

            indifferentiUni.put("Trasparenza", indifferentiUni.get("Trasparenza") / totaliUni);
            indifferentiUni.put("Persuasione", indifferentiUni.get("Persuasione") / totaliUni);
            indifferentiUni.put("Coinvolgimento", indifferentiUni.get("Coinvolgimento") / totaliUni);
            indifferentiUni.put("Fiducia", indifferentiUni.get("Fiducia") / totaliUni);
        }
        /////////////////////
        if (totaliBi != 0) {
            sistemaBi.put("Trasparenza", sistemaBi.get("Trasparenza") / totaliBi);
            sistemaBi.put("Persuasione", sistemaBi.get("Persuasione") / totaliBi);
            sistemaBi.put("Coinvolgimento", sistemaBi.get("Coinvolgimento") / totaliBi);
            sistemaBi.put("Fiducia", sistemaBi.get("Fiducia") / totaliBi);

            baselineBi.put("Trasparenza", baselineBi.get("Trasparenza") / totaliBi);
            baselineBi.put("Persuasione", baselineBi.get("Persuasione") / totaliBi);
            baselineBi.put("Coinvolgimento", baselineBi.get("Coinvolgimento") / totaliBi);
            baselineBi.put("Fiducia", baselineBi.get("Fiducia") / totaliBi);

            indifferentiBi.put("Trasparenza", indifferentiBi.get("Trasparenza") / totaliBi);
            indifferentiBi.put("Persuasione", indifferentiBi.get("Persuasione") / totaliBi);
            indifferentiBi.put("Coinvolgimento", indifferentiBi.get("Coinvolgimento") / totaliBi);
            indifferentiBi.put("Fiducia", indifferentiBi.get("Fiducia") / totaliBi);
        }
        /////////////////////////////////
        if (totaliUniBi != 0) {
            sistemaUniBi.put("Trasparenza", sistemaUniBi.get("Trasparenza") / totaliUniBi);
            sistemaUniBi.put("Persuasione", sistemaUniBi.get("Persuasione") / totaliUniBi);
            sistemaUniBi.put("Coinvolgimento", sistemaUniBi.get("Coinvolgimento") / totaliUniBi);
            sistemaUniBi.put("Fiducia", sistemaUniBi.get("Fiducia") / totaliUniBi);

            baselineUniBi.put("Trasparenza", baselineUniBi.get("Trasparenza") / totaliUniBi);
            baselineUniBi.put("Persuasione", baselineUniBi.get("Persuasione") / totaliUniBi);
            baselineUniBi.put("Coinvolgimento", baselineUniBi.get("Coinvolgimento") / totaliUniBi);
            baselineUniBi.put("Fiducia", baselineUniBi.get("Fiducia") / totaliUniBi);

            indifferentiUniBi.put("Trasparenza", indifferentiUniBi.get("Trasparenza") / totaliUniBi);
            indifferentiUniBi.put("Persuasione", indifferentiUniBi.get("Persuasione") / totaliUniBi);
            indifferentiUniBi.put("Coinvolgimento", indifferentiUniBi.get("Coinvolgimento") / totaliUniBi);
            indifferentiUniBi.put("Fiducia", indifferentiUniBi.get("Fiducia") / totaliUniBi);
        }

        uni.put("sistema", sistemaUni);
        uni.put("baseline2", baselineUni);
        uni.put("indifferenti", indifferentiUni);

        bi.put("sistema", sistemaBi);
        bi.put("baseline2", baselineBi);
        bi.put("indifferenti", indifferentiBi);

        unibi.put("sistema", sistemaUniBi);
        unibi.put("baseline2", baselineUniBi);
        unibi.put("indifferenti", indifferentiUniBi);
        ////////////////////////////////////////////////////
        esiti.put("unigrammi", uni);
        esiti.put("bigrammi", bi);
        esiti.put("unibigrammi", unibi);

        return esiti;
    }

    // ---------------------------------------------------------------------------------------

    // 10) preferenza tra sistema e baseline 1 in base al numero di contesti
    public static HashMap<Integer, HashMap<String, Double>> SistemaVSbaseline1NumContesti() {

        HashMap<Integer, HashMap<String, Double>> preferenzaNumeroContesti = new HashMap<Integer, HashMap<String, Double>>();
        int sistema1 = 0, sistema2 = 0, sistema3 = 0,
                baseline1_1 = 0, baseline1_2 = 0, baseline1_3 = 0,
                indiff1 = 0, indiff2 = 0, indiff3 = 0,
                totale1 = 0, totale2 = 0, totale3 = 0;

        for (ValutazioneTipo2 v2 : Report.valutazioni2) {
            if (v2.getNumeroContesti() == 1) {
                totale1++;
                if (v2.getPreferenza0() == 1) {
                    sistema1++;//SIST
                } else if (v2.getPreferenza0() == 2) {
                    baseline1_1++;//BASELINE D
                } else {
                    indiff1++;
                }
            } else if (v2.getNumeroContesti() == 2) {
                totale2++;
                if (v2.getPreferenza0() == 1) {
                    sistema2++;
                } else if (v2.getPreferenza0() == 2) {
                    baseline1_2++;
                } else {
                    indiff2++;
                }
            } else if (v2.getNumeroContesti() == 3) {
                totale3++;
                if (v2.getPreferenza0() == 1) {
                    sistema3++;
                } else if (v2.getPreferenza0() == 2) {
                    baseline1_3++;
                } else {
                    indiff3++;
                }
            }

        }

        HashMap<String, Double> contesto1 = new HashMap<String, Double>();
        HashMap<String, Double> contesto2 = new HashMap<String, Double>();
        HashMap<String, Double> contesto3 = new HashMap<String, Double>();

        contesto1.put("sistema", totale1 != 0 ? (double) sistema1 / totale1 : 0);
        contesto1.put("baseline1", totale1 != 0 ? (double) baseline1_1 / totale1 : 0);
        contesto1.put("Indifferente", totale1 != 0 ? (double) indiff1 / totale1 : 0);

        contesto2.put("sistema", totale2 != 0 ? (double) sistema2 / totale2 : 0);
        contesto2.put("baseline1", totale2 != 0 ? (double) baseline1_2 / totale2 : 0);
        contesto2.put("Indifferente", totale2 != 0 ? (double) indiff2 / totale2 : 0);

        contesto3.put("sistema", totale3 != 0 ? (double) sistema3 / totale3 : 0);
        contesto3.put("baseline1", totale3 != 0 ? (double) baseline1_3 / totale3 : 0);
        contesto3.put("Indifferente", totale3 != 0 ? (double) indiff3 / totale3 : 0);

        preferenzaNumeroContesti.put(1, contesto1);
        preferenzaNumeroContesti.put(2, contesto2);
        preferenzaNumeroContesti.put(3, contesto3);

        return preferenzaNumeroContesti;
    }

    // 11) preferenze tra sistema e baseline 2 in base al numero di contesti
    public static HashMap<Integer, HashMap<String, Double>> SistemaVSbaseline2NumContesti() {

        HashMap<Integer, HashMap<String, Double>> preferenzaNumeroContesti = new HashMap<Integer, HashMap<String, Double>>();
        int sistema1 = 0, sistema2 = 0, sistema3 = 0,
                baseline2_1 = 0, baseline2_2 = 0, baseline2_3 = 0,
                indiff1 = 0, indiff2 = 0, indiff3 = 0,
                totale1 = 0, totale2 = 0, totale3 = 0;

        for (ValutazioneTipo3 v3 : Report.valutazioni3) {
            if (v3.getNumeroContesti() == 1) {
                totale1++;
                if (v3.getPreferenza0() == 1) {
                    sistema1++;//SIST
                } else if (v3.getPreferenza0() == 2) {
                    baseline2_1++;//BASELINE D
                } else {
                    indiff1++;
                }
            } else if (v3.getNumeroContesti() == 2) {
                totale2++;
                if (v3.getPreferenza0() == 1) {
                    sistema2++;
                } else if (v3.getPreferenza0() == 2) {
                    baseline2_2++;
                } else {
                    indiff2++;
                }
            } else if (v3.getNumeroContesti() == 3) {
                totale3++;
                if (v3.getPreferenza0() == 1) {
                    sistema3++;
                } else if (v3.getPreferenza0() == 2) {
                    baseline2_3++;
                } else {
                    indiff3++;
                }
            }

        }

        HashMap<String, Double> contesto1 = new HashMap<String, Double>();
        HashMap<String, Double> contesto2 = new HashMap<String, Double>();
        HashMap<String, Double> contesto3 = new HashMap<String, Double>();

        contesto1.put("sistema", totale1 != 0 ? (double) sistema1 / totale1 : 0);
        contesto1.put("baseline2", totale1 != 0 ? (double) baseline2_1 / totale1 : 0);
        contesto1.put("Indifferente", totale1 != 0 ? (double) indiff1 / totale1 : 0);

        contesto2.put("sistema", totale2 != 0 ? (double) sistema2 / totale2 : 0);
        contesto2.put("baseline2", totale2 != 0 ? (double) baseline2_2 / totale2 : 0);
        contesto2.put("Indifferente", totale2 != 0 ? (double) indiff2 / totale2 : 0);

        contesto3.put("sistema", totale3 != 0 ? (double) sistema3 / totale3 : 0);
        contesto3.put("baseline2", totale3 != 0 ? (double) baseline2_3 / totale3 : 0);
        contesto3.put("Indifferente", totale3 != 0 ? (double) indiff3 / totale3 : 0);

        preferenzaNumeroContesti.put(1, contesto1);
        preferenzaNumeroContesti.put(2, contesto2);
        preferenzaNumeroContesti.put(3, contesto3);

        return preferenzaNumeroContesti;
    }


}
