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
			FastTimer timer = new FastTimer();
		
		
			GameGrid loaded_grid = new GameGrid(7,7);
				boolean isSuccess =  loaded_grid.LoadFromFile("test.puzzle");
			if(isSuccess == true){
				System.out.print("Solution initiale");
				loaded_grid.PrintToCmd();			
			}
			List<GameMove> found_moves = loaded_grid.GetAvailableMove(); 
			
			
			System.out.println("\n\nInitial possible moves\n");
			for(GameMove current_move :found_moves){
				current_move.PrintOutCmd();
			}
			
			
			
			List<GameMove> solution_move  = new LinkedList();
			loaded_grid.ResetMonitoring();
			
			timer.StartTime();
				boolean result = loaded_grid.FindSolution(solution_move);
			timer.StopTime();
			
			System.out.println("\n**************************\n");
			if(result == false){
				System.out.println("Pas de solution");
			}
			else{
				System.out.println("Solution in " +solution_move.size() +" moves");
			}
			System.out.println("	Time : "+timer.LastDelta + " millsec");
			System.out.println("	Node visited :"+loaded_grid.node_visited_cpt);
			System.out.println("	Dept require :"+loaded_grid.max_dept);
			System.out.println("	Dept limitation :"+loaded_grid.dept_limit);
			
			if(solution_move.size() > 0){
				System.out.println("\nMove from last to first\n");
				for(GameMove current_move :solution_move){
					current_move.PrintOutCmd();
				}
				System.out.println("\n**************************\n");
			}
			
			
			System.out.print("\nFinal grid");
			loaded_grid.PrintToCmd();
    }
}
