/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elplus.servicepublication.resources;

import com.elplus.servicepublication.domaine.Publication;
import com.elplus.servicepublication.repositories.PublicationRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.ok;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cannel
 */
@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class PublicationRestController {

    //les proprietes
    @Autowired
    private PublicationRepository publicationRepository;

    @GetMapping
    public String home() {
        return "Bienvenue sur l'api des publication d'elevage plus";
    }

    @GetMapping(value = "/all")
    public ResponseEntity getAll() {
        return ok(publicationRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getOne(@PathVariable long id) {
        if (id > 0) {
            Optional<Publication> p = publicationRepository.findById(id);
            return p.orElse(null)!=null ? ok(p) : ok("Ce enregistrement n'existe pas");
        }
        return ok("Veuillez entrer un id superieur à zero");
    }
}
