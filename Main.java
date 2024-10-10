import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
interface Phone {
    void call();
    void text();
    void videoCall();
    void showCallHistory();
    void showTextHistory();
}

abstract class SimplePhone implements Phone {
    protected List<String> callHistory;
    protected List<String> videoCallHistory;
    protected List<String> textHistory;
    protected Scanner scanner;

    public SimplePhone() {
        this.callHistory = new ArrayList<>();
        this.videoCallHistory = new ArrayList<>();
        this.textHistory = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    
    public void showCallHistory() {
        System.out.println("Call History:");
        for (String call : callHistory) {
            System.out.println(call);
        }
    }

    public void showTextHistory() {
        System.out.println("Text History:");
        for (String text : textHistory) {
            System.out.println(text);
        }
    }
}

class GuledsPhone extends SimplePhone {

    public void call() {
        System.out.println(">>>>> Welcome to Simple Communication! Follow the steps <<<<");
        System.out.print("Who do you want to call? ");
        String contact = scanner.nextLine();
        callHistory.add("Called: " + contact);
        System.out.println("Calling " + contact + "...");
    }

    public void videoCall() {
        System.out.print("Who do you want to Video Call? ");
        String contact = scanner.nextLine();
        videoCallHistory.add("Video Called: " + contact);
        System.out.println("Video Calling " + contact + "...");
    }


    public void text() {
        System.out.print("Who do you want to text? ");
        String contact = scanner.nextLine();
        System.out.print("Enter your message: ");
        String message = scanner.nextLine();
        textHistory.add("Texted " + contact + ": " + message);
        System.out.println("Text sent to " + contact + ": " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        GuledsPhone myPhone = new GuledsPhone();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Call");
            System.out.println("2. Text");
            System.out.println("3. Video Call");
            System.out.println("4. Show Call History");
            System.out.println("5. Show Text History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    myPhone.call();
                    break;
                case 2:
                    myPhone.text();
                    break;
                case 3:
                    myPhone.videoCall();
                    break;
                case 4:
                    myPhone.showCallHistory();
                    break;
                case 5:
                    myPhone.showTextHistory();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
