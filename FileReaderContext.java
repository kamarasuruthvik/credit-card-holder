import java.util.List;

public class FileReaderContext {
    private FileReaderStrategy fileReaderStrategy;
    private String InputFileName, OutputFileName;

    public FileReaderContext(FileReaderStrategy fileReaderStrategy, String InputFileName, String OutputFileName) {
        this.fileReaderStrategy = fileReaderStrategy;
        this.InputFileName = InputFileName;
        this.OutputFileName = OutputFileName;
    }

    public void setFileReaderStrategy(FileReaderStrategy fileReaderStrategy, String InputFileName, String OutputFileName) {
        this.fileReaderStrategy = fileReaderStrategy;
        this.InputFileName = InputFileName;
        this.OutputFileName = OutputFileName;
    }

    public List<String[]> readFile(String fileName) {
        return fileReaderStrategy.readFile(fileName);
    }

    public void writeFile(List<String[]> output, String FileName){
        fileReaderStrategy.writeFile(output, FileName);
    }
}
