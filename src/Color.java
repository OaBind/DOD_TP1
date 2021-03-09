public enum Color {
    RED("RED"),
    BLUE("BLUE"),
    GREEN( "GREEN");

    public String name;

    Color(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
