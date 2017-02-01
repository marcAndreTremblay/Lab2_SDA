package core;
import java.io.*;
import java.util.*;

public class Main
{
	//List des solution
	//List des nobmres de noeud parcourur
	//Temps d'execution (apres loading, non affichage)
	//Afficher la solution finale
    
	
	
	
	public static void main(String[] args)
    {		
		
			GameGrid loaded_grid = new GameGrid(7,7);
				boolean isSuccess =  loaded_grid.LoadFromFile("test.puzzle");
			if(isSuccess == true){
				System.out.print("Solution initiale");
				loaded_grid.PrintToCmd();			
			}
			List<GameMove> found_moves = loaded_grid.GetAvailableMove(); 
			
			
			System.out.println('\n');
			for(GameMove current_move :found_moves){
				current_move.PrintOutCmd();
			}
			
			
			
			List<GameMove> solution_move  = new LinkedList();
			boolean result = loaded_grid.FindSolution(solution_move);
			if(result == false){
				System.out.println("\nPas de solution");
			}
			else{
				System.out.println("\nSolution");
				System.out.println("Last\n");
				for(GameMove current_move :solution_move){
					current_move.PrintOutCmd();
				}
				System.out.println("\nFirst\n");
			}
			
			System.out.print("\nFinal grid");
			loaded_grid.PrintToCmd();
    }
}
