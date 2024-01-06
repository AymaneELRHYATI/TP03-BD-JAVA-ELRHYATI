

public class CompteEpargne extends Compte  {

    // Attributs
    public final String typeCompteP = "CompteEpargne";

    private double tauxInteret = 6;

    // Constructors
    public CompteEpargne(double solde) {
        super(solde);
    }

    public CompteEpargne(Client client, Agence agence) {
        super(client, agence);
    }

    public CompteEpargne(double solde, Client client, Agence agence) {
        super(solde, client, agence);
    }

    // Methods
    public void calculInteret() {
        super.deposer(getSolde() * tauxInteret / 100);
    }

    // Getters and Setters
    public String getTypeCompteP() {
        return typeCompteP;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    @Override
    public String toString() {
        return "CompteEpargne{" +
                "solde=" + super.getSolde() +
                ", code=" + super.getCode() +
                '}';
    }
}