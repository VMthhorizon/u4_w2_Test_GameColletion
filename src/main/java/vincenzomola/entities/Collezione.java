package vincenzomola.entities;

import vincenzomola.enums.Genere;
import vincenzomola.enums.Piattaforma;

import java.util.*;

public class Collezione {

    static List<Gioco> collection = new ArrayList<>();

    public static List<Gioco> getCollection() {
        return collection;
    }

    // METODO NUMERO 1
    public static void addElement() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Premi: 1 per inserire un Videogioco | 2 per un Gioco da Tavolo");

        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println("Inserisci il Titolo: ");
        String titolo = scanner.nextLine();
        System.out.println("Inserisci l'Anno di pubblicazione: ");
        int anno = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            System.out.println("Inserisci il genere tra: Action, Strategico, Avventura, Sportivo");
            String genereInput = scanner.nextLine()
                    .toUpperCase();
            Genere genere = Genere.valueOf(genereInput);

            System.out.println("Inserisci la Piattaforma tra: Pc, Xbox, Ps5, Switch");
            String piattaformaInput = scanner.nextLine()
                    .toUpperCase();
            Piattaforma piattaforma = Piattaforma.valueOf(piattaformaInput);

            System.out.println("Inserisci le Ore di Gioco");
            int ore = Integer.parseInt(scanner.nextLine());

            Videogioco videogioco;
            boolean idDuplicato;

            do {
                videogioco = new Videogioco(titolo, anno, piattaforma, ore, genere);

                int idDaVerificare = videogioco.getId();
                idDuplicato = collection.stream()
                        .anyMatch(gioco -> gioco.getId() == idDaVerificare);

            } while (idDuplicato);

