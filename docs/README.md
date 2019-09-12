# User Guide

## Features 

### Feature 1 - Tasks 
Add ToDos, Events and Deadlines for Duke to remember them for you

### Feature 2 - Realistic Deadlines
Add dates to events and deadlines to remind yourself when stuff happens or expires

### Feature 3 - Error Prevention
Multiple failsafe in place to ensure that you will not confuse Duke with your commands 

### Feature 4 - Tagging
Tags a task with your favourite hashtag 

## Usage

### todo - Add ToDo for Duke

Adds a ToDo into Duke which it will store for you

#### Example of usage:

`todo (description of todo)`

#### Expected outcome:
```
Got it. I've added this task:
    [T][X] (description of todo) 
Now you have (xxx) tasks in the list.
```

### event/deadline - Add events or deadlines for Duke

Adds an event or deadline into Duke which it will store for you.

#### Example of usage:

For adding events:

``
event (description of event) /at (date of event)
``

For adding deadlines:

``
deadline (description of deadline) /by (date of deadline)
``

`date of event` is in the format `DD/MM/YYYY HHmm`

#### Expected outcome:
```
Got it. I've added this task:
    [T][X] (description) (date)
Now you have (xxx) tasks in the list.
```

### done - Completes a task in your list

Informs duke that you have completed a task in your list

#### Example of usage:

``
done (task number)
``

#### Expected outcome:
```
Nice! I've marked this task as done:
    (Task that was marked as done)
```

### delete - Deletes a task from your list

Completely eradicates a task from your list and duke will forget it for you

#### Example of usage:

``
delete (task number)
``

#### Expected outcome:
```
Noted. I've removed this task:
    (Task that was marked as done)
Now you have (xxx) tasks in the list.
```

### find - Finds a task by description

Asks duke to help you find a task with your entered description

#### Example of usage:

``
find (querying description)
``

#### Expected outcome:
```
Here are the matching tasks in your list:
    (All tasks that was found...)
```

### list - Lists out all the task that you have

Lists out all the tasks that you have in the list

#### Example of usage:

``
list
``

#### Expected outcome:
```
Here are the tasks in your list:
    (All tasks in your list...)
```

### tag - Tags a task with \#

Gives a tasks a hashtag

#### Example of usage:

``
tag (task number) /as (tag name without #)
``

#### Expected outcome:
```
Noted. I've tagged task (task number) as (tag name)
    (tagged task)
```

### bye - Exits the applcation

Leaves the duke application

#### Example of usage:

``
bye
``

#### Expected outcome:
```
Application exits
```

