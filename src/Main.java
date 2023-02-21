import java.util.Scanner;
public class Main {
//    field
    public static Scanner scanner = new Scanner(System.in);
    public static String model[] = new String[10];
    public static void main(String[] args){
        methodTesting();

    }
//    tampilkan semua elemen dalam array yang tidak null
    public static void showData(){
        for (var i=0; i<model.length; i++){
            var data = model[i];
            var no = i+1;
            if (model[i] != null){
                System.out.println("| >> "+no+". "+data);
            }
        }
    }
    public static void addData(String data){
//        cek kapasitas array
        var isFull = true;
        for (var i=0; i< model.length; i++){
            if (model[i] == null){
                isFull = false;
                break;
            }
        }
//        resize array
        if (isFull){
            var temp = model;
            model = new String[model.length * 2];
            for (var i=0; i<temp.length; i++){
                model[i] = temp[i];
            }
        }
//        kalau elemennya null isi dengan data
        for (var i=0; i<model.length; i++){
            if (model[i] == null){
                model[i] = data;
                break;
            }
        }
    }
//    inputan untuk menerima data tipe data string
    public static String iptStr(String message){
        System.out.print("| >> "+message+" : ");
        return scanner.nextLine();
    }
//    inputan untuk menerima tipe data integer
    public static int iptInt(String message){
        System.out.print("| >> "+message+" : ");
        int i = scanner.nextInt();
        return i;
    }
    public static boolean removeData(int number){
//        kalau inputan - 1 lebih kecil dari 0 atau lebih besasr dari panjang array atau kosong maka kembalikan ke false
        if (((number - 1) >= model.length) || ((number - 1) < 0) || (model[number - 1] == null)){
            return false;
        }else{
//            baca semua elemen mulai dari inputan number - 1 sampai panjang array
            for (var i=(number-1); i< model.length; i++){
//                kalau i (number - 1) sama dengan panjang array - 1 maka kosongkan pilihannya
                if (i == (model.length - 1)){
                    model[i] = null;
//                    selain itu geser data yang tidak null keatas
                }else{
                    model[i] = model[i+1];
                }
            }
            return true;
        }
    }
    public static void methodTesting(){
        for (var i=0; i<5; i++){
            var ipt = iptStr("Masukkan Data").toUpperCase();
            addData(ipt);
        }
        for (var i=0; i<3; i++){
            var iptNum = iptInt("Masukan nomor data yang ingin dihapus");
            removeData(iptNum);
        }
        showData();
    }
}
