package dao;

import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImpl implements IDao{
    @Override
    public double getTemp() {
        /*
        Se connecter à la BD pour récupérer la température
         */
        double data=24;
        return data;
    }
}
