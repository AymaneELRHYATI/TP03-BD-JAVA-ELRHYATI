import java.io.Serializable;

public class Compte implements Serializable {

    // Attributs
    private static int nbCompte = 0;

    protected int code;
    protected double solde;
    protected Agence lAgence;
    protected Client proprietaire;

    // Constructors
    public Compte() {}

    public Compte(double solde) {
        this.solde = solde;
        code = ++nbCompte;
    }

    public Compte(Client client, Agence agence) {
        this(50.00, client, agence);
    }

    public Compte(double solde, Client client, Agence agence) {
        code = ++nbCompte;
        this.solde = solde;
        this.proprietaire = client;
        this.lAgence = agence;
    }

    // Methods
    public void retirer(double montant) {
        if (montant < solde) solde -= montant;
    }

    public void deposer(double montant) {
        solde += montant;
    }

    // Getters and Setters

    public static int getNbCompte() {
        return nbCompte;
    }

    public static void setNbCompte(int nbCompte) {
        Compte.nbCompte = nbCompte;
    }

    public int getCode() {
        return code;
    }

    public double getSolde() {
        return solde;
    }

    public Agence getlAgence() {
        return lAgence;
    }

    public Client getProprietaire() {
        return proprietaire;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "solde=" + solde +
                ", code=" + code +
                '}';
    }
}