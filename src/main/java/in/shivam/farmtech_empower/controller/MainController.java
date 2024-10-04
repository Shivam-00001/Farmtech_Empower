   package in.shivam.farmtech_empower.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.shivam.farmtech_empower.entity.User;
import in.shivam.farmtech_empower.repository.UserRepo;
import in.shivam.farmtech_empower.service.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    // Set common user details into model when authenticated
    @ModelAttribute
    public void commonUser(Principal p, Model m) {
        if (p != null) {
            String email = p.getName();
            User user = userRepo.findByEmail(email);
            m.addAttribute("user", user);
        }
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/Terms_of_Service")
    public String Terms_of_Service() {
        return "Terms_of_Service";
    }

    @GetMapping("/PrivacyPolicy")
    public String PrivacyPolicy() {
        return "PrivacyPolicy";
    }

    @GetMapping("/calculator")
    public String calculator() {
        return "calculator";
    }

    @GetMapping("/signin")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/ourproducts")
    public String ourproducts() {
        return "ourproducts";
    }

    @GetMapping("/product-details")
    public String productDetails() {
        return "product-details";
    }

    @GetMapping("/OrderNow")
    public String orderNow() {
        return "OrderNow";
    }

    @GetMapping("/user/profile")
    public String profile(Principal p, Model m) {
        if (p != null) {
            String email = p.getName();
            User user = userRepo.findByEmail(email);
            m.addAttribute("user", user);
        }
        return "profile";
    }

    @GetMapping("/signup")
    public ModelAndView signup(HttpSession session) {
        ModelAndView mav = new ModelAndView("signup");

        String msg = (String) session.getAttribute("msg");
        if (msg != null) {
            mav.addObject("msg", msg);
            session.removeAttribute("msg");
        }

        return mav;
    }

    @PostMapping("/saveUser")
    public String createUser(@ModelAttribute User user, HttpSession session) {
        boolean emailExists = userService.checkEmail(user.getEmail());

        if (emailExists) {
            session.setAttribute("msg", "Email ID already exists");
            return "redirect:/signup";
        } else {
            User userDtls = userService.saveUser(user);
            if (userDtls != null) {
                session.setAttribute("msg", "Registered Successfully");
            } else {
                session.setAttribute("msg", "Something went wrong");
            }
            return "redirect:/signup";
        }
    }
}
