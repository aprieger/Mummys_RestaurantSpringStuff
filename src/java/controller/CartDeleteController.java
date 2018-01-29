package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PkgOrder;
import model.Package;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.PackageDAO;
import service.PkgOrderDAO;

@Controller
@RequestMapping("/cartdelete")
public class CartDeleteController{
    int customerId=1;
    private PackageDAO packageDAO;
    private PkgOrderDAO pkgOrderDAO;

    public void setPackageDAO(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
    }
    public void setPkgOrderDAO(PkgOrderDAO pkgOrderDAO) {
        this.pkgOrderDAO = pkgOrderDAO;
    }
    
    @RequestMapping(value="/cartdelete", method=RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        pkgOrderDAO.deletePkgOrder(Integer.parseInt(request.getParameter("pkgOrderId")));
        return new ModelAndView("redirect:/cart.htm", "pkgOrderList", pkgOrderDAO.getOpenPkgOrdersByCustomer(customerId));
    }
}
