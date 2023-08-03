package  com.pfe.backend.repository ;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.backend.model.Categorie;

@Repository
public interface CategorieRepository  extends JpaRepository <Categorie, Long> {}