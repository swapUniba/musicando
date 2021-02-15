package frontend;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;
import java.util.TreeMap;


//CLASSE CHE MODELLA FILM
/* Questa classe modella i vari cd e album, costituiti da:
    - id intero, progressivo
    - asin amazon
    - titolo
    - autori
    - url immagine copertina
*/
public class Locale{
    private int id;
    private String asin, titolo, autori, url;

    public Locale(int id, String asin, String titolo, String autori, String url) {
        this.id = id;
        this.asin = asin;
        this.titolo = titolo;
        this.autori = autori;
        this.url = url;
    }

    public Locale(){

    }

    public Locale(int id) throws Exception {

        Scanner in = new Scanner(new File(Configurazione.path+"info utili/"+id+".txt"));

        this.id = id;
        in.nextLine();
        this.asin = in.nextLine();
        this.titolo = in.nextLine();
        this.autori = in.nextLine();
        this.url = in.nextLine();

        in.close();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutori() {
        return autori;
    }

    public void setAutori(String autori) {
        this.autori = autori;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //metodo che legge le frasi di 1 locale e le restituisce in struttura con id + frase intera
    public static TreeMap<Integer, String> LeggiFrasiLocaleDAT(int locale) throws Exception {
    	ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(Configurazione.path + "frasi singoli items/intere dat/" + locale + ".dat")));
        TreeMap<Integer, String> mappaFrasi = (TreeMap<Integer, String>) ois.readObject();
        ois.close();
        return mappaFrasi;
    }
	
    
}
