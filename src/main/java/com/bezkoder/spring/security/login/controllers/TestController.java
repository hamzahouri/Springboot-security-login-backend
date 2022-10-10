package com.bezkoder.spring.security.login.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content from eclipse.";
  }

  @GetMapping("/user")
  @PreAuthorize("hasAuthority('USER') or hasAuthority('MODERATOR') or hasAuthority('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/mod")
  @PreAuthorize("hasAuthority('MODERATOR')")
  public String moderatorAccess() {
    return "Moderator Board.";
  }

  @GetMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
 
  public String adminAccess() {
    return "Admin Boardhghjghg.";
  }
}
