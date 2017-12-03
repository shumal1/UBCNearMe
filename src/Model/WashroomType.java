package Model;

public enum WashroomType {
    MALE("Male"),
    FEMALE("Female"),
    ACCESSIBLE("Accessible");

    private  String displayName;
    WashroomType(String displayName) {this.displayName = displayName;}

    public String getDisplayName() {return displayName;}

    public static WashroomType getType(String nm) {
        switch (nm) {
            case "Male":
                return MALE;
            case "Female":
                return FEMALE;
            case "Accessible":
                return ACCESSIBLE;
        }return null;
    }
}

