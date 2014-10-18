package controller;

import model.User;
import model.UserWithValidatorWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/loginValidator")
public class LoginControllerWithValidatorWay {
    @Autowired
    private UserValidator userValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator( userValidator);
    }

    @RequestMapping(method = GET)
    public String login(Model model){
        model.addAttribute("user", new UserWithValidatorWay());
        return "loginWithValidator";
    }

    @RequestMapping(method = POST)
    public String doLogin(@Valid @ModelAttribute("user") UserWithValidatorWay user,
                          BindingResult result) {
        if(result.hasErrors()) {
            return "loginWithValidator";
        }
        return "loginSuccess";
    }
}
