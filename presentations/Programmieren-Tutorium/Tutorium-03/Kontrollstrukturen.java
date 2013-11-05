if (<Bedingung>) {
    // Anweisung für '<Bedingung> ist wahr'
} else {
    // Anweisung für '<Bedingung> ist falsch'
}

if (<Bedingung>) {
    // Anweisung für '<Bedingung> ist wahr'
} else if (<andere Bedingung>) {
    // Anweisung für '<andere Bedingung> ist wahr'
} else {
    // Anweisung für '<Bedingung> ist falsch'
}

public class World {
    public static void main(String[] a) {
        int monat = 12;
        switch (monat) {
        case 1:
            System.out.println("Es ist Januar!");
            break;
        case 2:
            System.out.println("Es ist Februar!");
            break;
        case 3:
            System.out.println("Es ist März!");
            break;
        default:
            // Anweisung, wenn monat keinen angegebener Wert angenommen hat.
            System.out.println("Es ist Weihnachten!");
        }
    }
}

while(true) {
    System.out.println("It's true!");
}

for (int i = 0; i < 10; i++) {
    System.out.println(i);
}

while (bedingung) {
    // Anweisungen werden ausgeführt, solange bedingung == true
}

do {
    // Anweisungen werden ausgeführt, solange bedingung == true
} while (bedingung);
