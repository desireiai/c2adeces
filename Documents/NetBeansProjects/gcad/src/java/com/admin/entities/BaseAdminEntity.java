/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.entities;

import java.io.Serializable;
import javax.persistence.Version;

/**
 *
 * @author BATE
 */
public abstract class BaseAdminEntity implements Serializable {

    @Version
    protected Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
