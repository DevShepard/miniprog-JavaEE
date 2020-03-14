package ThreeTierArchitecture.service;

import ThreeTierArchitecture.dao.RouteDao;
import ThreeTierArchitecture.entity.Route;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RouteService {
    private String username,userphone,userlocal;
    private RouteDao rd = new RouteDao();
    public boolean findAllRoutes(Map<String, String[]> map) {

        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            if((entry.getKey()).equals("username") ){
                this.username = Arrays.toString(entry.getValue());
            }
            else if((entry.getKey()).equals("userphone") ){
                this.userphone = Arrays.toString(entry.getValue());
            }
            else if((entry.getKey()).equals("userlocal") ){
                this.userlocal = Arrays.toString(entry.getValue());
            }
        }
        if (rd.findAllRoutes(username,userphone,userlocal)) {
            return true;
        }else {
            return false;
        }
    }
    }
