package com.learning.SocialLoginOAuth2.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecureController {

  @GetMapping("/secure")
  public String index() {
    return "secure.html";
  }

}
