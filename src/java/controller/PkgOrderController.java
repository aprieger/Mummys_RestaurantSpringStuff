package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import model.PkgOrder;
import service.PkgOrderDAO;

public class PkgOrderController extends SimpleFormController{
    private PkgOrderDAO pkgOrderDAO;
    
    //public PkgOrderController() {
    //    setCommandClass(Package.class);
    //    setCommandName("user");
    //}

    public void setPkgOrderDAO(PkgOrderDAO pkgOrderDAO) {
        this.pkgOrderDAO = pkgOrderDAO;
    }
    
    //@Override
    //protected ModelAndView onSubmit(Object command) throws Exception{
    //    PkgOrder pkgOrder=(PkgOrder)command;
    //    return new ModelAndView("userSuccess","pkgOrder",pkgOrder);
    //}
    
    //@RequestMapping(value="/package", method=RequestMethod.GET)
    //public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    //    return new ModelAndView("package", "packageDetails", packageDAO.getSinglePackageData(Integer.parseInt(request.getQueryString())));
    //}
}
