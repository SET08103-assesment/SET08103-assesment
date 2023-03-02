# USE CASE: 4 Produce a population report on the population information.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a statistician, I want to produce a report that shows various population data so I can present this data in the stakeholder meeting.

### Scope

Company.

### Level

Primary task.

### Preconditions

The database contains population data.

### Success End Condition

A report is available for statistician for the next meeting with the stakeholder.

### Failed End Condition

No report is produced.

### Primary Actor

Statistician.

### Trigger

A request for population information data available for the next meeting is sent to statistician.

## MAIN SUCCESS SCENARIO

1. The stakeholder have requested comprehensive reports and analyse on population data.
2. The statistician accesses the required data using the provided SQL database as a starting point.
3. The statistician collects and captures population information, including data on demographics, trends, and projections.
4. The statistician uses the system to extract population data and other relevant information for the required data.
5. The statistician generates a report for the stakeholder containing the requested information.

## EXTENSIONS

3. **Data is missing**:
 1. The statistician identifies that some data required for the report is missing from the database.
 2. The statistician informs the stakeholder of the missing data and proposes potential solutions, such as obtaining the missing data from other sources or modifying the report to exclude the missing data.
 3. The stakeholder evaluate the proposed solutions and decide on the best course of action.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0