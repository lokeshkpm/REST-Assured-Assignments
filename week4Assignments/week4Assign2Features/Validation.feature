Feature: ServiceNow Incident Management

@Smoke @Sanity
Scenario: Get all the incidents with validation as software

Given set the endpoint
And add the auth
Given add the queryParams as "sysparm_fields" and "sys_id, number, category"
Given add the queryParams
|sysparm_fields	|sys_id, number, category	|
|category|software|
When send the request
Then validate the response as 200



