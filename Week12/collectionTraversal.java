import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class collectionTraversal {
    public static void execute(){
        List<String> carBrands = Arrays.asList("Ferrari", "Porsche", "Audi", "Mercedes");
        List<String> upperCaseBrands = new ArrayList<>();
   
        /*for(String brand : carBrands) {
            upperCaseBrands.add(brand.toUpperCase());
        }*/
        carBrands.forEach(brand -> System.out.println(brand));
        /*for(String brand : upperCaseBrands) {
            System.out.println(brand);
        }*/
        upperCaseBrands.forEach(brand -> System.out.println(brand));

    }
    public static void main(String[] args) {
        execute();
    }
}
