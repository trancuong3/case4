package org.example.case_modul4.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@PreAuthorize("hasRole('ADMIN')")
@Controller
public class AdminController {
    @GetMapping("/admin")
    public String adminPage() {
        return "Admin/admin";
    }
}
