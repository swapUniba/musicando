package Splitter_5;
import jdk.nashorn.api.tree.Tree;

import java.io.*;
import java.util.*;

//funziona con tutti i tipi, intere, unigrammi ecc

// le frasi sono quelle del dataset

public class Splitter {

	public static void generaIntere() throws Exception{

		Scanner in = new Scanner(new File("src\\Splitter_5\\dataset_cds_positivo.txt"));

		String outpath="src\\Splitter_5\\output_cds_intere\\";
		int counter = 0;
		PrintWriter out = new PrintWriter(new File(outpath + counter + ".txt"));

		String id="";
		int contaRiga=0;

		TreeMap<Integer, String> idAsin = new TreeMap<>();			//counter;asin

		while (in.hasNextLine()){

			try {
				String line = in.nextLine();

				StringTokenizer myTokens = new StringTokenizer(line, "\t");

				String FilmID = myTokens.nextToken();                        //I:8493
				contaRiga = Integer.parseInt(myTokens.nextToken());            //221
				String frase = myTokens.nextToken();                    //fiction favorite, favorite movie

				if (id.equals(FilmID)) {        //I:8493 == a quello di prima
					//contaRiga++;
					out.write(FilmID + ";" + contaRiga + ";" + frase + "\n");    //scrivo semplice

				} else {            //I:8493 != 	I:8500
					id = FilmID;        //id = I:8500
					counter++;
					idAsin.put(counter, id);
					System.out.println(counter);        //++, come indice del film da assegnare al 2.txt
					out.flush();
					out.close();                //chiuso file precedente

					out = new PrintWriter(outpath + counter + ".txt");
					out.println(FilmID + ";" + contaRiga + ";" + frase);
				}

			} catch (Throwable t) {
				System.out.println("Exception " + counter + ".");
			}

		}

		in.close();

	}

	public static void generaDAT() throws Exception{

		for (int i=1; i<=3207; i++){

			Scanner in = new Scanner(new File("src\\Splitter_5\\output_cds_intere\\"+i+".txt"));
			TreeMap<Integer, String> mappaIdFrase = new TreeMap<>();

			while (in.hasNextLine()){

				String line[] = in.nextLine().split(";");
				mappaIdFrase.put(Integer.parseInt(line[1]), line[2]);

			}

			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("src\\Splitter_5\\output_cds_intere\\interedat\\"+i+".dat"));
			out.writeObject(mappaIdFrase);
			out.flush();
			out.close();
			mappaIdFrase.clear();

		}

		System.out.println("Done!");

	}
	
    public static void main(String[] args) throws IOException {

    	BufferedReader br = new BufferedReader ( new FileReader (
    			"src\\Splitter_5\\idFraseLemmiUni_cds.txt"));

        String outpath="src\\Splitter_5\\out\\";
        //idFrasefrasiIntere, idFraseLemmiBi, idFraseLemmiUni, idFraseLemmiUniBi
        String readString = null;
		String id ="";	
		int counter = 0;	//NOME FILE TXT
		PrintWriter fileoutput = new PrintWriter(new File(outpath+counter+".txt"), "UTF-8");
		int contaRiga=0;

		TreeMap<Integer, String> idAsin = new TreeMap<>();			//counter;asin

        while((readString = br.readLine()) != null) {        //I:8493;17544;But, in all honesty,

			try {

				StringTokenizer myTokens = new StringTokenizer(readString, ";");

				String FilmID = myTokens.nextToken();                        //I:8493
				contaRiga = Integer.parseInt(myTokens.nextToken());            //221
				//int contaRiga = Integer.parseInt(myTokens.nextToken());
				String frase = myTokens.nextToken();                    //fiction favorite, favorite movie

				if (id.equals(FilmID)) {        //I:8493 == a quello di prima
					//contaRiga++;
					fileoutput.println(FilmID + ";" + contaRiga + ";" + frase);    //scrivo semplice

				} else {            //I:8493 != 	I:8500
					id = FilmID;        //id = I:8500
					counter++;
					idAsin.put(counter, id);
					System.out.println(counter);        //++, come indice del film da assegnare al 2.txt
					fileoutput.flush();
					fileoutput.close();                //chiuso file precedente

					fileoutput = new PrintWriter(new File(outpath+counter+".txt"), "UTF-8");
					fileoutput.println(FilmID + ";" + contaRiga + ";" + frase);
				}

			} catch (Throwable t) {
				System.out.println("Exception " + counter + ".");
			}
		}

        fileoutput.flush();
		fileoutput.close();	
		br.close();

		/*
		PrintWriter schedaFilm = new PrintWriter(new File("src\\Splitter_5\\Scheda Film_cds.txt"));

		for (int intid : idAsin.keySet()){
			schedaFilm.println(intid+";"+idAsin.get(intid));
		}

		schedaFilm.flush();
		schedaFilm.close();
		*/

    }
}
