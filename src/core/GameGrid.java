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
	public boolean LoadFromFile(char[] file_name){
		grid_data = new int[this.grid_size];
		boolean Status = true;
		
		int c;
		int current_index = 0;
		int item_loaded_cpt = 0;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("test.puzzle"));
	
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
			if(grid_data[i] != 0 || grid_data[i] != 2){ //Check if its a 'Pion'
				
				//Check top side
				if(i-grid_x >= 0 &&  i-grid_x*2 >= 0){ //Check if top side is in play
					if(grid_data[i-grid_x] == 1 && grid_data[i-grid_x*2] == 2){ //Check if top is clear move
						
					}
				}
				//Check bottom side
				if(i+grid_x < grid_size &&  i+grid_x*2 < grid_size){ //Check if bottom side is in play
					if(grid_data[i+grid_x] == 1 && grid_data[i+grid_x*2] == 2){ //Check if bottom is clear move
						
					}
				}
				//Check left side
				if((i-1)%6 == 0 || (i-2)%6 == 0){ //If on the left side
					//To close to the left edge
				}
				else{
					//Check if clean move possible
					if(grid_data[i-1] == 1 && grid_data[i-2] == 2){ //Check if left is a clear move
						
					}
				}
				//Check right side
				if((i+1)%7 == 0 || (i+2)%7 == 0){ //Check if right side clear to check
					//To close to the right edge
				}
				else{
					//Check if clean move possible
					if(grid_data[i+1] == 1 && grid_data[i+2] == 2){ //Check if bottom is clear move
						
					}
				}
			}
		}		
		return result;
	}
}
 