            collection.add(videogioco);
        } else if (choice == 2) {
            System.out.println("Inserisci la durata di Gioco in Minuti: ");
            int minuti = Integer.parseInt(scanner.nextLine());

            int numPlayers;
            do {
                System.out.println("Inserisci quante Persone possono giocarci (da 2 a 10): ");
                numPlayers = Integer.parseInt(scanner.nextLine());

                if (numPlayers < 2 || numPlayers > 10) System.out.println("INPUT NON VALIDO, Riprova: ");
            } while (numPlayers < 2 || numPlayers > 10);

            GiocoDaTavolo giocoDaTavolo;
            boolean idDuplicato;

            do {
                giocoDaTavolo = new GiocoDaTavolo(titolo, anno, minuti, numPlayers);

                int idDaVerificare = giocoDaTavolo.getId();
                idDuplicato = collection.stream()
                        .anyMatch(gioco -> gioco.getId() == idDaVerificare);

            } while (idDuplicato);

            collection.add(giocoDaTavolo);
        }
    }

    // METODO NUMERO 2

    public static void ricercaPerId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci l'ID del gioco da cercare: ");

        try {
            int idCercato = Integer.parseInt(scanner.nextLine());

            List<Gioco> risultatoRicerca = collection.stream()
                    .filter(gioco -> gioco.getId() == idCercato)
                    .toList();

            if (!risultatoRicerca.isEmpty()) {
                System.out.println("Il gioco è: " + risultatoRicerca.getFirst());
            } else {
                System.out.println("Gioco non trovato");
            }

        } catch (NumberFormatException e) {
            System.out.println("INPUT NON VALIDO RIPROVA");
        }
    }

    // METODO NUMERO 3

    public static void ricercaPerPrezzo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il budget: ");

        try {
            double budget = Double.parseDouble(scanner.nextLine());

            List<Gioco> giochiEconomici = collection.stream()
                    .filter(gioco -> gioco.getPrice() < budget)
                    .toList();

            if (!giochiEconomici.isEmpty()) {
                System.out.println("Giochi sotto budget: ");
                giochiEconomici.forEach(gioco -> System.out.println("- " + gioco));
            } else {
                System.out.println("Nessun gioco trovato con prezzo inferiore al budget");
            }

        } catch (NumberFormatException e) {
            System.out.println("INPUT NON VALIDO!");
        }

    }

    // METODO 4

    public static void ricercaPerGiocatori() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il numero di giocatori: ");

        try {
            int giocatoriCercati = Integer.parseInt(scanner.nextLine());
            List<Gioco> risultati = new ArrayList<>();
            for (Gioco gioco : collection) {
                if (gioco instanceof GiocoDaTavolo) {
                    GiocoDaTavolo gdt = (GiocoDaTavolo) gioco;

                    if (giocatoriCercati <= gdt.getNumberOfPlayer()) {
                        risultati.add(gdt);
                    }
                }
            }

            if (!risultati.isEmpty()) {
                risultati.forEach(g -> System.out.println("- " + g));
            } else {
                System.out.println("Nessun gioco rovato con questo numero di giocatori");
            }

        } catch (NumberFormatException e) {
            System.out.println("INPUT NON VALIDO");
        }
    }

    // METODO 5
    public static void rimuoviPerId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci l'ID del gioco da rimuovere: ");

        try {
            int idGioco = Integer.parseInt(scanner.nextLine());

            if (collection.removeIf(gioco -> gioco.getId() == idGioco)) {
                System.out.println("Gioco cancellato");
            } else System.out.println("Gioco non trovato");

        } catch (NumberFormatException e) {
            System.out.println("INPUT NON VALIDO!");
        }
    }

    // METODO 6
    public static void aggiornaPerId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci l'ID del gioco: ");

        try {
            int idCercato = Integer.parseInt(scanner.nextLine());

            List<Gioco> giocoTrovato = collection.stream()
                    .filter(gioco -> gioco.getId() == idCercato)
                    .toList();

            if (!giocoTrovato.isEmpty()) {
                Gioco giocoDaModificare = giocoTrovato.get(0);
                System.out.println("Gioco trovato: " + giocoDaModificare.getTitle());
                System.out.println("Inserisci i NUOVI dati per l'aggiornamento.");

                System.out.println("Nuovo Titolo: ");
                giocoDaModificare.setTitle(scanner.nextLine());

                System.out.println("Nuovo Anno di pubblicazione: ");
                giocoDaModificare.setAnnoRilascio(Integer.parseInt(scanner.nextLine()));

                if (giocoDaModificare instanceof Videogioco) {
                    Videogioco videogame = (Videogioco) giocoDaModificare;

                    System.out.println("Nuovo Genere (Action, Strategico, Avventura, Sportivo): ");
                    videogame.setGenere(Genere.valueOf(scanner.nextLine()
                            .toUpperCase()));

                    System.out.println("Nuova Piattaforma (Pc, Xbox, Ps5, Switch): ");
                    videogame.setPiattaforma(Piattaforma.valueOf(scanner.nextLine()
                            .toUpperCase()));

                    System.out.println("Nuove Ore di Gioco: ");
                    videogame.setOreGioco(Integer.parseInt(scanner.nextLine()));

                } else if (giocoDaModificare instanceof GiocoDaTavolo) {
                    GiocoDaTavolo giocoTavolo = (GiocoDaTavolo) giocoDaModificare;

                    System.out.println("Nuova Durata in minuti: ");
                    giocoTavolo.setDurataInMinuti(Integer.parseInt(scanner.nextLine()));

                    int numPlayers;
                    do {
                        System.out.println("Nuovo numero massimo di giocatori (da 2 a 10): ");
                        numPlayers = Integer.parseInt(scanner.nextLine());
                    } while (numPlayers < 2 || numPlayers > 10);

                    giocoTavolo.setNumberOfPlayer(numPlayers);
                }

                System.out.println("Gioco aggiornato");
            }
        } catch (Exception e) {
            System.out.println("Errore durante l'aggiornamento");
        }
    }


    // METODO 7
    public static void stampaStatistiche() {
        if (collection.isEmpty()) {
            System.out.println("Collezione vuota!");
            return;
        }

        long totaleVideogiochi = collection.stream()
                .filter(gioco -> gioco instanceof Videogioco)
                .count();

        long totaleGiochiDaTavolo = collection.stream()
                .filter(gioco -> gioco instanceof GiocoDaTavolo)
                .count();

        System.out.println("Videogiochi: " + totaleVideogiochi);
        System.out.println("Giochi da Tavolo: " + totaleGiochiDaTavolo);

        OptionalDouble optionalMedia = collection.stream()
                .mapToDouble(Gioco::getPrice)
                .average();

        if (optionalMedia.isPresent()) {
            double mediaPrezzi = optionalMedia.getAsDouble();
            System.out.printf("Media prezzi: ", mediaPrezzi);
        }

        List<Gioco> giocoCostoso = collection.stream()
                .max(Comparator.comparingDouble(Gioco::getPrice))
                .stream()
                .toList();

        if (!giocoCostoso.isEmpty()) {
            Gioco piuCaro = giocoCostoso.get(0);
            System.out.println(piuCaro.getTitle() + " è il gioco piu costosto a " + piuCaro.getPrice() + " euro");
        }
    }
}
