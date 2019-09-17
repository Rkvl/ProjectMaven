package models.impl;

import connection.DataBaseConnection;
import models.datas.TourData;
import models.dao.TourDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DefaultTourDao implements TourDao {

    DataBaseConnection dataBaseConnection = new DataBaseConnection();


    private static final String GET_ALL_TOURS = "SELECT * FROM our_tours";
    private static final String CREATE_TOUR = "INSERT INTO our_tours" +
            "(id_country, name, description, cost) VALUES(?, ?, ?, ?)";
    private static final String DELETE_TOUR_BY_ID = "DELETE FROM our_tours WHERE id_tour = ?";
    private static final String SELECT_TOUR_BY_ID = "SELECT * FROM our_tour WHERE id_tours = ?";


    @Override
    public List<TourData> getAllTours() {
        List<TourData> tourDataList = new ArrayList<>();
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_TOURS)) {

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                TourData tourData = new TourData();
                tourData.setName(rs.getString("name"));
                tourData.setDescription(rs.getString("description"));
                tourData.setCost(rs.getInt("cost"));
                tourData.setIdCountry(rs.getInt("id_country"));
                tourData.setIdTours(rs.getInt("id_tours"));
                tourDataList.add(tourData);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tourDataList;
    }

    @Override
    public TourData getTourById(int id) {
        TourData tourData = null;

        try (Connection conn = dataBaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_TOUR_BY_ID)) {

            statement.setInt(1, 1);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                tourData = new TourData();
                tourData.setIdTours(rs.getInt("id_tours"));
                tourData.setName(rs.getString("name"));
                tourData.setIdCountry(rs.getInt("id_country"));
                tourData.setDescription(rs.getString("description"));
                tourData.setCost(rs.getInt("cost"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tourData;
    }


    @Override
    public boolean deleteTourById(int id) {


        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_TOUR_BY_ID)) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void createTour(int idCountry, String name, String description, int cost) {
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_TOUR)) {

            statement.setInt(1, idCountry);
            statement.setString(2, name);
            statement.setString(3, description);
            statement.setInt(4, cost);
            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
