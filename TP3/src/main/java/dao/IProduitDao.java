package dao;

import java.util.List;

public interface IProduitDao {
     void save(Produit p);
     List<Produit> findAll();
     List<Produit> findByDesignation(String mc);
     Produit findByID(Long id);
     void update(Produit p);
     void deleteById(Long idP);
}
