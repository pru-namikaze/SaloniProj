package com.nhce.saloni.saloniproj.data.persistence.core;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RealTimeDatabaseFirebaseConfig<T> {

    protected HashMap<String, T> datatable;
    protected DatabaseReference databaseReference;

    protected RealTimeDatabaseFirebaseConfig(String pathFromRootNode){
        this.datatable = new HashMap<String, T>();
        this.databaseReference = FirebaseDatabase.getInstance().getReference().child(pathFromRootNode);
    }

    protected void setChildEventListener(final Class<T> serializeToClass){
    }
}
