package by.niitzi.bushylo.controller.command.servlet;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = { "/logout" })
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServlet req, HttpServlet resp) throws ServletException, IOException {
        super.doGet((HttpServletRequest) req, (HttpServletResponse) resp);
        HttpSession session = ((HttpServletRequest) req).getSession(false);
        if (session != null){
            session.removeAttribute("user");

            RequestDispatcher dispatcher = ((HttpServletRequest) req).getRequestDispatcher("login.jsp");
            dispatcher.forward((ServletRequest) req, (ServletResponse) resp);
        }

    }
}
