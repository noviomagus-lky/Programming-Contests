import javafx.util.Pair;


class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashMap<String,List<String>> graph = new HashMap();
        wordList.add(beginWord);
        int L = wordList.size();
        
        for(int i = 0;i < L;i++)
        {
            graph.put(wordList.get(i),new LinkedList<String>());
        }
        
        for(int i = 0;i < L;i++)
        {
            for(int j = i+1;j < L;j++)
            {
                if(available(wordList.get(i),wordList.get(j)))
                { 
                    graph.get(wordList.get(i)).add(wordList.get(j));
                    graph.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }
        //Now we have the graph.
        
        //Now we do the BFS trying to find a path from beginWord to endWord.
        //The first path we find must be the shortest path.
        
        Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
        Q.add(new Pair(beginWord, 1));
    
        System.out.println(available("hit","hit"));
        
        while(!Q.isEmpty())
        {
            Pair<String,Integer> temp = Q.remove();
            int level = temp.getValue().intValue();
            
            List<String> diction = graph.get(temp.getKey());
            
            for(int i = 0;i < diction.size();i++)
            {
                if(diction.get(i).equals(endWord))
                    return level +1;
                        
                Q.add(new Pair(diction.get(i), level+1));
                
              
            }
            diction.clear();
        }
        
        return 0;
                
    }
    
    
    public boolean available(String a,String b)
    {
           int count = 0;
            for(int i = 0;i < a.length();i++)
                if(a.charAt(i) != b.charAt(i))
                    count ++;
           if(count == 1)
               return true;
           else 
               return false;
        
    }
}
