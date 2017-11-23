package launches;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestLecture {

    private TestLecture() throws JDOMException, IOException {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(new File("b2b.xml"));

        Element root = document.getRootElement();
        System.out.println("Année de la promo " + root.getName() + " " + root.getAttributeValue("annees"));
        List<Element> etudiants = root.getChild("etudiants").getChildren("etudiant");
        for (Element etudiant : etudiants) {
            String code = etudiant.getAttributeValue("code");
            String prenom = etudiant.getChildText("prenom");
            String nom = etudiant.getChildText("nom");
            System.out.println("- [" + code + "] " + nom + " " + prenom);
        }
    }

    public static void main(String[] args) throws JDOMException, IOException {
        new TestLecture();
    }
}
