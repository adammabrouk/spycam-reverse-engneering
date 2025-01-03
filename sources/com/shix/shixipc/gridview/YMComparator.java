package com.shix.shixipc.gridview;

import java.util.Comparator;

/* loaded from: classes.dex */
public class YMComparator implements Comparator<GridItem> {
    @Override // java.util.Comparator
    public int compare(GridItem gridItem, GridItem gridItem2) {
        int compareTo = gridItem.getTime().compareTo(gridItem2.getTime());
        if (compareTo > 0) {
            return -1;
        }
        return compareTo == 0 ? 0 : 1;
    }
}
