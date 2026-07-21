package com.lld.prototypedesign.prototype;

public class CardLimits implements Cloneable{
    private double dailyWithdrawalLimit;
    private double dailySpendLimit;
    private double maxTransactionsPerDay;

    public CardLimits() {}

    public CardLimits(double dailyWithdrawalLimit, double dailySpendLimit, double maxTransactionsPerDay) {
        this.dailyWithdrawalLimit = dailyWithdrawalLimit;
        this.dailySpendLimit = dailySpendLimit;
        this.maxTransactionsPerDay = maxTransactionsPerDay;
    }

    @Override
    public CardLimits clone() {
        try {
            return (CardLimits) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("CardLimits should always be cloneable", e);
        }
    }

    public double getDailyWithdrawalLimit() { return dailyWithdrawalLimit; }
    public void setDailyWithdrawalLimit(double dailyWithdrawalLimit) { this.dailyWithdrawalLimit = dailyWithdrawalLimit; }

    public double getDailySpendLimit() { return dailySpendLimit; }
    public void setDailySpendLimit(double dailySpendLimit) { this.dailySpendLimit = dailySpendLimit; }

    public double getMaxTransactionsPerDay() { return maxTransactionsPerDay; }
    public void setMaxTransactionsPerDay(double maxTransactionsPerDay) { this.maxTransactionsPerDay = maxTransactionsPerDay; }

    @Override
    public String toString() {
        return "CardLimits{" +
                "dailyWithdrawalLimit=" + dailyWithdrawalLimit +
                ", dailySpendLimit=" + dailySpendLimit +
                ", maxTransactionsPerDay=" + maxTransactionsPerDay +
                '}';
    }
}
