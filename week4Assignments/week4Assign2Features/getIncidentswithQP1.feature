Feature: ServiceNow Incident Management

@Sanity
Scenario: Get all the Incidents with Query Parameter1 software

Given set the endpoint
And add the auth
And add the queryParams
|sysparm_fields|sys_id,category|
|category|software|
When send the request with QP
Then validate the response


