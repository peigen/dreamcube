/*
 * dreamcube.com Inc.
 * Copyright (c) 2010 All Rights Reserved.
 */
package com.dreamcube.core.dal.daointerface;

// auto generated imports
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dreamcube.core.common.tools.PageList;

import com.dreamcube.core.dal.dataobject.DcSquadDO;

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
     *  <tt>insert into dc_squad(squad_name,squad_desc,axiser,cubers,followers,investors,status,gmt_create,gmt_modify,attention) values (?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, ?)</tt>
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
     *  <tt>select * from dc_squad</tt>
     *
     *	@return List<DcSquadDO>
     *	@throws DataAccessException
     */
    public List<DcSquadDO> load() throws DataAccessException;

    /**
     *  Query DB table <tt>dc_squad</tt> for records.
     *
     *  <p>
     *  The sql statement for this operation is <br>
     *  <tt>select * from dc_squad where (id = ?)</tt>
     *
     *	@param id
     *	@return DcSquadDO
     *	@throws DataAccessException
     */
    public DcSquadDO loadById(long id) throws DataAccessException;

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
     *  Update DB table <tt>dc_squad</tt>.
     *
     *  <p>
     *  The sql statement for this operation is <br>
     *  <tt>update dc_squad set squad_name=?, squad_desc=?, axiser=?, cubers=?, followers=?, investors=?, status=?, gmt_modify=CURRENT_TIMESTAMP where (id = ?)</tt>
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

    /**
     *  Query DB table <tt>dc_squad</tt> for records.
     *
     *  <p>
     *  The sql statement for this operation is <br>
     *  <tt>select * from dc_squad where ((squad_name = ?) AND (axiser = ?) AND (cubers = ?) AND (followers = ?) AND (investors = ?) AND (status = ?) AND (gmt_create = ?) AND (gmt_modify = ?))</tt>
     *
     *	@param squadName
     *	@param axiser
     *	@param cubers
     *	@param followers
     *	@param investors
     *	@param status
     *	@param gmtCreate
     *	@param gmtModify
     *	@param pageSize
     *	@param pageNum
     *	@return PageList
     *	@throws DataAccessException
     */
    public PageList query(String squadName, String axiser, String cubers, String followers,
                          String investors, String status, Date gmtCreate, Date gmtModify,
                          int pageSize, int pageNum) throws DataAccessException;

    /**
     *  Update DB table <tt>dc_squad</tt>.
     *
     *  <p>
     *  The sql statement for this operation is <br>
     *  <tt>update dc_squad set attention=? where (id = ?)</tt>
     *
     *	@param attention
     *	@param id
     *	@return int
     *	@throws DataAccessException
     */
    public int updateAttention(long attention, long id) throws DataAccessException;

}