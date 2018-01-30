package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.PkgOrder;
import Model.Package;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DAO.PackageDAO;
import DAO.PkgOrderDAO;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

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
    public ModelAndView showAddUserForm(Model model, HttpServletRequest request, HttpServletResponse response) {
	PkgOrder pkg = new PkgOrder();
       	model.addAttribute("pkgForm", pkg);
        return new ModelAndView("cart", "cartPkgList", pkgOrderDAO.getOpenPkgOrdersByCustomerAll(customerId));
    }
    
    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    public ModelAndView deleteCartItem(@ModelAttribute("pkgForm") PkgOrder pkg, BindingResult result, Model model) {
        pkgOrderDAO.deletePkgOrder(pkg.getPkgOrderId());
        return new ModelAndView("redirect:/cart.htm", "pkgOrderList", pkgOrderDAO.getOpenPkgOrdersByCustomer(customerId));

    }
}
