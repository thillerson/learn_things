package com.company.dataStructures.lintCode;

import java.util.*;

public class Islands {

  public static class Coordinate {
    public int x;
    public int y;

    public Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "Coordinate{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Coordinate)) return false;

      Coordinate that = (Coordinate) o;

      if (x != that.x) return false;
      return y == that.y;
    }

    @Override
    public int hashCode() {
      int result = x;
      result = 31 * result + y;
      return result;
    }

  }


  /**
   * [
   * [1, 1, 0, 0, 0],
   * [0, 1, 0, 0, 1],
   * [0, 0, 0, 1, 1],
   * [0, 0, 0, 0, 0],
   * [0, 0, 0, 0, 1]
   * ]
   */
  public static void scanMatrix() {
    int[][] field = new int[][]{new int[]{1, 1, 0, 0, 0}, new int[]{0, 1, 0, 0, 1}, new int[]{0, 0, 0, 1, 1}, new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 1}};
    int[][] components = new int[][]{new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0}};
    Set<Coordinate> visited = new HashSet<>();
    Queue<Coordinate> toVisit = new LinkedList<>();

    int i = 0, j = 0, connectedComponents = 0;
    for (; i < field.length; i++) {
      //System.out.printf("considering row %s:\n", i);
      int[] row = field[i];
      for (j = 0; j < row.length; j++) {
        //System.out.printf("\tconsidering column %s (value: %s):\n", j, row[j]);
        if (row[j] == 1 && components[i][j] == 0) {
          components[i][j] = ++connectedComponents;
          Coordinate initialCoordinate = new Coordinate(i, j);
          toVisit.add(initialCoordinate);
          visited.add(initialCoordinate);

          do {
            Coordinate coordinate = toVisit.remove();
            components[coordinate.x][coordinate.y] = connectedComponents;
            List<Coordinate> neighbors = neighborsFor(coordinate, field);
            for (Coordinate neighborCoordinate : neighbors) {
              //System.out.printf("Considering neighbor: %s\n", neighborCoordinate);
              if (!visited.contains(neighborCoordinate)) {
                //System.out.printf("neighbor not yet visited: %s\n", neighborCoordinate);
                toVisit.add(neighborCoordinate);
                visited.add(neighborCoordinate);
              }
            }
          } while (!toVisit.isEmpty());
        }
      }
    }

    System.out.printf("Connected Components: %s\n%s", connectedComponents, Arrays.deepToString(components));
  }

  private static List<Coordinate> neighborsFor(Coordinate coordinate, int[][] field) {
    int x = coordinate.x;
    int y = coordinate.y;
    List<Coordinate> neighbors = new LinkedList<>();

    /**
     *  [ [a b c],
     *    [d e f],
     *    [g h i] ]
     *
     *  given ^^ and [1,1], (e), then this should return
     *  [ [0,1], [1,0], [1,2], [2,1] ]
     *
     */

    if (x <= field.length - 1 && x >= 0) {
      int[] row = field[x];
      if (y <= row.length - 1 && y >= 0) {
        Coordinate top = new Coordinate(x - 1, y);
        Coordinate bottom = new Coordinate(x + 1, y);
        Coordinate right = new Coordinate(x, y + 1);
        Coordinate left = new Coordinate(x, y - 1);

        if (top.x >= 0 && top.x < field.length && field[top.x][top.y] == 1) {
          neighbors.add(top);
        }
        if (bottom.x >= 0 && bottom.x < field.length && field[bottom.x][bottom.y] == 1) {
          neighbors.add(bottom);
        }
        if (right.y >= 0 && right.y < row.length && field[right.x][right.y] == 1) {
          neighbors.add(right);
        }
        if (left.y >= 0 && left.y < row.length && field[left.x][left.y] == 1) {
          neighbors.add(left);
        }
      }
    }

    //System.out.printf("Neighbors to [%s,%s]: \n %s\n", coordinate.x, coordinate.y, neighbors);

    return neighbors;
  }

}
