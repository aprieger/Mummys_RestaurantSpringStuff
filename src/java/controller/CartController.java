package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PkgOrder;
import model.Package;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.PackageDAO;
import service.PkgOrderDAO;

@Controller
@RequestMapping("/cart")
public class CartController{
    int customerId=1;
    private PackageDAO packageDAO;
    private PkgOrderDAO pkgOrderDAO;

    public void setPackageDAO(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
    }
    public void setPkgOrderDAO(PkgOrderDAO pkgOrderDAO) {
        this.pkgOrderDAO = pkgOrderDAO;
    }
    
    @RequestMapping(value="/cart", method=RequestMethod.GET)
    public ModelAndView handleRequest(ModelMap map, HttpServletRequest request, HttpServletResponse response) throws Exception{
        //map.addAttribute("pkgCollectionList",)
        return new ModelAndView("cart", "cartPkgList", pkgOrderDAO.getOpenPkgOrdersByCustomerAll(customerId));
    }
}
