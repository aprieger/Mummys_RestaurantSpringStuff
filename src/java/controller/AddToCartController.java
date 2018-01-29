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
@RequestMapping("/addtocart")
public class AddToCartController{
    int customerId=1;
    private PackageDAO packageDAO;
    private PkgOrderDAO pkgOrderDAO;

    public void setPackageDAO(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
    }
    public void setPkgOrderDAO(PkgOrderDAO pkgOrderDAO) {
        this.pkgOrderDAO = pkgOrderDAO;
    }
    
    @RequestMapping(value="/addtocart", method=RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        PkgOrder pkgOrder = new PkgOrder();
        Package pkg = packageDAO.getSinglePackageData(Integer.parseInt(request.getParameter("packageId")));
        
        pkgOrder.setPkgOrderId(pkgOrderDAO.getNextPkgOrderId());
        pkgOrder.setOrderId(0);
        pkgOrder.setPackageId(Integer.parseInt(request.getParameter("packageId")));
        pkgOrder.setCustomerId(customerId);
        pkgOrder.setPricePerPkg(pkg.getPrice());
        pkgOrder.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        pkgOrder.setIsOpen(1);
        pkgOrderDAO.addOpenPkgOrder(pkgOrder);
        
        return new ModelAndView("redirect:/cart.htm", "pkgOrderList", pkgOrderDAO.getOpenPkgOrdersByCustomer(customerId));
    }
}
