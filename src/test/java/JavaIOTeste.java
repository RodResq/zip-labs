import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaIOTeste {

    private final String FILE_NAME = "src/test/resources/fileToCreate.txt";

    @AfterEach
    @BeforeEach
    public void cleanUpFiles() {
        File targetFile = new File(FILE_NAME);
        targetFile.delete();
    }

    @Test
    public void testCresateFile() throws IOException {
        Path newFilePath = Paths.get(FILE_NAME);
        Files.createFile(newFilePath);
    }
}
