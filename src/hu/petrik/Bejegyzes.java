package hu.petrik;

import java.time.LocalDateTime;

public class Bejegyzes<DateTime> {
    private String szerzo;
    private String tartalom;
    private int likeok = 0;
    private LocalDateTime letrejott = LocalDateTime.now();
    private LocalDateTime szerkesztve = LocalDateTime.now();

    public Bejegyzes(String szerzo, String tartalom){
        this.szerzo = szerzo;
        this.tartalom = tartalom;

    }

    public String getSzerzo() {
        return szerzo;
    }

    public String getTartalom() {
        return tartalom;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
        this.szerkesztve = LocalDateTime.now();
    }

    public int getLikeok() {
        return likeok;
    }

    public LocalDateTime getLetrejott() {
        return letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        return szerkesztve;
    }

    public void like(){
        this.likeok++;
    }

    @Override
    public String toString() {
        if (this.szerkesztve == LocalDateTime.now()) {
            return this.szerzo + " - " + this.likeok + " - " + this.letrejott +
                    "\nSzerkesztve" + this.szerkesztve + "\n" + this.tartalom;
        } else {
            return this.szerzo + " - " + this.likeok + " - " + this.letrejott +
                    "\n" + this.tartalom;
        }
    }
}
