import java.io.*;

public class Main {

    public final static int NB_CLIENTS = 4;

    public static void main(String[] args) throws IOException {

        // Création de l'agence
        Agence lAgence = new Agence("N 10 Rue Edahab, Hay LFARAH, Agadir");

        // Création des Clients et leurs comptes
        Client LClient[] = new Client[NB_CLIENTS];

        LClient[0] = new Client("EL RHYATI", "Aymane", "Ait melloul", lAgence);
        LClient[1] = new Client("Tarzoukt", "Abrahim", "Inezgane", lAgence);
        LClient[2] = new Client("Allal", "hmeed", "Agadir", lAgence);
        LClient[3] = new Client("bouhmd", "hamiid", "ouleed tieeema", lAgence);

        LClient[0].addCompte(new CompteEpargne(8000));
        LClient[1].addCompte(new ComptePayant(550));
        LClient[2].addCompte(new ComptePayant(4800));
        LClient[2].addCompte(new ComptePayant(1000));
        LClient[3].addCompte(new CompteEpargne(2320));
        LClient[3].addCompte(new ComptePayant(4300));

        //file operations 
        FileOutputStream f = new FileOutputStream("comptes");
        ObjectOutputStream o = new ObjectOutputStream(f);

        o.writeObject(LClient);
        f.close(); 
        o.close();

        // Deposer
        if(LClient[0].getCompte(0) != null) {
            LClient[0].getCompte(0).deposer(4400);
        } else {
            System.out.println("Ce compte n'existe pas");
        }

        // Retirer
        if(LClient[2].getCompte(1) != null) {
            LClient[2].getCompte(1).retirer(100);
        } else {
            System.out.println("Ce compte n'existe pas");
        }

        // Ajout des clients 
        for(int i = 0; i < LClient.length; i++) {
            lAgence.addClient(LClient[i]);
        }

        // Application de la méthode calculInteret() sur tous les comptes d'épargne
        for(int i = 0; i < Agence.getNbClients(); i++) {
            for(int j = 0; j < lAgence.getClient(i).getNbCompte(); j++) {
                if (lAgence.getClient(i).getCompte(j) instanceof CompteEpargne) {
                    ((CompteEpargne)lAgence.getClient(i).getCompte(j)).calculInteret();
                }
            }
        }


        // clients avec leurs différents comptes

        System.out.println("clients");

        for(int i = 0; i < Agence.getNbClients(); i++) {
            System.out.println(lAgence.getClient(i).toString());
        }

        //  comptes d'épargne de l'agence

        System.out.println("\ncomptes d'epargne de l'agence");

        for(int i = 0; i < Agence.getNbClients(); i++) {
            for(int j = 0; j < lAgence.getClient(i).getNbCompte(); j++) {
                if (lAgence.getClient(i).getCompte(j) instanceof CompteEpargne) {
                    System.out.println(lAgence.getClient(i).getCompte(j).toString());
                }
            }
        }

        //  comptes payants de l'agence

        System.out.println("\n comptes payants de l'agence ");

        for(int i = 0; i < Agence.getNbClients(); i++) {
            for(int j = 0; j < lAgence.getClient(i).getNbCompte(); j++) {
                if (lAgence.getClient(i).getCompte(j) instanceof ComptePayant) {
                    System.out.println(lAgence.getClient(i).getCompte(j).toString());
                }
            }
        }

    }
}