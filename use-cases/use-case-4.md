# USE CASE: Creating report of N largest countries in the world

## CHARACTERISTIC INFORMATION

### Goal in Context

As an organization user, I want to be able to generate a list of N largest populated countries in the world where N is provided by the user

### Scope

Organization.

### Level

Primary task.

### Preconditions

We have a database with all the countries in the world and their populations

### Success End Condition

A report is available for the user with N lagest populated countries in the world where N was provided by the user.

### Failed End Condition

No report is produced.

### Primary Actor

Organization User

### Trigger

Someone wants to know census data on every country in the world.

## MAIN SUCCESS SCENARIO

1. Organization user wants to generate list of N countries in the world by largest population
2. User extracts a list of N largest populated countries in the world where the user provided N

## EXTENSIONS

3. **Database contain all countries**:
    1. Database might not be up-to-date if a new country is created.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 0.1.0.6