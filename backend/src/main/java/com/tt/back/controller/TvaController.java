package com.tt.back.controller;

import com.tt.back.entity.Tva;
import com.tt.back.service.TvaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tva")
public class TvaController {

    private TvaService tvaService;

    public TvaController(TvaService tvaService) {
        this.tvaService = tvaService;
    }

    @GetMapping(value = "/")
    public List<Tva> getAll(){
        return tvaService.getAll();
    }

}