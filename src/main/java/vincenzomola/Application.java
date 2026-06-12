package vincenzomola;

import vincenzomola.entities.Collezione;
import vincenzomola.entities.GiocoDaTavolo;
import vincenzomola.entities.Videogioco;
import vincenzomola.enums.Genere;
import vincenzomola.enums.Piattaforma;

import java.util.List;
import java.util.Scanner;

import static vincenzomola.entities.Collezione.*;


public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numInput;


        Collezione.getCollection()
                .addAll(List.of(
                        new Videogioco("Sonic", 2022, Piattaforma.PC, 150, Genere.AVVENTURA),
                        new Videogioco("Fifa 24", 2023, Piattaforma.PS5, 200, Genere.SPORTIVO),
                        new Videogioco("Cyberpunk 2077", 2020, Piattaforma.XBOX, 90, Genere.AVVENTURA),
                        new Videogioco("Fifa 22", 2021, Piattaforma.PC, 500, Genere.STRATEGICO),
                        new Videogioco("Batman Arkham Knight", 2015, Piattaforma.PS5, 45, Genere.ACTION),
                        new GiocoDaTavolo("Monopoly", 1935, 90, 6),
                        new GiocoDaTavolo("Dungeons & Dragons", 1974, 180, 8),
                        new GiocoDaTavolo("Risiko", 1957, 120, 2),
                        new GiocoDaTavolo("Taboo", 1995, 75, 4),
                        new GiocoDaTavolo("Bang", 2008, 30, 3)));

        while (true) {
            try {
                System.out.println(
                        "Digita: \n 1 per AGGIUNGERE un GIOCO \n 2 per RICERCA tramite ID \n 3 per RICERCA per " +
                                "PREZZO" +
                                " \n " +
                                "4 " +
                                "per " +
                                "RICARCA per GIOCATORI \n 5 per RIMUOVERE un ELEMENTO tramite ID \n 6 per " +
                                "AGGIORNARE " +
                                "un " +
                                "ELEMENTO tramite ID \n 7 per STATISTICHE della COLLEZIONE \n 0 per USCIRE");
                numInput = Integer.parseInt(scanner.nextLine());

                if (numInput == 0) break;
                switch (numInput) {
                    case 1 -> addElement();
                    case 2 -> ricercaPerId();
                    case 3 -> ricercaPerPrezzo();
                    case 4 -> ricercaPerGiocatori();
                    case 5 -> rimuoviPerId();
                    case 6 -> aggiornaPerId();
                    case 7 -> stampaStatistiche();

                    default -> System.out.println("ELEMENTO NON VALIDO RIPROVA");
                }
            } catch (Exception e) {
                System.out.println("INPUT INSERITO NON VALIDO, RIPROVA: ");
            }
            System.out.println(Collezione.getCollection());
        }
    }
}
