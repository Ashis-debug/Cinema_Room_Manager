import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String type = scanner.next();

        switch (type) {
            case "rectangle":
                float firstSide = scanner.nextFloat();
                float secondSide = scanner.nextFloat();
                System.out.println(firstSide * secondSide);
                break;
            case "triangle":
                float a = scanner.nextFloat();
                float b = scanner.nextFloat();
                float c = scanner.nextFloat();

                float s = (a + b + c) / 2;

                float ans = s * (s - a) * (s - b) * (s - c);

                System.out.println(Math.sqrt(ans));
                break;
            case "circle":
                float r = scanner.nextFloat();
                System.out.println(3.14 * r * r);
                break;
            default:
                System.out.println("The given shape is undefined!");
                break;
                
        }
    }
}
