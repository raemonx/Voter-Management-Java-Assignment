package Assignment1;

//............................................................
// Assignment 1
// ©Himangshu Shekhar Baruah
// Written by: Himangshu Shekhar BARUAH, Student ID 40229774
//............................................................

/**
 * --------------------- Program Description -----------------
 * This program basically contains a Voter class with various
 * attributes with getters/setters as required. It also conta-
 * ins a constructor for default values. There is one method
 * to find no of voters and also print all information of a
 * particular voter. It also compares two voters for equality.
 */

/**
 * import the needed java library classes
 */

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Voter {

    /**
     * The attributes of the Voter class are selected as private.
     */
    private long voterID;
    private String voterName;
    private byte voterAge;
    private String voterEmail;
    private char[] voterPcode;

    /**
     * @attribute votersCreated is the count of number of objects created.
     */
    private static int votersCreated=0;

    /**
     * Below are the getters and setters for the variables
     * voterName, voterAge, voterEmail, voterPcode
     * Only getter is used for voterID
     */
    public long getVoterID() {
        return voterID;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    public byte getVoterAge() {
        return voterAge;
    }

    public void setVoterAge(byte voterAge) {
        this.voterAge = voterAge;
    }

    public String getVoterEmail() {
        return voterEmail;
    }

    public void setVoterEmail(String voterEmail) {
        this.voterEmail = voterEmail;
    }

    public char[] getVoterPcode() {
        return voterPcode;
    }

    public void setVoterPcode(char[] voterPcode) {
        this.voterPcode = voterPcode;
    }

    /**
     * This is the default constructor when an object of class
     * Voter is called. Default values of the variables have
     * been hardcoded.
     */
    public Voter() {
        voterID = 00000;
        voterName = "Default";
        voterAge = 0;
        voterEmail = "default@abc.com";
        voterPcode[0]= '-';

        /**
         * Increment voter count when object is instanced.
         */
        votersCreated++;
    }

    /**
     * This is the parameterized constructor to set the values of the
     * attributes of the Voter class.
     * @param voterID This refers to the voterID
     * @param voterName This refers to the name of the voter
     * @param voterAge This refers to the age of the voter
     * @param voterEmail This refers to the Email of the voter
     * @param voterPcode This refers to the Pcode of the voter
     */
    public Voter(long voterID, String voterName, byte voterAge, String voterEmail, char[] voterPcode) {
        this.voterID = voterID;
        this.voterName = voterName;
        this.voterAge = voterAge;
        this.voterEmail = voterEmail;
        this.voterPcode = voterPcode;
        /**
         * Increment voter count when object is instanced.
         */
        votersCreated++;
    }

    /**
     * The method toString() has been overridden to return the values
     * of the Voter object when required
     * @return Returns the Voter information.
     */
    @Override
    public String toString() {
        return "ID: " + voterID +
                "\nName: " + voterName  +
                "\nAge: " + voterAge +
                "\nEmail: " + voterEmail +
                "\nPcode: " + String.valueOf(voterPcode)
                ;
    }

    /**
     * Method to find the number of voters created when object is
     * instanced.
     * @return Returns the count of voter object instanced.
     */
    public int findNumberofCreatedVoters(){
        if(votersCreated==0){
            return 0;
        }
        return votersCreated;
    }

    /**
     * The method equals has been overridden so that we can compare
     * the voterID and voterPcode to confirm if the instances of the
     * voter class object are equal.
     * @param obj The obj is an instance of Voter class
     * @return This returns a boolean value to return if the instance
     * is equal to another instance of the voter class.
     */
    public boolean equals(@NotNull Object obj) {
        /**
         * If the equals method is comparing to itself
         * @return true
         */
        if(obj == this){
            return true;
        }
        /**
         * if the parameter obj is not an instance of class Voter
         * @return false
         */
        else if (obj instanceof Voter == false) {
            return false;
        }
        /**
         * Casting the obj to a voter class object and comparing the
         * voterID and voterPcode to verify the equality.
         */
        Voter v = (Voter) obj;
        if(this.voterID == v.voterID && this.voterPcode == v.voterPcode)
            return true;

        return false;
    }
}
