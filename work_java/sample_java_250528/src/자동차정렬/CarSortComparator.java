package 자동차정렬;

import java.util.Comparator;

public class CarSortComparator implements Comparator<CarSortInfo> {
    @Override
    public int compare(CarSortInfo o1, CarSortInfo o2) {
        return o1.carName.compareTo(o2.carName);
    }

    @Override
    public Comparator<CarSortInfo> reversed() {
        return Comparator.super.reversed();
    }
}
