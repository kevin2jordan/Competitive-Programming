package Blind75.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Node {
    int x;
    int y;
    int val;

    Node(int val, int x, int y) {
        this.val = val;
        this.x = x;
        this.y = y;
    }
}

public class mergeKArrays {

    public static void main(String[] args) {
        int matrix[][] = {
                {4,5,6},
                {1,2,3},
                {7,8,9}
        };

        List<Integer> result = mergeKSortedArrays(matrix);

        for(int ele: result) {

            System.out.print(ele + " ");
        }
    }

    private static List<Integer> mergeKSortedArrays(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<Integer> sortedMatrix = new ArrayList<>();
        PriorityQueue<Node> pqueue = new PriorityQueue<>((x,y) -> x.val - y.val);

        for(int i=0;i<n;i++) {
            pqueue.add(new Node(matrix[i][0], i, 0));
        }

        while(!pqueue.isEmpty()) {
            Node top = pqueue.poll();
            sortedMatrix.add(top.val);
            if(top.y+1 < m) {
                pqueue.add(new Node(matrix[top.x][top.y+1], top.x, top.y+1));
            }
        }

        return sortedMatrix;
    }
}

/*
        Brute Force - put all elements in list and sort
        nmlognm

        Optimised :- nmlogn

        nklogn

 */
