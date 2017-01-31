import java.io.*;
import java.util.*;

public class Main
{
	//List des solution
	//List des nobmres de noeud parcourur
	//Temps d'execution (apres loading, non affichage)
	//Afficher la solution finale
    
	public static void PrintGrid(int grid_size, int[] grid_data){
		System.out.print('\n');
		for(int i = 0; i < grid_size; i++){
			if(i%7 == 0){
				System.out.print('\n');
			}
			System.out.print(grid_data[i]);
			
		}
	}
	public static boolean ReadGridFile(int grid_size, int[] grid_data){
		boolean Status = true;
		int c;
		int current_index = 0;
		int item_loaded_cpt = 0;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("test.puzzle"));
	
			while ((c = br.read()) != -1) {
			    //Since c is an integer, cast it to a char. If it isn't -1, it will be in the correct range of char.
				
				if(c == 48){ //0	
					grid_data[current_index] = 0;
					current_index++;
				}
				if (c == 49){ //1
					grid_data[current_index] = 1;
					current_index++;
				}
				if (c == 50) {//2	
					grid_data[current_index] = 2;
					current_index++;
				}
				
			      
			}
			
			if(current_index != grid_size){
				System.out.print("Could't load all the grid data\n");
				Status = false;
			}
		} catch (FileNotFoundException e) {
			Status = false;
			e.printStackTrace();
			System.out.print(e.toString() +"\n");
		} catch (IOException e) {
			Status = false;
			e.printStackTrace();
			System.out.print(e.toString() +"\n");			
		}
		return Status;
	}
	
	
	public static void main(String[] args)
    {		
			int grid_size = 7*7;	
			int[] grid_data = new int[grid_size];
			
			boolean isSuccess =  ReadGridFile(grid_size,grid_data);
			if(isSuccess == true){
				PrintGrid(grid_size,grid_data);			
			}
	
    }
}
