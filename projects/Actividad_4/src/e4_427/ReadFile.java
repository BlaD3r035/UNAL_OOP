package e4_427;
import java.io.*;

public class ReadFile {
    private String filePath;

    public ReadFile(String filePath) {
        this.filePath = filePath;
    }

    public String read() throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        InputStreamReader converter = new InputStreamReader(file);
        BufferedReader reader = new BufferedReader(converter);

        StringBuilder content = new StringBuilder();
        String line = reader.readLine();

        while (line != null) {
            content.append(line).append("\n");
            line = reader.readLine();
        }

        reader.close();
        return content.toString();
    }
}