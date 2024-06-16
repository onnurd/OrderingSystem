public class Chair implements IProduct {

    private String name = "Chair";

    public Chair() {
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
