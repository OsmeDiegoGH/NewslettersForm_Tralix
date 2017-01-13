package org.newsletters.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/newsletters")
public class NewslettersServlet {
    
    @RequestMapping(value="/form", method = RequestMethod.GET)
    public ModelAndView adminView() {
        ModelAndView view = new ModelAndView("/modules/newslettersForm/view");
        return view;
    }
    
}
