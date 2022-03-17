package com.example.phonebook.controllers;

import com.example.phonebook.models.Contact;
import com.example.phonebook.models.User;
import com.example.phonebook.repositories.ContactRepository;
import com.example.phonebook.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PhonebookController {

    // standard constructors
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }





    @GetMapping("/contacts")
    public Page<Contact> getContacts(
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable
    ) {
        return contactRepository.findAll(pageable);
    }

    @PostMapping("/contacts")
    void addContact(@RequestBody Contact contact) {
        contactRepository.save(contact);
    }

    @DeleteMapping("/contacts/{id}")
    void deleteTutorial(@PathVariable("id") long id) {
        contactRepository.deleteById(id);
    }

    @PutMapping("/contacts/{id}")
     void replaceEmployee(@RequestBody Contact newContact, @PathVariable Long id) {
        contactRepository.findById(id)
                .map(contact -> {
                    contact.setName(newContact.getName());
                    contact.setPhone(newContact.getPhone());
                    return contactRepository.save(contact);
                });
    }



}
