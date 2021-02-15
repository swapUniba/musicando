package Filtering_2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Filtering {
	
    public static void main(String[] args) throws IOException {//dataset_verypositive.txt //dataset_positivo.txt
    	BufferedReader br = new BufferedReader ( new FileReader (
    			"src\\Filtering_2\\dataset_cds_positivo.txt"));
        FileWriter complete = new FileWriter(
        		"src\\Filtering_2\\dataset_cds_positivo_CLEAN.txt");

		int counter=0;
		String readString=null;
        while  ((readString = br.readLine())  != null){

			try{

				//I:8493	But, in all honesty, I thought this wa
				//System.out.println("Not null");
				StringTokenizer myTokens = new StringTokenizer(readString, "\t");
				String FilmID = myTokens.nextToken();	//I:8493
				myTokens.nextToken();
				//int countFrasi = Integer.parseInt(myTokens.nextToken());	//16501
				String sentence = myTokens.nextToken();	//But, in all honesty,... .
				//System.out.println(sentence);
				if(!(sentence.split("\\s+").length<5 || sentence.split("\\s+").length>80)){ //n parole nell frase
					counter++;
					//System.out.println(FilmID +"\t" + counter + "\t" + sentence);
					complete.write(FilmID +"\t" + counter + "\t" + sentence + "\n");
				}

			} catch (Throwable t){
				System.out.println("Log: " + counter +" - " + t);
			}


	    }
        complete.flush();
        complete.close();
        br.close();
    }
    
}
