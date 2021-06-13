/*
 *  UCF COP3330 Summer 2021 Assignment 27 Solution
 *  Copyright 2021 Brandon Barbour
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter the first name: ");
        Scanner input = new Scanner(System.in);
        String first = input.next();
        System.out.print("Enter the last name: ");
        String last = input.next();
        System.out.print("Enter the ZIP code: ");
        String zip = input.next();
        System.out.print("Enter the employee ID: ");
        String id = input.next();
        validateInput(first, last, zip, id);

    }

    public static void validateInput(String first, String last, String zip, String id) {
        int check = 0;
        String strfirst = "";
        String strlast = "";
        String strzip = "";
        String strid = "";

        switch (validateFirst(first)) {
            case 2:
                check++;
                break;
            case 1:
                strfirst = "The first name must be at least 2 characters long.\n";
                break;
            case 0:
                strfirst = "The first name must be filled in.\n";
                break;
        }
        switch (validateLast(last)) {
            case 2:
                check++;
                break;
            case 1:
                strlast = "The last name must be at least 2 characters long.\n";
                break;
            case 0:
                strlast = "The last name must be filled in.\n";
                break;
        }
        switch (validateZip(zip)) {
            case 2:
                check++;
                break;
            case 1:
                strzip = "The zipcode must be a 5 digit number.\n";
                break;
            case 0:
                strzip = "The zipcode must be filled in.\n";
                break;
        }
        switch (validateID(id)) {
            case 2:
                check++;
                break;
            case 1:
                strid = "The employee ID must be in the format of AA-1234.";
                break;
            case 0:
                strid = "The employee ID must be filled in.";
                break;
        }

        String out = strfirst + strlast + strzip + strid;
        if (check == 4) {
            out = "There were no errors found.";
        }
        System.out.printf("%s", out);
    }


    public static int validateFirst(String first) {
        if (first.length() >= 2) {
            return 2;
        }
        else if (first.length() > 0) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static int validateLast(String last) {
        if (last.length() >= 2) {
            return 2;
        }
        else if (last.length() > 0) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static int validateZip(String zip) {
        char[] ziparray = zip.toCharArray();
        if (zip.length() == 5) {
            int zipcount = 0;
            for (int i = 0; i <= zip.length() - 1; i++) {
                if (Character.isDigit(ziparray[i])) {
                    zipcount++;
                }
            }
            if (zipcount == 5) {
                return 2;
            }
            else {
                return 1;
            }
        }
        else if (zip.length() == 0) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public static int validateID(String id) {
        char[] idarray = id.toCharArray();
        if (idarray.length == 7) {
            if ((Character.isLetter(idarray[0])) && (Character.isLetter(idarray[1]))) {
                if (idarray[2] == '-') {
                    int digitcount = 0;
                    for (int i = 3; i <= 6; i++) {
                        if (Character.isDigit(idarray[i])) {
                            digitcount++;
                        }
                    }
                    if (digitcount == 4) {
                        return 2;
                    }
                    else {
                        return 1;
                    }
                }
                else {
                    return 1;
                }
            }
            else {
                return 1;
            }
        }
        else if (id.length() == 0) {
            return 0;
        }
        else {
            return 1;
        }
    }
}

