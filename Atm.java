import java.util.*;
class Atm
{
    public static HashMap<Integer,ArrayList<String>>cd =new HashMap<Integer,ArrayList<String>>();
    public static ArrayList<ArrayList<String>>transaction =new ArrayList<ArrayList<String>>();
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        while(true){
            System.out.println("Enter Choice:\n1.CustomerLogin\n2.Exit ");
            int choice=obj.nextInt();
            switch(choice)
            {
                case 1:
                    CustomerLogin();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter Valid Choice");
            }
        }
    }
    public static void CustomerLogin() {
        ArrayList<String> details=new ArrayList<>();
        details.add("6565");
        details.add("ajay");
        details.add("10000");
        cd.put(1234512345, details);
        Scanner obj=new Scanner(System.in);
        System.out.println("please enter Credit Card Number");
        int cnumber=obj.nextInt();
        System.out.println("Enter Pin Number");
        int pin=obj.nextInt();
        String pin1=String.valueOf(pin);
        if(cd.containsKey(cnumber))
        {
            if(pin1.equals((cd.get(cnumber).get(0))))
            {
                System.out.println("Welcome User"+(cd.get(cnumber).get(1)));
                Transaction(cnumber);
            }
            else
            {
                System.out.println("Enter Correct Pin number");
            }
        }
        else
            System.out.println("Enter Valid card Number");
    }
    public static void Transaction(int cnumber) {
        Scanner obj=new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter Choice:\n1.Check The Balance\n2.WithDraw the Money\n3.Deposit the Money\n4.Transfer\n5.Mini Statement\n6.Exit ");
            int choice=obj.nextInt();
            switch(choice)
            {
                case 1:
                    enquiry(cnumber);
                    break;
                case 2:
                    CashWithDraw(cnumber);
                    break;
                case 3:
                    Deposit(cnumber);
                    break;
                case 4:
                    Transfer(cnumber);
                    break;
                case 5:
                    Statement(cnumber);
                    break;
                case 6:
                    System.out.println("Thanks for Using!!!!!!!!!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter correct Choice in User menu");
            }
        }
    }
    public static void enquiry(int cnumber) {
        System.out.println("Current Balance is: "+cd.get(cnumber).get(2));
    }
    public static void CashWithDraw(int cnumber) {
        Scanner obj=new Scanner(System.in);
        System.out.println("Enter Amount:");
        int cash=obj.nextInt();
        if(cash<=Integer.parseInt(cd.get(cnumber).get(2))){
            System.out.println("Your Amount is proceded");
            String amount=cd.get(cnumber).get(2);
            int amount1=Integer.parseInt(amount);
            amount1-=cash;
            amount=String.valueOf(amount1);
            ArrayList<String> details=cd.get(cnumber);
            details.set(2, amount);
            cd.put(cnumber,details);
            ArrayList<String> transactionDetails=new ArrayList<>();
            transactionDetails.add(String.valueOf(cnumber));
            transactionDetails.add("With Draw");
            transactionDetails.add(String.valueOf(cash));
            transaction.add(transactionDetails);
            System.out.println("Your Balance is: "+cd.get(cnumber).get(2));
        }
        else{
            System.out.println("Insufficent Balance");
        }
    }
    public static void Deposit(int cnumber) {
        Scanner obj=new Scanner(System.in);
        System.out.println("Enter Amount: ");
        int cash=obj.nextInt();
        System.out.println("Your Amount is Deposited");
            String amount=cd.get(cnumber).get(2);
            int amount1=Integer.parseInt(amount);
            amount1+=cash;
            amount=String.valueOf(amount1);
            ArrayList<String> details=cd.get(cnumber);
            details.set(2, amount);
            cd.put(cnumber,details);
            ArrayList<String> transactionDetails=new ArrayList<>();
            transactionDetails.add(String.valueOf(cnumber));
            transactionDetails.add("Deposit");
            transactionDetails.add(String.valueOf(cash));
            transaction.add(transactionDetails);
            System.out.println("Your Balance is: "+cd.get(cnumber).get(2));
    }
    public static void Statement(int cnumber) {
        
        for(ArrayList<String> i:transaction)
        {
            if(Integer.parseInt(i.get(0))==cnumber){
                for(String j:i){
                    System.out.print(j+" ");
                }
                System.out.println();
            }
        }
    }
    public static void Transfer(int cnumber) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Account Number of transfer account ");
        int acc1=sc.nextInt();
        System.out.println("Enter Amount to Transfer ");
        int cash=sc.nextInt();
        if(cash<=Integer.parseInt(cd.get(cnumber).get(2))){
            System.out.println("Ammount of "+cash+"Rs"+"Transfered to "+acc1);
            String amount=cd.get(cnumber).get(2);
            int amount1=Integer.parseInt(amount);
            amount1-=cash;
            amount=String.valueOf(amount1);
            ArrayList<String> details=cd.get(cnumber);
            details.set(2, amount);
            cd.put(cnumber,details);
            ArrayList<String> transactionDetails=new ArrayList<>();
            transactionDetails.add(String.valueOf(cnumber));
            transactionDetails.add("Transfer");
            transactionDetails.add(String.valueOf(cash));
            transaction.add(transactionDetails);
            System.out.println("The Balance Amount: "+cd.get(cnumber).get(2)+"Rs");
        }
        else{
            System.out.println("Sorry Insufficent Balance.");
        }
    }
}