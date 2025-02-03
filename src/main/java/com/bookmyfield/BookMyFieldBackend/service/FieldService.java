package com.bookmyfield.BookMyFieldBackend.service;

import com.bookmyfield.BookMyFieldBackend.model.Field;
import com.bookmyfield.BookMyFieldBackend.model.User;
import com.bookmyfield.BookMyFieldBackend.repository.FieldRepository;
import com.bookmyfield.BookMyFieldBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FieldService {

    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private UserRepository userRepository;

    public Field addField(Field field, String ownerEmail) {
        User owner = userRepository.findByEmail(ownerEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));
        field.setOwner(owner);
        field.setStatus("Pending"); // Default status for admin approval
        return fieldRepository.save(field);
    }

    public List<Field> getFieldsByOwner(String ownerEmail) {
        User owner = userRepository.findByEmail(ownerEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return fieldRepository.findByOwner(owner);
    }

    public void deleteField(Long id, String ownerEmail) {
        Field field = fieldRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Field not found"));

        if (!field.getOwner().getEmail().equals(ownerEmail)) {
            throw new RuntimeException("Unauthorized to delete this field");
        }

        fieldRepository.delete(field);
    }

    public List<Field> getPendingApprovals() {
        return fieldRepository.findByStatus("Pending");
    }
}
