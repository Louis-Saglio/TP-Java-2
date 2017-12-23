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
}
