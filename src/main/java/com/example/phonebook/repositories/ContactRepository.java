package com.example.phonebook.repositories;


import com.example.phonebook.models.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
    Page<Contact> findAll(Pageable pageable);
}
