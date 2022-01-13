package by.niitzi.bushylo.controller.utils;

import by.niitzi.bushylo.controller.command.filter.SecurityConfiguration;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

public class SecurityUtils {//проверяет обязывает ли ЗАПРОС вводить логин, и подходит ли тот ЗАПРОС с РОЛЬЮ вошедшего пользователя

//    public static boolean isSignIn(HttpServletRequest request){
//        String urlPattern = UrlPatternUtils.getUrlPattern(request);
//
//        Set<String> roles = SecurityConfiguration.getAllRoles();
//
//        for(String r : roles){
//            List<String> urlPatternsList = SecurityConfiguration.getPatternsForRole(r);
//
//            if(urlPatternsList != null && urlPatternsList.contains(urlPattern)){
//                return true;
//            }
//        }
//
//        return false;
//
//    }
//
//    //имеет ли ЗАПРОС подходящую роль
//    public static boolean hasRole(HttpServletRequest request){
//        String urlPattern = UrlPatternUtils.getUrlPattern(request);
//
//        Set<String> allRoles = SecurityConfiguration.getAllRoles();
//
//        for(String r : allRoles){
////            if (!request.isSignIn(r)) {
////                continue;
////            }
//
//            List<String> urlPatternsList = SecurityConfiguration.getPatternsForRole(r);
//            if(urlPatternsList != null && urlPatternsList.contains(urlPattern)){
//                return true;
//            }
//        }
//        return false;
//    }
}
