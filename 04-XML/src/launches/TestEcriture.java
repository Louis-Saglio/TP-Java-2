package launches;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.IOException;
import java.io.OutputStream;

public class TestEcriture {

    Document document;

    public TestEcriture() throws IOException {
        Element racine = new Element("b2b");
        document = new Document(racine);
        racine.setAttribute("annes", "2017");
        Element e_Etudiant = new Element("etudiants");
        racine.addContent(e_Etudiant);
        e_Etudiant.addContent(
                new Element("etudiant").setAttribute("codes", "CH01")
                        .addContent(new Element("nom").setText("CHIRAC"))
                        .addContent(new Element("prenom").setText("Jacques"))
        );
        affiche(System.out);
    }

    public void affiche(OutputStream out) throws IOException {
        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, out);
    }

    public static void main(String[] args) throws IOException {
        new TestEcriture();
    }
}
