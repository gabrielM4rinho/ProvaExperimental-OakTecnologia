package entities;

public class Product {

    private String name;
    private String description;
    private double productPrice;
    private char disponivelParaVenda;

    public Product(String name, String description, double productPrice, char disponivelParaVenda) {
        this.name = name;
        this.description = description;
        this.productPrice = productPrice;
        this.disponivelParaVenda = disponivelParaVenda;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public char isDisponivelParaVenda() {
        return disponivelParaVenda;
    }

    public void setDisponivelParaVenda(char disponivelParaVenda) {
        this.disponivelParaVenda = disponivelParaVenda;
    }

    @Override
    public String toString() {
        return "Produto: " + name + ", valor: R$" + String.format("%.2f", productPrice);
    }
}
