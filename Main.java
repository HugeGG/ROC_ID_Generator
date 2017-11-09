import java.util.*;
import java.math.*;
import java.util.*;
import java.security.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main
{
	public static void main(String[] args)
	{
		String index = "", country = "";
		int sexual, total, y = 0;
		Random ran = new Random();
		Scanner in = new Scanner(System.in);
		System.out.println("Sexual: 1.Man 2.Woman");
		sexual = in.nextInt();
		System.out.println("Place: A ~ Z");
		country = in.next();
		country = country.toUpperCase();
        char place = country.charAt(0);
		System.out.println("Total:  ");
		total = in.nextInt();
		switch(place)
		{
			case 'A': 	y = 1;  break;	case 'G': y = 55;   break;  case 'M': y = 11;   break;	case 'S': y = 56;   break;	case 'Y': y = 12;   break;
			case 'B': 	y = 10; break;	case 'H': y = 64;	break;  case 'N': y = 20;	break;  case 'T': y = 65;	break;  case 'Z': y = 30;   break;
			case 'C':	y = 19; break;	case 'I': y = 39;	break;  case 'O': y = 48;	break;  case 'U': y = 74;   break;
			case 'D':	y = 28; break;	case 'J': y = 73;	break;  case 'P': y = 29;	break;  case 'V': y = 83;   break;
			case 'E': 	y = 37; break;	case 'K': y = 82;	break;  case 'Q': y = 38;	break;  case 'W': y = 21;   break;
			case 'F': 	y = 46; break;	case 'L': y = 2;	break;  case 'R': y = 47;	break;  case 'X': y = 3;    break;
		}
		String[] output = new String[total];
		for(int i = 0; i < total; i++)
		{
			output[i] = "";
		}
		
		for(int i = 0; i < total; i++)
		{
			int add = y;
			output[i] += place;
			add += sexual * 8;
			output[i] += sexual;
			for(int j = 7; j >= 1; j--)
			{
				int now = ran.nextInt(10);
				add += now * j;
				output[i] += now;
			}
			int check = 10 - (add % 10);
            if(check == 10)
                check = 0;
			output[i] += check;
			//System.out.println(output[i]);
		}

        String outputFile = "users.csv";
		
		// before we open the file check to see if it already exists
		boolean alreadyExists = new File(outputFile).exists();
			
		try {
			// use FileWriter constructor that specifies open for appending
			CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
			
			// if the file didn't already exist then we need to write out the header line
			if (!alreadyExists)
			{
				csvOutput.write("id");
				csvOutput.write("Key");
				csvOutput.endRecord();
			}
			// else assume that the file already has the correct header line
			
			// write out a few records
			for(int i = 1; i < total; i++)
			{
				String count = "" + i;
				csvOutput.write(count);
				csvOutput.write(output[i]);
				csvOutput.endRecord();
			}
			
			csvOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
	}
	}
}