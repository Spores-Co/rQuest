/**
 * A faulty class that attempts to scan a two-dimensional array, forward of
 * a given position. There are two bugs in this class. An anticipated bug and
 * an "unexpected" one. The anticipated bug is that there is no code to
 * prevent the class from scanning a row beyond the last row of the array.
 * But this is easy to fix, and we'll take care of it at some time.
 *
 * The "unexpected" bug, is that the partial scan we attempt, does not return
 * every array element after the designated one, but only those on a column
 * after the column of the designated element. This is the bug that you need
 * to fix.
 *
 * For example, if the designated element is [0][2], as in the code below,
 * the partial scan should return D E F G H I J K L M N O P.
 * Instead it returns D H L P.
 *
 * Fit it. If you can. Please!
 * 
 */
class PartialScan {

    public static void main(String args[]) {

        int N=4; // size for NxN array

        /** We name the main array of this Class after the person
         * who suggested that we work on this problem.
         */
        char[][] alvin = new char[N][N];

        int i, j, r, c, nextJ, nextI; // Misc indices used throughout

        System.out.println("\nThis is the full array:");
        for (i = 0; i < N; i++) {
            System.out.print("\n\t");
            for (j = 0; j < N; j++) {
                alvin[i][j] = (char)(65+ i * N + j);
                System.out.print(alvin[i][j]+" ");
            }
        }

        i = 0; // Position in array from which we'll attempt
        j = 2; // a partial scan forward. You can change these
               // values and experiment with the behavior
               // of the bug you are asked to fix.

        System.out.println("\n\nAttempting a partial scan forward of row ["+i+"], column ["+j+"] (element value: "+alvin[i][j]+")");


        if (j == N - 1) {    
            nextJ = 0;       
            nextI = i + 1;  
        } else {             
            nextJ = j + 1;   
            nextI = i;       
        }                    
        System.out.print("\t");                    
        for (r = nextI; r < N;) {                
            for (c = nextJ; c < N; c++) 
            {   
                if(r==N)
                {break;}
                System.out.print(alvin[r][c] + " ");
                if(c==N-1 && j!=N-1)
                {
                    c=-1; r++;
                }
            }
        }
    }
}
