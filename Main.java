import java.util.Scanner; // for the cli



public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the todo + notes cli thing");
        System.out.println("Type 'help' for a list of commands");

        Scanner scanner = new Scanner(System.in); // read the user's input
        
        while (true) {
            System.out.print("> "); // cool prompt prefix
            String input = scanner.nextLine().trim().toLowerCase(); // read and remove accidental whitespace and convert to lowercase

            // the meat of the cli
            switch (input) {
                case "help" -> printHelp();
                case "exit" -> {
                    System.out.println("またね"); // this did not print in my vscode cmd lol
                    return;
                }
                default -> System.out.println("Unknown command. Please type 'help'");
            }

        }
    }

    private static void printHelp(){
        System.out.println("""
                Commands:
                    help: show this message
                    exit: exit the app
                    todo: do todo stuff (TBD)
                    note: do note stuff (TBD)
                """);
    }

}
