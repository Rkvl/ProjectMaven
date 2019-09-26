package servlets.tourS;

import models.dao.TourDao;
import models.datas.TourData;
import models.impl.DefaultTourDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class createTourServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TourDao tourDao = DefaultTourDao.getTourDaoInstance();

        int idCountry = Integer.parseInt(req.getParameter("idCountry"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));

        tourDao.createTour(idCountry,name,description,price);

    }
}
