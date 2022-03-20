package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

public class ProduitDaoImpl implements IProduitDao{

    /* Déclaration de l’objet EntityManager qui permet de gérer les entités*/
    private EntityManager entityManager;

    /* Constructeur */
    public void CatalogueDaoImpl() {
        /* Création de l’objet Entity Manager Factory */
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UP_CAT");
        /* Création de l’objet Entity Manager */
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    @Transactional
    public void save(Produit p) {
        entityManager.persist(p);
    }

    @Override
    public List<Produit> findAll() {
        Query query=entityManager.createQuery("select p from Produit p");
        return query.getResultList();
    }

    @Override
    public List<Produit> findByDesignation(String mc) {
        Query query=entityManager.createQuery("select p from Produit p where p.designation like :x");
        query.setParameter("x", "%"+mc+"%");
        return query.getResultList();
    }

    @Override
    public Produit findByID(Long id) {
        Produit p=entityManager.find(Produit.class, id);
        return p;
    }

    @Override
    public void update(Produit p) {
        entityManager.merge(p);
    }

    @Override
    public void deleteById(Long idP) {
        Produit p=entityManager.find(Produit.class, idP);
        entityManager.remove(p);
    }
}
