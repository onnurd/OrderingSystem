public class Dresser implements IProduct {

    private String name = "Dresser";

    public Dresser() {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public boolean isManifactured() {
        return true;
    }

    @Override
    public boolean isStored() {
        return true;
    }

    @Override
    public boolean isSold() {
        return true;
    }
}
