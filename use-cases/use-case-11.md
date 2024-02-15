# USE CASE: 4 Produce a Report on all the cities in a distric sorted by largest to smallest population

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *User* I want *Produce a Report on all the cities in a distric sorted by largest to smallest population*

### Scope

Organisation.

### Level

Primary task.

### Preconditions

We know the district.  Database contains current city population data.

### Success End Condition

A report is available for user.

### Failed End Condition

No report is produced.

### Primary Actor

Users.

### Trigger

A user requests cities information.

## MAIN SUCCESS SCENARIO

1. A user requests cities information
2. Requested data is in database
4. Data is presented to the user

## EXTENSIONS

3. **Data or District does not exist**:
    1. The program informs the user that no data exists for the specified district.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 0.1.0.4
