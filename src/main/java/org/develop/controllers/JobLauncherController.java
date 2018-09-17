package org.develop.controllers;

import org.codehaus.jettison.json.JSONObject;
import org.develop.batch.factory.JobFactory;
import org.develop.batch.listeners.JobCompletionNotificationListener;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "/job")
public class JobLauncherController {
	private static final String TIME = "time";
	private static final String JOB_NAME = "job";

	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private JobFactory jobFactory;
	@Autowired 
	JobCompletionNotificationListener jobListener;

	@RequestMapping(value = "/joblauncher.do", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void launchJob(@RequestBody String info) throws Exception {
		
		JSONObject parseJson = new JSONObject(info);
		JobParametersBuilder builder = extractParameters(parseJson);
		
		jobLauncher.run(jobFactory.getJob(parseJson.getString(JOB_NAME), jobListener), builder.toJobParameters());
	}

	private JobParametersBuilder extractParameters(JSONObject parseJson) throws Exception {
		JobParametersBuilder builder = new JobParametersBuilder();
		// org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException:
		// A job instance already exists and is complete for
		// parameters={job=executeTasklet}. If you want to run this job again, change
		// the parameters.
		builder.addLong(TIME, System.currentTimeMillis()).toJobParameters();
		builder.addString(JOB_NAME, parseJson.getString(JOB_NAME));
		return builder;
	}
}
