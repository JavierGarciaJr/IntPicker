import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FillerSort {

	public static String list = "data.txt";// sets up the text file to be read in the program
	/**
	 * main method of the class.
	 * calls FilterSort
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		FilterSort(list);// calls FilterSort
	}
	/**
	 *  this method counts the amount of lines in the program
	 * @param list
	 * @throws IOException
	 */
	public static void FilterSort(String list) throws IOException {
		int count = 0;//initializes the variable count
		Path read = Paths.get(list);//creates path to read text file
		Scanner jam = new Scanner(read);//Scanner reads the text file
		while (jam.hasNextLine()) {//while list has another line, loop continues

			String indiv = jam.nextLine();//goes on to next line

			count++;//counts the ammount of lines that have been through this loop
		}
		store(count);//calls store

	}
	/**
	 * gives an exact number of spots for the array and stores the lines in them
	 * @param count
	 * @throws IOException
	 */
	public static void store(int count) throws IOException {
		int add = 0;//initializes the variable add
		String[] firstA = new String[count];//array that will store each line of the file
		Path read = Paths.get(list);//creates path to read the text file
		Scanner jam = new Scanner(read);//Scanner reads the text file
		while (jam.hasNextLine()) {//while list has another line, loop continues

			String alone = jam.nextLine();//sets the line as a string

			firstA[add] = alone;//stores the string alone into the array

			add++;// increases add to store next line into the correct array spot when it loops again
		}

		gum(firstA, count);//calls gum

	}
	/**
	 * this method counts the individual amount of items that can be stored into a new array
	 * @param firstA
	 * @param count
	 */
	public static void gum(String[] firstA, int count) {
		int add = 0;//initializes add
		Random r = new Random();//creates a new random
		int ok = r.nextInt(count - 1);//makes count - 1 the highest point that the random can go to

		Scanner jam = new Scanner(firstA[ok]);//Scanner reads the line that is stored in a random spot of the array
		while (jam.hasNext()) {//while there is another item, the loop continues

			String indiv = jam.next();//sets each item as an individual string

			add++;//counts to get the correct number of spots in the array
		}

		finish(firstA, add, ok);//calls finish
	}
	/**
	 * final method of program that finds and focuses on the ints and displays them in order from least to greatest
	 * @param firstA
	 * @param add
	 * @param ok
	 */
	public static void finish(String[] firstA, int add, int ok) {
		int sum = 0;//initializes sum
		String strnum = "";//initializes strnum 
		int[] ice = new int[add];//creates new array that stores the ints as strings
		Scanner jam = new Scanner(firstA[ok]);//jam reads the line random line
		while (jam.hasNext()) {//loops while there is another item
			if (jam.hasNextInt(10)) {//if method returns a valid int value it goes through this if
				strnum = jam.next(); //stores the int in the string

				ice[sum] = Integer.parseInt(strnum);//puts strnum into the right spot in array ice

				sum++;//increase only in if so that Strings do not get stored into array
			} else {
				jam.next();// goes to the next  item
			}
		}
		jam.close();//closes scanner
		int[] real = new int[sum];//new scanner that stores the strings numbers as ints
		for (int i = 0; i <= sum - 1; i++) {//loops until i reaches array limit
			real[i] = ice[i];//copies ints over the array
		}
		Arrays.sort(real);//sorts the arrays ints
		if (sum == 0) {// if there arent any ints, it diplays this text
			System.out.print("There are not any int's on this line of your file");//display text if no ints in spot in array
		}
		for (int k = 0; k <= sum - 1; k++) {//loops through each int in array
			System.out.println(real[k]);//displays int in specific spot of the array
		}

	}

}
