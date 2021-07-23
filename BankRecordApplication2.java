package bankrecordapplication;
import java.util.Scanner; // Importing java.util.Scanner package to utilize the Scanner class.
interface Bank // Creating an interface named Bank.
{
    void getDetails(); // Method declaration of getDetails() that will store the entered details of the user.
    void displayDetails(); // Method declaration of displayDetails() that will display the obtained user details.
    double displayBalance(double dep);
}

class Welcome implements Bank // Class Welcome provides implementation of the Bank interface. 
{
    String name,type; // Declaring variables name and type of type String that will store the name of the account holder and type of the account respectively.
    int accno; // Declaring variable accno of type int that will store the account number of the user.
    double balance;
    
    Scanner in = new Scanner(System.in); // Creating in object of Scanner class to get input fro the user.
    @Override 
    public void getDetails() // Using method overriding to define the functionality of method getDetails().
    {
        System.out.println("Enter the name of the Account holder: ");
        name = in.nextLine(); // Store the name of the account holder in name variable.
        System.out.println("Hello "+name+" enter your account number: ");
        accno=in.nextInt(); // Store the account number provided by the user in accno variable.
        type=in.nextLine();
        System.out.println("Please enter the account type(Case Sensitive): Savings/Current ");
        type=in.nextLine(); // Store the details regarding type of account in type variable.
    }

    @Override
    public void displayDetails() // Using method overriding to define the functionality of method displayDetails().
    {
        System.out.println("\nDisplaying obtained details: "); 
        System.out.println("Name of the Account holder: "+name); // Display the name of the account holder.
        System.out.println("Account number: "+accno); // Display the account number.
        if(!("Current".equals(type))||!("Savings".equals(type))) // Check for the provided type of account and perform corresponding operations.
        {
            System.out.println("Account type: "+type+" has been verified successfully!"); // If provided details match print out this statement.
        }
        else
        {
            System.out.println("Sorry the entered account type does not exist! Please try again"); // Else print out this message.
        }
    }
    @Override
    public double displayBalance(double dep) // Using method overriding to define the functionality of method displayBalance().
    {
        balance=10000;
       balance=balance+dep; // Add the deposited amount to the current balance.
       System.out.println("Amount deposited successfully!");
        System.out.println("Available balance in "+accno+" is: Rs. "+balance); // Display the current balance.
       return(balance);
    }

}

abstract class Loan extends Welcome // Creating an abstract class Loan to handle loan related activities.
{
    abstract void calculateInterest(); // calculateInterest() is the abstract method of Loan class.

}
class HomeLoan extends Loan // Class HomeLoan extends abstract class Loan hierarchically.
{

   protected int prin_amt,time; // Declaring int type variables prin_amt,time as protected type to prevent direct access of data.
   protected double rate,emi; // Declaring double type variables rate, emi as protected to prevent direct access of data.
    HomeLoan(int p,int t,double r) // Using parameterized constructor to store the details obtained from the user.
    {
        prin_amt=p; // Store the principal amount.
        time=t*12; // Store the loan duration in terms of months.
        rate=r/(12*100); // Store the rate of interest after performing the corresponding calculation.
    }
    @Override 
    protected void calculateInterest() // Using method overrding to provide functionality of the method calculateInterest().
    {
        emi=(rate*prin_amt*Math.pow(1+rate,time))/(Math.pow(1+rate,time)-1); // Calculating the EMI to be paid by the user using Math.pow() function.
        System.out.println("For the selected Rate of Interest: "+rate+
        "\nThe Principal amount stated is: "+prin_amt+"\nThe calculated interest(EMI) to be paid is: "
        +emi+" per month for the duration of: "+time+" Months"); // Displaying the calculated EMI along with the provided details.
    }
}

