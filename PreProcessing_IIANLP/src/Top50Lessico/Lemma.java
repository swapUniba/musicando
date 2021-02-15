package Top50Lessico;

import java.io.Serializable;

public class Lemma implements Serializable {

    public String lemma;
    public String score;

    public Lemma(String lemma, String score) {
        this.lemma = lemma;
        this.score = score;
    }

    public Lemma(String riga){

        String[] lem = riga.split("\t");

        this.lemma = lem[0].trim();
        this.score = lem[1].trim();


    }

    public String getLemma() {
        return lemma;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString(){
        return this.lemma + ":\t" + this.score;
    }
}
