/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dao;

import com.admin.entities.TypeOper;
import javax.ejb.Stateless;


/**
 *
 * @author firok
 */
@Stateless
public class TypeOperDAOBean extends BaseDAOBean<TypeOper, String> implements TypeOperDAOBeanLocal {

    public TypeOperDAOBean() {
        super(TypeOper.class);
    }

    
}
