package com.SplitEasier.spliteasier.splitwise.model;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Group {
    private String name;
    private String type;
    private boolean simplifyDebt;
    private String user;
    private String firstName;
    private String lastName;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Group(String name, String type, boolean simplifyDebt, String user, String firstName, String lastName) {
        this.name = name;
        this.type = type;
        this.simplifyDebt = simplifyDebt;
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("users__0__last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("users__0__first_name")
    public String getFirstName() {
        return firstName;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("group_type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("simplify_by_default")
    public boolean isSimplifyDebt() {
        return simplifyDebt;
    }

    public void setSimplifyDebt(boolean simplifyDebt) {
        this.simplifyDebt = simplifyDebt;
    }

    @JsonProperty("users__0__email")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
