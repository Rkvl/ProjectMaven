package models.dao;

import models.datas.TourData;


import java.util.List;

public interface TourDao {

    List<TourData> getAllTours();

    TourData getTourById(int id);

    boolean deleteTourById(int id);

    void createTour(int idCountry, String name, String description, int cost);


}
