package vincenzomola.entities;

import vincenzomola.enums.Genere;
import vincenzomola.enums.Piattaforma;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Videogioco extends Gioco {

    //ATTRIBUTI UNICI
    private Piattaforma piattaforma;
    private int oreGioco;
    private Genere genere;

    //COSTRUTTORE
    public Videogioco(String title, int annoRilascio, Piattaforma piattaforma, int oreGioco,
                      Genere genere) {
        super(title, annoRilascio);
        this.piattaforma = piattaforma;
        this.oreGioco = oreGioco;
        this.genere = genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public void setOreGioco(int oreGioco) {
        this.oreGioco = oreGioco;
    }

    public void setPiattaforma(Piattaforma piattaforma) {
        this.piattaforma = piattaforma;
    }

    @Override
    public String toString() {
        return "Videogioco{" +
                "piattaforma=" + piattaforma +
                ", oreGioco=" + oreGioco +
                ", genere=" + genere +
                "} " + super.toString();
    }
}
