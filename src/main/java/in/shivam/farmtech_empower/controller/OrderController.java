package in.shivam.farmtech_empower.controller;

import in.shivam.farmtech_empower.entity.DeliveryAddress;
import in.shivam.farmtech_empower.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderController {

    @Autowired
    private DeliveryAddressService deliveryAddressService;

    @PostMapping("/submitOrder")
    public String submitOrder(
            @RequestParam("fullName") String fullName,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("pincode") String pincode,
            @RequestParam("state") String state,
            @RequestParam("city") String city,
            @RequestParam("houseNo") String houseNo,
            @RequestParam("quantity") Integer quantity,
            @RequestParam("productNo") String productNo, // New parameter
            RedirectAttributes redirectAttributes) {

        DeliveryAddress address = new DeliveryAddress();
        address.setFullName(fullName);
        address.setPhoneNumber(phoneNumber);
        address.setPincode(pincode);
        address.setState(state);
        address.setCity(city);
        address.setHouseNo(houseNo);
        address.setQuantity(quantity);
        address.setProductNo(productNo); // Set the new field

        boolean isSaved = deliveryAddressService.saveDeliveryAddress(address);

        if (isSaved) {
            redirectAttributes.addFlashAttribute("message", "Order Successfully!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Order Failed!");
        }

        return "redirect:/OrderNow"; // Redirects back to the OrderNow.html page
    }
}
