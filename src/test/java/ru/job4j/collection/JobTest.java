package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {

    @Test
    public void whenComparatorAscByName() {
        Comparator<Job> comparatorAscByName = new JobAscByName();
        int rsl = comparatorAscByName.compare(
                new Job("Petr", 1),
                new Job("Ivan", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscByPriority() {
        Comparator<Job> comparatorAscByPriority = new JobAscByPriority();
        int rsl = comparatorAscByPriority.compare(
                new Job("Petr", 1),
                new Job("Ivan", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> comparatorDescByName = new JobDescByName();
        int rsl = comparatorDescByName.compare(
                new Job("Petr", 1),
                new Job("Ivan", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> comparatorDescByPriority = new JobDescByPriority();
        int rsl = comparatorDescByPriority.compare(
                new Job("Petr", 1),
                new Job("Ivan", 2)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorByNameAndPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorByPriorityAndNameDesc() {
        Comparator<Job> cmpPriorityName = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpPriorityName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}