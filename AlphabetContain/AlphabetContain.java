
public class AlphabetContain {
	public static void main(String[] args){
		
		System.out.println(SmallestSubstringContainingTheAlphabet("aaaaaabcdefghijklmnopqrstuvwxyz"));
		System.out.println(SmallestSubstringContainingTheAlphabet("abcdefghijklmn124345678!@#$%^&*opqrstuvwxyz!*abcdefghijklmn"));
	}
	
	public static boolean Contain(String temp){

	    boolean[] flag = new boolean[26]; \\ 26 symbols in the alphabet
	    
	    
	    
	    for(int i=0; i<26; i++){
	            flag[i]=false;
	    }

	    for(int i=0; i<temp.length(); i++){
	        if((int)temp.charAt(i)-97>=0 && (int)temp.charAt(i)-97<=26){
	            flag[(int)temp.charAt(i)-97]=true;
	        }
	    }

	    boolean contAlpha=true;

	    for(int i=0; i<26; i++){
	        if(!flag[i]){
	            contAlpha=false;
	        }
	    }

	    return contAlpha;
	}
	
	public static String SmallestSubstringContainingTheAlphabet(String text){
		
		for(int i=26;i<=text.length(); i++){
		    for(int j=0; j<=text.length()-i; j++){
		        String temp=text.substring(j, j+i);
		        if(Contain(temp)){
		            return temp;
		        }
		    }
		}

		return "not containing";
	}

}
