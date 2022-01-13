package by.niitzi.bushylo.controller.command.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class ServletFilter implements Filter {//проверка всех ЗАПРОСОВ, перед тем как получить доступ к странице
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }



}
