package Enums;

public enum UserData {

    USER_LOGIN("gartungk"),USER_PASSWORD("xMB5r3rnrWqz");

   private String value;

    UserData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    }
