package controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = GET)
    public String login(Model model){
        model.addAttribute("userForm", new User());
        return "login";
    }

    @RequestMapping(method = POST)
    public String doLogin(@Valid @ModelAttribute("userForm") User userForm, BindingResult result) {
        if(result.hasErrors()) {
            return "login";
        }
        return "loginSuccess";
    }
}
