package org.develop.persistence.dao.impl;

import org.develop.persistence.dao.interfaces.IJobDao;
import org.develop.persistence.entities.config.JobModel;
import org.springframework.stereotype.Repository;

@Repository
public class JobDao extends BaseDao<JobModel, String> implements IJobDao {

}
