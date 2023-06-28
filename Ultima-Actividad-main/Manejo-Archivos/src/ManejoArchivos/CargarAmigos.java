/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoArchivos;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SudoerJteheran
 */
public class CargarAmigos {

    public static String[] displayFriends() {
        try {

            String nameNumberString;
            String name;
            long number;
            List<String> Lista = new ArrayList<String>();
            // Using file pointer creating the file.
            File file = new File("contactosAmigos.txt");

            if (!file.exists()) {

                // Create a new file if not exists.
                file.createNewFile();
            }

            // Opening file in reading and write mode.

            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;

            // Traversing the file
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

                // Print the contact data
                Lista.add(
                        name + ":" + number);
            }
            return Lista.toArray(new String[Lista.size()]);
        } catch (Exception e) {
            String[] error = { e.getMessage() };
            return error;

        }
    }
}