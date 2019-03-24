package com.elplus.servicepublication;

import com.elplus.servicepublication.domaine.Publication;
import com.elplus.servicepublication.repositories.PublicationRepository;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServicepublicationApplication implements CommandLineRunner{
    
    //les proprietes
    @Autowired
    private PublicationRepository publicationRepository;

    public static void main(String[] args) {
        SpringApplication.run(ServicepublicationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        //remplissage de la liste
        List<Publication> publications=Arrays.asList(
                new Publication("Mon elevage", "Mon intro Mon intro", "Mon contenu", "https://festivalwallpaper.com/wallpapers-hd/chicken-wallpaper-mobile-On-High-Resolution-Wallpaper.jpg", "mon resumé", new Date(), "mon auteur"),
                new Publication("Mon elevage", "Mon intro Mon intro", "Mon contenu", "https://images8.alphacoders.com/417/thumb-1920-417457.jpg", "mon resumé", new Date(), "mon auteur"),
                new Publication("Mon elevage", "Mon intro Mon intro", "Mon contenu", "http://3.bp.blogspot.com/-Oqm5RD222Aw/T9xWXLdW3dI/AAAAAAAACaM/vszwIbQNUYo/s1600/Chicken+Pictures.jpg", "mon resumé", new Date(), "mon auteur"),
                new Publication("Mon elevage", "Mon intro Mon intro", "Mon contenu", "https://festivalwallpaper.com/wallpapers-hd/chicken-wallpaper-full-hd-On-High-Resolution-Wallpaper.jpg", "mon resumé", new Date(), "mon auteur"),
                new Publication("Mon elevage", "Mon intro Mon intro", "Mon contenu", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQviy4iLyw7HM_6zB2iPrI4_9w-2SsOBXOA0J4GkyTzhNNm1y7H", "mon resumé", new Date(), "mon auteur"));
        
        //enregistrement
        publications.forEach(v->publicationRepository.saveAndFlush(v));
        
    }

}
