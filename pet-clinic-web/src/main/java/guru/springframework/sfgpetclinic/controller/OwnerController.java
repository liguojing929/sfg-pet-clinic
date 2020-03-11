package guru.springframework.sfgpetclinic.controller;


import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    // by using constructor -- it should automatically autowire by spring.
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    /**
     * @RequestMapping({"", "/", "/index",...}) means mapping different requests to the same method,
     * which means type the url mentioned inside will return the same page.
     * @return
     */
    @RequestMapping({"", "/", "/index", "/index.html", "/test"})
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }
}
