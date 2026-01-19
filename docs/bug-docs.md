## Problem with finding the table of connected DB
Error -> Java created a new empty DB with the same name in what it considered the working path (?) since the one created in SQLite studio was linked to a general 'NetBeansProjects' folder

Solution -> Explicitly set the working path of the project to the one linked in SQLite studio, both point twds the direct path

## Problem with grayed out local branches
Solution -> Select 'Enable destructive actions'

## Don't know how to create a byte stream to go from File -> BLOB
Solution -> Need PREPARED STATEMENTS to handle BLOB data (mandatory)
-> Convert file directly to byte using readAllBytes()
-> Set the blob data as the byte file w/ the prepared statement


## Problems with a file that wouldn't clean and build
Solution -> Check for test files, make sure they are named test and not anything else, check project files are in project tab and not file tab, move src file if needed - if this all fails copy code that you need and delete file as it is currupted. Re - clone file with Team - Git - Clone and link to repistory again

## Problem with some Database Query Logic 
- Need to enforce unique book name & author to check for duplicates in Books table instead of a risky manual method 

## Problem with passing ResultSet of databases into windows
- After implementing try-with-resources to close the ResultSet and the Statement used for the request, the other windows couldnt reference the ResultSet any longer.
- > Solution: Created a class to represent the rows for a result set  & set the attributes as the column types 

## Problem with admin button configurations in Announcements after previous login/logout
- Track how user is being updated using debug features
-> Problem: Was creating a new window each time when the user clicks 'Log Out', passing in a new DB operator instead of the one the other windows were referencing. The announcement window and the login window were not referencing the same user, giving the wrong boolean values for checking user type in roleCheck()
-> Solution: Added conditional logic to check whether to show or to create the next window
