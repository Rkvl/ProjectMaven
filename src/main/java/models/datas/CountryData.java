package models.datas;

public class CountryData {
private int countryId;
private String countryName;


    @Override
    public String toString() {
        return "CountryData{" +
                "countryId=" + countryId +
                ", countryName='" + countryName + '\'' +
                '}';
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
