# USE CASE: 1 Produce a Report on all the countries and capitals in the world, continent and region organised by largest population to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

As a statistician, I want to produce a report that shows all the countries and capitals in the world, continent and region organised by largest population to smallest so I can present this data to the stakeholders.

### Scope

Company.

### Level

Primary task.

### Preconditions

Database contains countries and capitals population data.

### Success End Condition

A report is available for statistician to provide to stakeholder.

### Failed End Condition

No report is produced.

### Primary Actor

Statistician.

### Trigger

A request for population information is sent to statistician.

## MAIN SUCCESS SCENARIO

1. Stakeholder request population information for the countries and capitals in the world, continent and region, ascending.
2. Statistician creating connection to given database.
3. Statistician captures information of the countries and capitals in the world, continent and region ascending to get population information for.
4. Statistician extracts population information of the countries and capitals in the world, continent and region ascending.
5. Statistician provides report to stakeholder.

## EXTENSIONS

3. **Data is missing**:
    1. Statistician informs stakeholder that data is missing.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0