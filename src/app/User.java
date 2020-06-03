package app;

abstract class User {
    protected String firstName;
    protected String lastName;
    protected String email;

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.firstName, this.lastName, this.email);
    }
}

// 'User' is abstract; cannot be instantiated
// It will be "abstract" so that other programmers cannot use "instance" of User.
// so it will be used as "datatype"
// ex) User xxx = new User();