class VehicleLoan extends Loan // Class VehicleLoan extends abstract class Loan hierarchically.
{
   protected int principle,duration; // Declaring int type variables principle,duration as protected type to prevent direct access of data. 
   protected double rate,emi; // Declaring double type variables rate, emi as protected to prevent direct access of data.
   VehicleLoan(int p,int t,double r) // Using Parameterized constructor to store the details entered by the user.
   {
       principle=p; // Store the principle amount.
       duration=t*12; // Store the loan duration in terms of months.
       rate=r/(12*100); // Store the rate of interest.
   }
   @Override
   protected void calculateInterest() // Using method overrding to provide functionality of the method calculateInterest(). 
    {
        emi=(rate*principle*Math.pow(1+rate,duration))/(Math.pow(1+rate,duration)-1); // Calculating the EMI to be paid by the user using Math.pow() function.
        System.out.println("For the selected Rate of Interest: "+rate+
        "\nThe Principal amount stated: "+principle+"\nThe calculated interest(EMI) to be paid is: "
        +emi+" per month for the duration of: "+duration+ " Months"); // Displaying the calculated EMI along with the provided details. 
    }

}

class EducationLoan extends Loan
{
    protected int principle,duration; // Declaring int type variables principle,duration as protected type to prevent direct access of data.
   protected double rate,emi; // Declaring double type variables rate, emi as protected to prevent direct access of data.
   EducationLoan(int p,int t,double r) // Using Parameterized constructor to store the details entered by the user.
   {
       principle=p; // Store the principle amount.
       duration=t*12; // Store the loan duration in terms of months.
       rate=r/(12*100); // Store the rate of interest.
   }
    @Override
    protected void calculateInterest() // Using method overrding to provide functionality of the method calculateInterest(). 
    {
       emi=(rate*principle*Math.pow(1+rate,duration))/(Math.pow(1+rate,duration)-1); // Calculating the EMI to be paid by the user using Math.pow() function.
        System.out.println("For the selected Rate of Interest: "+rate+
        "\nThe Principal amount stated: "+principle+"\nThe calculated interest(EMI) to be paid is: "
        +emi+" per month for the duration of: "+duration+ " Months"); // Displaying the calculated EMI along with the provided details.
    }

}

abstract class FixedDeposit extends Welcome // Declaring abstract class FixedDeposit to handle all the functions related to Fixed Deposit.
{
    abstract void calculateInterest(); // Declaring abstract method calculateInterest() to calculate the interest amount related to the FD.
}
class ThreeYears extends FixedDeposit // Class ThreeYears extends hierarchically from class FixedDeposit.
{
    protected int princ_amt,time=3; // Declaring int type variables princ_amt, time as protected to prevent direct memory access. time is fixed in this case i.e. 3 years.
    protected double amt,intr,rate; // Declaring double type variables amt, intr, rate of type protected to prevent direct memory access.
    ThreeYears(int p,double r) // Using parameterized constructor to assign the obtained values of principle and rate of interest.
    {
       princ_amt=p; // Store the principle amount.
       rate=r; // Store the rate of interest.
    }
    @Override
    protected void calculateInterest() // Using method overriding to define the functionality of calculateInterest() method.
    {
        intr=(princ_amt*time*rate)/100; // Using basic formula of interest calculation to calculate the interest.
        amt=intr+princ_amt; // Adding the calculated interest in the principle amount to dispaly the total amount to ber received after three years.
        System.out.println("Amount that you will receive after "+time+" years is: " +amt+" for a principle amount of: "+princ_amt+" and rate of interest: "+rate); 
        // Display the amount along with the provided details.
    }
    protected void calculateInterest(int p,int t,double r) // Using method overloading to provide the same functionality.
    {
        intr=(p*t*r)/100; // Calculating the interest.
        amt=intr+p; // Adding the interest in the principle.
        System.out.println("The principle of "+p+" after "+t+
                " years at the rate of interest: "+r+"%\nwill be: "+amt); // Displaying the results.
    }
}

