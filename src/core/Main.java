package core;
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
	

	
	public static void main(String[] args)
    {		
		
			GameGrid loaded_grid = new GameGrid(7,7);
				boolean isSuccess =  loaded_grid.LoadFromFile("test.puzzle".toCharArray());
			if(isSuccess == true){
				System.out.print("Solution initiale");
				loaded_grid.PrintToCmd();			
			}
			
			//Find the first possible moves
			List<GameMove> found_moves = loaded_grid.GetAvailableMove(); 
			
			//For each of those move check if there is a solution to the puzzle
				//Back tracking algo here
				//
			
			System.out.println('\n');
			for(GameMove current_move :found_moves){
				current_move.PrintOutCmd();
			}
    }
}
