import java.util.List;

public interface FileReaderStrategy{

    List<String[]>  readFile(String filePath);
    void writeFile(List<String[]> output, String filePath);
}
