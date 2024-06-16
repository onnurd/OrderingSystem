public class Table implements IProduct {

    private String name = "Table";

    public Table() {
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
