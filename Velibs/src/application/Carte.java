package application;

import java.util.ArrayList;

public class Carte {
    private ArrayList<Station> stations;

    public Carte() {
        this.stations = new ArrayList<>();
    }

    public ArrayList<Station> getStations() {
        return this.stations;
    }

    // Méthode pour filtrer les stations par arrondissement
    public ArrayList<Station> filterStationsByArrondissement(String arrondissement) {
        ArrayList<Station> filteredStations = new ArrayList<>();
        for (Station station : stations) {
            if (station.getArrondissement().equals(arrondissement)) {
                filteredStations.add(station);
            }
        }
        System.out.println(filteredStations);
        return filteredStations;
    }
    
    public void setCarte(ArrayList<Station> liste){
    	this.stations = liste;
    }


}
