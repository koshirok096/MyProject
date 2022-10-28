import java.util.Scanner;
import java.util.UUID;
import java.net.Inet4Address;
import java.net.InetAddress;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import java.net.URL;

public class DataAccount<s1, s2> {

    private final String accountNumber;
    private s2 accountHolderName;

    double balance;
    double prevTransaction;

    s2 accountType;
    s2 accountStatus;

    public DataAccount(s2 accountHolderName, double balance) {
        this.accountNumber = UUID.randomUUID().toString();
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public static boolean isValid(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Object showMenu() throws SocketException {

        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("==================================");
            System.out.println("1. Domain to IP Address");
            System.out.println("2. Get LocalHost");
            System.out.println("3. IP Address to Hostname");
            System.out.println("4. Network IP Address Lookup");
            System.out.println("5. Internet Connectivity Check");
            System.out.println("6. URL Validation Check");
            System.out.println("7. Change Stored Domain");
            System.out.println("8. Exit");
            System.out.println("==================================");
            System.out.println("                                  ");
            System.out.print("Enter an option: ");
            option = scanner.next().charAt(0);
            System.out.println();
            switch (option) {
                case '1':
                    System.out.println("==================================");
                    System.out.println("                                  ");
                    System.out.println("\"Domain to IP address\"\n ├ ①  Use Stored Info\n └ ②  Enter Manually");
                    System.out.println("                                  ");
                    int d1 = scanner.nextInt();
                    if (d1 == 1) {
                        try {
                            String Ad4IP;
                            System.out.println("                                  ");
                            InetAddress ip = InetAddress.getByName(Ad4IP = (String) accountHolderName);
                            System.out.println(Ad4IP + "'s IP Address is: ");
                            System.out.println("                                  ");
                            System.out.println(ip.getHostAddress());
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    } else if (d1 == 2) {
                        System.out.println(" └ Enter The Domain (like this: google.com, youtube.com, etc...:)");
                        System.out.println("                                  ");
                        String Ad4IP = scanner.next();
                        try {
                            System.out.println("                                  ");
                            InetAddress ip = InetAddress.getByName(Ad4IP);
                            System.out.println(Ad4IP + "'s IP Address is: ");
                            System.out.println("                                  ");
                            System.out.println(ip.getHostAddress());
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    } else {
                        System.out.println("Invalid option! Please enter again.");
                    }
                    System.out.println();
                    break;
                case '2':

                    System.out.println("==================================");
                    System.out.println("                                  ");
                    System.out.println("\"Get LocalHost\"\n\nYour your LocalHost information is below.");
                    System.out.println("                                  ");
                    try {
                        InetAddress myIP = InetAddress.getLocalHost();
                        System.out.println(myIP);
                        System.out.println(myIP.getHostName());
                        System.out.println(myIP.getHostAddress());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    System.out.println();
                    break;
                case '3':
                    System.out.println("==================================");
                    System.out.println("                                  ");
                    System.out.println("\"IP Address to Hostname\"\n ├ ①  Use Stored Info\n └ ②  Enter Manually");
                    System.out.println("                                  ");

                    int d2 = scanner.nextInt();
                    if (d2 == 1) {
                        String Ad4Host = (String) accountHolderName;
                        try {
                            InetAddress ip = InetAddress.getByName(Ad4Host);
                            System.out.println("                                  ");
                            System.out.println("Stored domain, " + accountHolderName + "'s IP address is " + ip.getHostAddress());
                            String IPInt = ip.getHostAddress();
                            ip = InetAddress.getByName(IPInt);
                            System.out.println("                                  ");
                            System.out.println(IPInt + "'s HostName is: ");
                            System.out.println("                                  ");
                            System.out.println(ip.getHostName());
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    } else if (d2 == 2) {
                        System.out.println(" └ Enter The IP Address: ");
                        System.out.println("                                  ");
                        String Ad4Host = scanner.next();
                        try {
                            System.out.println("                                  ");
                            InetAddress ip = InetAddress.getByName(Ad4Host);
                            System.out.println(Ad4Host + "'s HostName is: ");
                            System.out.println("                                  ");
                            System.out.println(ip.getHostName());
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    } else {
                        System.out.println("Invalid option! Please enter again.");
                    }
                    System.out.println();
                    break;
                case '4':
                    System.out.println("==================================");
                    System.out.println("                                  ");
                    System.out.println("                                  ");
                    Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
                    while (n.hasMoreElements()) {
                        System.out.println("----------------------------------------------------");
                        NetworkInterface e = n.nextElement();
                        System.out.println("Interface Name: " + e.getName());
                        Enumeration<InetAddress> a = e.getInetAddresses();
                        while (a.hasMoreElements()) {
                            InetAddress addr = a.nextElement();
                            String add = addr.getHostAddress().toString();
                            if (add.length() < 17)
                                System.out.println("IPv4 Address: " + add);
                            else
                                System.out.println("IPv6 Address: " + add);
                        }
                    }
                    System.out.println();
                    break;
                case '5':
                    System.out.println("==================================");
                    System.out.println("                                  ");
                    System.out.println("\"Internet Connectivity Check\"");
                    System.out.println("                                  ");
                    try {
                        URL url = new URL("http://www.google.com");
                        URLConnection connection = url.openConnection();
                        connection.connect();
                        System.out.println("Good news! Your device is connected to internet.");
                    } catch (MalformedURLException e) {
                        System.out.println("Now your device is NOT connected to internet.");
                    } catch (IOException e) {
                        System.out.println("Now your device is NOT connected to internet.");
                    }
                    System.out.println("                                  ");
                    break;
                case '6':
                    System.out.println("==================================");
                    System.out.println("                                  ");
                    System.out.println(
                            "\"URL Validation Check\"\n ├ ①  Use Stored Info\n └ ②  Enter Manually\n * Don't enter \"https://www.\". It will be added to the head of URL automatically!");
                    System.out.println("                                  ");
                    int d3 = scanner.nextInt();
                    System.out.println("                                  ");
                    if (d3 == 1) {
                        String url1 = "https://www." + (String) accountHolderName;
                        if (isValid(url1))
                            System.out
                                    .println("Your stored domain, https://www." + accountHolderName + " is valid URL!");
                        else
                            System.out.println(
                                    "Your stored domain, https://www." + accountHolderName + " is NOT valid URL.");
                    } else if (d3 == 2) {
                        System.out.println(" └ Enter The Domain (like this: google.com, youtube.com, etc...:) ");
                        System.out.println("                                  ");
                        String ValiType = scanner.next();
                        String url2 = "https://www." + (String) ValiType;
                        if (isValid(url2))
                            System.out.println("https://www." + ValiType + " is valid URL!");
                        else
                            System.out.println("https://www." + ValiType + " is NOT valid URL.");
                    }
                    System.out.println("                                  ");
                    break;
                case '7':
                    System.out.println("==================================");
                    System.out.println("                                  ");
                    System.out.println("\"Change Stored Domain\"\nYou recorded " + accountHolderName
                            + " as your bookmark.\nDo you want to replace it with new domain?\n ├ ①  Yes\n └ ②  No");
                    System.out.println("                                  ");

                    int d4 = scanner.nextInt();
                    System.out.println("                                  ");
                    if (d4 == 1) {
                        System.out.println(" └ Enter The New Domain (like this: google.com, youtube.com, etc...:) ");
                        System.out.println("                                  ");
                        String newDomain = scanner.next();
                        try {
                            System.out.println("                                  ");
                            accountHolderName = (s2) newDomain;
                            System.out.println("Woohoo! Now " + accountHolderName + " is stored!");
                            System.out.println("                                  ");
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    } else if (d4 == 2) {
                        System.out.println("Back To Menu");
                        System.out.println("                                  ");
                    }
                    break;
                case '8':
                    System.out.println("==================================");
                    scanner.close();
                    break;
                default:
                    System.out.println("Invalid option! Please enter again.");
                    break;
            }
        } while (option != '8');
        System.out.println();
        System.out.println("Thank you for using! Have a great one");
        System.out.println("                                  ");
        System.out.println("                                  ");
        System.out.println(
                "████████                      ██  ██                                  \n██                            ██  ██                                  \n██  ▓▓▓▓  ▓▓▓▓▓▓  ██▓▓▓▓  ▓▓▓▓██  ██▓▓▓▓  ▓▓  ██  ▓▓▓▓▓▓              \n██    ██  ██  ██  ██  ██  ██  ██  ██  ██  ██  ██  ██  ██              \n████████  ██████  ██████  ██████  ██████  ██████  ██████              \n                                              ██  ██                  \n████████████████████████████████████████  ██████  ██████    ██  ██  ██");
        System.out.println("                                  ");
        System.out.println("                                  ");
        return scanner;
    }
}
