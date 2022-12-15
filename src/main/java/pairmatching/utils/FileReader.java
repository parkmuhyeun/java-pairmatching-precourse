package pairmatching.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public List<String> read(String file) {
        List<String> crews = new ArrayList<>();
        String path = "./src/main/resources/";
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(new File(path + file)));
            String name;
            while ((name = br.readLine()) != null) {
                crews.add(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return crews;
    }
}
