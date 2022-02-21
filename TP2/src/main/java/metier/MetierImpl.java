package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier{

    @Autowired
    @Qualifier("dao")
    // Couplage faible
    private IDao dao;

    @Override
    public double calcul() {
        double temp = dao.getTemp();
        double res = temp*12;
        return res;
    }

    public IDao getDao() {
        return dao;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
