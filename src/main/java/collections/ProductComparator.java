package collections;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    private String criteria;
    private boolean ascending;

    public ProductComparator(String choice) {
        String[] parts = choice.split("-"); // Split user input (criteria-order)
        this.criteria = parts[0];
        this.ascending = parts[1].equalsIgnoreCase("ascending");
    }

    @Override
    public int compare(Product p1, Product p2) {
        int comparisonResult;
        switch (criteria) {
            case "name":
                comparisonResult = p1.getName().compareTo(p2.getName());
                break;
            case "price":
                comparisonResult = Double.compare(p1.getPrice(), p2.getPrice());
                break;
            case "quantity":
                comparisonResult = Integer.compare(p1.getQuantity(), p2.getQuantity());
                break;
            default:
                throw new IllegalArgumentException("Invalid criteria: " + criteria);
        }
        return ascending ? comparisonResult : -comparisonResult; // Reverse order if descending
    }
}
