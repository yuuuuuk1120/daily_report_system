package controllers.reports;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Report;
import utils.DBUtil;

/**
 * Servlet implementation class ReportsLikeServlet
 */
@WebServlet("/reports/like")
public class ReportsLikeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportsLikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        //        //サーブレットで日報IDを受け取る
        //        //受け取ったIDで日報を検索
        //        Report r = em.find(Report.class, Integer.parseInt(request.getParameter("id")));
        //        System.out.println(request.getParameter("id"));
        //
        //        //検索した日報のいいねを一つ増やす
        //        Integer like_count = (Integer.parseInt(request.getParameter("report_like")));
        //        int click = r.getLike_value();
        //        if (like_count > 0)
        //            click++;
        //        r.setLike_value(click);

        //        int click = r.getLike_value();
        //        if (r.getId() == Integer.parseInt(request.getParameter("id"))) {
        //            click++;
        //        } else if (r.getId() == Integer.parseInt(request.getParameter("id2"))) {
        //            click--;
        //        }
        //
        //        r.setLike_value(click);

        String i1 = request.getParameter("id");
        String i2 = request.getParameter("id2");

        boolean isLike = (i1 != null);

        String i;
        if (isLike) {
            i = i1;
        } else {
            i = i2;
        }


        Report r = em.find(Report.class, Integer.parseInt(i));
        System.out.println(i);

        //クリックして増減
        int click = r.getLike_value();
        if (isLike) {
            click++;
        } else {
            click--;
        }
        r.setLike_value(click);

        //DBを更新
        em.getTransaction().begin();
        em.getTransaction().commit();//DB新規登録を確定
        em.close();

        //        request.setAttribute("report", r);
        //        request.setAttribute("report_like", click);
        //        request.getSession().removeAttribute("report_id");

        response.sendRedirect(request.getContextPath() + "/reports/index");

    }

}
