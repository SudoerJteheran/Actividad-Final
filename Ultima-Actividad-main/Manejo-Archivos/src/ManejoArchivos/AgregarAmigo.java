/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoArchivos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author SudoerJteheran
 */
public class AgregarAmigo {
    public static String addFriend(String newName, long newNumber) {
        try {
            String nameNumberString;
            String name;
            long number;
            String Return;

            // Using file pointer creating the file.
            File file = new File("contactosAmigos.txt");

            if (!file.exists()) {

                // Create a new file if not exists.
                file.createNewFile();
            }

            // Opening file in reading and write mode.

            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;

            // Checking whether the name
            // of contact already exists.
            // getFilePointer() give the current offset
            // value from start of the file.
            while (raf.getFilePointer() < raf.length()) {

                // reading line from the file.
                nameNumberString = raf.readLine();

                // splitting the string to get name and
                // number
                String[] lineSplit = nameNumberString.split("!");

                // separating name and number.
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);

                // if condition to find existence of record.
                if ((name.equals(newName))
                        || number == newNumber) {
                    found = true;
                    break;
                }
            }

            if (found == false) {

                // Enter the if block when a record
                // is not already present in the file.
                nameNumberString = newName + "!"
                        + String.valueOf(newNumber);

                // writeBytes function to write a string
                // as a sequence of bytes.
                raf.writeBytes(nameNumberString);

                // To insert the next record in new line.
                raf.writeBytes(System.lineSeparator());

                // Print the message
                Return = " Amigo añadido!. ";

                // Closing the resources.
                raf.close();
            }
            // The contact to be updated
            // could not be found
            else {

                // Closing the resources.
                raf.close();

                // Print the message
                Return = " El nombre o numero ya existe ";
            }
            return Return;
        } catch (IOException ioe) {
            return " Error: " + ioe.getMessage();
        }

    }
}