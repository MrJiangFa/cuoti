package annotation.p625;

@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30)
    String firstName;
    @SQLString(50)
    String lastName;
    @SQLInteger
    int age;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }

    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String handle;

}
