package by.niitzi.bushylo.controller.utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Map;

//Servlet urlPattern = /spath/*
//URL ЗАПРОСА: http://localhost:8081/FinalTask(context path)/spath(servlet path)/path Info...

public class UrlPatternUtils  {

//    public boolean hasUrlPattern(ServletContext servletContext, String urlPattern){
//
//        Map<String, ? extends ServletRegistration> map = servletContext.getServletRegistration();
//
//        for(String servletName : map.keySet()){
//            ServletRegistration servletRegistration = map.get(servletName);
//
//            Collection<String> mappings = servletRegistration.getMappings();//get the currently available mappings of the Servlet represented by ServletRegistration
//
//            if(mappings.contains(urlPattern)){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static String getUrlPattern(HttpServletRequest request){
//        ServletContext servletContext = request.getServletContext();
//        String servletPath = request.getServletPath();
//        String pathInfo = request.getPathInfo();
//
//        String urlPattern;
//        if (pathInfo != null){
//            urlPattern = servletPath + "/*";
//            return urlPattern;
//        }
//
//        urlPattern = servletPath;
//
//
//
//
//
//
//        return "/";
//
//
//    }
//
//
}
