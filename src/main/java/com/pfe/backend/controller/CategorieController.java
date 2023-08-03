package com.pfe.backend.controller;

import com.pfe.backend.model.Categorie;
import com.pfe.backend.service.CategorieService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")


@CrossOrigin(origins = "http://localhost:4200")
//@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Categorie")

public class CategorieController {

    private final CategorieService categorieService;

    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @PostMapping
    public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie) {
        try {
            Categorie createdCategorie = categorieService.createCategorie(categorie);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCategorie);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Categorie>> getAllCategories() {
        try {
            List<Categorie> categories = categorieService.getAllCategories();
            return ResponseEntity.ok(categories);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable("id") Long id) {
        try {
            Categorie categorie = categorieService.getCategorieById(id);
            if (categorie != null) {
                return ResponseEntity.ok(categorie);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categorie> updateCategorie(@PathVariable("id") Long id, @RequestBody Categorie categorie) {
        try {
            Categorie updatedCategorie = categorieService.updateCategorie(id, categorie);
            if (updatedCategorie != null) {
                return ResponseEntity.ok(updatedCategorie);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategorie(@PathVariable("id") Long id) {
        try {
            categorieService.deleteCategorie(id);
            return ResponseEntity.ok("Categorie deleted with id: " + id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
