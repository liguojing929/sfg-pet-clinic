package guru.springframework.sfgpetclinic.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    /**
     * @RequestMapping({"", "/", "/index",...}) means mapping different requests to the same method,
     * which means type the url mentioned inside will return the same page.
     * @return
     */
    @RequestMapping({"", "/", "/index", "/index.html", "/test"})
    public String listOwners() {
        return "owners/index";
    }
}
