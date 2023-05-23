package tn.arabsoft.auth.controler;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import tn.arabsoft.auth.Service.LibredemandeService;
import tn.arabsoft.auth.entity.LibredemandeEntity;
import tn.arabsoft.auth.entity.Personnel;


@CrossOrigin("*")
@RestController

@RequestMapping("/libredeman")

public class LibredemandeController {
    @Autowired
    private LibredemandeService libredemandeService;
    /*@GetMapping("getByMatricule/{matricule}")
    public ResponseEntity<LibredemandeEntity> getPersonnelParMatricule(@PathVariable Long matricule) {
        LibredemandeEntity libredemandeEntity = libredemandeService.getDemandeParMatricule(matricule);
        if (libredemandeEntity != null) {
            return new ResponseEntity<>(libredemandeEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

    @GetMapping("/allDemand")
    public ResponseEntity<List<LibredemandeEntity>>findAll() {
        List<LibredemandeEntity> libredemandeEntities= libredemandeService.getAllDemand();
        return  ResponseEntity.ok().body(libredemandeEntities);
    }
    @PostMapping("/addDemand")
    @ResponseBody
    public void addDemand(@RequestBody LibredemandeEntity libredemandeentity) {
        this.libredemandeService.addDemand(libredemandeentity);
    }
    @DeleteMapping("/deleteDemand/{id}")
    @ResponseBody
    public void deleteDemand(@PathVariable Long Id_Libre_Demande) {
        this.libredemandeService.deleteDemand(Id_Libre_Demande);
    }
    @PutMapping("/updateAccepted/{Id_Libre_Demande}")
    @ResponseBody
    public ResponseEntity<LibredemandeEntity> updateA(@PathVariable Long Id_Libre_Demande) {
        LibredemandeEntity updateDemand = this.libredemandeService.updateDemandA(Id_Libre_Demande);
        return new ResponseEntity<>(updateDemand, HttpStatus.OK);
    }
    @PutMapping("/updateRefused")
    public ResponseEntity<LibredemandeEntity> updateR(@RequestBody LibredemandeEntity libredemandeEntity) {
        LibredemandeEntity updateDemand = this.libredemandeService.updateDemandR(libredemandeEntity);
        return new ResponseEntity<>(updateDemand, HttpStatus.OK);
    }
}
