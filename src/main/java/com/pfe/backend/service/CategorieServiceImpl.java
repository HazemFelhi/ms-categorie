package com.pfe.backend.service;

import com.pfe.backend.model.Categorie;
import com.pfe.backend.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService {

    private final CategorieRepository categorieRepository;

    @Autowired
    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie getCategorieById(Long id) {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(id);
        return optionalCategorie.orElse(null);
    }

    @Override
    public Categorie updateCategorie(Long id, Categorie categorie) {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(id);
        if (optionalCategorie.isPresent()) {
            Categorie existingCategorie = optionalCategorie.get();
            existingCategorie.setDescription(categorie.getDescription());
            existingCategorie.setNom(categorie.getNom());
            return categorieRepository.save(existingCategorie);
        } else {
            return null;
        }
    }

    @Override
    public void deleteCategorie(Long id) {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(id);
        optionalCategorie.ifPresent(categorieRepository::delete);
    }
}
