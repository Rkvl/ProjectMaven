package models.dao;

import models.datas.CountryData;

import java.util.List;

public interface CountryDao {

    List<CountryData> getAllCountryes();

    CountryData getCountryById(int id);

    void addCountry(String countryName);

    boolean deleteCountryById(int id);


}
