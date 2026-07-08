package com.designpatterns.abstractfactory.response;

public class CheckoutResponse {
    private String region;
    private double chargedAmount;
    private double shippingCost;
    private double tax;
    private double total;

    public CheckoutResponse(String region, double chargedAmount, double shippingCost,
                            double tax, double total) {
        this.region = region;
        this.chargedAmount = chargedAmount;
        this.shippingCost = shippingCost;
        this.tax = tax;
        this.total = total;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getChargedAmount() {
        return chargedAmount;
    }

    public void setChargedAmount(double chargedAmount) {
        this.chargedAmount = chargedAmount;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
