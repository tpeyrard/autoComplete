package order;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: <program> <pattern>");
        } else {
            System.out.println(AutoComplete.search(args[0]));
        }
    }

}
