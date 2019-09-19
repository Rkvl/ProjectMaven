package models;

import models.dao.CountryDao;
import models.dao.OrderDao;
import models.dao.TourDao;
import models.dao.UserDao;
import models.datas.CountryData;
import models.datas.OrdersData;
import models.datas.UserData;
import models.impl.DefaultCountryDao;
import models.impl.DefaultOrderDao;
import models.impl.DefaultTourDao;
import models.impl.DefaultUserDao;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        // UserDao userDao = new DefaultUserDao();
        // List<UserData> userData = userDao.getAllUsers();
        // userDao.createUser("Ruslan", "Kovalets", "12345", "yandex.ua", 1);
        // System.out.println(userData);
        // userDao.updateUser(2, "Alexei","Kovalets", "root", "@gmail.com", 0);

        //  TourDao tourDao = new DefaultTourDao();
        //  List<TourData> tourData = tourDao.getAllTours();
        // tourDao.createTour(1,"good tour", "veryy good tour", 3000);
        // System.out.println(tourData);


      //  CountryDao countryDao = new DefaultCountryDao();
      //  List<CountryData> countryData = countryDao.getAllCountryes();
      //  System.out.println(countryData);
      //  countryDao.deleteCountryById(2);


        OrderDao orderDao = new DefaultOrderDao();
        OrdersData save = new OrdersData();

        List<OrdersData> ordersData = orderDao.getAllOrders();

        save.setOrderId(1);
        save.setUserId(15);
        save.setTourId(21);

        orderDao.updateOrder(save);


        System.out.println(ordersData);

    }
}
