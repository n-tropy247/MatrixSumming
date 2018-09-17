/*
 * Copyright (C) 2018 Ryan Castelli
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package matrixsumming;

import org.apache.commons.lang3.StringUtils;

/**
 * Summing matrices in a console session.
 *
 * @author Ryan Castelli
 * @version 9/17/2018
 */
final class MatrixSumming {

    /**
     * Matrices to sum.
     */
    private static final int[][] MATRIX1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
            MATRIX2 = {{3, 2, 1}, {6, 5, 4}, {9, 8, 7}};

    /**
     * Utility class.
     */
    private MatrixSumming() {
    }

    /**
     * Main method.
     *
     * @param args
     *          command-line arguments
     */
    public static void main(final String[] args) {
        int[][] result = sumMatrices(MATRIX1, MATRIX2);
        int maxVal = 0;
        for (int[] row : result) {
            for (int col : row) {
                if (col > maxVal) {
                    maxVal = col;
                }
            }
        }
        for (int[] row : result) {
            for (int col : row) {
                System.out.printf("|%s|",
                        StringUtils.center(String.valueOf(col),
                                String.valueOf(maxVal).length()));
            }
            System.out.println();
        }
    }

    /**
     * Perform the matrix addition.
     *
     * @param a
     *          first matrix
     * @param b
     *          second matrix
     * @return summed matrix
     */
    private static int[][] sumMatrices(final int[][] a, final int[][] b) {
        if (a.length == b.length && a[0].length == b[0].length) {
            int[][] sum = new int[a.length][a[0].length];
            for (int row = 0; row < sum.length; row++) {
                for (int col = 0; col < sum[0].length; col++) {
                    sum[row][col] = a[row][col] + b[row][col];
                }
            }
            return sum;
        } else {
            System.out.println("Matrices not same dimensions.");
        }
        return null;
    }
}
