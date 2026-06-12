package vincenzomola.entities;

import java.time.LocalDate;
import java.util.Random;

public class GiocoDaTavolo extends Gioco {
    //ATTRIBUTI UNICI

    private int numberOfPlayer;
    private int durataInMinuti;

    public GiocoDaTavolo(String title, int annoRilascio, int durataInMinuti, int numberOfPlayer) {
        super(title, annoRilascio);
        this.numberOfPlayer = numberOfPlayer;
        this.durataInMinuti = durataInMinuti;
    }

    public int getDurataInMinuti() {
        return durataInMinuti;
    }

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public void setDurataInMinuti(int durataInMinuti) {
        this.durataInMinuti = durataInMinuti;
    }

    public void setNumberOfPlayer(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    @Override
    public String toString() {
        return "GiocoDaTavolo{" +
                "numberOfPlayer=" + numberOfPlayer +
                ", durataInMinuti=" + durataInMinuti +
                "} " + super.toString();
    }
}
