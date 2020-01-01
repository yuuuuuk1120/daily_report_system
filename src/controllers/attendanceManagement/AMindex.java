package controllers.attendanceManagement;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.AttendanceManagement;
import models.Employee;
import utils.DBUtil;

/**
 * Servlet implementation class AMindex
 */
@WebServlet("/attendance/index")
public class AMindex extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AMindex() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Employee login_employee = (Employee) request.getSession().getAttribute("login_employee");
        List<AttendanceManagement> ams = em.createNamedQuery("getMyAllworks", AttendanceManagement.class)
                .setParameter("employee", login_employee).getResultList();

        em.close();

        request.setAttribute("attendanceManagements", ams);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/attendance/index.jsp");
        rd.forward(request, response);

    }

}
