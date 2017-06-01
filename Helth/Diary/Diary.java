package Diary;

import java.io.*;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Files;

public class Diary{
    
    private String fileName;
    
    public Diary(String username) throws IOException{
        this.fileName = "diary" + username + ".txt";
        FileWriter diary = new FileWriter(fileName,true);
        BufferedWriter bw = new BufferedWriter(diary);
    }
    
    public void setEntry(String food) throws IOException{
        FileWriter diary = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(diary);
        bw.newLine();
        bw.write(food);
        bw.close();
    }
    
    public String getEntry() throws IOException{
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        String read = "";
        for (int i = 0; i < lines.size(); i++) {
            read += lines.get(i) + "\n";
        }
        return read;
    }
    
    public void clearDiary() throws IOException{
        FileWriter diary = new FileWriter(fileName);
    }
}
