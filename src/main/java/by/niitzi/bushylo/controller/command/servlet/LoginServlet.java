package by.niitzi.bushylo.controller.command.servlet;

import by.niitzi.bushylo.model.dao.UserDAO;
import by.niitzi.bushylo.model.dao.UserDAOO;
import by.niitzi.bushylo.model.entity.UserAccount;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserDAOO userDAO = new UserDAOO();

        try{
            UserAccount userAccount = userDAO.findUser(login, password);
            String page = "loginPage.jsp";

            if(userAccount != null){
                HttpSession session = req.getSession();
                session.setAttribute("user", userAccount);
                page = "userInfo.jsp";
            }else{
                String message = "Please, full in all the requested info";
                req.setAttribute("message",message);
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
            dispatcher.forward(req, resp);
        }catch (SQLException | ClassNotFoundException e){
            throw new ServletException(e);
        }


//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        //// forward - перенаправить к странице
//        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("web/loginPage.jsp");
//        dispatcher.forward(req, resp);
//
//    }
//будет выполнен когда пользователь введет login & password, и нажимает Submit
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//
//        String login = req.getParameter("loginName");
//        String password = req.getParameter("password");
//
//        UserDAOO userDAO = new UserDAOO();
//
//        UserAccount userAccount = null;
//        try {
//            userAccount = userDAO.findUser(login, password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        String page = "loginPage.jsp";
//
//        if(login.isEmpty() || password.isEmpty()){
//            String message = "Please, full in all the requested info";
//            req.setAttribute("message",message);
//        }else{
//            HttpSession session = req.getSession();
//            session.setAttribute("user", userAccount);
//            page = "userInfo.jsp";
//        }
//        RequestDispatcher dispatcher = req.getRequestDispatcher(page);
//        dispatcher.forward(req, resp);








//    @Override
//    public void destroy() {
//        super.destroy();
//    }
}
}
