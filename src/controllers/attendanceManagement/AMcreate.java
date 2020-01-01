package controllers.attendanceManagement;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.AttendanceManagement;
import models.Employee;
import utils.DBUtil;

/**
 * Servlet implementation class AMcreate
 */
@WebServlet("/attendance/create")
public class AMcreate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AMcreate() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EntityManager em = DBUtil.createEntityManager();
        AttendanceManagement a = new AttendanceManagement();

        String date = request.getParameter("date");
        String startTime = request.getParameter("startTime");
        String finishTime = request.getParameter("finishTime");

        //        System.out.println(date);
        //        System.out.println(startTime);
        //        System.out.println(finishTime);

        String dayWork = date + " " + "00:00:00";
        String startDateTime = date + " " + startTime + ":00";
        String finishDateTime = date + " " + finishTime + ":00";
        //        System.out.println(startDateTime);
        //        System.out.println(finishDateTime);

        a.setDay_time(Timestamp.valueOf(dayWork));
        a.setStart_from(Timestamp.valueOf(startDateTime));
        a.setFinish_at(Timestamp.valueOf(finishDateTime));

        SimpleDateFormat sdf1 = new SimpleDateFormat("h/m");
        sdf1.format(a.getStart_from());
        sdf1.format(a.getFinish_at());

        HttpSession session = ((HttpServletRequest) request).getSession();
        Employee e = (Employee) session.getAttribute("login_employee");
        a.setEmployee(e);

        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();

        response.sendRedirect(request.getContextPath() + "/attendance/index");
    }

}
