package com.pfe.backend.service;

import com.pfe.backend.model.Categorie;

import java.util.List;

public interface CategorieService {

    Categorie createCategorie(Categorie categorie);

    List<Categorie> getAllCategories();

    Categorie getCategorieById(Long id);

    Categorie updateCategorie(Long id, Categorie categorie);

    void deleteCategorie(Long id);
}
