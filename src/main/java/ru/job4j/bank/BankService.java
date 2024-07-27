package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу модели для банковской системы - Банковские переводы.
 * В системе можно производить следующие действия:
 * 1. Регистрировать пользователя;
 * 2. Удалять пользователя из системы;
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов;
 * 4. Переводить деньги с одного банковского счета на другой счет;
 *
 * @author Teymur Azimov
 * @version 1.0
 */
public class BankService {
    /**
     * Это поле содержит всех пользователей системы с привязанными к ним счетами
     * Хранение информации осуществляется в коллекции типа Map<User, List<Account>>
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему.
     * Этот метод добавляет нового пользователя в систему, если его еще нет в карте пользователей.
     * Метод использует putIfAbsent для предотвращения дублирования пользователей.
     *
     * @param user пользователь, который будет добавлен в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя из системы.
     * Удаление происходит по уникальному идентификатору пользователя - паспорту.
     *
     * @param passport уникальный идентификатор пользователя, по которому будет выполнено удаление
     */
    public void deleteUser(String passport) {
        for (User user : users.keySet()) {
            users.remove(new User(passport, ""));
        }
    }

    /**
     * Метод добавляет новый счет к пользователю.
     * Для поиска пользователя используется уникальный идентификатор пользователя - паспорт.
     * Для поиска пользвателя используется метод findByPassport.
     * В методе присутствует проверка дублирования счетов.
     *
     * @param passport уникальный идентификатор пользователя, по которому осуществляется поиск пользователя
     * @param account  новый счет пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по уникальному идентификатору - номеру паспорта.
     *
     * @param passport уникальный идентификатор (паспорт)
     * @return возвращает уникальный идентификатор (паспорт), либо null, в случае его отсутствия
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет пользователя по реквизитам.
     * Сначала нужно найти пользователя по паспорту с помощью метода findByPassport.
     * Потом получить список счетов этого пользователя и в нем найти нужный счет.
     * Поскольку метод findByPassport может вернуть null, внедрена проверка на != null.
     *
     * @param passport  уникальный идентификатор (паспорт)
     * @param requisite реквизиты счета
     * @return возвращает уникальный идентификатор (паспорт) по реквизитам, либо null, в случае его отсутствия
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт.
     *
     * @param sourcePassport       паспорт отправителя (источника средств)
     * @param sourceRequisite      реквизиты счета отправителя
     * @param destinationPassport  паспорт получателя (назначения средств)
     * @param destinationRequisite реквизиты счета получателя
     * @param amount               сумма перевода
     * @return Если счёт не найден или не хватает денег на счёте sourcePassport (с которого переводят), возвращается false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account srcAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destAccount = findByRequisite(destinationPassport, destinationRequisite);

        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}