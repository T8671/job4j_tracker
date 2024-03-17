package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private Item[] result = new Item[items.length];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (key.equals(item.getName())) {
                result[count] = item;
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    public Item findById(int id) {
        int i = indexOf(id);
        return i != -1 ? items[i] : null;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                result = i;
                break;
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        int i = indexOf(id);
        boolean result = i != -1;
        if (result) {
            item.setId(id);
            items[i] = item;
        }
        return result;
    }

    public void delete(int id) {
        int i = indexOf(id);
        boolean result = i != -1;
        if (result) {
            int start = i + 1;
            int distPos = i;
            int length = size - i - 1;
            System.arraycopy(items, start, items, distPos, length);
            items[size - 1] = null;
            size--;
        }
    }
}