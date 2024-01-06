import java.io.Serializable;
import java.util.Arrays;

public class Client implements Serializable {

    // Attributes
    public final int MAX_COMPTE = 4;

    private int code;
    private final String nom;
    private final String prenom;
    private String adresse;
    private Agence monAgence;
    Compte[] mesComptes;
    private int nbCompte = 0;

    private static int nbClient = 0;

    // Constructor

    public Client(String nom, String prenom, String adresse, Agence agence) {
        code = ++ nbClient;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.monAgence = agence;
        mesComptes = new Compte[MAX_COMPTE];
    }

    // Methods
    public void addCompte(Compte c) {
        if(nbCompte < MAX_COMPTE)
            mesComptes[nbCompte++] = c;
        else System.out.println("Vous avez atteindre le nombre max du comptes que vous pouvez avoir");
    }

    public void deposer(int nCompte, double montant) {
        mesComptes[nCompte].deposer(montant);
    }

    public void retirer(int nCompte, double montant) {
        mesComptes[nCompte].retirer(montant);
    }

    // Getters and Setters
    public Compte getCompte(int n) {
        return mesComptes[n];
    }

    public int getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Agence getMonAgence() {
        return monAgence;
    }

    public void setMonAgence(Agence monAgence) {
        this.monAgence = monAgence;
    }

    public int getNbCompte() {
        return nbCompte;
    }

    public static int getNbClient() {
        return nbClient;
    }

    @Override
    public String toString() {
        return "Client{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", mesComptes=" + Arrays.toString(mesComptes) +
                '}';
    }

}
