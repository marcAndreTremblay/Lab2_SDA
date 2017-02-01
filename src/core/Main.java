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
				boolean isSuccess =  loaded_grid.LoadFromFile("test2.puzzle");
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
			loaded_grid.ResetMonitoring();
			timer.StartTime();
			boolean result = loaded_grid.FindSolution(solution_move);
			timer.StopTime();
			if(result == false){
				System.out.println("\nPas de solution");
				System.out.println("Time : "+timer.LastDelta + " millsec");
				System.out.println("Node visited :"+loaded_grid.node_visited_cpt);
				System.out.println("Dept require :"+loaded_grid.max_dept);
			}
			else{
				System.out.println("\nSolution");
				System.out.println("Time : "+timer.LastDelta + " millsec");
				System.out.println("Node visited :"+loaded_grid.node_visited_cpt);
				System.out.println("Dept require :"+loaded_grid.max_dept);
				System.out.println("\nLast to first\n");
				for(GameMove current_move :solution_move){
					current_move.PrintOutCmd();
				}
				System.out.println("\nFirst\n");
			}
			
			System.out.print("\nFinal grid");
			loaded_grid.PrintToCmd();
    }
}
