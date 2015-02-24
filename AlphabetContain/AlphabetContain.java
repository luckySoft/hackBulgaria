
public class AlphabetContain {
	public static void main(String[] args){
		
		System.out.println(smallestSubstringContainingTheAlphabet("aaaaaabcdefghijklmnopqrstuvwxyz"));
		System.out.println(smallestSubstringContainingTheAlphabet("abcdefghijklmn124345678!@#$%^&*opqrstuvwxyz!*abcdefghijklmn"));
	}
	
	public static boolean contain(String temp){

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
	
	public static String smallestSubstringContainingTheAlphabet(String text){
		
		for(int i=26;i<=text.length(); i++){
		    for(int j=0; j<=text.length()-i; j++){
		        String temp=text.substring(j, j+i);
		        if(contain(temp)){
		            return temp;
		        }
		    }
		}

		return "not containing";
	}

}
