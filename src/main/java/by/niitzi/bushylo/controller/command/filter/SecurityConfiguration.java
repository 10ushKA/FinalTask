package by.niitzi.bushylo.controller.command.filter;

import java.util.*;

public class SecurityConfiguration {//или все же через UserDAOOO

    private static final String ROLE_USER = "USER";
    private static final String ROLE_ADMIN = "ADMIN";

    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

    private static void init(){
        List<String> urlPatternUser = new ArrayList<>();
        List<String> urlPatternAdmin = new ArrayList<>();

        urlPatternUser.add("/userInfo");
        mapConfig.put(ROLE_USER, urlPatternUser);

        urlPatternAdmin.add("/userInfo");
        urlPatternAdmin.add("/adminInfo");
        mapConfig.put(ROLE_ADMIN, urlPatternAdmin);
    }

    public static Set<String> getAllRoles(){
        return mapConfig.keySet();
    }

    public static List<String> getPatternsForRole(String role){
        return mapConfig.get(role);
    }
}
