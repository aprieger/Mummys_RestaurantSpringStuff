package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Package;
import model.*;
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
import service.PackageDAO;
import service.PkgOrderDAO;

@Controller
public class PackageController{
    private PackageDAO packageDAO;
    private PkgOrderDAO pkgOrderDAO;

    public void setPackageDAO(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
    }
    public void setPkgOrderDAO(PkgOrderDAO pkgOrderDAO) {
        this.pkgOrderDAO = pkgOrderDAO;
    }
    
    @RequestMapping(value="/package", method=RequestMethod.GET)
    public ModelAndView handleRequest(ModelMap map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PkgOrder pkgOrder = new PkgOrder();
        map.addAttribute("pkgOrderDetails", pkgOrder);
        return new ModelAndView("package", "packageDetails", packageDAO.getSinglePackageData(Integer.parseInt(request.getParameter("id"))));
    }
}
