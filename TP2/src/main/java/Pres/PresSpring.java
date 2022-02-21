package Pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresSpring {
    public static void main(String[] args){
        ApplicationContext context=new ClassPathXmlApplicationContext("configurationSpring.xml");

        IMetier metier= (IMetier) context.getBean("metier"); // recupere l'objet qui a l'id metier depuis le fichier config.xml

        System.out.println(metier.calcul());

    }
}
