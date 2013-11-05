public class Student {
    // die Attribute sind nun nach außen nicht mehr sichtbar
    private String name;
    private int semester;
    private int matriculationNumber;

    public Student(String name, int semester, int matriculationNumber) {
        // hier wird wie gewohnt alles initialisiert
    }
}

public class Main {
    public static void main(String[] args) {
        Student maxMustermann = new Student("Max Mustermann", 3, 1234567);
        // hier bekommt man nun einen Compilerfehler
        maxMustermann.matriculationNumber = 3141592;
        // ...
    }
}

public class Student {
    // ... Attribute, Konstruktor usw. ...


    // die getter-Methode für das Attribute 'name'
    public String getName() {
        return this.name;
    }
    // ... weitere getter-Methoden usw. ...
}

public class Main {
    public static void main(String[] args) {
        Student maxMustermann = new Student("Max Mustermann", 3, 1234567);
        // liest den Namen und gibt ihn aus
        System.out.println(maxMustermann.getName());
        // ...
    }
}
