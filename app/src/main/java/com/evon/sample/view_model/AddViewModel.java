package com.evon.sample.view_model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;

import com.evon.sample.room_database.dao.AppDatabase;
import com.evon.sample.room_database.entity.Model;


/**
 * The type Add view model.
 */
public class AddViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;

    /**
     * Instantiates a new Add view model.
     *
     * @param application the application
     */
    public AddViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());

    }

    /**
     * Add item.
     *
     * @param model the model
     */
    public void addItem(final Model model) {
        new addAsyncTask(appDatabase).execute(model);
    }

    private static class addAsyncTask extends AsyncTask<Model, Void, Void> {

        private AppDatabase db;

        /**
         * Instantiates a new Add async task.
         *
         * @param appDatabase the app database
         */
        addAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final Model... params) {
            db.itemAndPersonModel().addItem(params[0]);
            return null;
        }

    }
}
