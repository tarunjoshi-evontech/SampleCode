package com.evon.sample.room_database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * The type Model.
 */
@Entity
public class Model {

    /**
     * The Id.
     */
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String itemName;
    private String personName;


    /**
     * Instantiates a new Model.
     *
     * @param itemName   the item name
     * @param personName the person name
     */
    public Model(String itemName, String personName) {
        this.itemName = itemName;
        this.personName = personName;
    }

    /**
     * Gets item name.
     *
     * @return the item name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Gets person name.
     *
     * @return the person name
     */
    public String getPersonName() {
        return personName;
    }

}
