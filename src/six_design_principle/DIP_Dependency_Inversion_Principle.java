package six_design_principle;

interface Driveable {
    void drive();
}

class Person {
    Driveable driveable;

    Person(Driveable driveable) {
        this.driveable = driveable;
    }

    public void goOut() {
        driveable.drive();
    }

}

public class DIP_Dependency_Inversion_Principle {

}
