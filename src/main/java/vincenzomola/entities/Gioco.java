package vincenzomola.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Gioco {
    Random random = new Random();

    private static List<Integer> idGiàEstratto = new ArrayList<>();

    // ATTRIBUTI COMUNI
    private int id;
    private String title;
    private int annoRilascio;
    private double price;

    //COSTRUTTORE
    public Gioco(String title, int annoRilascio) {
        int nuovoId;

        do {
            nuovoId = random.nextInt(10000, 100000);
        } while (idGiàEstratto.contains(nuovoId));
        idGiàEstratto.add(nuovoId);

        this.id = nuovoId;
        this.title = title;
        this.annoRilascio = annoRilascio;
        this.price = random.nextDouble(3, 111);
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAnnoRilascio(int annoRilascio) {
        this.annoRilascio = annoRilascio;
    }

    @Override
    public String toString() {
        return "Gioco{" +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", annoRilascio=" + annoRilascio +
                ", price=" + price +
                '}';
    }
}
