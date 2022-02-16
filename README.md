# Homework Project 1
## Part A
&nbsp;&nbsp;&nbsp;&nbsp;Do all of problem 3.13 (Employee Class) from the text, including the main, as written.   Inside the Employee class, use accessors and mutators whenever possible (so you should only be using the instance variables inside the accessors and mutators themselves).
### 3.14 (Employee Class)
&nbsp;&nbsp;&nbsp;&nbsp;Create a class called Employee that includes three instance variables—a first name (type String), a last name (type String) and a monthly salary (double). Provide a constructor that initializes the three instance variables. Provide a set and a get method for each instance variable. If the monthly salary is not positive, do not set its value. Write a test application named EmployeeTest that demonstrates class Employee’s capabilities. Create two Employee objects and display each object’s yearly salary. Then give each Employee a 10% raise and display each Employee’s yearly salary again.
## Part B
&nbsp;&nbsp;&nbsp;&nbsp;Now, suppose a new company policy says that instead of the monthly salary we will now store the yearly salary.  We will need to make this change inside Employee and support the new usage, without breaking existing code (such as the old main) that relies on the old version.  
&nbsp;&nbsp;&nbsp;&nbsp;Add an instance variable for yearly salary (with accessor and mutator).  
&nbsp;&nbsp;&nbsp;&nbsp;Remove the monthly salary instance variable from Employee.  If you wrote part A always going through accessors and mutators, this should break very little.  
&nbsp;&nbsp;&nbsp;&nbsp;Change the existing public accessor and mutator for the monthly salary so that they will still work as originally expected, that is, the existing main method, unchanged, will have the same results it did when you ran it for part A, but inside Employee we are using the new instance variable. We should also be able to write new code using Employee that works with yearly salaries directly.  
&nbsp;&nbsp;&nbsp;&nbsp;Think this through.  If someone does setYearlySalary(50000) what would they expect to happen if then then print getMonthlySalary()?  If someone does setMonthlySalary(1000) what would they expect to happen if they then print(getYearlySalary)?  Does your code do this?  
&nbsp;&nbsp;&nbsp;&nbsp;Add a new class with a main, NewEmployeeHarness, and test the additions to Employee.
## Part C
&nbsp;&nbsp;&nbsp;&nbsp;To the Employee class, add instance variables to store a percentage to save to a retirement account, and an age, and ensure that these cannot be set to unreasonable values.  
&nbsp;&nbsp;&nbsp;&nbsp;Add a method payday.  Assume that employees are paid twice a month.  You will report how much is being paid out directly and how much is being put in their retirement account.  
&nbsp;&nbsp;&nbsp;&nbsp;For the retirement account, the company will match contributions up to $100.  Employees up to age 60 can put in up to $300 total (including company match) per pay period, while employees 60 and over can contribute up to $500.  
&nbsp;&nbsp;&nbsp;&nbsp;So if an employee contributes a percentage that came out to $50, the employer would match it and a total of $100 would go to the retirement account.  If an employee aged 47 put in $280, the employer would match, but only $20 to reach the $300 limit.  If an employee aged 61 tried to contribute $510, only the $500 would go into retirement, the extra would be put back into the paycheck (in this case the company did not contribute).  Think through how to figure out the final numbers and report them. (remember: never mess up your instance variables just to do a calculation, local variables are free!)
## Part D
In a main (separate from previous mains) create a menu
- `0. Quit`
- `1. Create Employee`

If they create an employee
- `0. Return to main menu`
- `1. Set salary (monthly format)`
- `2. Set salary (yearly format)`
- `3. Set age`
- `4. Preview Payday Statement`
- `5. Retirement Help`

If they choose retirement help
- `0. Return to previous menu`
- `1. Set Retirement Percentage`
- `2. View Retirement Scenarios`

&nbsp;&nbsp;&nbsp;&nbsp;If they choose retirement scenarios, you will run three scenarios: 0% retirement contribution, 10% retirement contribution, and whatever their actual % retirement contribution is.  For each, show what their total take-home and total retirement contribution would be for a full year, then, assuming they do the same from their current age to age 65, and earn 2% on their retirement investment account each year, what their total retirement amount would be after age 65.  
&nbsp;&nbsp;&nbsp;&nbsp;For the menu, any time you are accepting a value, loop until you are given something valid (this should happen before it goes into a mutator, which is the last line of defense).  
&nbsp;&nbsp;&nbsp;&nbsp;Note that to support part D, you may find you need to adjust what you did in part C to break it into smaller methods that return individual values. Remember that a good guideline is that you don't want to have the same code in two places.