package Assignment1;
//............................................................
// Assignment 1
// ©Himangshu Shekhar Baruah
// Written by: Himangshu Shekhar BARUAH , Student ID 40229774
//............................................................


import java.util.Scanner;

 /**
 * ------------------------------- Program Description --------------------------------
 * This program is a voter management system where user can add a new voter,
  * edit voter details using the voterID, display all the voters from a specific
  * Pcode and display all the voters below a certain age. There is max number of voters
  * allowed which is inputted from the user at the start, and they cant add more voters
  * than the allowed limit.The program has got some critical tasks like create/change
  * voter details which require authentication and for the simplicity of the usage,
  * it has been hardcoded as " password ". If the password is entered wrong 3 times,
  * main menu is opened, and if 12 times the password is wrong for creating a voter
  * system exits due to suspicious activity. Voter Name, Age, Email and Pcode can be
  * changed by the user after authentication.
  * -----------------------------------------------------------------------------------
 */
public class Driver {
    /**
     * Initiate the scanner class and take input of maximum number
     * of voters.
     */
    public static Scanner sc = new Scanner(System.in);

    /**
     * The method mainMenu prints the main menu on the screen
     * and takes the input from the user.
     *
     * @return Returns the option selected by user
     */
    public static int mainMenu() {
        /**
         * Display the Main Menu
         */
        System.out.println("What do you want to do?");
        System.out.println("\t1.\tEnter new voters (password required)");
        System.out.println("\t2.\tChange information of a voter (password required)");
        System.out.println("\t3.\tDisplay all voters by a specific voterPcode");
        System.out.println("\t4.\tDisplay all voters under a certain age");
        System.out.println("\t5.\tExit");
        System.out.print("Please enter your choice > ");
        /**
         * Integer.parseInt is used to convert String to int.
         * @variable input is used to fetch the menu option.
         */
        int input = Integer.parseInt(sc.nextLine());

        return input;
    }

     /**
      * This method print the update menu and returns the input entered
      * by the user
      * @return input value selected by the user
      */
    public static int updateMenu() {
        /**
         * Display the Update Menu
         */
        System.out.println("What information would you like to change?");
        System.out.println("\t1.\tName");
        System.out.println("\t2.\tAge");
        System.out.println("\t3.\tEmail");
        System.out.println("\t4.\tPCode");
        System.out.println("\t5.\tExit");
        System.out.print("Enter your choice > ");
        /**
         * Integer.parseInt is used to convert String to int.
         * @variable input is used to fetch the menu option.
         */
        int input = Integer.parseInt(sc.nextLine());
        return input;
    }

     /**
      * This method returns the voter object from the voterBase array as required
      * @param voterID voter ID of the voter
      * @param voterBase array of voter objects
      * @return returns the voter object matching the voterID
      */
    public static Voter findVoterByID(long voterID,Voter[] voterBase) {

            for (int i = 0; i < voterBase.length; i++) {
                if(voterBase[i]!=null) {
                    if (voterBase[i].getVoterID() == voterID) {
                        return voterBase[i];
                }
            }
        }
        return null;
    }

     /**
      * This method returns the voter object index from the voterBase array as required
      * @param voterID voter ID of the voter
      * @param voterBase array of voter objects
      * @return returns the voter object index matching the voterID
      */
    public static int findVoterIndex(long voterID,Voter[] voterBase) {
        for (int i = 0; i < voterBase.length; i++) {
            if(voterBase[i]!=null){
                if (voterBase[i].getVoterID() == voterID) {
                    return i;
                }
            }
        }
        return -1;
    }

     /**
      * This method displays the voter details on the screen
      * @param voter voter object from voterBase array
      * @param index voter object index from voterBase array
      */
    public static void displayVoter(Voter voter,int index){
        System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*");
        System.out.println("+*+*+*+ Voter Details +*+*+*");
        System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*");
        System.out.println("Voter: #"+index);
        System.out.println(voter.toString());
    }

    /**
     * This method displays the voter details whose Pcode matches the search
     * requirement.
     * @param nextLine Voter Pcode to be searched as entered by user
     * @param voterBase Voter array containing voter objects.
     */
    public static void findVoterBy(String nextLine, Voter[] voterBase) {
        /**
         * for loop for searching the voter object and printing the voter
         * if details are matching.
         */
        for (int i = 0; i < voterBase.length; i++) {
            if(voterBase[i]!=null){
                if(String.valueOf(voterBase[i].getVoterPcode()).equals(nextLine)){
                    displayVoter(voterBase[i],i);
                }
            }
        }
    }

