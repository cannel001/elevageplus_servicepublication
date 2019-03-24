/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elplus.servicepublication.repositories;

import com.elplus.servicepublication.domaine.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author cannel
 */
public interface PublicationRepository extends JpaRepository<Publication, Long>{
    
}
