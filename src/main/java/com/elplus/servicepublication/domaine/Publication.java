/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elplus.servicepublication.domaine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author cannel
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Publication implements Serializable{
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotEmpty(message = "Veuillez entrer le titre s'il vous plait")
    private String titre;
    
    @NotEmpty(message = "Veuillez entrer une introduction s'il vous plait")
    private String intro;
    
    @NotEmpty(message = "veuillez entrer un contenu s'il vous plait")
    private String contenu;
    
    @NotEmpty(message = "Veuillez entrer le lien de l'image s'il vous plait")
    private String lienPhoto;
    
    @NotEmpty(message = "Veuillez entrer un resumé s'il vous plait")
    private String resume;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePublication;
    
    @NotEmpty(message = "Veuillez entrer le nom de l'auteur s'il vous plait")
    private String auteur;
    
    //constructeur sans id
    public Publication(String titre, String intro, String contenu, String lienPhoto, String resume, Date datePublication, String auteur) {
        this.titre = titre;
        this.intro = intro;
        this.contenu = contenu;
        this.lienPhoto = lienPhoto;
        this.resume = resume;
        this.datePublication = datePublication;
        this.auteur = auteur;
    }
    
    
}
