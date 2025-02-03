package com.bookmyfield.BookMyFieldBackend.service;

import com.bookmyfield.BookMyFieldBackend.model.Field;
import com.bookmyfield.BookMyFieldBackend.model.FieldStatus;
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

    public Field addField(Field field, Long ownerId) {
        User owner = userRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("Owner not found"));
        field.setOwner(owner);
        field.setStatus(FieldStatus.PENDING);
        return fieldRepository.save(field);
    }

    public List<Field> getFieldsByOwner(Long ownerId) {
        User owner = userRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("Owner not found"));
        return fieldRepository.findByOwner(owner);
    }

    public Optional<Field> getFieldStatus(Long fieldId) {
        return fieldRepository.findById(fieldId);
    }

    public Field updateField(Long fieldId, Field updatedField) {
        return fieldRepository.findById(fieldId).map(field -> {
            field.setName(updatedField.getName());
            field.setLocation(updatedField.getLocation());
            field.setDescription(updatedField.getDescription());
            field.setTimings(updatedField.getTimings());
            field.setPrice(updatedField.getPrice());
            field.setCategory(updatedField.getCategory());
            field.setImage(updatedField.getImage());
            return fieldRepository.save(field);
        }).orElseThrow(() -> new RuntimeException("Field not found"));
    }
}
