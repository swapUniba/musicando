package LemmaItems_6;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LemmaItems {

    public static StanfordCoreNLP pipeline = Pipeline.getPipeline();

    public static void main(String[] args) throws IOException {

        for (int i=1; i<=3207; i++){

            Scanner in = new Scanner(new File("src\\LemmaItems_6\\info utili\\"+i+".txt"));

            /*
            1
            B000089GIO
            One Heart
            Celine Dion
            https://images-na.ssl-images-amazon.com/images/I/71KcppEL9IL._SX466_.jpg
             */

            in.nextLine(); //id
            in.nextLine(); //asin
            String title = in.nextLine();
            String author = in.nextLine();

            in.close();

            String text = title + " " + author;

            String uni = "", bi="", unibi="";

            CoreDocument document = new CoreDocument(text);
            pipeline.annotate(document);

            ArrayList<String> l = new ArrayList<>();
            for (CoreLabel token : document.tokens()){
                uni += (token.get(CoreAnnotations.LemmaAnnotation.class).toLowerCase()+"\n");
                l.add(token.get(CoreAnnotations.LemmaAnnotation.class).toLowerCase());

            }

            unibi = uni;

            for (int j=0; j<l.size()-1; j++){
                bi += l.get(j) + " " + l.get(j+1) + "\n";
            }


            unibi += bi;
            bi = bi.trim();

            unibi = unibi.trim();

            System.out.println(uni);
            System.out.println(bi);
            System.out.println(unibi);

            break;


            /*
            PrintWriter outuni = new PrintWriter(new File("src\\LemmaItems_6\\stoplemmiitem\\unigrammi\\"+i+".txt"));
            outuni.println(uni);
            outuni.flush();
            outuni.close();

            PrintWriter outbi = new PrintWriter(new File("src\\LemmaItems_6\\stoplemmiitem\\bigrammi\\"+i+".txt"));
            outbi.println(bi);
            outbi.flush();
            outbi.close();

            PrintWriter outunibi = new PrintWriter(new File("src\\LemmaItems_6\\stoplemmiitem\\unibigrammi\\"+i+".txt"));
            outunibi.println(unibi);
            outunibi.flush();
            outunibi.close();

            */

        }

    }
}
