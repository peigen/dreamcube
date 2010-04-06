/*
 * dreamcube.com Inc.
 * Copyright (c) 2010 All Rights Reserved.
 */
package com.dreamcube.core.dal.daointerface;

// auto generated imports
import com.dreamcube.core.dal.dataobject.DcSquadDO;
import org.springframework.dao.DataAccessException;
import java.util.List;

/**
 * A dao interface provides methods to access database table <tt>dc_squad</tt>.
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
public interface DcSquadDAO {
	/**
	 *  Insert one <tt>DcSquadDO</tt> object to DB table <tt>dc_squad</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into dc_squad(squad_name,squad_desc,axiser,cubers,followers,investors,status,gmt_create,gmt_modify) values (?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)</tt>
	 *
	 *	@param dcSquad
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(DcSquadDO dcSquad) throws DataAccessException;

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
    public DcSquadDO loadByName(String squadName) throws DataAccessException;

	/**
	 *  Query DB table <tt>dc_squad</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from dc_squad</tt>
	 *
	 *	@return List<DcSquadDO>
	 *	@throws DataAccessException
	 */	 
    public List<DcSquadDO> load() throws DataAccessException;

	/**
	 *  Update DB table <tt>dc_squad</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update dc_squad set squad_name=?, squadDesc=?, axiser=?, cubers=?, followers=?, investors=?, status=?, gmt_create=CURRENT_TIMESTAMP, gmt_modify=CURRENT_TIMESTAMP where (id = ?)</tt>
	 *
	 *	@param dcSquad
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(DcSquadDO dcSquad) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>dc_squad</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from dc_squad where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteById(long id) throws DataAccessException;

}