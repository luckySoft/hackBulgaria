
public class AlphabetContain {
	public static void main(String[] args){
		
		System.out.println(smallestSubstringContainingTheAlphabet("aaaaaabcdefghijklmnopqrstuvwxyz"));
		System.out.println(smallestSubstringContainingTheAlphabet("abcdefghijklmn124345678!@#$%^&*opqrstuvwxyz!*abcdefghijklmn"));
	}
	
	public static boolean contain(String B){

	    boolean[] flag = new boolean[26];
	    
	    
	    
	    for(int i=0; i<26; i++){
	            flag[i]=false;
	    }

	    for(int i=0; i<B.length(); i++){
	        if((int)B.charAt(i)-97>=0 && (int)B.charAt(i)-97<=26){
	            flag[(int)B.charAt(i)-97]=true;
	        }
	    }

	    boolean cont=true;

	    for(int i=0; i<26; i++){
	        if(!flag[i]){
	            cont=false;
	        }
	    }

	    return cont;
	}
	
	public static String smallestSubstringContainingTheAlphabet(String A){
		
		for(int i=26;i<=A.length(); i++){
		    for(int j=0; j<=A.length()-i; j++){
		        String temp=A.substring(j, j+i);
		        if(contain(temp)){
		            return temp;
		        }
		    }
		}

		return "not containing";
	}

}
