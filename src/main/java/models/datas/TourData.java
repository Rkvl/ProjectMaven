package models.datas;



public class TourData {

    private int idTours;
    private int idCountry;
    private String description;
    private String name;

    private int cost;

    @Override
    public String toString() {
        return "TourData{" +
                "idTours=" + idTours +
                ", idCountry=" + idCountry +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdTours() {
        return idTours;
    }

    public void setIdTours(int idTours) {
        this.idTours = idTours;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
