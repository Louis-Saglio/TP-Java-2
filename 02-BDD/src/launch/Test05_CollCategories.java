package launch;

import beans.Categorie;
import beans.CollCategories;

public class Test05_CollCategories {
    public static void main(String[] args) {
        CollCategories collCategories = new CollCategories();
        for (Categorie collCategory : collCategories) {
            System.out.println(collCategory);
        }
    }
}
