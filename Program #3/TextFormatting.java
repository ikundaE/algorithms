package student;
/* 
 * This class is meant to contain your algorithm.
 * You should implement the static method:
 *   formatParagraph - which formats one paragraph
 */
import java.util.ArrayList;

public class TextFormatting {
	// simple greedy paragraph formating that just packs each line as full as possible
	// this will usually not give an optimal result
	//
	// input:
	//   words: an array of the words in the paragraph
	//   width: the desired formatting width
	//   result: an empty ArrayList into which you should add the resulting paragraph
	//
	// returns:
	//   the formatted paragraph as an ArrayList of Strings, 1 string for each
	//     formatted line of the paragraph
	//   the return value is the total calculated badness value for the paragraph
	
	public static int formatParagraph(String[] words, int width, ArrayList<String> result) {

		int badness = 0;
		int spaceleft [] [] = new int [words.length][words.length];
		//These nested loops are going to put all the words combo possible per line
		for (int i = 0; i < words.length; i++)
		{
			spaceleft[i][i] = width - words[i].length();
			for (int j = i+1; j < words.length; j++)
				{				     //add 1 is for the space between words
					spaceleft[i][j] = spaceleft [i][j-1] - words[j].length() - 1; 
				}
		}
		
		//these next nested loops is to find places where words go beyond the width
		for (int i=0; i<words.length; i++)
		{
			for (int j=i; j<words.length; j++)
			{
				if(spaceleft[i][j] < 0)
				{
					spaceleft[i][j] = Integer.MAX_VALUE;
				}else
				{	//this is the the local badness per line
					spaceleft[i][j] = (int) Math.pow(spaceleft[i][j], 3);
				}
			}
		}
		
		int badnesperline[] = new int[words.length];
        int wordsindex[] = new int[words.length];
        for(int i = words.length-1; i >= 0 ; i--)
        {
        	badnesperline[i] = spaceleft[i][words.length-1];
            wordsindex[i] = words.length;
            for(int j=words.length-1; j > i; j--)
            {
                if(spaceleft[i][j-1] == Integer.MAX_VALUE)
                {
                    continue;
                }
                if(badnesperline[i] > badnesperline[j] + spaceleft[i][j-1])
                {
                	badnesperline[i] = badnesperline[j] + spaceleft[i][j-1];
                	//badness += badnesperline[i];
                    wordsindex[i] = j;
                }
            }
        }
        
        int i = 0;
        int j;
        badness = badnesperline[0];
        do{
        	StringBuilder buf = new StringBuilder();
            j = wordsindex[i];
            for(int k=i; k < j; k++){
            	buf.append(words[k] + " ");
            }
            result.add(buf.toString()); 
            i = j;
        }while(j < words.length);
        
        //return builder.toString();
    
		
		/*int i = 0;
		while (i < words.length) {       // this loop adds another line to result
			StringBuilder buf = new StringBuilder();
			buf.append(words[i++]);
			// add more words until full
			while (i < words.length && buf.length() + 1 + words[i].length() <= width)
				buf.append(" "+words[i++]);      // space between words
			badness += Math.pow(width-buf.length(), 3);
			result.add(buf.toString());   // add this line to the paragraph
		}*/
		 
		return badness;
	}

	// extra credit paragraph formatting that has no penalty for the last line of the paragraph
	public static int xc_formatParagraph(String[] words, int width, ArrayList<String> result) {
		
		return -1;		// not implemented
	}
}

