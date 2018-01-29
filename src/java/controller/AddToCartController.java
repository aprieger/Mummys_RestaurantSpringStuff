package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.PackageDAO;
import service.PkgOrderDAO;

@Controller
@RequestMapping("/addtocart")
public class AddToCartController{
    private PackageDAO packageDAO;
    private PkgOrderDAO pkgOrderDAO;

    public void setPackageDAO(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
    }
    public void setPkgOrderDAO(PkgOrderDAO pkgOrderDAO) {
        this.pkgOrderDAO = pkgOrderDAO;
    }
    
    @RequestMapping(value="/addtocart", method=RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("addtocart", "packageDetails", packageDAO.getSinglePackageData(Integer.parseInt(request.getParameter("id"))));
    }
}
