
class PartialScan {

    public static void main(String args[]) {

        int N=4; 

        char[][] alvin = new char[N][N];

        int i, j, r, c, nextJ, nextI; 

        System.out.println("\nThis is the full array:");
        for (i = 0; i < N; i++) {
            System.out.print("\n\t");
            for (j = 0; j < N; j++) {
                alvin[i][j] = (char)(65+ i * N + j);
                System.out.print(alvin[i][j]+" ");
            }
        }

        i = 0; 
        j = 2; 

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
