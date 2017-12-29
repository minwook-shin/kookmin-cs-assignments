package kmu.oop.practice.lab4.theater;

import kmu.oop.practice.lab4.common.*;
import kmu.oop.practice.lab4.theater.*;

public class ReservedProgram extends TheaterProgram {
    boolean reserved[][];

    // Test5: set up 3 variables with incoming arguments, and then, construct
    // 2-dimensional variables(sold[][] and reserved[][]) followed by initializing as 'false'.
    public ReservedProgram(TheaterType type, String program, int admissionFee[]) {

        super(type, program, admissionFee);
        reserved = new boolean[type.level][];


        for (int i = 0; i < type.level; i++) {
            reserved[i] = new boolean[type.size[i]];
        }


        for (int i = 0; i < type.level; i++) {
            for (int j = 0; j < type.size[i]; j++) {

                reserved[i][j] = false;
            }
        }


        // set up type, program, admissionfee, and sold[][] by calling constructor
        //   TheaterProgram(TheaterType type, String program, int admissionFee[]).
        // set up reserved[][] by allocating memory space and initialing the value by 'false'

    }

    // Test6: mark the seat reserved out with 'true'
    public boolean reserve(String level, int position) {
        reserved[changeLevel(level)][position - 1] = true;// mark reserved[][] at the proper seat location

        return true;
    }

    // Test7: compute the total # of vacant seats that are neither sold nor reserved.
    public int vacantSeat() {
        int sum = 0;

        for (int i = 0; i < reserved.length; i++) {
            for (int j = 0; j < reserved[i].length; j++) {
                if ((sold[i][j] == false) && (reserved[i][j] == false)) {
                    sum++;
                }
            }
        }// count up the # of vacant seats that are neither sold nor reserved.

        return sum;
    }

    public String seatStatus(String level, int position) {
        String res;

        if (sold[changeLevel(level)][position - 1]) res = "Sold";
        else if (reserved[changeLevel(level)][position - 1]) res = "Reserved";
        else res = "Vacant";

        return res;
    }

    // Test8: compute the total expected income yielded by selling or reserving tickets
    public int expectedIncome() {
        int sum = 0;

        for (int i = 0; i < sold.length; i++) {
            for (int j = 0; j < sold[i].length; j++) {
                if (sold[i][j] == true || reserved[i][j] == true) {
                    sum += admissionFee[i];
                }
            }
        }
        // compute total expected income by selling or reserving tickets

        return sum;
    }

}
