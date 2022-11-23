package pt.up.fe.ldts.example3;

public class FixedDiscount implements Discount{

    private final int fixed;

    public FixedDiscount(int fixed) {
        this.fixed = fixed;
    }

    @Override
    public double applyDiscount(double price) {
        return price-fixed;
    }
}
