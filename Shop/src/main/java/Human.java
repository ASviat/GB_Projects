public abstract class Human {

    protected String name;
    protected String dateOfBirth;
    protected String phone;

    enum Gender {Male, Female}

    protected Gender gender;

    public Human(String name, String dateOfBirth, String phone, Gender gender) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
}
