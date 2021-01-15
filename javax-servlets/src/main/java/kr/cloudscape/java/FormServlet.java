package kr.cloudscape.java;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 classes annotated with @WebServlet must extend the javax.servlet.http.HttpServlet class.
 It is important to note that @WebServlet annotation is only available from Java EE 6 onward.
 */
@WebServlet(name = "FormServlet", urlPatterns = "/calculateServlet")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String height = req.getParameter("height");
        String weight = req.getParameter("weight");

        try {
            double bmi = calculateBMI(Double.parseDouble(weight), Double.parseDouble(height));

            req.setAttribute("bmi", bmi);
            resp.setHeader("Test", "Success");
            resp.setHeader("BMI", String.valueOf(bmi));

            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    private double calculateBMI(Double weight, Double height) {
        return weight / (height * height);
    }
}
