package launches;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestEcriture {

    private Document document;

    private TestEcriture() throws IOException {
        Element racine = new Element("b2b");
        document = new Document(racine);
        racine.setAttribute("annes", "2017");
        Element e_Etudiant = new Element("etudiants");
        racine.addContent(e_Etudiant);
        e_Etudiant.addContent(
                new Element("etudiant").setAttribute("code", "CH01")
                        .addContent(new Element("nom").setText("CHIRAC"))
                        .addContent(new Element("prenom").setText("Jacques"))
        );
        e_Etudiant.addContent(
                new Element("etudiant").setAttribute("code", "JO01")
                        .addContent(new Element("nom").setText("JOSPIN"))
                        .addContent(new Element("prenom").setText("Lionel"))
        );
        e_Etudiant.addContent(
                new Element("etudiant").setAttribute("code", "ME01")
                        .addContent(new Element("nom").setText("MENDES_FRANCE"))
                        .addContent(new Element("prenom").setText("Pierre"))
        );
        affiche(System.out);
        affiche(new FileOutputStream("b2b.xml"));
    }

    private void affiche(OutputStream out) throws IOException {
        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, out);
    }

    public static void main(String[] args) throws IOException {
        new TestEcriture();
    }
}
