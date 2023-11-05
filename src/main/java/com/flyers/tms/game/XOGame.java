package com.flyers.tms.game;

import java.util.Scanner;

public class XOGame {

  public static void main(String[] args) {

    char[][] box = new char[3][3];
    char player  = 'X';
    boolean gameOver = false;
    Scanner sc = new Scanner(System.in);

    for (int row = 0; row < box.length; row++){
      for (int col = 0; col < box[row].length; col++){
        box[row][col] = ' ';
      }
    }

    while (!gameOver){
      showBoard(box);
      System.out.println("Player " + player + " enter index position");
      int row = sc.nextInt();
      int col = sc.nextInt();

      //To check the given position already exist or not
      if (box[row][col] != ' '){
        System.out.println("Invalid move change the position");
      }else {
        //To place the value
        box[row][col] = player;

        //To check who won
        gameOver = haveWon(box,player);

        if (gameOver){
          System.out.println("Player "+ player +" won the match");
        }else {
          if (player == 'X'){
            player = 'O';
          }else {
            player = 'X';
          }
        }
      }
    }
    showBoard(box);
  }

  private static boolean haveWon(char[][] box, char player) {
    //check the rows
    for (int i = 0; i<box.length; i++){
      if (box[i][0] == player && box[i][1] == player && box[i][2] == player)
        return true;
    }

    //check the column
    for (int j = 0; j<box.length; j++){
      if (box[0][j] == player && box[1][j] == player && box[2][j] == player)
        return true;
    }

    //check the diagonals
   if (box[0][0] == player && box[1][1] == player && box[2][2] == player)
     return true;

   if (box[0][2] == player && box[1][1] == player && box[2][0] == player)
     return true;

    return false;
  }

  private static void showBoard(char[][] box) {
    for (int i =0; i< box.length; i++){
      for (int j =0; j< box.length; j++ )
        System.out.print(box[i][j]+" |");

      System.out.println();
    }

  }

}
