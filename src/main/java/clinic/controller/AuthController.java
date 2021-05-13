package clinic.controller;

import clinic.dto.EmployeeDTO;
import clinic.entities.Employee;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.logging.Logger;

@Controller
//@RequestMapping(value = "/")
public class AuthController {
//    private Logger logger = Logger.getLogger(AuthController.class);
//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }

    //    private boolean hasAnyRole() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        return auth != null
//                && auth.isAuthenticated()
//                && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")
//                || a.getAuthority().equals("ROLE_DOCTOR")
//                || a.getAuthority().equals("ROLE_NURSE"));
//    }
//
//    @GetMapping(value = "/login")
//    public String login() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth.isAuthenticated()) {
//            return "redirect:/index";
//        } else {
//            return "login";
//        }
//    }
    @GetMapping(value = "/login")
    public String login(HttpServletRequest request,
                        @RequestParam(required = false) boolean error) {
//                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth.isAuthenticated()&&!error) {
//            return "index";
//        }
//        else
        return "login";
    }

    @GetMapping(value = "/logout")
    public String performLogout() {
        return "index";
    }
//
//
//
//    @GetMapping(value = "/logout")
//    public String logOut() {
//        if(!hasAnyRole())  {
//            return "redirect:/index";
//        }
//        return "login";
//    }
//
//    @GetMapping(value = "/performLogOut")
//    public String performLogout() {
//        if(!hasAnyRole())  {
//            return "redirect:/index";
//        }
//        return "login";
//    }
}
