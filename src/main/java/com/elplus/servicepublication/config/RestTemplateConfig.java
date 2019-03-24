/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elplus.servicepublication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author cannel
 */
@Configuration
public class RestTemplateConfig {
    
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    
}
