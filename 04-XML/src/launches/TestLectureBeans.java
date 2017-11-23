package launches;

import beans.Etudiants;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestLectureBeans {

    private TestLectureBeans(Etudiants etudiants) throws JDOMException, IOException {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(new File("b2b.xml"));

        Element root = document.getRootElement();
        List<Element> students = root.getChild("etudiants").getChildren("etudiant");

        for (Element etudiant : students) {
            String code = etudiant.getAttributeValue("code");
            String prenom = etudiant.getChildText("prenom");
            String nom = etudiant.getChildText("nom");
            System.out.println("- [" + code + "] " + nom + " " + prenom);
        }
    }

    public static void main(String[] args) throws JDOMException, IOException {
        Etudiants etudiants = new Etudiants();
        new TestLectureBeans(etudiants);
    }
}
