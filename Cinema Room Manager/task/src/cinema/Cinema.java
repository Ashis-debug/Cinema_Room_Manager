package cinema;
import java.util.*;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your code here
        System.out.println("Enter the number of rows:");
        System.out.print("> ");
        int row = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        System.out.print("> ");
        int column = scanner.nextInt();
        System.out.println();

        char[][] cinema = new char[row][column];
        for (char rows[] : cinema) {
            Arrays.fill(rows, 'S');
        }

        menu(cinema);

    }

    static void menu(char[][] cinema) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            System.out.print("> ");
            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    printCinemaHall(cinema);
                    System.out.println();
                    break;
                case 2:
                    bookYourSeat(cinema);
                    System.out.println();
                    break;
                case 3:
                    statistics(cinema);
                    System.out.println();
                    break;
                case 0:
                    return;

            }
        }
    }

    static void statistics(char[][] cinema) {
        float total = cinema.length * cinema[0].length;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                if (cinema[i][j] == 'B') {
                    count++;
                    sum = sum + calculateSeatPrice(cinema, i + 1);
                    System.out.println(sum);
                }
            }
        }

        System.out.println("Number of purchased tickets " + (int)count);
        float percent = (count / total) * 100;
        System.out.println("Percentage: "+String.format("%.2f",percent) + "%");
        System.out.println("Current income: $" + sum);
        System.out.println("Total income: $" + calculateProfit(cinema));

    }

    static int calculateProfit(char[][] cinema) {
        int rows = cinema.length;
        int columns = cinema[0].length;
        int totalProfit = 0;
        if (rows * columns <= 60) {
            totalProfit = rows * columns * 10;
        } else {
            int firstHalf = rows / 2;
            int secondHalf = rows - firstHalf;
            totalProfit = (firstHalf * 10 * columns)  + (secondHalf * 8 * columns);
        }
        return totalProfit;
    }

    static void printCinemaHall(char[][] cinema) {
        int row = cinema.length;
        int column = cinema[0].length;
        System.out.println("Cinema:");
        for (int i = 0; i < column; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (j == 0) {
                    System.out.print(i +1 + " ");
                }
                System.out.print(cinema[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int calculateSeatPrice(char[][] cinema ,int rowNo) {
        int rows = cinema.length;
        int columns = cinema[0].length;
        if (rows * columns <= 60) {
            return 10;
        }
        int mid = rows / 2;

        if (rowNo <= mid) {
            return 10;
        } else {
            return 8;
        }
    }

    static void bookYourSeat(char[][] cinema) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a row number:");
            System.out.print("> ");
            int rowNo = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            System.out.print("> ");
            int columnNo = scanner.nextInt();
            System.out.println();

            if (rowNo < 0 || rowNo > cinema.length || columnNo < 0 || columnNo > cinema[0].length) {
                System.out.println("Wrong input!");
                System.out.println();
            } else if (cinema[rowNo - 1][columnNo - 1] == 'B'){
                System.out.println("That ticket has already been purchased!");
                System.out.println();
            }
            else {
                cinema[rowNo - 1][columnNo - 1] = 'B';
                System.out.println("Ticket price: $" + calculateSeatPrice(cinema, rowNo));
                break;
            }
        }

    }




}