     /**
      * This method displays all the voters below a certain age
      * @param age age to be matched
      * @param voterBase voter object array containing the voters.
      */
    private static void findYoungerThan(byte age, Voter[] voterBase) {
        /**
         * for loop for searching the voter object and printing the voter
         * if age is less than the age entered.
         */
        for (int i = 0; i < voterBase.length; i++) {
            if(voterBase[i]!=null){
                if(voterBase[i].getVoterAge() < age){
                    displayVoter(voterBase[i],i);
                }
            }
        }
    }

     /**
      * main driver method to run the program
      */
    public static void main(String[] args) {
        /**
         * Prints the welcome message.
         */
        System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+");
        System.out.println("Hi! Welcome to Parti Québécois Voter Management System");
        System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+");
        /**
         *Prompts a message for max number of voters
         */
        System.out.println("\nPlease Enter the maximum number of voters in your neighbourhood.");
        /**
         * Integer.parseInt is used to convert String to int.
         * @variable maxVoters is the maximum number of voters in a neighbourhood.
         */
        int maxVoters = Integer.parseInt(sc.nextLine());
        /**
         * Create a voter object array with size of maxVoters
         */
        Voter[] voterBase = new Voter[maxVoters];
        /**
         * @variable totalCount is counter of max number of incorrect attempts
         * allowed
         */
        int index = 0;
        final String password = "password";
        int totalCount = 0;
        /**
         * The while loop keeps the main menu running until the program is
         * terminated due to a condition or is terminated by the user using
         * the fifth option in main menu.
         * @param doNotExit==true is set for continued loop.
         */
        boolean doNotExit = true;
        while (doNotExit) {

            /**
             * Switch statement for running the code for the specific option
             */
            switch (mainMenu()) {
                case 1: {
                    /**
                     * count is the counter of retries allowed inside option1
                     */
                    int countOption1 = 0;
                    /**
                     * The while loop checks if the retries is less than 3
                     */
                    while (countOption1 < 3) {
                        System.out.println("Please enter your password.");
                        String inputPassword = sc.nextLine();
                        /**
                         * If the password entered by the user is correct
                         * proceed for the voter creation.
                         */
                        if (inputPassword.equals(password)) {
                            System.out.println("Please enter the number of voters you want to add: ");
                            int voterEntered = Integer.parseInt(sc.nextLine());
                            /**
                             * Check if the voters to be added is available in array.
                             */
                            if ((voterBase.length - index) >= voterEntered) {
                                /**
                                 * Takes the input of the voter details in a loop
                                 * for number of voters to be added
                                 */
                                System.out.println("Please Enter the voter details below:");
                                for (int i = 0; i < voterEntered; i++) {
                                    System.out.println("Enter Voter ID:");
                                    long voterID = Long.parseLong(sc.nextLine());
                                    System.out.println("Enter Voter Name:");
                                    String voterName = sc.nextLine();
                                    System.out.println("Enter Voter Age:");
                                    Byte voterAge = Byte.parseByte(sc.nextLine());
                                    System.out.println("Enter Voter Email:");
                                    String voterEmail = sc.nextLine();
                                    System.out.println("Enter Voter Pcode:");
                                    char[] voterPcode = sc.nextLine().toCharArray();

                                    /**
                                     * Create a Voter class object and stores it in VoterBase
                                     * Array.
                                     */
                                    Voter voter = new Voter(voterID, voterName, voterAge, voterEmail, voterPcode);
                                    voterBase[index] = voter;
                                    /**
                                     * Give an output that voter is created successfully
                                     * and increase the current voter index.
                                     */
                                    System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+");
                                    System.out.println("Voter added successfully.");
                                    System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+");
                                    /**
                                     * Increase the index of the voterBase array.
                                     */
                                    index++;
                                }
                                break;

                            } else {
                                /**
                                 * print available voters to be added.
                                 */
                                System.out.println("You can add only " + (voterBase.length - index) + " voters");
                                totalCount=0;
                                break;
                            }
                        } else {
                            /**
                             * counters to check password errors
                             */
                            countOption1++;
                            totalCount++;
                        }
                        /**
                         * if total wrong password entries exceed 12 , program is closed
                         */
                        if (totalCount == 12) {
                            System.out.println("Program detected suspicious activities and will terminate immediately!");
                            System.exit(1);
                        }
                    }
                    break;
                }
                case 2: {
                    /**
                     * count is the counter of retries allowed inside option1
                     */
                    int countOption2 = 0;
                    /**
                     * The while loop checks if the retries is less than 3
                     * Also a label is added to exit this loop if required.
                     */
                    firstWhileLoop:
                    while (countOption2 < 3) {
                        System.out.println("Please enter your password.");
                        String inputPassword = sc.nextLine();
                        /**
                         * If the password entered by the user is correct
                         * proceed for the voter details display.
                         */
                        if (inputPassword.equals(password)) {
                            boolean voterDisplay = true;
                            /**
                             * This while loop is for maintaining the display of main menu unless
                             * exit is selected
                             */
                            while (voterDisplay) {
                                System.out.println("Please enter the voterID of the voter you want to update:");
                                /**
                                 * voterID is fetched from console and voter object and index is extracted.
                                 */
                                long voterID = Long.parseLong(sc.nextLine());
                                Voter voterCheck = findVoterByID(voterID, voterBase);
                                int voterIndex = findVoterIndex(voterID, voterBase);
                                /**
                                 * if the voterID is matched in voterBase it will display the voter details
                                 * and display the update menu
                                 */
                                if (voterCheck != null) {
                                    displayVoter(voterCheck, voterIndex);
                                    boolean exitUpdateMenu = false;
                                    while(!exitUpdateMenu) {
                                        /**
                                         * switch case for different cases of update menu
                                         */
                                        switch (updateMenu()) {
                                            case 1:
                                                /**
                                                 * Case for changing the name and re-display
                                                 * of Voter details
                                                 */
                                                System.out.println("Please enter new name:");
                                                voterCheck.setVoterName(sc.nextLine());
                                                displayVoter(voterCheck, voterIndex);
                                                break;
                                            case 2:
                                                /**
                                                 * Case for changing the Age and re-display
                                                 * of Voter details
                                                 */
                                                System.out.println("Please enter new Age:");
                                                voterCheck.setVoterAge(Byte.parseByte(sc.nextLine()));
                                                displayVoter(voterCheck, voterIndex);
                                                break;
                                            case 3:
                                                /**
                                                 * Case for changing the Email and re-display
                                                 * of Voter details
                                                 */
                                                System.out.println("Please enter new Email:");
                                                voterCheck.setVoterEmail(sc.nextLine());
                                                displayVoter(voterCheck, voterIndex);
                                                break;
                                            case 4:
                                                /**
                                                 * Case for changing the Pcode and re-display
                                                 * of Voter details
                                                 */
                                                System.out.println("Please enter new Pcode:");
                                                voterCheck.setVoterPcode(sc.nextLine().toCharArray());
                                                displayVoter(voterCheck, voterIndex);
                                                break;
                                            case 5:
                                                /**
                                                 * Case for returning to main menu using break to
                                                 * firstWhileLoop
                                                 */
                                                System.out.println("Returning to Main Menu");
                                                System.out.println();
                                                break firstWhileLoop;
                                        }
                                    }
                                }
                                else {
                                    /**
                                     * keep asking for voter id unless correct voter id entered.
                                     */
                                    boolean noVoterID = true;
                                    while(noVoterID){
                                        System.out.println("No Voter Found. Please enter yes to re-enter voterID or enter no to exit.");
                                        String choice = sc.nextLine();
                                        /**
                                         * if yes is entered loop will exit and run the parent loop
                                         */
                                        if (choice.equals("yes")) {
                                            noVoterID = false;
                                        }
                                        /**
                                         * if no is entered , it will break to the firstWhileLoop label.
                                         */
                                        else if (choice.equals("no")) {
                                            break firstWhileLoop;
                                        }
                                    }
                                }
                            }
                        }
                        /**
                         * else condition to increase the count if password is wrong.
                         */
                        else
                            countOption2++;
                    }
                    break;
                }
                case 3: {
                    /**
                     * Asks the user for Pcode and displays voter as required.
                     */
                    System.out.println("Please enter the voter Pcode");
                    findVoterBy(sc.nextLine(),voterBase);
                    break;
                }
                case 4: {
                    /**
                     *  An input is asked for an age and then displays all voters
                     *  below that age
                     */
                    System.out.println("Please enter the age.");
                    findYoungerThan(Byte.parseByte(sc.nextLine()),voterBase);
                    break;
                }
                case 5: {
                    /**
                     * Exits while loop and ends the driver program.
                     */
                    System.out.println("Thank you for using the Voter Management System");
                    System.out.println("System will now exit.");
                    doNotExit = false;
                }
            }
        }
    }
}