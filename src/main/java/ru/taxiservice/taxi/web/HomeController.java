package ru.taxiservice.taxi.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.taxiservice.taxi.domain.User;
import ru.taxiservice.taxi.service.IRoleService;
import ru.taxiservice.taxi.service.IUserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
    private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(/*Locale locale, Model model*/) {
		/*logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
		
		return "home";*/
		return "redirect:/index";
	}
	
	
	
	@RequestMapping("/index")
    public @ResponseBody String listContacts(Map<String, Object> map) {

        /*map.put("user", new User());
        map.put("users", userService.users());*/

        return "user";
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("user") User user, BindingResult result) {
		logger.info("Add");
        userService.addUser(user);

        return "redirect:/index";
    }
	
	@RequestMapping("/delete/{userId}")
    public String deleteContact(@PathVariable("userId") Long userId) {

        userService.removeUser(userId);

        return "redirect:/index";
    }
	
}
