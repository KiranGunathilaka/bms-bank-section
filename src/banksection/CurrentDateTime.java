package banksection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class CurrentDateTime {

    public static void main(String[] args) {
        time();
    }

    public static String time() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time = dtf.format(now);
        System.out.println(time);
        return time;
    }
}
