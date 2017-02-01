package core;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class GameGrid {
	
	public int [] grid_data;
	public int grid_size;
	int grid_x;
	int grid_y;
	GameGrid(int x,int y){
		grid_x = x;
		grid_y = y;
		grid_size = grid_x*grid_y;
	}
	public void PrintToCmd(){
		System.out.print('\n');
		for(int i = 0; i < grid_size; i++){
			if(i%grid_x == 0){
				System.out.print('\n');
			}
			System.out.print(grid_data[i]);
			
		}
	}
	public boolean LoadFromFile(String file_name){
		grid_data = new int[this.grid_size];
		boolean Status = true;
		
		int c;
		int current_index = 0;
		int item_loaded_cpt = 0;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file_name));
	 
			while ((c = br.read()) != -1) {
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
	public List<GameMove> GetAvailableMove(){
		List<GameMove> result = new LinkedList<GameMove>();		
		for(int i =0;i<this.grid_size;i++){
			if(grid_data[i] == 1){ //Check if its a 'Pion'
				//Check top side
				if(i-grid_x >= 0 &&  i-grid_x*2 >= 0){ //Check if top side is in play
					if(grid_data[i-grid_x] == 1 && grid_data[i-grid_x*2] == 2){ //Check if top is clear move
						result.add(new GameMove(i,i-grid_x,i-grid_x*2));
					}
				} 
				if(i+grid_x < grid_size &&  i+grid_x*2 < grid_size){ //Check if bottom side is in play
					if(grid_data[i+grid_x] == 1 && grid_data[i+grid_x*2] == 2){ //Check if bottom is clear move
						result.add(new GameMove(i,i+grid_x,i+grid_x*2));
					}
				}
				
					
					//Current row min and max
					int min  = (i - i %grid_x);
					int max = (min+grid_x-1);

				//Check left side
				if(i > min && i-1 > min && i-2 > min ){
					if(grid_data[i-1] == 1 && grid_data[i-2] == 2){ //Check if left is a clear move
							result.add(new GameMove(i,i-1,i-2));
					}
				}
				
				
				//Check right side
				if(i < max && i+1 < max && i+2 < max ){
					if(grid_data[i+1] == 1 && grid_data[i+2] == 2){ //Check if left is a clear move
						result.add(new GameMove(i,i+1,i+2));
					}
				}
			}
		}		
		return result;
	}
	
	//Data for algo analyse
	int max_dept;
	int node_visited_cpt;
	int dept_limit = 20;
	public void ResetMonitoring(){
		max_dept=0;
		node_visited_cpt=0;
		dept_limit = 20;
	}
	
	private int CountGridPin(){
		int cpt = 0;
		for(int i = 0;i<this.grid_size;i++){
			if(grid_data[i] == 1) {cpt++;}
		}
		return cpt;
	}
	private void ApplyMove(GameMove to_move){
		grid_data[to_move.start_index] = 2;
		grid_data[to_move.middle_index] = 2;
		grid_data[to_move.end_index] = 1;
	}
	private void UndoMove(GameMove to_move){
		grid_data[to_move.start_index] = 1;
		grid_data[to_move.middle_index] = 1;
		grid_data[to_move.end_index] = 2;
	}
	//a solution is a success if the end move make one pin left alone
	public boolean FindSolution(List<GameMove> solution_move){	
		return this.FindSolution(solution_move,1);
	}
	public boolean FindSolution(List<GameMove> solution_move,int algo_dept){	
		node_visited_cpt++;
		if(algo_dept > dept_limit) {
			//dept_limit += dept_limit/4;
			return false;
		}
		if(algo_dept > max_dept){
			max_dept = algo_dept;
		}
		List<GameMove> available_move = this.GetAvailableMove();
		if(available_move.size() == 0){
			if(this.CountGridPin() == 1){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			for(GameMove current_move : available_move){
				ApplyMove(current_move);
				boolean result = this.FindSolution(solution_move,algo_dept++);
				if(result == true){
					solution_move.add(current_move);
					return true;
				}else{
					UndoMove(current_move);	
				}
			}	
		}
		return false;		
	}
}