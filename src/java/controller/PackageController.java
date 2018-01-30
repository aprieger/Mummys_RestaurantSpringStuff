package Controller;

import Model.PkgOrder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import DAO.PackageDAO;
import DAO.PkgOrderDAO;

@Controller
@RequestMapping("/packages")
public class PackageController{
    int customerId=1;
    private PackageDAO packageDAO;
    private PkgOrderDAO pkgOrderDAO;

    public void setPackageDAO(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
    }
    public void setPkgOrderDAO(PkgOrderDAO pkgOrderDAO) {
        this.pkgOrderDAO = pkgOrderDAO;
    }
    
    @RequestMapping(value = "/package", method = RequestMethod.GET)
    public ModelAndView handleRequest(Model model, HttpServletRequest request, HttpServletResponse response) {
	PkgOrder pkgOrder = new PkgOrder();
	model.addAttribute("formPkgOrder", pkgOrder);
        return new ModelAndView("package", "packageDetails", packageDAO.getSinglePackageData(Integer.parseInt(request.getParameter("packageId"))));
    }
    
    @RequestMapping(value = "/package", method = RequestMethod.POST)
    public ModelAndView addPackage(@ModelAttribute("formPkgOrder") PkgOrder formPkgOrder, BindingResult result, Model model) {
        PkgOrder newPkgOrder = new PkgOrder();
        System.out.println("---getPkgOrderId: "+formPkgOrder.getPkgOrderId());
        System.out.println("---getOrderId: "+formPkgOrder.getOrderId());
        System.out.println("---getPackageId: "+formPkgOrder.getPackageIdKey());
        System.out.println("---getCustomerId: "+formPkgOrder.getCustomerId());
        System.out.println("---getPricePerPkg: "+formPkgOrder.getPricePerPkg());
        System.out.println("---getQuantity: "+formPkgOrder.getQuantity());
        System.out.println("---getIsOpen: "+formPkgOrder.getIsOpen());
        Package pkg = packageDAO.getSinglePackageData(formPkgOrder.getPackageIdKey());
        
        newPkgOrder.setPkgOrderId(pkgOrderDAO.getNextPkgOrderId());
        newPkgOrder.setOrderId(0);
        newPkgOrder.setPackageIdKey(formPkgOrder.getPackageIdKey());
        newPkgOrder.setCustomerId(customerId);
        newPkgOrder.setPricePerPkg(pkg.getPrice());
        newPkgOrder.setQuantity(formPkgOrder.getQuantity());
        newPkgOrder.setIsOpen(1);
        pkgOrderDAO.addOpenPkgOrder(newPkgOrder);
        
        return new ModelAndView("redirect:/cart.htm", "pkgOrderList", pkgOrderDAO.getOpenPkgOrdersByCustomer(customerId));
    }
}
