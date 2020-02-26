package ThreeTierArchitecture.service;

import ThreeTierArchitecture.dao.RouteDao;
import ThreeTierArchitecture.entity.Route;

import java.util.List;

public class RouteService {
    private RouteDao rd = new RouteDao();
    public int findAllRoutes(String test_text) {
        if (rd.findAllRoutes(test_text)) {
            return 1;
        }else {
            return 0;
        }
    }
    }
