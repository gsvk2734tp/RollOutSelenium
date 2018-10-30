package RollOut.utils;

import java.io.FileOutputStream;
import java.io.IOException;

public class createCSVusers {
    private static String filePath = "C:\\123\\csvUsers.txt";
    private static String value;

    public static void main(String[] args) {
        try(FileOutputStream fos=new FileOutputStream(filePath))
        {
            for (int i = 1000; i < 6000; i++) {
                value = String.format("User%d,User%d@User%d,+00%d,User%d\n", i, i, i, i ,i);
                byte[] buffer = value.getBytes();
                fos.write(buffer, 0, buffer.length);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
