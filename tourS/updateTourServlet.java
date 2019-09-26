package servlets.tourS;

import models.dao.TourDao;
import models.datas.TourData;
import models.impl.DefaultTourDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateTourServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TourDao tourDao = DefaultTourDao.getTourDaoInstance();
        TourData tourData = new TourData();
        tourData.setIdCountry(Integer.parseInt(req.getParameter("idCountry")));
        tourData.setIdTours(Integer.parseInt(req.getParameter("idTours")));
        tourData.setName(req.getParameter("name"));
        tourData.setDescription(req.getParameter("description"));
        tourData.setPrice(Double.parseDouble("price"));

        tourDao.updateTour(tourData);


    }
}
