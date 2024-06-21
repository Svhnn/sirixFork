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

![General Coverage SS](https://github.com/Svhnn/sirixFork/tree/main/images/general-coverage-ss.png)

![In Depth Coverage SS](https://github.com/Svhnn/sirixFork/tree/main/images/in-depth-coverage-ss.png)

### Your own coverage tool

Group member 1: Sven <br/>
Function 1: getBytes

https://github.com/sirixdb/sirix/commit/6e3f7603fe00d56dc8400d887cb0349e4c9619a2 <br/>
https://github.com/sirixdb/sirix/commit/49243c156d3480a46da1a6abc4e5cb0a349df6a1
I did all of the cover measurements and the tests in the same commit and for some reason they got split into two commits,
so both of the commits above contain the entirety of the changed function, plus tests.

<Provide a screenshot of the coverage results output by the instrumentation>

![getBytes Coverage SS](https://github.com/Svhnn/sirixFork/tree/main/images/getBytes-coverage-result.png)

Function 2: ToInt <br/>



## Coverage improvement

### Individual tests

<The following is supposed to be repeated for each group member>

[//]: # (<Group member name>)

<Test 1>

<Show a patch (diff) or a link to a commit made in your forked repository that shows the new/enhanced test>
https://github.com/sirixdb/sirix/commit/6e3f7603fe00d56dc8400d887cb0349e4c9619a2
https://github.com/sirixdb/sirix/commit/49243c156d3480a46da1a6abc4e5cb0a349df6a1
These are the same commits as shared above, since I mentioned that I did both the tests and the measurements at once.

<Provide a screenshot of the old coverage results (the same as you already showed above)>
![General Coverage SS](https://github.com/Svhnn/sirixFork/tree/main/images/general-coverage-ss.png) <br/>
<Provide a screenshot of the new coverage results>
![In Depth Coverage SS](https://github.com/Svhnn/sirixFork/tree/main/images/in-depth-coverage-ss.png)

[//]: # (<State the coverage improvement with a number and elaborate on why the coverage is improved>)

<Test 2>

<Provide the same kind of information provided for Test 1>

### Overall

<Provide a screenshot of the old coverage results by running an existing tool (the same as you already showed above)>

[//]: # (<Provide a screenshot of the new coverage results by running the existing tool using all test modifications made by the group>)

## Statement of individual contributions

[//]: # (<Write what each group member did>)

