package dao;
import java.util.List;
public class Test {
    public static void main(String[] args) {
        ProduitDaoImpl dao=new ProduitDaoImpl();
        dao.save(new Produit("P1", 8000, 4));
        dao.save(new Produit("P2", 6700, 2));
        dao.save(new Produit("P3", 5300, 1));
        System.out.println("--------------------");
        List<Produit> prods=dao.findAll();
        for(Produit p:prods) {
            System.out.println(p.getDesignation());
        }
    }
}