package metier;

import dao.IDao;

public class MetierImpl implements IMetier{


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
