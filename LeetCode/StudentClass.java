package matcher;

public class StudentClass {

	public KMPMatcher kmpMatcher;

	public StudentClass(String text, String pattern) {
		kmpMatcher = new KMPMatcher(text, pattern);
	}

	public void buildPrefixFunction() {
		kmpMatcher.setPrefixFunction(computePrefixFunction(kmpMatcher.getPattern()));
	}
	
	public static int[] computePrefixFunction(String pattern) {
		
		int patternLen = pattern.length();
		
		
		
		//initialize the array to hold the value of prefix-function	
		int[] prefixFunction = new int[patternLen];
		
		prefixFunction[0] = 0;
		int k = 0;//shift amount
		int q;
		//calculate each result of prefixFunction correspond to index q
		for(q = 1; q < patternLen; q++) {
		
			while(k > 0 && (pattern.charAt(k) != pattern.charAt(q)))
				k = prefixFunction[k - 1];
			if(pattern.charAt(k) == pattern.charAt(q))
				k+=1;
			prefixFunction[q] = k;
		}
		return prefixFunction;				
	}


	public static class KMPMatcher {

		private String text;
		private String pattern;
		private int textLen;
		private int patternLen;
		private int[] prefixFunction;
		private Queue matchIndices;

		public KMPMatcher(String text, String pattern) {
			this.text = text;
			this.pattern = pattern;
			this.textLen = text.length();
			this.patternLen = pattern.length();
			this.prefixFunction = new int[patternLen + 1];
			this.matchIndices = new Queue();
		}

		public void setPrefixFunction(int[] prefixFunction) {
			this.prefixFunction = prefixFunction;
		}

		public int[] getPrefixFunction() {
			return prefixFunction;
		}

		public String getPattern() {
			return pattern;
		}

		public Queue getMatchIndices() {
			return matchIndices;
		}

		public void search() {
			//check if the pattern is not longer than the text
			if(patternLen <= textLen) {
				
				
				int q = 0;//shift amount
				
				//search for all match indices in the text
				for(int i = 0; i < textLen ; i++) {
					while(q > 0 && pattern.charAt(q) != text.charAt(i))
						q = prefixFunction[q - 1];
					if(pattern.charAt(q) == text.charAt(i))
						q+=1;
					if(q == patternLen) {
						matchIndices.enqueue(i + 1 - patternLen);
					    q = prefixFunction[q - 1];
					    }
				}
		    }	
		}
	}
}