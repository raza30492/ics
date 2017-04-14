package com.example.ics.restcontroller;

import com.example.ics.dto.ProductCsv;
import com.example.ics.entity.Product;
import com.example.ics.service.ProductService;
import com.example.ics.util.ApiUrls;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by razamd on 3/29/2017.
 */
@RestController
@RequestMapping(ApiUrls.ROOT_URL_UPLOADS)
public class UploadRestController {

    private final Logger logger = LoggerFactory.getLogger(UploadRestController.class);

    @Autowired
    Mapper mapper;

    @Autowired ProductService productService;

    @PostMapping(ApiUrls.URL_UPLOADS_PRODUCTS)
    public ResponseEntity<?> uploadProducts(@RequestParam("file") MultipartFile file){
        logger.debug("uploadProducts()");
        if (! (file.getOriginalFilename().contains("xlsx") || file.getOriginalFilename().contains("xls"))) {
            return new ResponseEntity<>(new Error("FILE_NOT_SUPPORTED"), HttpStatus.CONFLICT);
        }
        productService.addProductsBatch(file);
        System.out.println("Check");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public ResponseEntity<?> test(){
        productService.sync();

        return ResponseEntity.ok("OK");
    }
}
