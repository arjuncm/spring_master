package com.howtodospring.demo.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.howtodospring.demo.model.User;
import com.howtodospring.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String userForm(Locale locale, ModelMap model) {
		List<User> list = userService.listUser();
		for (User user : list) {
			System.out.println(user.toString());

		}
		model.addAttribute("users", list);
		return "main";
	}

	@ModelAttribute("user")
	public User formBackingObject() {
		return new User();
	}

	@PostMapping("addUser")
	public String saveUser(@ModelAttribute("user") @Valid User user,
			BindingResult result, Model model) {

		if (result.hasErrors()) {

			model.addAttribute("users", userService.listUser());
			return "main";
		}

		userService.save(user);
		return "redirect:/";
	}

	@GetMapping("removeUser/{id}")
	public String removeUser(@PathVariable("id") Long id,Model model) {
		System.out.println("remove following id=" + id);
		userService.remove(id);
		model.addAttribute("users", userService.listUser());
		return "main";
	}
	@PostMapping("/removelist")
	public String removeList(Model model){
		List<User> list = userService.listUser();
		for (User user : list) {
			System.out.println(user.toString());

		}
		model.addAttribute("removedlist", list);
		return "removelist";
	}
}