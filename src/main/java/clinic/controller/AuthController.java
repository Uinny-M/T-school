package clinic.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {
    private boolean hasAnyRole() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null
                && auth.isAuthenticated()
                && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")
                || a.getAuthority().equals("ROLE_DOCTOR")
                || a.getAuthority().equals("ROLE_NURSE"));
    }

    @GetMapping(value = {"/login", "/login/{error}"})
    public String login(Model model, @PathVariable(required = false) boolean error) {
        if(hasAnyRole()) {
            return "redirect:/index";
        }

        if(error) {
            model.addAttribute("errorMessage", "Invalid email or password!");
        }

        return "auth";
    }



    @GetMapping(value = "/logout")
    public String logOut() {
        if(!hasAnyRole())  {
            return "redirect:/index";
        }
        return "auth";
    }

    @GetMapping(value = "/performLogOut")
    public String performLogout() {
        if(!hasAnyRole())  {
            return "redirect:/index";
        }
        return "auth";
    }
}
