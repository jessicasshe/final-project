## Problem with finding the table of connected DB
Error -> Java created a new empty DB with the same name in what it considered the working path (?) since the one created in SQLite studio was linked to a general 'NetBeansProjects' folder

Solution -> Explicitly set the working path of the project to the one linked in SQLite studio, both point twds the direct path

## Problem with grayed out local branches
Solution -> Select 'Enable destructive actions'

## Don't know how to create a byte stream to go from File -> BLOB
Solution -> Need PREPARED STATEMENTS to handle BLOB data (mandatory)

## Problems with a file that wouldn't clean and build
Solution -> Check for test files, make sure they are named test and not anything else, check project files are in project tab and not file tab, move src file if needed - if this all fails copy code that you need and delete file as it is currupted. Re - clone file with Team - Git - Clone and link to repistory again

