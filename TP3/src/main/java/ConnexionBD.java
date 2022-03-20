import dao.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnexionBD {
    public List<Produit> produitsParMC(String mc) throws Exception {

        List<Produit> produits=new ArrayList<Produit>(); Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection ("jdbc:mysql://localhost:3309/DB_CAT","root","");

        PreparedStatement ps=conn.prepareStatement("SELECT * FROM PRODUITS WHERE DESIGNATION like ?");
        ps.setString(1, mc);
        ResultSet rs=ps.executeQuery();

        while(rs.next()){

            Produit p=new Produit();

            p.setId(rs.getLong("ID"));
            p.setDesignation(rs.getString("DESIGNATION"));
            p.setPrix(rs.getDouble("PRIX"));
            p.setQuantite(rs.getInt("QUANTITE"));

            produits.add(p);
        }

        return produits;
    }
}
