package com.shehroze.atm.bank;
import com.shehroze.atm.ActionResult;
import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<Integer, Account> accounts = new HashMap<>();

    public Bank() {
        accounts.put(1000, new BasicAccount(new AccountData(
                1000, "Muhammad Shahroze", "shehroze.safdar@gmail.com", 500
        )));

        accounts.put(2000, new PremiumAccount(new AccountData(
                2000, "Huzaifa Umer", "huzaifa_umer@gmail.com", 200
        )));
    }

    public ActionResult<AccountData> getAccountById(int id) {
        Account account = accounts.get(id);

        if (account != null) {
            return ActionResult.success(account.getAccountData());
        } else {
            return ActionResult.fail("No account with id: " + id);
        }
    }

    public ActionResult<AccountData> deposit(AccountData accountData, int amount) {
        Account account = accounts.get(accountData.getId());
        account.deposit(amount);

        return ActionResult.success(account.getAccountData());
    }

    public ActionResult<AccountData> withdraw(AccountData accountData, int amount) {
        Account account = accounts.get(accountData.getId());
        boolean ok = account.withdraw(amount);

        if (ok) {
            return ActionResult.success(account.getAccountData());
        } else {
            return ActionResult.fail("Withdraw failed: " + amount + ". Account has: " + account.getBalance());
        }
    }
}