class FiveYears extends FixedDeposit // Class FiveYears extends hierarchically from class FixedDeposit.
{
    protected int princ_amt,time=5; // Declaring int type variables princ_amt, time as protected to prevent direct memory access. time is fixed in this case i.e. 5 years.
    protected double intr,rate,amt; // Declaring double type variables amt, intr, rate of type protected to prevent direct memory access.
    FiveYears(int p,double r) // Using parameterized constructor to assign the obtained values of principle and rate of interest.
    {
       princ_amt=p; // Store the principle amount.
       rate=r; // Store the rate of interest.
    }
    @Override
    protected void calculateInterest() // Using method overriding to define the functionality of calculateInterest() method.
    {
        intr=(princ_amt*time*rate)/100; // Using basic formula of interest calculation to calculate the interest.
        amt=intr+princ_amt; // Adding the calculated interest in the principle amount to dispaly the total amount to ber received after five years.
        System.out.println("Amount that you will receive after "+time+" years is: "+amt+" for a principle amount of: "+princ_amt+" and rate of interest: "+rate);
        // Display the amount along with the provided details.    
    }
    protected void calculateInterest(int p,int t,double r) // Using method overloading to provide the same functionality.
    {
        intr=(p*t*r)/100; // Calculating the interest.
        amt=intr+p; // Adding the interest in the principle.
        System.out.println("The principle of "+p+" after "+t+
                " years at the rate of interest: "+r+"% \nwill be: "+amt); // Displaying the results.
    }
}

class SevenYears extends FixedDeposit // Class SevenYears extends hierarchically from class FixedDeposit.
{
    protected int princ_amt,time=7; // Declaring int type variables princ_amt, time as protected to prevent direct memory access. time is fixed in this case i.e. 7 years.
    protected double intr,rate,amt; // Declaring double type variables amt, intr, rate of type protected to prevent direct memory access.
    SevenYears(int p,double r) // Using parameterized constructor to assign the obtained values of principle and rate of interest.
    {
       princ_amt=p; // Store the principle amount.
       rate=r; // Store the rate of interest.
    }
    @Override
    protected void calculateInterest() // Using method overriding to define the functionality of calculateInterest() method.
    {
        intr=(princ_amt*time*rate)/100; // Using basic formula of interest calculation to calculate the interest.
        amt=intr+princ_amt; // Adding the calculated interest in the principle amount to dispaly the total amount to ber received after seven years.
        System.out.println("Amount that you will receive after "+time+" years is: "
                +amt+" for a principle amount of: "+princ_amt+
                " and rate of interest: "+rate); // Display the amount along with the provided details.  
    }
    protected void calculateInterest(int p,int t,double r) // Using method overloading to provide the same functionality.
    {
        intr=(p*t*r)/100; // Calculating the interest.
        amt=p+intr; // Adding the interest in the principle.
        System.out.println("The principle of "+p+" after "+t+
                " years at the rate of interest: "+r+"% \nwill be: "+amt); // Displaying the results.
    }
}

