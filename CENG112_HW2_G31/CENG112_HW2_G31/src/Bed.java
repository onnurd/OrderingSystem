public class Bed implements IProduct {

    private String name = "Bed";

    public Bed() {
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
