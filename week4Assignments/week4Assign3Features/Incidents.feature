Feature: ServiceNow Incident Management

Scenario: Create Incident

When post the request with short description as "Creating Incident" and category as "hardware"
Then validate the response as 201
Then validate the response for task_effective_number

Scenario: Update Incident

And update the description with randomString 
Then validate the response as 200
Then validate the response for description is updated

Scenario: Delete Incident

When get the incident for delete 
Then send the request for delete
Then validate the response as 204
And validate the record is removed

 
 