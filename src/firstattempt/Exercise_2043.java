package firstattempt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class Bank {
    private List<BigDecimal> balance = new ArrayList<>();

    public Bank(long[] balance) {
        for (long value : balance) {
            this.balance.add(BigDecimal.valueOf(value));
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        account1--;
        account2--;

        if(balance.get(account1).compareTo(BigDecimal.valueOf(money)) < 0) return false;

        balance.set(account1, balance.get(account1).subtract(BigDecimal.valueOf(money)));
        balance.set(account2, balance.get(account2).add(BigDecimal.valueOf(money)));
        return true;
    }

    public boolean deposit(int account, long money) {
        account--;

        balance.set(account, balance.get(account).add(BigDecimal.valueOf(money)));
        return true;
    }

    public boolean withdraw(int account, long money) {
        account--;

        if(balance.get(account).compareTo(BigDecimal.valueOf(money)) < 0) return false;

        balance.set(account, balance.get(account).subtract(BigDecimal.valueOf(money)));
        return true;
    }

    public void printBalance() {
        System.out.println(balance);
    }
}

public class Exercise_2043 {
    public static void main(String[] args) {
        Bank bank = new Bank(new long[] {10, 100, 20, 50, 30});
        bank.printBalance();

        System.out.println(bank.transfer(1, 2, 10));
        bank.printBalance();

        bank.withdraw(3, 20);
        bank.printBalance();

        bank.deposit(2, 10);
        bank.printBalance();
    }
}
