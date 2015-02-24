import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DupFiles {
	
	public static List<File> myFiles = new ArrayList<File>();
	
	public static void main(String[] args) {


		  Scanner scan = new Scanner(System.in);

		  String dir = scan.nextLine();
			
		  ListDuplicatingFiles(dir);

	}
	
	public static void ListDuplicatingFiles(String[] dir) throws IOException {
	
		    File[] files = new File(dir).listFiles(); //dir is the checked directory

		    GetFiles(files);
		    
		    PrintFiles();
		    
		    RemoveDuplicatedFiles();

		    System.out.println();
		    
		    PrintFiles();
	}
	
	
	public static void RemoveDuplicatedFiles() throws IOException{
		
		if(myFiles.isEmpty()){
			
			System.out.println("no files");
			
		}else
		{
			for(int i=0; i<myFiles.size(); i++){
				
				boolean flag=false;
				
				for(int j=i+1; j<myFiles.size(); j++){
					
					FileReader FR_i = new FileReader(myFiles.get(i));
					FileReader FR_j = new FileReader(myFiles.get(j));
					
					BufferedReader reader1 = new BufferedReader(FR_i);
					BufferedReader reader2 = new BufferedReader(FR_j);

					String line1 = null;
					String line2 = null;
					
					while (((line1 = reader1.readLine()) != null)&&((line2 = reader2.readLine()) != null)) 
					{
					    if (!line1.equalsIgnoreCase(line2)) 
					    { 
					        flag=true; 
					        break;
					    }
					}
					
					if(flag==false){
						myFiles.remove(j);
						j--;
					}	
					
					reader1.close();
					reader2.close();
				}	
			}					
		}	
	}
		
	public static void GetFiles(File[] files) {
	    for (File file : files) {
	        if (file.isDirectory()) {
	            GetFiles(file.listFiles());
	        } 
		else {
	            myFiles.add(file);
	        }
	    }
	}
	
	public static void PrintFiles() {
		for(int i=0; i<myFiles.size(); i++) {
			System.out.println(myFiles.get(i).getName());
		}
	}
	
	
}