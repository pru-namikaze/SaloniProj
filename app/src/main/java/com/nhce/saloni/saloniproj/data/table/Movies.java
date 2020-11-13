package com.nhce.saloni.saloniproj.data.table;

import com.nhce.saloni.saloniproj.data.model.Movie;
import com.nhce.saloni.saloniproj.data.persistence.operations.RealTimeDatabaseFirebase;

public class Movies extends RealTimeDatabaseFirebase {
    public static Movies movieTable = null;

    private Movies(){
        super("Title", Movie.class);
    }

    public static Movies getInstance(){
        return movieTable == null? new Movies(): movieTable;
    }
}
