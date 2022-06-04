import java.util.Scanner;

public class Node_12 {
    String namaPembeli, NoHp;
    int kodePesanan;
    String namaPesanan;
    int harga;
    Node_12 prev, next;

    Node_12(Node_12 prev, String namaPembeli, String NoHp, int kodePesanan, String namaPesanan, int harga, Node_12 next){
        this.prev = prev;
        this.namaPembeli = namaPembeli;
        this.NoHp = NoHp;
        this.kodePesanan = kodePesanan;
        this.namaPesanan = namaPesanan;
        this.harga = harga;
        this.next = next;
    }

class Pembeli{
    String namaPembeli, NoHp;
    Pembeli prev, next;

    Pembeli(Pembeli prev, String b, String c, Pembeli next){
        this.prev = prev;
        namaPembeli = b;
        NoHp = c;
        this.next = next;
    }
}

class Pesanan{
    int kodePesanan;
    String namaPesanan;
    int harga;
    Pembeli prev, next;

    Pesanan(Pembeli prev, int a, String b, int d, Pembeli next){
        this.prev = prev;
        kodePesanan = a;
        namaPesanan = b;
        harga = d;
        this.next = next;
    }
}

class Node_12_DoubleLinkedLists{
    Node_12 front, rear;
    int size;

    void Node_12_DoubleLinkedList(){
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public void Enqueue(String namaPembeli, String NoHp, int kodePesanan, String namaPesanan, int harga){
        Node_12 newNode = new Node_12(null, namaPembeli, NoHp, kodePesanan, namaPesanan, harga, null);
        if(isEmpty()){
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public void Dequeue() throws Exception {
        if(isEmpty()){
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        }else{
            System.out.println(front.namaPembeli + " telah memesan Menu.");
            front = front.next;
            front.prev = null;
            size--;
        }
    }

    public void print(){
        if(!isEmpty()){
            Node_12 tmp = front;
            System.out.println();
            System.out.println("++++++++++++++++++++++++");
            System.out.println("Daftar Pengantri Vaksin");
            System.out.println("++++++++++++++++++++++++");
            System.out.println("|No.\t | Nama Customer \t | No. Hp \t|");
            while(tmp != null){
                System.out.println("|"+tmp.kodePesanan + "\t | " + tmp.namaPembeli + " |");
                tmp = tmp.next;
            }
            System.out.println("Total Antrian = " + size);
        }else{
            System.out.println("Linked List Kosong");
        }
    }

}

class Node_12Main{
    public static void menu(){
        System.out.println("Menu");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Cetak Antrian");
        System.out.println("3. Hapus Antrian");
        System.out.println("4. Laporan Pengurutan pesanan by nama");
        System.out.println("5. Hitung total Pendapatan");
        System.out.println("6. Keluar");
    }

    public static void main(String[] args)  {
        System.out.println("======= Quiz 2 PRAKTIKUM ASD TI - 1G dan TI - 1F =======");
        System.out.println("dibuat oleh : Iemaduddin");
        System.out.println("NIM         : 2141720055");
        System.out.println("Absen       : 12");
        System.out.println("========================================================");
        Scanner sc = new Scanner(System.in);
        int menu = 0;
        Node_12_DoubleLinkedLists dll = new Node_12_DoubleLinkedLists();

        do{
            System.out.println();
            menu();
            menu = sc.nextInt();
            switch (menu){
                case 1:
                    System.out.println("-----------------------------");
                    System.out.println("Masukkan Data Pembeli");
                    System.out.println("-----------------------------");
                    System.out.print("Nomor Antrian: ");
                    int noAntrian = sc.nextInt();
                    System.out.print("Nama Customer: ");
                    String namaPembeli = sc.nextLine();
                    System.out.print("Nomor HP: ");
                    String NoHp = sc.nextLine();
                    System.out.print("Nomor HP: ");
                    String namaPesanan = sc.nextLine();
                    System.out.print("Harga: ");
                    int harga = sc.nextInt();
                    dll.Enqueue(namaPembeli, NoHp, noAntrian, namaPesanan, harga);
                    break;
                case 2:
                    dll.Dequeue();
                    dll.print();
                    break;
                case 3:
                    dll.print();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("TERIMA KASIH...");
                    System.exit(0);
            }
        }while(menu > 0 && menu < 5);
    }
}
}
 