package project2;

import java.io.*;
import java.util.ArrayList;

public class FileCreate{
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
    public static void addData(String username, String password, String email, String file_name){
        try {
            ArrayList<String> users = readFile(file_name);
            users.add(username);
            users.add(password);
            users.add(email);
            FileOutputStream fileOutputStream = new FileOutputStream(file_name + ".txt");
            for (int i = 0; i < users.size(); i++){
                fileOutputStream.write((users.get(i) + "\n").getBytes());
            }
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void upData(String file_name, ArrayList<String> users) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file_name + ".txt");
        for (int i = 0; i < users.size(); i++){
            fileOutputStream.write((users.get(i) + "\n").getBytes());
        }
        fileOutputStream.close();
    }
    public boolean checkData(String username, String password){
        try {
            ArrayList<String> users = readFile("Users");
            for (int i = 0; i < users.size(); i += 3){
                if (username.contains(users.get(i)) && password.contains(users.get(i + 1))){
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static void resetPassword(String username, String password, String file_name) throws IOException{
        ArrayList<String> users = readFile("Users");
        for (int i = 0; i < users.size(); i += 3){
            if (username.contains(users.get(i))){
                users.set(i + 1, password);
                upData(file_name, users);
            }
        }
    }

    public int handlerError(String username, String password, String email){
        if (username.contains("")){
            return 0;
        }
        if (password.contains("")){
            return 1;
        }
        if (email.contains("")){
            return 2;
        }
        if (username.contains(password) || password.contains(username)){
            return 3;
        }
        return -1;
    }
}
