package ru.job4j.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BankServiceTest {
    @Test
    void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434")).isEqualTo(user);
    }

    @Test
    void deleteUserIsTrue() {
        User first = new User("3434", "Petr Arsentev");
        User second = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(first);
        bank.addUser(second);
        bank.deleteUser("3434");
        assertThat(bank.findByPassport(first.getPassport())).isNull();
    }

    @Test
    void deleteUserIsFalse() {
        User first = new User("3434", "Petr Arsentev");
        User second = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(first);
        bank.addUser(second);
        bank.deleteUser("343434");
        assertThat(bank.findByPassport(first.getPassport())).isEqualTo(first);
    }

    @Test
    void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("34", "5546")).isNull();
    }

    @Test
    void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").getBalance()).isEqualTo(150D);
    }

    @Test
    void addAccountIsInvalid() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount("4343", new Account("5546", 150D));
        assertThat(bank.getAccounts(user)).isEmpty();
    }

    @Test
    void addDuplicateAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("5546", 500D));
        assertThat(bank.getAccounts(user).size()).isEqualTo(1);
    }

    @Test
    void transferMoneyOk() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        boolean result = bank.transferMoney(user.getPassport(), "5546",
                user.getPassport(), "113", 150D);
        assertThat(result).isTrue();
        assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance()).isEqualTo(200D);
    }

    @Test
    void transferMoneyOkCheckSourceAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "5546").getBalance()).isEqualTo(0D);
    }

    @Test
    void transferMoneySourceNull() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        boolean result = bank.transferMoney(user.getPassport(), "554",
                user.getPassport(), "113", 150D);
        assertThat(result).isFalse();
        assertThat(bank.findByRequisite(user.getPassport(), "5546").getBalance()).isEqualTo(150D);
    }

    @Test
    void transferMoneyDontHaveEnoughMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 300D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance()).isEqualTo(50D);
    }

    @Test
    void transferMoneyDestinationIsNull() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "1131", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "5546").getBalance()).isEqualTo(150D);
    }

    @Test
    public void whenUserExistsThenFindByPassportReturnsUser() {
        BankService bankService = new BankService();
        User user1 = new User("123456", "John Doe");
        bankService.addUser(user1);

        User foundUser = bankService.findByPassport("123456");
        assertThat(foundUser).isEqualTo(user1);
    }

    @Test
    public void whenUserDoesNotExistThenFindByPassportReturnsNull() {
        BankService bankService = new BankService();
        User user1 = new User("123456", "John Doe");
        bankService.addUser(user1);

        User foundUser = bankService.findByPassport("654321");
        assertThat(foundUser).isNull();
    }

    @Test
    public void whenNoUsersThenFindByPassportReturnsNull() {
        BankService bankService = new BankService();

        User foundUser = bankService.findByPassport("123456");
        assertThat(foundUser).isNull();
    }

    @Test
    public void whenAddingMultipleUserThenFindByPassportReturnsCorrectUser() {
        BankService bankService = new BankService();
        User user1 = new User("123456", "John Doe");
        User user2 = new User("654321", "Jane Doe");
        bankService.addUser(user1);
        bankService.addUser(user2);

        User foundUser1 = bankService.findByPassport("123456");
        User foundUser2 = bankService.findByPassport("654321");

        assertThat(foundUser1).isEqualTo(user1);
        assertThat(foundUser2).isEqualTo(user2);
    }
}