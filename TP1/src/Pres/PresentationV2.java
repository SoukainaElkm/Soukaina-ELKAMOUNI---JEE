package Pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationV2 {
    public static void main(String[] args) throws Exception {

        /*
                  Invocation Dynamique
         */
        Scanner sc = new Scanner(new File("config.txt"));
        String daoClassName = sc.nextLine();
        //System.out.println(daoClassName);
        Class cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.newInstance(); // sous-casting
        //System.out.println(dao.getTemp());

        String metierClassName = sc.nextLine();
        System.out.println(metierClassName);
        Class cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.newInstance();

        Method m = cMetier.getMethod("setDao", IDao.class); // si elle contient plusieur parametre, faire ("setDao", new Class[]{IDao.class, ...})
        m.invoke(metier, dao); // appeler la methode m dans l'objet metier, et on lui transmet l'objet dao comme parametre
        System.out.println(metier.calcul());

    }
}
