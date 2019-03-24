/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elplus.servicepublication.service;

import java.io.File;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author willi
 */
public interface IMyFileService {
    
    public File convertMultipartToFile(MultipartFile file);
    
    public String savePicture(File file,String path);
    
}
