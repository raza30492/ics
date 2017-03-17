/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ics.assembler;

import com.example.ics.entity.SubCategory;
import com.example.ics.restcontroller.CategoryRestController;
import com.example.ics.restcontroller.SubCategoryRestController;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class SubCategoryAssembler extends ResourceAssemblerSupport<SubCategory, Resource>{

    public SubCategoryAssembler() {
        super(CategoryRestController.class, Resource.class);
    }

    @Override
    public Resource toResource(SubCategory subCategory) {
        Collection<Link> links = new ArrayList<>();
        links.add(linkTo(methodOn(CategoryRestController.class)
                        .loadCategorySubCategory(subCategory.getId(),subCategory.getCategory().getId()))
                        .withSelfRel()
        );
        links.add(linkTo(methodOn(CategoryRestController.class)
                .loadCategorySubCategoryProducts(subCategory.getCategory().getId(),subCategory.getId(),null,null))
                .withRel("productList")
        );
        return new Resource<>(subCategory, links); 
    }
    
}