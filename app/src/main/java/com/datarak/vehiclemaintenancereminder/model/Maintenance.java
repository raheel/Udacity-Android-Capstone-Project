
package com.datarak.vehiclemaintenancereminder.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Maintenance {

    @SerializedName("actionHolder")
    @Expose
    private List<ActionHolder> actionHolder = new ArrayList<ActionHolder>();

    /**
     * 
     * @return
     *     The actionHolder
     */
    public List<ActionHolder> getActionHolder() {
        return actionHolder;
    }

    /**
     * 
     * @param actionHolder
     *     The actionHolder
     */
    public void setActionHolder(List<ActionHolder> actionHolder) {
        this.actionHolder = actionHolder;
    }

}
