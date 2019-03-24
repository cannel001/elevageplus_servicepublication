/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elplus.servicepublication.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.elplus.servicepublication.service.IMyFileService;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author willi
 */
@Service
public class MyFileService implements IMyFileService {

    @Override
    public File convertMultipartToFile(MultipartFile file) {

        try {

            File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
            file.transferTo(convFile);
            return convFile;
        } catch (IOException ex) {
            Logger.getLogger(MyFileService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(MyFileService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String savePicture(File file, String path) {

        //configuration
        Map config = ObjectUtils.asMap(
                "cloud_name", "dtpt8vqjj",
                "api_key", "531422646336615",
                "api_secret", "IfVgRaphOQ8kbf0Hw57ql-cYr64");

        //creer un nouveau nom pour l'image
        String newNameImage = (new Date()).getTime() + "";

        System.out.println("*************** passage 1");

        //recuperer l'extention de l'image
        String ext = file.toString().substring(file.toString().lastIndexOf("."));

        System.out.println("*************** passage 2");

        Map params = ObjectUtils.asMap(
                "public_id", path + "/" + newNameImage + "");

        System.out.println("*************** passage 3");

        Cloudinary cloudinary = new Cloudinary(config);

        System.out.println("*************** passage 4");

        try {

            Map resultatImport = cloudinary.uploader().upload(file, params);

            System.out.println("*************** passage 5");

            if (resultatImport != null) {

                return "https://res.cloudinary.com/dtpt8vqjj/image/upload/v1541877415/" + path + "/" + newNameImage + ext;

            }

        } catch (IOException ex) {
            Logger.getLogger(MyFileService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

}
