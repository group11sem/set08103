# USE CASE: Creating report of all the capital cities in a region

## CHARACTERISTIC INFORMATION

### Goal in Context

As a member of the organization, I want to be able to generate a list of all the capital cities in a region organized from largest to smallest population

### Scope

Company.

### Level

Primary task.

### Preconditions

We have a database with all the capital cities and their populations

### Success End Condition

A report is available for the user with capital cities in a region listed largest to smallest population

### Failed End Condition

No report is produced.

### Primary Actor

Organization User

### Trigger

Someone wants to know census data on capital cities in a region

## MAIN SUCCESS SCENARIO

1. Organization user wants to generate list of capital cities in a region
2. User extracts a list of capital cities in a region listed from largest to smallest population

## EXTENSIONS

3. **Database contain all cities**:
    1. Database might not be up to date if a new capital city is created.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 0.1.0.9