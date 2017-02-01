package core;

public class GameMove {
	int start_index;
	int middle_index;
	int end_index;
	public GameMove(int start,int middle,int end){
		this.start_index = start;
		this.middle_index = middle;
		this.end_index = end;
	}
	public void PrintOutCmd(){
		System.out.print("	From "+start_index + " To " +end_index+ " over "+middle_index+'\n');
	}
}
