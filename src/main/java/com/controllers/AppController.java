package com.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("home");
	}
	
	@GetMapping("/profile")
	public ModelAndView profile(
		@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client,
		@AuthenticationPrincipal OAuth2User user
	) {
		ModelAndView mav = new ModelAndView("profile");
		mav.addObject("userName", user.getAttributes().get("name"));
		mav.addObject("clientName", client.getClientRegistration().getClientName());
		return mav;
	}
}
