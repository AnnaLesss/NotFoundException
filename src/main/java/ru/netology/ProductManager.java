package ru.netology;

public class ProductManager {
    private ProductRepository repo;

    public ProductRepository getRepo() {
        return repo;
    }

    public void setRepo(ProductRepository repo) {
        this.repo = repo;
    }

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }


    public void add(Product prod) {
        repo.save(prod);
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.getAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[tmp.length - 1] = product;
                    result = tmp;
                }
            }
        }
        return result;
    }
}