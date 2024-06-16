public class Bookcase implements IProduct {

    private String name = "Bookcase";

    public Bookcase() {
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