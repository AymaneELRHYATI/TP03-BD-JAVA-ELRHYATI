import java.io.Serializable;
import java.util.Arrays;

public class Agence implements Serializable{

    // Attributs
    public final static int COMPTES = 80;
    public final static int CLIENTS = 30;


    private int numAg;
    private String adresse;
    private Client[] lClients;
    private Compte[] lComptes;

    private static int nbAgences = 0;
    private static int nbComptes = 0;
    private static int nbClients = 0;

    // Constructors
    public Agence (String adresse) {
        numAg = ++nbAgences;
        this.adresse = adresse;
        lClients = new Client[CLIENTS];
        lComptes = new Compte[COMPTES];
    }

    // Methods
    public void addCompte(Compte nb) {
        if(nbComptes < COMPTES)
            lComptes[nbComptes++] = nb;
        else System.out.println("Vous avez atteindre le nombre max du comptes que vous pouvez avoir");
    }

    public void addClient(Client c) {
        if(nbClients < CLIENTS)
            lClients[nbClients++] = c;
        else System.out.println("Vous avez atteindre le nombre max du clients que vous pouvez avoir");
    }

    // Getters and Setters
    public int getNumAgence() {
        return numAg;
    }

    public void setNumAgence(int numAg) {
        this.numAg = numAg;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Compte getCompte(int n) {
        if(n>=0 && n<lComptes.length){return lComptes[n];}
        else return null;
    }

    public Client getClient(int n) {
        return lClients[n];
    }

    public static int getNbAgences() {
        return nbAgences;
    }

    public static int getNbComptes() {
        return nbComptes;
    }

    public static int getNbClients() {
        return nbClients;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "numAgence=" + numAg +
                ", adresse='" + adresse + '\'' +
                ", lesClients=" + Arrays.toString(lClients) +
                ", lesComptes=" + Arrays.toString(lComptes) +
                '}';
    }

}