package project2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SplittableRandom;

public class FileCreate{
    String email;
    String password;
    String name;
    String gender;

    public void createFolder(){

    }

    public static ArrayList<String> readFile(String file_name) throws IOException {
        BufferedReader reader_file = new BufferedReader(new FileReader(file_name + ".txt"));
        String line;
        ArrayList<String> users = new ArrayList<>();
        while ((line = reader_file.readLine()) != null){
            users.add(line);
        }
        return users;
    }
    public static void addData(String name, String password, String email, String file_name){
        try {
            ArrayList<String> users = readFile(file_name);
            users.add(name);
            users.add(password);
            users.add(email);
            FileWriter file_writer = new FileWriter(file_name + ".txt");
            for (int i = 0; i < users.size(); i++){
                file_writer.write(users.get(i) + "\n");
            }
            file_writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
