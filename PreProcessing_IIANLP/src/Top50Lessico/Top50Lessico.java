package Top50Lessico;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Scanner;

public class Top50Lessico {

    public static void main(String[] argv){


        String path = "";
        int conf = 1;

        TreeMap<String, TreeMap<String, TreeMap<String, ArrayList<Lemma>>>> lessico = new TreeMap<>();

        String tecnica="";
        String tipo="";
        String contesto="";

        TreeMap<String, TreeMap<String, ArrayList<Lemma>>> tipoContestoLemma = new TreeMap<>();

        while (conf <= 6){


            switch (conf) {
                case 1:
                    tecnica = "normale";
                    tipo = "unigrammi";
                    break;
                case 2:
                    tecnica = "normale";
                    tipo = "bigrammi";
                    break;
                case 3:
                    tecnica = "normale";
                    tipo = "unibigrammi";
                    break;
                case 4:
                    tecnica = "pmi";
                    tipo = "unigrammi";
                    break;
                case 5:
                    tecnica = "pmi";
                    tipo = "bigrammi";
                    break;
                case 6:
                    tecnica = "pmi";
                    tipo = "unibigrammi";
                    break;
            }

            int cont = 1;

            TreeMap<String, ArrayList<Lemma>> contestoLemmi = new TreeMap<>();

            while(cont<=10){

                switch (cont){

                    case 1:
                        contesto = "1_Good Mood.txt";
                        break;
                    case 2:
                        contesto = "2_Bad Mood.txt";
                        break;
                    case 3:
                        contesto = "3_Relax.txt";
                        break;
                    case 4:
                        contesto = "4_Sport.txt";
                        break;
                    case 5:
                        contesto = "5_Focus.txt";
                        break;
                    case 6:
                        contesto = "6_Home.txt";
                        break;
                    case 7:
                        contesto = "7_Driving.txt";
                        break;
                    case 8:
                        contesto = "8_Alone.txt";
                        break;
                    case 9:
                        contesto = "9_Friends.txt";
                        break;
                    case 10:
                        contesto = "10_Couple.txt";
                        break;

                }

                path = "C:\\Users\\Giuseppe\\Desktop\\progetto nlp\\Spillo - Musicando\\filesFilmando2\\" + tecnica + "\\" + tipo + "\\lessico\\" + contesto;

                int counter=0;

                try {

                    Scanner in = new Scanner(new File(path));
                    System.out.println(path);
                    counter = 0;
                    ArrayList<Lemma> lemmi = new ArrayList<>();

                    while (in.hasNextLine() && counter<50){

                        Lemma l = new Lemma(in.nextLine());
                        lemmi.add(l);

                        counter++;

                    }

                    contestoLemmi.put(contesto, lemmi);

                    in.close();
                } catch (Exception e){
                    System.out.println(tecnica + " - " + tipo + " - " + contesto + " - " + counter);
                }

                cont++;

            }

            tipoContestoLemma.put(tipo, contestoLemmi);

            if ((conf == 3) || (conf == 6)){
                lessico.put(tecnica, tipoContestoLemma);
                tipoContestoLemma = new TreeMap<>();
            }

            conf++;

        }


        for (String a : lessico.keySet()){
            System.out.println(a);
            for (String b : lessico.get(a).keySet()){
                System.out.println("\t"+b);
                for (String c : lessico.get(a).get(b).keySet()){
                    System.out.println("\t\t" + c + " -> " + lessico.get(a).get(b).get(c));
                }
            }
        }

        try {

            ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("lessico.dat"));
            ois.writeObject(lessico);
            ois.flush();
            ois.close();

            int i=1;

            while(i<=10){

                PrintWriter out = new PrintWriter(new File(i+".txt"));

                int cont = 0;

                switch (i){

                    case 1:
                        contesto = "1_Good Mood.txt";
                        break;
                    case 2:
                        contesto = "2_Bad Mood.txt";
                        break;
                    case 3:
                        contesto = "3_Relax.txt";
                        break;
                    case 4:
                        contesto = "4_Sport.txt";
                        break;
                    case 5:
                        contesto = "5_Focus.txt";
                        break;
                    case 6:
                        contesto = "6_Home.txt";
                        break;
                    case 7:
                        contesto = "7_Driving.txt";
                        break;
                    case 8:
                        contesto = "8_Alone.txt";
                        break;
                    case 9:
                        contesto = "9_Friends.txt";
                        break;
                    case 10:
                        contesto = "10_Couple.txt";
                        break;

                }

                out.println(contesto+"\n");
                out.println("normale uni\t\t\t\tnormale bi\t\t\t\tnormale unibi\t\t\t\tpmi uni\t\t\t\tpmi bi\t\t\t\tpmi unibi\n");

                while (cont < 50){

                    Lemma l1 = lessico.get("normale").get("unigrammi").get(contesto).get(cont);
                    Lemma l2 = lessico.get("normale").get("bigrammi").get(contesto).get(cont);
                    Lemma l3 = lessico.get("normale").get("unibigrammi").get(contesto).get(cont);
                    Lemma l4 = lessico.get("pmi").get("unigrammi").get(contesto).get(cont);
                    Lemma l5 = lessico.get("pmi").get("bigrammi").get(contesto).get(cont);
                    Lemma l6 = lessico.get("pmi").get("unibigrammi").get(contesto).get(cont);

                    out.println(l1.getLemma()+"\t"+l1.getScore()+"\t\t\t"+l2.getLemma()+"\t"+l2.getScore()+"\t\t\t"+l3.getLemma()+"\t"+l3.getScore()+"\t\t\t"+l4.getLemma()+"\t"+l4.getScore()+"\t\t\t"+l5.getLemma()+"\t"+l5.getScore()+"\t\t\t"+l6.getLemma()+"\t"+l6.getScore());

                    cont++;

                }

                out.flush();
                out.close();

                i++;

            }


        } catch (Exception e){
            e.printStackTrace();
        }



    }

}
