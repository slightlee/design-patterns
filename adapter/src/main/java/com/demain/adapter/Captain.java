package com.demain.adapter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Captain uses {@link RowingBoat} to sail. <br> This is the client in the pattern.
 * 船长使用{@link RowingBoat}航行。
 */
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class Captain {

    private RowingBoat rowingBoat;

    void row() {
        rowingBoat.row();
    }

}
