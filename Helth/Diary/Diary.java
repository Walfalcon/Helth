import java.util.ArrayList;

public class Diary{
    
    private ArrayList<String> diary;
    
    public Diary(){
        this.diary = new ArrayList<String>();
    }
    
    public void setEntry(String food){
        diary.add(food);
    }
    
    public String getEntry(int entry){
        return diary.get(entry);
    }
}
