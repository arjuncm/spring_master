package com.howtodospring.demo.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.howtodospring.demo.model.Account;
import com.howtodospring.demo.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String userForm() {
		return "main";
	}

	@ModelAttribute("user")
	public Account formBackingObject() {
		return new Account();
	}

	@GetMapping("login")
	public String login(@ModelAttribute("user") @Valid Account account,
			BindingResult result, Model model) {
		return "login";
	}
	
	@GetMapping("registration")
	public @ResponseBody Account registration() {
		Account account = new Account();
		account.setName("Arjun");
		account.setEmail("arjun.mohan@inapp.com");
		account.setFirst_name("Arjun");
		account.setLast_name("mohan");
		return account;
	}
	
	
	@PostMapping(value = "/customers")
	public ResponseEntity createCustomer(@RequestBody Account account) {

		//customerDAO.create(customer);

		return new ResponseEntity(account, HttpStatus.OK);
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
		List<Account> list = userService.listUser();
		for (Account account : list) {
			System.out.println(account.toString());

		}
		model.addAttribute("removedlist", list);
		return "removelist";
	}
}