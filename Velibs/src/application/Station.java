package application;

public class Station {
    private String numero;
    private String nom;
    private String statut;
    private int capacite;
    private int veloDispo;
    private int attacheDispo;
    private String peutDepose;
    private String carteB;
    private String ville;
    private String arrondissement;

    public Station(String numero, String nom, String ville, String arrondissement, String statut, int capacite, int veloDispo, int attacheDispo, String peutDepose, String carteB) {
        this.numero = numero;
        this.nom = nom;
        this.ville = ville;
        this.arrondissement = "";
        this.statut = statut;
        this.capacite = capacite;
        this.veloDispo = veloDispo;
        this.attacheDispo = attacheDispo;
        this.peutDepose = peutDepose;
        this.carteB = carteB;
    }

    // Getters et setters

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public int getVeloDispo() {
        return veloDispo;
    }

    public void setVeloDispo(int veloDispo) {
        this.veloDispo = veloDispo;
    }

    public int getAttacheDispo() {
        return attacheDispo;
    }

    public void setAttacheDispo(int attacheDispo) {
        this.attacheDispo = attacheDispo;
    }

    public String getPeutDepose() {
        return peutDepose;
    }

    public void setPeutDepose(String peutDepose) {
        this.peutDepose = peutDepose;
    }

    public String getCarteB() {
        return carteB;
    }

    public void setCarteB(String carteB) {
        this.carteB = carteB;
    }

    public String getArrondissement() {
        // Récupère le numéro de station
        String numero = this.numero;
        // Si le numéro est composé de moins de 5 caractères, prenez le premier caractère comme arrondissement
        if (numero.length() <5) {
            arrondissement = numero.substring(0, 1);
        } else if (numero.length() >= 5) {
            int num = Integer.parseInt(numero.substring(0, 5));
         // Vérifiez les plages de numéros de station pour déterminer le département
            if (num >= 10000 && num < 21000) {
                arrondissement = numero.substring(0, 2);
            } else if (num >= 21000 && num < 30000) {
                arrondissement = "92";
            } else if (num >= 30000 && num < 40000) {
                arrondissement = "93";
            } else if (num >= 40000 && num < 50000) {
                arrondissement = "94";
            } else if (num >= 50000 && num < 60000) {
                arrondissement = "95";
            } else {
                return arrondissement = "Mobile";
            }
        }
        return arrondissement;
    }

    public void setArrondissement(String arrondissement) {
        this.arrondissement = arrondissement;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    // Méthode toString pour afficher les informations de la station
    @Override
    public String toString() {
        return "Station{" +
                "numero='" + numero + '\'' +
                ", nom='" + nom + '\'' +
                ", ville='" + ville + '\'' +
                ", arrondissement='" + arrondissement + '\'' +
                ", statut='" + statut + '\'' +
                ", capacite=" + capacite +
                ", veloDispo=" + veloDispo +
                ", attacheDispo=" + attacheDispo +
                ", peutDepose='" + peutDepose + '\'' +
                ", carteB='" + carteB + '\'' +
                '}';
    }
}
