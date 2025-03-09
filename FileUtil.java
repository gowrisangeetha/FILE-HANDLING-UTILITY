import java.io.*;
import java.nio.file.*;
import java.util.List;

/**
 * FileUtil class provides utility methods for handling file operations.
 * This includes creating, reading, writing, renaming, copying, and deleting files.
 */
public class FileUtil {

    /**
     * Creates a new file at the specified file path.
     * @param filePath The path of the file to be created.
     * @return true if the file is successfully created, false otherwise.
     */
    public static boolean createFile(String filePath) {
        File file = new File(filePath);
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Deletes the file at the specified file path.
     * @param filePath The path of the file to be deleted.
     * @return true if the file is successfully deleted, false otherwise.
     */
    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.delete();
    }

    /**
     * Writes text to a file.
     * @param filePath The file path where content should be written.
     * @param content The content to write.
     * @param append If true, appends content to the file; if false, overwrites.
     */
    public static void writeFile(String filePath, String content, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads and returns the entire content of a file as a string.
     * @param filePath The file path to read from.
     * @return The file content as a string.
     */
    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    /**
     * Reads all lines from a file and returns them as a list of strings.
     * @param filePath The file path to read from.
     * @return A list of lines from the file.
     */
    public static List<String> readAllLines(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Renames a file from oldFilePath to newFilePath.
     * @param oldFilePath The current file path.
     * @param newFilePath The new file path.
     * @return true if the renaming is successful, false otherwise.
     */
    public static boolean renameFile(String oldFilePath, String newFilePath) {
        File oldFile = new File(oldFilePath);
        File newFile = new File(newFilePath);
        return oldFile.renameTo(newFile);
    }

    /**
     * Copies a file from sourceFilePath to destinationFilePath.
     * @param sourceFilePath The source file path.
     * @param destinationFilePath The destination file path.
     * @return true if the copy is successful, false otherwise.
     */
    public static boolean copyFile(String sourceFilePath, String destinationFilePath) {
        try {
            Files.copy(Paths.get(sourceFilePath), Paths.get(destinationFilePath), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Main method demonstrating various file operations.
     */
    public static void main(String[] args) {
        String filePath = "example.txt";
        String newFilePath = "renamed_example.txt";
        String copyFilePath = "copy_example.txt";
        String content = "Hello, File Handling!";
        String moreContent = "\nAppending more content.";

        // Create file
        if (createFile(filePath)) {
            System.out.println("File created: " + filePath);
        } else {
            System.out.println("File already exists or failed to create: " + filePath);
        }

        // Write to file
        writeFile(filePath, content, false);
        System.out.println("Written to file: " + filePath);

        // Append to file
        writeFile(filePath, moreContent, true);
        System.out.println("Appended to file: " + filePath);

        // Read file
        System.out.println("File content:\n" + readFile(filePath));

        // Read all lines
        System.out.println("File content (line by line):");
        List<String> lines = readAllLines(filePath);
        if (lines != null) {
            lines.forEach(System.out::println);
        }

        // Rename file
        if (renameFile(filePath, newFilePath)) {
            System.out.println("File renamed to: " + newFilePath);
        } else {
            System.out.println("Failed to rename file.");
        }

        // Copy file
        if (copyFile(newFilePath, copyFilePath)) {
            System.out.println("File copied to: " + copyFilePath);
        } else {
            System.out.println("Failed to copy file.");
        }

        // Delete files
        if (deleteFile(newFilePath)) {
            System.out.println("File deleted: " + newFilePath);
        } else {
            System.out.println("Failed to delete file: " + newFilePath);
        }

        if (deleteFile(copyFilePath)) {
            System.out.println("File deleted: " + copyFilePath);
        } else {
            System.out.println("Failed to delete file: " + copyFilePath);
        }
    }
}
