Feature: ServiceNow Incident Management

Scenario: create an incident

Given set the endpoint
And add the auth
And add the queryParams as "sysparm_fields" and "category,short_description,sys_id,urgency,approval,knowledge,number"
When post the request as "Creating Incident" and category as "hardware"
Then validate the response for below
|result.urgency|3|
|result.approval|not requested|
|result.knowledge|false|
|result.number|INC|






