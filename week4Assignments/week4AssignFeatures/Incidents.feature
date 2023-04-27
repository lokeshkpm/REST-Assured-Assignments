Feature: ServiceNow Incident Creation Management

Scenario Outline: Create three incidents using the same scenario

Given set the endpoint
And add the auth
And add the queryParams as "sysparm_fields" and "category, short_description"
When post the request with short description as "<short_desc>" and category as "<category>"
Then validate the response "<short_desc>" and "<category>" and "<key>"

Examples:
 |short_desc|category|key|
# 1st data row
 |This is First|software|1|
# 2nd data row
 |This is Second|hardware|2|
# 3rd data row
 |This is Third|inquiry|3|

 
 