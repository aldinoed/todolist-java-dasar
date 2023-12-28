import java.util.Scanner;

public class ToDoList {
    public static String[] model= new String[10];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }
    public static String input(String info){
        System.out.println("TODOLIST");
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }
    public static void showTodoList(){
        int counter = 0;
        for(var item : model){
            if(item != null){
                System.out.println(++counter + ". " + item);
            }
        }
    }
    public static void viewShowTodoList(){

        while(true){
            showTodoList();

            System.out.println("\nMENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

           if(input.equals("1")){
               viewAddTodoList();
           }else if(input.equals("2")){
               viewRemoveTodoList();
           }else if(input.equals("x")){
               break;
           }else{
               System.out.println("Invalid Input!");
           }
        }
    }

    public static void viewAddTodoList(){
        System.out.println("\nMENAMBAH TODOLIST");

        String todo = input("Todo (Tekan x jika batal)");
        if(todo.equals("x")){
            viewShowTodoList();
        }else{
            addTodoList(todo);
        }
    }
    public static void addTodoList(String todo){
        var isFull = true;

//        Cek apakah model penuh
        for(var item : model){
            if(item == null){
                isFull = false;
                break;
            }
        }

//        jika penuh ukuran model resize 2x
        if(isFull){
            var temp = model;
            model = new String[model.length * 2];

            for(int i = 0; i < temp1.length; i++){
                model[i] = temp[i];
            }
        }

//        Tambah data di posisi yang NULL
        for(int i = 0; i < model.length; i++){
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    public static void viewRemoveTodoList(){
        System.out.println("Menghapus ToDo List");

        var input = input("Nomor yang Ingin Dihapus (x Jika Batal)");

        if(input.equals("x")){
            viewShowTodoList();
        }else{
            boolean success = removeTodoList(Integer.valueOf(input));
            if(!success){
                System.out.println("Gagal menghapus todolist : " + input);
            }
        }
    }

    public static boolean removeTodoList(int number){
        if((number - 1) >= (model.length) || (number - 1 < 0)){
            return false;
        }else if(model[number - 1] == null){
            return false;
        }else{
            for(int i = (number - 1); i < model.length; i++){
                if(i == (model.length - 1)){
                    model[i] = null;
                }else{
                    model[i] = model[i+1];
                }
            }
            return true;
        }
    }
}
