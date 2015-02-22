import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DupFiles {
	
	public static List<File> MyFiles = new ArrayList<File>();
	
	public static void main(String[] args) throws IOException {
		
		  File[] files = new File("D:\\opit folder").listFiles(); //D:\\opit folder is the checked directory
		    getFiles(files);
		    
		    list_Files();
		    
		    removeDupFiles();
		    System.out.println("========"); //separates before and after duplicate files been removed
		    
		    list_Files();

	}
	
	public static void removeDupFiles() throws IOException{
		
		if(MyFiles.isEmpty()){
			
			System.out.println("no files");
			
		}else
		{
			for(int i=0; i<MyFiles.size(); i++){
				
				boolean flag=false;
				
				for(int j=i+1; j<MyFiles.size(); j++){
					
					FileReader FR_i = new FileReader(MyFiles.get(i));
					FileReader FR_j = new FileReader(MyFiles.get(j));
					
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
						MyFiles.remove(j);
						j--;
					}	
					
					reader1.close();
					reader2.close();
				}	
			}					
		}	
	}
		
	public static void getFiles(File[] files) {
	    for (File file : files) {
	        if (file.isDirectory()) {
	            getFiles(file.listFiles());
	        } else {
	            MyFiles.add(file);
	        }
	    }
	}
	
	public static void list_Files(){
		for(int i=0; i<MyFiles.size(); i++){
			System.out.println(MyFiles.get(i).getName());
		}
	}
	
	
}