
package ar.edu.unq.desapp.grupoG.controllers;

import java.util.List;
import java.util.Optional;

import ar.edu.unq.desapp.grupoG.services.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoG.model.User;

@RestController

public class UserController {

    private UserService service;
    
    UserController(UserService service) {
		this.service = service;
	}
	

    @RequestMapping(value="users", method = RequestMethod.GET)
    public List<User> list(){
    	return service.findAll();
    }

    @RequestMapping(value="users", method = RequestMethod.POST)
    public User create(@RequestBody User user){
    	return service.create(user);
    }
    

    @RequestMapping(value="users/{id}", method = RequestMethod.GET)
    public Optional<User> get(@PathVariable Long id){
        return service.findById(id);
    }

    
    @RequestMapping(value="users/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable Long id, @RequestBody User modifiedUser){        
        return service.update(id, modifiedUser);
    }
    
    
    @RequestMapping(value="users/{id}", method = RequestMethod.DELETE)
    public User delete(@PathVariable Long id){
        //returns the deleted User
    	return service.delete(id);
    }

}



//package ar.edu.unq.desapp.grupoG.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import ar.edu.unq.desapp.grupoG.model.User;
//import ar.edu.unq.desapp.grupoG.service.UserService;
//import ar.edu.unq.desapp.grupoG.validator.UserValidator;
//
//
//@RestController
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//
//    @Autowired
//    private UserValidator userValidator;
//
//    @RequestMapping(value = "/registration", method = RequestMethod.GET)
//    public String registration(Model model) {
//        model.addAttribute("userForm", new User());
//
//        return "registration";
//    }
//
//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
//        userValidator.validate(userForm, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//
//        userService.save(userForm);
//
////        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
//
//        return "redirect:/welcome";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(Model model, String error, String logout) {
//        if (error != null)
//            model.addAttribute("error", "Your username and password is invalid.");
//
//        if (logout != null)
//            model.addAttribute("message", "You have been logged out successfully.");
//
//        return "login";
//    }
//
//    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
//    public String welcome(Model model) {
//        return "welcome";
//    }
//}
