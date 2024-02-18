# USE CASE: Creating report of N largest cities in a region

## CHARACTERISTIC INFORMATION

### Goal in Context

As a member of the organization, I want to be able to generate a list of N largest populated cities in a region where I would provide N

### Scope

Company.

### Level

Primary task.

### Preconditions

We have a database with all the cities in a region and their populations

### Success End Condition

A report is available for the user with N largest populated cities in a region where N is the number the user provided

### Failed End Condition

No report is produced.

### Primary Actor

Organization User

### Trigger

Someone wants to know census data on N largest cities in a region.

## MAIN SUCCESS SCENARIO

1. Organization user wants to generate list of N largest cities in a region by population
2. User extracts a list of N largest populated cities in a region where N is provided by the user

## EXTENSIONS

3. **Database contain all cities**:
    1. Database might not be up to date if a new city is created.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 0.1.0.8