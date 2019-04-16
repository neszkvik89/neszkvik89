import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyFile {
    public static void main(String[] args) {

        System.out.println(copyContent("src/my-file.txt", "src/my-text.txt"));

    }

    public static boolean copyContent(String fromFile, String toFile){
        boolean isCopied = false;
  try {
      Path copied = Paths.get(toFile);
      Path originalPath = Paths.get(fromFile);
      Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
      Files.readAllLines(originalPath)
              .equals(Files.readAllLines(copied));
      isCopied = true;
  } catch (IOException ioe) {
      System.out.println("IOException happened");
  }
  return isCopied;
    }
}
