import java.util.Scanner;
public class Main {
//    field
    public static Scanner scanner = new Scanner(System.in);
    public static String model[] = new String[10];
    public static void main(String[] args){
        methodTesting();

    }
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
        var isFull = true;
        for (var i=0; i< model.length; i++){
            if (model[i] == null){
                isFull = false;
                break;
            }
        }
        if (isFull){
            var temp = model;
            model = new String[model.length * 2];
            for (var i=0; i<temp.length; i++){
                model[i] = temp[i];
            }
        }
        for (var i=0; i<model.length; i++){
            if (model[i] == null){
                model[i] = data;
                break;
            }
        }
    }
    public static String iptStr(String message){
        System.out.print("| >> "+message+" : ");
        return scanner.nextLine();
    }
    public static boolean removeData(int number){
        if ((number - 1) < 0 || (number - 1) > model.length) {
            return false;
        }else {
            model[number - 1] = null;
            return true;

            for (var i=0; i<model.length; i++){
                if (model[i-1] == null){
                    model[i-1] = model[i];
                }
            }
        }
    }
    public static void methodTesting(){
        for (var i=0; i<5; i++){
            var ipt = iptStr("Masukkan Data").toUpperCase();
            addData(ipt);
        }
        removeData(2);
        showData();
    }
}
