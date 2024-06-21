# Report for Assignment 1

## Project chosen

Name: Sirix

URL: https://github.com/sirixdb/sirix/tree/main

Number of lines of code and the tool used to count it: <br/>
Total Lines: 190459 <br/>
Source Code Lines: 107800 <br/>
Disclaimer: Lines should be a bit less than this, since they were counted after we already improved 2 functions, <br/>
but it shouldn't matter since the requirement is well over 10k in either case. <br/>
Tool used: Statistics plugin in IntelliJ <br/>

Programming language: Java <br/>

## Coverage measurement

### Existing tool

There isn't a clear name of the existing tool, it's built into the IntelliJ text editor.
You can either run tests normally, debug them, or run them with coverage, which is what we did.

Existing Tool Coverage Image: <br/>

<img src="images/general-coverage-ss.png" width="600" />

### Your own coverage tool

**_Group member 1:_** Sven <br/>
**Function 1**: getBytes

Commits: <br/>
https://github.com/sirixdb/sirix/commit/6e3f7603fe00d56dc8400d887cb0349e4c9619a2 <br/>
https://github.com/sirixdb/sirix/commit/49243c156d3480a46da1a6abc4e5cb0a349df6a1 <br/>
I did all of the cover measurements and the tests in the same commit and for some reason they got split into two commits,
so both of the commits above contain the entirety of the changed function, plus tests.

Screenshot of coverage result by output: <br/>
<img src="images/getBytes-coverage-output.png" width="400" />

**Function 2**: ToInt <br/>

Commits: <br/>
https://github.com/sirixdb/sirix/commit/e48b78d9065111d31efaac3b6220715ab03b9ecf

Screenshot of coverage result by output: <br/>
<img src="images/ToInt-coverage-output.png" width="400" />


## Coverage improvement

### Individual tests

**_Group member 1:_** Sven <br/>
**Test 1**:

Commits: <br/>
https://github.com/sirixdb/sirix/commit/6e3f7603fe00d56dc8400d887cb0349e4c9619a2 <br/>
https://github.com/sirixdb/sirix/commit/49243c156d3480a46da1a6abc4e5cb0a349df6a1 <br/>
These are the same commits as shared above, since I mentioned that I did both the tests and the measurements at once.

Old coverage report: <br/>
<img src="images/general-coverage-ss.png" width="600" /> <br/>

New coverage report: <br/>
<img src="images/getBytes-coverage-after.png" width="600" /> <br/>

Coverage improvement: 2, by 10%. The reason the coverage has been improved, is because tests have been made to check the
possible inputs for the function. Assertions have been made with a true and a false input, and they're being ran. This
makes the coverage go up because both branches are now being checked. We in total have 2 branches, the if - else which
means that if it's being checked properly, the coverage goes up by 2.

**Test 2**

Commits: <br/>
https://github.com/sirixdb/sirix/commit/e48b78d9065111d31efaac3b6220715ab03b9ecf <br/>

Old coverage report: <br/>
<img src="images/general-coverage-ss.png" width="600" /> <br/>

New coverage report: <br/>
<img src="images/ToInt-coverage-after.png" width="600" /> <br/>

Coverage improvement: 6, by 6%. The reason the coverage has been improved, is because now all the if statements are 
being checked. Assertions are being made to check the input that variates with each different length input for the 
function. The coverage going up by 6 makes sense, because there's 3 if statements, each accounting for 2 branches since
some of them don't necessarily have an else, except for the last statement. So twice the if statements which have an
invisible else so 2 x 2 plus the final if + else statements is 4 + 2 = 6.

### Overall

Old coverage report: <br/>
<img src="images/general-coverage-ss.png" width="600" /> <br/>

New coverage report: <br/>
INSERT SS OF NEW COVERAGE WITH ALL TEST MODIFICATIONS FROM THE GROUP DON'T FORGET.

## Statement of individual contributions

What each group member did. <br/>
Group member 1, Sven: <br/>
Looked for a project, tried different python projects that didn't work due to library issues. Settled on finding a java
project, this one. Figured out the general coverage report and checked the number of lines. Updated the forms with
our group name and nloc. Updated the getBytes function by using a separate GetBytesCoverage file in which there's a
hashmap that contains booleans to check each branch hit. Then made a BranchCoverageGetBytesTest file inside the test
folder to be able to print out the measurements and be able to update the coverage. This has two assertions which
are checking whether the true and false inputs are being covered correctly inside of the getBytes function. Then 
calculates the total amount of branch coverage by taking the number of hits and inputs. Did essentially the same for
the toInt function, the only difference here is that there's 4 different branches, 3 ifs and one else, made the same
type of files for toInt as for getByte but with different names. Checked the length and output correspondence with
4 assertions with different inputs. Also did all of the general README information. <br/>



