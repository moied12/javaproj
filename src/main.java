import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class main {

   public static void main (String[] args){

       System.out.println("hello world");
       readFile();
   }
    private static List<String> readFile()
    {
        try {
            List<File> filesInFolder = Files.walk(Paths.get("C:\\Users\\moied\\Desktop\\4th year\\Project\\javaproj\\45"))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(Path.of("output.clones"), charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return null;
    }

}
