package proj_SistemaPasaporte;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Playground {
    

    public static void main(String[] args) {
        String inpuString = "2025-03-10";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        LocalDate inputdaDate = LocalDate.parse(inpuString);
        LocalDate currDate = LocalDate.now();
        if (currDate.isBefore(inputdaDate)) {
            System.out.println("HOla sisisi fue antes");
        } else {
            System.out.println("HOla nonono fue después ¿Qué empalo?");
        }
    }
}
