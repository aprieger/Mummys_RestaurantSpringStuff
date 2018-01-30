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
@RequestMapping("/adminpackages")
public class AdminPackageEditController{
    private PackageDAO packageDAO;
    private PkgOrderDAO pkgOrderDAO;

    public void setPackageDAO(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
    }
    public void setPkgOrderDAO(PkgOrderDAO pkgOrderDAO) {
        this.pkgOrderDAO = pkgOrderDAO;
    }
    //@RequestMapping(value="/adminpackageedit", method=RequestMethod.GET)
    //public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
    //    return new ModelAndView("adminpackageedit", "packageDetails", packageDAO.getSinglePackageData(Integer.parseInt(request.getParameter("packageId"))));
    //}
    
    @RequestMapping(value = "/adminpackageedit", method = RequestMethod.GET)
    public ModelAndView showAddUserForm(Model model, HttpServletRequest request, HttpServletResponse response) {
	Package pkg = new Package();
       	model.addAttribute("pkgForm", pkg);
        return new ModelAndView("adminpackageedit", "packageDetails", packageDAO.getSinglePackageData(Integer.parseInt(request.getParameter("packageId"))));
    }
    
    @RequestMapping(value = "/adminpackageedit", method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("pkgForm") Package pkg, BindingResult result, Model model) {
        System.out.println(pkg.getName());
        packageDAO.editName(pkg.getPackageId(), pkg.getName());
        //packageDAO.editPackage(pkg.getPackageId(), pkg.getName(), pkg.getDescription(), pkg.getMealCategory(), pkg.getImageSource(), pkg.getPrice(), pkg.getIsSpecial(), pkg.getMealType());
        return "redirect:/adminpackages.htm";
    }
}
