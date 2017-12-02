package Model;

public enum WRType {
    MALE("Male"),
    FEMALE("Female"),
    ACCESSIBILITY("Accessibility");

    private  String displayName;
    WRType(String displayName) {this.displayName = displayName;}

    public String getDisplayName() {return displayName;}

    public static WRType getType(String nm) {
        switch (nm) {
            case "Male":
                return MALE;
            case "Female":
                return FEMALE;
            case "Accessibility":
                return ACCESSIBILITY;
        }return null;
    }
}

