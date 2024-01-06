

public class ComptePayant extends Compte  {

    // Attributs
    private final double TAUX_OPERATION = 5;
    public final String typeCompteP = "ComptePayant";

    // Constructors
    public ComptePayant(double solde) {
        super(solde);
    }

    public ComptePayant(Client client, Agence agence) {
        super(client, agence);
    }

    public ComptePayant(double solde, Client client, Agence agence) {
        super(solde, client, agence);
    }

    // Methods
    public void retirer(double mt) {
        super.retirer(mt + TAUX_OPERATION);
    }

    public void deposer (double mt) {
        super.deposer(mt - TAUX_OPERATION);
    }

    // Getters and Setters
    public String getTypeCompteP() {
        return typeCompteP;
    }

    @Override
    public String toString() {
        return "ComptePayant{" +
                "solde=" + super.getSolde() +
                ", code=" + super.getCode() +
                '}';
    }
}