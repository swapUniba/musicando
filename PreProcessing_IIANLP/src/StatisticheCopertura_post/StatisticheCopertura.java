package StatisticheCopertura_post;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.*;

public class StatisticheCopertura {

    public static void main(String[] args) throws Exception {

        int conf = 1;
        String path_c = "";
        while (conf <= 6) {

            switch (conf) {
                case 1:
                    path_c = "_nu";
                    break;
                case 2:
                    path_c = "_nb";
                    break;
                case 3:
                    path_c = "_nub";
                    break;
                case 4:
                    path_c = "_pu";
                    break;
                case 5:
                    path_c = "_pb";
                    break;
                case 6:
                    path_c = "_pub";
                    break;

            }


            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src\\StatisticheCopertura_post\\contesti-item-frasi"+path_c+".dat"));
            HashMap<HashSet<Integer>, HashMap<Integer, ArrayList<Integer>>> matriceContestiItemFrasi =
                    (HashMap<HashSet<Integer>, HashMap<Integer, ArrayList<Integer>>>) in.readObject();
            in.close();

            HashMap<Integer, HashSet<HashSet<Integer>>> itemContesti = new HashMap<>();

            /*
                - indice
                - id item
                - titolo
                - numero combinazioni contesti
                - combinazioni
             */


            for (HashSet<Integer> combContesti : matriceContestiItemFrasi.keySet()) {

                Set<Integer> items = matriceContestiItemFrasi.get(combContesti).keySet();

                for (int item : items) {

                    if (itemContesti.containsKey(item)) {
                        itemContesti.get(item).add(combContesti);
                    } else {
                        HashSet<HashSet<Integer>> temp = new HashSet<>();
                        temp.add(combContesti);
                        itemContesti.put(item, temp);
                    }

                }

            }

            /*
                - indice
                - id item
                - titolo
                - numero combinazioni contesti
                - combinazioni
             */


            PrintWriter out = new PrintWriter(new File("src\\StatisticheCopertura_post\\statistiche"+path_c+".csv"));
            out.println("INDEX\tITEM\tTITLE\tAUTHOR\tNUM COMBINATIONS\tCOMBINATIONS");

            int index = 0;

            try {

                for (int item : itemContesti.keySet()) {

                    index++;

                    Scanner scheda = new Scanner(new File("src\\StatisticheCopertura_post\\info utili\\" + item + ".txt"));
                    scheda.nextLine();
                    scheda.nextLine();
                    String title = scheda.nextLine();
                    String author = scheda.nextLine();
                    scheda.close();


                    //System.out.println(index+"\t"+item+"\t"+title+"\t"+itemContesti.get(item).size()+"\t"+itemContesti.get(item));
                    out.println(index + "\t" + item + "\t" + title + "\t" + author +"\t" + itemContesti.get(item).size() + "\t" + itemContesti.get(item));


                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            out.flush();
            out.close();


            conf++;

        }


        System.out.println("The end.");


    }
}
