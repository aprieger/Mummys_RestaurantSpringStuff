package Controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Package;
import Model.PkgOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import DAO.PackageDAO;

@Controller
public class MenuController{
    private PackageDAO packageDAO;

    public void setPackageDAO(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
    }
    
    @RequestMapping(value="/menu", method=RequestMethod.GET)
    public ModelAndView handleRequest(ModelMap map, HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        return new ModelAndView("menu", "packageList", packageDAO.getAllPackageData());
    }
}
