import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*  Kelompok 4 SDA
    Anggota:
    1. Shabrina Elfani Gucy (2111521005)
    2. Al - Amin (2111521017)
    3. Rakhilca Yanedika (2111522005)
    4. Syakina Triyana (2111522017)
    5. Lutfi Maulana (2111523001)
    6. Ghina Fitri Hidayah (2111523015)
 */

public class Laptop {    
    
    static    class Node {
        String key;
        Node left, right;
    
        public Node(String string){
            key = string;
            left = right = null;
        }
    }

        Node root;
        Laptop(){
            root = null;
        }
    
        void printPreorder(Node node){
            if (node == null)
                return;
            
            System.out.println(node.key + " ");
    
            printPreorder(node.left);
    
            printPreorder(node.right);
        }
    

        void printPreorder() {
            printPreorder(root);
        }
    
    
    public static void main(String[] args) {
        //mendefinisikan beberapa variabel yang akan digunakan
        String nama; //berguna untuk nama pelanggan
        Integer i=1, l = 1; //i untuk data nama pelanggan, l untuk data jenis laptop yang dibeli
        boolean bool = true; //
        Integer pendapatan = 0,tagihan = 0, harga = 0; 
        /*pendapatan untuk total pendapatan hari itu, tagihan untuk total berapa yang harus dibayar oleh pelanggan
         harga untuk menyimpan harga dari satu barang*/

        Queue <String> pelanggan = new LinkedList<String>(); //menyimpan antrian pelanggan
        Stack Asus = new Stack(); //menyimpan stok laptop Asus
        Stack Macbook = new Stack(); //menyimpan stok macbook
        Stack Lenovo =new Stack (); //menyimpan stok laptop Lenovo
        ArrayList <ArrayList <String>> data = new ArrayList <ArrayList<String>>(); //menyimpan data hasil penjualan
        Laptop laptop = new Laptop(); //membuat binary tree dengan nama laptop

        Scanner pilih = new Scanner(System.in);
        System.out.println("====== Isi Stok Gudang ======");
        //mengisi stok asus
        System.out.print("Jumlah Laptop Asus  : ");
        int StokAsus = pilih.nextInt();
        for(int j=0; j< StokAsus; j++)
        {
            Asus.push("Asus");
        }
                
        //mengisi stok Lenovo
        System.out.print("Jumlah Laptop Lenovo : ");
        int StokLenovo = pilih.nextInt();
        for(int k=0; k< StokLenovo; k++)
        {
            Lenovo.push("Lenovo");
        }

        //mengisi stok MacBook
        System.out.print("Jumlah Laptop MacBook : ");
        int StokMacBook = pilih.nextInt();
        for(int x=0; x< StokMacBook; x++)
        {
            Macbook.push("MacBook");
        }

        System.out.println("\n");
        System.out.println("=================================");
        System.out.println("SELAMAT DATANG DI TOKO LAPTOP SDA");
        System.out.println("=================================");

        //menambahkan data pada arraylist
        data.add(new ArrayList<String>());
        data.get(0).add("Nama");
        data.get(0).add("Barang Yang dibeli");

        //menu transaksi
        do {
            // System.out.println("\n");
            System.out.println("=================================");
            System.out.println("           PILIH MENU             ");
            System.out.println("=================================");
            System.out.println("1. Antrian");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Pemilihan Laptop");
            System.out.println("4. Bayar");
            System.out.println("5. Cek Pendapatan dan Data Penjualan");
            System.out.println("6. Selesai");
            System.out.print("MASUKAN PILIHAN [1-6]: ");
            int input=pilih.nextInt();
            switch(input){
                case 1: 
                    //masuk ke dalam antrian
                    System.out.println("==========================================");
                    System.out.print("Masukan Nama anda: ");
                    nama = pilih.next(); 
                    pelanggan.add(nama); // memasukkan nama pelanggan ke dalam antrian
                    
                    System.out.println("==========================================");
                    System.out.println("Selamat Datang "+ nama);
                    System.out.println("Nomor  antrian anda : " + (i++));
                    
                    data.add(new ArrayList<String>());
                    data.get(i-1).add(nama);

                    System.out.println("==========================================");
                    System.out.println("");
                    break;
                
                case 2: //mengecek jumlah antrian yang ada
                    System.out.println("==========================================");
                    System.out.println("Antrian : " + pelanggan);
                    System.out.println("==========================================");
                    System.out.println("");
                    break;
                
                case 3:
                    //melakukan pemilihan laptop
                    harga = 0;
                    if (pelanggan.isEmpty() == false){ //melakukan pengecekan apakah terdapat pelanggan dalam antrian
                        //Jika terdapapat pelanggan maka menu pilihan laptop akan keluar

                        System.out.println("==========================================");
                        //memasukkan menu ke dalam binary tree
                        laptop.root = new Node("1. Asus  @Rp. 19 Juta");
                        laptop.root.left = new Node("2. Lenovo  @Rp. 16 Juta");
                        laptop.root.right = new Node("3. MacBook  @Rp. 25 Juta");
                        
                        //menampilkan menu laptop
                        laptop.printPreorder();
                            System.out.print("Laptop pilihan anda : ");
                            Scanner pilihlaptop = new Scanner(System.in);
                            int jenis = pilihlaptop.nextInt();
    
                            switch(jenis){
                                case 1: //pembelian untuk laptop Asus
                                    Boolean cekAsus; //untuk mempersingkat penulisan kondisi pada percabangan
                                    cekAsus = Asus.isEmpty();
                                     
                                    if (cekAsus == false){ 
                                        System.out.println("Pilihan Tipe : ASUS");
                                        System.out.println();
                                        Asus.pop(); 
                                        
                                        harga = 19000000;
                                        tagihan = tagihan + harga  ; 
                                        data.get(l).add("Asus");

                                        System.out.println("Tagihan :" + tagihan);
                                        System.out.println("SISA STOK : "+ Asus.size());
                                        System.out.println("");
                                        
                                    }
                                    else{
                                        System.out.println("Maaf Stok Laptop Asus Kosong ");
                                    }
                                    break;

                                case 2: //pembelian untuk laptop Lenovo
                                    Boolean cekLenovo;
                                    cekLenovo = Lenovo.isEmpty();
                                    if (cekLenovo == false){
                                        System.out.println("Pilihan Tipe : LENOVO");
                                        System.out.println();
                                        Lenovo.pop();

                                        harga = 16000000;
                                        tagihan = tagihan + harga  ; 
                                        data.get(l).add("Lenovo");

                                        System.out.println("Tagihan :" + tagihan);
                                        System.out.println("SISA STOK : "+ Lenovo.size()); 
                                        System.out.println("");       
                                    }
                                    else{
                                        System.out.println("Maaf Stok Laptop Lenovo Kosong ");
                                    }
                                    
                                    break;
                                case 3: //pembelian untuk laptop Macbook
                                    Boolean cekMacbook; //cekMacbook berguna untuk mengecek apakah stok macbook masih tersedia
                                    cekMacbook = Macbook.isEmpty();
                                    if (cekMacbook == false){
                                        System.out.println("Pilihan Tipe : MACBOOK");
                                        System.out.println();
                                        
                                        harga = 25000000;
                                        tagihan = tagihan + harga  ; //memasukkan macbook ke dalam tagihan
                                        System.out.println("Tagihan :" + tagihan);
                                        data.get(l).add("Macbook");

                                        Macbook.pop();
                                        System.out.println("SISA STOK : "+ Macbook.size());
                                        System.out.println("");
                                    }
                                    else{
                                        System.out.println("Maaf Stok Macbook Kosong ");
                                    }
                                    
                                    break;

                                default :
                                System.out.println("Jenis Laptop tersebut tidak ada!");
                            }

                    } 
                    else{
                        System.out.println("Silahkan ambil antrian terlebih dahulu");
                    }          
                    break;

                case 4: //codingan pembayaran
                    System.out.println("==========================================");
                    if (pelanggan.size() >= 1) {
                        System.out.println("Pembayaran!!");
                        System.out.println("Pelanggan atas nama : " + pelanggan.poll());
                        System.out.println("Tagihan anda sebesar : Rp " + tagihan);
                        System.out.println("Silahkan melakukan pembayaran"); 

                        pendapatan = pendapatan + tagihan;
                        System.out.println("\n");
                        System.out.println("Terima kasih telah berbelanja di toko kami");
                        System.out.println("==========================================");
                        System.out.println("");
                        tagihan = 0;
                        l++ ;

                    } else {
                        System.out.println("Maaf, tidak ada pelanggan");
                        System.out.println("==========================================");
                        System.out.println("");
                    }
                    break;

                case 5: //codingan data hasil penjualan
                    System.out.println("Pendapatan Hari Ini : Rp " + pendapatan);
                    System.out.println("Data Penjualan Hari Ini :  " + data);
                    
                    break;
                    
                case 6: //codingan toko tutup
                    System.exit(0);
                    break;
                
                default: //jika pelanggan salah memasukkan angka
                System.out.println("==========================================");
                System.err.println("Pilihan Anda Salah");
                System.out.println("==========================================");
                System.out.println("");
                        
            }
        }
        while(bool);

    }

}

