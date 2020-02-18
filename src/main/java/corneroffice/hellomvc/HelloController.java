package corneroffice.hellomvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String sayHelloToEveryone(Model model) {
        model.addAttribute("user", new User("Everyone"));
        return "HelloView";
    }
}
