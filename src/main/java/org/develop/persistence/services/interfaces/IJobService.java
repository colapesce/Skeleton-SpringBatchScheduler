package org.develop.persistence.services.interfaces;

import java.util.List;

import org.develop.persistence.entities.config.JobModel;

public interface IJobService {

	public JobModel saveSample();
	public JobModel loadByName(String name);	
	public List<JobModel> loadAll();
	
}
