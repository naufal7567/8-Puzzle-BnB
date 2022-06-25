package com.company;

public class Node {
    // Menyimpan parent node dari node sekarang
    // untuk membantu menemukan alurnya ketika jawaban sudah ditemukan
    public Node parent;

    // Menyimpan matrix
    public int[][] matrix;

    // Menyimpan koordinat angka 0 atau yang kosong
    public int x, y;

    // Menyimpan jumlah angka yang tidak berada pada tempatnya
    public int cost;

    // Menyimpan tingkatan level node
    public int level;

    // Function to allocate a new node
    // Fungsi untuk mengalokasikan node baru
    public Node(int[][] matrix, int x, int y, int newX, int newY, int level, Node parent)
    {
        // Atur penunjuk untuk alur ke root
        this.parent = parent;

        // copy data dari parent node ke node yang sekarang
        this.matrix = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++)
        {
            this.matrix[i] = matrix[i].clone();
        }

        // Menukar angka
        // pindahkan angka sebanyak 1 posisi
        this.matrix[x][y]       = this.matrix[x][y] + this.matrix[newX][newY];
        this.matrix[newX][newY] = this.matrix[x][y] - this.matrix[newX][newY];
        this.matrix[x][y]       = this.matrix[x][y] - this.matrix[newX][newY];

        // Menentukan jumlah angka yang tidak berada di tempatnya
        this.cost = Integer.MAX_VALUE;
        // Menentukan level node
        this.level = level;

        // update koordinat angka 0 atau kosong
        this.x = newX;
        this.y = newY;
    }

}