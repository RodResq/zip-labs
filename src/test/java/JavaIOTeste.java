import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;


public class JavaIOTeste {

    private final String FILE_NAME = "src/test/resources/fileToCreate.txt";

    @AfterEach
    @BeforeEach
    public void cleanUpFiles() {
        File targetFile = new File(FILE_NAME);
        targetFile.delete();
    }

    @Test
    public void testCriandoFileComPath() throws IOException {
        Path newFilePath = Paths.get(FILE_NAME);
        Files.createFile(newFilePath);
    }

    @Test
    public void testCriandoFileComFile() throws IOException {
        File newFile = new File(FILE_NAME);
        boolean success = newFile.createNewFile();

        assertFalse(success);
    }

    @Test
    public void testCriandoFileComFileOutputStream() {
        try(FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCriandoArquivoComGuava() throws IOException {
        com.google.common.io.Files.touch(new File(FILE_NAME));
    }

    @Test
    public void testCriandoFileComApacheCommonsIO() throws IOException {
        FileUtils.touch(new File(FILE_NAME));
    }
}
