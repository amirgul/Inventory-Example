import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileInputStream;

public class Main
{

    public static void main(String[] args)
    {
        String fileName = "Transactions.txt";
        try
        {
            Scanner inputStream = new Scanner(new File(fileName));
            String line = inputStream.nextLine();
            double total = 0;
            while (inputStream.hasNextLine())
            {
                line = inputStream.nextLine();
                String[] ary = line.split(",");
                String SKU = ary[0];
                int quantity = Integer.parseInt(ary[1]);
                double price = Double.parseDouble(ary[2]);
                String description = ary[3];
                System.out.printf("sold %d of %s (SKU: %s) at "+"S%1.2f each. \n", quantity, description, SKU, price);
                total += quantity* price;
            }
            System.out.printf("Total sales: $%1.2f\n", total);
            inputStream.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Can not find file " + fileName);
        }
        catch (IOException e)
        {
            System.out.println("Problem form input from file: " + fileName);
        }

        
    }
}
