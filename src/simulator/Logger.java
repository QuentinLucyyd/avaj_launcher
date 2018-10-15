package simulator;

import java.io.*;

public class Logger {
    private static File _File = null;
    private static FileWriter _Writer = null;
    private static BufferedWriter _BufferedWriter = null;

    public Logger() {
        try {
            _File = new File("simulation.txt");
            _Writer = new FileWriter(_File);
            _BufferedWriter = new BufferedWriter(_Writer);
        } catch (IOException e) {
            System.out.println("Error while creating file or Instantiating Filewriter or Bufferedwriter");
        }
    }
    public static void writeToFile(String str) {
        try {
            _BufferedWriter.write(str);
            _BufferedWriter.newLine();
        }
        catch (IOException e) {
            System.out.println("Error while writing to File");
        }
    }

    public static void closeFile()  {
        try {
            if (_BufferedWriter != null)
                _BufferedWriter.close();
        }
        catch (IOException e) {
            System.out.println("Error while closing the file");
        }
    }
}
