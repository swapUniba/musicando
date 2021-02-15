package ScalingPMI;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScalingPMI {

    public static void main(String[] arg){


        try {

            String path[] = {"C:\\Users\\Giuseppe\\Desktop\\progetto nlp\\Spillo - Musicando\\filesFilmando2\\pmi\\unigrammi\\idFraseLemmi",
                    "C:\\Users\\Giuseppe\\Desktop\\progetto nlp\\Spillo - Musicando\\filesFilmando2\\pmi\\bigrammi\\idFraseLemmi",
                    "C:\\Users\\Giuseppe\\Desktop\\progetto nlp\\Spillo - Musicando\\filesFilmando2\\pmi\\unibigrammi\\idFraseLemmi"
            };

            for (int i = 0; i < 3; i++) {

                int cont = 0;

                Scanner in = new Scanner(new File(path[i]+".txt"));
                PrintWriter out = new PrintWriter(new File(path[i]+"2.txt"));


                while(in.hasNextLine()){

                    String riga = in.nextLine().split(";",2)[1];

                    for (int c=0; c<100; c++){
                        cont++;
                        out.println(cont+";"+riga);
                    }

                }

                out.flush();
                out.close();
                in.close();


            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
