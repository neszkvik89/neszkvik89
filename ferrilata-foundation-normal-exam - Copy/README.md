# Ferrilata Foundation Normal Exam

## Getting Started

- Fork this repository under your own account
- Clone the forked repository to your computer
- Create a `.gitignore` file so generated files won't be committed
- Commit your progress frequently and with descriptive commit messages
- All your answers and solutions should go in this repository

## Keep in mind

- You can use any resource online, but **please work individually**
- **Don't just copy-paste** your answers and solutions, use your own words instead
- **Don't push your work** to GitHub until your mentor announces that the time is up

## Exercises

### Multiply items in a matrix

Write a method that takes a matrix as a parameter.

The function should:

- multiply each even number by 2 in each even indexed row
- multiply each odd number by 2 in each odd indexed row

Write at least 2 different test cases.

#### Example

Input

```
[
  [1, 3, 6, 2],
  [7, 5, 6, 1],
  [3, 3, 1, 5],
  [9, 0, 5, 3]
]
```

Output

```
[
  [1,  3,  12, 4],
  [14, 10, 6,  2],
  [3,  3,  1,  5],
  [18, 0,  10, 6]
]
```

### Most rainy days

Write a method which can read and parse a file containing information about
weather in various cities. The method must return the name of the city which
had the most rainy days.

#### Example

[Example file can be found here.](./cities.csv)

Output

```
Gyor
```
### Restaurant

Your task is to create a program to model the every day life in a restaurant.

#### Restaurant

- Every restaurant has a `name`, the year it was `founded` and a list of `employees` who are working there.
- It should have a method `guests arrived` which should instruct all employees to `work`
- We should be able to `hire` an employee which will add it to the list of `employees`

#### Employee

- Every employee has a `name`, an `experience` (number) and a method `work`
- The `experience` should start from `0` by default if it is not provided
- Every employee should be able to `work`, however the specific behavior is different for every kind

**We cannot hire or create basic employee** because they should always be some kind of specific employee like `Chef`, `Manager` or `Waiter`.

##### Waiter 

- It should store the amount of `tips` it has - in the beginning this is `0`
- Whenever it is instructed to `work`:
  - It should increase the amount of `tips` by `1`
  - It should increase its `experience` by `1`

##### Chef

- It should store information about the `meals` it ever cooked (name of the food + amount of times it was cooked)
- Whenever it is instructed to `work`:
  - It should increase its `experience` by `1`
- It should have a `cook` behavior
  - This should get the `name of the food` as an input
  - This should update the `meals` information so we are able to track that it cooked this specific food again

##### Manager

- It should have a `moodLevel` - in the beginning this is `400`
- Whenever it is instructed to `work`:
  - It should increase the `experience` by `1`
  - It should invoke its `have a meeting` behaviour
- Whenever `have a meeting` is invoked, the `moodLevel` should decrease by the managers `experience`

## Questions

### What is a unit test? What are different test cases?
Unit testing is performed on the small, individual units, such as the methods, interfaces, etc.
The purpose of unit-testing is to determine if the tested unit works as expected without errors, etc.
Different test cases are used to test different scenarios, attributes of the method. Examples are Functionality, Security,
Performance, etc.

### What is the difference between runtime and compile time error? Write 1-1 example.
A compile time error prevents the program to be successfully compiling. It could be caused by syntax error or missing
file references, mixing incompatible data types, etc.
Runtime error happens WHILE the program is already running. Possible causes: division by 0, trying to access a
non-existent file, null-pointer exception, index out of bounds exception, etc.
