/*
 * dreamcube.com Inc.
 * Copyright (c) 2010 All Rights Reserved.
 */
package com.dreamcube.core.dal.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.dreamcube.core.dal.daointerface.DcSquadDAO;

// auto generated imports
import com.dreamcube.core.dal.dataobject.DcSquadDO;
import org.springframework.dao.DataAccessException;

/**
 * An ibatis based implementation of dao interface <tt>com.dreamcube.core.dal.daointerface.DcSquadDAO</tt>.
 *
 * This file is generated by <tt>dreamcube-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>paygw</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/dc_squad.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>dreamcubedalgen</tt> 
 * to generate this file.
 *
 * @author peigen
 */
public class IbatisDcSquadDAO extends SqlMapClientDaoSupport implements DcSquadDAO {
	/**
	 *  Insert one <tt>DcSquadDO</tt> object to DB table <tt>dc_squad</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into dc_squad(squad_name,squad_desc,axiser,cubers,followers,investors,status,gmt_create,gmt_modify) values (?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param dcSquad
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(DcSquadDO dcSquad) throws DataAccessException {
    	if (dcSquad == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-DC-SQUAD-INSERT", dcSquad);

        return dcSquad.getId();
    }

	/**
	 *  Query DB table <tt>dc_squad</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from dc_squad where (squad_name = ?)</tt>
	 *
	 *	@param squadName
	 *	@return DcSquadDO
	 *	@throws DataAccessException
	 */	 
    public DcSquadDO load(String squadName) throws DataAccessException {

        return (DcSquadDO) getSqlMapClientTemplate().queryForObject("MS-DC-SQUAD-LOAD", squadName);

    }

	/**
	 *  Update DB table <tt>dc_squad</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update dc_squad set squad_name=?, squadDesc=?, axiser=?, cubers=?, followers=?, investors=?, status=?, gmt_create=sysdate, gmt_modify=sysdate where (id = ?)</tt>
	 *
	 *	@param dcSquad
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(DcSquadDO dcSquad) throws DataAccessException {
    	if (dcSquad == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-DC-SQUAD-UPDATE", dcSquad);
    }

	/**
	 *  Delete records from DB table <tt>dc_squad</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete dc_squad</tt>
	 *
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int clean() throws DataAccessException {

        return getSqlMapClientTemplate().delete("MS-DC-SQUAD-CLEAN", null);
    }

}