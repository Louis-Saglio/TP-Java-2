package facts;

import java.util.ArrayList;

public class Propositions extends ArrayList<Proposition> {

    public Proposition getById(int id) {
        for (Proposition proposition : this) {
            if (proposition.getId() == id) {
                return proposition;
            }
        }
        return null;
    }
}
