package core;

import java.io.*;
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
		return null;
	}
}
 