package com.flyers.tms.game;

import java.util.Arrays;
import java.util.Scanner;

public class MainApp {

  static int first = 1;
  static int second = 2;
  static byte row = 3;
  static byte column = 3;
  static boolean value = true;

  static int[][] arr = new int[row][column];

  public static void main(String[] args) {

    System.out.println("Tic-Tac-Toe GAME");
    System.out.println("RULES: Players take turns putting their marks in empty squares. " +
        "The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner. " +
        "When all 9 squares are full, the game is over. If no player has 3 marks in a row, the game ends in a tie.");

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }

    Scanner sc = new Scanner(System.in);
    int index1;
    int index2;

    while (value) {
      System.out.println(first + "'st player enter index to save value :"+ first);
       index1 = sc.nextInt();
       index2 = sc.nextInt();

      //To set first player value -- 1
      MainApp.toSetValue(index1,index2,first);
      MainApp.printGame();
      System.out.println(second + "'st player enter index to save value :"+ second);
      index1 = sc.nextInt();
      index2 = sc.nextInt();

      //To set second player value -- 2
      MainApp.toSetValue(index1,index2,second);
      MainApp.printGame();
    }
  }

  private static void printGame() {
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void toSetValue(int index1,int index2,int val){
    try {
      for (int i = index1; i < row; i++) {
        for (int j = index2; j < column; j++) {
          arr[i][j] = val;
          break;
        }
        break;
      }
    }catch (Exception e){
      throw new RuntimeException("Entered Index Was Out Of Bound!!!!");
    }
  }



}
