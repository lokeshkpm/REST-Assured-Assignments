Feature: ServiceNow Incident Management

@Smoke
Scenario: Get all Incidents

Given set the endpoint
And add the auth
When send the request
Then validate the response