abstract class Insurance extends Welcome // Declaring Insurance as an abstract class.
{
    abstract void insurancedetails(); // Declaring abstract method insuranceDetails().
}
class LifeInsurance extends Insurance // Class LifeInsurance extends Insurance class hierarchically.
{
        int policyno; // Declaring policyno as an int type variable that will store the policy number.
        double premium; // Declaring premium as type double to store the premium amount.
        double sumassured; // Declaring sumassured as type double to show the sumassured.
    LifeInsurance(int pn, double sa) // Using Parameterized constructor to store the necessary values.
    {
        policyno = pn; // Store the policy number in pn.
        sumassured = sa; // Store the sumassured in sa.
    }
        @Override
       void insurancedetails() // Using method overriding to provide functionality of method insurancedetails().
        {
        if(sumassured>=100000) // If value of sumassured is greater than or equal to 100000 then premium is Rs. 9980.
        {
            premium = 9980;
            System.out.println("For the policy no. "+policyno+" Sum Assured on accidental death is "+sumassured+" for a monthly premium payment of Rupees "+premium);
        }
        else if(sumassured>=1000000) // Else-if sumassured is greater than or equal to 1000000 then premium is Rs. 15980.
        {
            premium = 15980;
            System.out.println("For the policy no. "+policyno+" Sum Assured on accidental death is "+sumassured+" for a monthly premium payment of Rupees "+premium);
        }
        else if(sumassured>=10000000) // Else-if sumassured is greater than 10000000 then premium is Rs. 30980.
        {
            premium = 30980;
            System.out.println("For the policy no. "+policyno+" Sum Assured on accidental death is "+sumassured+" for a monthly premium payment of Rupees "+premium);
        }
        else // If sumassured value does not fall under above categories then display the following message.
        {
            System.out.println("Please enter the Assured Sum value greater than 1Lac.");
        }
        }
}
class VehicleInsurance extends Insurance // Class VehicleInsurance extends Insurance class hierarchically.
{
        int policyno; // Declaring policyno as an int type variable that will store the policy number.
        double premium; // Declaring premium as type double to store the premium amount.
        double sumassured; // Declaring sumassured as type double to show the sumassured.
    VehicleInsurance(int pn, double sa) // Using Parameterized constructor to store the necessary values.
    {
        policyno = pn; // Store the policy number in pn.
        sumassured = sa; // Store the sumassured in sa.
    }
        @Override
    void insurancedetails() // Using method overriding to provide functionality of method insurancedetails().
    {
        if(sumassured>=50000) // If sum assured is greater than Rs. 50000 then premium is Rs. 1980.
        {
            premium = 1980;
            System.out.println("For the policy no. "+policyno+" Sum Assured on Accident/Theft is "+sumassured+" for a monthly premium payment of Rupees "+premium);
        }
        else if(sumassured>=100000) // Else-if sum assured is greater than Rs. 100000 then premium is Rs. 4980.
        {
            premium = 4980;
            System.out.println("For the policy no. "+policyno+" Sum Assured on Accident/Theft is "+sumassured+" for a monthly premium payment of Rupees "+premium);
        }
        else if(sumassured>=1000000) // Else-if sum assured is greater than Rs. 1000000 then premium is Rs. 9980.
        {
            premium = 9980;
            System.out.println("For the policy no. "+policyno+" Sum Assured on Accident/Theft is "+sumassured+" for a monthly premium payment of Rupees "+premium);
        }
        else // If sumassured value does not fall under above categories then display the following message. 
        {
            System.out.println("Please enter the Assured Sum value greater than 50Thousand.");
        }
    }
}

 class BankRecordApplication  // Driver class.
{
    public static void main(String[] args)
    {
        int choice,s,p,t,pn; // Declaring variables.
        double r,sa,deposit,bal; // Declaring variables.
        Scanner sc = new Scanner(System.in); // Creating object sc of Scanner class to get the input from the user.
        System.out.println("=====**===== Welcome to our Bank! =====**=====");
        System.out.println("Please enter your details..");
        Welcome w = new Welcome(); // Creating object w of class Welcome.
        w.getDetails(); // Getting user details using getDetails() through object w.
        w.displayDetails(); // Displaying the user details thru displayDetails() using object w.
        System.out.println("\nHow may we provide service to you today?");
        System.out.println("1. Loan");
        System.out.println("2. Fixed Deposit");
        System.out.println("3. Insurance");
        System.out.println("4. Deposit Amount");
        System.out.println("Please enter your choice: ");
        choice=sc.nextInt(); // Store the selection in choice variable.
        switch(choice) // Using switch-case to perform the selected operation.
        {
            case 0: // As we have no function for 0 input display error message.
            {
                System.out.println("Invalid input! please select out of the provided options from 1 to 4");
                break;
            }
            case 1: //If user enters 1 then he wishes to get a loan.
            {
               System.out.println("Please select your type of loan:");
               System.out.println("1. Home Loan");
               System.out.println("2. Vehicle Loan");
               System.out.println("3. Education Loan");
               System.out.println("Please enter your choice: ");
               s=sc.nextInt(); // Store the choice of loan in s variable.
              switch (s) // Using switch case to go to the selection.
              {
                case 1: // If user enters 1 he wishes to avail a Home loan.
                {
                    System.out.println("Please enter the amount required by you: ");
                    p=sc.nextInt(); // Store the amount entered by user in p variable.
                    System.out.println("Please enter your suitable rate of interest: 5%,6%,7%");
                    r=sc.nextInt(); // Store the rate of interest as selected by the user in r variable.
                    System.out.println("Please enter the duration in terms of years: ");
                    t=sc.nextInt(); // Store the duration of loan in t variable.
                    HomeLoan h = new HomeLoan(p,t,r); // Passing the entered values thru constructor HomeLoan().
                    h.calculateInterest(); // Call to the calculateInterest() method thru object h.
                    break; // Exit on completion.
                }
                case 2: // If user enters 2 he wishes to avail Vehicle loan.
                {
                    System.out.println("Please enter the amount required by you: ");
                    p=sc.nextInt(); // Store the amount entered by user in p variable.
                    System.out.println("Please enter your suitable rate of interest: 5%,6%,7%");
                    r=sc.nextInt(); // Store the rate of interest as selected by the user in r variable.
                    System.out.println("Please enter the duration in terms of years: ");
                    t=sc.nextInt(); // Store the duration of loan in t variable.
                    VehicleLoan v = new VehicleLoan(p,t,r); // Passing the entered values thru constructor VehicleLoan().
                    v.calculateInterest(); // Call to the calculateInterest() method thru object v.
                    break; // Exit on completion.
                }
                case 3: // If user enters 3 he wishes to avail Education loan.
                {
                    System.out.println("Please enter the amount required by you: ");
                    p=sc.nextInt(); // Store the amount entered by user in p variable.
                    System.out.println("Please enter your suitable rate of interest: 5%,6%,7%");
                    r=sc.nextInt(); // Store the rate of interest as selected by the user in r variable.
                    System.out.println("Please enter the duration in terms of years: ");
                    t=sc.nextInt(); // Store the duration of loan in t variable.
                    EducationLoan ed = new EducationLoan(p,t,r); // Passing the entered values thru constructor EducationLoan().
                    ed.calculateInterest(); // Call to the calculateInterest() method thru object ed.
                    break; // Exit on completion.
                }
                default: // If any other value is entered display the following message.
                {
                    System.out.println("Invalid input!");
                }
              }
              break; // Exit on completion.
            }
            case 2: // If user enters 2 then he wishes to create a FD.
            {
               System.out.println("Please select your type of FD:");
               System.out.println("1. Three Years");
               System.out.println("2. Five Years");
               System.out.println("3. Seven Years");
               System.out.println("Please enter your choice: ");
               s=sc.nextInt(); // Store the selcetion in s variable.
               switch(s) // Using switch-case to get details about the type of FD the user wants to create.
               {
               case 1: // If user enters 1 then he wishes to fix the amount for three years.
                {
                 System.out.println("Please enter the amount you wish to deposit: ");
                 p=sc.nextInt(); // Store the amount to be fixed in p variable.
                 System.out.println("Please enter your desired rate of interest: 4% 6% 8%");
                 r=sc.nextInt(); // Store the rate of interest selected by the user in r variable.

                 ThreeYears th = new ThreeYears(p,r); // Create new object th of class ThreeYears.
                 th.calculateInterest(); // Calculating the interest using calculateInterest() method thru th variable.
                 break; // Exit on completion.
                }
               case 2: // If user enters 2 then he wishes to fix the amount for five years.
                {
               System.out.println("Please enter the amount you wish to deposit: ");
                 p=sc.nextInt(); // Store the amount to be fixed in p variable.
                 System.out.println("Please enter your desired rate of interest: 4% 6% 8%");
                 r=sc.nextInt(); // Store the rate of interest selected by the user in r variable.

                 FiveYears f = new FiveYears(p,r); // Create new object f of class FiveYears.
                 f.calculateInterest(); // Using object f calculate the interest thru calculateInterest() method.
                 break; // Exit on completion.
                }
                case 3: // If user enters 3 then he wishes to fix the amount for seven years.
                {
                System.out.println("Please enter the amount you wish to deposit: ");
                 p=sc.nextInt(); // Store the amount to be fixed in p variable.
                 System.out.println("Please enter your desired rate of interest: 4% 6% 8%");
                 r=sc.nextInt(); // Store the rate of interest selected by the user in r variable.

                 SevenYears se = new SevenYears(p,r); // Creating new object se of class SevenYears.
                 se.calculateInterest(); // Using object se calculate the interest thru calculateInterest() method.
                 break; // Exit on completion. 
                }
                default: // If user enters any other value then display the following message.
                {
                    System.out.println("Invalid input!");
                }
               }
               break; // Exit on completion.
            }
            case 3: // If user enters 3 then he wishes to get an insurance.
            {
               System.out.println("Please select your type of Insurance:");
               System.out.println("1. Life Insurance");
               System.out.println("2. Vehicle Insurance");
               System.out.println("Please enter your choice: ");
               s=sc.nextInt(); // Store the selection in s variable.
              switch (s) // Using seitch-case to get the necessary details.
              {
                case 1: // If user enters 1 he wishes to avail a life insurance.
                {
                    System.out.println("Please enter your Policy No.: ");
                    pn=sc.nextInt(); // Store the policy number in pn.
                    System.out.println("Please enter your required coverage of Sum Assured:");
                    sa=sc.nextDouble(); // Store the sum assured coverage in sa variable.
                    LifeInsurance l = new LifeInsurance(pn,sa); // Creating a new object l of class LifeInsurance.
                    l.insurancedetails(); // Calling the insurancedetails() method to calculate the monthly premium the customer will have to pay.
                    break; // Exit on completion.
                }
                case 2: // If user enters 2 the user wishes to avail a vehicle insurance.
                {
                    System.out.println("Please enter your Policy No.: ");
                    pn=sc.nextInt(); // Store the policy number in pn.
                    System.out.println("Please enter your required coverage of Sum Assured:");
                    sa=sc.nextDouble(); // Store the sum assured coverage in sa variable.
                    VehicleInsurance v = new VehicleInsurance(pn,sa); // Creating a new object v of class VehicleInsurance. 
                    v.insurancedetails(); // Calling the insurancedetails() method to calculate the monthly premium the customer will have to pay.
                    break; // Exit on completion. 
                }
                default: // If user enters any other value then display the following message.
                {
                    System.out.println("Invalid input!");
                }
              }
              break; // Exit on completion.
            }
            case 4: // If user enters 4 then he wishes to deposit money into his account.
            {
                Welcome w1 = new Welcome(); // Creating object w1 of class Welcome.
                System.out.println("Please enter amount to be deposited: ");
                deposit = sc.nextDouble(); // Storing the amount to be deposited in deposit variable.
                deposit=w1.displayBalance(deposit); // Passing the amount to be deposited in displayBalance() method using object w1.
                System.out.println("SUCCESS!! = Rupees "+deposit+" deposited.");
                break; // Exit on completion.
            }
            default: // If any other input is entered then display the following message.
            {
                System.out.println("Please select from the provided choices.");
                break;
            }
        }
        System.out.println("\n==**== THANK YOU! for Banking with Us ==**==");
        System.out.println("\nYou will shortly receive a receipt of your Transaction.\n");
    }
}
