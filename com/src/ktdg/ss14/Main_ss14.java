package ktdg.ss14;

import ktdg.ss14.service.AccountService;
import java.math.BigDecimal;

public class Main_ss14 {
    public static void main(String[] args) {
        AccountService service = new AccountService();

        System.out.println("TRUOC KHI GIAO DICH:");
        service.displayAllAccounts();

        System.out.println("\n--> Dang thuc hien chuyen khoan 1000 tu ACC01 sang ACC02...");
        service.transferMoney("ACC01", "ACC02", new BigDecimal("1000"));

        System.out.println("\n--> Dang thuc hien chuyen khoan 10000 tu ACC01 sang ACC02 (Qua so du)...");
        service.transferMoney("ACC01", "ACC02", new BigDecimal("10000"));

        service.displayAllAccounts();
    }
}
