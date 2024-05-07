package shoppingcart;

public enum Specials {

    BOGO("B.O.G.O Free");

    final String specialDescriptor;

    public String getSpecialDescriptor() {
        return specialDescriptor;
    }

    Specials(String specialDescriptor) {
        this.specialDescriptor = specialDescriptor;
    }
}
