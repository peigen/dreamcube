/*
 * dreamcube.com Inc.
 * Copyright (c) 2010 All Rights Reserved.
 */
package com.dreamcube.core.dal.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.dreamcube.core.dal.daointerface.DcUserDAO;

// auto generated imports
import com.dreamcube.core.dal.dataobject.DcUserDO;
import org.springframework.dao.DataAccessException;
import java.util.List;


/**
 * An ibatis based implementation of dao interface <tt>com.dreamcube.core.dal.daointerface.DcUserDAO</tt>.
 *
 * This file is generated by <tt>dreamcube-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>paygw</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/dc_user.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>dreamcubedalgen</tt> 
 * to generate this file.
 *
 * @author peigen
 */
@SuppressWarnings("unchecked")
public class IbatisDcUserDAO extends SqlMapClientDaoSupport implements DcUserDAO {
	/**
	 *  Insert one <tt>DcUserDO</tt> object to DB table <tt>dc_user</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into dc_user(logon_name,logon_passwd,nick_name,birthday,cert_no,gender,work_site,projects,info_site,gmt_create,gmt_modify,status) values (?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, ?)</tt>
	 *
	 *	@param dcUser
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(DcUserDO dcUser) throws DataAccessException {
    	if (dcUser == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-DC-USER-INSERT", dcUser);

        return dcUser.getId();
    }

	/**
	 *  Query DB table <tt>dc_user</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from dc_user</tt>
	 *
	 *	@return List<DcUserDO>
	 *	@throws DataAccessException
	 */	 
    public List<DcUserDO> load() throws DataAccessException {

        return getSqlMapClientTemplate().queryForList("MS-DC-USER-LOAD", null);

    }

	/**
	 *  Query DB table <tt>dc_user</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from dc_user where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return DcUserDO
	 *	@throws DataAccessException
	 */	 
    public DcUserDO loadById(long id) throws DataAccessException {
        Long param = new Long(id);

        return (DcUserDO) getSqlMapClientTemplate().queryForObject("MS-DC-USER-LOAD-BY-ID", param);

    }

	/**
	 *  Query DB table <tt>dc_user</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from dc_user where (logon_name = ?)</tt>
	 *
	 *	@param logonName
	 *	@return DcUserDO
	 *	@throws DataAccessException
	 */	 
    public DcUserDO loadByLogonName(String logonName) throws DataAccessException {

        return (DcUserDO) getSqlMapClientTemplate().queryForObject("MS-DC-USER-LOAD-BY-LOGON-NAME", logonName);

    }

	/**
	 *  Update DB table <tt>dc_user</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update dc_user set logon_passwd=?, nick_name=?, birthday=?, cert_no=?, gender=?, work_site=?, projects=?, info_site=?, status=?, gmt_modify=CURRENT_TIMESTAMP where (id = ?)</tt>
	 *
	 *	@param dcUser
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(DcUserDO dcUser) throws DataAccessException {
    	if (dcUser == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-DC-USER-UPDATE", dcUser);
    }

	/**
	 *  Delete records from DB table <tt>dc_user</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from dc_user where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteById(long id) throws DataAccessException {
        Long param = new Long(id);

        return getSqlMapClientTemplate().delete("MS-DC-USER-DELETE-BY-ID", param);
    }

}