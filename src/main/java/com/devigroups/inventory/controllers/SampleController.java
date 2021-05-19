package com.devigroups.inventory.controllers;

import com.devigroups.inventory.entities.Suppliers;
import com.devigroups.inventory.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SampleController {

    @Autowired
    private SupplierRepository suppRepo;

    @GetMapping("/home")
    private String sampleMethod(){
        return "hi there!!!";
    }

    @GetMapping("/suppliers")
    private List<Suppliers> getSupplierInfo(){
        return suppRepo.findAll();
    }

    @GetMapping("/suppliertotalcost")
    private Long totalPrice(){
        List<Suppliers> allSuppliers =  suppRepo.findAll();
        Long sum = allSuppliers.stream().filter((e) -> e.getUnitOfMeasure().contentEquals("Piece"))
                .mapToLong((e) -> e.getBufferStock() * e.getCostPerUnit() ).sum();

        //return allSuppliers.size();
        return sum;
    }
}
