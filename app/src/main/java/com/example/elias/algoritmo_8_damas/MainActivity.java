package com.example.elias.algoritmo_8_damas;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    View mview;
    GridView gridView;
    ImageAdapter adapter;
    private Integer[] mThumbIds = {
            R.drawable.casilla_blanca, R.drawable.casilla_cafe, R.drawable.casilla_blanca,
            R.drawable.casilla_cafe, R.drawable.casilla_blanca, R.drawable.casilla_cafe,
            R.drawable.casilla_blanca, R.drawable.casilla_cafe,

            R.drawable.casilla_cafe, R.drawable.casilla_blanca, R.drawable.casilla_cafe,
            R.drawable.casilla_blanca, R.drawable.casilla_cafe, R.drawable.casilla_blanca,
            R.drawable.casilla_cafe, R.drawable.casilla_blanca,

            R.drawable.casilla_blanca, R.drawable.casilla_cafe, R.drawable.casilla_blanca,
            R.drawable.casilla_cafe, R.drawable.casilla_blanca, R.drawable.casilla_cafe,
            R.drawable.casilla_blanca, R.drawable.casilla_cafe,

            R.drawable.casilla_cafe, R.drawable.casilla_blanca, R.drawable.casilla_cafe,
            R.drawable.casilla_blanca, R.drawable.casilla_cafe, R.drawable.casilla_blanca,
            R.drawable.casilla_cafe, R.drawable.casilla_blanca,

            R.drawable.casilla_blanca, R.drawable.casilla_cafe, R.drawable.casilla_blanca,
            R.drawable.casilla_cafe, R.drawable.casilla_blanca, R.drawable.casilla_cafe,
            R.drawable.casilla_blanca, R.drawable.casilla_cafe,

            R.drawable.casilla_cafe, R.drawable.casilla_blanca, R.drawable.casilla_cafe,
            R.drawable.casilla_blanca, R.drawable.casilla_cafe, R.drawable.casilla_blanca,
            R.drawable.casilla_cafe, R.drawable.casilla_blanca,

            R.drawable.casilla_blanca, R.drawable.casilla_cafe, R.drawable.casilla_blanca,
            R.drawable.casilla_cafe, R.drawable.casilla_blanca, R.drawable.casilla_cafe,
            R.drawable.casilla_blanca, R.drawable.casilla_cafe,

            R.drawable.casilla_cafe, R.drawable.casilla_blanca, R.drawable.casilla_cafe,
            R.drawable.casilla_blanca, R.drawable.casilla_cafe, R.drawable.casilla_blanca,
            R.drawable.casilla_cafe, R.drawable.casilla_blanca,
    };

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        gridView = findViewById(R.id.gridview);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        adapter = new ImageAdapter(this);
        gridView.setAdapter(adapter);

    }

    public void click(View view){
        gridView.setAdapter(new ImageAdapter(this));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(100, 100));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(0, 0, 0, 0);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

        // references to our images

    }

    public void change_image() throws InterruptedException {

        while (true){

            Thread.sleep(500);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void start(View view) throws InterruptedException {
        mview = view;/*
        new Thread(new Runnable() {
            public void run() {
                mThumbIds[20] = R.drawable.dama_blanca_blanca;
                gridView.setAdapter(adapter);

            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                try {
                    solveNQ();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/
        //mThumbIds[20] = R.drawable.dama_blanca_blanca;
        //gridView.setAdapter(new ImageAdapter(this));
        solveNQ();

    }

    final int N = 8;

    /* A utility function to print solution */
    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");

            System.out.println();
        }
        System.out.println("Aqui");
        Thread thread = new Thread(new Runnable() {
            public void run() {
                mThumbIds[20] = R.drawable.dama_blanca_blanca;
                gridView.setAdapter(adapter);

            }
        });
        thread.start();
        thread.stop();

    }

    /* A utility function to check if a queen can
    be placed on board[row][col]. Note that this
    function is called when "col" queens are already
    placeed in columns from 0 to col -1. So we need
    to check only left side for attacking queens */
    boolean isSafe(int board[][], int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    /* A recursive utility function to solve N
    Queen problem */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    boolean solveNQUtil(int board[][], int col) throws InterruptedException {
/* base case: If all queens are placed
then return true */
        if (col >= N) {
//solucion
            System.out.println("Solucion \n\n");
//printSolution(board);
            return true;
        }



/* Consider this column and try placing
this queen in all rows one by one */
        boolean res = false;
        for (int i = 0; i < N; i++) {
//pasos
            board[i][col] = 1;
            //allocate_queen(i, col, true);
            System.out.println("\n\n");
            printSolution(board);
            board[i][col] = 0;
            //allocate_queen(i, col, false);
            mThumbIds[col] = R.drawable.dama_blanca_blanca;
            gridView.setAdapter(adapter);

/* Check if queen can be placed on
board[i][col] */


            if (isSafe(board, i, col)) {
                /* Place this queen in board[i][col] */
                board[i][col] = 1;



                /* recur to place rest of the queens */
/* if (solveNQUtil(board, col + 1) == true){
System.out.println("Esta es la solucion final /n");
return true;
}*/

                res = solveNQUtil(board, col + 1) || res;

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


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void allocate_queen(int i, int col, boolean queen) throws InterruptedException {
        int n;
        if (i == 0) {
            n = col;
            setImage(i, n, queen);
        } else if (i == 1) {
            n = col + 8;
            setImage(i, n, queen);

            //ImageButton imageButton = findViewById(R.id.imageButton1);
            //imageButton.setImageResource(R.drawable.casilla_blanca);

        } else if (i == 2) {
            n = col + 16;
            setImage(i, n, queen);
        } else if (i == 3) {
            n = col + 24;
            setImage(i, n, queen);
        } else if (i == 4) {
            n = col + 32;
            setImage(i, n, queen);
        } else if (i == 5) {
            n = col + 40;
            setImage(i, n, queen);
        } else if (i == 6) {
            n = col + 48;
            setImage(i, n, queen);
        } else if (i == 7) {
            n = col + 56;
            setImage(i, n, queen);
        }
        //gridView.setAdapter(new ImageAdapter(this));
        Thread.sleep(500);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setImage(int line, int col, boolean queen) throws InterruptedException {
        if (queen) {
            if (line % 2 == 0) {
                if (col % 2 == 0) {
                    //button.setImageDrawable(getDrawable(R.drawable.dama_blanca_blanca));
                    //
                    //button.setBackground(getDrawable(R.drawable.dama_blanca_negra));
                    mThumbIds[col] = R.drawable.dama_blanca_blanca;

                } else {
                    //button.setImageDrawable(getDrawable(R.drawable.dama_blanca_negra));
                    //button.setBackground(getDrawable(R.drawable.dama_blanca_negra));
                    mThumbIds[col] = R.drawable.dama_blanca_negra;
                }
            } else {
                if (col % 2 == 0) {
                    //button.setBackground(getDrawable(R.drawable.dama_blanca_negra));
                    mThumbIds[col] = R.drawable.dama_blanca_negra;
                } else {
                    //
                    //button.setBackground(getDrawable(R.drawable.dama_blanca_negra));
                    mThumbIds[col] = R.drawable.dama_blanca_blanca;
                }
            }

        } else {
            if (line % 2 == 0) {
                if (col % 2 == 0) {
                    //button.setBackground(getDrawable(R.drawable.escaque_blanco));
                    mThumbIds[col] = R.drawable.casilla_blanca;
                } else {
                    //button.setBackground(getDrawable(R.drawable.escaque_negro));
                    mThumbIds[col] = R.drawable.casilla_cafe;
                }
            } else {
                if (col % 2 == 0) {
                    //button.setBackground(getDrawable(R.drawable.escaque_negro));
                    mThumbIds[col] = R.drawable.casilla_cafe;
                } else {
                    //button.setBackground(getDrawable(R.drawable.escaque_blanco));
                    mThumbIds[col] = R.drawable.casilla_blanca;
                }
            }
        }

    }

    /* This function solves the N Queen problem using
    Backtracking. It mainly uses solveNQUtil() to
    solve the problem. It returns false if queens
    cannot be placed, otherwise return true and
    prints placement of queens in the form of 1s.
    Please note that there may be more than one
    solutions, this function prints one of the
    feasible solutions.*/
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    boolean solveNQ() throws InterruptedException {
        /*int board[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };*/

        int board[][] = {{0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };


        if (!solveNQUtil(board, 0)) {
            System.out.print("Solution does not exist");
            return false;
        }

//printSolution(board);
        return true;
    }
}
