package models.impl;

import connection.DataBaseConnection;
import models.dao.CountryDao;
import models.datas.CountryData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DefaultCountryDao implements CountryDao {

    DataBaseConnection dataBaseConnection = new DataBaseConnection();

    private static final String ADD_COUNTRY = "INSERT INTO countryes" + "(name_country) VALUES(?)";
    private static final String GET_ALL_COUNTRYES = "SELECT * FROM countryes";
    private static final String GET_COUNTRY_BY_ID = "SELECT FROM countryes WHERE id_country = ?";
    private static final String DELETE_COUNTRY_BY_ID = "DELETE FROM countryes WHERE id_country = ?";


    @Override
    public List<CountryData> getAllCountryes() {
        List<CountryData> countryDataList = new ArrayList<>();
        CountryData countryData = null;

        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_COUNTRYES);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                countryData = new CountryData();
                countryData.setCountryName(rs.getString("name_country"));
                countryData.setCountryId(rs.getInt("id_country"));
                countryDataList.add(countryData);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countryDataList;
    }

    @Override
    public CountryData getCountryById(int id) {
        CountryData countryData = null;
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_COUNTRY_BY_ID)) {

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                countryData = new CountryData();
                countryData.setCountryId(rs.getInt("id_country"));
                countryData.setCountryName(rs.getString("name_country"));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public void addCountry(String countryName) {
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_COUNTRY)) {

            preparedStatement.setString(1, countryName);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean deleteCountryById(int id) {
        try(Connection connection = dataBaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COUNTRY_BY_ID)){

        preparedStatement.setInt(1,id);

        preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }



        return false;
    }
}
