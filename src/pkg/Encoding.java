package pkg;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Encoding {

    private static ArrayList<ArrayList<Character>> inputCharacter;
    private static ArrayList<ArrayList<Integer>> asciiValue;
    private static ArrayList<ArrayList<Integer>> Token;
    private static ArrayList<ArrayList<Integer>> Binary;

    public Encoding(ArrayList<ArrayList<Character>> inputCharacter, ArrayList<ArrayList<Integer>> asciiValue, ArrayList<ArrayList<Integer>> token, ArrayList<ArrayList<Integer>> Binary){
        Encoding.inputCharacter = inputCharacter;
        Encoding.asciiValue = asciiValue;
        Encoding.Token = token;
        Encoding.Binary = Binary;
    }

    public static ArrayList<ArrayList<Character>> getInputCharacter() {
        return inputCharacter;
    }

    public static void  setInputCharacter(ArrayList<ArrayList<Character>> inputCharacter) {
        Encoding.inputCharacter = inputCharacter;
    }

    public static ArrayList<ArrayList<Integer>> getAsciiValue() {
        return asciiValue;
    }

    public static void setAsciiValue(ArrayList<ArrayList<Integer>> asciiValue) {
        Encoding.asciiValue = asciiValue;
    }

    public ArrayList<ArrayList<Integer>> getToken() {
        return Token;
    }

    public void setToken(ArrayList<ArrayList<Integer>> token) {
        Token = token;
    }

    public ArrayList<ArrayList<Integer>> getBinary() {
        return Binary;
    }

    public void setBinary(ArrayList<ArrayList<Integer>> binary) {
        Binary = binary;
    }

    public static ArrayList<ArrayList<Integer>> EncodingData(ArrayList<ArrayList<Character>> arrayList){
        setAsciiValue(AsciiConversion(arrayList));



        return getAsciiValue();
    }

    public static ArrayList<ArrayList<Integer>> BinaryConversion(ArrayList<ArrayList<Integer>> arrayList){
        ArrayList<ArrayList<Integer>> conArray = new ArrayList<>();
        for (ArrayList<Integer> s :arrayList) {
            ArrayList<Integer> tempArray= new ArrayList<>();
            for (int i :s) {
                tempArray.add(i);
            }
            conArray.add(tempArray);
        }
        return conArray;
    }

    public static ArrayList<ArrayList<Integer>> AsciiConversion(ArrayList<ArrayList<Character>> arrayList){
        ArrayList<ArrayList<Integer>> conArray = new ArrayList<>();
        for (ArrayList<Character> s :arrayList) {
            ArrayList<Integer> tempArray= new ArrayList<>();
            for (char c :s) {
                tempArray.add((int)c);
            }
            conArray.add(tempArray);
        }
        return conArray;
    }

    public static ArrayList<ArrayList<Character>> ImportEncodingData(File file) {


        ArrayList<Character> list = null;


        BufferedReader reader = null;

        ArrayList<ArrayList<Character>> conArray = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            conArray = new ArrayList<>();

            //Loops over each line of the file
            for (int i = 0; i < file.length(); i++) {
                line = reader.readLine();
                list = new ArrayList<>();
                if (line != null) {
                    for (int j = 0; j < line.length(); j++) {
                        list.add(line.charAt(j));
                    }
                    conArray.add(list);
                } else {
                    break;
                }
            }

            //Exception Handling
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file);
        } catch (IOException e) {
            System.out.println("Unable to read file: " + file);
        } catch (NullPointerException e) {
            System.out.println("Line length equals null: " + file);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Unable to close file: " + file);
            }
        }
        setInputCharacter(conArray);
        return getInputCharacter();
    }
}
