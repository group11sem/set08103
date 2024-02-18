# USE CASE: Creating report of N largest captial cities in a region

## CHARACTERISTIC INFORMATION

### Goal in Context

As a member of the organization, I want to be able to generate a list of N largest populated capital cities in a region where N is provided

### Scope

Company.

### Level

Primary task.

### Preconditions

We have a database with all the capital cities and their populations

### Success End Condition

A report is available for the user with a list of N populated capital cities in a region where N is provided by the user.

### Failed End Condition

No report is produced.

### Primary Actor

Organization User

### Trigger

Someone wants to know census data on the top N popualted capital cities in a region.

## MAIN SUCCESS SCENARIO

1. Organization user wants to generate list of N top populated capital cities in a region use where N is provided by the user.
2. User extracts a list of N top populated capital cities in a continent

## EXTENSIONS

3. **Database contain all cities**:
    1. Database might not be up to date if a new capital city is created.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 0.1.0.10
