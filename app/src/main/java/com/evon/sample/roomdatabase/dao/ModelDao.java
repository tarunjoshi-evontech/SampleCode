package com.evon.sample.roomdatabase.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.evon.sample.roomdatabase.entity.Model;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * The dao interface for {@link Model} entity
 */
@Dao
public interface ModelDao {

    /**
     * Gets all items.
     *
     * @return the all items
     */
    @Query("select * from Model")
    LiveData<List<Model>> getAllItems();

    /**
     * Gets itemby id.
     *
     * @param id the id
     * @return the itemby id
     */
    @Query("select * from Model where id = :id")
    Model getItembyId(String id);

    /**
     * Add item.
     *
     * @param model the model
     */
    @Insert(onConflict = REPLACE)
    void addItem(Model model);

    /**
     * Delete item.
     *
     * @param model the model
     */
    @Delete
    void deleteItem(Model model);

}
