package elvinos.java.ExerciseThree;

import java.util.Calendar;

public class CreditCard {

    int expiryMonth;
    int expiryYear;
    String firstName;
    String lastName;
    String ccNumber;

    public CreditCard(int expiryMonth, int expiryYear,
                      String firstName, String lastName, String ccNumber) {
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ccNumber = ccNumber;
    }



    public String formatExpiryDate(){
        String yearString = String.valueOf(expiryYear);
        char[] digits1 = yearString.toCharArray();
        String formatDate = String.valueOf(expiryMonth) + "/" + String.valueOf(digits1[2]) + String.valueOf(digits1[3]);
        return formatDate;
    }

    public String formatFullName() {
        String fullName = firstName + " " + lastName;
        return fullName;
    }

    public String formatCCNumber() {
        String[] ccNumberNoSpaces = ccNumber.split("");
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < ccNumberNoSpaces.length; i++) {
            strBuilder.append(ccNumberNoSpaces[i]);
            if((i+1) % 4 == 0 && i != 0){
               strBuilder.append(" ");
            }
        }
        String ccNumber = strBuilder.toString();
        return ccNumber;
    }

    public Boolean isValid(){
        Calendar now = Calendar.getInstance();
        int CurYear = now.get(Calendar.YEAR);
        int CurMonth = now.get(Calendar.MONTH);
        if (CurYear < expiryYear) {
            return true;
        }
        else if(CurYear == expiryYear && CurMonth <= expiryMonth ){
            return true;
        }
        else {
            return false;
        }
    }

    public String toString(){
        String output = "Number: " +
                formatCCNumber() +
                "\nExpiry date: " +
                formatExpiryDate() +
                "\nAccount holder: " +
                formatFullName() +
                "\nIs valid: " +
                isValid();
        return output;
    }



}
