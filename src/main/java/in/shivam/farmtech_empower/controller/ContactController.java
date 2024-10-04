package in.shivam.farmtech_empower.controller;

import in.shivam.farmtech_empower.entity.Contact;
import in.shivam.farmtech_empower.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public String showContactForm(Model model, HttpSession session) {
        model.addAttribute("contact", new Contact());

        // Retrieve message from session if present
        String successMessage = (String) session.getAttribute("successMessage");
        String errorMessage = (String) session.getAttribute("errorMessage");

        if (successMessage != null) {
            model.addAttribute("successMessage", successMessage);
            session.removeAttribute("successMessage"); // Clear the message after displaying
        }

        if (errorMessage != null) {
            model.addAttribute("errorMessage", errorMessage);
            session.removeAttribute("errorMessage"); // Clear the message after displaying
        }

        return "contact";
    }

    @PostMapping("/contact")
    public String submitContactForm(@ModelAttribute Contact contact, HttpSession session) {
        boolean isSaved = contactService.saveContact(contact);
        
        if (isSaved) {
            session.setAttribute("successMessage", "Message sent Successfully!");
            return "redirect:/contact";
        } else {
            session.setAttribute("errorMessage", "Failed to send message. Please try again.");
            return "redirect:/contact";
        }
    }
}
