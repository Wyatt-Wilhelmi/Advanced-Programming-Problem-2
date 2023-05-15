import pkg.Encoding;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static pkg.Encoding.*;
import static pkg.Decoding.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println(ImportEncodingData(new File("src/pkg/Homework_3_-_Encoding_Text.txt")));
        for (ArrayList<Integer> s : EncodingData(ImportEncodingData(new File("src/pkg/Homework_3_-_Encoding_Text.txt")))) {
            System.out.println(s);
//            for (Object c : s) {
//                System.out.println(c);
//            }
//            System.out.println();
        }

    }
}
