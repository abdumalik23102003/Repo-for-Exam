package streams;

import java.io.*;
import java.util.logging.Logger;

//todo - in this class create two methods that can handle file copying
// 1.first method must include src file and from it your method will have to
// create another duplicate file. Then name of duplicate file should be like
// notes.txt => notes(1).txt
// 2.second method must include as an input two parameters , scr file and
// destination file. This method will reads from src file and writes to
// destination file.
// 3.For the class involve logger to log method operation details.
// When your methods throws an exception log error message to the console
// When copy file successfully finishes log info about it.
public class Streams {
    private static final Logger logger = Logger.getLogger(Streams.class.getName());

    // method 1: Copy a file and rename it
    public static void copyFileAndRename(String srcFilePath) {
            File srcFile = new File(srcFilePath);

            if (!srcFile.exists()) {
                logger.severe("Source file does not exist: " + srcFilePath);
                return;
            }

            String parentDir = srcFile.getParent();
            // path name oladi
            String fileName = srcFile.getName();
            // file name oladi
            String extension = "";
            int dotIndex = fileName.lastIndexOf('.');
            if (dotIndex > 0) {
                extension = fileName.substring(dotIndex);
                fileName = fileName.substring(0, dotIndex);
            }

            File destFile = new File(parentDir, fileName + "(1)" + extension);

            try (InputStream inStream = new FileInputStream(srcFile);
                 OutputStream outStream = new FileOutputStream(destFile)) {

                int i;
                while((i=inStream.read())!=-1){
                    System.out.print((char)i);
                    outStream.write((char) i);
                }

                logger.info("File copied successfully: " + srcFilePath + " to " + destFile.getAbsolutePath());
            } catch (IOException e) {
                logger.severe("Error copying file: " + e.getMessage());
            }
    }

    // method 2: Copy a file to a destination file
    public static void copyFile(String srcFilePath, String newtFilePath) {
            File srcFile = new File(srcFilePath);
            File newtFile = new File(newtFilePath);

            if (!srcFile.exists()) {
                logger.severe("Source file does not exist: " + srcFilePath);
                return;
            }

            try (InputStream inStream = new FileInputStream(srcFile);
                 OutputStream outStream = new FileOutputStream(newtFile)) {

                int i;
                while((i=inStream.read())!=-1){
                    System.out.print((char)i);
                    outStream.write((char) i);
                }

                logger.info("File copied successfully: " + srcFilePath + " to " + newtFilePath);
            } catch (IOException e) {
                logger.severe("Error copying file: " + e.getMessage());
            }
    }
}