import java.net.SocketException;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws SocketException {
        System.out.println("                                  ");
        System.out.println("\n        ██╗ █████╗ ██╗   ██╗ █████╗ \n        ██║██╔══██╗██║   ██║██╔══██╗\n        ██║███████║██║   ██║███████║\n   ██   ██║██╔══██║╚██╗ ██╔╝██╔══██║\n   ╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║\n    ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝");
        System.out.println("                                  ");
        System.out.println("Hello, this is the network information hub powered by Java.\nThis program can get some data relating to URL, domain and IP etc.\nAnd also there some useful functions about network.\nFirst of all, let's register a domain that you want to check. Enter like this: google.com, youtube.com, etc...");
        System.out.println("                                  ");
        Scanner scanner = new Scanner(System.in);
        String YourDomain = scanner.next();
        System.out.println("                                  ");
        System.out.println("Thank you! Now, " + YourDomain + " is stored.\nWhen you try some functions in this tool, you can use this domain as a quick-use bookmark. But also, you can enter a domain or some info manually if you like. \nPlease choose the one from the options below: ");
        System.out.println("                                  ");
        DataAccount<Integer, String> myAccount = 
            new DataAccount
            <>(
                YourDomain, 
                100);

        myAccount.showMenu();
        
        // scanner.close();


    }
    
}

