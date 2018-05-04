package com.example.elias.algoritmo_8_damas;

import android.widget.ImageButton;

public class queen {
    final int N = 8;

    /* A utility function to print solution */
    void printSolution(int board[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }

    /* A utility function to check if a queen can
    be placed on board[row][col]. Note that this
    function is called when "col" queens are already
    placeed in columns from 0 to col -1. So we need
    to check only left side for attacking queens */
    boolean isSafe(int board[][], int row, int col)
    {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i=row, j=col; j>=0 && i<N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    /* A recursive utility function to solve N
    Queen problem */
    boolean solveNQUtil(int board[][], int col)
    {
/* base case: If all queens are placed
then return true */
        if (col >= N){
//solucion
            System.out.println("Solucion \n\n");
//printSolution(board);
            return true;
        }



/* Consider this column and try placing
this queen in all rows one by one */
        boolean res = false;
        for (int i = 0; i < N; i++)
        {
//pasos
            board[i][col]=1;
            System.out.println("\n\n");
            printSolution(board);
            board[i][col]=0;

/* Check if queen can be placed on
board[i][col] */


            if (isSafe(board, i, col))
            {
                /* Place this queen in board[i][col] */
                board[i][col] = 1;
                allocate_queen(i, col);


                /* recur to place rest of the queens */
/* if (solveNQUtil(board, col + 1) == true){
System.out.println("Esta es la solucion final /n");
return true;
}*/

                res=solveNQUtil(board,col+1)||res;

/* If placing queen in board[i][col]
doesn't lead to a solution then
remove queen from board[i][col] */
                board[i][col] = 0; // BACKTRACK
            }
        }

/* If queen can not be place in any row in
this colum col, then return false */
        return res;
    }

    private void allocate_queen(int i, int col) {
        ImageButton button;
        if (i == 0){
            //button= (ImageButton)findViewById(R.id.imageButton1);
        }
        //button= (ImageButton)findViewById(R.id.);
    }

    /* This function solves the N Queen problem using
    Backtracking. It mainly uses solveNQUtil() to
    solve the problem. It returns false if queens
    cannot be placed, otherwise return true and
    prints placement of queens in the form of 1s.
    Please note that there may be more than one
    solutions, this function prints one of the
    feasible solutions.*/
    boolean solveNQ()
    {
        /*int board[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };*/

    int board[][] ={{0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0}
    };

    if (!solveNQUtil(board, 0))
    {
        System.out.print("Solution does not exist");
        return false;
    }

//printSolution(board);
        return true;
    }
}
