package application;

import org.json.*;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class ConnectAPI {
    // Méthode pour charger les données depuis l'API Vélib
    public ArrayList<Station> chargerStations() throws IOException, URISyntaxException, JSONException {
        ArrayList<Station> stations = new ArrayList<>();
        // Lien de l'API pour les stations Vélib
        String stationsUrl = "https://opendata.paris.fr/api/explore/v2.1/catalog/datasets/velib-disponibilite-en-temps-reel/exports/json?lang=fr&timezone=Europe%2FBerlin";
        // Appel de l'API pour récupérer les données sur les stations
        JSONArray stationsArray = appelAPI(stationsUrl);
        // Parcours du tableau de stations
        for (int i = 0; i < stationsArray.length(); i++) {
            JSONObject stationJson = stationsArray.getJSONObject(i);
            // Analyse des données JSON pour créer des objets Station et les ajouter à la liste
            Station station = analyserStation(stationJson);
            stations.add(station);
        }
        System.out.println();
        return stations;
    }

    // Méthode pour charger les arrondissements depuis l'API Vélib
    public ArrayList<String> chargerArrondissements() throws IOException, URISyntaxException, JSONException {
        ArrayList<String> arrondissements = new ArrayList<>();
        // Lien de l'API pour les arrondissements
        String arrondissementsUrl = "https://opendata.paris.fr/api/explore/v2.1/catalog/datasets/velib-disponibilite-en-temps-reel/exports/json?lang=fr&timezone=Europe%2FBerlin";
        // Appel de l'API pour récupérer les données sur les arrondissements
        JSONArray arrondissementsArray = appelAPI(arrondissementsUrl);
        // Parcours du tableau d'arrondissements
        for (int i = 0; i < arrondissementsArray.length(); i++) {
            String arrondissement = arrondissementsArray.getString(i);
            // Ajout de l'arrondissement à la liste
            arrondissements.add(arrondissement);
        }
        return arrondissements;
    }

    // Méthode pour charger les départements depuis l'API Vélib
    public ArrayList<String> chargerDepartements() throws IOException, URISyntaxException, JSONException {
        ArrayList<String> departements = new ArrayList<>();
        // Lien de l'API pour les départements
        String departementsUrl = "https://opendata.paris.fr/api/explore/v2.1/catalog/datasets/velib-disponibilite-en-temps-reel/exports/json?lang=fr&timezone=Europe%2FBerlin";
        // Appel de l'API pour récupérer les données sur les départements
        JSONArray departementsArray = appelAPI(departementsUrl);
        // Parcours du tableau de départements
        for (int i = 0; i < departementsArray.length(); i++) {
            String departement = departementsArray.getString(i);
            // Ajout du département à la liste
            departements.add(departement);
        }
        
        return departements;
    }

    // Méthode générique pour appeler l'API et récupérer un tableau JSON
    private JSONArray appelAPI(String apiUrl) throws IOException, URISyntaxException, JSONException {
        URL url = new URI(apiUrl).toURL();
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("UTF-8")));
        StringBuilder jsonStr = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonStr.append(line);
        }
        reader.close();
        //System.out.println("Réponse JSON de l'API : " + jsonStr.toString());
        return new JSONArray(jsonStr.toString());
    }

    // Méthode pour analyser un objet JSON représentant une station et créer un objet Station
    private Station analyserStation(JSONObject stationJson) {
        // Analyse des attributs JSON et création d'un objet Station
        String numero = stationJson.getString("stationcode");
        String nom = stationJson.getString("name");
        String ville = stationJson.getString("nom_arrondissement_communes");
        String statut = stationJson.getString("is_installed");
        int capacite = stationJson.getInt("capacity");
        int veloDispo = stationJson.getInt("numbikesavailable");
        int attacheDispo = stationJson.getInt("numdocksavailable");
        String peutDepose = stationJson.getString("is_returning");
        String carteB = stationJson.getString("is_renting");
        //System.out.println("Station - Numéro: " + numero + ", Nom: " + nom + ", Ville: " + ville + ", Statut: " + statut + ", Capacité: " + capacite + ", Vélos Disponibles: " + veloDispo + ", Ports d'attache disponibles: " + attacheDispo + ", Peut déposer: " + peutDepose + ", Carte bleue: " + carteB);
        return new Station(numero, nom, ville, statut, carteB, capacite, veloDispo, attacheDispo, peutDepose, carteB);
    }
}