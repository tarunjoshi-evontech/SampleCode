package com.evon.sample.view_model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.evon.sample.room_database.dao.AppDatabase;
import com.evon.sample.room_database.entity.Model;

import java.util.List;


/**
 * The type List view model.
 */
public class ListViewModel extends AndroidViewModel {

    private final LiveData<List<Model>> itemAndPersonList;

    private AppDatabase appDatabase;

    /**
     * Instantiates a new List view model.
     *
     * @param application the application
     */
    public ListViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());

        itemAndPersonList = appDatabase.itemAndPersonModel().getAllItems();
    }


    /**
     * Gets item and person list.
     *
     * @return the item and person list
     */
    public LiveData<List<Model>> getItemAndPersonList() {
        return itemAndPersonList;
    }

}
