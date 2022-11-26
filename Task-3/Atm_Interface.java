import java.util.*;
class Account
{
    String Name;
    String Username;
    String Pwd;
    String Account;
    float bal = 0.0f;
    int transactions = 0;

    public Account(String a, String b, String c, String d) //parameterized constructor for registering the account of the customer
    {
        Name = a;
        Username = b;
        Pwd = c;
        Account  = d;
        System.out.println("Account created successfully\n");
    }
    public boolean signin()
     {
         boolean isLogin = false;
         Scanner sc = new Scanner(System.in);
             System.out.print("\nEnter Your Username - ");
             String Usrnm = sc.nextLine();
             if ( Usrnm.equals(Username) ) {
                     System.out.print("\nEnter Your Password - ");
                     String pass = sc.nextLine();
                     if ( pass.equals(pass) ) {
                         System.out.print("\n!!Logined successful!!");
                         isLogin = true;
                     }
                     else {
                         System.out.println("\n@Incorrect Password@");
                     }

             }
             else {
                 System.out.println("Username not found\n");
         }
         return isLogin;

    }
    public void Deposit()
    {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter amount to deposit:\n");
        float mny = sc.nextFloat();
        if(mny <= 0.0)
        {
            System.out.println("Enter valid amount\n");
            transactions++;

        }
        else {
            bal = bal + mny;
            System.out.println(mny + " deposited successfully\n");
            transactions++;

        }


    }
     public void Withdrawl()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to withdrawl : \n");
        float withdraw = sc.nextFloat();
        if(withdraw >= bal)
        {
            System.out.println("Low Balance!!!" + "" + "\n");
        }
        else
        {
            System.out.println(withdraw + " withdrawn successfully\n");
            bal = bal - withdraw;
        }
    }
    public void Current_balance()
    {
        System.out.println("Your current balance is " + bal + " rupees only\n");
        transactions++;
    }
    public void Transaction_history()
    {
        System.out.println("Transactions done in this session is " + transactions);
    }
    public void Transfer()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the recepient name : \n");
        String receiver = sc.nextLine();
        System.out.println("Enter the amount to be transferred: \n");
        float transfer_amount = sc.nextFloat();
        if(transfer_amount > 0 && bal > transfer_amount) {
            System.out.println("Enter the account Number of the recepient:\n");
            String receiver_acc = sc.next();
            bal = bal - transfer_amount;
            System.out.println("Amount " + transfer_amount + " transferred successfully");
            transactions++;
        }
        else
        {
            System.out.println("Your current balance is low or enter the valid amount\n");
            transactions++;
        }

    }

}

public class Atm_Interface {
    public static void main(String args[])
    {
        System.out.println("Welcome to the DDFC Bank!!!");
        boolean operation = false;

            System.out.println("Enter your choice: \n1.Banking \n2.Exit\n");
            Scanner sc = new Scanner(System.in);
            int opt = sc.nextInt();
            if (opt == 1) {
                System.out.println("Enter your name:\n");
                String nam = sc.next();
                System.out.println("\n");
                System.out.println("Enter the user name:\n");
                String user_name = sc.next();
                System.out.println("Enter the password:\n");
                String pswd = sc.next();
                System.out.println("Enter your account number:\n");
                String acc = sc.next();
                Account a = new Account(nam, user_name, pswd, acc);
                System.out.println("Do you want to login: Yes/No\n");
                String want = sc.next();
                if (want.equalsIgnoreCase("Yes")) {
                    if (a.signin()) {
                        System.out.println("Please select the banking options\n");
                        boolean finished = false;
                        while (!finished) {
                            System.out.println("\n1.Deposit \n2.Withdrawl \n3. Bank Balance  \n4.Transactions Done \n5.Transfer \n");
                            int op = sc.nextInt();
                            switch (op) {
                                case 1:
                                    a.Deposit();
                                    break;
                                case 2:
                                    a.Withdrawl();
                                    break;
                                case 3:
                                    a.Current_balance();
                                    break;
                                case 4:
                                    a.Transaction_history();
                                    break;
                                case 5:
                                    a.Transfer();
                                    break;
                                default:
                                    finished = true;
                                    operation = true;
                                    break;

                            }
                        }
                    }

                } 
                else {
                    System.out.println("Thank You! and Have a nice day!!!\n");
                }

            } 
            else {
                System.out.println("Thank You! Have a nice day\n");
            }
    }
}
