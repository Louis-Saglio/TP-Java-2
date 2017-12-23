package facts;

import java.util.ArrayList;
import java.util.Arrays;

public class Values extends ArrayList<Value> {

    public Values(Value... values) {
        this.addAll(Arrays.asList(values));
    }

    public Values(String... strings) {
        for (String string : strings) {
            this.add(new Value(string));
        }
    }

    public Values() {
    }

    public Values filter(Value value) {
        Values rep = new Values();
        for (Value value1 : this) {
            if (value != value1) {
                rep.add(value1);
            }
        }
        return rep;
    }
}
