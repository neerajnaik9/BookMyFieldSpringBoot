package com.bookmyfield.BookMyFieldBackend.controller;

import com.bookmyfield.BookMyFieldBackend.model.Field;
import com.bookmyfield.BookMyFieldBackend.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/field-owner")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend access
public class FieldOwnerController {

    @Autowired
    private FieldService fieldService;

    @PostMapping("/add-field")
    public Field addField(@RequestBody Field field, @RequestParam Long ownerId) {
        return fieldService.addField(field, ownerId);
    }

    @GetMapping("/my-fields")
    public List<Field> getMyFields(@RequestParam Long ownerId) {
        return fieldService.getFieldsByOwner(ownerId);
    }

    @GetMapping("/field-status/{id}")
    public Optional<Field> getFieldStatus(@PathVariable Long id) {
        return fieldService.getFieldStatus(id);
    }

    @PutMapping("/edit-field/{id}")
    public Field editField(@PathVariable Long id, @RequestBody Field updatedField) {
        return fieldService.updateField(id, updatedField);
    }
}
