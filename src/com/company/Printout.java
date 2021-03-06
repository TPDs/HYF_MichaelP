package com.company;

import java.util.ArrayList;

public class Printout {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";


    public void printMaze(ArrayList<Point> wallList, Bug bug) {
        boolean flag1, flag2;

        for (int i = 12; i >= 0; i--) {
            if (i % 2 == 0) {
                for (int j = 1; j < 12; j = j + 2) {
                    System.out.print(ANSI_GREEN+"+");
                    Point temp = new Point(j, i);
                    flag1 = false;
                    for (Point s : wallList) {
                        if (s.getV() == temp.getV() && s.getH() == temp.getH()) {
                            flag1 = true;
                            break;
                        }
                    }
                    if (flag1) {
                        System.out.print("---");

                    } else {
                        System.out.print("   ");
                    }
                }
                System.out.println("+");
            } else {
                for (int k = 0; k < 12; k = k + 2) {
                    Point temp1 = new Point(k, i);
                    flag2 = false;
                    for (Point e : wallList) {
                        if (e.getV() == temp1.getV() && e.getH() == temp1.getH()) {
                            flag2 = true;
                            break;
                        }
                    }
                    if (flag2) {
                        System.out.print("|");
                    } else {
                        System.out.print(" ");
                    }
                    Point temp2 = new Point(k + 1, i);
                    Point temp3 = new Point(bug.getHorizontal(), bug.getVertical());
                    if (temp2.getH() == temp3.getH() && temp2.getV() == temp3.getV()) {
                        System.out.print(ANSI_YELLOW+"[¤]"+ ANSI_GREEN);
                    } else {
                        System.out.print("   ");
                    }
                }
                System.out.println("|");
            }
        }

    }
}
