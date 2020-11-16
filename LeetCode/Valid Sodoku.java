class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<Character> myset = new HashSet();
        int i,j;
        //check if each row is valid
        for(i = 0; i < 9; i++)
        {
            myset = new HashSet();
            
            for(j = 0; j < 9; j++)
            {
                if(myset.contains(board[i][j])&&(board[i][j]!='.'))
               {return false;}
                
                myset.add(board[i][j]);
                    
            }
        }
        //check if each column is valid
        for(i = 0; i < 9; i++)
        {
            myset = new HashSet();
            
            for(j = 0; j < 9; j++)
            {
               if(myset.contains(board[j][i])&&(board[j][i]!='.'))
                    {return false;}
                
                myset.add(board[j][i]);
                    
            }
        }
        //check if each box is valid
        for(i = 0; i < 9; i+=3)
        {
            for(j = 0; j < 9; j+=3)
            {
                if(!isValidBox(i,j,board))
                    return false;
            }
        }
        return true;
    }
    public boolean isValidBox(int row, int column, char[][] board)
    {
        HashSet<Character> mybox = new HashSet();
        for (int i = row; i < row + 3; i++)
        {
            for(int j = column; j < column + 3; j++)
            {
                 if(mybox.contains(board[i][j])&&(board[i][j]!='.'))
                    {return false;}
                mybox.add(board[i][j]);
            }
        }
        return true;
    }
}
