# USE CASE: Creating report of all countries in a region

## CHARACTERISTIC INFORMATION

### Goal in Context

As a member of the organization, I want to be able to generate a list of all the countries in a region organized by population from largest to smallest

### Scope

Organization.

### Level

Primary task.

### Preconditions

We have a database with all the countries in a region and their populations

### Success End Condition

A report is available for the user with all the countries in a region listed by largest to smallest population

### Failed End Condition

No report is produced.

### Primary Actor

Organization User

### Trigger

Someone wants to know census data on every country in a region.

## MAIN SUCCESS SCENARIO

1. Organization user wants to generate list of all the countries in a region by population
2. User extracts a list of all the countries in a region and their populations in order from largest to smallest population

## EXTENSIONS

3. **Database contain all countries**:
    1. Database might not be up-to-date if a new country is created.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 0.1.0.5