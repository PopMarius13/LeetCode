package daily_challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class P1268 {

    class Solution {

        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            List<List<String>> result = new ArrayList<>();
            List<String> productsTimeN = new LinkedList<>();
            List<String> newProductsTimeN = new LinkedList<>();

            for (String product : products) {
                if (product.charAt(0) == searchWord.charAt(0)) {
                    productsTimeN.add(product);
                }
            }
            productsTimeN.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            result.add( new ArrayList<>(productsTimeN.subList(0, Math.min(productsTimeN.size(), 3))));

            for (int i = 1; i < searchWord.length(); i++) {
                int n = productsTimeN.size();
                for (String productTimeN : productsTimeN) {
                    if (i < productTimeN.length() && productTimeN.charAt(i) == searchWord.charAt(i)) {
                        newProductsTimeN.add(productTimeN);
                    }
                }
                result.add( new ArrayList<>(newProductsTimeN.subList(0, Math.min(newProductsTimeN.size(), 3))));
                productsTimeN = newProductsTimeN;
                newProductsTimeN = new LinkedList<>();

            }
            return result;
        }
    }
}
