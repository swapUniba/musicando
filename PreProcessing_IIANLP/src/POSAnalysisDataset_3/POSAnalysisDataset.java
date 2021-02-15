package POSAnalysisDataset_3;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class POSAnalysisDataset {
	public static StanfordCoreNLP pipeline = Pipeline.getPipeline();
	public static HashSet<String> POSTypes = new HashSet<>(
			Arrays.asList(	"JJ","JJR", "JJS",				//aggettivi, comparativi e superlativi
							"NN", "NNS",					//nomi singolari, plurali
							//"RB","RBR","RBS",				//avverbi, comparativi e superlativi
							"VB","VBD","VBG","VBN","VBP","VBZ")); 	//verbo base, passato ,gerundio e participio, non 3rdps, 3rdps													
	
	public static ArrayList<String> syntax(String testoFrase) {
		ArrayList<String> lemmi = new ArrayList<String>();	//PREPARO LISTA LEMMI
		
		CoreDocument document = new CoreDocument(testoFrase);	  //CREATE A DOCUMENT OBJECT
		pipeline.annotate(document);						//ANNOTATE THE DOCUMENT
		
		List<CoreLabel> text = document.tokens();//TOKENS OF THE DOCUMENT
    	for(CoreLabel token : text) {
	        String POS = token.get(PartOfSpeechAnnotation.class);
	        
	        for(String POSType: POSTypes) 
	        	if (POS.equals(POSType)) 
	        		lemmi.add(token.get(LemmaAnnotation.class).toLowerCase());	
	        }
    	return lemmi;
    }
	
	
    public static void main(String[] args) throws IOException {
        Scanner fileDataset = new Scanner(new File("src\\POSAnalysisDataset_3\\dataset_cds_positivo_CLEAN.txt"));
		//dataset_positivo_CLEAN.txt//dataset_verypositive_CLEAN.txt//
        FileWriter outUni = new FileWriter("src\\POSAnalysisDataset_3\\idFraseLemmiUni_cds.txt");
        FileWriter outBi = new FileWriter("src\\POSAnalysisDataset_3\\idFraseLemmiBi_cds.txt");
        FileWriter outUniBi = new FileWriter("src\\POSAnalysisDataset_3\\idFraseLemmiUniBi_cds.txt");
        FileWriter outIntere = new FileWriter("src\\POSAnalysisDataset_3\\idFrasefrasiIntere_cds.txt");

        int counter = 0;
        
        while (fileDataset.hasNextLine()) {

        	try{

				//I:8493	1	But,...
				String riga = fileDataset.nextLine();
				StringTokenizer st = new StringTokenizer(riga,"\t");
				String id = st.nextToken();							//FILM ID: 	I:8493
				int contaRiga = Integer.parseInt(st.nextToken());	//1
				String testoFrase = st.nextToken();						//But,seri....
				//System.out.println(testoFrase);
				ArrayList<String> lemmiFrase = syntax(testoFrase);
				int n =lemmiFrase.size();

				String rigaoutUni="";		String rigaoutBi="";	String rigaoutUniBi="";		String rigaoutIntere="";

				if (n>=2){	//considero solo le frasi con almeno 3 lemmi	//ANCHE 2
					//contaRiga++;
					rigaoutIntere = id + ";" + contaRiga + ";" + testoFrase;	//RIGA INTERA
					rigaoutUni = id + ";" + contaRiga + ";";		//costruzione riga del file di output di unigrammi
					rigaoutBi = "";
					boolean primo= true;
					for(int j=0; j<n-1; j++){	//scorrimento lemmi frase
						if(primo==false) {   	//se non è il primo lemma aggiungo la virgola
							rigaoutUni += ", ";
							rigaoutBi += ", ";
						}
						rigaoutUni += lemmiFrase.get(j);		//aggiunta lemma alla frase
						rigaoutBi += lemmiFrase.get(j) + " " + lemmiFrase.get(j+1);
						primo = false;
					}
					rigaoutUni = rigaoutUni + ", " + lemmiFrase.get(n-1);
					// riga unigrammi -> pronta
					// riga bigrammi -> va aggiunta intestazione
					// riga unigrammi e bigrammi -> aggiungere alla riga unigrammi la riga bigrammi
					rigaoutUniBi = rigaoutUni + ", " + rigaoutBi;
					rigaoutBi = id + ";" + contaRiga + ";" + rigaoutBi;

					outIntere.write(rigaoutIntere + "\n");	//scrittura su file
					outUni.write(rigaoutUni + "\n");
					outBi.write(rigaoutBi + "\n");
					outUniBi.write(rigaoutUniBi + "\n");

					counter++;

					if (counter % 10000 == 0){
						System.out.print("| ");
						if (counter % 30 == 0){
							System.out.println();
						}
					}

				}//FINE IF

			} catch (Throwable t){
        		System.out.println("Sentence deleted.");
			}
			
		}//FINE WHILE

		outIntere.flush();
        outIntere.close();
        outUni.flush();
        outUni.close();
        outBi.flush();
        outBi.close();
        outUniBi.flush();
        outUniBi.close();
        fileDataset.close();
    }
}
