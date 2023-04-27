Feature: ServiceNow Incident Management

@Sanity
Scenario: Get all the Incidents with Query Parameter2 hardware

Given set the endpoint
And add the auth
And add the queryParams
|sysparm_fields|description,category|
|category|hardware|
When send the request with QP
Then validate the response


