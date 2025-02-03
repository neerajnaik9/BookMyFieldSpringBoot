package com.bookmyfield.BookMyFieldBackend.controller;

import com.bookmyfield.BookMyFieldBackend.model.Field;
import com.bookmyfield.BookMyFieldBackend.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fields")
@CrossOrigin(origins = "http://localhost:3000") // Adjust if needed
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @PostMapping
    public Field addField(@RequestBody Field field, @AuthenticationPrincipal UserDetails userDetails) {
        return fieldService.addField(field, userDetails.getUsername());
    }

    @GetMapping("/my-fields")
    public List<Field> getMyFields(@AuthenticationPrincipal UserDetails userDetails) {
        return fieldService.getFieldsByOwner(userDetails.getUsername());
    }

    @DeleteMapping("/{id}")
    public void deleteField(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        fieldService.deleteField(id, userDetails.getUsername());
    }

    @GetMapping("/pending")
    public List<Field> getPendingApprovals() {
        return fieldService.getPendingApprovals();
    }
}
