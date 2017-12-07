package beans;

import java.util.ArrayList;

public class Etudiants extends ArrayList<Etudiant> {

    public Etudiant getByCode(String code) {
        for (Etudiant etudiant : this) {
            if (etudiant.getCode().equals(code)){
                return etudiant;
            }
        }
        return null;
    }
}
