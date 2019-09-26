package servlets.tourS;

import models.dao.TourDao;
import models.impl.DefaultTourDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteTourServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TourDao tourDao = DefaultTourDao.getTourDaoInstance();
        int id = Integer.parseInt(req.getParameter("idTours"));
        tourDao.deleteTourById(id);

    }
}
