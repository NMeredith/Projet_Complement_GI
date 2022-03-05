package com.tt.back.controller;

import com.tt.back.entity.Nomenclature;
import com.tt.back.service.NomenclatureService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/nomenclature")
public class NomenclatureController {

    private NomenclatureService nomenclatureService;

    public NomenclatureController(NomenclatureService nomenclatureService) {
        this.nomenclatureService = nomenclatureService;
    }

    @GetMapping(value = "/")
    public List<Nomenclature> getAll(){
        return nomenclatureService.getAll();
    }
}