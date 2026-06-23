import java.io.File;
import java.io.IOException;

public class Directory {
    File directoryFile;
    public Directory(){
        directoryFile = new File("Directory.txt");
        createDirectoryFile();
    }
    public Directory(String fileName ){
        directoryFile = new File(fileName);
        createDirectoryFile();
    }
    public void createDirectoryFile(){
        if(!directoryFile.exists()){
            try{
                directoryFile.createNewFile();
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
